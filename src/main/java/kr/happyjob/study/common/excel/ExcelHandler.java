package kr.happyjob.study.common.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import kr.happyjob.study.common.excel.exception.ExcelUserException;
import kr.happyjob.study.common.excel.model.ExcelCellStyleModel;

public class ExcelHandler {

	ExcelCellStyleModel m_excelParam = null;
	HSSFWorkbook m_workbook = null;
	HSSFSheet m_sheet = null;
	
	
	public ExcelHandler(ExcelCellStyleModel excelParam) {
		
		// 엑셀 워크북을 생성한다.
		HSSFWorkbook workbook = new HSSFWorkbook();
		this.m_excelParam = excelParam;
	}
	
	public void createSheet(String strSheetName) {
		
		if (strSheetName == null || "".equals(strSheetName)) strSheetName = "sheet1";
		m_sheet = m_workbook.createSheet(strSheetName);
	}
	
	
	public void createRowCell() throws ExcelUserException {
		
		if (m_sheet == null) throw new ExcelUserException("작업 가능한 sheet가 없습니다.");

	}

}
