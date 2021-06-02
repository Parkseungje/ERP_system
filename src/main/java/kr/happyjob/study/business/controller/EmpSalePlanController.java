package kr.happyjob.study.business.controller;

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

import kr.happyjob.study.business.model.BizPartnerModel;
import kr.happyjob.study.business.model.EmpSalePlanModel;
import kr.happyjob.study.business.service.BizPartnerService;
import kr.happyjob.study.business.service.EmpSalePlanService;

//  영업계획

@Controller
@RequestMapping("/business/")
public class EmpSalePlanController {

	
	
	
	
	/**
	 * 기본생성자같이 기본으로 있어야하는 아무것도 없는 뷰단  
	 */
	// /business/empSalePlan.do
	@RequestMapping("empSalePlan.do")
	public String EmpSalePlan(){
		return "/business/EmpSalePlan";
	}
	
	
	



	@Autowired
	private EmpSalePlanService planService;
	
	
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	private final String className = this.getClass().toString();


	

	/**
	 * model에 List 넣기  == 조회
	 */
    @RequestMapping("planList.do")
    public String planList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
    			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + " ");
	
		
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));	// 현재 페이지 번호 넘어온것
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));			// 페이지 사이즈 넘어온것
		int pageIndex = (currentPage-1)*pageSize;												// 페이지 시작 row 번호 넘어온것
		String client_search =(String) paramMap.get("client_cd");  // 거래처 검색 셀렉트박스 넘어온것
		String from_date =(String) paramMap.get("from_date"); // 날짜 시작 데이터 검색  넘어온것
		String to_date =(String) paramMap.get("to_date"); // 날짜 끝 데이터 검색  넘어온것

		//int sales_pro_seq =Integer.parseInt((String)paramMap.get("sales_pro_seq"));		
		
		
		paramMap.put("pageIndex", pageIndex); // db로
		paramMap.put("pageSize", pageSize); // db로
		
		paramMap.put("client_cd", client_search); // db로
		//paramMap.put("sales_pro_seq", sales_pro_seq); // db로
		
		System.out.println(" pageIndex     " + pageIndex);
		System.out.println(" client_search    " + client_search);
		System.out.println(" from_date    " + from_date);
		System.out.println(" to_date    " + to_date);
		


		System.out.println("planList   컨트롤러로           왔음 ");

		
		// 1 . 목록 리스트 조회 

		List<EmpSalePlanModel> listPlan =planService.planList(paramMap);
		model.addAttribute("listPlan", listPlan);

		
		
		
		
		
		// 2 . 목록 리스트  카운트 조회
		int planCnt =planService.planCnt(paramMap);

		

		
		model.addAttribute("planCnt",planCnt);
		model.addAttribute("from_date", from_date);
		model.addAttribute("to_date", to_date);
		

		logger.info("   - paramMap ? ? ? ? ? ? : " + paramMap);
	
		
		
		return "/business/EmpSalePlanCallBack"; 
	}
	


// 단건 조회 
 	@RequestMapping("planListSelect.do")
 	@ResponseBody
 	public Map<String, Object> planListSelect(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
 			HttpServletResponse response, HttpSession session) throws Exception{
 	
 		String result = "SUCCESS";
 		String resultMsg = "조회 되었습니다.";
 		
 		
 		EmpSalePlanModel planpart = planService.planListSelect(paramMap);
 		
 		 Map<String, Object> resultMap = new HashMap<String, Object>();

 		resultMap.put("result",result); // 컨트롤러 탔으니 성공했다는 메세지 뷰로 보낸다 
 		resultMap.put("planpart",planpart); // 단건조회 목록
 		resultMap.put("resultMsg",resultMsg); // 한국어로 메세지 

 		 
 		logger.info("+ End " + planpart + "planpart"); // log4j  순서도 중요 
 		 System.out.printf("resultMap     ", resultMap);
 		
 		return resultMap ;
 		
 	}
 	
	
 	
 	// 신규거래처 등록 및 기존거래처 수정 
 	@RequestMapping("updatePlanList.do")
	@ResponseBody
	public Map<String, Object> updatePlanList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".updatePlanList");
		logger.info("   - paramMap : " + paramMap);
		
		String action = (String)paramMap.get("action");
		
		String result = "SUCCESS";
		String resultMsg = "저장 되었습니다.";
		
		
		
		// 실제 뷰단의 자바스크립트 =>  $(#"").(data.실제컬럼이름)에서 뿌리고 가져옴
		String sales_pro_seq = request.getParameter("sales_pro_seq");
		System.out.println(" ===>>>>>  sales_pro_seq "+ sales_pro_seq);
				
		


		String loginID = (String) session.getAttribute("loginId");
		paramMap.put("loginID", loginID);
		
		
 		
		
		if ("I".equals(action)) {
			//신규 등록 일때
			planService.insertPlanList(paramMap);
			
		} else if("U".equals(action)) {
			//  수정 할 때 
			planService.insertPlanList(paramMap);
			
		} else {
			result = "FALSE";
			resultMsg = "알수 없는 요청 입니다.";
		}
		
		
		// resultMap => 뷰로 간다 
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("수정 저장 End " + className + ".신규등록 및 수정 ");
		
		
		System.out.println("저장 컨트롤러 ");
		return resultMap;
	}
	
 	
	
 	// 삭제 
 	@RequestMapping("deletePlanList.do")
	@ResponseBody
	public Map<String, Object> deletePlanList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
 		
 		logger.info("+ Start " + className + ".deletePlanList");
		logger.info("   - paramMap : " + paramMap);

		String result = "SUCCESS";
		String resultMsg = "삭제 되었습니다.";
 		

		String sales_pro_seq = request.getParameter("sales_pro_seq");
		System.out.println(" ===>>>>>  sales_pro_seq "+ sales_pro_seq);

		 // client_cd 바로 받아서 삭제 : view단의  param : client_cd -> mapper
		planService.deletePlanList(paramMap);
		

		 Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result); // 잘왔다고 확인 보내주기
		resultMap.put("resultMsg", resultMsg);
		
		
		logger.info("+ End " + className + ".deletePlanList");
		
 		return resultMap;

 	}
 			
 	
	
	
}
