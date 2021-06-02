var m_popProdPmtMgmt_dlvrInfoMap = new Map();
var m_popProdPmtMgmt_godsModel = new Map();
var m_popProdPmtMgmt_salInfo = "";
var m_popProdPmtMgmt_currGodsModel = "";


/** OnLoad event */
$(function() {
	
	// 배송 정보 설정
	$(".tabPage").hide();
	$("#tab01").show();
	$('div.tab_area a').click(function(e) {
		e.preventDefault();

		var id = $(this).attr('href');
		
		// 배송 정보 탭 선택에 따라 상태값 저장
		if (id == "#tab01") {
			$("#formProdPmtMgmt_dlvrType").val("E");
		} else {
			$("#formProdPmtMgmt_dlvrType").val("N");
		}

		$("div.tab_area li").removeClass("on");
		$(".tabPage").hide();
		$(this).parents("li").addClass("on");
		$(id).show();
	});
	
	// 상악 수량 변경
	$("#formProdPmtMgmt_odrUpjQnty").keyup(function() {
		fSetPmtInfoForDvcMak();
	});
	
	// 하악 수량 변경
	$("#formProdPmtMgmt_odrLojQnty").keyup(function() {
		fSetPmtInfoForDvcMak();
	});
	
	// 추가 sheet 선택 설정
	$("#formProdPmtMgmt input:radio[name='odr_shet_poa']").click(function() {
		fSetPmtInfoForDvcMak();
	});
	
	// datepicker
	//$("#formProdPmtMgmt_dlvrScduDt").datepicker();
	
	// 달력버튼 datepicker
	//$('#popProdPmtMgmt_btnDlvrScduDt').bind('click', function() {
	//	$("#formProdPmtMgmt_dlvrScduDt").datepicker("show");
	//});
	
	// 결제구분 선택 설정
	$("#formProdPmtMgmt input:radio[name='eom_pmt_poa']").click(function(e) {
		var value = $(this).val();
		// N:즉시결제, Y:월말결제
		if (value == "N") {
			$("#popProdPmtMgmt_mopArea").show();	// 결제수단 show
		} else {
			$("#formProdPmtMgmt input:radio[name='mop_dvs_cod']").prop("checked", false);	// 결제수단 radio 초기화
			$("#formProdPmtMgmt input:radio[name='dps_knd_cod']").prop("checked", false);	// 현금결제 초기화
			$("#formProdPmtMgmt_dpsrNm").val("");															// 입금자명 초기화
			$("#popProdPmtMgmt_mopArea").hide();															// 결제수단 hide
			$("#popProdPmtMgmt_mopDvsCodAInfo").hide();												// 현금결제 상세 내용 hide
		} 
	});
	
	// 결제수단 선택 설정
	$("#formProdPmtMgmt input:radio[name='mop_dvs_cod']").click(function(e) {
		var value = $(this).val();
		// C:신용/체크카드, M:현금
		if (value == "C") {
			$("#popProdPmtMgmt_mopDvsCodAInfo").hide();	// 현금 결제
			/*
			e.preventDefault();
			alert("신용카드 및 실시간 계좌이체는 현재 준비중 입니다.\n당분간 무통장 입금을 해 주시기 바랍니다.");
			*/
		} else if (value == "M") {
			$("#popProdPmtMgmt_mopDvsCodAInfo").show();	// 현금 결제
		} 
	});
	
	// 무통장 입금 선택 시 입금자명 auto focus 설정
	$("#formProdPmtMgmt_dpsKndCodA").click(function (e) {
		$("#formProdPmtMgmt_dpsrNm").focus();
	});
	
	/* 임시 설정 */
	/*
	$("#formProdPmtMgmt_mopDvsCodC").click(function (e) {
		e.preventDefault();
		alert("신용카드 결제는 현재 준비중 입니다.\n당분간 무통장 입금을 해 주시기 바랍니다.");
	});
	*/
});


/** 결제 창 오픈 */
function fpopProdPmtMgmt(wrq_id) {
	
	// 의뢰서 id
	if (wrq_id == null || wrq_id == "" || wrq_id == undefined) {
		alert("결제 할 의뢰서를 먼저 선택해 주세요.");
		return false;
	}
	
	/* 화면 초기화 */
	m_popProdPmtMgmt_dlvrInfoMap.clear();													// 배송정보 초기화
	m_popProdPmtMgmt_godsModel.clear();													// 상품 전체정보 초기화
	m_popProdPmtMgmt_currGodsModel = "";													// 상품정보 초기화
	m_popProdPmtMgmt_salInfo = "";															// 할인정보 초기화

	$("#formProdPmtMgmt_wrqId").val(wrq_id);																		// 의뢰서 ID 설정
	$("#formProdPmtMgmt_pmtRcvrNm").val("");												// 받는분
	$("#formProdPmtMgmt_pmtPnn1").val("");													// 전화번호
	$("#formProdPmtMgmt_pmtPnn2").val("");													// 전화번호
	$("#formProdPmtMgmt_pmtPnn3").val("");													// 전화번호
	$("#formProdPmtMgmt_zcd").val("");														// 우편번호
	$("#formProdPmtMgmt_adrs").val("");														// 주소
	$("#formProdPmtMgmt_dtlAdrs").val("");													// 상세 주소
	$("#formProdPmtMgmt input:radio[name='odr_shet_poa']:input[value='N']").prop("checked", true);	// 추가 sheet 초기화
	$("#formProdPmtMgmt_cashPrc").val("");													// 클리어 캐시 사용금액 초기화
	$("#formProdPmtMgmt input:radio[name='eom_pmt_poa']:input[value='N']").prop("checked", true);	// 결제 구분 초기화
	$("#formProdPmtMgmt input:radio[name='mop_dvs_cod']").prop("checked", false);						// 결제수단 초기화
	$("#formProdPmtMgmt input:radio[name='dps_knd_cod']").prop("checked", false);						// 현금결제 초기화
	$("#popProdPmtMgmt_mopArea").show();													// 결제수단 show
	$("#formProdPmtMgmt_pmtCfmA").prop("checked", false);							// 취소규정 약관
	$("#formProdPmtMgmt_pmtCfmB").prop("checked", false);							// 취소규정 약관
	
	
	// 최근 의뢰서 조회
	var param = {
			wrq_id : wrq_id
	}
	
	var resultCallback = function(data) {
		fpopProdPmtMgmtResult(data);
	};

	callAjax("/makMgr/selectInitPmtInfo.do", "post", "json", false, param, resultCallback);
}


/** 결제 창 콜백 함수 */
function fpopProdPmtMgmtResult(data) {
	
	if (data.result == "SUCCESS") {

		/* 설정 데이터 초기화 */
		var wrq_dvs_cod = data.wrqModel.wrq_dvs_cod;
		
		// 상품 구분에 따른 결제 정보 설정
		$(data.listGodsModel).each(function (index, model) {
			m_popProdPmtMgmt_godsModel.put(model.gods_dvs_cod, model);
		});
		
		// 배송지 정보 설정
		fInitDlvrInfo(data.listDestInfoModel);
		
		var hirWrqId = data.wrqModel.hir_wrq_id;
		if (hirWrqId != null && hirWrqId != "" && hirWrqId != undefined) {
			m_popProdPmtMgmt_currGodsModel = m_popProdPmtMgmt_godsModel.get("R");
		} else {
			m_popProdPmtMgmt_currGodsModel = m_popProdPmtMgmt_godsModel.get(wrq_dvs_cod);
		} 
			
		// 장치제작 수량 설정
		$("#formProdPmtMgmt_odrUpjQnty").val(m_popProdPmtMgmt_currGodsModel.gods_qnty);	// 상악 수량
		$("#formProdPmtMgmt_odrLojQnty").val(m_popProdPmtMgmt_currGodsModel.gods_qnty);	// 하악 수량
		$("#formProdPmtMgmt_odrUpjQnty").attr("readonly", false); 
		$("#formProdPmtMgmt_odrLojQnty").attr("readonly", false);
		if (m_popProdPmtMgmt_currGodsModel.arch_dvs_cod == "A") {
			$("#formProdPmtMgmt_odrLojQnty").val("0");	// 하악 수량
			$("#formProdPmtMgmt_odrLojQnty").attr("readonly", true);
		} else if (m_popProdPmtMgmt_currGodsModel.arch_dvs_cod == "B") {
			$("#formProdPmtMgmt_odrUpjQnty").val("0");	// 상악 수량
			$("#formProdPmtMgmt_odrUpjQnty").attr("readonly", true);
		}
		
		$("#formProdPmtMgmt_pmtWrqDvsCod").val(wrq_dvs_cod);			// 의뢰 구분 코드 설정
		
		// 배송지 정보 영역 및 장치제작 수량 선택 Show/Hide 설정
		if (wrq_dvs_cod == "M") {
			$("#popProdPmtMgmt_deliveryArea").show();	// 배송지 영역 보임
			$("#popProdPmtMgmt_dvcMakArea").show();		// 장치제작 수량 선택 보임
			fSetPmtInfoForDvcMak();								// 장치제작 결제 가격 설정
			$("#popProdPmtMgmt_wkdInfoD").hide();			// 완료 요청 일자 설정 안내문
			$("#popProdPmtMgmt_wkdInfoM").show();		// 완료 요청 일자 설정 안내문
			
		} else {
			$("#popProdPmtMgmt_deliveryArea").hide();		// 배송지 영역 숨김
			$("#popProdPmtMgmt_dvcMakArea").hide();		// 장치제작 수량 선택 숨김
			fSetPmtInfoForPcsDsg();								// 정밀진단 결제 가격 설정
			$("#popProdPmtMgmt_wkdInfoD").show();		// 완료 요청 일자 설정 안내문
			$("#popProdPmtMgmt_wkdInfoM").hide();			// 완료 요청 일자 설정 안내문
		}
		
		var dlvrScduDt = data.wrqModel.dlvr_scdu_dt;
		if (data.ofcId == "OH170002") {
			$("#popProdPmtMgmt_btnDlvrScduDt").removeClass("hidden");
			$("#formProdPmtMgmt_dlvrScduDt").prop('readonly', false);
			
			$("#formProdPmtMgmt_dlvrScduDt").datepicker();
			$("#formProdPmtMgmt_dlvrScduDt").datepicker("setDate", new Date(Number(dlvrScduDt.substr(0,4)), Number(dlvrScduDt.substr(4,2)) -1, Number(dlvrScduDt.substr(6,2))));
			$('#popProdPmtMgmt_btnDlvrScduDt').bind('click', function() {
				$("#formProdPmtMgmt_dlvrScduDt").datepicker("show");
			});
		} else {
			$("#formProdPmtMgmt_dlvrScduDt").val(dlvrScduDt.substr(0,4) + "." + dlvrScduDt.substr(4,2) + "." + dlvrScduDt.substr(6,2));
		}

		/* 결제구분 선택 화면 설정*/
		// "N":즉시결제, "Y":월말결제
		if (m_popProdPmtMgmt_currGodsModel.eom_pmt_poa == "Y") {
			$("#popProdPmtMgmt_pmtDvsArea").show();	// 결제구분 선택 영역 보임
		} else {
			$("#popProdPmtMgmt_pmtDvsArea").hide();		// 결제구분 선택 영역 숨김
		}
		
		/* 보유캐시 설정*/
		$("#popProdPmtMgmt_cashAmut").text(comma(m_popProdPmtMgmt_currGodsModel.cash_amut));
		$("#popProdPmtMgmt_rmdCashAmutArea").hide();
		
		/* 결제수단 설정 */
		$("#popProdPmtMgmt_mopDvsCodAInfo").hide();	// 현금 결제
		
		
		/* LG Pay 정보 설정 */
		popProdPmtMgmt_fInitPayInfo(data.LGDPayInfoModel);
				
		// 모달 팝업
		gfModalPopTop("#popProdPmtMgmt");
		
	} else {
		// 오류 응답 메시지 출력
		alert(data.resultMsg);
	}
}


/** 배송지 정보 설정 */
function fInitDlvrInfo(listDestInfoModel) {

	// 기존 배송지 및 신규 배송지 탭 초기화
	$("#popProdPmtMgmt_btnListDest").empty();	// 화면 초기화
	m_popProdPmtMgmt_dlvrInfoMap.clear();			// 배송지 데이터 초기화

	var cssFocusClose = "focus_close";
	$(listDestInfoModel).each(function(index, model) {
		
		m_popProdPmtMgmt_dlvrInfoMap.put(model.snm, model);
		if (index == 0) {
			// 첫번째 배송지 설정
			fSetDlvrInfo(model.snm);
		} else {
			cssFocusClose = "";
		}
			
		var sbDestBtn = new StringBuffer();
		sbDestBtn.append("<span class='btnTypeBox "+cssFocusClose+"' id='popProdPmtMgmt_btnTypeBox_"+model.snm+"'>");
		sbDestBtn.append("<a class='name' href='javascript:fSetDlvrInfo(\""+model.snm+"\")'>"+model.rcvr_nm+"</a>");
		sbDestBtn.append("<a class='del' href='javascript:fDeleteDestInfo(\""+model.ofc_id+"\",\""+model.snm+"\")'></a>");
		sbDestBtn.append("</span>");
		
		$("#popProdPmtMgmt_btnListDest").append(sbDestBtn.toString());
	});
	
	//$("#popProdPmtMgmt_btnListDest").append("<a class='fr' href='#'>배송주소록 &gt; </a>");
	
	// 기존 배송지 등록 되어 있을 경우 기존 배송지로 초기 설정
	if ($(listDestInfoModel).size() > 0 ) {		
		$("#btnTab01").addClass("on");
		$("#tab01").show();
		$("#btnTab02").removeClass("on");
		$("#tab02").hide();
		$("#formProdPmtMgmt_dlvrType").val("E");
	} else {
		$("#btnTab01").removeClass("on");
		$("#tab01").hide();
		$("#btnTab02").addClass("on");
		$("#tab02").show();
		$("#formProdPmtMgmt_dlvrType").val("N");
		
		$("#popProdPmtMgmt_rcvrNm").text("등록된 배송지가 없습니다.");
		$("#popProdPmtMgmt_pnn").text("");
		$("#popProdPmtMgmt_adrs").text("");
		$("#popProdPmtMgmt_zcd").text("");
	}
}


/** 정밀진단 결제 정보 설정 */
function fSetPmtInfoForPcsDsg() {
	
	var pmt_odr_amut = 0;		// 의뢰 가격
	var pmt_sal_amut = 0;		// 할인 가격
	
	pmt_odr_amut = m_popProdPmtMgmt_currGodsModel.gods_qnty * m_popProdPmtMgmt_currGodsModel.gods_prc;	// 의뢰 가격
	pmt_sal_amut = 0;		// 할인 가격
	
	/* 의뢰정보 */
	// 제작구분
	$("#popProdPmtMgmt_pmtWrqDvsCodNm").text(m_popProdPmtMgmt_currGodsModel.wrq_dvs_cod_nm);
	
	// 주문 상세 정보
	$("#popProdPmtMgmt_pmtOdrInfo").empty();
	
	var sbPmtOdrInfo = new StringBuffer();
	sbPmtOdrInfo.append("<li> - 단가 : " + comma(m_popProdPmtMgmt_currGodsModel.gods_prc) + " 원</li>");	// 정상 단가
	sbPmtOdrInfo.append("<li> - 수량 : " + m_popProdPmtMgmt_currGodsModel.gods_qnty + " EA</li>");			// 수량
	$("#popProdPmtMgmt_pmtOdrInfo").append(sbPmtOdrInfo.toString());										// 의뢰정보 출력
	$("#popProdPmtMgmt_pmtOdrAmut").text(comma(pmt_odr_amut));											// 총금액
	

	/* 최종결제 정보*/
	$("#popProdPmtMgmt_pmtOdrPrc").text(comma(pmt_odr_amut));	// 의뢰가격
	m_popProdPmtMgmt_salInfo = "";	// 할인가격 상세정보 초기화
	
	// Y:할인적용, N:할인 미적용
	if (m_popProdPmtMgmt_currGodsModel.sal_psb_poa == "Y") {
		pmt_sal_amut = (m_popProdPmtMgmt_currGodsModel.gods_prc - m_popProdPmtMgmt_currGodsModel.gods_sal_prc) * m_popProdPmtMgmt_currGodsModel.gods_qnty;	// 할인 가격
		$("#popProdPmtMgmt_pmtSalAmut").text(comma(pmt_sal_amut));	// 할인가격
		$("#popProdPmtMgmt_pmtSalInfo").remove();
		
		// 할인 상세 정보
		var sbPmtSalInfo = new StringBuffer();
		sbPmtSalInfo.append("<div class=\"sub\" id=\"popProdPmtMgmt_pmtSalInfo\">");
		sbPmtSalInfo.append("	<dl>");
		sbPmtSalInfo.append("		<dt>- VIP할인("+m_popProdPmtMgmt_currGodsModel.sal_rat+"%)</dt>");
		sbPmtSalInfo.append("		<dd>"+comma(pmt_sal_amut)+"원</dd>");
		sbPmtSalInfo.append("	</dl>");
		sbPmtSalInfo.append("</div>");
		$("#popProdPmtMgmt_pmtFnlPmtInfo").append(sbPmtSalInfo.toString());
		
		// 할인가격 상세 정보
		m_popProdPmtMgmt_salInfo += "V|VIP 할인("+m_popProdPmtMgmt_currGodsModel.sal_rat+"%)|"+m_popProdPmtMgmt_currGodsModel.sal_rat+"|"+pmt_sal_amut+"|"+m_popProdPmtMgmt_currGodsModel.sal_psb_poa+"|N";
		
		
	} else {
		pmt_sal_amut = 0;
		$("#popProdPmtMgmt_pmtSalAmut").text(0);	// 할인가격
		$("#popProdPmtMgmt_pmtSalInfo").remove();	// 할인 정보 삭제
	}
	
	$("#popProdPmtMgmt_pmtClrCashPmtAmut").text(0);	// 클리어 캐시 사용 금액
	$("#popProdPmtMgmt_pmtPmtAmut").text(comma(pmt_odr_amut - pmt_sal_amut));	// 결제 예정 금액
	$("#formProdPmtMgmt_pmtAmut").val(pmt_odr_amut - pmt_sal_amut);						// 결제 예정 금액(hidden)
	
	// 상품정보
	$("#formProdPmtMgmt_godsId").val(m_popProdPmtMgmt_currGodsModel.gods_id);		// 상품 ID
	$("#formProdPmtMgmt_orgPrc").val(m_popProdPmtMgmt_currGodsModel.gods_prc);	// 상품 정상 단가
	$("#formProdPmtMgmt_shetOrgPrc").val(0);	// 추가시트 상품 정상 단가
}


/** 장치제작 결제 정보 설정 */
function fSetPmtInfoForDvcMak() {

	var godsModelSheet = m_popProdPmtMgmt_godsModel.get("A");
	
	// arch 수량
	var odr_qnty = 0;
	if (m_popProdPmtMgmt_currGodsModel.arch_dvs_cod == "A" || m_popProdPmtMgmt_currGodsModel.arch_dvs_cod == "C") {
		var odr_upj_qnty = $("#formProdPmtMgmt_odrUpjQnty").val();
		odr_qnty += parseInt(odr_upj_qnty==""?"0":odr_upj_qnty);	// 상악 수량
	}
	
	if (m_popProdPmtMgmt_currGodsModel.arch_dvs_cod == "B" || m_popProdPmtMgmt_currGodsModel.arch_dvs_cod == "C") {
		var odr_loj_qnty = $("#formProdPmtMgmt_odrLojQnty").val();
		odr_qnty += parseInt(odr_loj_qnty==""?"0":odr_loj_qnty);	// 하악 수량
	}
	
	// 추가시트 arch 수량
	var odr_sheet_qnty = 0;
	var odr_shet_poa = $('#formProdPmtMgmt input:radio[name="odr_shet_poa"]:checked').val();
	if (odr_shet_poa == "Y") {
		odr_sheet_qnty = odr_qnty;
	}
	
	var pmt_odr_amut = 0;		// 의뢰 가격
	var pmt_sal_amut = 0;		// 할인 가격
	
	// 의뢰 가격
	pmt_odr_amut = odr_qnty * m_popProdPmtMgmt_currGodsModel.gods_prc;		
	pmt_odr_amut +=  odr_sheet_qnty * godsModelSheet.gods_prc;
	
	/* 의뢰정보 */
	// 제작구분
	$("#popProdPmtMgmt_pmtWrqDvsCodNm").text(m_popProdPmtMgmt_currGodsModel.gods_nm);
	
	// 주문 상세 정보
	$("#popProdPmtMgmt_pmtOdrInfo").empty();
	var sbPmtOdrInfo = new StringBuffer();
	sbPmtOdrInfo.append("<li> - 치아 구분 : " + comma(m_popProdPmtMgmt_currGodsModel.arch_dvs_cod_nm) + "</li>");
	sbPmtOdrInfo.append("<li> - 수량 : " + odr_qnty  + " arch</li>");
	sbPmtOdrInfo.append("<li> - 단가 : " + comma(m_popProdPmtMgmt_currGodsModel.gods_prc) + " 원</li>");
	sbPmtOdrInfo.append("<li> - 추가 sheet 수량 : " + odr_sheet_qnty + " arch</li>");
	sbPmtOdrInfo.append("<li> - 추가 sheet 단가 : " + comma(godsModelSheet.gods_prc) + " 원</li>");
	
	$("#popProdPmtMgmt_pmtOdrInfo").append(sbPmtOdrInfo.toString());	// 의뢰정보 출력
	$("#popProdPmtMgmt_pmtOdrAmut").text(comma(pmt_odr_amut));		// 총금액
	
	/* 최종결제 정보*/
	// 의뢰 가격
	$("#popProdPmtMgmt_pmtOdrPrc").text(comma(pmt_odr_amut));

	// 할인 가격
	$("#popProdPmtMgmt_pmtSalAmut").text(0);	// 할인가격
	
	// 할인가격 정보
	$("#popProdPmtMgmt_pmtSalInfo").remove();
	
	// + VIP 할인
	var vip_sal_amut = 0;
	var mak_sal_poa = 'N';
	var shet_sal_poa = 'N';
	
	var rmk_sal_amut = 0;
	var rmk_sal_cnt = 0;
	
	// 상품별 할인 정보 설정
	if (m_popProdPmtMgmt_currGodsModel.gods_dvs_cod == "M") {

		// - 장치 제작
		// - Y:할인적용, N:할인 미적용
		if (m_popProdPmtMgmt_currGodsModel.sal_psb_poa == "Y") {
			var sal_amut = parseInt(m_popProdPmtMgmt_currGodsModel.gods_prc) - parseInt(m_popProdPmtMgmt_currGodsModel.gods_sal_prc);	// 할인 단가
			vip_sal_amut += sal_amut * odr_qnty;	// 총 할인 금액
			mak_sal_poa = "Y";
		}
		
	} else if (m_popProdPmtMgmt_currGodsModel.gods_dvs_cod == "R") {
	
		// - remake 할인 갯수를 구한다.
		if (m_popProdPmtMgmt_currGodsModel.rmk_sal_num >  m_popProdPmtMgmt_currGodsModel.odr_rmk_num) {
			
			rmk_sal_cnt = m_popProdPmtMgmt_currGodsModel.rmk_sal_num -  m_popProdPmtMgmt_currGodsModel.odr_rmk_num;
			
			// 리메이크 할인 갯수보다 주문갯수가 클경우 리메이크 할인 갯수를 적용한다.
			// 그외의 경우 주문 갯수모두 할인 갯수로 적용한다.
			if (odr_qnty >= rmk_sal_cnt) {
				rmk_sal_amut = rmk_sal_cnt * m_popProdPmtMgmt_currGodsModel.gods_sal_prc;
			} else {
				rmk_sal_cnt = odr_qnty;
				rmk_sal_amut = rmk_sal_cnt * m_popProdPmtMgmt_currGodsModel.gods_sal_prc;
			}
		}
	}
	
	// - 추가 시트
	// - Y:할인적용, N:할인 미적용
	if (godsModelSheet.sal_psb_poa == "Y") {
		var sal_amut = parseInt(godsModelSheet.gods_prc) - parseInt(godsModelSheet.gods_sal_prc);	// 할인 단가
		vip_sal_amut += sal_amut * odr_qnty;	// 총 할인 금액
		shet_sal_poa = "Y";
	}
	
	// + 정밀진단 할인
	var pcdg_sal_amut = 0;
	
	// - 상악 step
	var odr_upj_qnty = $("#formProdPmtMgmt_odrUpjQnty").val();
	odr_upj_qnty = parseInt(odr_upj_qnty==""?"0":odr_upj_qnty);
	
	// - 하악 step
	var odr_loj_qnty = $("#formProdPmtMgmt_odrLojQnty").val();
	odr_loj_qnty = parseInt(odr_loj_qnty==""?"0":odr_loj_qnty);
	

	// - 누적 arch 수 + 주문 arch 수
	var odr_stp_num = 0;
	odr_stp_num = odr_upj_qnty + odr_loj_qnty;
	
	// - 누적 step이 기준 step보다 크거나 같을 경우 할인 적용
	odr_stp_num += parseInt(m_popProdPmtMgmt_currGodsModel.odr_stp_num);
	if (parseInt(m_popProdPmtMgmt_currGodsModel.pcdg_sal_stp_qnty) <= odr_stp_num) {
		pcdg_sal_amut = parseInt(m_popProdPmtMgmt_currGodsModel.pcdg_sal_prc);
	}
	
	// + 총 할인 금액
	pmt_sal_amut = vip_sal_amut + pcdg_sal_amut + rmk_sal_amut;
	
	// - 총 할인 금액 정보 Header
	m_popProdPmtMgmt_salInfo = "";	// 할인가격 상세 정보
	
	
	var sbPmtSalInfo = new StringBuffer();
	if (pmt_sal_amut > 0) {
		sbPmtSalInfo.append("<div class=\"sub\" id=\"popProdPmtMgmt_pmtSalInfo\">");
	}
	
	// - VIP 할인
	if (vip_sal_amut > 0) {
		sbPmtSalInfo.append("	<dl>");
		sbPmtSalInfo.append("		<dt>- VIP할인("+m_popProdPmtMgmt_currGodsModel.sal_rat+"%) : </dt>");
		sbPmtSalInfo.append("		<dd>"+comma(vip_sal_amut)+" 원</dd>");
		sbPmtSalInfo.append("	</dl>");
		
		m_popProdPmtMgmt_salInfo += "V|VIP 할인("+m_popProdPmtMgmt_currGodsModel.sal_rat+"%)|"+m_popProdPmtMgmt_currGodsModel.sal_rat+"|"+vip_sal_amut+"|"+mak_sal_poa+"|"+shet_sal_poa;
	}
	
	// - 정밀진단 할인
	if (pcdg_sal_amut > 0) {
		sbPmtSalInfo.append("	<dl>");
		sbPmtSalInfo.append("		<dt>- 정밀진단 : </dt>");
		sbPmtSalInfo.append("		<dd>"+comma(pcdg_sal_amut)+" 원</dd>");
		sbPmtSalInfo.append("	</dl>");
		
		m_popProdPmtMgmt_salInfo += "^D|정밀진단|0|"+pcdg_sal_amut+"|Y|N";
	}
	
	// - 리메이크 할인
	if (rmk_sal_amut > 0) {
		sbPmtSalInfo.append("	<dl>");
		sbPmtSalInfo.append("		<dt>- 리메이크 : </dt>");
		sbPmtSalInfo.append("		<dd>"+comma(rmk_sal_amut)+" 원</dd>");
		sbPmtSalInfo.append("	</dl>");
		
		m_popProdPmtMgmt_salInfo += "^R|리메이크|"+rmk_sal_cnt+"|"+rmk_sal_amut+"|Y|N";
	}
	
	// - 총 할인 금액 정보 Tail
	if (pmt_sal_amut > 0) {
		sbPmtSalInfo.append("</div>");
		$("#popProdPmtMgmt_pmtFnlPmtInfo").append(sbPmtSalInfo.toString());
		$("#popProdPmtMgmt_pmtSalAmut").text(comma(pmt_sal_amut));	// 할인가격
	}
	
	$("#popProdPmtMgmt_pmtClrCashPmtAmut").text(0);	// 클리어 캐시 사용 금액
	$("#popProdPmtMgmt_pmtPmtAmut").text(comma(pmt_odr_amut - pmt_sal_amut));	// 결제 예정 금액
	$("#formProdPmtMgmt_pmtAmut").val(pmt_odr_amut - pmt_sal_amut);						// 결제 예정 금액(hidden)
	
	// 상품정보
	$("#formProdPmtMgmt_godsId").val(m_popProdPmtMgmt_currGodsModel.gods_id);		// 상품 ID
	$("#formProdPmtMgmt_orgPrc").val(m_popProdPmtMgmt_currGodsModel.gods_prc);	// 상품 정상 단가	
	$("#formProdPmtMgmt_shetOrgPrc").val(godsModelSheet.gods_prc);	// 추가시트 상품 정상 단가
}


/** 버튼 선택된 배송지 정보 설정 */
function fSetDlvrInfo(snm) {
	
	// 선택버튼 CSS 설정
	var elements = $("#popProdPmtMgmt_btnListDest").children("span");
	$(elements).each(function(index, element) {
		$(element).removeClass("focus_close");
	}); 
	$("#popProdPmtMgmt_btnTypeBox_"+snm).addClass("focus_close"); 

	// 선택 데이터 설정
	var model = m_popProdPmtMgmt_dlvrInfoMap.get(snm);
	$("#popProdPmtMgmt_rcvrNm").text(model.rcvr_nm);
	$("#popProdPmtMgmt_pnn").text(model.pnn_1+"-"+model.pnn_2+"-"+model.pnn_3);
	$("#popProdPmtMgmt_adrs").text(model.adrs+" "+model.dtl_adrs);
	$("#popProdPmtMgmt_zcd").text(model.zcd);
	
	// 선택된 배송지 정보 설정
	$("#formProdPmtMgmt_pmtDlvrSnm").val(snm);
}


/** 배송지 정보 삭제 */
function fDeleteDestInfo(ofc_id, snm) {
	
	var param = {
				ofc_id : ofc_id
			,	snm : snm
	}
	
	var resultCallback = function(data) {
		fDeleteDestInfoResult(data);
	};

	callAjax("/makMgr/deleteDestInfo.do", "post", "json", false, param, resultCallback);
	
}

/** 배송지 정보 삭제 콜백 함수 */
function fDeleteDestInfoResult(data) {

	if (data.result == "SUCCESS") {
		
		// 배송지 정보 설정
		fInitDlvrInfo(data.listDestInfoModel);
		
	} else {
		alert(data.resultMsg);
	}
}

/** 클리어 캐시 사용*/
function fUseClrCash() {
	
	var cash_prc = $("#formProdPmtMgmt_cashPrc").val();										// 캐시 사용 금액 <input>

	if (cash_prc == "" || cash_prc == "0") {
		cash_prc = 0;
		$("#popProdPmtMgmt_rmdCashAmutArea").hide();
	} else {
		$("#popProdPmtMgmt_rmdCashAmutArea").show();
	}

	cash_prc = parseInt(uncomma(cash_prc));															// 캐시 사용 금액 <input>
	var cash_amut = parseInt(uncomma($("#popProdPmtMgmt_cashAmut").text()));								// 보유 캐시
	var clr_cash_pmt_amut = parseInt(uncomma($("#popProdPmtMgmt_pmtClrCashPmtAmut").text()));	// 결제 예정 캐시 금액
	var pmt_amut = parseInt($("#formProdPmtMgmt_pmtAmut").val());													// 결제 예정금액

	if (cash_amut < cash_prc) {
		alert("보유한 Clear Cash보다 사용 Cash가 많습니다.\n보유한 Cash보다 적거나 같게 사용해 주세요.");
		$("#formProdPmtMgmt_cashPrc").focus();
		return;
	}
	
	if (pmt_amut < cash_prc) {
		var bConfirm = confirm("Clear Cash 사용 액이 결제 예정금액보다 많습니다.\n결제 예정금액만큼 사용 하시겠습니까?");
		if (bConfirm) {
			cash_prc = pmt_amut;
			$("#formProdPmtMgmt_cashPrc").val(cash_prc);
		} else {
			$("#formProdPmtMgmt_cashPrc").val("");
			cash_prc = 0;
		}
	}
	
	$("#popProdPmtMgmt_pmtClrCashPmtAmut").text(comma(cash_prc));			// 결제 예정 캐시 금액
	$("#popProdPmtMgmt_pmtPmtAmut").text(comma(pmt_amut - cash_prc));		// 결제 예정금액
	$("#popProdPmtMgmt_rmdCashAmut").text(comma(cash_amut - cash_prc));	// 잔여 캐시
}


/** 클리어 캐시 모두 사용 */
function fUseClrCashAll() {
	
	
	var cash_amut = parseInt(uncomma($("#popProdPmtMgmt_cashAmut").text()));								// 보유 캐시
	var pmt_amut = parseInt($("#formProdPmtMgmt_pmtAmut").val());													// 결제 예정금액
	var cash_prc = 0;
	
	// 보유캐시보다 결제 예정금액이 클 경우 보유 캐시 모두 사용
	if (cash_amut < pmt_amut) {
		cash_prc = cash_amut;
	} else {
		cash_prc = pmt_amut;
	}
	
	// 잔여 캐시 보이고 감추기
	if (cash_prc == 0) {
		$("#popProdPmtMgmt_rmdCashAmutArea").hide();
	} else {
		$("#popProdPmtMgmt_rmdCashAmutArea").show();
	}
	
	$("#popProdPmtMgmt_pmtClrCashPmtAmut").text(comma(cash_prc));			// 결제 예정 캐시 금액
	$("#formProdPmtMgmt_cashPrc").val(cash_prc);
	$("#popProdPmtMgmt_pmtPmtAmut").text(comma(pmt_amut - cash_prc));		// 결제 예정금액
	$("#popProdPmtMgmt_rmdCashAmut").text(comma(cash_amut - cash_prc));	// 잔여 캐시
}


/** 의뢰서 주문 결제 */
function fWrqOdrPmt() {
	
	// 의뢰서 구분 코드
	// D:정밀진단, W:장치제작
	var wrq_dvs_cod = $("#formProdPmtMgmt_pmtWrqDvsCod").val();
	var dlvr_type = $("#formProdPmtMgmt_dlvrType").val();
	
	/* validation check*/
	// 배송지 주소 체크
	// 의뢰서 구분 코드 ( "D":정밀진단, "M":장치제작)
	if ((wrq_dvs_cod == "M") && (dlvr_type == "N")) {
		
		if ($("#formProdPmtMgmt_pmtRcvrNm").val() == "") {
			alert("받는분을 입력해 주세요.");
			$("#formProdPmtMgmt_pmtRcvrNm").focus();
			return;
		}
		
		if ($("#formProdPmtMgmt_pmtPnn1").val() == "") {
			alert("전화번호를 입력해 주세요.");
			$("#formProdPmtMgmt_pmtPnn1").focus();
			return;
		}
		
		if ($("#formProdPmtMgmt_pmtPnn2").val() == "") {
			alert("전화번호를 입력해 주세요.");
			$("#formProdPmtMgmt_pmtPnn2").focus();
			return;
		}
		
		if ($("#formProdPmtMgmt_pmtPnn3").val() == "") {
			alert("전화번호를 입력해 주세요.");
			$("#formProdPmtMgmt_pmtPnn3").focus();
			return;
		}
		
		if ($("#formProdPmtMgmt_zcd").val() == "") {
			alert("우편번호를 입력해 주세요.");
			$("#formProdPmtMgmt_zcd").focus();
			return;
		}
		
		if ($("#formProdPmtMgmt_adrs").val() == "") {
			alert("주소를 입력해 주세요.");
			$("#formProdPmtMgmt_adrs").focus();
			return;
		}
		
		if ($("#formProdPmtMgmt_dtlAdrs").val() == "") {
			alert("상세 주소를 입력해 주세요.");
			$("#formProdPmtMgmt_dtlAdrs").focus();
			return;
		}
	}
	
	// 장치제작 수량 선택
	if (wrq_dvs_cod == "M") {
		var archDvsCod = m_popProdPmtMgmt_currGodsModel.arch_dvs_cod;
		
		if (archDvsCod == "A" || archDvsCod == "C") {
			var odr_upj_qnty = $("#formProdPmtMgmt_odrUpjQnty").val();
			if (odr_upj_qnty == "" || odr_upj_qnty == "0") {
				alert("상악 Step 수량을 입력해 주세요.");
				$("#formProdPmtMgmt_odrUpjQnty").focus();
				return;
			}
		}
		
		if (archDvsCod == "B" || archDvsCod == "C") {
			var odr_loj_qnty = $("#formProdPmtMgmt_odrLojQnty").val();
			if (odr_loj_qnty == "" || odr_loj_qnty == "0") {
				alert("하악 Step 수량을 입력해 주세요.");
				$("#formProdPmtMgmt_odrLojQnty").focus();
				return;
			}
		}
	}
	
	// 의뢰 완료 요청 일자
	/*
	var dlvrScduDt = $("#formProdPmtMgmt_dlvrScduDt").val();
	if (dlvrScduDt == "") {
		alert("의뢰 완료 요청 일자를 입력해 주세요.");
		$("#formProdPmtMgmt_dlvrScduDt").focus();
		return;
	} else {
		if (!g_fCheckDateFormat(dlvrScduDt)) {
			alert("의뢰 완료 요청일자가 날짜 형식이 아닙니다.\n날짜를 다시 확인해 주세요.");
			$("#formProdPmtMgmt_dlvrScduDt").focus();
			return;
		}
	}
	*/
	
	
	// 결제구분 선택
	var eom_pmt_poa = $("#formProdPmtMgmt input:radio[name='eom_pmt_poa']:checked").val();
	if (eom_pmt_poa == "" || eom_pmt_poa == undefined) {
		alert("결제구분을 선택해 주세요.");
		$("#eom_pmt_poa").focus();
		return;
	}
	
	// 결제수단 선택
	// 결제구분이 즉시결제 및 결제 예정금액이 있을 경우 결제수단을 체크 한다.
	var pmt_amut = parseInt(uncomma($("#popProdPmtMgmt_pmtPmtAmut").text()));	// 결제 예정 금액
	if (eom_pmt_poa == "N" && pmt_amut > 0) {
		
		// 결제수단 선택 체크
		var mop_dvs_cod = $("#formProdPmtMgmt input:radio[name='mop_dvs_cod']:checked").val();
		if (mop_dvs_cod == "" || mop_dvs_cod == undefined) {
			alert("결제수단을 선택해 주세요.");
			$("#formProdPmtMgmt_mopDvsCodC").focus();
			return ;
		}
		
		// 결제수단 별 하위 구성 체크
		//	C:신용/체크카드 결제, M:현금 결제
		if (mop_dvs_cod == "M") {
			var dps_knd_cod = $("#formProdPmtMgmt input:radio[name='dps_knd_cod']:checked").val();
			if (dps_knd_cod == "" || dps_knd_cod == undefined) {
				alert("현금결제 할 방법을 선택해 주세요.");
				$("#dps_knd_cod").focus();
				return;
			} else if (dps_knd_cod == "60") {
				if ($("#formProdPmtMgmt_dpsrNm").val() == "") {
					alert("무통장 입금자 명을 입력해 주세요.");
					$("#formProdPmtMgmt_dpsrNm").focus();
					return;
				}
			}
		}
	}
	
	// 결제 취소규정 체크 확인
	if (!$("#formProdPmtMgmt_pmtCfmA").is(":checked")) {
		alert("결제 취소규정 사항을 체크해 주세요.");
		$("#formProdPmtMgmt_pmtCfmA").focus();
		return;
	}
	
	if (!$("#formProdPmtMgmt_pmtCfmB").is(":checked")) {
		alert("결제 취소규정 사항을 체크해 주세요.");
		$("#formProdPmtMgmt_pmtCfmB").focus();
		return;
	}
	
	// 결제 정보 설정
	$("#formProdPmtMgmt_salInfo").val(m_popProdPmtMgmt_salInfo);																// 세일 상세 정보
	$("#formProdPmtMgmt_odrAmut").val(uncomma($("#popProdPmtMgmt_pmtOdrAmut").text()));						// 의뢰 금액
	$("#formProdPmtMgmt_salAmut").val(uncomma($("#popProdPmtMgmt_pmtSalAmut").text()));						// 할인 금액
	$("#formProdPmtMgmt_clrCashPmtAmut").val(uncomma($("#popProdPmtMgmt_pmtClrCashPmtAmut").text()));	// Clear Cash 사용 금액
	$("#formProdPmtMgmt_pmtScduAmut").val(uncomma($("#popProdPmtMgmt_pmtPmtAmut").text()));				// 결제 예정금액
	
	
	// VAN 결제 유무에 따른 결제 경로 지정
	// VAN 공유
	//		1. 즉시 결제일 경우
	//		2. 결제 금액이 있을 경우
	// VAN 미공유
	//		1. 월말결제일 경우
	//		2. 결제 금액이 없는 경우(100% Clear Cash 결제)
	/* VAN 미공유 결제 */
	if (eom_pmt_poa == "N" && mop_dvs_cod == "C" && pmt_amut > 0 ) {

		var odr_amut = $("#formProdPmtMgmt_pmtScduAmut").val();
		
		/* VAN 공유 결제*/
		var param = {
				odr_amut : odr_amut
		}
		
		var resultCallback = function(data) {
			fLaunchCrossPlatform(data);
		};
		
		callAjax("/PGMgmt/pgOdrIdInfo.do", "post", "json", false, param, resultCallback);
		
	} else {
		
		/* VAN 미공유 결제 */
		var resultCallback = function(data) {
			fWrqOdrPmtResult(data);
		};
		
		callAjax("/makMgr/saveWrqOdrPmt.do", "post", "json", false, $("#formProdPmtMgmt").serialize(), resultCallback);
	}
}

/** 의뢰서 주문 결제 콜백 함수 */
function fWrqOdrPmtResult(data) {
	
	if (data.result == "SUCCESS") {
		alert(data.resultMsg);
		
		// 새로운 배송지 화면 초기화
		fInitOdrDlvrInfo();
		
		// 의뢰서 목록 조회
		fListWrq();
		
		// 모달 닫기
		gfCloseModal();
		
	} else {
		alert(data.resultMsg);
	}
}


/** 새로운 배송지 화면 초기화 */
function fInitOdrDlvrInfo() {
	$("#formProdPmtMgmt_pmtRcvrNm").val("");
	$("#formProdPmtMgmt_pmtPnn1").val("");
	$("#formProdPmtMgmt_pmtPnn2").val("");
	$("#formProdPmtMgmt_pmtPnn3").val("");
	//$("#pmt_zcd").val("");
	//$("#pmt_adrs").val("");
	//$("#pmt_dtl_adrs").val("");
}


/*****************************************************
 * LG Pay 결제
 *****************************************************/
var LGD_window_type = "";

/* LG Pay 정보 설정 */
function popProdPmtMgmt_fInitPayInfo(LGDPayInfoModel) {
	
	LGD_window_type = LGDPayInfoModel.lgd_window_type;
	$("#formProdPmtMgmtPayinfo_LGD_CUSTOM_PROCESSTYPE").val(LGDPayInfoModel.lgd_custom_processtype);
	$("#formProdPmtMgmtPayinfo_LGD_MID").val((LGDPayInfoModel.cst_platform.trim() == "test"?"t":"")+LGDPayInfoModel.cst_mid);
	$("#formProdPmtMgmtPayinfo_LGD_WINDOW_VER").val(LGDPayInfoModel.lgd_window_ver);
	$("#formProdPmtMgmtPayinfo_CST_PLATFORM").val(LGDPayInfoModel.cst_platform);
	$("#formProdPmtMgmtPayinfo_LGD_CASNOTEURL").val(LGDPayInfoModel.lgd_casnoteurl);
	$("#formProdPmtMgmtPayinfo_LGD_CUSTOM_SKIN").val(LGDPayInfoModel.lgd_custom_skin);
	$("#formProdPmtMgmtPayinfo_CST_MID").val(LGDPayInfoModel.cst_mid);
	$("#formProdPmtMgmtPayinfo_LGD_WINDOW_TYPE").val(LGDPayInfoModel.lgd_window_type);
	$("#formProdPmtMgmtPayinfo_LGD_VERSION").val(LGDPayInfoModel.lgd_version);
	$("#formProdPmtMgmtPayinfo_LGD_OSTYPE_CHECK").val(LGDPayInfoModel.lgd_ostype_check);
	$("#formProdPmtMgmtPayinfo_LGD_CUSTOM_SWITCHINGTYPE").val(LGDPayInfoModel.lgd_custom_switchingtype);
	$("#formProdPmtMgmtPayinfo_LGD_RETURNURL").val(LGDPayInfoModel.lgd_returnurl);
	$("#formProdPmtMgmtPayinfo_LGD_CASNOTEURL").val(LGDPayInfoModel.lgd_casnoteurl);
}

	
/*
* 수정불가
*/
function fLaunchCrossPlatform(data) {

	// LGD Pay 결제수단 설정
	var lgdCustomUsablepay = "";
	var mopDvsCod = $("#formProdPmtMgmt input:radio[name='mop_dvs_cod']:checked").val();
	if (mopDvsCod == "C") {
		lgdCustomUsablepay = "SC0010";
	} else if (mopDvsCod == "M") {
		var dpsKndCod = $("#formProdPmtMgmt input:radio[name='dps_knd_cod']:checked").val();
		if (dpsKndCod == "50") {
			lgdCustomUsablepay = "SC0030";
		} else if (dpsKndCod == "60") {
			lgdCustomUsablepay = "SC0040";
		}
	}
	
	
	// 상품명 설정
	var prodInfo = "";
	var wrqDvsCod = m_popProdPmtMgmt_currGodsModel.gods_dvs_cod;
	if (wrqDvsCod == "D") {
		prodInfo = m_popProdPmtMgmt_currGodsModel.gods_nm;
	} else {
		var odr_qnty = 0;
		if (m_popProdPmtMgmt_currGodsModel.arch_dvs_cod == "A" || m_popProdPmtMgmt_currGodsModel.arch_dvs_cod == "C") {
			var odr_upj_qnty = $("#formProdPmtMgmt_odrUpjQnty").val();
			odr_qnty += parseInt(odr_upj_qnty==""?"0":odr_upj_qnty);	// 상악 수량
		}
		
		if (m_popProdPmtMgmt_currGodsModel.arch_dvs_cod == "B" || m_popProdPmtMgmt_currGodsModel.arch_dvs_cod == "C") {
			var odr_loj_qnty = $("#formProdPmtMgmt_odrLojQnty").val();
			odr_qnty += parseInt(odr_loj_qnty==""?"0":odr_loj_qnty);	// 하악 수량
		}
		
		prodInfo = m_popProdPmtMgmt_currGodsModel.gods_nm + "("+odr_qnty+" arch)";
	}
	
	
	// 결제정보 설정
	var LGDPayInfoModel = data.LGDPayInfoModel;
	$("#formProdPmtMgmtPayinfo_LGD_CUSTOM_USABLEPAY").val(lgdCustomUsablepay);
	$("#formProdPmtMgmtPayinfo_LGD_AMOUNT").val($("#formProdPmtMgmt_pmtScduAmut").val());
	$("#formProdPmtMgmtPayinfo_LGD_PRODUCTINFO").val(prodInfo);
	$("#formProdPmtMgmtPayinfo_LGD_BUYER").val(data.ofc_nm);
	$("#formProdPmtMgmtPayinfo_LGD_OID").val(LGDPayInfoModel.odr_id);
	$("#formProdPmtMgmtPayinfo_LGD_HASHDATA").val(LGDPayInfoModel.lgd_hashdata);
	$("#formProdPmtMgmtPayinfo_LGD_TIMESTAMP").val(LGDPayInfoModel.time_stamp);
	
	/*
	console.log("formProdPmtMgmtPayinfo_LGD_CUSTOM_PROCESSTYPE=["+$("#formProdPmtMgmtPayinfo_LGD_CUSTOM_PROCESSTYPE").val()+"]");
	console.log("formProdPmtMgmtPayinfo_LGD_MID=["+$("#formProdPmtMgmtPayinfo_LGD_MID").val()+"]");
	console.log("formProdPmtMgmtPayinfo_LGD_WINDOW_VER=["+$("#formProdPmtMgmtPayinfo_LGD_WINDOW_VER").val()+"]");
	console.log("formProdPmtMgmtPayinfo_CST_PLATFORM=["+$("#formProdPmtMgmtPayinfo_CST_PLATFORM").val()+"]");
	console.log("formProdPmtMgmtPayinfo_LGD_CASNOTEURL=["+$("#formProdPmtMgmtPayinfo_LGD_CASNOTEURL").val()+"]");
	console.log("formProdPmtMgmtPayinfo_LGD_CUSTOM_SKIN=["+$("#formProdPmtMgmtPayinfo_LGD_CUSTOM_SKIN").val()+"]");
	console.log("formProdPmtMgmtPayinfo_CST_MID=["+$("#formProdPmtMgmtPayinfo_CST_MID").val()+"]");
	console.log("formProdPmtMgmtPayinfo_LGD_WINDOW_TYPE=["+$("#formProdPmtMgmtPayinfo_LGD_WINDOW_TYPE").val()+"]");
	console.log("formProdPmtMgmtPayinfo_LGD_VERSION=["+$("#formProdPmtMgmtPayinfo_LGD_VERSION").val()+"]");
	console.log("formProdPmtMgmtPayinfo_LGD_OSTYPE_CHECK=["+$("#formProdPmtMgmtPayinfo_LGD_OSTYPE_CHECK").val()+"]");
	console.log("formProdPmtMgmtPayinfo_LGD_CUSTOM_SWITCHINGTYPE=["+$("#formProdPmtMgmtPayinfo_LGD_CUSTOM_SWITCHINGTYPE").val()+"]");
	console.log("formProdPmtMgmtPayinfo_LGD_RETURNURL=["+$("#formProdPmtMgmtPayinfo_LGD_RETURNURL").val()+"]");
	console.log("formProdPmtMgmtPayinfo_LGD_PRODUCTINFO=["+$("#formProdPmtMgmtPayinfo_LGD_PRODUCTINFO").val()+"]");
	console.log("formProdPmtMgmtPayinfo_LGD_AMOUNT=["+$("#formProdPmtMgmtPayinfo_LGD_AMOUNT").val()+"]");
	console.log("formProdPmtMgmtPayinfo_LGD_BUYER=["+$("#formProdPmtMgmtPayinfo_LGD_BUYER").val()+"]");
	console.log("formProdPmtMgmtPayinfo_LGD_OID=["+$("#formProdPmtMgmtPayinfo_LGD_OID").val()+"]");
	console.log("formProdPmtMgmtPayinfo_LGD_HASHDATA=["+$("#formProdPmtMgmtPayinfo_LGD_HASHDATA").val()+"]");
	console.log("formProdPmtMgmtPayinfo_LGD_TIMESTAMP=["+$("#formProdPmtMgmtPayinfo_LGD_TIMESTAMP").val()+"]");
	console.log("formProdPmtMgmtPayinfo_LGD_CUSTOM_USABLEPAY=["+$("#formProdPmtMgmtPayinfo_LGD_CUSTOM_USABLEPAY").val()+"]");
	console.log("formProdPmtMgmtPayinfo_LGD_BUYEREMAIL=["+$("#formProdPmtMgmtPayinfo_LGD_BUYEREMAIL").val()+"]");
	console.log("==================================================================================");
	console.log("formProdPmtMgmtPayinfo_wrqId=["+$("#formProdPmtMgmtPayinfo_wrqId").val()+"]");
	console.log("formProdPmtMgmtPayinfo_clrCashPmtAmut=["+$("#formProdPmtMgmtPayinfo_clrCashPmtAmut").val()+"]");
	console.log("formProdPmtMgmtPayinfo_godsId=["+$("#formProdPmtMgmtPayinfo_godsId").val()+"]");
	console.log("formProdPmtMgmtPayinfo_orgPrc=["+$("#formProdPmtMgmtPayinfo_orgPrc").val()+"]");
	console.log("formProdPmtMgmtPayinfo_odrUpjQnty=["+$("#formProdPmtMgmtPayinfo_odrUpjQnty").val()+"]");
	console.log("formProdPmtMgmtPayinfo_odrLojQnty=["+$("#formProdPmtMgmtPayinfo_odrLojQnty").val()+"]");
	console.log("formProdPmtMgmtPayinfo_odrShetPoa=["+$("#formProdPmtMgmtPayinfo_odrShetPoa").val()+"]");
	console.log("formProdPmtMgmtPayinfo_shetOrgPrc=["+$("#formProdPmtMgmtPayinfo_shetOrgPrc").val()+"]");
	console.log("formProdPmtMgmtPayinfo_odrAmut=["+$("#formProdPmtMgmtPayinfo_odrAmut").val()+"]");
	console.log("formProdPmtMgmtPayinfo_salAmut=["+$("#formProdPmtMgmtPayinfo_salAmut").val()+"]");
	console.log("formProdPmtMgmtPayinfo_pmtScduAmut=["+$("#formProdPmtMgmtPayinfo_pmtScduAmut").val()+"]");
	console.log("formProdPmtMgmtPayinfo_eomPmtPoa=["+$("#formProdPmtMgmtPayinfo_eomPmtPoa").val()+"]");
	console.log("formProdPmtMgmtPayinfo_mopDvsCod=["+$("#formProdPmtMgmtPayinfo_mopDvsCod").val()+"]");
	console.log("formProdPmtMgmtPayinfo_dpsKndCod=["+$("#formProdPmtMgmtPayinfo_dpsKndCod").val()+"]");
	console.log("formProdPmtMgmtPayinfo_salInfo=["+$("#formProdPmtMgmtPayinfo_salInfo").val()+"]");
	console.log("formProdPmtMgmtPayinfo_dlvrType=["+$("#formProdPmtMgmtPayinfo_dlvrType").val()+"]");
	console.log("formProdPmtMgmtPayinfo_pmtDlvrSnm=["+$("#formProdPmtMgmtPayinfo_pmtDlvrSnm").val()+"]");
	console.log("formProdPmtMgmtPayinfo_pmtRcvrNm=["+$("#formProdPmtMgmtPayinfo_pmtRcvrNm").val()+"]");
	console.log("formProdPmtMgmtPayinfo_pmtPnn1=["+$("#formProdPmtMgmtPayinfo_pmtPnn1").val()+"]");
	console.log("formProdPmtMgmtPayinfo_pmtPnn2=["+$("#formProdPmtMgmtPayinfo_pmtPnn2").val()+"]");
	console.log("formProdPmtMgmtPayinfo_pmtPnn3=["+$("#formProdPmtMgmtPayinfo_pmtPnn3").val()+"]");
	console.log("formProdPmtMgmtPayinfo_zcd=["+$("#formProdPmtMgmtPayinfo_zcd").val()+"]");
	console.log("formProdPmtMgmtPayinfo_adrs=["+$("#formProdPmtMgmtPayinfo_adrs").val()+"]");
	console.log("formProdPmtMgmtPayinfo_dtlAdrs=["+$("#formProdPmtMgmtPayinfo_dtlAdrs").val()+"]");
	*/
	
	var cstPlatform = $("#formProdPmtMgmtPayinfo_CST_PLATFORM").val();
	lgdwin = openXpay(document.getElementById('formProdPmtMgmtPayinfo'), cstPlatform, LGD_window_type, null, "", "");
}


/*
* FORM 명만  수정 가능
*/
function getFormObject() {
	
	return document.getElementById("formProdPmtMgmtPayinfo");
}

/*
 * 인증결과 처리
 */
function payment_return() {
	
	var fDoc;
	
	fDoc = lgdwin.contentWindow || lgdwin.contentDocument;
		
	if (fDoc.document.getElementById('LGD_RESPCODE').value == "0000") {
		// 주문정보 설정
		$("#formProdPmtMgmtPayinfo_wrqId").val($("#formProdPmtMgmt_wrqId").val());
		$("#formProdPmtMgmtPayinfo_clrCashPmtAmut").val($("#formProdPmtMgmt_clrCashPmtAmut").val());
		$("#formProdPmtMgmtPayinfo_godsId").val($("#formProdPmtMgmt_godsId").val());
		$("#formProdPmtMgmtPayinfo_orgPrc").val($("#formProdPmtMgmt_orgPrc").val());
		$("#formProdPmtMgmtPayinfo_odrUpjQnty").val($("#formProdPmtMgmt_odrUpjQnty").val());
		$("#formProdPmtMgmtPayinfo_odrLojQnty").val($("#formProdPmtMgmt_odrLojQnty").val());
		$("#formProdPmtMgmtPayinfo_odrShetPoa").val($('#formProdPmtMgmt input:radio[name="odr_shet_poa"]:checked').val());
		$("#formProdPmtMgmtPayinfo_shetOrgPrc").val($("#formProdPmtMgmt_shetOrgPrc").val());
		$("#formProdPmtMgmtPayinfo_odrAmut").val($("#formProdPmtMgmt_odrAmut").val());
		$("#formProdPmtMgmtPayinfo_salAmut").val($("#formProdPmtMgmt_salAmut").val());
		$("#formProdPmtMgmtPayinfo_pmtScduAmut").val($("#formProdPmtMgmt_pmtScduAmut").val());
		$("#formProdPmtMgmtPayinfo_eomPmtPoa").val($("#formProdPmtMgmt input:radio[name='eom_pmt_poa']:checked").val());
		$("#formProdPmtMgmtPayinfo_mopDvsCod").val($("#formProdPmtMgmt input:radio[name='mop_dvs_cod']:checked").val());
		$("#formProdPmtMgmtPayinfo_dpsKndCod").val($("#formProdPmtMgmt input:radio[name='dps_knd_cod']:checked").val());
		$("#formProdPmtMgmtPayinfo_salInfo").val($("#formProdPmtMgmt_salInfo").val());
		$("#formProdPmtMgmtPayinfo_dlvrType").val($("#formProdPmtMgmt_dlvrType").val());
		$("#formProdPmtMgmtPayinfo_pmtDlvrSnm").val($("#formProdPmtMgmt_pmtDlvrSnm").val());
		$("#formProdPmtMgmtPayinfo_pmtRcvrNm").val($("#formProdPmtMgmt_pmtRcvrNm").val());
		$("#formProdPmtMgmtPayinfo_pmtPnn1").val($("#formProdPmtMgmt_pmtPnn1").val());
		$("#formProdPmtMgmtPayinfo_pmtPnn2").val($("#formProdPmtMgmt_pmtPnn2").val());
		$("#formProdPmtMgmtPayinfo_pmtPnn3").val($("#formProdPmtMgmt_pmtPnn3").val());
		$("#formProdPmtMgmtPayinfo_zcd").val($("#formProdPmtMgmt_zcd").val());
		$("#formProdPmtMgmtPayinfo_adrs").val($("#formProdPmtMgmt_adrs").val());
		$("#formProdPmtMgmtPayinfo_dtlAdrs").val($("#formProdPmtMgmt_dtlAdrs").val());
		$("#formProdPmtMgmtPayinfo_dtlAdrs").val($("#formProdPmtMgmt_dtlAdrs").val());
		$("#formProdPmtMgmtPayinfo_dlvrScduDt").val($("#formProdPmtMgmt_dlvrScduDt").val());
		
		$("#formProdPmtMgmtPayinfo_LGD_PAYKEY").val(fDoc.document.getElementById('LGD_PAYKEY').value);
		
		/*
		document.getElementById("formProdPmtMgmtPayinfo_LGD_PAYKEY").value = fDoc.document.getElementById('LGD_PAYKEY').value;
		//document.getElementById("formProdPmtMgmtPayinfo").target = "_self";
		document.getElementById("formProdPmtMgmtPayinfo").action = "/makMgr/saveWrqOdrPmtWithPG.do";
		document.getElementById("formProdPmtMgmtPayinfo").submit();
		*/
		
		
		/* VAN 미공유 결제 */
		var resultCallback = function(data) {
			fPaymentReturnResult(data);
		};
		
		callAjax("/makMgr/saveWrqOdrPmtWithPG.do", "post", "json", false, $("#formProdPmtMgmtPayinfo").serialize(), resultCallback);
		
	} else {
		
		//alert("LGD_RESPCODE (결과코드) : " + fDoc.document.getElementById('LGD_RESPCODE').value + "\n" + "LGD_RESPMSG (결과메시지): " + fDoc.document.getElementById('LGD_RESPMSG').value);
		alert(fDoc.document.getElementById('LGD_RESPMSG').value + " ("+fDoc.document.getElementById('LGD_RESPCODE').value+")");
		closeIframe();
	}
}


function fPaymentReturnResult(data) {
	
	if (data.result == "SUCCESS") {
		
		// 모달 닫기
		closeIframe();
		
		// 결제정보 오픈
		fPopPmtMgmt(data.odr_id,'');
		
		// 새로운 배송지 화면 초기화
		fInitOdrDlvrInfo();
		
		// 의뢰서 목록 조회
		fListWrq();
				
	} else {
		
		alert(data.resultMsg);
		closeIframe();
	}
}