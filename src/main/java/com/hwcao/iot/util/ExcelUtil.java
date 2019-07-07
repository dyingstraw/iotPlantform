package com.hwcao.iot.util;

import org.apache.poi.hssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExcelUtil {
    public static void exportExcel(String sheetName, int columnWidth,
                                   List<List<String>> excelData,
                                   HttpServletResponse response,
                                   String fileName) throws IOException {
        //声明一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //声明一个表格，设置表格名称
        HSSFSheet sheet = workbook.createSheet(sheetName);
        //设置表格列宽
        sheet.setDefaultColumnWidth(columnWidth);

        //写入List<List<String>>中的数据
        int rowIndex = 0;
        for(List<String> data: excelData){
            //创建行
            HSSFRow row = sheet.createRow(rowIndex++);
            //本行添加数据
            for(int i=0;i<data.size();i++){
                //创建一个单元格
                HSSFCell cell = row.createCell(i);
                //创建一个内容对象
                HSSFRichTextString text = new HSSFRichTextString(data.get(i));
                //将内容写入单元格
                cell.setCellValue(text);
            }
        }
        //将Excel的输出流通过response输出到页面下载
        response.setContentType("application/octet-stream");

        //设置Excel名称
        response.setHeader("Content-disposition","attachment;filename=" + fileName);

        workbook.write(response.getOutputStream());
        //刷新缓冲
        response.flushBuffer();
        workbook.close();


    }
}
