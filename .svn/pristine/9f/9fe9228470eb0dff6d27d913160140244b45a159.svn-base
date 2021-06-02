package kr.happyjob.study.business.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.business.service.BmSalePlanService;
import kr.happyjob.study.business.model.BmSalePlanModel;


@Controller
@RequestMapping("/business")


public class BmSalePlanController {

	@Autowired
	BmSalePlanService bmSalePlanService;

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	
	
	@RequestMapping("bmSalePlan.do")
	public String init(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		String loginID = (String) session.getAttribute("loginId");
		model.addAttribute("loginID", loginID);
		paramMap.put("loginID",loginID);
		
		String userType = (String) session.getAttribute("userType");
		model.addAttribute("userType", userType);
		
		
		return "/business/bmSalePlan";
	}
	/**
	 * 영업실적조회 
	 */
	@RequestMapping("listBmSalePlan.do")
	public String listEmpDv(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".listBmSalePlan");
		logger.info("   - paramMap : " + paramMap);
		
				
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));	// 현재 페이지 번호
		int pageSize    = Integer.parseInt((String)paramMap.get("pageSize"));	    // 페이지 사이즈
		int pageIndex   = (currentPage-1)*pageSize;								    // 페이지 시작 row 번호
			
		String loginID = (String) session.getAttribute("loginId");
		//model.addAttribute("loginID", loginID);
		String userType = (String) session.getAttribute("userType");
		
		
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		paramMap.put("loginID", loginID);
		paramMap.put("userType", userType);
		// 지출결의서 목록 조회 : 회계 총무 / 관리자
		List<BmSalePlanModel> listBmSalePlanModel = bmSalePlanService.listBmSalePlan(paramMap);
		model.addAttribute("listBmSalePlanModel", listBmSalePlanModel);
		
		// 지출결의서 목록 카운트 조회 :
		int totalCount = bmSalePlanService.countListBmSalePlan(paramMap);
		
		System.out.println("totalCount: " + totalCount);
		model.addAttribute("totalCntBmSalePlan", totalCount);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPageBmSalePlan",currentPage);
		
		logger.info("+ End " + className + ".listBmSalePlan");
		
		
		return "business/bmSalePlanCallback";
	}	
}
