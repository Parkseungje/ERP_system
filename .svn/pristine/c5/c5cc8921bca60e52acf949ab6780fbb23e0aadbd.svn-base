var m_popDestMgmt_execFunc = "";
var m_popDestMgmt_pageSize = 5;
var m_popDestMgmt_pageBlockSize = 10;

var m_popDestMgmt_listDestInfoModel = new Map();


$(function() {
});

/** 배송지관리 팝업 */
function fPopDestMgmt(ofcId, odrId, execFunc) {
	
	$("#formDestMgmt_odrId").val(odrId);
	
	// 팝업 종료 후 실행 되어야 할 함수
	if (execFunc == null || execFunc == "" || execFunc == undefined) {
		m_popDestMgmt_execFunc = "";
	} else {
		m_popDestMgmt_execFunc = execFunc;
	}
	
	var param = {
			ofc_id : ofcId
		,	odr_id : odrId
		,	currentPage : 1
		,	pageSize : m_popDestMgmt_pageSize
	}

	var resultCallback = function(data) {
		fPopDestMgmtResult(data, ofcId);
	};

	callAjax("/odrMgmt/initPopDestMgmt.do", "post", "json", true, param, resultCallback);
}

/** 배송지관리 팝업 콜백 함수 */
function fPopDestMgmtResult(data, ofcId) {
	
	if (data.result == "SUCCESS") {
	
		// 배송지 정보 설정
		var odrDlvrInfoModel = data.odrDlvrInfoModel;
		if (odrDlvrInfoModel != null && odrDlvrInfoModel != "" && odrDlvrInfoModel != undefined) {
			fSetDlvrInfo_popDestMgmt(odrDlvrInfoModel);
		}
		
		// 배송지 목록 정보 설정
		var listDestInfoModel = data.listDestInfoModel;
		if (listDestInfoModel != null && listDestInfoModel != "" && listDestInfoModel != undefined) {
			fSetListDlvrInfo_popDestMgmt(listDestInfoModel);
		}
		
		// 페이지 네비게이션 생성
		var currentPage = data.currentPage;
		var totalCnt = data.totalCnt;
		
		var paginationHtml = getPaginationHtml(currentPage, totalCnt, m_popDestMgmt_pageSize, m_popDestMgmt_pageBlockSize, 'fListDlvrInfo_popDestMgmt', [ofcId]);
		$("#popDestMgmt_pagination").empty().append(paginationHtml);
		
		// 모달 팝업
		gfModalPopTop("#popDestMgmt");
		
	} else {
		// 오류 응답 메시지 출력
		alert(data.resultMsg);
	}
}

/** 배송지 정보 설정 */
function fSetDlvrInfo_popDestMgmt(model) {
	
	$("#formDestMgmt_rcvrNm").val(model.rcvr_nm);
	$("#formDestMgmt_pnn1").val(model.pnn_1);
	$("#formDestMgmt_pnn2").val(model.pnn_2);
	$("#formDestMgmt_pnn3").val(model.pnn_3);
	$("#formDestMgmt_zcd").val(model.zcd);
	$("#formDestMgmt_adrs").val(model.adrs);
	$("#formDestMgmt_dtlAdrs").val(model.dtl_adrs);
}

/** 배송지 목록 정보 설정 */
function fSetListDlvrInfo_popDestMgmt(list) {
	
	m_popDestMgmt_listDestInfoModel.clear();
	
	var listdlvrInfo = new StringBuffer();
	$(list).each(function(index, model) {
		
		listdlvrInfo.append("<tr>");
		listdlvrInfo.append("	<td>"+model.rcvr_nm+"</td>");
		listdlvrInfo.append("	<td>"+model.pnn_1+"-"+model.pnn_2+"-"+model.pnn_3+"</td>");
		listdlvrInfo.append("	<td class='textL'><a href=\"javascript:fSetDlvrInfo_popDestMgmt(m_popDestMgmt_listDestInfoModel.get('"+model.snm+"'));\">"+model.adrs+" "+model.dtl_adrs+"</a></td>");
		listdlvrInfo.append("	<td>"+model.zcd+"</td>");
		listdlvrInfo.append("</tr>");

		m_popDestMgmt_listDestInfoModel.put(model.snm, model);
	});
	
	$("#popDestMgmt_listDestInfo").empty().append(listdlvrInfo.toString());
}


/** 배송지 목록 조회 */
function fListDlvrInfo_popDestMgmt(currentPage, ofcId) {
	
	var param = {
			ofc_id : ofcId
		,	currentPage : currentPage
		,	pageSize : m_popDestMgmt_pageSize
	}
	
	var resultCallback = function(data) {
		fListDlvrInfoResult_popDestMgmt(data, ofcId);
	};

	callAjax("/odrMgmt/listDlvrInfo.do", "post", "json", true, param, resultCallback);
}


/** 배송지 목록 조회 콜백 함수 */
function fListDlvrInfoResult_popDestMgmt(data, ofcId) {
	
	if (data.result == "SUCCESS") {
		
		// 배송지 목록 정보 설정
		var listDestInfoModel = data.listDestInfoModel;
		if (listDestInfoModel != null && listDestInfoModel != "" && listDestInfoModel != undefined) {
			fSetListDlvrInfo_popDestMgmt(listDestInfoModel);
		}
		
		// 페이지 네비게이션 생성
		var currentPage = data.currentPage;
		var totalCnt = data.totalCnt;
		
		var paginationHtml = getPaginationHtml(currentPage, totalCnt, m_popDestMgmt_pageSize, m_popDestMgmt_pageBlockSize, 'fListDlvrInfo_popDestMgmt', [ofcId]);
		$("#popDestMgmt_pagination").empty().append(paginationHtml);

		
	} else {
		// 오류 응답 메시지 출력
		alert(data.resultMsg);
	}
}

/** 배송 정보 수정 */
function fUpdateOdrDlvrInfo_popDestMgmt() {
	
	var chk = checkNotEmpty(
		[
				[ "formDestMgmt_rcvrNm", "수령자 이름을 입력해 주세요." ]
			,	[ "formDestMgmt_pnn1", "전화번호를 입력해 주세요." ]
			,	[ "formDestMgmt_pnn2", "전화번호를 입력해 주세요." ]
			,	[ "formDestMgmt_pnn3", "전화번호를 입력해 주세요." ]
			,	[ "formDestMgmt_zcd", "우펀변호를 입력해 주세요." ]
			,	[ "formDestMgmt_adrs", "주소를 입력해 주세요." ]
			,	[ "formDestMgmt_dtlAdrs", "상세주소를 입력해 주세요." ]
		]
	);
	
	if (!chk) {
		return;
	}
	
	var resultCallback = function(data) {
		fUpdateOdrDlvrInfoResult_popDestMgmt(data);
	};

	callAjax("/odrMgmt/updateOdrDlvrInfo.do", "post", "json", true, $("#formDestMgmt").serialize(), resultCallback);
}


/** 배송 정보 수정 콜백 함수 */
function fUpdateOdrDlvrInfoResult_popDestMgmt(data) {
	
	if (data.result == "SUCCESS") {
		
		alert(data.resultMsg);		
		gfCloseModal()

	} else {
		// 오류 응답 메시지 출력
		alert(data.resultMsg);
	}
}