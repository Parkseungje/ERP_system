package kr.happyjob.study.business.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.business.model.BizPartnerModel;
import kr.happyjob.study.business.service.BizPartnerService;




// 거래처 관리 

// comnGrpCodListController.java  참고 
@Controller
@RequestMapping("/business/")
public class BizPartnerController {
	
	@Autowired(required=true)
	private BizPartnerService bizService;
	
	
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	private final String className = this.getClass().toString();



	/**
	 * 기본생성자같이 기본으로 있어야하는 아무것도 없는 뷰단  
	 */
	@RequestMapping("bizPartner.do")
	public String ClientList(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		return "/business/BizPartner";
	}
	

	


	/**
	 * model에 List 넣기  == 조회
	 */
    @RequestMapping("bizPartnerList.do")
    public String bizPartnerList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
    			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + " ");
		logger.info("   - paramMap ? ? ? ? ? ? : " + paramMap);
		
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));	// 현재 페이지 번호 넘어온것
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));			// 페이지 사이즈 넘어온것
		int pageIndex = (currentPage-1)*pageSize;												// 페이지 시작 row 번호 넘어온것
		String client_search =(String) paramMap.get("client_search");  // 거래처 검색 셀렉트박스 넘어온것
		String from_date =(String) paramMap.get("from_date"); // 날짜 시작 데이터 검색  넘어온것
		String to_date =(String) paramMap.get("to_date"); // 날짜 끝 데이터 검색  넘어온것
		
		
		paramMap.put("pageIndex", pageIndex); // db로
		paramMap.put("pageSize", pageSize); // db로
		
		System.out.println(" pageIndex     " + pageIndex);
		System.out.println(" client_search    " + client_search);
		System.out.println(" from_date    " + from_date);
		System.out.println(" to_date    " + to_date);
		
		logger.info("+ 자바단 컨트롤러 Start " + className + " .clientList");
		logger.info("   자바단 컨트롤러  - paramMap : " + paramMap);
		System.out.println("bizPartnerList   컨트롤러로           왔음 ");

		
		// 1 . 목록 리스트 조회 
		List<BizPartnerModel> clientList = bizService.clientList(paramMap);
		model.addAttribute("clientList", clientList);

		
		
		// 2 . 목록 리스트  카운트 조회
		int cliCnt =bizService.clientCnt(paramMap);

		model.addAttribute("cliCnt",cliCnt);
		model.addAttribute("from_date", from_date);
		model.addAttribute("to_date", to_date);

		

		
		
		return "/business/BizPartnerCallBack"; 
	}
	

// 단건 조회 
 	@RequestMapping("bizPartListSelect.do")
 	@ResponseBody
 	public Map<String, Object> selectClientList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
 			HttpServletResponse response, HttpSession session) throws Exception{
 	
 		String result = "SUCCESS";
 		String resultMsg = "조회 되었습니다.";
 		
 		
 		BizPartnerModel bizpart = bizService.selectClientList(paramMap);
 		
 		 Map<String, Object> resultMap = new HashMap<String, Object>();

 		resultMap.put("result",result); // 컨트롤러 탔으니 성공했다는 메세지 뷰로 보낸다 
 		resultMap.put("bizpart",bizpart); // 단건조회 목록
 		resultMap.put("resultMsg",resultMsg); // 한국어로 메세지 

 		 
 		logger.info("+ End " + bizpart + "bizPart"); // log4j  순서도 중요 
 		 System.out.printf("resultMap     ", resultMap);
 		
 		return resultMap ;
 		
 	}
 	
 	
 	
 	// 신규거래처 등록 및 기존거래처 수정 
 	@RequestMapping("bizPartListSave.do")
	@ResponseBody
	public Map<String, Object> saveBizClient(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".bizPartListSave");
		logger.info("   - paramMap : " + paramMap);
		
		String action = (String)paramMap.get("action");
		
		String result = "SUCCESS";
		String resultMsg = "저장 되었습니다.";
		
		
		
		// 실제 뷰단의 자바스크립트 =>  $(#"").(data.실제컬럼이름)에서 뿌리고 가져옴
		String client_cd = request.getParameter("client_cd");
		System.out.println(" ===>>>>>  client_cd "+ client_cd);
				
		
		// 사용자 정보 설정
		paramMap.put("fst_rgst_sst_id", session.getAttribute("loginId"));
		paramMap.put("fnl_mdfr_sst_id", session.getAttribute("loginId"));



		String loginID = (String) session.getAttribute("loginId");
		paramMap.put("loginID", loginID);
		
		
 		
 		//paramMap =>  디비로 감 
		//이메일 주소 파라미터 받은거 합침 
		paramMap.put("email", (String)paramMap.get("email1") + "@" + (String)paramMap.get("email2"));
		//전화 주소 파라미터
		paramMap.put("tel", (String)paramMap.get("local_tel1") + "-" + (String)paramMap.get("local_tel2") + "-" + (String)paramMap.get("local_tel3"));
		//거래처 담당자 번호
		paramMap.put("emp_hp", (String)paramMap.get("phone_tel1") + "-" + (String)paramMap.get("phone_tel2") + "-" + (String)paramMap.get("phone_tel3"));

	
		
		if ("I".equals(action)) {
			//신규 등록 일때
			bizService.insertClientList(paramMap);
			
		} else if("U".equals(action)) {
			//  수정 할 때 
			bizService.updateClientList(paramMap);
			
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
 	@RequestMapping("bizPartListDelete.do")
	@ResponseBody
	public Map<String, Object> deleteClientList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
 		
 		logger.info("+ Start " + className + ".bizPartListDelete");
		logger.info("   - paramMap : " + paramMap);

		String result = "SUCCESS";
		String resultMsg = "삭제 되었습니다.";
 		

		String client_cd = request.getParameter("client_cd");
		System.out.println(" ===>>>>>  client_cd "+ client_cd);

		 // client_cd 바로 받아서 삭제 : view단의  param : client_cd -> mapper
		bizService.deleteClientList(paramMap);
		

		 Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result); // 잘왔다고 확인 보내주기
		resultMap.put("resultMsg", resultMsg);
		
		
		logger.info("+ End " + className + ".bizPartListDelete");
		
 		return resultMap;

 	}
 			
 	
 	
 	
	
}
