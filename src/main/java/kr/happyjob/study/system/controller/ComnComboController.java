package kr.happyjob.study.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
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
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.common.comnUtils.ComnCodUtil;
import kr.happyjob.study.system.model.comcombo;
import kr.happyjob.study.system.service.ComnComboService;

@Controller
@RequestMapping("/system/")
public class ComnComboController {
	
	@Autowired
	ComnComboService comnComboService;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	/**
	 *  공통 콤보 
	 */
	@RequestMapping("selectComCombo.do")
	@ResponseBody
	public Map<String, Object> selectComCombo (Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".selectComCombo");
		logger.info("   - paramMap : " + paramMap);

		String ComType = (String) paramMap.get("comtype");
			
		List<comcombo> comComboModel = new ArrayList<>();
		
		logger.info("   - ComType : " + ComType);
		
		if("dept".equals(ComType)) {
			// 공통 콤보 조회 부서
			comComboModel = comnComboService.selectdeptlist(paramMap);

		} else if("acc".equals(ComType)) {
			// 공통 콤보 조회 계정 상세
			comComboModel = comnComboService.selectacclist(paramMap);
		} else if("cli".equals(ComType)) {
			// 공통 콤보 조회 거래처 
			comComboModel = comnComboService.selectclientlist(paramMap);
		} else if("pro".equals(ComType)) {
			// 공통 콤보 조회 제품 
			comComboModel = comnComboService.selectproductlist(paramMap);
		} else if("whp".equals(ComType)) {
			// 공통 콤보 조회 창고 담당자 
			comComboModel = comnComboService.selectwhpersonlist(paramMap);
		} else if("wh".equals(ComType)) {
			// 공통 콤보 조회 창고
			comComboModel = comnComboService.selectwhlist(paramMap);
		}
		
		
		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("list", comComboModel);
		
		logger.info("+ End " + className + ".selectComCombo");
		
		return resultMap;
	}
	
	
	/**
	 *  제품 공통 콤보 
	 */
	@RequestMapping("productCombo.do")
	@ResponseBody
	public Map<String, Object> productCombo (Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".productCombo");
		logger.info("   - paramMap : " + paramMap);

		String ComType = (String) paramMap.get("comtype");
			
		List<comcombo> comComboModel = new ArrayList<>();
		
		logger.info("   - ComType : " + ComType);
		
		if("l".equals(ComType)) {
			// 상품 대분류
			comComboModel = comnComboService.selectlargelist(paramMap);
		} else if("m".equals(ComType)) {
			// 상품 중분류
			comComboModel = comnComboService.selectmidlist(paramMap);
		} else if("p".equals(ComType)) {
			// 상품 목록 
			comComboModel = comnComboService.selectdivproductlist(paramMap);
		}
		
		
		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("list", comComboModel);
		
		logger.info("+ End " + className + ".productCombo");
		
		return resultMap;
	}	
	
}
