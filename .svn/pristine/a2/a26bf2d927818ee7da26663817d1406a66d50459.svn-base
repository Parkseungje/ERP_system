var m_popWrqPscgMgmt_execFunc = "";

$(function() {
	
});

/** 의뢰서 담당자 팝업 Open */
function fPopWrqPscgMgmt(wrqIdd, execFunc) {

	// 팝업 종료 후 실행 되어야 할 함수
	if (execFunc == null || execFunc == "" || execFunc == undefined) {
		m_popDlvrMgmt_execFunc = "";
	} else {
		m_popDlvrMgmt_execFunc = execFunc;
	}
	
	$("#formWrqPscgMgmt_wrqId").val(wrqIdd);
	
	var param = {
			wrq_id : wrqIdd
	}

	var resultCallback = function(data) {
		fPopWrqPscgMgmtResult(data);
	};

	callAjax("/actMgmt/initPopWrqPscgMgmt.do", "post", "json", true, param, resultCallback);
}

/** 의뢰서 담당자 팝업 Open 콜백 함수 */
function fPopWrqPscgMgmtResult(data) {

	if (data.result == "SUCCESS") {
		
		// 담당자 목록 select box 설정
		fSetPscgSstId(data, "");
		
		// 버튼 설정
		$("#popWrqPscgMgmt_btnAcceptWrq").show();
		$("#popWrqPscgMgmt_btnSaveWrqPscgMgmt").hide();
		$("#popWrqPscgMgmt_btnDeleteWrqPscgMgmt").hide();
		
		// 모달 팝업
		gfModalPopTop("#popWrqPscgMgmt");
		
	} else {
		// 오류 응답 메시지 출력
		alert(data.resultMsg);
	}
}


/** 담당자 저장 팝업 Open */
function fPopSavePscg(wrqId, pscgSstId, execFunc) {
	
	// 팝업 종료 후 실행 되어야 할 함수
	if (execFunc == null || execFunc == "" || execFunc == undefined) {
		m_popDlvrMgmt_execFunc = "";
	} else {
		m_popDlvrMgmt_execFunc = execFunc;
	}

	// 담당자 ID가 있으면 수정, 없으면 신규 등록 한다.
	$("#formWrqPscgMgmt_wrqId").val(wrqId);
	if (pscgSstId == "") {
		$("#formWrqPscgMgmt_action").val("I");
	} else {
		$("#formWrqPscgMgmt_action").val("U");
	}
	
	var param = {
			wrq_id : wrqId
	}

	var resultCallback = function(data) {
		fPopSavePscgResult(data, pscgSstId);
	};

	callAjax("/actMgmt/initPopWrqPscgMgmt.do", "post", "json", true, param, resultCallback);
}

/** 담당자 저장 팝업 Open 콜백 함수 */
function fPopSavePscgResult(data, pscgSstId) {
	
	if (data.result == "SUCCESS") {
		
		// 담당자 목록 select box 설정
		fSetPscgSstId(data, pscgSstId);
		
		// 버튼 설정
		$("#popWrqPscgMgmt_btnAcceptWrq").hide();
		$("#popWrqPscgMgmt_btnSaveWrqPscgMgmt").show();
		if (pscgSstId == "") {
			$("#popWrqPscgMgmt_btnDeleteWrqPscgMgmt").hide();
		} else { 
			$("#popWrqPscgMgmt_btnDeleteWrqPscgMgmt").show();
		}
		
		// 모달 팝업
		gfModalPopTop("#popWrqPscgMgmt");
		
	} else {
		// 오류 응답 메시지 출력
		alert(data.resultMsg);
	}
}


/** 의뢰서 접수 및 담당자 배정 */
function fAcceptWrqWithPscgMgmt() {
	
	var pscgSstId = $("#formWrqPscgMgmt_pscgSstId").val();
	if (pscgSstId == "") {
		alert("작업 담당자를 지정해 주세요.");
		$("#formWrqPscgMgmt_pscgSstId").focus();
		return;
	}
	
	var resultCallback = function(data) {
		fAcceptWrqWithPscgMgmtResult(data);
	};

	callAjax("/actMgmt/acceptWrq.do", "post", "json", true, $("#formWrqPscgMgmt").serialize(), resultCallback);
}


/** 의뢰서 접수 및 담당자 배정 콜백 함수 */
function fAcceptWrqWithPscgMgmtResult(data) {
	
	if (data.result == "SUCCESS") {
		
		alert(data.resultMsg);
		
		// 팝업창 종료
		gfCloseModal();
		
		// // 메인 목록 조회
		if (m_popDlvrMgmt_execFunc != null || m_popDlvrMgmt_execFunc != "" || m_popDlvrMgmt_execFunc == undefined) {
			eval(m_popDlvrMgmt_execFunc);
		}
		
	} else {
		// 오류 응답 메시지 출력
		alert(data.resultMsg);
	}
}


/** 의뢰서 담당자 저장 */
function fSaveWrqPscgMgmt() {

	var pscgSstId = $("#formWrqPscgMgmt_pscgSstId").val();
	if (pscgSstId == "") {
		alert("작업 담당자를 지정해 주세요.");
		$("#formWrqPscgMgmt_pscgSstId").focus();
		return;
	}
	
	var resultCallback = function(data) {
		fSaveWrqPscgMgmtResult(data);
	};

	callAjax("/actMgmt/saveWrqPscgMgmt.do", "post", "json", true, $("#formWrqPscgMgmt").serialize(), resultCallback);
}


/** 의뢰서 담당자 저장 콜백 함수 */
function fSaveWrqPscgMgmtResult(data) {

	if (data.result == "SUCCESS") {
		
		alert(data.resultMsg);
		
		// 팝업창 종료
		gfCloseModal();
		
		// // 메인 목록 조회
		if (m_popDlvrMgmt_execFunc != null || m_popDlvrMgmt_execFunc != "" || m_popDlvrMgmt_execFunc == undefined) {
			eval(m_popDlvrMgmt_execFunc);
		}
		
	} else {
		// 오류 응답 메시지 출력
		alert(data.resultMsg);
	}
}


/** 의뢰서 담당자 삭제 */
function fDeleteWrqPscgMgmt() {
	
	if (!confirm("의뢰서 작업 담당자를 삭제 하시겠습니까?")) return;
	
	var resultCallback = function(data) {
		fSaveWrqPscgMgmtResult(data);
	};

	callAjax("/actMgmt/deleteWrqPscgMgmt.do", "post", "json", true, $("#formWrqPscgMgmt").serialize(), resultCallback);
}


/** 의뢰서 담당자 삭제 콜백 함수 */
function fSaveWrqPscgMgmtResult(data) {

	if (data.result == "SUCCESS") {
		
		alert(data.resultMsg);
		
		// 팝업창 종료
		gfCloseModal();
		
		// // 메인 목록 조회
		if (m_popDlvrMgmt_execFunc != null || m_popDlvrMgmt_execFunc != "" || m_popDlvrMgmt_execFunc == undefined) {
			eval(m_popDlvrMgmt_execFunc);
		}
		
	} else {
		// 오류 응답 메시지 출력
		alert(data.resultMsg);
	}
}

/** 의뢰서 담당자 설정 */
function fSetPscgSstId(data, pscgSstId) {
	
	var listPscgInfo = data.listPscgInfo;
	$("#formWrqPscgMgmt_pscgSstId").find("option").remove();
	$("#formWrqPscgMgmt_pscgSstId").append("<option value=''>--담당자 선택--</option>");
	for (var i=0 ; i<listPscgInfo.length ; i++) {
		var model = listPscgInfo[i];
		$("#formWrqPscgMgmt_pscgSstId").append("<option value='"+model.USR_SST_ID+"'>"+model.USR_NM+"</option>");
	}
	
	$("#formWrqPscgMgmt_pscgSstId").val(pscgSstId).prop("selected", true);
}
