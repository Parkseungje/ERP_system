import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import kr.happyjob.study.common.excel.ExcelStyleHelper;
import kr.happyjob.study.common.excel.model.ExcelCellStyleModel;


/**
 * @author User
 *
 */
@SuppressWarnings("deprecation")
public class ExcelReport {
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		String[] arrListTitle = {"NO","구분/환자명","차트번호","내용","규격(단계)","arch","공급가격","의뢰일","요청일","배송일","비고"};
		String[][] arrListData = {
				{"1","이규인","20170921003","장치제작","5-10","12","396,000","2017-11-29","2017-12-06","12/6일(택)",""},
				{"2","김기정","20171124002","정밀진단","","1","-100,000","2017-12-06","2017-12-06","12/6일(직)","장치제작 시 정밀진단비 제외"},
				{"2","김기정","20171124002","장치제작","5-10","12","396,000","2017-12-06","2017-12-06","12/6일(직)",""}
		};
		
		try {
			
			/**
			 *  엑셀 워크북 및 시트 생성
			 **/
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("12월 거래명세서-클리어치과");
			
			/**
			 * cell 스타일 생성
			 **/
			ExcelStyleHelper styleHelper = new ExcelStyleHelper();
			ExcelCellStyleModel cellStyleModel = new ExcelCellStyleModel();
			
			// 서브 타이틀 스타일 설정
			cellStyleModel.setFontHeight((short)(16*20));
			cellStyleModel.setFontBlod(true);
			cellStyleModel.setCellAlignment(HSSFCellStyle.ALIGN_LEFT);
			HSSFCellStyle cellStyleSubTitle = styleHelper.getCellStyleSubTitle(workbook, cellStyleModel);
			
			cellStyleModel.setFontHeight((short)(10*20));
			cellStyleModel.setFontBlod(false);
			cellStyleModel.setCellAlignment(HSSFCellStyle.ALIGN_RIGHT);
			cellStyleModel.setCellVerticalAlignment(HSSFCellStyle.VERTICAL_BOTTOM);
			HSSFCellStyle cellStyleSubTitleCmnt = styleHelper.getCellStyleSubTitle(workbook, cellStyleModel);
			
			// 리스트 타이틀 스타일 설정
			cellStyleModel.setFontHeight((short)(11*20));
			cellStyleModel.setFontBlod(true);
			cellStyleModel.setCellAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyleModel.setCellVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			cellStyleModel.setCellFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			HSSFCellStyle cellStyleListTitle = styleHelper.getCellStyle(workbook, cellStyleModel);
			
			// 리스트 데이터 스타일 설정 - 일반
			cellStyleModel.setFontHeight((short)(11*20));
			cellStyleModel.setFontBlod(false);
			cellStyleModel.setCellAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyleModel.setCellVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			cellStyleModel.setCellFillForegroundColor(HSSFColor.WHITE.index);
			HSSFCellStyle cellStyleListData = styleHelper.getCellStyle(workbook, cellStyleModel);
			
			// 리스트 데이터 스타일 설정 - 공급가격(-)
			cellStyleModel.setFontHeight((short)(11*20));
			cellStyleModel.setFontBlod(false);
			cellStyleModel.setFontColor(Font.COLOR_RED);
			cellStyleModel.setCellAlignment(HSSFCellStyle.ALIGN_RIGHT);
			cellStyleModel.setCellVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			cellStyleModel.setCellFillForegroundColor(HSSFColor.WHITE.index);	
			HSSFCellStyle cellStyleListDataLR = styleHelper.getCellStyle(workbook, cellStyleModel);
			
			// 리스트 데이터 스타일 설정 - 공급가격(+)
			cellStyleModel.setFontHeight((short)(11*20));
			cellStyleModel.setFontBlod(false);
			cellStyleModel.setFontColor(Font.COLOR_NORMAL);
			cellStyleModel.setCellAlignment(HSSFCellStyle.ALIGN_RIGHT);
			cellStyleModel.setCellVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			cellStyleModel.setCellFillForegroundColor(HSSFColor.WHITE.index);	
			HSSFCellStyle cellStyleListDataLN = styleHelper.getCellStyle(workbook, cellStyleModel);
			
			// 리스트 데이터 스타일 설정 - 공급가격(+)
			cellStyleModel.setFontHeight((short)(11*20));
			cellStyleModel.setFontBlod(false);
			cellStyleModel.setFontColor(Font.COLOR_RED);
			cellStyleModel.setCellAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyleModel.setCellVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			cellStyleModel.setCellFillForegroundColor(HSSFColor.WHITE.index);	
			HSSFCellStyle cellStyleListDataCR = styleHelper.getCellStyle(workbook, cellStyleModel);
		
			
			/**
			 * 엑셀 데이터 생성
			 **/
			int rowCount = 0;
			HSSFRow row;
			HSSFCell cell;
			
			// 서브타이틀 ====================================================
			row = sheet.createRow(rowCount++);
			row.setHeight((short)(34*20));
			
			// cell 생성
			for (int i=0 ; i<=arrListTitle.length ; i++) {
				
				cell = row.createCell(i);
				
				if (i == 1) {
					cell.setCellStyle(cellStyleSubTitle);
					cell.setCellValue("12월 정밀진단 및 제작 현황_클리어치과");
				} else if (i == 11) {
					cell.setCellStyle(cellStyleSubTitleCmnt);
					cell.setCellValue("※ Arch당 적용 단가 : 33,000");
				}
			}

			
			// 리스트 타이틀 ==================================================
			row = sheet.createRow(rowCount++);
			row.setHeight((short)(25*20));
			
			for (int i=0 ; i<arrListTitle.length ; i++) {
				
				cell = row.createCell(i+1);
				cell.setCellStyle(cellStyleListTitle);
				cell.setCellValue(arrListTitle[i]);
			}
			
			// 리스트 데이터 ==================================================
			int endMrgPos = 0;
			int mrgCnt = 0;
			
			for (int i=0 ; i<arrListData.length ; i++) {
				 
				row = sheet.createRow(rowCount++);
				row.setHeight((short)(20*20));
				
				for(int j=0 ; j<arrListData[i].length ; j++) {
					
					cell = row.createCell(j+1);
					
					if (j == 6) {
						if ("정밀진단".equals(arrListData[i][3])) {
							cell.setCellStyle(cellStyleListDataLR);
						} else {
							cell.setCellStyle(cellStyleListDataLN);
						}
					} else if (j==9) {
						cell.setCellStyle(cellStyleListDataCR);
					} else {
						cell.setCellStyle(cellStyleListData);
					}
					
					cell.setCellValue(arrListData[i][j]);
				}
				
				if ((i > 0) && arrListData[i-1][0].equals(arrListData[i][0])) {
					endMrgPos = i+2;
					mrgCnt++;
				} else {
					if (endMrgPos != 0) {
	 					sheet.addMergedRegion(new CellRangeAddress((endMrgPos-mrgCnt),endMrgPos,1,1));
						sheet.addMergedRegion(new CellRangeAddress((endMrgPos-mrgCnt),endMrgPos,2,2));
						sheet.addMergedRegion(new CellRangeAddress((endMrgPos-mrgCnt),endMrgPos,3,3));
					}
					endMrgPos = 0;
					mrgCnt = 0;
				}
			}
			
			if (endMrgPos != 0) {
				sheet.addMergedRegion(new CellRangeAddress((endMrgPos-mrgCnt),endMrgPos,1,1));
				sheet.addMergedRegion(new CellRangeAddress((endMrgPos-mrgCnt),endMrgPos,2,2));
				sheet.addMergedRegion(new CellRangeAddress((endMrgPos-mrgCnt),endMrgPos,3,3));
			}
			
			//sheet.addMergedRegion(new CellRangeAddress(3,4,2,2));
			// st.addMergedRegion(new CellRangeAddress(
	        //             0, //시작 행번호
	        //            2, //마지막 행번호
	        //            2, //시작 열번호
	        //            4  //마지막 열번호
	        //    ));
			
			
			// 리스트 서머리 ==================================================
			row = sheet.createRow(rowCount++);
			row.setHeight((short)(25*20));
			
			for (int i=0 ; i<arrListTitle.length ; i++) {
				
				cell = row.createCell(i+1);
				cell.setCellStyle(cellStyleListData);
				
				if (i == 1) {
					cell.setCellValue("클리어치과 청구 합계");
				} else if(i == 10) {
					cell.setCellValue("부가세 포함");
				}
			}

			// 셀 병합
			sheet.addMergedRegion(new CellRangeAddress((rowCount-1),(rowCount-1),2,6));
			
			row = sheet.createRow(rowCount++);
			row.setHeight((short)(25*20));
			for (int i=0 ; i<arrListTitle.length ; i++) {
				
				cell = row.createCell(i+1);
				cell.setCellStyle(cellStyleListData);
				
				if (i == 3) {
					cell.setCellValue("정밀진단");
				} else if(i == 5 || i == 6) {
					cell.setCellValue("-");
				}
			}
			
			row = sheet.createRow(rowCount++);
			row.setHeight((short)(25*20));
			for (int i=0 ; i<arrListTitle.length ; i++) {
				
				cell = row.createCell(i+1);
				cell.setCellStyle(cellStyleListData);
				
				if (i == 3) {
					cell.setCellValue("모델/장치제작");
				} else if(i == 5) {
					cell.setCellValue((double)424);
				} else if(i == 6) {
					cell.setCellValue((double)13992000);
				}
			}

			row = sheet.createRow(rowCount++);
			row.setHeight((short)(25*20));
			for (int i=0 ; i<arrListTitle.length ; i++) {
				
				cell = row.createCell(i+1);
				cell.setCellStyle(cellStyleListData);
				
				if (i == 3) {
					cell.setCellValue("정밀진단(차감)");
				} else if(i == 5) {
					cell.setCellValue((double)0);
				} else if(i == 6) {
					cell.setCellValue((double)0);
				}
			}
			
			// 컬럼 Auto resize ==================================================
			for (int i=0 ; i<=arrListTitle.length ; i++) {
				sheet.autoSizeColumn(i);
				if (i == 0) { 
					sheet.setColumnWidth(i, (600));
				} if (i == 1) {
					sheet.setColumnWidth(i, (1500));
				} else {
					sheet.setColumnWidth(i, (sheet.getColumnWidth(i))+512);
				}
			}
			
			// 엑셀파일 기록 ==================================================
			workbook.write(new FileOutputStream("D:\\excel.xls"));

			workbook.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * List title에 대한 스타일을 리턴한다.
	 * @param wb
	 * @return
	 */
	public static HSSFCellStyle getStyleListTitleNormal(HSSFWorkbook wb) {
		HSSFFont font = wb.createFont();
		font.setFontName("맑은 고딕");
		font.setFontHeight((short)(11*20));
		font.setBold(true);
		
		HSSFCellStyle style = wb.createCellStyle();
		style.setFont(font);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		return style;
	}
	
	
	
	public static HSSFCellStyle getStyleListDataNormal(HSSFWorkbook wb) {
		HSSFFont font = wb.createFont();
		font.setFontName("맑은 고딕");
		font.setFontHeight((short)(11*20));
		font.setBold(false);
		
		HSSFCellStyle style = wb.createCellStyle();
		style.setFont(font);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		return style;
	}
	
	
}
