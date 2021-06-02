package kr.happyjob.study.usrMgr.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.happyjob.study.common.comnUtils.ComnCodUtil;
import kr.happyjob.study.system.model.ComnCodUtilModel;

@Controller
@RequestMapping("/usrMgr/")
public class OfcInfoMgrController {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	/**
	 * 오피스 관리 초기화면
	 */
	@RequestMapping("ofcInfoMgr.do")
	public String initOfcInfoMgr(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".initOfcInfoMgr");
		logger.info("   - paramMap : " + paramMap);
	
		List<ComnCodUtilModel> listOfcDvsCod = ComnCodUtil.getComnCod("OFC_DVS_COD");	// 오피스 구분 코드
		List<ComnCodUtilModel> listDealPoa = ComnCodUtil.getComnCod("DEAL_POA");				// 거래 여부
		List<ComnCodUtilModel> listLstNum = ComnCodUtil.getComnCod("LST_NUM");					// 리스트 갯수
		List<ComnCodUtilModel> listCtrCod = ComnCodUtil.getComnCod("CTR_COD");					// 국가 코드
		List<ComnCodUtilModel> listPnnCtr = ComnCodUtil.getComnCod("PNN_CTR");					// 전화번호 국가
		List<ComnCodUtilModel> listRoleCod = ComnCodUtil.getComnCod("ROLE_COD");				// 역할 코드

		model.addAttribute("ofc_id", (String)session.getAttribute("ofcId"));//내회사코드
		model.addAttribute("ofc_dvs_cod", (String)session.getAttribute("ofcDvsCod"));//내회사구분코드
		model.addAttribute("listOfcDvsCod", listOfcDvsCod);	// 오피스 구분 코드
		model.addAttribute("listDealPoa", listDealPoa);			// 직위 코드
		model.addAttribute("listLstNum", listLstNum);			// 리스트 갯수
		model.addAttribute("listCtrCod", listCtrCod);				// 국가 코드
		model.addAttribute("listPnnCtr", listPnnCtr);				// 전화번호 국가
		model.addAttribute("listRoleCod", listRoleCod);			// 역할 코드
		
		logger.info("+ End " + className + ".initOfcInfoMgr");

		return "usrmgr/ofcInfoMgr";
	}
}
