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

import kr.happyjob.study.business.model.EstManagementModel;
import kr.happyjob.study.business.model.OeManagementModel;
import kr.happyjob.study.business.service.EstManagementService;
import kr.happyjob.study.business.service.OeManagementService;
import kr.happyjob.study.common.uuid.OrderCodeGenerator;

//수주관리
@Controller
@RequestMapping("/business/")
public class OeManagementController {
	

	//oemList
	//oemService
	//oempart

	
	
		// EstManagementService EstManagementService 지양
		@Autowired
		private OeManagementService oemService; 
		
		
		
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

		

		@RequestMapping("oeManagement.do")
		public String OeManagement(){			
			return "/business/OeManagement";
		}
		
		

		/* model에 List 넣기  == 조회*/
	    @RequestMapping("oeManagementList.do")
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
			


			System.out.println("OeManagementList   컨트롤러로           왔음 ");


			// 1 . 목록 리스트 조회 
			List<OeManagementModel> oemList = oemService.oemList(paramMap); // -> 콜백단으로 보내지는 데이터
			model.addAttribute("oemList", oemList);

			
			

			
			// 2 . 목록 리스트  카운트 조회
			int oemCnt =oemService.oemCnt(paramMap);


			model.addAttribute("oemCnt",oemCnt);
			model.addAttribute("from_date", from_date);
			model.addAttribute("to_date", to_date);

			
			logger.info("   - paramMap ? ? ? ? ? ? : " + paramMap);
			
			return "/business/OeManagementCallBack"; 
		}
		
	    
	    

	// 단건 조회 
	 	@RequestMapping("oeManagementSelect.do")
	 	@ResponseBody
	 	public Map<String, Object> selectEstList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	 			HttpServletResponse response, HttpSession session) throws Exception{
	 	
	 		
			logger.info("+ 자바단 컨트롤러 Start " + className + " .OeManagementSelect");
	 		
	 		String result = "SUCCESS";
	 		String resultMsg = "조회 되었습니다.";

	 		
	 		//단건 조회  
	 		//단건조회에 맞는 모달 안 리스트 뽑을 때 estimate_no는 여기서 꺼내서 썼음 
	 		OeManagementModel oempart = oemService.selectOemList(paramMap); 
	 		
	 		 Map<String, Object> resultMap = new HashMap<String, Object>();
	 		resultMap.put("result",result); // 컨트롤러 탔으니 성공했다는 메세지 뷰로 보낸다 
	 		resultMap.put("oempart",oempart); // 단건조회 목록
	 		resultMap.put("resultMsg",resultMsg); // 한국어로 메세지 
	 		
	 		// 회사 프로퍼티 박은거 보내기 
	 		resultMap.put("erp_copnm",erp_copnm); // 회사이름 
	 		resultMap.put("erp_copnum",erp_copnum); // 사업자번호
	 		resultMap.put("erp_addr",erp_addr); // 회사 주소 
	 		resultMap.put("erp_emp",erp_emp); // 담당자 이름 
	 		resultMap.put("erp_tel",erp_tel); // 담당자 전화번호 
	 		

	 		
	 		System.out.println("erp_tel ?????????????????????? ===" +  erp_tel);
			logger.info("+ End " + oempart + "oempart"); 
			System.out.printf("resultMap     ", resultMap);
		 
		 
		 	logger.info("+ End " + className + "estManagementSelect"); // log4j  순서도 중요 
		 	System.out.printf("resultMap     ", resultMap);
	 		System.out.println("estManagementSelect   컨트롤러로           왔음 ");
			 
	 		return resultMap ;
	 		
	 	}
	 	
	 	

		/* 모달에 foreach문 돌리기 : 단건 조회 항목에 대한 주문 건 리스트  */
	    @RequestMapping("oeDetailList.do")
	    public String OemDetaillist(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	    			HttpServletResponse response, HttpSession session) throws Exception {


			
			logger.info("+ 자바단 컨트롤러 Start " + className + " .oemDetailList");
			System.out.println("oemDetailList   컨트롤러로           왔음 ");


			// 1 . 목록 리스트 조회 
			List<OeManagementModel> oemDetailList = oemService.oemListDetail(paramMap); // -> 콜백단으로 보내지는 데이터
			model.addAttribute("oemDetailList", oemDetailList);

			
			// 2 . 목록 리스트  카운트 조회
			int oemDetailCnt =oemService.oemDetailCnt(paramMap);
			model.addAttribute("oemDetailCnt",oemDetailCnt);
			
			logger.info("   자바단 컨트롤러  - paramMap : " + paramMap);
			
			return "/business/OeDetailManagementModal"; 
		}
		

	 	// 신규 견적서 등록 및 수정 
	 	@RequestMapping("oeManagementSave.do")
		@ResponseBody
		public Map<String, Object> saveEstManage(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
				HttpServletResponse response, HttpSession session) throws Exception {
			
	 		
	 		
			logger.info("+ Start " + className + ".OeManagementSave");

			logger.info("   - paramMap : " + paramMap);
			
			OrderCodeGenerator  orderCodeGenerator = new OrderCodeGenerator();

			
			
			String action = (String)paramMap.get("action");
			
			String result = "SUCCESS";
			String resultMsg = "저장 되었습니다.";
			

			

			
			System.out.println("action action action action action " + action);


			String receive_num = request.getParameter("receive_num"); // 뷰단에서 가져온 데이터그릇
			System.out.println(" ===>>>>>  receive_num "+ receive_num);

			
			
			String estimate_no = request.getParameter("estimate_no"); // 뷰단에서 가져온 데이터그릇
			System.out.println(" ===>>>>>  estimate_no "+ estimate_no);

			
			String client_search1 = request.getParameter("client_search1");
			System.out.println(" ===>>>>>  client_search1 "+ client_search1);
			

	 		
			
			String divproducttall = request.getParameter("divproducttall");
			System.out.println(" ===>>>>>  divproducttall "+ divproducttall);
		
			String receive_cnt = request.getParameter("receive_cnt");
			System.out.println(" ===>>>>>  	receive_cnt "+ receive_cnt);
			

			String loginID = (String) session.getAttribute("loginId");
			paramMap.put("loginID", loginID);



			
			if ("I".equals(action)) {
				
				

				// insert 두번 날리는법 -- 메소드 이름 다르게 
				
				//신규 등록 일때
				//	eceive 테이블 인서트
				oemService.insertOemList(paramMap);

				//receive_prod 테이블 인서트
				oemService.updateInsertOemList(paramMap);

				
				
				// --> scm 주문번호  : 매퍼단
				String order_code =  orderCodeGenerator.uuidGenerator();
				paramMap.put("order_code", order_code);
				
				
				//scm order  테이블 인서트
				//estService.updateInsertEstList(paramMap);
				


				System.out.println("--------------------------scm 오더 테이블에 안넣어줬음~ -> 신규등록 ");
				 
				
				
			} else if("U".equals(action)) {
				//  단건 조회시 
				oemService.oemListDetail(paramMap);
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
	 	@RequestMapping("oeManagementListDelete.do")
		@ResponseBody
		public Map<String, Object> deleteEstManage(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
				HttpServletResponse response, HttpSession session) throws Exception {
	 		
	 		logger.info("+ Start " + className + ".OeManagementListDelete");
			logger.info("   - paramMap : " + paramMap);

			String result = "SUCCESS";
			String resultMsg = "삭제 되었습니다.";
	

			String receive_num = request.getParameter("receive_num");
			System.out.println(" ===>>>>>  receive_num "+ receive_num);
			
			String emtimate_no = request.getParameter("emtimate_no");
			System.out.println(" ===>>>>>  emtimate_no "+ emtimate_no);


				

			 // estimate_no 바로 받아서 삭제 : view단의  param : estimate_no -> mapper
		 	oemService.deleteOemList(paramMap);
			
		 	

			 Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("result", result); // 잘왔다고 확인 보내주기
			resultMap.put("resultMsg", resultMsg);
			
			
			logger.info("+ End " + className + ".OeManagementListDelete");
			
	 		return resultMap;

	 	}
	 	
	 	
	 			
	 	
	

}
