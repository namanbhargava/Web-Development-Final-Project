package in.developersera.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;


public class ExcelSalesListReportView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setHeader("Content-disposition", "attachment; filename=\"books_list.xls\"");
		
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) model.get("newList");
		
		Sheet sheet = workbook.createSheet("Book List");
		
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("BookName");
		
		
		int rowNum = 1;
		for (String data : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(data);
			
		}
		
	}
}
	