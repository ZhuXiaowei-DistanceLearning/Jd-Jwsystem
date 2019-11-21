package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.common.pojo.PageUtils;
import com.zxw.common.pojo.RS;
import com.zxw.common.utils.FileUtils;
import com.zxw.jwxt.domain.StudentRole;
import com.zxw.jwxt.domain.TStudent;
import com.zxw.jwxt.mapper.TStudentMapper;
import com.zxw.jwxt.vo.QueryStudentVO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class StudentService extends BaseService {

    @Autowired
    private TStudentMapper studentMapper;

    @Autowired
    private StudentRoleService studentRoleService;

    public TStudent findByUsername(QueryStudentVO queryStudentVO) {
//        TStudentExample studentExample = new TStudentExample();
//        JW.pojo.TStudentExample.Criteria studentCriteria = studentExample.createCriteria();
//        studentCriteria.andSidEqualTo(username);
//        List<TStudent> student = studentMapper.selectByExample(studentExample);
//        if (student.size() == 1) {
//            return student.get(0);
//        } else {
//            return null;
//        }
        return null;
    }

    /**
     * 找到课程中的学生名单
     */
    public IPage findStudentByclass(QueryStudentVO queryStudentVO) {
        Page page = getPage(queryStudentVO);
        IPage iPage = studentMapper.findAll(page, queryStudentVO.getCid());
        return iPage;
    }

    /**
     * 查询所有学生
     */
    public IPage pageQuery(QueryStudentVO queryStudentVO) {
        Page page = getPage(queryStudentVO);
        QueryWrapper wrapper = getWrapper(queryStudentVO);
        IPage iPage = studentMapper.selectPage(page, wrapper);
        return iPage;
    }

    /**
     * 添加缺勤学生名单
     */
    public RS addStudentAbenst(QueryStudentVO queryStudentVO) {
        List<TStudent> list = studentMapper.selectBatchIds(queryStudentVO.getStudentIds());
        if (list == null) {
            return RS.error("无法查询到相应数据");
        }
        List<Object> collect = list.stream().map(e -> {
            e.setAbsent(e.getAbsent() + 1);
            studentMapper.updateById(e);
            return e;
        }).collect(Collectors.toList());
        return RS.ok(collect);
    }

    /**
     * 模板化代码
     * 导入学生信息表格
     */
    public RS importXlsStudent(MultipartFile myFile, QueryStudentVO queryStudentVO) {
        // 创建
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(myFile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 左下角单元
        XSSFSheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            int rowNum = row.getRowNum();
            if (rowNum == 0) {
                continue;
            }
            XSSFCell cell = (XSSFCell) row.getCell(0);
            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
            String sid = cell.getStringCellValue();
            String sname = row.getCell(1).getStringCellValue();
            /**
             * 转换
             */
            XSSFCell cell2 = (XSSFCell) row.getCell(2);
            cell2.setCellType(XSSFCell.CELL_TYPE_STRING);
            String password = cell2.getStringCellValue();
            String sex = row.getCell(3).getStringCellValue();
            String scity = row.getCell(4).getStringCellValue();
            String roleId = "b762e0f84ec911e8bf5d34de1af4e65a";
            String qx = "学生";
            TStudent student = new TStudent();
            student.setUsername(sname);
            student.setScity(scity);
            student.setAbsent(0);
            student.setClassesId(queryStudentVO.getClassesId());
            student.setPassword(password);
            student.setQx(qx);
            student.setId(sid);
            student.setSex(sex);
            studentMapper.insert(student);
            StudentRole studentRole = new StudentRole();
            studentRole.setRoleId(roleId);
            studentRole.setStudentId(sid);
            RS srInsert = studentRoleService.insert(studentRole);
            if (srInsert.get("status").equals("0")) {
                return RS.error("导入失败");
            }
        }
        return RS.ok();
    }

    /**
     * 模板化代码
     */
    public void exportXlsStudent(HttpServletResponse response, HttpServletRequest request, QueryStudentVO queryStudentVO) throws IOException {
        Page page = getPage(queryStudentVO);
        Page<QueryStudentVO> list = studentMapper.findAll(page, queryStudentVO.getCid());
        // 在内存中创建一个Excel文件，通过输出流写到客户端提供下载
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 创建一个sheet页
        XSSFSheet sheet = workbook.createSheet(list.getRecords().get(0).getClasses().getClassname() + "学生信息");
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 居中
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        // 第一行表头
        XSSFRow headRow = sheet.createRow(0);
        headRow.createCell(0).setCellValue("学号");
        headRow.createCell(1).setCellValue("姓名");
        headRow.createCell(2).setCellValue("密码");
        headRow.createCell(3).setCellValue("性别");
        headRow.createCell(4).setCellValue("户籍");
        headRow.createCell(5).setCellValue("班级");
        String classname = list.getRecords().get(0).getClasses().getClassname();
        for (int i = 0; i < list.getRecords().size(); i++) {
            XSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            dataRow.createCell(0).setCellValue(list.getRecords().get(i).getSid());
            dataRow.createCell(1).setCellValue(list.getRecords().get(i).getUsername());
            dataRow.createCell(2).setCellValue(list.getRecords().get(i).getPassword());
            dataRow.createCell(3).setCellValue(list.getRecords().get(i).getSex());
            dataRow.createCell(4).setCellValue(list.getRecords().get(i).getScity());
            dataRow.createCell(5).setCellValue(classname);
        }
        String filename = list.getRecords().get(0).getClasses().getClassname() + "学生信息.xlsx";
        String agent = request.getHeader("User-Agent");
        filename = FileUtils.encodeDownloadFilename(filename, agent);
        // 一个流两个头
        ServletOutputStream out = response.getOutputStream();
        String contentType = request.getSession().getServletContext().getMimeType(filename);
        response.setContentType(contentType);
        response.setHeader("content-disposition", "attchment;filename=" + filename);
        workbook.write(out);
    }
}
