package kr.happyjob.study.employee.controller;

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

import kr.happyjob.study.employee.model.EmpTaModel;
import kr.happyjob.study.employee.service.EmpTaApplyService;

//import kr.happyjob.study.employee.service.EmpMgtService;

@Controller
@RequestMapping("/employee/")
public class EmpTaApplyController {
	
	@Autowired
	EmpTaApplyService empTaApplyService;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	// Get class name for logger
	private final String className = this.getClass().toString();

	//근태 신청 조회 초기화면
	@RequestMapping("empTaApply.do")
	public String initEmpTaApply(Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("+ Start " + className + ".empTaApply");
		
		String loginID = (String) session.getAttribute("loginId");
		model.addAttribute("loginID", loginID);
		
		return "employee/empTaApply";
	}
	
	@RequestMapping("empTaApplyCallback.do")
	public String empTaApplyList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("+ Start " + className + ".empTaApplyCallback");
		logger.info("   - paramMap : " + paramMap);
		
		String loginID = (String) session.getAttribute("loginId");
		paramMap.put("loginID", loginID);
		
		int currentPage = Integer.parseInt((String) paramMap.get("currentPage")); // 현재페이지
	    int pageSize = Integer.parseInt((String) paramMap.get("pageSizeEmpTaApply"));
	    int pageIndex = (currentPage - 1) * pageSize;
	    
	    paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		// 목록 조회
		List<EmpTaModel> listEmpTaModel = empTaApplyService.empTaApplyList(paramMap);
		model.addAttribute("listEmpTaModel", listEmpTaModel);
		
		// 목록 카운트 조회
		int totalCount = empTaApplyService.empTaApplyCnt(paramMap);
		model.addAttribute("totalEmpTaApplyCnt", totalCount);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPageEmpTaApply",currentPage);
		
		return "employee/empTaApplyCallback";
	}
	
	@RequestMapping("empTaApplyAnList.do")
	@ResponseBody
	public Map<String,Object>  empTaApplyAnList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("+ Start " + className + ".empTaApplyAnList");
		logger.info("   - paramMap : " + paramMap);
		
		String result = "SUCESS";
		String resultMsg = "조회할 항목이 없습니다.";
		
		String loginID = (String) session.getAttribute("loginId");
		paramMap.put("loginID", loginID);
		
		EmpTaModel  taApply =  empTaApplyService.empTaApplyAnList(paramMap);
		System.out.println("service");
		System.out.println("taApply : " + taApply);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//Integer  totalCnt =  EmpPayHistService.totalCnt(paramMap);
		
		if(taApply == null){
			resultMap.put("resultMsg", resultMsg);
			result = "FAIL";
			//model.addAttribute("totalCnt",totalCnt);
		}else{
			resultMap.put("taApply", taApply);
		} 
		resultMap.put("result", result);
		return resultMap;
	}
	
	@RequestMapping("empTaApplyReturn.do")
	public String empTaApplyReturn(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		EmpTaModel taApplyReturn = empTaApplyService.empTaApplyReturn(paramMap);
		
		model.addAttribute("taApplyReturn", taApplyReturn);
		model.addAttribute("loginID", session.getAttribute("loginId"));
		System.out.println("taApplyReturn : " + taApplyReturn);
				
		return "/employee/empTaApplyReturn";
	}
	/**
	 *  근태신청 저장
	 */
	@RequestMapping("saveEmpTaApply.do")
	@ResponseBody
	public Map<String, Object> saveEmpTaApply(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".saveEmpTaApply");
		logger.info("   - paramMap : " + paramMap);
		
		String result = "SUCCESS";
		String resultMsg = "저장 되었습니다.";
		String loginID = (String) session.getAttribute("loginId");
		paramMap.put("loginID", loginID);
		
			// 그룹코드 신규 저장
		empTaApplyService.insertEmpTaApply(paramMap);

		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End " + className + ".saveEmpTaApply");
		
		return resultMap;
	}
	//근태신청 모달창 데이터 리스트
	@RequestMapping("empTaApplyModal.do")
	@ResponseBody
	public Map<String, Object> admNoticeDetail(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		String loginID = (String) session.getAttribute("loginId");
		paramMap.put("loginID", loginID);
		
		EmpTaModel taApplyModal = empTaApplyService.empTaApplyModal(paramMap);
			
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("taApplyModal", taApplyModal);
		resultMap.put("loginID", loginID);
		resultMap.put("result", "SUCCESS");
		
		System.out.println("taApplyModal : " + taApplyModal);
				
		return resultMap;
	}
}
