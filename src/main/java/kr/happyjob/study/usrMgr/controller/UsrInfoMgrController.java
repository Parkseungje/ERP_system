package kr.happyjob.study.usrMgr.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.happyjob.study.common.comnUtils.ComnCodUtil;
import kr.happyjob.study.system.model.ComnCodUtilModel;

@Controller
@RequestMapping("/usrMgr/")
public class UsrInfoMgrController {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();


	
	/**
	 *  오피스 인원정보 초기화면
	 */
	@RequestMapping("usrInfoMgr.do")
	public String initAcutInfoMgr(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".initAcutInfoMgr");
		paramMap.put("ofc_dvs_cod", (String)session.getAttribute("ofcDvsCod")); //내회사 구분 코드
		logger.info("   - paramMap : " + paramMap);

		List<ComnCodUtilModel> listCtrCod = ComnCodUtil.getComnCod("CTR_COD");					// 국가 코드
		List<ComnCodUtilModel> listPnnCtr = ComnCodUtil.getComnCod("PNN_CTR");					// 전화번호 국가
		List<ComnCodUtilModel> listRoleCod = ComnCodUtil.getComnCod("ROLE_COD");				// 역할 코드
		if(paramMap.get("ofc_dvs_cod").equals("A")){ //대리점일시 역할 코드 변경
			listRoleCod = ComnCodUtil.getComnCod("AGNC_ROLE_COD");				// 대리점 역할 코드
		}
		
		
		model.addAttribute("ofc_id", (String)session.getAttribute("ofcId"));//내회사코드
		model.addAttribute("listCtrCod", listCtrCod);				// 국가 코드
		model.addAttribute("listPnnCtr", listPnnCtr);				// 전화번호 국가
		model.addAttribute("listRoleCod", listRoleCod);			// 역할 코드

		logger.info("+ End " + className + ".initAcutInfoMgr");

		return "usrmgr/usrInfoMgr";
	}
}
