var m_popDvcMakMgmtId = "popDvcMakMgmt";
var m_popDvcMakMgmt_execFunc = "";
var m_popDvcMakMgmt_maxCellId = 0;
var m_popDvcMakMgmt_selectedWrqDt = "";
var m_popDvcMakMgmt_selectedMetaDvsCod = "M";
var m_popDvcMakMgmt_mapDvcMak = new Map();

/*
var m_data = 
	{
		"listDvcMak": [ 
		 	{"WRQ_DT":"2018.01.01","STP":1,"U_META_DVS_COD":"M","U_HRD_QNTY":1,"U_SFT_QNTY":1,"L_META_DVS_COD":"M","L_HRD_QNTY":1,"L_SFT_QNTY":1,"WRK_DVS":"C"},
		 	{"WRQ_DT":"2018.01.01","STP":2,"U_META_DVS_COD":"M","U_HRD_QNTY":1,"U_SFT_QNTY":0,"L_META_DVS_COD":"M","L_HRD_QNTY":1,"L_SFT_QNTY":0,"WRK_DVS":"C"},
		 	{"WRQ_DT":"2018.01.01","STP":3,"U_META_DVS_COD":"M","U_HRD_QNTY":1,"U_SFT_QNTY":0,"L_META_DVS_COD":"M","L_HRD_QNTY":1,"L_SFT_QNTY":0,"WRK_DVS":"C"},
		 	{"WRQ_DT":"2018.01.01","STP":4,"U_META_DVS_COD":"M","U_HRD_QNTY":1,"U_SFT_QNTY":0,"L_META_DVS_COD":"M","L_HRD_QNTY":1,"L_SFT_QNTY":0,"WRK_DVS":"C"},
		 	{"WRQ_DT":"2018.01.01","STP":5,"U_META_DVS_COD":"M","U_HRD_QNTY":1,"U_SFT_QNTY":0,"L_META_DVS_COD":"M","L_HRD_QNTY":1,"L_SFT_QNTY":0,"WRK_DVS":"C"},
		 	{"WRQ_DT":"2018.01.01","STP":6,"U_META_DVS_COD":"M","U_HRD_QNTY":1,"U_SFT_QNTY":0,"L_META_DVS_COD":"P","L_HRD_QNTY":1,"L_SFT_QNTY":0,"WRK_DVS":"C"},
		 	{"WRQ_DT":"2018.04.01","STP":6,"U_META_DVS_COD":"R","U_HRD_QNTY":1,"U_SFT_QNTY":0,"L_META_DVS_COD":"R","L_HRD_QNTY":1,"L_SFT_QNTY":0,"WRK_DVS":"C"},
		 	{"WRQ_DT":"2018.04.01","STP":7,"U_META_DVS_COD":"M","U_HRD_QNTY":1,"U_SFT_QNTY":0,"L_META_DVS_COD":"M","L_HRD_QNTY":1,"L_SFT_QNTY":0,"WRK_DVS":"C"},
		 	{"WRQ_DT":"2018.04.01","STP":8,"U_META_DVS_COD":"M","U_HRD_QNTY":1,"U_SFT_QNTY":0,"L_META_DVS_COD":"M","L_HRD_QNTY":1,"L_SFT_QNTY":0,"WRK_DVS":"C"},
		 	{"WRQ_DT":"2018.04.01","STP":9,"U_META_DVS_COD":"M","U_HRD_QNTY":1,"U_SFT_QNTY":0,"L_META_DVS_COD":"M","L_HRD_QNTY":1,"L_SFT_QNTY":0,"WRK_DVS":"C"},
		 	{"WRQ_DT":"2018.04.01","STP":10,"U_META_DVS_COD":"M","U_HRD_QNTY":1,"U_SFT_QNTY":0,"L_META_DVS_COD":"M","L_HRD_QNTY":1,"L_SFT_QNTY":0,"WRK_DVS":"C"},
		 	{"WRQ_DT":"2018.04.01","STP":11,"U_META_DVS_COD":"M","U_HRD_QNTY":1,"U_SFT_QNTY":0,"L_META_DVS_COD":"M","L_HRD_QNTY":1,"L_SFT_QNTY":0,"WRK_DVS":"C"},
		 	{"WRQ_DT":"2018.04.01","STP":12,"U_META_DVS_COD":"M","U_HRD_QNTY":1,"U_SFT_QNTY":0,"L_META_DVS_COD":"M","L_HRD_QNTY":1,"L_SFT_QNTY":0,"WRK_DVS":"C"},
		 	{"WRQ_DT":"2018.07.01","STP":13,"U_META_DVS_COD":"M","U_HRD_QNTY":1,"U_SFT_QNTY":0,"L_META_DVS_COD":"M","L_HRD_QNTY":1,"L_SFT_QNTY":0,"WRK_DVS":"O"},
		 	{"WRQ_DT":"2018.07.01","STP":14,"U_META_DVS_COD":"M","U_HRD_QNTY":1,"U_SFT_QNTY":0,"L_META_DVS_COD":"M","L_HRD_QNTY":1,"L_SFT_QNTY":0,"WRK_DVS":"O"},
		 	{"WRQ_DT":"2018.07.01","STP":15,"U_META_DVS_COD":"M","U_HRD_QNTY":1,"U_SFT_QNTY":0,"L_META_DVS_COD":"M","L_HRD_QNTY":1,"L_SFT_QNTY":0,"WRK_DVS":"O"},
	 	]
	};
*/
var m_data = 
{
	"listDvcMak": [
	    {"WRQ_ID":"R171100001","SNM":1,"STP":0,"WRQ_DT":"2018.01.01","UPJ_META_DVS_COD":"P","UPJ_HRD_QNTY":1,"UPJ_SFT_QNTY":0,"LOJ_META_DVS_COD":"P","LOJ_HRD_QNTY":1,"LOJ_SFT_QNTY":0,"WRK_DVS":"C"},
	    {"WRQ_ID":"R171100001","SNM":2,"STP":0,"WRQ_DT":"2018.01.01","UPJ_META_DVS_COD":"P","UPJ_HRD_QNTY":1,"UPJ_SFT_QNTY":0,"LOJ_META_DVS_COD":"P","LOJ_HRD_QNTY":1,"LOJ_SFT_QNTY":0,"WRK_DVS":"C"},
	 	{"WRQ_ID":"R171100002","SNM":3,"STP":1,"WRQ_DT":"2018.04.01","UPJ_META_DVS_COD":"M","UPJ_HRD_QNTY":1,"UPJ_SFT_QNTY":0,"LOJ_META_DVS_COD":"M","LOJ_HRD_QNTY":1,"LOJ_SFT_QNTY":0,"WRK_DVS":"C"},
	 	{"WRQ_ID":"R171100002","SNM":4,"STP":2,"WRQ_DT":"2018.04.01","UPJ_META_DVS_COD":"M","UPJ_HRD_QNTY":1,"UPJ_SFT_QNTY":0,"LOJ_META_DVS_COD":"M","LOJ_HRD_QNTY":1,"LOJ_SFT_QNTY":0,"WRK_DVS":"C"},
	 	{"WRQ_ID":"R171100002","SNM":5,"STP":3,"WRQ_DT":"2018.04.01","UPJ_META_DVS_COD":"M","UPJ_HRD_QNTY":1,"UPJ_SFT_QNTY":0,"LOJ_META_DVS_COD":"M","LOJ_HRD_QNTY":1,"LOJ_SFT_QNTY":0,"WRK_DVS":"C"},
	 	{"WRQ_ID":"R171100002","SNM":6,"STP":4,"WRQ_DT":"2018.04.01","UPJ_META_DVS_COD":"M","UPJ_HRD_QNTY":1,"UPJ_SFT_QNTY":0,"LOJ_META_DVS_COD":"M","LOJ_HRD_QNTY":1,"LOJ_SFT_QNTY":0,"WRK_DVS":"C"},
	 	{"WRQ_ID":"R171100002","SNM":7,"STP":5,"WRQ_DT":"2018.04.01","UPJ_META_DVS_COD":"M","UPJ_HRD_QNTY":1,"UPJ_SFT_QNTY":0,"LOJ_META_DVS_COD":"M","LOJ_HRD_QNTY":1,"LOJ_SFT_QNTY":0,"WRK_DVS":"C"},
	 	{"WRQ_ID":"R171100002","SNM":8,"STP":6,"WRQ_DT":"2018.04.01","UPJ_META_DVS_COD":"M","UPJ_HRD_QNTY":1,"UPJ_SFT_QNTY":0,"LOJ_META_DVS_COD":"M","LOJ_HRD_QNTY":1,"LOJ_SFT_QNTY":0,"WRK_DVS":"C"},
	 	{"WRQ_ID":"R171100003","SNM":9,"STP":7,"WRQ_DT":"2018.07.01","UPJ_META_DVS_COD":"M","UPJ_HRD_QNTY":1,"UPJ_SFT_QNTY":0,"LOJ_META_DVS_COD":"M","LOJ_HRD_QNTY":1,"LOJ_SFT_QNTY":0,"WRK_DVS":"O"},
	 	{"WRQ_ID":"R171100003","SNM":10,"STP":8,"WRQ_DT":"2018.07.01","UPJ_META_DVS_COD":"M","UPJ_HRD_QNTY":1,"UPJ_SFT_QNTY":0,"LOJ_META_DVS_COD":"M","LOJ_HRD_QNTY":1,"LOJ_SFT_QNTY":0,"WRK_DVS":"O"},
	 	{"WRQ_ID":"R171100003","SNM":11,"STP":9,"WRQ_DT":"2018.07.01","UPJ_META_DVS_COD":"M","UPJ_HRD_QNTY":1,"UPJ_SFT_QNTY":0,"LOJ_META_DVS_COD":"M","LOJ_HRD_QNTY":1,"LOJ_SFT_QNTY":0,"WRK_DVS":"O"},
 	]
};


var mt_prc = 
	[
	 	{"MAK_TYPE":"P","UNT_PRC":33000,"UL_TYPE":"U","DVC_TYPE":"P","HD_CNT":1,"SFT_CNT":0}
	];


$(function() {
	
	// 마우스 우클릭 컨텍스트 메뉴 실행 방지
	// step 차감 기능으로 사용
	$(document).bind("contextmenu",function(e){
		return false;
	});	
});


/** 장치제작 json 데이터를 파싱하여 데이터 구조에 담는다. */
function fParseDataToMap_popDvcMakMgmt(data) {
	
	// 장치제작 Map 데이터 초기화
	fReleaseMap_popDvcMakMgmt();
	
	var wrqData;
	var mapData;
	var wrqDt = "";
	var minStp;
	var maxStp;
	
	for (var i=0 ; i<data.listDvcMak.length ; i++) {
		
		var rowData = data.listDvcMak[i];
		
		if (wrqDt == rowData.WRQ_DT) {
			//if. 기존 의뢰서 데이터
			
			// 스텝 데이터
			var stpData = new Object();
			stpData.STP = rowData.STP;
			stpData.SNM = rowData.SNM;
			stpData.UPJ_META_DVS_COD = rowData.UPJ_META_DVS_COD;
			stpData.UPJ_HRD_QNTY = rowData.UPJ_HRD_QNTY;
			stpData.UPJ_SFT_QNTY = rowData.UPJ_SFT_QNTY;
			stpData.UPJ_QNTY = rowData.UPJ_HRD_QNTY + rowData.UPJ_SFT_QNTY;
			stpData.LOJ_META_DVS_COD = rowData.LOJ_META_DVS_COD;
			stpData.LOJ_HRD_QNTY = rowData.LOJ_HRD_QNTY;
			stpData.LOJ_SFT_QNTY = rowData.LOJ_SFT_QNTY;
			stpData.LOJ_QNTY = rowData.LOJ_HRD_QNTY + rowData.LOJ_SFT_QNTY;
			
			mapData.put(rowData.SNM, stpData);
			
		} else {
			//if. 신규 의뢰서 데이터
			
			// 현재 의뢰 일자 설정
			wrqDt = rowData.WRQ_DT;
			
			// step min/max 설정 및 초기화
			minStp = 999;
			maxStp = 0;

			// 의뢰 객체 생성
			wrqData = new Object();
			wrqData.WRQ_ID = rowData.WRQ_ID;
			wrqData.WRQ_DT = rowData.WRQ_DT;
			wrqData.WRK_DVS = rowData.WRK_DVS;
			
			// 스텝 데이터
			var stpData = new Object();
			stpData.STP = rowData.STP;
			stpData.SNM = rowData.SNM;
			stpData.UPJ_META_DVS_COD = rowData.UPJ_META_DVS_COD;
			stpData.UPJ_HRD_QNTY = rowData.UPJ_HRD_QNTY;
			stpData.UPJ_SFT_QNTY = rowData.UPJ_SFT_QNTY;
			stpData.UPJ_QNTY = rowData.UPJ_HRD_QNTY + rowData.UPJ_SFT_QNTY;
			stpData.LOJ_META_DVS_COD = rowData.LOJ_META_DVS_COD;
			stpData.LOJ_HRD_QNTY = rowData.LOJ_HRD_QNTY;
			stpData.LOJ_SFT_QNTY = rowData.LOJ_SFT_QNTY;
			stpData.LOJ_QNTY = rowData.LOJ_HRD_QNTY + rowData.LOJ_SFT_QNTY;
			
			mapData = new Map();
			mapData.put(rowData.SNM, stpData);
			
			wrqData.DATA = mapData;
			
			m_popDvcMakMgmt_mapDvcMak.put(wrqDt, wrqData);
		}
		
		// min/max step 설정
		if (minStp > rowData.STP) minStp = rowData.STP
		if (maxStp < rowData.STP) maxStp = rowData.STP
		wrqData.STP_STD = minStp;
		wrqData.STP_END = maxStp;
	}
	
	console.log("create new data===========================");
	console.log(m_popDvcMakMgmt_mapDvcMak);
	
	return wrqDt;
}


/** 장치제작 데이터 삭제 */
function fReleaseMap_popDvcMakMgmt() {
	
	var rootKeys = m_popDvcMakMgmt_mapDvcMak.keys();
	
	// 의뢰서별 step 데이터 초기화
	for (var i=0 ; i<rootKeys.length ; i++) {
		m_popDvcMakMgmt_mapDvcMak.get(rootKeys[i]).DATA.clear();
	}
	
	// 전체 데이터 초기화
	m_popDvcMakMgmt_mapDvcMak.clear();
}


/** 장치제작 관리 팝업 오픈 */
function fPopDvcMakMgmt_popDvcMakMgmt() {
	
	fPopDvcMakMgmtResult_popDvcMakMgmt(m_data);
}


/** 장치제작 관리 팝업 오픈 콜백 함수 */
function fPopDvcMakMgmtResult_popDvcMakMgmt(data) {
	
	// 수신 데이터 파싱
	m_popDvcMakMgmt_selectedWrqDt = fParseDataToMap_popDvcMakMgmt(data);
	
	// count drow cell
	var maxStp = 0;
	var nonStpCnt = 0;
	for (var rootKey in m_popDvcMakMgmt_mapDvcMak.map) {
		
		var rootData = m_popDvcMakMgmt_mapDvcMak.get(rootKey);
		for (var stpKey in rootData.DATA.map) {
			
			stpData = rootData.DATA.get(stpKey);
			if (maxStp < stpData.STP) maxStp = stpData.STP;
			if (stpData.STP == 0) nonStpCnt++;
		}	
	}
	
	
	var sbMakDate = new StringBuffer();					// 주문날짜 버퍼
	var sbStpNum = new StringBuffer();					// step info 버퍼
	var sbMakUpjCnt = new StringBuffer();				// 상악제작 버퍼
	var sbMakUpjHrdCnt = new StringBuffer();			// 상악제작(하드) 버퍼
	var sbMakUpjSftCnt = new StringBuffer();			// 상악제작(소프트) 버퍼
	var sbMakLojSftCnt = new StringBuffer();			// 하악제작(소프트) 버퍼
	var sbMakLojHrdCnt = new StringBuffer();			// 하악제작(하드) 버퍼
	var sbMakLojCnt = new StringBuffer();				// 하악제작 버퍼
	
	// 초기 max step 만큼 셀을 그린다.
	m_popDvcMakMgmt_maxCellId = maxStp + nonStpCnt;
	
	for(var i=1 ; i<=m_popDvcMakMgmt_maxCellId ; i++) {
		
		sbMakDate.append("<td id=\"date_"+i+"_"+m_popDvcMakMgmtId+"\"> </td>");							// 주문날자
		sbStpNum.append("<td id=\"stp_"+i+"_"+m_popDvcMakMgmtId+"\"> </td>");								// step
		sbMakUpjCnt.append("<td id=\"upj_"+i+"_"+m_popDvcMakMgmtId+"\"> </td>");							// 상악제작
		sbMakUpjHrdCnt.append("<td id=\"upjHrd_"+i+"_"+m_popDvcMakMgmtId+"\"> </td>");					// 상악제작(하드)
		sbMakUpjSftCnt.append("<td id=\"upjSft_"+i+"_"+m_popDvcMakMgmtId+"\"> </td>");					// 상악제작(소프트)
		sbMakLojSftCnt.append("<td id=\"lojSft_"+i+"_"+m_popDvcMakMgmtId+"\"> </td>");						// 하악제작(소프트)
		sbMakLojHrdCnt.append("<td id=\"lojHrd_"+i+"_"+m_popDvcMakMgmtId+"\"> </td>");					// 하악제작(하드)
		sbMakLojCnt.append("<td id=\"loj_"+i+"_"+m_popDvcMakMgmtId+"\"> </td>");								// 하악제작
	}
		
	/* 장치제작 html 삽입 */
	var sbHtml = new StringBuffer();
	sbHtml.append("<table class=\"table_appliance\" style=\"width: "+(m_popDvcMakMgmt_maxCellId*25)+"px\" id=\"dvcMakHstr_popDvcMakMgmt\">");
	sbHtml.append("  <caption>caption</caption>");
	sbHtml.append("  <thead>");
	// 장치제작 일자
	sbHtml.append("    <tr class=\"day\"  id=\"makDate_popDvcMakMgmt\">");
	sbHtml.append(sbMakDate.toString());
	sbHtml.append("    </tr>");
	// step info
	sbHtml.append("    <tr id=\"stepNum_popDvcMakMgmt\">");
	sbHtml.append(sbStpNum.toString());
	sbHtml.append("    </tr>");
	// 상악제작
	sbHtml.append("    <tr class=\"box\" id=\"makUpjCnt_popDvcMakMgmt\">");
	sbHtml.append(sbMakUpjCnt.toString());
	sbHtml.append("    </tr>");
	sbHtml.append("  </thead>");
	sbHtml.append("  <tbody>");
	// 상악제작(하드)
	sbHtml.append("    <tr class=\"dotted\" id=\"makUpjHrdCnt_popDvcMakMgmt\">");
	sbHtml.append(sbMakUpjHrdCnt.toString());
	sbHtml.append("    </tr>");
	// 상악제작(소프트)
	sbHtml.append("    <tr class=\"solid\" id=\"makUpjSftCnt_popDvcMakMgmt\">");
	sbHtml.append(sbMakUpjSftCnt.toString());
	sbHtml.append("    </tr>");
	// 하악제작(소프트)
	sbHtml.append("    <tr class=\"dotted\" id=\"makLojSftCnt_popDvcMakMgmt\">");
	sbHtml.append(sbMakLojSftCnt.toString());
	sbHtml.append("    </tr>");
	// 하악제작(하드)
	sbHtml.append("    <tr id=\"makLojHrdCnt_popDvcMakMgmt\">");
	sbHtml.append(sbMakLojHrdCnt.toString());
	sbHtml.append("    </tr>");
	sbHtml.append("  </tbody>");
	sbHtml.append("  <tfoot>");
	// 하악제작
	sbHtml.append("    <tr class=\"box\" id=\"makLojCnt_popDvcMakMgmt\">");
	sbHtml.append(sbMakLojCnt.toString());
	sbHtml.append("    </tr>");
	sbHtml.append("  </tfoot>");
	sbHtml.append("</table>");
	
	// 기존 제작 테이블 삭제	
	$("#divDvcMakHstr_popDvcMakMgmt").empty();
	$("#divDvcMakHstr_popDvcMakMgmt").append(sbHtml.toString());

	// step 정보에 대한 화면설정을 한다
	var prevWrqDt;
	var bWrqDt;
	for (var rootKey in m_popDvcMakMgmt_mapDvcMak.map) {
		
		// 의뢰일자 및 스텝 번호를 설정 한다.
		bWrqDt = true;
		var rootData = m_popDvcMakMgmt_mapDvcMak.get(rootKey);
		
		for (var cellKey in rootData.DATA.map) {
			
			var stpData = rootData.DATA.get(cellKey);
			
			// 의뢰일자
			if (bWrqDt) {
				$("#date_"+cellKey+"_"+m_popDvcMakMgmtId).html("<a href=\"javascript:fSelectWrqDt_popDvcMakMgmt('"+rootKey+"');\"><div>"+rootKey+"</div></a>");
				bWrqDt = false;
			}
			
			// 스텝 번호
			if (stpData.STP != 0) {
				$("#stp_"+cellKey+"_"+m_popDvcMakMgmtId).text(stpData.STP);
			}
		}
		
		// 의뢰일자 별 스텝 정보를 설정한다.
		fDrawStepBar_popDvcMakMgmt(prevWrqDt, rootKey);
		
		// 이전 의뢰 일자 설정
		prevWrqDt = rootKey;
	}
	
	// 의뢰일자 이전 및 이후 스텝라인 설정
	fDrawAdjStpBar_popDvcMakMgmt(m_popDvcMakMgmt_selectedWrqDt, true);
	
	// 장치종류 초기 설정
	fSetMakDvs_popDvcMakMgmt(m_popDvcMakMgmt_selectedMetaDvsCod);

	
	// 테이블 내 td 마우스 클릭 이벤트
	// 좌클릭 : 설정 반영 및 수량 증가
	// 우클릭 : 설정 제거 및 수량 감소
	$("#dvcMakHstr_popDvcMakMgmt td").off("mouseup").mouseup(function(e) {
		var id = $(this).attr("id");
		fSetStpClickCell_popDvcMakMgmt(id, e);
	});
	

	// 팝업화면 실행
	gfModalPopTop("#"+m_popDvcMakMgmtId);
}


/** step data 전체를 재구성 한다. */
function fDrawStepBar_popDvcMakMgmt(currWrqDt, newWrqDt) {

	var rootData; 

	/* 이전 의뢰 데이터 초기화 */
	if (currWrqDt) {
		rootData = m_popDvcMakMgmt_mapDvcMak.get(currWrqDt);
		for (var cellKey in rootData.DATA.map) {
			
			var stpData = rootData.DATA.get(cellKey);
			
			$("#upj_"+cellKey+"_"+m_popDvcMakMgmtId).removeClass("appliance passive remake fixied");
			$("#loj_"+cellKey+"_"+m_popDvcMakMgmtId).removeClass("appliance passive remake fixied");
			
			// 제작 종류 설정
			$("#upj_"+cellKey+"_"+m_popDvcMakMgmtId).addClass("bg");		// 상악
			$("#loj_"+cellKey+"_"+m_popDvcMakMgmtId).addClass("bg");		// 하악
			
			// 제작 수량 설정
			// 상악(합계)
			$("#upj_"+cellKey+"_"+m_popDvcMakMgmtId).text(" ");
			// 상악(하드)
			$("#upjHrd_"+cellKey+"_"+m_popDvcMakMgmtId).text(" ");
			// 상악(소프트)
			$("#upjSft_"+cellKey+"_"+m_popDvcMakMgmtId).text(" ");
			
			// 하악
			// 하악(합계)
			$("#loj_"+cellKey+"_"+m_popDvcMakMgmtId).text(" ");
			// 하악(하드)
			$("#lojHrd_"+cellKey+"_"+m_popDvcMakMgmtId).text(" ");
			// 하악(소프트)
			$("#lojSft_"+cellKey+"_"+m_popDvcMakMgmtId).text(" ");					
		}
	}
	
	
	/* 선택된 의뢰 데이터 초기화 */
	rootData = m_popDvcMakMgmt_mapDvcMak.get(newWrqDt);
	for (var cellKey in rootData.DATA.map) {
		
		var stpData = rootData.DATA.get(cellKey);
		
		// 제작 종류 설정
		$("#upj_"+cellKey+"_"+m_popDvcMakMgmtId).addClass(fGetBoxClass_popDvcMakMgmt(stpData.UPJ_META_DVS_COD));		// 상악
		$("#loj_"+cellKey+"_"+m_popDvcMakMgmtId).addClass(fGetBoxClass_popDvcMakMgmt(stpData.LOJ_META_DVS_COD));		// 하악
		
		// 제작 수량 설정
		// 상악(합계)
		$("#upj_"+cellKey+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpData.UPJ_QNTY));
		// 상악(하드)
		$("#upjHrd_"+cellKey+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpData.UPJ_HRD_QNTY));
		// 상악(소프트)
		$("#upjSft_"+cellKey+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpData.UPJ_SFT_QNTY));
		
		// 하악
		// 하악(합계)
		$("#loj_"+cellKey+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpData.LOJ_QNTY));
		// 하악(하드)
		$("#lojHrd_"+cellKey+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpData.LOJ_HRD_QNTY));
		// 하악(소프트)
		$("#lojSft_"+cellKey+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpData.LOJ_SFT_QNTY));			
	}
}


/** 의뢰일 이전 및 이후 의뢰정보를 표기 한다 */
function fDrawAdjStpBar_popDvcMakMgmt(wrqDt, bDrawFlag) {

	// 의뢰서 데이터 맵
	var prevWrqDt;
	var nextWrqDt;
	
	// 의뢰 일자에 대한 이전/이후 주문 일자를 찾는다.
	var rootKeys = m_popDvcMakMgmt_mapDvcMak.keys();
	for (var i=0 ; i<rootKeys.length ; i++) {
		if (rootKeys[i] == wrqDt) {
			
			if (i>0) prevWrqDt = rootKeys[i-1];
			if (i<(rootKeys.length-1)) nextWrqDt = rootKeys[i+1];
			
			break;
		}
	}
	
	// 이전일자 주문정보 설정
	if (prevWrqDt) {
		
		var stpData = m_popDvcMakMgmt_mapDvcMak.get(prevWrqDt).DATA;
		for(var cellKey in stpData.map) {
			if (bDrawFlag) 	{
				// if. 이전 정보를 설정한다
				$("#upjSft_"+cellKey+"_"+m_popDvcMakMgmtId).addClass("lineB_red");
			} else {
				// if. 이전 정보를 삭제한다.
				$("#upjSft_"+cellKey+"_"+m_popDvcMakMgmtId).removeClass("lineB_red");
			}
		}
	}
	
	// 이후일자 주문정보 설정
	if (nextWrqDt) {
		
		var stpData = m_popDvcMakMgmt_mapDvcMak.get(nextWrqDt).DATA;
		for(var cellKey in stpData.map) {
			if (bDrawFlag) 	{
				// if. 이전 정보를 설정한다
				$("#upjSft_"+cellKey+"_"+m_popDvcMakMgmtId).addClass("lineB_red");
			} else {
				// if. 이전 정보를 삭제한다.
				$("#upjSft_"+cellKey+"_"+m_popDvcMakMgmtId).removeClass("lineB_red");
			}
		}	
	}
}


/** 의뢰일자 선택 시 step 데이터 화면을 재구성 한다. */
function fSelectWrqDt_popDvcMakMgmt(wrqDt) {
	
	// 의뢰일자 스텝 데이터 설정
	fDrawStepBar_popDvcMakMgmt(m_popDvcMakMgmt_selectedWrqDt, wrqDt);
	// 의뢰일자 이전 및 이후 스텝라인을 삭제 한다.
	fDrawAdjStpBar_popDvcMakMgmt(m_popDvcMakMgmt_selectedWrqDt, false);
	// 의뢰일자 이전 및 이후 스텝라인 설정 한다.
	fDrawAdjStpBar_popDvcMakMgmt(wrqDt, true);
	// 선택된 의뢰 일자 설정
	m_popDvcMakMgmt_selectedWrqDt = wrqDt;
}


/** 선택된 셀의 장치 제작 타입 및 갯수 설정 */
function fSetStpClickCell_popDvcMakMgmt(id, e) {
	
	var arrId = id.split("_");
	var idCellType = arrId[0];
	var cellId = arrId[1];
	
	// 선택된 셀이 날짜 또는 step 수 row일경우 로직을 종료 한다.
	if (idCellType == "date" || idCellType == "stp") {
		return false;
	}
	
	switch(e.which) {
	case 1:	// 좌 클릭
		fLButtonClick_popDvcMakMgmt(idCellType, cellId);
		break;
	case 3:	// 우 클릭
		fRButtonClick_popDvcMakMgmt(idCellType, cellId);
		break;
	}
}


/** 마우스 왼쪽버튼 클릭 이벤트
 *   - 상악, 하악에 대한 장치타입 설정
 *   - 하드, 소프트에 대한 갯수 증가
 *  */
function fLButtonClick_popDvcMakMgmt(cellType, cellId) {
	
	console.log("m_popDvcMakMgmt_selectedWrqDt=["+m_popDvcMakMgmt_selectedWrqDt+"]");
	console.log("cellType=["+cellType+"], cellId=["+cellId+"]");
	
	
	// 의뢰일자에 대한 step 설정 데이터를 가져 온다.
	var rootData = m_popDvcMakMgmt_mapDvcMak.get(m_popDvcMakMgmt_selectedWrqDt);
	
	// 의뢰한 내역아 이닐 경우 종료한다.
	var wrkDvs = rootData.WRK_DVS;
	if (wrkDvs == "C")
		return false;
	
	var stpData = rootData.DATA.get(cellId);
	console.log(stpData);
	if (cellType == "upj") {
		
		// 상악 장치구분 설정
		if (stpData) {
			stpData.UPJ_META_DVS_COD = m_popDvcMakMgmt_selectedMetaDvsCod;
			if (stpData.UPJ_QNTY == 0) {
				stpData.UPJ_QNTY = 1;
				stpData.UPJ_HRD_QNTY = 1;
				stpData.UPJ_SFT_QNTY = 0;
			}
		} else {
			stpData = new Object();
			stpData.STP = Number($.trim($("#stp_"+cellId+"_"+m_popDvcMakMgmtId).text()));
			stpData.SNM = cellId;
			stpData.UPJ_META_DVS_COD = m_popDvcMakMgmt_selectedMetaDvsCod;
			stpData.UPJ_QNTY = 1;
			stpData.UPJ_HRD_QNTY = 1;
			stpData.UPJ_SFT_QNTY = 0;
			stpData.LOJ_META_DVS_COD = "";
			stpData.LOJ_QNTY = 0;
			stpData.LOJ_HRD_QNTY = 0;
			stpData.LOJ_SFT_QNTY = 0;
			rootData.DATA.put(cellId, stpData);
		}
		
	} else if (cellType == "loj") {
		
		// 하악 장치구분 설정
		if (stpData) {
			stpData.LOJ_META_DVS_COD = m_popDvcMakMgmt_selectedMetaDvsCod;
			if (stpData.LOJ_QNTY == 0) {
				stpData.LOJ_QNTY = 1;
				stpData.LOJ_HRD_QNTY = 1;
				stpData.LOJ_SFT_QNTY = 0;
			}
		} else {
			stpData = new Object();
			stpData.STP = Number($.trim($("#stp_"+cellId+"_"+m_popDvcMakMgmtId).text()));
			stpData.SNM = cellId;
			stpData.UPJ_META_DVS_COD = "";
			stpData.UPJ_QNTY = 0;
			stpData.UPJ_HRD_QNTY = 0;
			stpData.UPJ_SFT_QNTY = 0;
			stpData.LOJ_META_DVS_COD = m_popDvcMakMgmt_selectedMetaDvsCod;
			stpData.LOJ_QNTY = 1;
			stpData.LOJ_HRD_QNTY = 1;
			stpData.LOJ_SFT_QNTY = 0;
			rootData.DATA.put(cellId, stpData);
		}
		
	} else if (cellType == "upjHrd") {
		
		// 상악 하드 갯수 설정
		if (stpData) {
			stpData.UPJ_META_DVS_COD = m_popDvcMakMgmt_selectedMetaDvsCod;
			stpData.UPJ_HRD_QNTY = stpData.UPJ_HRD_QNTY + 1;
			stpData.UPJ_QNTY = stpData.UPJ_HRD_QNTY + stpData.UPJ_SFT_QNTY;
			
		} else {
			stpData = new Object();
			stpData.STP = Number($.trim($("#stp_"+cellId+"_"+m_popDvcMakMgmtId).text()));
			stpData.SNM = cellId;
			stpData.UPJ_META_DVS_COD = m_popDvcMakMgmt_selectedMetaDvsCod;
			stpData.UPJ_QNTY = 1;
			stpData.UPJ_HRD_QNTY = 1;
			stpData.UPJ_SFT_QNTY = 0;
			stpData.LOJ_META_DVS_COD = "";
			stpData.LOJ_QNTY = 0;
			stpData.LOJ_HRD_QNTY = 0;
			stpData.LOJ_SFT_QNTY = 0;
			rootData.DATA.put(cellId, stpData);
		}
		
	} else if (cellType == "upjSft") {
		
		// 상악 소프트 갯수 설정
		if (stpData) {
			stpData.UPJ_META_DVS_COD = m_popDvcMakMgmt_selectedMetaDvsCod;
			stpData.UPJ_SFT_QNTY = stpData.UPJ_SFT_QNTY + 1;
			stpData.UPJ_QNTY = stpData.UPJ_HRD_QNTY + stpData.UPJ_SFT_QNTY;
		} else {
			stpData = new Object();
			stpData.STP = Number($.trim($("#stp_"+cellId+"_"+m_popDvcMakMgmtId).text()));
			stpData.SNM = cellId;
			stpData.UPJ_META_DVS_COD = m_popDvcMakMgmt_selectedMetaDvsCod;
			stpData.UPJ_QNTY = 1;
			stpData.UPJ_HRD_QNTY = 0;
			stpData.UPJ_SFT_QNTY = 1;
			stpData.LOJ_META_DVS_COD = "";
			stpData.LOJ_QNTY = 0;
			stpData.LOJ_HRD_QNTY = 0;
			stpData.LOJ_SFT_QNTY = 0;
			rootJson.DATA.put(cellId, stpData);
		}
		
	} else if (cellType == "lojHrd") {
		
		// 하악 하드 갯수 설정
		if (stpData) {
			stpData.LOJ_META_DVS_COD = m_popDvcMakMgmt_selectedMetaDvsCod;
			stpData.LOJ_HRD_QNTY = stpData.LOJ_HRD_QNTY + 1;
			stpData.LOJ_QNTY = stpData.LOJ_HRD_QNTY + stpData.LOJ_SFT_QNTY;
		} else {
			stpData = new Object();
			stpData.STP = Number($.trim($("#stp_"+cellId+"_"+m_popDvcMakMgmtId).text()));
			stpData.SNM = cellId;
			stpData.UPJ_META_DVS_COD = "";
			stpData.UPJ_QNTY = 0;
			stpData.UPJ_HRD_QNTY = 0;
			stpData.UPJ_SFT_QNTY = 0;
			stpData.LOJ_META_DVS_COD = m_popDvcMakMgmt_selectedMetaDvsCod;
			stpData.LOJ_QNTY = 1;
			stpData.LOJ_HRD_QNTY = 1;
			stpData.LOJ_SFT_QNTY = 0;
			rootJson.DATA.put(cellId, stpData);
		}
		
	} else if (cellType == "lojSft") {
		
		// 하악 소프트 갯수 설정
		if (stpData) {
			stpData.LOJ_META_DVS_COD = m_popDvcMakMgmt_selectedMetaDvsCod;
			stpData.LOJ_SFT_QNTY = stpData.L_SFT_QNTY + 1;
			stpData.LOJ_QNTY = stpData.LOJ_HRD_QNTY + stpData.LOJ_SFT_QNTY;
		} else {
			stpData = new Object();
			stpData.STP = Number($.trim($("#stp_"+cellId+"_"+m_popDvcMakMgmtId).text()));
			stpData.SNM = cellId;
			stpData.UPJ_META_DVS_COD = "";
			stpData.UPJ_QNTY = 0;
			stpData.UPJ_HRD_QNTY = 0;
			stpData.UPJ_SFT_QNTY = 0;
			stpData.LOJ_META_DVS_COD = m_popDvcMakMgmt_selectedMetaDvsCod;
			stpData.LOJ_QNTY = 1;
			stpData.LOJ_HRD_QNTY = 0;
			stpData.LOJ_SFT_QNTY = 1;
			rootJson.DATA.put(cellId, stpData);
		}
	}
	
	console.log(stpData);
	/* 화면 설정 */
	// 제작 종류 설정
	$("#upj_"+cellId+"_"+m_popDvcMakMgmtId).removeClass("appliance passive remake fixied");
	$("#loj_"+cellId+"_"+m_popDvcMakMgmtId).removeClass("appliance passive remake fixied");
	
	$("#upj_"+cellId+"_"+m_popDvcMakMgmtId).addClass(fGetBoxClass_popDvcMakMgmt(stpData.UPJ_META_DVS_COD));	// 상악
	$("#loj_"+cellId+"_"+m_popDvcMakMgmtId).addClass(fGetBoxClass_popDvcMakMgmt(stpData.LOJ_META_DVS_COD));	// 하악
	
	// 제작 수량 설정
	// 상악(합계)
	$("#upj_"+cellId+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpData.UPJ_QNTY));
	// 상악(하드)
	$("#upjHrd_"+cellId+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpData.UPJ_HRD_QNTY));
	// 상악(소프트)
	$("#upjSft_"+cellId+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpData.UPJ_SFT_QNTY));
	
	// 하악
	// 하악(합계)
	$("#loj_"+cellId+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpData.LOJ_QNTY));
	// 하악(하드)
	$("#lojHrd_"+cellId+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpData.LOJ_HRD_QNTY));
	// 하악(소프트)
	$("#lojSft_"+cellId+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpData.LOJ_SFT_QNTY));
}


/** 마우스 오른쪽버튼 클릭 이벤트
 *   - 상악, 하악에 대한 장치타입 제거
 *   - 하드, 소프트에 대한 갯수 감소
 *  */
function fRButtonClick_popDvcMakMgmt(cellType, cellId) {

	// 의뢰일자에 대한 step 설정 데이터를 가져 온다.
	var rootJson = m_popDvcMakMgmt_mapDvcMak.get(m_popDvcMakMgmt_selectedWrqDt);
	
	// 의뢰한 내역아 이닐 경우 종료한다.
	var wrkDvs = rootJson.WRK_DVS;
	if (wrkDvs == "C")
		return false;
	
	var stpJson = rootJson.DATA.get(cellId);
	
	if (cellType == "upj") {
		// 상악 장치구분 제거
		stpJson.UPJ_META_DVS_COD = "";
		stpJson.UPJ_QNTY = 0;
		stpJson.UPJ_HRD_QNTY = 0;
		stpJson.UPJ_SFT_QNTY = 0;
	} else if (cellType == "loj") {
		// 하악 장치구분 제거
		stpJson.LOJ_META_DVS_COD = "";
		stpJson.LOJ_QNTY = 0;
		stpJson.LOJ_HRD_QNTY = 0;
		stpJson.LOJ_SFT_QNTY = 0;
	} else if (cellType == "upjHrd") {
		if (stpJson.UPJ_HRD_QNTY > 0) {
			stpJson.UPJ_HRD_QNTY = stpJson.UPJ_HRD_QNTY - 1;
			stpJson.UPJ_QNTY = stpJson.UPJ_HRD_QNTY + stpJson.UPJ_SFT_QNTY;
		}
	} else if (cellType == "upjSft") {
		if (stpJson.UOJ_SFT_QNTY > 0) {
			stpJson.UOJ_SFT_QNTY = stpJson.UOJ_SFT_QNTY - 1;
			stpJson.UOJ_QNTY = stpJson.UOJ_HRD_QNTY + stpJson.UOJ_SFT_QNTY;
		}
	} else if (cellType == "lojHrd") {
		if (stpJson.LOJ_HRD_QNTY > 0) {
			stpJson.LOJ_HRD_QNTY = stpJson.LOJ_HRD_QNTY - 1;
			stpJson.LOJ_QNTY = stpJson.LOJ_HRD_QNTY + stpJson.LOJ_SFT_QNTY;
		}
	} else if (cellType == "lojSft") {
		if (stpJson.LOJ_SFT_QNTY > 0) {
			stpJson.LOJ_SFT_QNTY = stpJson.LOJ_SFT_QNTY - 1;
			stpJson.LOJ_QNTY = stpJson.LOJ_HRD_QNTY + stpJson.LOJ_SFT_QNTY;
		}
	}
	
	
	/* 화면 설정 */
	// 제작 종류 설정
	$("#upj_"+cellId+"_"+m_popDvcMakMgmtId).removeClass("appliance passive remake fixied");
	$("#loj_"+cellId+"_"+m_popDvcMakMgmtId).removeClass("appliance passive remake fixied");
	
	$("#upj_"+cellId+"_"+m_popDvcMakMgmtId).addClass(fGetBoxClass_popDvcMakMgmt(stpJson.UPJ_META_DVS_COD));	// 상악
	$("#loj_"+cellId+"_"+m_popDvcMakMgmtId).addClass(fGetBoxClass_popDvcMakMgmt(stpJson.LOJ_META_DVS_COD));		// 하악
	
	// 제작 수량 설정
	// 상악(합계)
	$("#upj_"+cellId+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpJson.UPJ_QNTY));
	// 상악(하드)
	$("#upjHrd_"+cellId+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpJson.UPJ_HRD_QNTY));
	// 상악(소프트)
	$("#upjSft_"+cellId+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpJson.UPJ_SFT_QNTY));
	
	// 하악
	// 하악(합계)
	$("#loj_"+cellId+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpJson.LOJ_QNTY));
	// 하악(하드)
	$("#lojHrd_"+cellId+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpJson.LOJ_HRD_QNTY));
	// 하악(소프트)
	$("#lojSft_"+cellId+"_"+m_popDvcMakMgmtId).text(fGetBoxQnty_popDvcMakMgmt(stpJson.LOJ_SFT_QNTY));
	
	if (stpJson.UPJ_META_DVS_COD == "" && stpJson.LOJ_META_DVS_COD == "") {
		rootJson.DATA.remove(cellId);
	}
}


/** 신규 스텝 추가 */
function fAddNewStep_popDvcMakMgmt() {

	var rootKeys = m_popDvcMakMgmt_mapDvcMak.keys();
	var maxWrqDt = rootKeys[rootKeys.length-1];
	var maxStpData = m_popDvcMakMgmt_mapDvcMak.get(maxWrqDt).DATA.get(m_popDvcMakMgmt_maxCellId);
	
	var maxStp = Number($.trim($("#stp_"+m_popDvcMakMgmt_maxCellId+"_"+m_popDvcMakMgmtId).text()));
	
	
	var stpData = new Object();
	stpData.SNM = ++m_popDvcMakMgmt_maxCellId;
	stpData.STP = (maxStp==0)?0:++maxStp;
	if (maxStpData) {
		// 상악 설정
		stpData.UPJ_META_DVS_COD = maxStpData.UPJ_META_DVS_COD;
		if (maxStpData.UPJ_META_DVS_COD == "") {
			stpData.UPJ_HRD_QNTY = 0;
			stpData.UPJ_SFT_QNTY = 0;
			stpData.UPJ_QNTY = 0;
		} else {
			stpData.UPJ_HRD_QNTY = 1;
			stpData.UPJ_SFT_QNTY = 0;
			stpData.UPJ_QNTY = 1;
		}
		
		// 하악 설정
		stpData.LOJ_META_DVS_COD = maxStpData.LOJ_META_DVS_COD;
		if (maxStpData.LOJ_META_DVS_COD == "") {
			stpData.LOJ_HRD_QNTY = 0;
			stpData.LOJ_SFT_QNTY = 0;
			stpData.LOJ_QNTY = 0;
		} else {
			stpData.LOJ_HRD_QNTY = 1;
			stpData.LOJ_SFT_QNTY = 0;
			stpData.LOJ_QNTY = 1;
		}
	} else {
		// 상악 설정
		stpData.UPJ_META_DVS_COD = "";
		stpData.UPJ_HRD_QNTY = 0;
		stpData.UPJ_SFT_QNTY = 0;
		stpData.UPJ_QNTY = 0;
		stpData.UPJ_HRD_QNTY = 0;
		stpData.UPJ_SFT_QNTY = 0;
		stpData.UPJ_QNTY = 0;
	}
	
	m_popDvcMakMgmt_mapDvcMak.get(maxWrqDt).DATA.put(m_popDvcMakMgmt_maxCellId, stpData);

	// 테이블 크기 조정 및 스크롤 이동
	var tableWidth = Number($("#dvcMakHstr_popDvcMakMgmt").css("width").replace(/[^0-9]/g,'')) + 25;
	$("#dvcMakHstr_popDvcMakMgmt").css("width", tableWidth+"px");

	// 우측 컬럼 추가
	var addObject = $("#makDate_popDvcMakMgmt").append("<td id=\"date_"+m_popDvcMakMgmt_maxCellId+"_"+m_popDvcMakMgmtId+"\"> </td>");
	$("#stepNum_popDvcMakMgmt").append("<td id=\"stp_"+m_popDvcMakMgmt_maxCellId+"_"+m_popDvcMakMgmtId+"\">"+fGetBoxQnty_popDvcMakMgmt(stpData.STP)+"</td>");
	$("#makUpjCnt_popDvcMakMgmt").append("<td id=\"upj_"+m_popDvcMakMgmt_maxCellId+"_"+m_popDvcMakMgmtId+"\">"+fGetBoxQnty_popDvcMakMgmt(stpData.UPJ_QNTY)+"</td>");
	$("#makUpjHrdCnt_popDvcMakMgmt").append("<td id=\"upjHrd_"+m_popDvcMakMgmt_maxCellId+"_"+m_popDvcMakMgmtId+"\">"+fGetBoxQnty_popDvcMakMgmt(stpData.UPJ_HRD_QNTY)+"</td>");
	$("#makUpjSftCnt_popDvcMakMgmt").append("<td id=\"upjSft_"+m_popDvcMakMgmt_maxCellId+"_"+m_popDvcMakMgmtId+"\">"+fGetBoxQnty_popDvcMakMgmt(stpData.UPJ_SFT_QNTY)+"</td>");
	$("#makLojSftCnt_popDvcMakMgmt").append("<td id=\"lojSft_"+m_popDvcMakMgmt_maxCellId+"_"+m_popDvcMakMgmtId+"\">"+fGetBoxQnty_popDvcMakMgmt(stpData.LOJ_SFT_QNTY)+"</td>");
	$("#makLojHrdCnt_popDvcMakMgmt").append("<td id=\"lojHrd_"+m_popDvcMakMgmt_maxCellId+"_"+m_popDvcMakMgmtId+"\">"+fGetBoxQnty_popDvcMakMgmt(stpData.LOJ_HRD_QNTY)+"</td>");
	$("#makLojCnt_popDvcMakMgmt").append("<td id=\"loj_"+m_popDvcMakMgmt_maxCellId+"_"+m_popDvcMakMgmtId+"\">"+fGetBoxQnty_popDvcMakMgmt(stpData.LOJ_QNTY)+"</td>");
	
	if (maxStpData.UPJ_META_DVS_COD != "")
		$("#upj_"+m_popDvcMakMgmt_maxCellId+"_"+m_popDvcMakMgmtId).addClass(fGetBoxClass_popDvcMakMgmt(stpData.UPJ_META_DVS_COD));	// 상악
	if (maxStpData.LOJ_META_DVS_COD != "")
		$("#loj_"+m_popDvcMakMgmt_maxCellId+"_"+m_popDvcMakMgmtId).addClass(fGetBoxClass_popDvcMakMgmt(stpData.LOJ_META_DVS_COD));	// 하악
	
	if (addObject) {
		$("#divDvcMakHstr_popDvcMakMgmt").animate({scrollLeft : tableWidth}, 800);
	}
	
	// 테이블 내 td 마우스 클릭 이벤트
	// 좌클릭 : 설정 반영 및 수량 증가
	// 우클릭 : 설정 제거 및 수량 감소
	$("#dvcMakHstr_popDvcMakMgmt td").off("mouseup").mouseup(function(e) {
		var id = $(this).attr("id");
		fSetStpClickCell_popDvcMakMgmt(id, e);
	});
}


/** 선택된 제작 장치 타입 설정 */
function fSetMakDvs_popDvcMakMgmt(makDvs) {
	
	$("#makDvsAppliance_popDvcMakMgmt").removeClass("font_appliance");
	$("#makDvsPassive_popDvcMakMgmt").removeClass("font_passive");
	$("#makDvsRemake_popDvcMakMgmt").removeClass("font_remake");
	$("#makDvsFixied_popDvcMakMgmt").removeClass("font_fixied");
	$("#makDvsBlank_popDvcMakMgmt").removeClass("font_blank");
	
	switch(makDvs) {
		case "M" :
			m_popDvcMakMgmt_selectedMetaDvsCod = "M";
			$("#makDvsAppliance_popDvcMakMgmt").addClass("font_appliance");
			break;
		case "P" :
			m_popDvcMakMgmt_selectedMetaDvsCod = "P";
			$("#makDvsPassive_popDvcMakMgmt").addClass("font_passive");
			break;
		case "R" :
			m_popDvcMakMgmt_selectedMetaDvsCod = "R";
			$("#makDvsRemake_popDvcMakMgmt").addClass("font_remake");
			break;
		case "F" :
			m_popDvcMakMgmt_selectedMetaDvsCod = "F";
			$("#makDvsFixied_popDvcMakMgmt").addClass("font_fixied");
			break;
		case "B" :
			m_popDvcMakMgmt_selectedMetaDvsCod = "B";
			$("#makDvsBlank_popDvcMakMgmt").addClass("font_blank");
			break;
	}
}


/** 스텝박스 클래스 얻기 */
function fGetBoxClass_popDvcMakMgmt(metaDvsCod) {
	
	if (metaDvsCod == "M") clazz = "appliance";		// 교정장치
	else if(metaDvsCod == "P") clazz = "passive";	// passive
	else if(metaDvsCod == "R") clazz = "remake";	// remake
	else if(metaDvsCod == "F") clazz = "fixied";		// 유지장치
	else clazz = "";
	
	return clazz;
}


/** 스텝박스 제작 수량 얻기 */
function fGetBoxQnty_popDvcMakMgmt(qnty) {

	return (qnty > 0?qnty.toString():" ");
}
