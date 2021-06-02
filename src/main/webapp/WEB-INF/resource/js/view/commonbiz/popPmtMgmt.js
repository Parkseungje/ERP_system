var m_popPmtMgmt_odrInfo;
var m_popPmtMgmt_execFunc = "";

$(function() {
});

/** 결제관리 팝업 Open */
function fPopPmtMgmt(odr_id, execFunc) {

	$("#popPmtMgmt_odrInfoCash").removeClass("show").addClass("hidden");
	$("#popPmtMgmt_odrInfoProd").removeClass("show").addClass("hidden");
	$("#popPmtMgmt_dlvrInfo").removeClass("show").addClass("hidden");
	$("#popPmtMgmt_dlvrPmtInfo").removeClass("show").addClass("hidden");
	$("#popPmtMgmt_currInfo").removeClass("show").addClass("hidden");
	$("#popPmtMgmt_pmtInfoDetlNote").removeClass("show").addClass("hidden");
	
		
	// 팝업 종료 후 실행 되어야 할 함수
	if (execFunc == null || execFunc == "" || execFunc == undefined) {
		m_popPmtMgmt_execFunc = "";
	} else {
		m_popPmtMgmt_execFunc = execFunc;
	}
	
	var param = {
			odr_id : odr_id
	}

	var resultCallback = function(data) {
		fPopPmtMgmtResult(data);
	};

	callAjax("/odrMgmt/selectOdrInfo.do", "post", "json", true, param, resultCallback);
}

/** 발주관리 팝업 Open 콜백 함수 */
function fPopPmtMgmtResult(data) {

	if (data.result == "SUCCESS") {
		
		// 업무정보 설정 ==================================
		m_popPmtMgmt_odrInfo = data.odrInfoModel;
		
		var wrqDvsCod = m_popPmtMgmt_odrInfo.wrq_dvs_cod;
		
		// 의뢰(주문)정보 설정 ==============================
		var odrInfo = new StringBuffer();
		
		// pmt_dvs_cod : C[클리어캐시], P[의뢰서]
		if (m_popPmtMgmt_odrInfo.pmt_dvs_cod == "C") {
			$("#popPmtMgmt_odrInfoCash").removeClass("hidden").addClass("show");
			
		} else {
			
			$("#popPmtMgmt_odrInfoProd").removeClass("hidden").addClass("show");
			$("#popPmtMgmt_odrInfoProdDetl").empty();

			var makOdrCnt = (m_popPmtMgmt_odrInfo.upj_qnty+m_popPmtMgmt_odrInfo.loj_qnty);
			
			odrInfo.append("<tr style='background: #fff;'>");
			odrInfo.append("	<td" + ((wrqDvsCod=="M")?" rowspan='2'":"") + ">" + m_popPmtMgmt_odrInfo.odr_id + "</td>");
			odrInfo.append("	<td>" + m_popPmtMgmt_odrInfo.wrq_dvs_cod_nm + "</td>");
			odrInfo.append("	<td>" + m_popPmtMgmt_odrInfo.arch_dvs_cod_nm + "</td>");
			odrInfo.append("	<td>" + comma(m_popPmtMgmt_odrInfo.org_prc) + " 원</td>");
			odrInfo.append("	<td>" + makOdrCnt + ((wrqDvsCod=="M")?" arch":" 부") + "</td>");
			odrInfo.append("	<td>" + comma(m_popPmtMgmt_odrInfo.org_prc * makOdrCnt) + " 원</td>");
			odrInfo.append("</tr>");
			// 장치제작일 경우 추가 시트 표기
			if (wrqDvsCod == "M") {
				var shetOdrCnt = ((m_popPmtMgmt_odrInfo.shet_poa=="N")?0:(m_popPmtMgmt_odrInfo.upj_qnty+m_popPmtMgmt_odrInfo.loj_qnty));
				odrInfo.append("<tr style='background: #fff;'>");
				odrInfo.append("	<td>추가시트</td>");
				odrInfo.append("	<td>" + m_popPmtMgmt_odrInfo.arch_dvs_cod_nm + "</td>");
				odrInfo.append("	<td>" + comma(m_popPmtMgmt_odrInfo.shet_org_prc) + " 원</td>");
				odrInfo.append("	<td>" + shetOdrCnt + " arch</td>");
				odrInfo.append("	<td>" + comma(m_popPmtMgmt_odrInfo.shet_org_prc * shetOdrCnt) + " 원</td>");
				odrInfo.append("</tr>");
			}
			odrInfo.append("<tr class='bold' style='background: #f3f3f3;'>");
			odrInfo.append("	<td>총금액</td>");
			odrInfo.append("	<td colspan='4'></td>");
			odrInfo.append("	<td>" + comma(m_popPmtMgmt_odrInfo.odr_amut) + " 원</td>");
			odrInfo.append("</tr>");
		}
		
		$("#popPmtMgmt_odrInfoProdDetl").append(odrInfo.toString());
		
		
		// 결제정보 설정 ==============================
		var pmtInfo = new StringBuffer();
		$("#popPmtMgmt_pmtInfoDetl").empty();
		pmtInfo.append("<tr>");
		pmtInfo.append("	<th>결제 완료일</th>");
		pmtInfo.append("	<td colspan='3'>" + m_popPmtMgmt_odrInfo.pay_date + "</td>");
		pmtInfo.append("</tr>");
		pmtInfo.append("<tr>");
		pmtInfo.append("	<th rowspan='5'>결제 방법/금액</th>");
		
		if (m_popPmtMgmt_odrInfo.ctcd_pmt_amut > 0) {
			pmtInfo.append("	<td>신용카드</td>");
			pmtInfo.append("	<td class='textR'>" + comma(m_popPmtMgmt_odrInfo.ctcd_pmt_amut) + " 원</td>");
			pmtInfo.append("	<td>" + m_popPmtMgmt_odrInfo.pay_info + "</td>");
		}
		
		if (m_popPmtMgmt_odrInfo.actf_pmt_amut > 0) {
			pmtInfo.append("	<td>실시간 계좌이체</td>");
			pmtInfo.append("	<td class='textR'>" + comma(m_popPmtMgmt_odrInfo.actf_pmt_amut) + " 원</td>");
			pmtInfo.append("	<td>" + m_popPmtMgmt_odrInfo.pay_info + "</td>");
		}
		
		if (m_popPmtMgmt_odrInfo.mkdp_pmt_amut > 0) {
			pmtInfo.append("	<td>무통장 입금</td>");
			pmtInfo.append("	<td class='textR'>" + comma(m_popPmtMgmt_odrInfo.mkdp_pmt_amut) + " 원</td>");
			pmtInfo.append("	<td>" + m_popPmtMgmt_odrInfo.pay_info + "</td>");
			$("#popPmtMgmt_pmtInfoDetlNote").removeClass("hidden").addClass("show");
		}
		
		if (m_popPmtMgmt_odrInfo.eom_pmt_amut > 0) {
			pmtInfo.append("	<td>월말 결제</td>");
			pmtInfo.append("	<td class='textR'>" + comma(m_popPmtMgmt_odrInfo.eom_pmt_amut) + " 원</td>");
			pmtInfo.append("	<td></td>");
		}
				
		pmtInfo.append("</tr>");
		pmtInfo.append("<tr>");
		pmtInfo.append("	<td>클리어 캐시</td>");
		pmtInfo.append("	<td class='textR'>"+ comma(m_popPmtMgmt_odrInfo.clr_cash_pmt_amut) +" 원</td>");	
		pmtInfo.append("	<td></td>");
		pmtInfo.append("</tr>");
		
		// 할인내역을 설정 한다
		var listOdrSalInfoModel = data.listOdrSalInfoModel;
		$(listOdrSalInfoModel).each(function(index, model) {
			if (index == 0) {
				pmtInfo.append("<tr>");
				pmtInfo.append("	<td rowspan='" + $(listOdrSalInfoModel).size() + "'>할인내역</td>");
			} else {
				pmtInfo.append("<tr>");
			}
			
			pmtInfo.append("	<td class='textR'><font class='font_red'>" + comma(model.sal_prc) + " 원</font></td>");
			pmtInfo.append("	<td>" + model.sal_cnts + "</td>");
			pmtInfo.append("</tr>");
		});
		pmtInfo.append("<tr style='background: #f3f3f3;'>");
		pmtInfo.append("	<td class='bold'>합계</td>");
		pmtInfo.append("	<td class='textR bold'>" + comma(m_popPmtMgmt_odrInfo.odr_amut) + " 원</td>");
		pmtInfo.append("	<td></td>");
		pmtInfo.append("</tr>");
		
		$("#popPmtMgmt_pmtInfoDetl").append(pmtInfo.toString());
		
		
		// 납품정보 설정 ==============================
		if (m_popPmtMgmt_odrInfo.dlvr_amut > 0) {
			
			$("#popPmtMgmt_dlvrInfo").removeClass("hidden").addClass("show");
			$("#popPmtMgmt_dlvrInfoDetl").empty();
			
			var dlvrInfo = new StringBuffer();
			var makOdrCnt = m_popPmtMgmt_odrInfo.dlvr_upj_qnty+m_popPmtMgmt_odrInfo.dlvr_loj_qnty;
			
			dlvrInfo.append("<tr style='background: #fff;'>");
			dlvrInfo.append("	<td" + ((wrqDvsCod=="M")?" rowspan='2'":"") + ">" + m_popPmtMgmt_odrInfo.dlvr_dt + "</td>");
			dlvrInfo.append("	<td>" + m_popPmtMgmt_odrInfo.wrq_dvs_cod_nm + "</td>");
			dlvrInfo.append("	<td>" + m_popPmtMgmt_odrInfo.arch_dvs_cod_nm + "</td>");
			dlvrInfo.append("	<td>" + comma(m_popPmtMgmt_odrInfo.org_prc) + " 원</td>");
			dlvrInfo.append("	<td>" + makOdrCnt + ((wrqDvsCod=="M")?" arch":" 부") + "</td>");
			dlvrInfo.append("	<td>" + comma(m_popPmtMgmt_odrInfo.org_prc * makOdrCnt) + " 원</td>");
			dlvrInfo.append("</tr>");
			// 장치제작일 경우 추가 시트 표기
			if (wrqDvsCod == "M") {
				var shetOdrCnt = ((m_popPmtMgmt_odrInfo.dlvr_shet_poa=="N")?0:makOdrCnt);
				dlvrInfo.append("<tr style='background: #fff;'>");
				dlvrInfo.append("	<td>추가시트</td>");
				dlvrInfo.append("	<td>" + m_popPmtMgmt_odrInfo.arch_dvs_cod_nm + "</td>");
				dlvrInfo.append("	<td>" + comma(m_popPmtMgmt_odrInfo.org_prc) + " 원</td>");
				dlvrInfo.append("	<td>" + shetOdrCnt + " arch</td>");
				dlvrInfo.append("	<td>" + comma(m_popPmtMgmt_odrInfo.shet_org_prc * shetOdrCnt) + "  원</td>");
				dlvrInfo.append("</tr>");
			}
			dlvrInfo.append("<tr class='bold' style='background: #f3f3f3;'>");
			dlvrInfo.append("	<td>총금액</td>");
			dlvrInfo.append("	<td colspan='4'></td>");
			dlvrInfo.append("	<td>" + comma(m_popPmtMgmt_odrInfo.dlvr_amut) + " 원</td>");
			dlvrInfo.append("</tr>");

			$("#popPmtMgmt_dlvrInfoDetl").append(dlvrInfo.toString());
		}

		
		// 납품금액 설정 ==============================
		if (m_popPmtMgmt_odrInfo.dlvr_amut > 0) {
			
			$("#popPmtMgmt_dlvrPmtInfo").removeClass("hidden").addClass("show");
			$("#popPmtMgmt_dlvrPmtInfoDetl").empty();
			
			var dlvrPmtInfo = new StringBuffer();
			dlvrPmtInfo.append("<tr>");
			dlvrPmtInfo.append("	<th>정산 완료일</th>");
			dlvrPmtInfo.append("	<td colspan='3'></td>");
			dlvrPmtInfo.append("</tr>");
			dlvrPmtInfo.append("<tr>");
			dlvrPmtInfo.append("	<th rowspan='5'>정산 방법/금액</th>");
			
			var odrAmut = 0;
			var dlvrAmut = 0;
			if (m_popPmtMgmt_odrInfo.dlvr_ctcd_pmt_amut > 0) {
				dlvrPmtInfo.append("	<td>신용카드</td>");
				dlvrPmtInfo.append("	<td class='textR'>" + comma(m_popPmtMgmt_odrInfo.dlvr_ctcd_pmt_amut) + " 원</td>");
				odrAmut = m_popPmtMgmt_odrInfo.ctcd_pmt_amut;
				dlvrAmut = m_popPmtMgmt_odrInfo.dlvr_ctcd_pmt_amut;
			}
			
			if (m_popPmtMgmt_odrInfo.dlvr_actf_pmt_amut > 0) {
				dlvrPmtInfo.append("	<td>실시간 계좌이체</td>");
				dlvrPmtInfo.append("	<td class='textR'>" + comma(m_popPmtMgmt_odrInfo.dlvr_actf_pmt_amut) + " 원</td>");
				odrAmut = m_popPmtMgmt_odrInfo.actf_pmt_amut;
				dlvrAmut = m_popPmtMgmt_odrInfo.dlvr_actf_pmt_amut;
			}
			
			if (m_popPmtMgmt_odrInfo.dlvr_mkdp_pmt_amut > 0) {
				dlvrPmtInfo.append("	<td>무통장 입금</td>");
				dlvrPmtInfo.append("	<td class='textR'>" + comma(m_popPmtMgmt_odrInfo.dlvr_mkdp_pmt_amut) + " 원</td>");
				odrAmut = m_popPmtMgmt_odrInfo.mkdp_pmt_amut;
				dlvrAmut = m_popPmtMgmt_odrInfo.dlvr_mkdp_pmt_amut;
			}
			
			if (m_popPmtMgmt_odrInfo.dlvr_eom_pmt_amut > 0) {
				dlvrPmtInfo.append("	<td>월말 결제</td>");
				dlvrPmtInfo.append("	<td class='textR'>" + comma(m_popPmtMgmt_odrInfo.dlvr_eom_pmt_amut) + " 원</td>");
				odrAmut = m_popPmtMgmt_odrInfo.eom_pmt_amut;
				dlvrAmut = m_popPmtMgmt_odrInfo.dlvr_eom_pmt_amut;
			}
			dlvrPmtInfo.append("	<td>부분취소 금액 : " + comma(odrAmut) + " 원 – " + comma(dlvrAmut) + " 원 = <span class='font_red'>" + comma(odrAmut-dlvrAmut) + " 원</span></td>");
			dlvrPmtInfo.append("</tr>");
			dlvrPmtInfo.append("<tr>");
			dlvrPmtInfo.append("	<td>클리어 캐시</td>");
			dlvrPmtInfo.append("	<td class='textR'>" + comma(m_popPmtMgmt_odrInfo.dlvr_clr_cash_pmt_amut) + " 원</td>");
			dlvrPmtInfo.append("	<td></td>");
			dlvrPmtInfo.append("</tr>");
			// 할인내역을 설정 한다
			var listDlvrSalInfoModel = data.listDlvrSalInfoModel;
			$(listDlvrSalInfoModel).each(function(index, model) {
				if (index == 0) {
					dlvrPmtInfo.append("<tr>");
					dlvrPmtInfo.append("	<td rowspan='" + $(listDlvrSalInfoModel).size() + "'>할인내역</td>");
				} else {
					dlvrPmtInfo.append("<tr>");
				}
				dlvrPmtInfo.append("	<td class='textR'><font class='font_red'>" + comma(model.sal_prc) + " 원</font></td>");
				dlvrPmtInfo.append("	<td>" + model.sal_cnts + "</td>");
				dlvrPmtInfo.append("</tr>");
			});
			dlvrPmtInfo.append("<tr style='background: #f3f3f3;'>");
			dlvrPmtInfo.append("	<td class='bold'>합계</td>");
			dlvrPmtInfo.append("	<td class='textR bold'>" + comma(m_popPmtMgmt_odrInfo.dlvr_amut) + " 원</td>");
			dlvrPmtInfo.append("	<td></td>");
			dlvrPmtInfo.append("</tr>");
			
			$("#popPmtMgmt_dlvrPmtInfoDetl").append(dlvrPmtInfo.toString());
		}
		
		
		// 배송정보 설정 ==============================
		if (wrqDvsCod == "M") {
		
			$("#popPmtMgmt_currInfo").removeClass("hidden").addClass("show");
			
			var currInfo = new StringBuffer();
			$("#popPmtMgmt_currInfoDetl").empty();
			
			currInfo.append("<tr>");
			currInfo.append("	<th>배송일자</th>");
			currInfo.append("	<td>" + (m_popPmtMgmt_odrInfo.send_dt==""?"-":m_popPmtMgmt_odrInfo.send_dt) + "</td>");
			currInfo.append("</tr>");
			currInfo.append("<tr>");
			currInfo.append("	<th>택배사</th>");
			currInfo.append("	<td>" + m_popPmtMgmt_odrInfo.curr_cod_nm + (m_popPmtMgmt_odrInfo.ivc_num==""?"":"(송장번호 : "+m_popPmtMgmt_odrInfo.ivc_num+")") + "</td>");
			currInfo.append("</tr>");
			currInfo.append("<tr>");
			currInfo.append("	<th>받으실 분</th>");
			currInfo.append("	<td>" + m_popPmtMgmt_odrInfo.rcvr_nm + " / " + m_popPmtMgmt_odrInfo.pnn + "</td>");
			currInfo.append("</tr>");
			currInfo.append("<tr>");
			currInfo.append("	<th>주소</th>");
			currInfo.append("	<td>[" + m_popPmtMgmt_odrInfo.zcd + "] " + m_popPmtMgmt_odrInfo.adrs + "</td>");
			currInfo.append("</tr>");

			$("#popPmtMgmt_currInfoDetl").append(currInfo.toString());
		}
		
		
		// 버튼 설정 ==============================
		$("#popPmtMgmt_btnConfirmDps").hide();		// 입금확인
		$("#popPmtMgmt_btnCancelPmt").hide();		// 결제취소
		
		if(m_popPmtMgmt_odrInfo.pmt_dvs_cod == "P") {
			
			if (m_popPmtMgmt_odrInfo.odr_prgr_dvs_cod == "W") {
				
				if (m_popPmtMgmt_odrInfo.prgr_stp_dvs_cod == "B") {
					$("#popPmtMgmt_btnCancelPmt").show();
				} else {
					$("#popPmtMgmt_btnCancelPmt").hide();
				}
				
				$("#popPmtMgmt_btnConfirmDps").show();		// 입금확인
				
			} else if(m_popPmtMgmt_odrInfo.odr_prgr_dvs_cod == "S") {
				
				if (m_popPmtMgmt_odrInfo.prgr_stp_dvs_cod == "B") {
					$("#popPmtMgmt_btnCancelPmt").show();
				} else {
					$("#popPmtMgmt_btnCancelPmt").hide();
				}
			}
			
		} else if(m_popPmtMgmt_odrInfo.pmt_dvs_cod == "C") {
		
			if (m_popPmtMgmt_odrInfo.odr_prgr_dvs_cod == "W") {
				$("#popPmtMgmt_btnConfirmDps").show();		// 입금확인
				$("#popPmtMgmt_btnCancelPmt").show();		// 결제취소
			} else if(m_popPmtMgmt_odrInfo.odr_prgr_dvs_cod == "S") {
				$("#popPmtMgmt_btnCancelPmt").show();		// 결제취소
			}
		}
		
		
		// 모달 팝업
		gfModalPopTop("#popPmtMgmt");
		
	} else {
		// 오류 응답 메시지 출력
		alert(data.resultMsg);
	}
}


/** 결제 취소 */
function fCancelOdrPmt_popPmtMgmt() {
	
	if(!confirm("해당 결제를 취소 하시겠습니까?")) return;
	
	var param = {
			odr_id : m_popPmtMgmt_odrInfo.odr_id
		,	pmt_dvs_cod : m_popPmtMgmt_odrInfo.pmt_dvs_cod
	}

	var resultCallback = function(data) {
		fCancelOdrPmtResult_popPmtMgmt(data);
	};

	callAjax("/odrMgmt/cancelOdrPmt.do", "post", "json", true, param, resultCallback);
}

/** 결제 취소 콜백 함수 */
function fCancelOdrPmtResult_popPmtMgmt(data) {
	
	if (data.result == "SUCCESS") {
		
		alert(data.resultMsg);
		
		// 메인 목록 조회
		if (m_popPmtMgmt_execFunc != null || m_popPmtMgmt_execFunc != "" || m_popPmtMgmt_execFunc == undefined) {
			eval(m_popPmtMgmt_execFunc);
		}
		
		// 모달 팝업 종료
		gfCloseModal();
		
	} else {
		// 오류 응답 메시지 출력
		alert(data.resultMsg);
	}
}

/** 입금 확인 */
function fConfirmDps_popPmtMgmt() {
	
	if (!confirm("입금확인 처리를 하시겠습니까?")) return;
	
	var param = {
			odr_id : m_popPmtMgmt_odrInfo.odr_id
			,	pmt_dvs_cod : m_popPmtMgmt_odrInfo.pmt_dvs_cod
	}
	
	var resultCallback = function(data) {
		fConfirmDpsResult_popPmtMgmt(data);
	};

	callAjax("/odrMgmt/confirmDps.do", "post", "json", true, param, resultCallback);
}

/** 입금 확인 콜백 함수 */
function fConfirmDpsResult_popPmtMgmt(data) {

	if (data.result == "SUCCESS") {
		
		alert(data.resultMsg);
		
		// 메인 목록 조회
		if (m_popPmtMgmt_execFunc != null || m_popPmtMgmt_execFunc != "" || m_popPmtMgmt_execFunc == undefined) {
			eval(m_popPmtMgmt_execFunc);
		}
		
		// 모달 팝업 종료
		gfCloseModal();
		
	} else {
		// 오류 응답 메시지 출력
		alert(data.resultMsg);
	}
}