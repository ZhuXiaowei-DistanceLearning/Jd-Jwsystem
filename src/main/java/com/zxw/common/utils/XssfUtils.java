package com.zxw.common.utils;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class XssfUtils {
    public void ExportXlsModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 在内存中创建一个Excel文件，通过输出流写到客户端提供下载
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 创建一个sheet页
        XSSFSheet sheet = workbook.createSheet("学生信息模板");
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
        headRow.createCell(4).setCellValue("手机");
        headRow.createCell(4).setCellValue("身份证");
        headRow.createCell(4).setCellValue("家庭住址");
        headRow.createCell(4).setCellValue("政治面貌");
        String filename = "学生信息模板.xlsx";
        String agent = request.getHeader("User-Agent");
        filename = FileUtils.encodeDownloadFilename(filename, agent);
        // 一个流两个头
        OutputStream out = response.getOutputStream();
        String contentType = request.getSession().getServletContext().getMimeType(filename);
//        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setContentType(contentType);
        response.setHeader("content-disposition", "attchment;filename=" + filename);
        workbook.write(out);
    }

    public void ExportXlsStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
    }

    public void ExportXlsStudent(List<?> list, HttpServletRequest request, HttpServletResponse response) {
    }

    /**
     * 导入学生信息
     */
    public void ImportXlsStudent() throws FileNotFoundException, IOException {
    }
}
