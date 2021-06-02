package kr.happyjob.study.system.controller;

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

import kr.happyjob.study.login.model.UserInfo;
import kr.happyjob.study.system.model.UserMgmtModel;
import kr.happyjob.study.system.service.UserMgmtService;

@Controller
@RequestMapping("/system/")
public class UserMgmtController {

	@Autowired
	UserMgmtService userMgmtService;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	// 사용자 관리 페이지 연결
	@RequestMapping("userMgmt.do")
	public String initUserMgmt(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".initUserMgmt");
		logger.info("   - paramMap : " + paramMap);
		
		String loginID = (String) session.getAttribute("loginId");
		paramMap.put("loginID", loginID);
		System.out.println(loginID);
		
		logger.info("+ End " + className + ".initUserMgmt");

		return "system/userMgmt";
	}

	// 사용자 리스트 출력
	@RequestMapping("userMgmtList.do")
	public String userMgmtList(Model model, @RequestParam Map<String, Object> paramMap, 
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("   - paramMap : " + paramMap);
		//String sname = (String) paramMap.get("sname");
		
		int currentPage = Integer.parseInt((String) paramMap.get("currentPage")); // 현재페이지
	    int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
	    int pageIndex = (currentPage - 1) * pageSize;
		
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		//paramMap.put("sname", sname);
		
		// 사용자 목록 조회
		List<UserMgmtModel> userMgmtList = userMgmtService.userMgmtList(paramMap);
		model.addAttribute("userMgmtList", userMgmtList);
		
		// 목록 수 추출해서 보내기
		int userMgmtCnt = userMgmtService.userMgmtCnt(paramMap);
		
	    model.addAttribute("userMgmtCnt", userMgmtCnt);
	    model.addAttribute("pageSize", pageSize);
	    model.addAttribute("currentPage",currentPage);
	    
	    return "system/userMgmtList";
	}
	
	
	// 사용자 상세 조회 - 회원가입 폼 불러올 부분
	@RequestMapping("userMgmtdetail.do")
	@ResponseBody
	public Map<String,Object> userMgmtdetail(Model model, @RequestParam Map<String, Object> paramMap, 
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		//System.out.println("상세정보 보기를 위한 param에서 넘어온 값을 찍어봅시다.: " + paramMap);
		  logger.info("+ Start " + className + ".userMgmtdetail");
		  logger.info("   - paramMap : " + paramMap);
		  
		String result="";
		
		// 선택된 게시판 1건 조회 
		UserMgmtModel userMgmtdetail = userMgmtService.userMgmtDetail(paramMap);
		
		if(userMgmtdetail != null) {
			result = "SUCCESS"; 
		}else {
			result = "FAIL / 불러오기에 실패했습니다.";  // null이면 실패
		}
		System.out.println(userMgmtdetail);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", userMgmtdetail); // 리턴 값 해쉬에 담기 
		resultMap.put("resultMsg", result); // success 용어 담기 
		//resultMap.put("resultComments", comments);
		
		logger.info("+ End " + className + ".userMgmtdetail");
	    
	    return resultMap;
	}
}
