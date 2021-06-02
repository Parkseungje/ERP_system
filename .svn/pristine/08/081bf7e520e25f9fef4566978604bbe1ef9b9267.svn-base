package kr.happyjob.study.common.comnUtils;


import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.view.AbstractView;

public class ExcelDownloadView extends AbstractView {

	private static final String CONTENT_TYPE = "application/vnd.ms-excel";
	private static final String EXTENSION = ".xlsx";
	
	public ExcelDownloadView() {
		setContentType(CONTENT_TYPE);
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		downloadExcel(model, response);
	}
	

	@SuppressWarnings("unchecked")
	private void downloadExcel(Map<String, Object> model, HttpServletResponse response) throws IOException {
		
		String excelName = (String)model.get("excelName");				// 엑셀 파일명
		List<String> colName = (List<String>)model.get("colName");		// cell 자료 key
		List<Map<String, Object>> colValue = (List<Map<String, Object>>)model.get("colValue");	// cell 자료
		
		response.setHeader("Content-Disposition", "Attachment; Filename=" + excelName + EXTENSION);
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		String title = (String)model.get("title");				// 타이틀 명
		String fromDate = (String)model.get("fromDate");				
		String toDate = (String)model.get("toDate");	
		String dateInterval = fromDate!=null && toDate!=null ? ("(" + fromDate + " ~ " + toDate + ")") : "";
		XSSFSheet sheet = workbook.createSheet(title + dateInterval);
		
		// 셀 스타일
		XSSFCellStyle styleTitle = getTitleStyle(workbook);
		XSSFCellStyle styleHeader = getHeaderStyle(workbook);
		XSSFCellStyle styleStr = getStrStyle(workbook);
		XSSFCellStyle styleNum = getNumberStyle(workbook);
		XSSFCellStyle styleUpArrow = getUpArrowstyle(workbook);
		XSSFCellStyle styleDownArrow = getDownArrowStyle(workbook);
		
		// 병합처리 (머지할 시작셀:마지막셀, ex) A1:B1 또는 A1:A3
		List<String> mergeColName = (List<String>)model.get("mergeColName");
		int mgSize = mergeColName != null ? mergeColName.size() : 0;
		for (int i = 0; i < mgSize; i++) {
			sheet.addMergedRegion(CellRangeAddress.valueOf(mergeColName.get(i)));
		}
		
		// 헤더 생성
		Object obj = model.get("headerRows");
		int hdRows = obj == null ? 1 : ((Integer)obj).intValue();
		String titleKey = "titleName";
		for (int i = 0; i < hdRows; i++) {
			List<String> titleName = (List<String>)model.get(titleKey + (i+1));
			XSSFRow menuRow = sheet.createRow(i);
			for (int j = 0; j < titleName.size(); j++) {
				XSSFCell cell = menuRow.createCell(j);
				cell.setCellStyle(i==0 ? styleTitle : styleHeader);
				cell.setCellValue(titleName.get(j));
			}
		}
		
		// 내용 생성
		for (int i = 0; i < colValue.size(); i++) {
			// 상단 메뉴가 있기 때문에 + 해준다.
			XSSFRow row = sheet.createRow(i+hdRows);
			Map<String, Object> temp = colValue.get(i);
			for (int j = 0; j < colName.size(); j++) {
				Object val = temp.get(colName.get(j));
				XSSFCell cell = row.createCell(j);
				boolean isNumber = val!=null && val instanceof Integer;
				if (isNumber) {
					boolean isRatio = colName.get(j).toLowerCase().indexOf("ratio") > -1 ? true : false;
					//숫자 형식이여도 컬럼키가 ratio 포함되면 '94.12%' 형식으로 입력
					if(isRatio){
						String cellValue = isNull(String.valueOf(val), "");
						cell.setCellStyle(styleStr);
						cell.setCellValue(cellValue + "%");
					}else{
						cell.setCellStyle(styleNum);
						cell.setCellValue(((Integer)val).longValue());
					}
				}
				else {
					String cellValue = isNull(String.valueOf(val), "");
					XSSFCellStyle sty = styleStr;
					if ( cellValue.startsWith("▲") ) {
						sty = styleUpArrow;
					}
					else if ( cellValue.startsWith("▼") ) {
						sty = styleDownArrow;
					}
					cell.setCellStyle(sty);
					// 컬럼키가 ratio 포함되면 뒤에 '94.12%' 형식으로 입력
					cell.setCellValue(colName.get(j).toLowerCase().indexOf("ratio") > -1 ? cellValue+"%" : cellValue);
				}
			}
		}
		
		// 컬럼 컨텐츠 길이에 맞게 width 조절
		for(int i=0; i<colName.size(); i++){
			sheet.autoSizeColumn(i);
			sheet.setColumnWidth(i, (sheet.getColumnWidth(i))+2500 ); 
		}		
		
		ServletOutputStream out = response.getOutputStream();
		workbook.write(out);
		out.flush();
	}

	private XSSFCellStyle getDownArrowStyle(XSSFWorkbook workbook) {
		XSSFCellStyle styleUpArrow = workbook.createCellStyle();
		styleUpArrow.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		styleUpArrow.setBottomBorderColor(new XSSFColor(Color.BLACK));
		styleUpArrow.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		styleUpArrow.setLeftBorderColor(new XSSFColor(Color.GREEN));
		styleUpArrow.setBorderRight(XSSFCellStyle.BORDER_THIN);
		styleUpArrow.setRightBorderColor(new XSSFColor(Color.BLUE));
		styleUpArrow.setBorderTop(XSSFCellStyle.BORDER_THIN);
		styleUpArrow.setTopBorderColor(new XSSFColor(Color.BLACK));
		styleUpArrow.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		styleUpArrow.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		XSSFFont font = workbook.createFont();
		font.setColor(new XSSFColor(Color.BLUE));
		styleUpArrow.setFont(font);
		return styleUpArrow;
	}

	private XSSFCellStyle getUpArrowstyle(XSSFWorkbook workbook) {
		XSSFCellStyle styleUpArrow = workbook.createCellStyle();
		styleUpArrow.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		styleUpArrow.setBottomBorderColor(new XSSFColor(Color.BLACK));
		styleUpArrow.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		styleUpArrow.setLeftBorderColor(new XSSFColor(Color.GREEN));
		styleUpArrow.setBorderRight(XSSFCellStyle.BORDER_THIN);
		styleUpArrow.setRightBorderColor(new XSSFColor(Color.BLUE));
		styleUpArrow.setBorderTop(XSSFCellStyle.BORDER_THIN);
		styleUpArrow.setTopBorderColor(new XSSFColor(Color.BLACK));
		styleUpArrow.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		styleUpArrow.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		XSSFFont font = workbook.createFont();
		font.setColor(new XSSFColor(Color.RED));
		styleUpArrow.setFont(font);
		return styleUpArrow;
	}

	private XSSFCellStyle getNumberStyle(XSSFWorkbook workbook) {
		XSSFCellStyle styleNum = workbook.createCellStyle();
		XSSFDataFormat df = workbook.createDataFormat();
		styleNum.setDataFormat(df.getFormat("General"));
		styleNum.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		styleNum.setBottomBorderColor(new XSSFColor(Color.BLACK));
		styleNum.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		styleNum.setLeftBorderColor(new XSSFColor(Color.GREEN));
		styleNum.setBorderRight(XSSFCellStyle.BORDER_THIN);
		styleNum.setRightBorderColor(new XSSFColor(Color.BLUE));
		styleNum.setBorderTop(XSSFCellStyle.BORDER_THIN);
		styleNum.setTopBorderColor(new XSSFColor(Color.BLACK));
		styleNum.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
		return styleNum;
	}

	private XSSFCellStyle getStrStyle(XSSFWorkbook workbook) {
		XSSFCellStyle styleStr = workbook.createCellStyle();
		styleStr.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		styleStr.setBottomBorderColor(new XSSFColor(Color.BLACK));
		styleStr.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		styleStr.setLeftBorderColor(new XSSFColor(Color.GREEN));
		styleStr.setBorderRight(XSSFCellStyle.BORDER_THIN);
		styleStr.setRightBorderColor(new XSSFColor(Color.BLUE));
		styleStr.setBorderTop(XSSFCellStyle.BORDER_THIN);
		styleStr.setTopBorderColor(new XSSFColor(Color.BLACK));
		styleStr.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		styleStr.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		return styleStr;
	}

	private XSSFCellStyle getHeaderStyle(XSSFWorkbook workbook) {
		XSSFCellStyle styleHeader = workbook.createCellStyle();
		styleHeader.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		styleHeader.setBottomBorderColor(new XSSFColor(Color.BLACK));
		styleHeader.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		styleHeader.setLeftBorderColor(new XSSFColor(Color.GREEN));
		styleHeader.setBorderRight(XSSFCellStyle.BORDER_THIN);
		styleHeader.setRightBorderColor(new XSSFColor(Color.BLUE));
		styleHeader.setBorderTop(XSSFCellStyle.BORDER_THIN);
		styleHeader.setTopBorderColor(new XSSFColor(Color.BLACK));
		styleHeader.setFillBackgroundColor(new XSSFColor(Color.WHITE));
		styleHeader.setFillForegroundColor(new XSSFColor(new Color(Integer.parseInt("93ccea", 16))));
		styleHeader.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		styleHeader.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		styleHeader.setVerticalAlignment(XSSFCellStyle.ALIGN_FILL);
		return styleHeader;
	}

	private XSSFCellStyle getTitleStyle(XSSFWorkbook workbook) {
		XSSFCellStyle styleTitle = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(20);
		font.setBold(true);
		styleTitle.setFont(font);
		styleTitle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		styleTitle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		return styleTitle;
	}
	private String isNull(String param, String ref) {
		String result = param;
		if(param == null || "".equals(param)) result = ref;
		
		return result;
	}		
	
	/**
	 * 엑셀 데이터 다운로드 기본 템플릿
	 * 
	 * 사용 예)
	 	List<HashMap<String, Object>> statCatgDetail = knowledgeStatService.statCatgDetail(requestParams);
	 	
	 	ExcelDownloadParam param = new ExcelDownloadParam()
	 			.setExcelParams(excelParams)
	 			.setList(statCatgDetail)
	 			.setFilePrefix("knowledgeStatExcel")
	 			.setTitle("지식현황 통계")
	 			.setDate(requestParams.get("fromDate"), requestParams.get("toDate"))
	 			.setNames("카테고리","카테고리","질문","질문","질문","답변")
	 			.setExtraHeader("카테고리,카테고리,Training,Auto Training,기본지식(LSP),답변")
	 			.setCols("type","subType","questTrain","questML","questLsp","answer")
	 			.setSummaryRow("questTrain","questML","questLsp","answer")
	 			.addMidSum("type", "FAQ", new String[]{"type","subType"}, new String[]{"FAQ","소계"}) // 소계 추가
	 			.addTotalSum("subType", "소계", new String[]{"type","subType"}, new String[]{"합계",""}) // 합계 추가
	 			.setHeaderRowMerge("A2:B3,C2:E2,F2:F3") // 헤더 영역 머지
	 			.addDataRowVerticalMerge("type", "FAQ") // 데이터 영역 세로 머지
	 			.addDataRowHorizontalMerge(new String[]{"type","subType"}, "type", "FAQ"); // 데이터 영역 가로 머지
	 	
	 	ExcelDownloadView.template(param);
	 *
	 */
	public static void template(ExcelDownloadParam param) {
		
		List<String> headerRow = new ArrayList<String>();
		headerRow.add(param.title);
		
		List<String> headerRow2 = new ArrayList<String>();
		for(String colName : param.names) {
			headerRow2.add(colName);
		}
		
		int headerRowCnt = 2; // 제목 행 + 컬럼명 행 => 2 행
		
		if ( param.extraHeader != null ) {
			for(String each : param.extraHeader) {
				List<String> extraHeaderRow = new ArrayList<String>();
				for(String extraCol : each.split(",")) {
					extraHeaderRow.add(extraCol);
				}
				headerRowCnt += 1;
				param.excelParams.put("titleName"+headerRowCnt,   extraHeaderRow);
			}
		}
		
		// 셀 병합 설정
		List<String> mergeColRanges = new ArrayList<String>();
		String titleMerge = new CellRangeAddress(0,0, 0,param.names.length-1).formatAsString(); 
		mergeColRanges.add(titleMerge);
		if ( !param.headerRowMerge.isEmpty() ) {
			for( String each : param.headerRowMerge.split(",") ) {
				mergeColRanges.add(each);
			}
		}
		if ( !param.dataRowMerge.isEmpty() ) {
			for( String each : param.dataRowMerge.split(",") ) {
				mergeColRanges.add(each);
			}			
		}

		// 엑셀 데이터: 엑셀에 표시할 데이터의 컬럼 key 값 
		List<String> colNames = new ArrayList<String>();
		for(String col : param.cols) {
			colNames.add(col);
		}
		
		// 조회 기간을 지정한 경우 하단 시트명에 기간 표시
		if ( param.fromDate != null && param.toDate != null ) {
			param.excelParams.put("fromDate", param.fromDate);
			param.excelParams.put("toDate", param.toDate);
		}
		
		param.excelParams.put("title", param.title);
		param.excelParams.put("mergeColName", mergeColRanges);
		param.excelParams.put("headerRows",   headerRowCnt);
		param.excelParams.put("excelName",    param.filePrefix);
		param.excelParams.put("titleName1",   headerRow);
		param.excelParams.put("titleName2",   headerRow2);
		param.excelParams.put("colName",      colNames);
		param.excelParams.put("colValue",     param.list);
	}

	public static void template(ModelMap excelParams, List<HashMap<String, Object>> list, String filePrefix,
			String title, String[] names, String[] cols) {
		template(new ExcelDownloadParam(excelParams, list, filePrefix, title, names, cols));
	}	
	
}
