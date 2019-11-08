package com.zxw.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
		String filename = "学生信息模板.xlsx";
		String agent = request.getHeader("User-Agent");
		filename = FileUtils.encodeDownloadFilename(filename, agent);
		// 一个流两个头
		ServletOutputStream out = response.getOutputStream();
		String contentType = request.getSession().getServletContext().getMimeType(filename);
		response.setContentType(contentType);
		response.setHeader("content-disposition", "attchment;filename=" + filename);
		workbook.write(out);
	}

	public void ExportXlsStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		String filename = "学生信息模板.xlsx";
		String agent = request.getHeader("User-Agent");
		filename = FileUtils.encodeDownloadFilename(filename, agent);
		// 一个流两个头
		ServletOutputStream out = response.getOutputStream();
		String contentType = request.getSession().getServletContext().getMimeType(filename);
		response.setContentType(contentType);
		response.setHeader("content-disposition", "attchment;filename=" + filename);
		workbook.write(out);
	}

	public void ExportXlsStudent(List<?> list, HttpServletRequest request, HttpServletResponse response) {
		/*
		 * // 在内存中创建一个Excel文件，通过输出流写到客户端提供下载 XSSFWorkbook workbook = new
		 * XSSFWorkbook(); // 创建一个sheet页 XSSFSheet sheet =
		 * workbook.createSheet("晚夜班护理质量检查结果"); // 璁剧疆鍗曞厓鏍兼牱寮� XSSFCellStyle
		 * cellStyle = workbook.createCellStyle();
		 * cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);// 右边框
		 * cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN); // 下边框
		 * cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);// 左边框
		 * cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);// 上边框
		 * cellStyle.setWrapText(true);
		 * cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 居中
		 * cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER); //
		 * 设置单元格行宽 sheet.setColumnWidth(2, 10000); sheet.setColumnWidth(4,
		 * 10000); // 合并单元格 sheet.addMergedRegion(new CellRangeAddress(0, 1, 0,
		 * 0)); sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 2));
		 * sheet.addMergedRegion(new CellRangeAddress(0, 0, 3, 4)); if (list ==
		 * null) { // 第一行表头 XSSFRow headRow = sheet.createRow(0);
		 * headRow.createCell(0).setCellValue("姓名");
		 * headRow.createCell(1).setCellValue("性别");
		 * headRow.createCell(2).setCellValue("户籍");
		 * headRow.createCell(3).setCellValue("权限"); String filename =
		 * "学生信息模板.xlsx"; String agent = request.getHeader("User-Agent");
		 * filename = FileUtils.encodeDownloadFilename(filename, agent); //
		 * 一个流两个头 ServletOutputStream out = response.getOutputStream(); String
		 * contentType =
		 * request.getSession().getServletContext().getMimeType(filename);
		 * response.setContentType(contentType);
		 * response.setHeader("content-disposition", "attchment;filename=" +
		 * filename); workbook.write(out); } return workbook;
		 */
	}

	/**
	 * 导入学生信息
	 */
	public void ImportXlsStudent() throws FileNotFoundException, IOException {
	}
}
