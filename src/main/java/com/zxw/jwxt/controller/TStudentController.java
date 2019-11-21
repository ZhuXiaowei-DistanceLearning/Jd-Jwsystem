package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.common.pojo.RS;
import com.zxw.common.pojo.TableReponse;
import com.zxw.common.utils.E3Result;
import com.zxw.common.utils.XssfUtils;
import com.zxw.jwxt.domain.TStudent;
import com.zxw.jwxt.service.StudentService;
import com.zxw.jwxt.vo.BaseQueryParam;
import com.zxw.jwxt.vo.QueryStudentVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zxw.jwxt.controller.BaseController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/student")
public class TStudentController extends BaseController {
    @Autowired
    private StudentService studentService;

    /**
     * 导出学生信息模板模板
     */
    @GetMapping("/exportXlsModel")
    public void ExportXlsModel(HttpServletResponse response, HttpServletRequest request) throws Exception {
        XssfUtils xfu = new XssfUtils();
        xfu.ExportXlsModel(request, response);
    }

    /**
     * 导出该班级的学生表格
     *
     * @param response
     * @param request
     * @param queryStudentVO
     * @throws Exception
     */
    @GetMapping("/exportXlsStudent")
    public void ExportXlsStudent(HttpServletResponse response, HttpServletRequest request,QueryStudentVO queryStudentVO)
            throws Exception {
        studentService.exportXlsStudent(response, request, queryStudentVO);
    }

    /**
     * 导入学生信息
     *
     * @param myFile
     * @param queryStudentVO
     * @return
     * @throws Exception
     */
    @PostMapping("/importXlsStudent")
    public RS ImportXlsStudent(@RequestParam("myFile") MultipartFile myFile, QueryStudentVO queryStudentVO) throws Exception {
//        String flag = studentService.importXlsStudent(myFile, cid, response);
//        return flag;
        return null;
    }

    /**
     * 查询出学生列表
     *
     * @param queryStudentVO
     * @return
     * @throws IOException
     */
    @GetMapping("/pageQuery")
    public TableReponse pageQuery(QueryStudentVO queryStudentVO) throws IOException {
        IPage result = studentService.pageQuery(queryStudentVO);
        TableReponse reponse = TableReponse.of(result);
        return reponse;
    }

    /**
     * 查询该班级的所有学生
     *
     * @param queryStudentVO
     * @return
     */
    @GetMapping("/findStudentByclass")
    public TableReponse findStudentByclass(QueryStudentVO queryStudentVO) {
        IPage result = studentService.findStudentByclass(queryStudentVO);
        TableReponse reponse = TableReponse.of(result);
        return reponse;
    }

    /**
     * 添加学生缺勤
     *
     * @param queryStudentVO
     * @return
     */
    @PostMapping("/addStudentAbsent")
    public RS addAbsent(QueryStudentVO queryStudentVO) {
        RS rs = studentService.addStudentAbenst(queryStudentVO);
        return rs;
    }

    /**
     * 查询个人成绩
     *
     * @param request
     * @return
     */
    @GetMapping("/PersonScorePage")
    public String PersonScorePage(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        TStudent student = (TStudent) subject.getPrincipal();
        request.setAttribute("PersonStudent", student);
        return "/student/PersonScore";
    }
}
