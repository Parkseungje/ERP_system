package kr.happyjob.study.sales.controller;

import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.sales.model.AccSlipModel;
import kr.happyjob.study.sales.service.SlService;
import kr.happyjob.study.system.model.ComnGrpCodModel;

@Controller
@RequestMapping("/sales")
public class ddRevenueController {

	@Autowired	
	SlService slservice;

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	/**
	 * 일별매출관리 초기화면
	 */
	
	@RequestMapping("/ddRevenue.do")
	public String initddRevenue(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {



		model.addAttribute("tody", "2021-05-10");

		return "sales/ddRevenue";
	}

	/**
	 * 일별매출목록 조회
	 */
	@RequestMapping("listAccSlip.do")
	public String listAccSlip(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".listAccSlip");
		logger.info("   - paramMap : " + paramMap);


		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));	// 현재 페이지 번호
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));			// 페이지 사이즈
		int pageIndex = (currentPage-1)*pageSize;												// 페이지 시작 row 번호

		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		// 공통 그룹코드 목록 조회
		List<AccSlipModel> listAccSlipModel = slservice.listAccSlip(paramMap);
		
		model.addAttribute("listAccSlipModel", listAccSlipModel);

		// 공통 그룹코드 목록 카운트 조회
		int totalCount = slservice.countListddRevenue(paramMap);
		//int totalCount=15;
		model.addAttribute("totalCntddRevenue", totalCount);

		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPageddRevenue",currentPage);

		logger.info("+ End " + className + ".listAccSlip");


		return "/sales/ddRevenueList";
	}	
	
	@RequestMapping("listddAmtSum.do")
	public String listddAmtSum(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".listddAmtSum");
		logger.info("   - paramMap : " + paramMap);

		// 공통 그룹코드 목록 조회
		List<AccSlipModel> listddAmtSumModel = slservice.listddAmtSum(paramMap);
		
		model.addAttribute("listddAmtSumModel", listddAmtSumModel);

		logger.info("+ End " + className + ".listddAmtSum");


		return "/sales/ddRevenueSumList";
	}	
	










}
