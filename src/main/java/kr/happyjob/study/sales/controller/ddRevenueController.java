package kr.happyjob.study.sales.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SimpleTimeZone;

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

import kr.happyjob.study.sales.model.SalesModel;
import kr.happyjob.study.sales.service.DRevService;
import kr.happyjob.study.system.model.ComnGrpCodModel;

@Controller
@RequestMapping("/sales")
public class ddRevenueController {

	@Autowired	
	DRevService dRevService;

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

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c1 = Calendar.getInstance();

        String strToday = sdf.format(c1.getTime());

		model.addAttribute("today", strToday);

		return "sales/ddRevenue";
	}

	/**
	 * 일별매출목록 조회
	 */
	@RequestMapping("listDaySales.do")
	public String listDaySales(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".listDaySales");
		logger.info("   - paramMap : " + paramMap);


		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));	// 현재 페이지 번호
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));			// 페이지 사이즈
		int pageIndex = (currentPage-1)*pageSize;												// 페이지 시작 row 번호

		paramMap.put("pageIndex", pageIndex);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		
		// 일별주문조회 테이블
		List<SalesModel> listDSalesModel = dRevService.listDSales(paramMap);
		
		model.addAttribute("listDSalesModel", listDSalesModel);

		// 일별주문 목록 카운트 조회
		int totalCount = dRevService.countListddRevenue(paramMap);
		
		model.addAttribute("totalCntddRevenue", totalCount);

		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPageddRevenue",currentPage);

		logger.info("+ End " + className + ".listDaySales");


		return "/sales/ddRevenueList";
	}	
	
	@RequestMapping("listDaySalesSum.do")
	public String listDaySalesSum(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".listDaySalesSum");
		logger.info("   - paramMap : " + paramMap);

		// 검색한 날짜 매출통계
		List<SalesModel> listDaySalesSumModel = dRevService.listDaySalesSum(paramMap);
		
		model.addAttribute("listDaySalesSumModel", listDaySalesSumModel);

		logger.info("+ End " + className + ".listDaySalesSum");

		return "/sales/ddRevenueSumList";
	}	
	
	@RequestMapping("viewDaySalesChart.do")
	public String viewDaySalesChart(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".viewDaySalesChart");
		logger.info("   - paramMap : " + paramMap);


		// 공통 그룹코드 목록 조회
		List<SalesModel> listDaySalesChartModel = dRevService.listDaySalesChart(paramMap);

		model.addAttribute("listDaySalesChartModel", listDaySalesChartModel);


		logger.info("+ End " + className + ".viewDaySalesChart");


		return "/sales/ddRevenueSumChart";
	}
	


	










}
