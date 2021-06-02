package kr.happyjob.study.common.excel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

import kr.happyjob.study.common.excel.model.ExcelCellStyleModel;

public class ExcelStyleHelper {

	/**
	 * List title에 대한 스타일을 리턴한다.
	 * @param wb
	 * @return
	 */
	public HSSFCellStyle getCellStyleSubTitle(HSSFWorkbook wb, ExcelCellStyleModel model) {
		
		// Font 설정
		HSSFFont font = wb.createFont();
		font.setFontName(model.getFontName());
		font.setFontHeight(model.getFontHeight());
		font.setBold(model.getFontBlod());
		font.setColor(model.getFontColor());
		
		// Cell 스타일 설정
		HSSFCellStyle style = wb.createCellStyle();
		style.setFont(font);
		style.setAlignment(model.getCellAlignment());
		style.setVerticalAlignment(model.getCellVerticalAlignment());
		style.setFillForegroundColor(model.getCellFillForegroundColor());
		style.setFillPattern(model.getCellFillPattern());
		
		return style;
	}
	
	
	/**
	 * List title에 대한 스타일을 리턴한다.
	 * @param wb
	 * @return
	 */
	public HSSFCellStyle getStyleListTitle(HSSFWorkbook wb, ExcelCellStyleModel model) {
		
		// Font 설정
		HSSFFont font = wb.createFont();
		font.setFontName(model.getFontName());
		font.setFontHeight(model.getFontHeight());
		font.setBold(model.getFontBlod());
		font.setColor(model.getFontColor());
		
		// Cell 스타일 설정
		HSSFCellStyle style = wb.createCellStyle();
		style.setFont(font);
		style.setAlignment(model.getCellAlignment());
		style.setVerticalAlignment(model.getCellVerticalAlignment());
		style.setFillForegroundColor(model.getCellFillForegroundColor());
		style.setFillPattern(model.getCellFillPattern());
		style.setBorderBottom(model.getCellBorderBottom());
		style.setBorderTop(model.getCellBorderTop());
		style.setBorderLeft(model.getCellBorderLeft());
		style.setBorderRight(model.getCellBorderRight());
		
		return style;
	}
	
	
	/**
	 * List Data에 대한 스타일을 리턴한다.
	 * @param wb
	 * @return
	 */
	public HSSFCellStyle getStyleListData(HSSFWorkbook wb, ExcelCellStyleModel model) {
		
		// Font 설정
		HSSFFont font = wb.createFont();
		font.setFontName(model.getFontName());
		font.setFontHeight(model.getFontHeight());
		font.setBold(model.getFontBlod());
		font.setColor(model.getFontColor());
		
		// Cell 스타일 설정
		HSSFCellStyle style = wb.createCellStyle();
		style.setFont(font);
		style.setAlignment(model.getCellAlignment());
		style.setVerticalAlignment(model.getCellVerticalAlignment());
		style.setFillForegroundColor(model.getCellFillForegroundColor());
		style.setFillPattern(model.getCellFillPattern());
		style.setBorderBottom(model.getCellBorderBottom());
		style.setBorderTop(model.getCellBorderTop());
		style.setBorderLeft(model.getCellBorderLeft());
		style.setBorderRight(model.getCellBorderRight());
		
		return style;
	}
	
		
	
	
	/**
	 * Style 모델에 대한 Cell 스타일을 리턴한다.
	 * @param wb
	 * @return
	 */
	public HSSFCellStyle getCellStyle(HSSFWorkbook wb, ExcelCellStyleModel model) {
		
		// Font 설정
		HSSFFont font = wb.createFont();
		font.setFontName(model.getFontName());
		font.setFontHeight(model.getFontHeight());
		font.setBold(model.getFontBlod());
		font.setColor(model.getFontColor());
		
		// Cell 스타일 설정
		HSSFCellStyle style = wb.createCellStyle();
		style.setFont(font);
		style.setAlignment(model.getCellAlignment());
		style.setVerticalAlignment(model.getCellVerticalAlignment());
		style.setFillForegroundColor(model.getCellFillForegroundColor());
		style.setFillPattern(model.getCellFillPattern());
		style.setBorderBottom(model.getCellBorderBottom());
		style.setBorderTop(model.getCellBorderTop());
		style.setBorderLeft(model.getCellBorderLeft());
		style.setBorderRight(model.getCellBorderRight());
		
		return style;
	}
}
