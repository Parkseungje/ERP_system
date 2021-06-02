var m_popCashPmtMgmt_execId = "";

$(function() {

	// 구매 Cash Keyup event
	$("#formCashPmtMgmt_cashPrc").keyup(function (e) {
		inputNumberFormat(this);
		var odrPrc = $(this).val();
		if (odrPrc == "") {
			odrPrc = 0;
		}
		
		$("#popCashPmtMgmt_odrPrc").text(odrPrc);	// 구매 Cash
		$("#popCashPmtMgmt_pmtAmut").text(odrPrc);	// 결제 예정금액
	});
	
	/* 무통장 입금 radio 버튼 선택 */
	$("#formCashPmtMgmt_dpsKndCod60").click(function (e) {
		$("#formCashPmtMgmt_DpsrNm").focus();
	});
	
	/* 임시 설정 */
	$("#formCashPmtMgmt_dpsKndCod50").click(function (e) {
		e.preventDefault();
		alert("실시간 계좌이체는 현재 준비중 입니다.\n당분간 무통장 입금을 해 주시기 바랍니다.");
	});
});


/** 화면 초기화 */
function fInitCashPmt() {
	
	$("#popCashPmtMgmt_cashAmut").text("0");		// 보유 Cash 초기화
	$("#formCashPmtMgmt_cashPrc").val("");			// 구매 Cash
	$("#popCashPmtMgmt_odrPrc").text("0");			// 구매 Cash(최종결제 정보)
	$("#popCashPmtMgmt_pmtAmut").text("0");		// 결제 예정금액
	
	$("input:radio[name='mop_dvs_cod']").prop("checked", false);	// 결제수단 선택 초기화
	$("#formCashPmtMgmt_crdKndCod").val("");		// 카드종류 선택 초기화
	$("input:radio[name='dps_knd_cod']").prop("checked", false);	// 현금결제 선택 초기화
	$("#formCashPmtMgmt_DpsrNm").val("");			// 입금자명 초기화
	
	// 결제취소규정 안내 초기화
	$("input:radio[name='pmt_cfm_a']").prop("checked", false);	// 결제수단 선택 초기화
	$("input:radio[name='pmt_cfm_b']").prop("checked", false);	// 결제수단 선택 초기화
}


/** 클리어 캐시 구매 팝업 */
function fpopCashPmtMtmt(viewId) {

	// 메인창 캐시 정보 id
	// 결제 후 캐시 정보 update
	if (viewId == null || viewId == "" || viewId == undefined) {
		m_popCashPmtMgmt_execId = "";
	} else {
		m_popCashPmtMgmt_execId = viewId;
	}
	
	// 화면 초기화
	fInitCashPmt();
	
	var param = {}
		
	var resultCallback = function(data) {
		fpopCashPmtMtmtResult(data);
	};

	callAjax("/odrMgmt/selectClearCash.do", "post", "json", true, param, resultCallback);
}


/** 클리어 캐시 구매 팝업 콜백 함수 */
function fpopCashPmtMtmtResult(data) {
	
	if (data.result == "SUCCESS") {

		var ofcCashModel = data.ofcCashModel;
		if (ofcCashModel == null || ofcCashModel == "" || ofcCashModel == undefined) {
			$("#popCashPmtMgmt_cashAmut").text("0");
		} else {
			$("#popCashPmtMgmt_cashAmut").text(comma(ofcCashModel.cash_amut));
		}
		
		// 모달 팝업
		gfModalPopTop("#popCashPmtMgmt");
		
		$("#formCashPmtMgmt_cashPrc").focus();
		
	} else {
		// 오류 응답 메시지 출력
		alert(data.resultMsg);
	}
}

/** 클리어 캐시 구매 결제 */
function fClearCashPmt_popCashPmtMgmt() {
	
	// 결제수단 선택
	// 결제구분이 즉시결제 및 결제 예정금액이 있을 경우 결제수단을 체크 한다.
	var pmtAmut = $("#popCashPmtMgmt_pmtAmut").text();	// 결제 예정 금액
	if (pmtAmut == null || pmtAmut == undefined || pmtAmut == "" || pmtAmut == "0") {
		alert("결제할 금액이 없습니다.\n구매 Cash를 입력 후 결제해 주세요.");
		$("#formCashPmtMgmt_cashPrc").focus();
		return;
	} else {
		pmtAmut = parseInt(uncomma(pmtAmut));
	}
	
	if (pmtAmut > 0) {
		
		// 결제수단 선택 체크
		var dspKndCod = $('input:radio[name="dps_knd_cod"]:checked').val();
		if (dspKndCod == "" || dspKndCod == undefined) {
			alert("결제 수단을 선택해 주세요.");
			return ;
		} else if (dspKndCod == "60") {
			var dpsrNm = $("#formCashPmtMgmt_DpsrNm").val();
			if(dpsrNm == "") {
				alert("입금자 성명을 입력해 주세요.");
				$("#formCashPmtMgmt_DpsrNm").focus();
				return;
			}
		}
	}
	
	// 결제 취소규정 체크 확인
	if (!$("#formCashPmtMgmt_pmtCfmA").is(":checked")) {
		alert("결제 취소규정 사항을 체크해 주세요.");
		$("#formCashPmtMgmt_pmtCfmA").focus();
		return;
	}
	
	if (!$("#formCashPmtMgmt_pmtCfmB").is(":checked")) {
		alert("결제 취소규정 사항을 체크해 주세요.");
		$("#formCashPmtMgmt_pmtCfmB").focus();
		return;
	}
	
	var cashPrc = parseInt(uncomma($("#popCashPmtMgmt_odrPrc").text()));	// 구매 캐시 수량
	$("#formCashPmtMgmt_fnlPmtAmut").val(pmtAmut);
	$("#formCashPmtMgmt_fnlOdrPrc").val(cashPrc);
	
	var resultCallback = function(data) {
		fClearCashPmtResult_popCashPmtMgmt(data);
	};
	
	callAjax("/odrMgmt/saveClearCashPmt.do", "post", "json", false, $("#formCashPmtMgmt").serialize(), resultCallback);
}


/** 클리어 캐시 구매 결제 콜백 함수 */
function fClearCashPmtResult_popCashPmtMgmt(data) {
	
	if (data.result == "SUCCESS") {

		// 메시지 출력
		var moDvsCod = $('input:radio[name="mop_dvs_cod"]:checked').val();
		var dpsKndCod = $('input:radio[name="dps_knd_cod"]:checked').val();
		
		var resultMsg = data.resultMsg;
		if (moDvsCod == "M" && dpsKndCod == "A") {
			resultMsg += "\n무통장 입금은 입금 완료 확인 시 Clear Cash가 적립 됩니다.";
		}		
		alert(resultMsg);
		
		// 메인에 클리어 캐시 금액 변경
		var ofcCashModel = data.ofcCashModel;
		var viewId = $("#formCashPmtMgmt_viewClrCash").val();
		if (viewId != null && viewId != "" && viewId != undefined) {
			$("#"+viewId).text(comma(ofcCashModel.cash_amut));
		}
		
		// 모달 닫기
		gfCloseModal();
		
	} else {
		// 오류 응답 메시지 출력
		alert(data.resultMsg);
	}
}