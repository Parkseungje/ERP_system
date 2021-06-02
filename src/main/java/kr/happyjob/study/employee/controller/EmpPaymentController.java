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

import kr.happyjob.study.employee.model.EmployeeModel;
import kr.happyjob.study.employee.service.EmpPaymentService;

@Controller
@RequestMapping("/employee/")
public class EmpPaymentController {
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	// Get class name for logger
	private final String className = this.getClass().toString();

	@Autowired
	EmpPaymentService empPaymentService;
	
	/* 급여관리 초기화면 */
	@RequestMapping("empPayment.do")
	public String initEmpPayment(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("+ Start " + className + ".initEmpPayment");
		
		String userType = (String) session.getAttribute("userType");
		
		model.addAttribute("userType", userType);
		
		return "employee/empPayment";
	}//급여관리 초기화면 끝
	
	/* 급여관리 리스트 전체 조회 */
	@RequestMapping("empPaymentList.do")
	public String empPaymentList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		//콘솔에 로그 찍기
		logger.info("+ Start " + className + ".empPaymentList");
		logger.info("   - paramMap : " + paramMap);
		
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));
		int pageIndex = (currentPage-1)*pageSize;
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		logger.info("   - currentPage : " + currentPage);
		logger.info("   - pageIndex : " + pageIndex);
	
		//급여지급내역 리스트 조회
		List<EmployeeModel> listEmployeeModel = empPaymentService.empPaymentList(paramMap);
		model.addAttribute("listEmployeeModel", listEmployeeModel);
		logger.info("   - listEmployeeModel : " + listEmployeeModel);
		
		//급여지급내역 리스트 총 글 수 조회
		int empPaymentTotalCnt = empPaymentService.countEmpPaymentList(paramMap);
		model.addAttribute("empPaymentTotalCnt", empPaymentTotalCnt);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPageEmpPayment", currentPage);
		
		logger.info("+ End " + className + ".empPaymentList");
		
		return "employee/empPaymentList";
	}
	
	/* 급여관리 상세 리스트 조회 */
	@RequestMapping("listEmpDtlPayment.do")
	@ResponseBody
	public Map<String, Object> listEmpDtlGrade(@RequestParam Map<String, Object> paramMap, HttpServletRequest request
												, HttpServletResponse response, HttpSession session) throws Exception{
		logger.info("+ Start " + className + ".listEmpDtlPayment");
		logger.info("   - paramMap : " + paramMap);
		
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));
		int pageIndex = (currentPage-1)*pageSize;
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		logger.info("   - currentPage : " + currentPage);
		logger.info("   - pageIndex : " + pageIndex);
		
		EmployeeModel empDtl = empPaymentService.viewEmpDtlPayment(paramMap);
		
		//승진 내역 상세 리스트 조회
		List<EmployeeModel> listEmployeeModel = empPaymentService.empDtlPaymentList(paramMap);
		logger.info("   - listEmployeeModel : " + listEmployeeModel);
		
		//승진 내역 상세 리스트 총 글 수 조회
		int empDtlPaymentTotalCnt = empPaymentService.countEmpDtlPaymentList(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("empDtl", empDtl);
		resultMap.put("listEmployeeModel", listEmployeeModel);
		resultMap.put("empDtlPaymentTotalCnt", empDtlPaymentTotalCnt);
		
		resultMap.put("pageSize", pageSize);
		resultMap.put("currentPageEmpDtlPayment", currentPage);
		
		logger.info("+ End " + className + ".listEmpDtlPayment");
		
		return resultMap;
	}
	
	/* 급여지급처리 -> 개인 지급 */
	@RequestMapping("empPaymentProcess.do")
	@ResponseBody
	public Map<String, Object> empPaymentProcess(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		//콘솔에 로그 찍기
		logger.info("+ Start " + className + ".empPaymentProcess");
		logger.info("   - paramMap : " + paramMap);
		
		//jsp에 보낼 result, resultMsg 변수 설정
		String result = "SUCCESS";
		String resultMsg = "지급완료되었습니다.";
		
		empPaymentService.empPaymentProcess(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result",result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End " + className + ".empPaymentProcess");
		
		return resultMap;
	}
	
	
	/* 급여지급처리 -> 일괄 지급 */
	@RequestMapping("allEmpPayment.do")
	@ResponseBody
	public Map<String, Object> allEmpPayment(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		//콘솔에 로그 찍기
		logger.info("+ Start " + className + ".allEmpPayment");
		logger.info("   - paramMap : " + paramMap);
		
		//jsp에 보낼 result, resultMsg 변수 설정
		String result = "SUCCESS";
		String resultMsg = "일괄지급완료되었습니다.";
		
		empPaymentService.allEmpPayment(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result",result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End " + className + ".allEmpPayment");
		
		return resultMap;
	}
}
