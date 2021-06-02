package kr.happyjob.study.dashboard.controller;

import java.util.ArrayList;
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

import kr.happyjob.study.dashboard.model.DashboardModel;
import kr.happyjob.study.dashboard.service.DashboardService;
import kr.happyjob.study.system.model.NoticeModel;
import kr.happyjob.study.system.model.NoticeNewModel;
import kr.happyjob.study.system.service.NoticeService;

@Controller
public class DashboardController {
	
	@Autowired
	NoticeService noticeService;
	DashboardService dashboardService;
	
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	@RequestMapping("/dashboard/dashboard.do")
	public String initDashboard(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		
		logger.info("+ Start " + className + ".initDashboard");
		/* ############## set input data################# */
		paramMap.put("loginId", session.getAttribute("loginId")); // 제목
		paramMap.put("userType", session.getAttribute("userType")); // 오피스 구분 //
																	// 코드
		paramMap.put("date", session.getAttribute("date")); // 등록 일자
		logger.info("   - paramMap : " + paramMap);

		String returnType = "/dashboard/dashboardMgr";

		logger.info("+ end " + className + ".initDashboard");

		return returnType;
	}

	// 공지사항 리스트 출력
	@RequestMapping("/inf/listinf.do")
	public String noticeList(Model model, @RequestParam Map<String, Object> paramMap, 
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("   - paramMap : " + paramMap);
		String title = (String) paramMap.get("title");
		
		int currentPage = Integer.parseInt((String) paramMap.get("currentPage")); // 현재페이지
	    int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
	    int pageIndex = (currentPage - 1) * pageSize;
		
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		paramMap.put("title", title);
		
		// 공지사항 목록 조회
		List<NoticeModel> noticeList = noticeService.noticenewList(paramMap);
		model.addAttribute("notice", noticeList);
		
		// 목록 수 추출해서 보내기
		int noticeCnt = noticeService.noticenewCount(paramMap);
		
	    model.addAttribute("noticeCnt", noticeCnt);
	    model.addAttribute("pageSize", pageSize);
	    model.addAttribute("currentPage",currentPage);
	    
	    return "system/noticeList";
	}
	
	// 공지사항 상세 조회
	@RequestMapping("detailNotice.do")
	@ResponseBody
	public Map<String,Object> detailNotice(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		//System.out.println("상세정보 보기를 위한 param에서 넘어온 값을 찍어봅시다.: " + paramMap);
		  logger.info("+ Start " + className + ".detailNotice");
		  logger.info("   - paramMap : " + paramMap);
		  
		String result="";
		
		// 선택된 게시판 1건 조회 
		NoticeNewModel detailNotice = noticeService.noticenewdetail(paramMap);
		
		if(detailNotice != null) {
			result = "SUCCESS";  // 성공시 찍습니다. 
		}else {
			result = "FAIL / 불러오기에 실패했습니다.";  // null이면 실패입니다.
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("resultMsg", result); // success 용어 담기 
		resultMap.put("result", detailNotice); // 리턴 값 해쉬에 담기 
		//resultMap.put("resultComments", comments);
		System.out.println(detailNotice);
		
		logger.info("+ End " + className + ".detailNotice");
	    
	    return resultMap;
	}
	
	//간이 차트
	@RequestMapping("/dashboard/goChart.do")
	@ResponseBody
	public Map<String,Object> goChart(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		  logger.info("+ Start " + className + ".goChart");
		  logger.info("   - paramMap : " + paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();	
		//List<DashboardModel> goChart = dashboardService.goChart(paramMap);
		//model.addAttribute("goChart", goChart);

		// 값 가져오기
		int cntEngineer = dashboardService.cntEngineer(paramMap);
		int cntCompany = dashboardService.cntCompany(paramMap); 
		int cntProject = dashboardService.cntProject(paramMap);
//		int cntApplicant = dashboardService.cntApplicant(paramMap);
		
		resultMap.put("cntEngineer", cntEngineer);
		resultMap.put("cntCompany", cntCompany);
		resultMap.put("cntProject", cntProject);
//		resultMap.put("cntApplicant", cntApplicant);
		
		logger.info("+ End " + className + ".goChart");
	    
	    return resultMap;
	}

}
