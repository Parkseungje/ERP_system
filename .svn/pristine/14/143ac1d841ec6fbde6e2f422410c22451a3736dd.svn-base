var m_dlvrInfoMap = new Map();
var m_godsModel = new Map();
var m_salInfo = "";
var m_currGodsModel = "";


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
			$("#dlvr_type").val("E");
		} else {
			$("#dlvr_type").val("N");
		}

		$("div.tab_area li").removeClass("on");
		$(".tabPage").hide();
		$(this).parents("li").addClass("on");
		$(id).show();
	});
	
	// 상악 수량 변경
	$("#odr_upj_qnty").keyup(function() {
		fSetPmtInfoForDvcMak();
	});
	
	// 하악 수량 변경
	$("#odr_loj_qnty").keyup(function() {
		fSetPmtInfoForDvcMak();
	});
	
	// 추가 sheet 선택 설정
	$("input:radio[name='odr_shet_poa']").click(function(e) {
		fSetPmtInfoForDvcMak();
	});
	
	// 결제구분 선택 설정
	$("input:radio[name='eom_pmt_poa']").click(function(e) {
		var value = $(this).val();
		// N:즉시결제, Y:월말결제
		if (value == "N") {
			$("#mop_area").show();	// 결제수단 show
		} else {
			$("input:radio[name='mop_dvs_cod']").prop("checked", false);	// 결제수단 radio 초기화
			$("#crd_knd_cod").val("");													// 카드종류 초기화
			$("#mop_dvs_cod_C_info").hide();		// 결제수단 hide
			$("input:radio[name='dps_knd_cod']").prop("checked", false);	// 현금결제 초기화
			$("#mop_area").hide();		// 결제수단 hide
			$("#mop_dvs_cod_A_info").hide();		// 결제수단 hide
		} 
	});
	
	// 결제수단 선택 설정
	$("input:radio[name='mop_dvs_cod']").click(function(e) {
		var value = $(this).val();
		// C:신용/체크카드, M:현금
		if (value == "C") {
			//$("#mop_dvs_cod_C_info").show();	// 신용/체크카드 결제
			//$("#mop_dvs_cod_A_info").hide();	// 현금 결제
			e.preventDefault();
			alert("신용카드 및 실시간 계좌이체는 현재 준비중 입니다.\n당분간 무통장 입금을 해 주시기 바랍니다.");
		} else if (value == "M") {
			$("#mop_dvs_cod_C_info").hide();	// 신용/체크카드 결제
			$("#mop_dvs_cod_A_info").show();	// 현금 결제
		} 
	});
	
	// 무통장 입금 선택 시 입금자명 auto focus 설정
	$("#dps_knd_cod_B").click(function (e) {
		$("#dpsr_nm").focus();
	});
	
	/* 임시 설정 */
	$("#dps_knd_cod_B").click(function (e) {
		e.preventDefault();
		alert("신용카드 및 실시간 계좌이체는 현재 준비중 입니다.\n당분간 무통장 입금을 해 주시기 바랍니다.");
	});
	
	
});


/** 결제 창 오픈 */
function fDsgMakMgrPopPmt(wrq_id) {
	
	// 의뢰서 id
	if (wrq_id == null || wrq_id == "" || wrq_id == undefined) {
		alert("결제 할 의뢰서를 먼저 선택해 주세요.");
		return false;
	}
	
	/* 화면 초기화 */
	m_dlvrInfoMap.clear();																			// 배송정보 초기화
	m_godsModel.clear();																			// 상품 전체정보 초기화
	m_currGodsModel = "";																			// 상품정보 초기화
	m_salInfo = "";																						// 할인정보 초기화

	$("#wrq_id").val(wrq_id);																		// 의뢰서 ID 설정
	$("#pmt_rcvr_nm").val("");																		// 받는분
	$("#pmt_pnn_1").val("");																		// 전화번호
	$("#pmt_pnn_2").val("");																		// 전화번호
	$("#pmt_pnn_3").val("");																		// 전화번호
	$("#zcd").val("");																					// 우편번호
	$("#adrs").val("");																				// 주소
	$("#dtl_adrs").val("");																			// 상세 주소
	$('input:radio[name=odr_shet_poa]:input[value="N"]').prop("checked", true);	// 추가 sheet 초기화
	$("#cash_prc").val("");																			// 클리어 캐시 사용금액 초기화
	$('input:radio[name=eom_pmt_poa]:input[value="N"]').prop("checked", true);	// 결제 구분 초기화
	$("input:radio[name='mop_dvs_cod']").prop("checked", false);						// 결제수단 초기화
	$("#crd_knd_cod").val("");																		// 신용/체크카드 결제 초기화
	$("input:radio[name='dps_knd_cod']").prop("checked", false);						// 현금결제 초기화
	$("#mop_area").show();																		// 결제수단 show
	$("#pmt_cfm_a").prop("checked", false);													// 취소규정 약관
	$("#pmt_cfm_b").prop("checked", false);													// 취소규정 약관
	
	
	// 최근 의뢰서 조회
	var param = {
			wrq_id : wrq_id
	}
	
	var resultCallback = function(data) {
		fDsgMakMgrPopPmtResult(data);
	};

	callAjax("/makMgr/selectInitPmtInfo.do", "post", "json", false, param, resultCallback);
}


/** 결제 창 콜백 함수 */
function fDsgMakMgrPopPmtResult(data) {
	
	if (data.result == "SUCCESS") {

		/* 설정 데이터 초기화 */ 
		var wrq_dvs_cod = $("#wrq_dvs_cod").val();		// 의뢰서 구분 코드(D:정밀진단, M:장치제작)
		
		// 상품 구분에 따른 결제 정보 설정
		$(data.listGodsModel).each(function (index, model) {
			m_godsModel.put(model.gods_dvs_cod, model);
		});
		
		// 배송지 정보 설정
		fInitDlvrInfo(data.listDestInfoModel);
		
		var hirWrqId = data.wrqModel.hir_wrq_id;
		if (hirWrqId != null && hirWrqId != "" && hirWrqId != undefined) {
			m_currGodsModel = m_godsModel.get("R");
		} else {
			m_currGodsModel = m_godsModel.get(wrq_dvs_cod);
		} 
			
		// 장치제작 수량 설정
		$("#odr_upj_qnty").val(m_currGodsModel.gods_qnty);	// 상악 수량
		$("#odr_loj_qnty").val(m_currGodsModel.gods_qnty);	// 하악 수량
		$("#odr_upj_qnty").attr("readonly", false); 
		$("#odr_loj_qnty").attr("readonly", false);
		if (m_currGodsModel.arch_dvs_cod == "A") {
			$("#odr_loj_qnty").val("0");	// 하악 수량
			$("#odr_loj_qnty").attr("readonly", true);
		} else if (m_currGodsModel.arch_dvs_cod == "B") {
			$("#odr_upj_qnty").val("0");	// 상악 수량
			$("#odr_upj_qnty").attr("readonly", true);
		}
		
		$("#pmt_wrq_dvs_cod").val(wrq_dvs_cod);			// 의뢰 구분 코드 설정
		
		// 배송지 정보 영역 및 장치제작 수량 선택 Show/Hide 설정
		if (wrq_dvs_cod == "M") {
			$("#delivery_area").show();	// 배송지 영역 보임
			$("#dvcMak_area").show();	// 장치제작 수량 선택 보임
			fSetPmtInfoForDvcMak();				// 장치제작 결제 가격 설정
		} else {
			$("#delivery_area").hide();		// 배송지 영역 숨김
			$("#dvcMak_area").hide();		// 장치제작 수량 선택 숨김
			fSetPmtInfoForPcsDsg();		// 정밀진단 결제 가격 설정 
		}
		
		
		/* 결제구분 선택 화면 설정*/
		// "N":즉시결제, "Y":월말결제
		if (m_currGodsModel.eom_pmt_poa == "Y") {
			$("#pmtDvs_area").show();	// 결제구분 선택 영역 보임
		} else {
			$("#pmtDvs_area").hide();		// 결제구분 선택 영역 숨김
		}
		
		/* 보유캐시 설정*/
		$("#cash_amut").text(comma(m_currGodsModel.cash_amut));
		$("#rmd_cash_amut_area").hide();
		
		/* 결제수단 설정 */
		$("#mop_dvs_cod_C_info").hide();	// 신용/체크카드 결제
		$("#mop_dvs_cod_A_info").hide();	// 현금 결제
				
		// 모달 팝업
		gfModalPopTop("#layer6");
		
	} else {
		// 오류 응답 메시지 출력
		alert(data.resultMsg);
	}
}


/** 정밀진단 결제 정보 설정 */
function fSetPmtInfoForPcsDsg() {
	
	var pmt_odr_amut = 0;		// 의뢰 가격
	var pmt_sal_amut = 0;		// 할인 가격
	
	pmt_odr_amut = m_currGodsModel.gods_qnty * m_currGodsModel.gods_prc;	// 의뢰 가격
	pmt_sal_amut = 0;		// 할인 가격
	
	/* 의뢰정보 */
	// 제작구분
	$("#pmt_wrq_dvs_cod_nm").text(m_currGodsModel.wrq_dvs_cod_nm);
	
	// 주문 상세 정보
	$("#pmt_odr_info").empty();
	
	var sbPmtOdrInfo = new StringBuffer();
	sbPmtOdrInfo.append("<li> - 단가 : " + comma(m_currGodsModel.gods_prc) + " 원</li>");	// 정상 단가
	sbPmtOdrInfo.append("<li> - 수량 : " + m_currGodsModel.gods_qnty + " EA</li>");			// 수량
	$("#pmt_odr_info").append(sbPmtOdrInfo.toString());										// 의뢰정보 출력
	$("#pmt_odr_amut").text(comma(pmt_odr_amut));											// 총금액
	

	/* 최종결제 정보*/
	$("#pmt_odr_prc").text(comma(pmt_odr_amut));	// 의뢰가격
	m_salInfo = "";	// 할인가격 상세정보 초기화
	
	// Y:할인적용, N:할인 미적용
	if (m_currGodsModel.sal_psb_poa == "Y") {
		pmt_sal_amut = (m_currGodsModel.gods_prc - m_currGodsModel.gods_sal_prc) * m_currGodsModel.gods_qnty;	// 할인 가격
		$("#pmt_sal_amut").text(comma(pmt_sal_amut));	// 할인가격
		$("#pmt_sal_info").remove();
		
		// 할인 상세 정보
		var sbPmtSalInfo = new StringBuffer();
		sbPmtSalInfo.append("<div class=\"sub\" id=\"pmt_sal_info\">");
		sbPmtSalInfo.append("	<dl>");
		sbPmtSalInfo.append("		<dt>- VIP할인("+m_currGodsModel.sal_rat+"%)</dt>");
		sbPmtSalInfo.append("		<dd>"+comma(pmt_sal_amut)+"원</dd>");
		sbPmtSalInfo.append("	</dl>");
		sbPmtSalInfo.append("</div>");
		$("#pmt_fnl_pmt_info").append(sbPmtSalInfo.toString());
		
		// 할인가격 상세 정보
		m_salInfo += "V|VIP 할인("+m_currGodsModel.sal_rat+"%)|"+m_currGodsModel.sal_rat+"|"+pmt_sal_amut+"|"+m_currGodsModel.sal_psb_poa+"|N";
		
		
	} else {
		pmt_sal_amut = 0;
		$("#pmt_sal_amut").text(0);	// 할인가격
		$("#pmt_sal_info").remove();	// 할인 정보 삭제
	}
	
	$("#pmt_clr_cash_pmt_amut").text(0);	// 클리어 캐시 사용 금액
	$("#pmt_pmt_amut").text(comma(pmt_odr_amut - pmt_sal_amut));	// 결제 예정 금액
	$("#pmt_amut").val(pmt_odr_amut - pmt_sal_amut);						// 결제 예정 금액(hidden)
	
	// 상품정보
	$("#gods_id").val(m_currGodsModel.gods_id);		// 상품 ID
	$("#org_prc").val(m_currGodsModel.gods_prc);	// 상품 정상 단가
	$("#shet_org_prc").val(0);	// 추가시트 상품 정상 단가
}


/** 장치제작 결제 정보 설정 */
function fSetPmtInfoForDvcMak() {

	var godsModelSheet = m_godsModel.get("A");
	
	// arch 수량
	var odr_qnty = 0;
	if (m_currGodsModel.arch_dvs_cod == "A" || m_currGodsModel.arch_dvs_cod == "C") {
		var odr_upj_qnty = $("#odr_upj_qnty").val();
		odr_qnty += parseInt(odr_upj_qnty==""?"0":odr_upj_qnty);	// 상악 수량
	}
	
	if (m_currGodsModel.arch_dvs_cod == "B" || m_currGodsModel.arch_dvs_cod == "C") {
		var odr_loj_qnty = $("#odr_loj_qnty").val();
		odr_qnty += parseInt(odr_loj_qnty==""?"0":odr_loj_qnty);	// 하악 수량
	}
	
	// 추가시트 arch 수량
	var odr_sheet_qnty = 0;
	var odr_shet_poa = $('input:radio[name="odr_shet_poa"]:checked').val();
	if (odr_shet_poa == "Y") {
		odr_sheet_qnty = odr_qnty;
	}
	
	var pmt_odr_amut = 0;		// 의뢰 가격
	var pmt_sal_amut = 0;		// 할인 가격
	
	// 의뢰 가격
	pmt_odr_amut = odr_qnty * m_currGodsModel.gods_prc;		
	pmt_odr_amut +=  odr_sheet_qnty * godsModelSheet.gods_prc;
	
	/* 의뢰정보 */
	// 제작구분
	$("#pmt_wrq_dvs_cod_nm").text(m_currGodsModel.gods_nm);
	
	// 주문 상세 정보
	$("#pmt_odr_info").empty();
	var sbPmtOdrInfo = new StringBuffer();
	sbPmtOdrInfo.append("<li> - 치아 구분 : " + comma(m_currGodsModel.arch_dvs_cod_nm) + "</li>");
	sbPmtOdrInfo.append("<li> - 수량 : " + odr_qnty  + " arch</li>");
	sbPmtOdrInfo.append("<li> - 단가 : " + comma(m_currGodsModel.gods_prc) + " 원</li>");
	sbPmtOdrInfo.append("<li> - 추가 sheet 수량 : " + odr_sheet_qnty + " arch</li>");
	sbPmtOdrInfo.append("<li> - 추가 sheet 단가 : " + comma(godsModelSheet.gods_prc) + " 원</li>");
	
	$("#pmt_odr_info").append(sbPmtOdrInfo.toString());	// 의뢰정보 출력
	$("#pmt_odr_amut").text(comma(pmt_odr_amut));		// 총금액
	
	/* 최종결제 정보*/
	// 의뢰 가격
	$("#pmt_odr_prc").text(comma(pmt_odr_amut));

	// 할인 가격
	$("#pmt_sal_amut").text(0);	// 할인가격
	
	// 할인가격 정보
	$("#pmt_sal_info").remove();
	
	// + VIP 할인
	var vip_sal_amut = 0;
	var mak_sal_poa = 'N';
	var shet_sal_poa = 'N';
	
	var rmk_sal_amut = 0;
	var rmk_sal_cnt = 0;
	
	// 상품별 할인 정보 설정
	if (m_currGodsModel.gods_dvs_cod == "M") {

		// - 장치 제작
		// - Y:할인적용, N:할인 미적용
		if (m_currGodsModel.sal_psb_poa == "Y") {
			var sal_amut = parseInt(m_currGodsModel.gods_prc) - parseInt(m_currGodsModel.gods_sal_prc);	// 할인 단가
			vip_sal_amut += sal_amut * odr_qnty;	// 총 할인 금액
			mak_sal_poa = "Y";
		}
		
	} else if (m_currGodsModel.gods_dvs_cod == "R") {
	
		// - remake 할인 갯수를 구한다.
		if (m_currGodsModel.rmk_sal_num >  m_currGodsModel.odr_rmk_num) {
			rmk_sal_cnt = m_currGodsModel.rmk_sal_num -  m_currGodsModel.odr_rmk_num;
			
			// 리메이크 할인 갯수보다 주문갯수가 클경우 리메이크 할인 갯수를 적용한다.
			// 그외의 경우 주문 갯수모두 할인 갯수로 적용한다.
			if (odr_qnty >= rmk_sal_cnt) {
				rmk_sal_amut = rmk_sal_cnt * m_currGodsModel.gods_sal_prc;
			} else {
				rmk_sal_cnt = odr_qnty;
				rmk_sal_amut = rmk_sal_cnt * m_currGodsModel.gods_sal_prc;
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
	
	// - 누적 step + 주문 step
	var odr_stp_num = 0;

	// - 상악 step
	var odr_upj_qnty = $("#odr_upj_qnty").val();
	odr_upj_qnty = parseInt(odr_upj_qnty==""?"0":odr_upj_qnty);
	
	// - 하악 step
	var odr_loj_qnty = $("#odr_loj_qnty").val();
	odr_loj_qnty = parseInt(odr_loj_qnty==""?"0":odr_loj_qnty);
	
	// - 상악/하악 step 중 큰 step을 취함
	if (odr_upj_qnty >= odr_loj_qnty) odr_stp_num = odr_upj_qnty;
	else odr_stp_num = odr_loj_qnty;
	
	// - 누적 step이 기준 step보다 크거나 같을 경우 할인 적용
	odr_stp_num += parseInt(m_currGodsModel.odr_stp_num);
	if (parseInt(m_currGodsModel.pcdg_sal_stp_qnty) <= odr_stp_num) {
		pcdg_sal_amut = parseInt(m_currGodsModel.pcdg_sal_prc);
	}
	
	// + 총 할인 금액
	pmt_sal_amut = vip_sal_amut + pcdg_sal_amut + rmk_sal_amut;
	
	// - 총 할인 금액 정보 Header
	m_salInfo = "";	// 할인가격 상세 정보
	
	
	var sbPmtSalInfo = new StringBuffer();
	if (pmt_sal_amut > 0) {
		sbPmtSalInfo.append("<div class=\"sub\" id=\"pmt_sal_info\">");
	}
	
	// - VIP 할인
	if (vip_sal_amut > 0) {
		sbPmtSalInfo.append("	<dl>");
		sbPmtSalInfo.append("		<dt>- VIP할인("+m_currGodsModel.sal_rat+"%) : </dt>");
		sbPmtSalInfo.append("		<dd>"+comma(vip_sal_amut)+" 원</dd>");
		sbPmtSalInfo.append("	</dl>");
		
		m_salInfo += "V|VIP 할인("+m_currGodsModel.sal_rat+"%)|"+m_currGodsModel.sal_rat+"|"+vip_sal_amut+"|"+mak_sal_poa+"|"+shet_sal_poa;
	}
	
	// - 정밀진단 할인
	if (pcdg_sal_amut > 0) {
		sbPmtSalInfo.append("	<dl>");
		sbPmtSalInfo.append("		<dt>- 정밀진단 : </dt>");
		sbPmtSalInfo.append("		<dd>"+comma(pcdg_sal_amut)+" 원</dd>");
		sbPmtSalInfo.append("	</dl>");
		
		m_salInfo += "^D|정밀진단|0|"+pcdg_sal_amut+"|Y|N";
	}
	
	// - 리메이크 할인
	if (rmk_sal_amut > 0) {
		sbPmtSalInfo.append("	<dl>");
		sbPmtSalInfo.append("		<dt>- 리메이크 : </dt>");
		sbPmtSalInfo.append("		<dd>"+comma(rmk_sal_amut)+" 원</dd>");
		sbPmtSalInfo.append("	</dl>");
		
		m_salInfo += "^R|리메이크|"+rmk_sal_cnt+"|"+rmk_sal_amut+"|Y|N";
	}
	
	// - 총 할인 금액 정보 Tail
	if (pmt_sal_amut > 0) {
		sbPmtSalInfo.append("</div>");
		$("#pmt_fnl_pmt_info").append(sbPmtSalInfo.toString());
		$("#pmt_sal_amut").text(comma(pmt_sal_amut));	// 할인가격
	}
	
	$("#pmt_clr_cash_pmt_amut").text(0);	// 클리어 캐시 사용 금액
	$("#pmt_pmt_amut").text(comma(pmt_odr_amut - pmt_sal_amut));	// 결제 예정 금액
	$("#pmt_amut").val(pmt_odr_amut - pmt_sal_amut);						// 결제 예정 금액(hidden)
	
	// 상품정보
	$("#gods_id").val(m_currGodsModel.gods_id);		// 상품 ID
	$("#org_prc").val(m_currGodsModel.gods_prc);	// 상품 정상 단가	
	$("#shet_org_prc").val(godsModelSheet.gods_prc);	// 추가시트 상품 정상 단가
}


/** 배송지 정보 설정 */
function fInitDlvrInfo(listDestInfoModel) {

	// 기존 배송지 및 신규 배송지 탭 초기화
	$("#btnListDest").empty();	// 화면 초기화
	m_dlvrInfoMap.clear();		// 배송지 데이터 초기화

	var cssFocusClose = "focus_close";
	$(listDestInfoModel).each(function(index, model) {
		
		m_dlvrInfoMap.put(model.snm, model);
		if (index == 0) {
			// 첫번째 배송지 설정
			fSetDlvrInfo(model.snm);
		} else {
			cssFocusClose = "";
		}
			
		var sbDestBtn = new StringBuffer();
		sbDestBtn.append("<span class='btnTypeBox "+cssFocusClose+"' id='btnTypeBox_"+model.snm+"'>");
		sbDestBtn.append("<a class='name' href='javascript:fSetDlvrInfo(\""+model.snm+"\")'>"+model.rcvr_nm+"</a>");
		sbDestBtn.append("<a class='del' href='javascript:fDeleteDestInfo(\""+model.ofc_id+"\",\""+model.snm+"\")'></a>");
		sbDestBtn.append("</span>");
		
		$("#btnListDest").append(sbDestBtn.toString());
	});
	
	//$("#btnListDest").append("<a class='fr' href='#'>배송주소록 &gt; </a>");
	
	// 기존 배송지 등록 되어 있을 경우 기존 배송지로 초기 설정
	if ($(listDestInfoModel).size() > 0 ) {		
		$("#btnTab01").addClass("on");
		$("#tab01").show();
		$("#btnTab02").removeClass("on");
		$("#tab02").hide();
		$("#dlvr_type").val("E");
	} else {
		$("#btnTab01").removeClass("on");
		$("#tab01").hide();
		$("#btnTab02").addClass("on");
		$("#tab02").show();
		$("#dlvr_type").val("N");
		
		$("#view_rcvr_nm").text("등록된 배송지가 없습니다.");
		$("#view_pnn").text("");
		$("#view_adrs").text("");
		$("#view_zcd").text("");
	}
}


/** 버튼 선택된 배송지 정보 설정 */
function fSetDlvrInfo(snm) {
	
	// 선택버튼 CSS 설정
	var elements = $("#btnListDest").children("span");
	$(elements).each(function(index, element) {
		$(element).removeClass("focus_close");
	}); 
	$("#btnTypeBox_"+snm).addClass("focus_close"); 

	// 선택 데이터 설정
	var model = m_dlvrInfoMap.get(snm);
	$("#view_rcvr_nm").text(model.rcvr_nm);
	$("#view_pnn").text(model.pnn_1+"-"+model.pnn_2+"-"+model.pnn_3);
	$("#view_adrs").text(model.adrs+" "+model.dtl_adrs);
	$("#view_zcd").text(model.zcd);
	
	// 선택된 배송지 정보 설정
	$("#pmt_dlvr_snm").val(snm);
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
	
	var cash_prc = $("#cash_prc").val();										// 캐시 사용 금액 <input>

	if (cash_prc == "" || cash_prc == "0") {
		cash_prc = 0;
		$("#rmd_cash_amut_area").hide();
	} else {
		$("#rmd_cash_amut_area").show();
	}

	cash_prc = parseInt(uncomma(cash_prc));															// 캐시 사용 금액 <input>
	var cash_amut = parseInt(uncomma($("#cash_amut").text()));								// 보유 캐시
	var clr_cash_pmt_amut = parseInt(uncomma($("#pmt_clr_cash_pmt_amut").text()));	// 결제 예정 캐시 금액
	var pmt_amut = parseInt($("#pmt_amut").val());													// 결제 예정금액

	if (cash_amut < cash_prc) {
		alert("보유한 Clear Cash보다 사용 Cash가 많습니다.\n보유한 Cash보다 적거나 같게 사용해 주세요.");
		$("#cash_prc").focus();
		return;
	}
	
	if (pmt_amut < cash_prc) {
		var bConfirm = confirm("Clear Cash 사용 액이 결제 예정금액보다 많습니다.\n결제 예정금액만큼 사용 하시겠습니까?");
		if (bConfirm) {
			cash_prc = pmt_amut;
			$("#cash_prc").val(cash_prc);
		} else {
			$("#cash_prc").val("");
			cash_prc = 0;
		}
	}
	
	$("#pmt_clr_cash_pmt_amut").text(comma(cash_prc));			// 결제 예정 캐시 금액
	$("#pmt_pmt_amut").text(comma(pmt_amut - cash_prc));		// 결제 예정금액
	$("#rmd_cash_amut").text(comma(cash_amut - cash_prc));	// 잔여 캐시
}


/** 클리어 캐시 모두 사용 */
function fUseClrCashAll() {
	
	
	var cash_amut = parseInt(uncomma($("#cash_amut").text()));								// 보유 캐시
	var pmt_amut = parseInt($("#pmt_amut").val());													// 결제 예정금액
	var cash_prc = 0;
	
	// 보유캐시보다 결제 예정금액이 클 경우 보유 캐시 모두 사용
	if (cash_amut < pmt_amut) {
		cash_prc = cash_amut;
	} else {
		cash_prc = pmt_amut;
	}
	
	// 잔여 캐시 보이고 감추기
	if (cash_prc == 0) {
		$("#rmd_cash_amut_area").hide();
	} else {
		$("#rmd_cash_amut_area").show();
	}
	
	$("#pmt_clr_cash_pmt_amut").text(comma(cash_prc));			// 결제 예정 캐시 금액
	$("#cash_prc").val(cash_prc);
	$("#pmt_pmt_amut").text(comma(pmt_amut - cash_prc));		// 결제 예정금액
	$("#rmd_cash_amut").text(comma(cash_amut - cash_prc));	// 잔여 캐시
}


/** 의뢰서 주문 결제 */
function fWrqOdrPmt() {
	
	// 의뢰서 구분 코드
	// D:정밀진단, W:장치제작
	var wrq_dvs_cod = $("#pmt_wrq_dvs_cod").val();
	var dlvr_type = $("#dlvr_type").val();
	
	/* validation check*/
	// 배송지 주소 체크
	// 의뢰서 구분 코드 ( "D":정밀진단, "M":장치제작)
	if ((wrq_dvs_cod == "M") && (dlvr_type == "N")) {
		
		if ($("#pmt_rcvr_nm").val() == "") {
			alert("받는분을 입력해 주세요.");
			$("#pmt_rcvr_nm").focus();
			return;
		}
		
		if ($("#pmt_pnn_1").val() == "") {
			alert("전화번호를 입력해 주세요.");
			$("#pmt_pnn_1").focus();
			return;
		}
		
		if ($("#pmt_pnn_2").val() == "") {
			alert("전화번호를 입력해 주세요.");
			$("#pmt_pnn_2").focus();
			return;
		}
		
		if ($("#pmt_pnn_3").val() == "") {
			alert("전화번호를 입력해 주세요.");
			$("#pmt_pnn_3").focus();
			return;
		}
		
		if ($("#zcd").val() == "") {
			alert("우편번호를 입력해 주세요.");
			$("#zcd").focus();
			return;
		}
		
		if ($("#adrs").val() == "") {
			alert("주소를 입력해 주세요.");
			$("#adrs").focus();
			return;
		}
		
		if ($("#dtl_adrs").val() == "") {
			alert("상세 주소를 입력해 주세요.");
			$("#dtl_adrs").focus();
			return;
		}
	}
	
	// 장치제작 수량 선택
	if (wrq_dvs_cod == "M") {
		var archDvsCod = m_currGodsModel.arch_dvs_cod;
		
		if (archDvsCod == "A" || archDvsCod == "C") {
			var odr_upj_qnty = $("#odr_upj_qnty").val();
			if (odr_upj_qnty == "" || odr_upj_qnty == "0") {
				alert("상악 Step 수량을 입력해 주세요.");
				$("#odr_upj_qnty").focus();
				return;
			}
		}
		
		if (archDvsCod == "B" || archDvsCod == "C") {
			var odr_loj_qnty = $("#odr_loj_qnty").val();
			if (odr_loj_qnty == "" || odr_loj_qnty == "0") {
				alert("하악 Step 수량을 입력해 주세요.");
				$("#odr_loj_qnty").focus();
				return;
			}
		}
	}
	
	// 결제구분 선택
	var eom_pmt_poa = $('input:radio[name="eom_pmt_poa"]:checked').val();
	if (eom_pmt_poa == "") {
		alert("결제구분을 선택해 주세요.");
		$("#eom_pmt_poa").focus();
		return;
	}
	
	// 결제수단 선택
	// 결제구분이 즉시결제 및 결제 예정금액이 있을 경우 결제수단을 체크 한다.
	var pmt_amut = parseInt(uncomma($("#pmt_pmt_amut").text()));	// 결제 예정 금액
	if (eom_pmt_poa == "N" && pmt_amut > 0) {
		
		// 결제수단 선택 체크
		var mop_dvs_cod = $('input:radio[name="mop_dvs_cod"]:checked').val();
		if (mop_dvs_cod == "" || mop_dvs_cod == undefined) {
			alert("결제수단을 선택해 주세요.");
			$("#mop_dvs_cod_C").focus();
			return ;
		}
		
		// 결제수단 별 하위 구성 체크
		//	C:신용/체크카드 결제, M:현금 결제
		if (mop_dvs_cod == "C") {
			var crd_knd_cod = $("#crd_knd_cod").val();
			if (crd_knd_cod == "") {
				alert("결제 할 카드 종류를 선택해 주세요.");
				$("#crd_knd_cod").focus();
				return;
			}
		} else if (mop_dvs_cod == "M") {
			var dps_knd_cod = $('input:radio[name="dps_knd_cod"]:checked').val();
			if (dps_knd_cod == "" || dps_knd_cod == undefined) {
				alert("현금결제 할 방법을 선택해 주세요.");
				$("#dps_knd_cod").focus();
				return;
			}
		}
	}
	
	// 결제 취소규정 체크 확인
	if (!$("#pmt_cfm_a").is(":checked")) {
		alert("결제 취소규정 사항을 체크해 주세요.");
		$("#pmt_cfm_a").focus();
		return;
	}
	
	if (!$("#pmt_cfm_b").is(":checked")) {
		alert("결제 취소규정 사항을 체크해 주세요.");
		$("#pmt_cfm_b").focus();
		return;
	}
	
	// 결제 정보 설정
	$("#sal_info").val(m_salInfo);	// 세일 상세 정보
	$("#odr_amut").val(uncomma($("#pmt_odr_amut").text()));								// 의뢰 금액
	$("#sal_amut").val(uncomma($("#pmt_sal_amut").text()));								// 할인 금액
	$("#clr_cash_pmt_amut").val(uncomma($("#pmt_clr_cash_pmt_amut").text()));	// Clear Cash 사용 금액
	$("#pmt_scdu_amut").val(uncomma($("#pmt_pmt_amut").text()));					// 결제 예정금액
	
	
	// VAN 결제 유무에 따른 결제 경로 지정
	// VAN 공유
	//		1. 즉시 결제일 경우
	//		2. 결제 금액이 있을 경우
	// VAN 미공유
	//		1. 월말결제일 경우
	//		2. 결제 금액이 없는 경우(100% Clear Cash 결제)
	/* VAN 미공유 결제 */
	var resultCallback = function(data) {
		fWrqOdrPmtResult(data);
	};
	
	callAjax("/makMgr/saveWrqOdrPmt.do", "post", "json", false, $("#myForm").serialize(), resultCallback);
	

//	if (eom_pmt_poa == "N" && pmt_amut > 0 ) {
//		/* VAN 공유 결제*/
//		
//		
//	} else {
//		
//		/* VAN 미공유 결제 */
//		var resultCallback = function(data) {
//			fWrqOdrPmtResult(data);
//		};
//		
//		callAjax("/makMgr/saveWrqOdrPmt.do", "post", "json", false, $("#myForm").serialize(), resultCallback);
//	}
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
	$("#pmt_rcvr_nm").val("");
	$("#pmt_pnn_1").val("");
	$("#pmt_pnn_2").val("");
	$("#pmt_pnn_3").val("");
	$("#pmt_zcd").val("");
	$("#pmt_adrs").val("");
	$("#pmt_dtl_adrs").val("");
}