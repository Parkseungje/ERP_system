package kr.happyjob.study.common.comnUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.ui.ModelMap;

public class ExcelDownloadParam {
	
	public ModelMap excelParams; //  컨트롤러 파라미터로 정의된 ModelMap 으로 세팅
	public List<HashMap<String, Object>> list; // 출력할 대상 목록
	public String filePrefix; // 파일명 앞에 붙을 문구 ( 파일명은 filePrefix + "YYYYMMDD".xlsx )
	public String title; // 엑셀 상단 타이틀 문구
	public String[] names; // 컬럼 명칭 목록
	public String[] cols; // list 요소 중 엑셀로 출력할 컬럼 key 목록
	public String[] extraHeader; // 추가할 헤더 지정
	public String[] summaryRow; // 합계를 계산할 컬럼 key 목록
	public String summaryRowLabel = "합계"; // 합계 컬럼 명칭
	public String fromDate; // 조회 시작 기간
	public String toDate; // 조회 종료 기간
	public String headerRowMerge = ""; // 헤더 영역 셀 병합  
	public String dataRowMerge = ""; // 데이터 영역 셀 병합 
	
	public ExcelDownloadParam(){}
	
	public ExcelDownloadParam(ModelMap excelParams, List<HashMap<String, Object>> list, String filePrefix, String title,
			String[] names, String[] cols) {
		this.excelParams = excelParams;
		this.list =  new ArrayList<>(list);
		this.filePrefix = filePrefix;
		this.title = title;
		this.names = names;
		this.cols = cols;
	}

	public ModelMap getExcelParams() {
		return excelParams;
	}

	public ExcelDownloadParam setExcelParams(ModelMap excelParams) {
		this.excelParams = excelParams;
		return this;
	}

	public List<HashMap<String, Object>> getList() {
		return list;
	}

	public ExcelDownloadParam setList(List<HashMap<String, Object>> list) {
		this.list = list;
		return this;
	}

	public String getFilePrefix() {
		return filePrefix;
	}

	public ExcelDownloadParam setFilePrefix(String filePrefix) {
		this.filePrefix = filePrefix;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public ExcelDownloadParam setTitle(String title) {
		this.title = title;
		return this;
	}

	public String[] getNames() {
		return names;
	}

	public ExcelDownloadParam setNames(String... names) {
		this.names = names;
		return this;
	}

	public String[] getCols() {
		return cols;
	}

	public ExcelDownloadParam setCols(String... cols) {
		this.cols = cols;
		return this;
	}

	public String[] getExtraHeader() {
		return extraHeader;
	}

	public ExcelDownloadParam setExtraHeader(String... extraHeader) {
		this.extraHeader = extraHeader;
		return this;
	}
	
	public String[] getSummaryRow() {
		return summaryRow;
	}

	public ExcelDownloadParam setSummaryRow(String... summaryRows) {
		this.summaryRow = summaryRows;
		return this;
	}

	public String getSummaryRowLabel() {
		return summaryRowLabel;
	}

	public void setSummaryRowLabel(String summaryRowLabel) {
		this.summaryRowLabel = summaryRowLabel;
	}
	
	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public ExcelDownloadParam setDate(String from, String to) {
		this.fromDate = from;
		this.toDate = to;
		return this;
	}		
	

	@Override
	public String toString() {
		return "ExcelDownloadParam [excelParams=" + excelParams + ", list=" + list + ", filePrefix=" + filePrefix
				+ ", title=" + title + ", names=" + Arrays.toString(names) + ", cols=" + Arrays.toString(cols)
				+ ", extraHeader=" + Arrays.toString(extraHeader) + ", summaryRow=" + Arrays.toString(summaryRow)
				+ ", summaryRowLabel=" + summaryRowLabel + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", headerRowMerge=" + headerRowMerge + ", dataRowMerge=" + dataRowMerge + "]";
	}

	/**
	 * 소계 추가 
	 * @param pos 소계 행이 추가될 위치
	 * @param includeKey, includeVal - 맵의 includeKey 로 찾은 값이 includeVal 일치하는 경우만 소계에 누적.
	 * @param labelKeys, labelVals - 소계 출력될 행을 제외한 라벨에 넣어줄 값 목록.
	 */
	public ExcelDownloadParam addMidSum(int pos, String includeKey, String includeVal, String[] labelKeys, String[] labelVals) {
		HashMap<String, Object> sum = sumWithLabels(labelKeys, labelVals);
		for(String each : summaryRow) {
			sum.put(each,  includeSum(includeKey, includeVal, each));
		}
		this.list.add(pos, sum);
		return this;
	}
	/**
	 * 소계 추가 
	 * @param includeKey, includeVal - 맵의 includeKey 로 찾은 값이 includeVal 일치하는 경우만 소계에 누적.
	 * @param labelKeys, labelVals - 소계 출력될 행을 제외한 라벨에 넣어줄 값 목록.
	 */	
	public ExcelDownloadParam addMidSum(String includeKey, String includeVal, String[] labelKeys, String[] labelVals) {
		int pos = getRowCount(includeKey, includeVal);
		return addMidSum(pos, includeKey, includeVal, labelKeys, labelVals);
	}
	private int getRowCount(String includeKey, String includeVal) {
		int faqRowCnt = 0;
		for(HashMap<String, Object> each : list) {
			if( includeVal.equals(each.get(includeKey)) )
				faqRowCnt += 1;
		}
		return faqRowCnt;
	}	
	
	
	/**
	 * 총계 추가 
	 * @param excludeKey, excludeVal - 맵의 excludeKey 로 찾은 값이 excludeVal 일치하는 경우를 제외하고 총계에 누적.
	 * @param labelKeys, labelVals - 소계 출력될 행을 제외한 라벨에 넣어줄 값 목록.
	 */	
	public ExcelDownloadParam addTotalSum(String excludeKey, String excludeVal, String[] labelKeys, String[] labelVals) {
		HashMap<String, Object> sum = sumWithLabels(labelKeys, labelVals);
		for(String each : summaryRow) {
			sum.put(each,  excludeSum(excludeKey, excludeVal, each));
		}		
		this.list.add(sum);
		return this;
	}	
	
	private HashMap<String, Object> sumWithLabels(String[] keys, String[] vals) {
		HashMap<String, Object> sum = new HashMap<>();
		for(int i=0; i<keys.length; i++) {
			sum.put(keys[i], vals[i]);
		}
		return sum;
	}
	private int includeSum(String includeKey, String includeVal, String colKey) {
		int rowSum = 0;
		for(HashMap<String, Object> each : list) {
			if ( includeVal.equals(each.get(includeKey)) ) {
				rowSum = rowSum + (int)each.get(colKey);
			}
		}
		return rowSum;
	}		
	private int excludeSum(String key, String val, String colKey) {
		int rowSum = 0;
		for(HashMap<String, Object> each : list) {
			if ( !val.equals(each.get(key)) ) {
				rowSum = rowSum + (int)each.get(colKey);
			}
		}
		return rowSum;
	}

	/**
	 * 헤더 영역 병합 : 병합할 행들을 쉼표로 구분하여 엑셀 행열 서식으로 지정
	 * 
	 * 예) 첫행 1열 ~ 3열 병합             =>  setHeaderRowMerge("A1:C1")
	 *    둘째행 1열 ~ 셋째행 2열 병합     =>  setHeaderRowMerge("A2:B3")
	 *    첫행 1열 ~ 3열, 둘째행 1열 ~ 셋째행 2열 병합  =>  setHeaderRowMerge("A1:C1,A2:B3")
	 */
	public ExcelDownloadParam setHeaderRowMerge(String headerRowMerge) {
		this.headerRowMerge = headerRowMerge;
		return this;
	}	

	/**
	 * 데이터 영역 세로 병합 : 지정한 컬럼 키로 찾은 값과 동일한 값을 가진 행들을 세로 병합
	 * @param key 병합 대상 컬럼의 키 값
	 * @param val 병합 대상 컬럼의 값
	 */
	public ExcelDownloadParam addDataRowVerticalMerge(String key, String val) {
		
		int colIdx = getColumnIndex(key);
		int vMergeStartRow = getHeaderRowCount();
		for(HashMap<String, Object> each : list) {
			if ( val.equals(each.get(key)) ) {
				break;
			}
			vMergeStartRow += 1;
		}
		int vMergeEndRow = vMergeStartRow + getRowCount(key, val) - 1;
		String vMerge = new CellRangeAddress(vMergeStartRow,vMergeEndRow, colIdx,colIdx).formatAsString();
		
		dataRowMerge += dataRowMerge.isEmpty() ? vMerge : (","+vMerge);
		
		return this;
	}
	
	/**
	 * 데이터 영역 가로 병합 : 제외 컬럼 키와 값을 입력하면 일치하는 값을 가진 행은 제외하고 병합
	 * @param mergeCols 가로로 병합할 컬럼을 index 오름 차순으로 지정
	 * @param excludeKey 가로 병합 시 제외할 컬럼 키 값
	 * @param excludeVal 가로 병합 시 제외할 컬럼 값
	 * 
	 * 예 ) type과 subType 컬럼을 병합, 단 type 이 FAQ 인 행은 병합에서 제외  
	 *   => setDataRowHorizontalMerge(new String[]{"type, subType"}, "type", "FAQ" )
	 */
	public ExcelDownloadParam addDataRowHorizontalMerge(String[] mergeCols, String excludeKey, String excludeVal) {
		
		int rowIdx = getHeaderRowCount();
		String cMerge = "";
		int cMergeStartIdx = getColumnIndex(mergeCols[0]);
		int cMergeEndIdx = getColumnIndex(mergeCols[mergeCols.length-1]);
		for(HashMap<String, Object> each : list) {
			if ( excludeKey==null || !excludeVal.equals(each.get(excludeKey)) ) {
				String merge = new CellRangeAddress(rowIdx, rowIdx, cMergeStartIdx, cMergeEndIdx).formatAsString();
				cMerge += cMerge.isEmpty() ? merge : ("," + merge);
			}
			rowIdx += 1;
		}
		
		this.dataRowMerge += dataRowMerge.isEmpty() ? cMerge : (","+cMerge);
		
		return this;
	}	
	/**
	 * 데이터 영역 가로 병합
	 * 
	 * 예 ) 데이터 행의 type과 subType 컬럼을 병합
	 *   => setDataRowHorizontalMerge(new String[]{"type, subType"})
	 */
	public ExcelDownloadParam setDataRowHorizontalMerge(String[] mergeCols) {
		addDataRowHorizontalMerge(mergeCols, null, null);
		return this;
	}
	
	private int getColumnIndex(String key) {
		for(int i=0; i<cols.length; i++) {
			if( key.equals(cols[i]) ) {
				return i;
			}
		}
		return -1;
	}

	private int getHeaderRowCount() {
		return 2 + (extraHeader==null ? 0 : extraHeader.length);
	}
	
}