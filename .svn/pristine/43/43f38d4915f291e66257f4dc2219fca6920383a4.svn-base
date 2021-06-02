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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.employee.model.EmployeeModel;
import kr.happyjob.study.employee.service.EmpMgtService;

@Controller
@RequestMapping("/employee/")
public class EmpMgtController {
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	// Get class name for logger
	private final String className = this.getClass().toString();
	

	/* 4대보험 properties */
	//국민연금
	@Value("${emp.rate.natps}")
	private float natpsV; 
	//건강보험
	@Value("${emp.rate.hinsure}")
	private float hinsureV; 
	//산재보험
	@Value("${emp.rate.ohsinsure}")
	private float ohsinsureV; 
	//고용보험
	@Value("${emp.rate.einsure}")
	private float einsureV;
	//소득세
	@Value("${emp.rate.incometax}")
	private float incometaxV; 
	
	
	@Autowired
	EmpMgtService empMgtService;
	
	/* 인사관리 초기화면 */
	@RequestMapping("empMgt.do")
	public String initEmpMgt(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("+ Start " + className + ".initEmpMgt");
		
		String userType = (String) session.getAttribute("userType");
		
		model.addAttribute("userType", userType);
		
		return "employee/empMgt";
	}//인사관리 초기화면 끝
	
	/* 인사관리 사원등록 사번 가져오기 */
	@RequestMapping("gainLoginID.do")
	@ResponseBody
	public Map<String, Object> gainLoginID(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		logger.info("+ Start " + className + ".gainLoginID");
		String loginID = empMgtService.gainLoginID();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("loginID", loginID);
		
		logger.info("+ End " + className + ".gainLoginID");
		return resultMap;
	}
	
	/* 인사관리 사원등록 호봉테이블 호출 */
	@RequestMapping("empPaystep.do")
	public String empPaystep() throws Exception {
		logger.info("+ Start " + className + ".empPaystep");
		return "employee/empPaystep";
	}//호봉테이블 호출 끝 

	
	/* 인사관리 사원등록 */
	@RequestMapping("empRegister.do")
	@ResponseBody
	public Map<String, Object> empRegister(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
				HttpServletResponse response, HttpSession session) throws Exception {
		//콘솔에 로그 찍기
		logger.info("+ Start " + className + ".empRegister");
		logger.info("   - paramMap : " + paramMap);
		
		//jsp에 보낼 result, resultMsg 변수 설정
		String action = (String)paramMap.get("action");
		String result = "SUCCESS";
		String resultMsg = "등록되었습니다.";
		
		//이메일 주소 합치기
		paramMap.put("mail", (String)paramMap.get("mail1") + "@" + (String)paramMap.get("mail2"));
		//전화 번호 합치기
		paramMap.put("tel", (String)paramMap.get("tel1") + "-" + (String)paramMap.get("tel2") + "-" + (String)paramMap.get("tel3"));
		
		//4대보험 퍼센트 map에 담기
		paramMap.put("natpsV", natpsV);
		paramMap.put("hinsureV", hinsureV);
		paramMap.put("ohsinsureV", ohsinsureV);
		paramMap.put("einsureV", einsureV);
		paramMap.put("incometaxV", incometaxV);
		/* [기준소득월액은 최저 32만원에서 최고금액은 503만원까지의 범위로 결정하게 됩니다. 
		   따라서, 신고한 소득월액이 32만원보다 적으면 32만원을 기준소득월액으로 하고, 503만원보다 많으면 503만원을 기준소득월액으로 합니다.]
		-> 실제 4대보험 세액 공제는 위의 문장처럼 진행되지만, 지금 프로젝트에서는 최저,최고 금액 상관 없이 세액 계산하기로 하였음. */
		
		if("I".equals(action)) {
			empMgtService.empRegister(paramMap, request);
			
		}else if ("U".equals(action)) {
			empMgtService.updateEmp(paramMap, request);
			resultMsg = "수정되었습니다.";
			
		}else {
			result = "FALSE";
			resultMsg = "알 수 없는 요청입니다.";
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result",result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End " + className + ".empRegister");
		
		return resultMap;
	}//인사관리 사원등록 끝
	
	/* 인사관리 사원 리스트 조회 */
	@RequestMapping("showEmpList.do")
	public String showEmpList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		//콘솔에 로그 찍기
		logger.info("+ Start " + className + ".showEmpList");
		logger.info("   - paramMap : " + paramMap);
		
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));
		int pageIndex = (currentPage-1)*pageSize;
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		logger.info("   - currentPage : " + currentPage);
		logger.info("   - pageIndex : " + pageIndex);
		
		//사원 리스트 조회
		List<EmployeeModel> listEmployeeModel = empMgtService.showEmpList(paramMap);
		model.addAttribute("listEmployeeModel", listEmployeeModel);
		logger.info("   - listEmployeeModel : " + listEmployeeModel);
		
		//사원 리스트 총 글 수 조회
		int empTotalCnt = empMgtService.countEmpList(paramMap);
		model.addAttribute("empTotalCnt", empTotalCnt);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPageEmpList", currentPage);
		
		logger.info("+ End " + className + ".showEmpList");
		
		return "employee/empList";
	}

	/* 인사관리 사원 상세정보 조회 */
	@RequestMapping("viewEmpDtl.do")
	@ResponseBody
	public Map<String, Object> viewEmpDtl(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("+ Start " + className + ".viewEmpDtl");
		logger.info("   - paramMap : " + paramMap);
		
		String result = "SUCCESS";
		String resultMsg = "조회 실패";
		
		EmployeeModel empDtl = empMgtService.viewEmpDtl(paramMap);
		logger.info("   - empDtl : " + empDtl);
		
		int workyear = empMgtService.getWorkyear(paramMap);
		String imgPath = "/imgPath/"+empDtl.getLoginID()+"/"+empDtl.getFilename();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		resultMap.put("empDtl", empDtl);
		resultMap.put("workyear", workyear);
		resultMap.put("imgPath", imgPath);
		
		logger.info("+ End " + className + ".viewEmpDtl");
		
		return resultMap;
	}
	
	/* 인사관리 퇴사처리 */
	@RequestMapping("resignEmp.do")
	@ResponseBody
	public Map<String, Object> resignEmp(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		//콘솔에 로그 찍기
		logger.info("+ Start " + className + ".resignEmp");
		logger.info("   - paramMap : " + paramMap);
		
		//jsp에 보낼 result, resultMsg 변수 설정
		String result = "SUCCESS";
		String resultMsg = "퇴사처리되었습니다.";
		
		empMgtService.resignEmp(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result",result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End " + className + ".resignEmp");
		
		return resultMap;
	}
	
	/* 인사관리 정보삭제 */
	@RequestMapping("deleteEmp.do")
	@ResponseBody
	public Map<String, Object> deleteEmp(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		//콘솔에 로그 찍기
		logger.info("+ Start " + className + ".deleteEmp");
		logger.info("   - paramMap : " + paramMap);
		
		//jsp에 보낼 result, resultMsg 변수 설정
		String result = "SUCCESS";
		String resultMsg = "삭제되었습니다.";
		
		empMgtService.deleteEmp(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result",result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End " + className + ".deleteEmp");
		
		return resultMap;
	}
	
	/* 승진내역관리 초기화면*/
	@RequestMapping("empGrade.do")
	public String initEmpGrade(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("+ Start " + className + ".initEmpGrade");
		
		return "employee/empGrade";
	}//승진내역관리 초기화면 끝
	
	
	/* 승진내역관리 전체 리스트 조회 */
	@RequestMapping("listEmpGrade.do")
	public String listEmpGrade(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		//콘솔에 로그 찍기
		logger.info("+ Start " + className + ".listEmpGrade");
		logger.info("   - paramMap : " + paramMap);
		
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));
		int pageIndex = (currentPage-1)*pageSize;
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		logger.info("   - currentPage : " + currentPage);
		logger.info("   - pageIndex : " + pageIndex);
		
		//승진 내역 리스트 조회
		List<EmployeeModel> listEmployeeModel = empMgtService.empGradeList(paramMap);
		model.addAttribute("listEmployeeModel", listEmployeeModel);
		logger.info("   - listEmployeeModel : " + listEmployeeModel);
		
		//승진 내역 리스트 총 글 수 조회
		int empGradeTotalCnt = empMgtService.countEmpGradeList(paramMap);
		model.addAttribute("empGradeTotalCnt", empGradeTotalCnt);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPageEmpGrade", currentPage);
		
		logger.info("+ End " + className + ".listEmpGrade");
		
		return "employee/empGradeList";
	}
	
	/* 승진내역관리 상세 리스트 조회 */
	@RequestMapping("listEmpDtlGrade.do")
	@ResponseBody
	public Map<String, Object> listEmpDtlGrade(@RequestParam Map<String, Object> paramMap, HttpServletRequest request
												, HttpServletResponse response, HttpSession session) throws Exception{
		logger.info("+ Start " + className + ".listEmpDtlGrade");
		logger.info("   - paramMap : " + paramMap);
		
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));
		int pageIndex = (currentPage-1)*pageSize;
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		logger.info("   - currentPage : " + currentPage);
		logger.info("   - pageIndex : " + pageIndex);
		
		EmployeeModel empDtl = empMgtService.viewEmpDtl(paramMap);
		
		//승진 내역 상세 리스트 조회
		List<EmployeeModel> listEmployeeModel = empMgtService.empDtlGradeList(paramMap);
		logger.info("   - listEmployeeModel : " + listEmployeeModel);
		
		//승진 내역 상세 리스트 총 글 수 조회
		int empDtlGradeTotalCnt = empMgtService.countEmpDtlGradeList(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("empDtl", empDtl);
		resultMap.put("listEmployeeModel", listEmployeeModel);
		resultMap.put("empDtlGradeTotalCnt", empDtlGradeTotalCnt);
		
		resultMap.put("pageSize", pageSize);
		resultMap.put("currentPageEmpDtlGrade", currentPage);
		
		logger.info("+ End " + className + ".listEmpDtlGrade");
		
		return resultMap;
	}
	
}
