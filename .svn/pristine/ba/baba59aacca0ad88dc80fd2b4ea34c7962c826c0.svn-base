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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.business.model.BizPartnerModel;
import kr.happyjob.study.business.model.EstManagementModel;
import kr.happyjob.study.business.service.EstManagementService;

//견적서 작성 및 조회

@Controller
@RequestMapping("/business/")
public class EstManagementController {
	
	
	// EstManagementService EstManagementService 지양
	@Autowired
	private EstManagementService estService; 
	
	
	
	// 프로퍼티 값 
	@Value("${cop.copnm}")
	private String erp_copnm; // 회사이름
	
	@Value("${cop.copnum}")
	private String erp_copnum; //사업자등록번호
	
	@Value("${cop.addr}")
	private String erp_addr; // 주소
	
	@Value("${cop.emp}")
	private String erp_emp; // 담당자
	
	@Value("${cop.tel}")
	private String erp_tel;	 // 회사 번호
	
	
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	private final String className = this.getClass().toString();

	
	// 생성자 같은 느낌 
	@RequestMapping("estManagement.do")
	public String estMangement(){
		return "business/EstManagement";
		
	}
	
	

	/* model에 List 넣기  == 조회*/
    @RequestMapping("estManagementList.do")
    public String estManagementList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
    			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + "estManagementList ");

		
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));	// 현재 페이지 번호 넘어온것
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));			// 페이지 사이즈 넘어온것
		int pageIndex = (currentPage-1)*pageSize;												// 페이지 시작 row 번호 넘어온것
		String client_search =(String) paramMap.get("client_search");  // 거래처 검색 셀렉트박스 넘어온것
		String from_date =(String) paramMap.get("from_date"); // 날짜 시작 데이터 검색  넘어온것
		String to_date =(String) paramMap.get("to_date"); // 날짜 끝 데이터 검색  넘어온것
		
		
		paramMap.put("pageIndex", pageIndex); // db로
		paramMap.put("pageSize", pageSize); // db로
		
		
		System.out.println(" currentPage     " + currentPage);
		System.out.println(" pageIndex     " + pageIndex);
		System.out.println(" client_search    " + client_search);
		System.out.println(" from_date    " + from_date);
		System.out.println(" to_date    " + to_date);
		


		System.out.println("estManagementList   컨트롤러로           왔음 ");

		
		// 1 . 목록 리스트 조회 
		List<EstManagementModel> estList = estService.estList(paramMap); // -> 콜백단으로 보내지는 데이터
		model.addAttribute("estList", estList);

		
		
		// 2 . 목록 리스트  카운트 조회
		int estCnt =estService.estCnt(paramMap);


		model.addAttribute("estCnt",estCnt);
		model.addAttribute("from_date", from_date);
		model.addAttribute("to_date", to_date);

		
		logger.info("   - paramMap ? ? ? ? ? ? : " + paramMap);
		
		return "/business/EstManagementCallBack"; 
	}
	
    
    

// 단건 조회 
 	@RequestMapping("estManagementSelect.do")
 	@ResponseBody
 	public Map<String, Object> selectEstList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
 			HttpServletResponse response, HttpSession session) throws Exception{
 	
 		
		logger.info("+ 자바단 컨트롤러 Start " + className + " .estManagementSelect");
 		
 		String result = "SUCCESS";
 		String resultMsg = "조회 되었습니다.";

 		
 		//단건 조회  
 		//단건조회에 맞는 모달 안 리스트 뽑을 때 estimate_no는 여기서 꺼내서 썼음 
 		EstManagementModel estpart = estService.selectEstList(paramMap); 
 		
 		 Map<String, Object> resultMap = new HashMap<String, Object>();
 		resultMap.put("result",result); // 컨트롤러 탔으니 성공했다는 메세지 뷰로 보낸다 
 		resultMap.put("estpart",estpart); // 단건조회 목록
 		resultMap.put("resultMsg",resultMsg); // 한국어로 메세지 
 		
 		// 회사 프로퍼티 박은거 보내기 
 		resultMap.put("erp_copnm",erp_copnm); // 회사이름 
 		resultMap.put("erp_copnum",erp_copnum); // 사업자번호
 		resultMap.put("erp_addr",erp_addr); // 회사 주소 
 		resultMap.put("erp_emp",erp_emp); // 담당자 이름 
 		resultMap.put("erp_tel",erp_tel); // 담당자 전화번호 
 		
 		
 		System.out.println("erp_tel ?????????????????????? ===" +  erp_tel);
		logger.info("+ End " + estpart + "estpart"); 
		System.out.printf("resultMap     ", resultMap);
	 
	 
	 	logger.info("+ End " + className + "estManagementSelect"); // log4j  순서도 중요 
	 	System.out.printf("resultMap     ", resultMap);
 		System.out.println("estManagementSelect   컨트롤러로           왔음 ");
		 
 		return resultMap ;
 		
 	}
 	
 	

	/* 모달에 foreach문 돌리기 : 단건 조회 항목에 대한 주문 건 리스트  */
    @RequestMapping("estDetaillist.do")
    public String EstDetaillist(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
    			HttpServletResponse response, HttpSession session) throws Exception {


		
		logger.info("+ 자바단 컨트롤러 Start " + className + " .EstDetaillist");
		System.out.println("EstDetaillist   컨트롤러로           왔음 ");


		// 1 . 목록 리스트 조회 
		List<EstManagementModel> estDetailList = estService.estListDetail(paramMap); // -> 콜백단으로 보내지는 데이터
		model.addAttribute("estDetailList", estDetailList);

		
		
		// 2 . 목록 리스트  카운트 조회
		int estDetailCnt =estService.estDetailCnt(paramMap);
		model.addAttribute("estDetailCnt",estDetailCnt);
		
		logger.info("   자바단 컨트롤러  - paramMap : " + paramMap);
		
		return "/business/EstDetailManagementModal"; 
	}
	

 	// 신규 견적서 등록 및 수정 
 	@RequestMapping("estManagementSave.do")
	@ResponseBody
	public Map<String, Object> saveEstManage(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".estManagementSave");

		logger.info("   - paramMap : " + paramMap);
		
		
		String action = (String)paramMap.get("action");
		
		String result = "SUCCESS";
		String resultMsg = "저장 되었습니다.";
		

		

		
		System.out.println("action action action action action " + action);

		// 실제 뷰단의 자바스크립트 =>  $(#"").(data.실제컬럼이름)에서 뿌리고 가져옴
		String estimate_no = request.getParameter("estimate_no");
		System.out.println(" ===>>>>>  estimate_no "+ estimate_no);
		//paramMap.put("estimate_no", estimate_no);
		//paramMap.put("loginID", loginID);

		
		String client_search1 = request.getParameter("client_search1");
		//paramMap.put("client_search1", client_search1);
		System.out.println(" ===>>>>>  client_search1 "+ client_search1);
		
		
		String divproducttall = request.getParameter("divproducttall");
		//paramMap.put("divproducttall", divproducttall);
		System.out.println(" ===>>>>>  divproducttall "+ divproducttall);
		
		String estimate_cnt = request.getParameter("estimate_cnt");
		//paramMap.put("estimate_cnt", estimate_cnt);
		System.out.println(" ===>>>>>  estimate_cnt "+ estimate_cnt);
		

		String loginID = (String) session.getAttribute("loginId");
		paramMap.put("loginID", loginID);



		
		if ("I".equals(action)) {
			


			
			//신규 등록 일때
			//estimate테이블 인서트
			estService.insertEstList(paramMap);

			//estimate_prod 테이블 인서트
			estService.updateInsertEstList(paramMap);


			

			
			System.out.println("---------------------------> 신규등록 ");
			 
			// insert 두번 날리는법 -- 메소드 이름 다르게 
			// estService.insert1EstList(paramMap);
			// estService.insert2EstList(paramMap);
			
			
		} else if("U".equals(action)) {
			//  단건 조회시 
			estService.estListDetail(paramMap);
			System.out.println("------------> 상세 조회");
			
			
		} else {
			result = "FALSE";
			resultMsg = "알수 없는 요청 입니다.";
		}
		
		
		// resultMap => 뷰로 간다 
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("수정 저장 End " + className + ".신규등록 및 수정 ");
		logger.info("   - paramMap : " + paramMap);
		
		System.out.println("저장 컨트롤러 ");
		return resultMap;
	}
	

	
 	// 삭제 
 	@RequestMapping("estManagementListDelete.do")
	@ResponseBody
	public Map<String, Object> deleteEstManage(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
 		
 		logger.info("+ Start " + className + ".estManagementListDelete");
		logger.info("   - paramMap : " + paramMap);

		String result = "SUCCESS";
		String resultMsg = "삭제 되었습니다.";
 		

		String estimate_no = request.getParameter("estimate_no");
		System.out.println(" ===>>>>>  estimate_no "+ estimate_no);

		

		 // estimate_no 바로 받아서 삭제 : view단의  param : estimate_no -> mapper
	 	estService.deleteEstList(paramMap);
		

		 Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result); // 잘왔다고 확인 보내주기
		resultMap.put("resultMsg", resultMsg);
		
		
		logger.info("+ End " + className + ".estManagementListDelete");
		
 		return resultMap;

 	}
 	
 	
 			
 	


}
