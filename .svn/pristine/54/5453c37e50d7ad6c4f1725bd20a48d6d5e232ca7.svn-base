package kr.happyjob.study.accounting.controller;

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

import kr.happyjob.study.accounting.model.AccSlipModel;
import kr.happyjob.study.accounting.service.AccSlipService;

//import kr.happyjob.study.employee.service.EmpMgtService;

@Controller
@RequestMapping("/accounting/")
public class AccSlipController { 
	
	@Autowired
	AccSlipService AccSlipService;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	//회계전표 초기화면
	@RequestMapping("accSlipF.do")
	public String initAccSlip(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("+ Start " + className + ".accSlipF");
		return "accounting/accSlip";
		
	}
	
	@RequestMapping("accSlipCallback.do")
	public String listAccSlip(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("+ Start " + className + ".accSlipCallback");
		logger.info("   - paramMap : " + paramMap);
		
		int currentPage = Integer.parseInt((String) paramMap.get("currentPage")); // 현재페이지
	    int pageSize = Integer.parseInt((String) paramMap.get("pageSizeAccSlip"));
	    int pageIndex = (currentPage - 1) * pageSize;
	    
	    paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		// 목록 조회
		List<AccSlipModel> listAccSlipModel = AccSlipService.accSlipList(paramMap);
		model.addAttribute("listAccSlipModel", listAccSlipModel);
		
		// 목록 카운트 조회
		int totalCount = AccSlipService.accSlipCnt(paramMap);
		model.addAttribute("totalAccSlipCnt", totalCount);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPageAccSlip",currentPage);
		
		return "accounting/accSlipCallback";
	}
	
	@RequestMapping("accSlipModal.do")
	public String listAccSlipModal(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("+ Start " + className + ".accSlipModal");
		logger.info("   - paramMap : " + paramMap);
		// 목록 조회
		List<AccSlipModel> listAccSlipModelModal = AccSlipService.accSlipModal(paramMap);
		logger.info("   - listAccSlipModelModal : " + listAccSlipModelModal);

		int totalCount = AccSlipService.accSlipCnt(paramMap);
		model.addAttribute("totalCount", totalCount);
		
		model.addAttribute("listAccSlipModelModal", listAccSlipModelModal);
		
		
		return "accounting/accSlipModal";
	}
	
}