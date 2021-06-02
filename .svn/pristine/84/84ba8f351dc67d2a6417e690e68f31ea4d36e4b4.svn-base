package kr.happyjob.study.dashboard.controller;

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

import kr.happyjob.study.dashboard.model.PcmModel;
import kr.happyjob.study.dashboard.service.DashboardPcmService;

@Controller
public class DashboardPcmController {
	
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	DashboardPcmService service;
	
	
	// 1. 발주 관련 일정 AJAX 로딩 페이지
	@ResponseBody
	@RequestMapping("/dashboard/calendarList.do")
	private List<PcmModel> 	calendarList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception{
		
		//System.out.println("상세정보 보기를 위한 param에서 넘어온 값을 찍어봅시다.: " + paramMap);
		  logger.info("+ Start " + className + ".calendarList");
		  logger.info("   - paramMap : " + paramMap);
		  
		// 매출 목록 조회
		List<PcmModel> calendarList = service.purchaseOrderList(paramMap);
		logger.info("+ End " + className + ".calendarList");
		return calendarList;
		  
	}
	

}
