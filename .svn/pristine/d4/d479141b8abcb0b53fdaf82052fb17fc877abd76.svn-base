package kr.happyjob.study.consupport.controller;

import java.text.SimpleDateFormat;







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
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.consupport.model.ConSupportBModel;
import kr.happyjob.study.consupport.model.NameListModel;
import kr.happyjob.study.consupport.service.ConSupportBService;
import kr.happyjob.study.system.model.ComnDtlCodModel;



@Controller
@RequestMapping("/conSupport/")
public class ConSupportBController {
	private final Logger logger = LogManager.getLogger(this.getClass());

	private final String className = this.getClass().toString();

	@Autowired
	ConSupportBService conSupportBService;
	
	
	@RequestMapping("/conSupportB.do")
	public String conSupportB(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("@@@@@@@@@@@@@START conSupportBManage@@@@@@@@@@@@@@@@@@@");
		logger.info("@@@@@@@@@@@@@END conSupportBManage@@@@@@@@@@@@@@@@@@@@@");
		return "/consupport/conSupportB";
	}

	/**
	 * 공통 그룹 코드 목록 조회
	 */
	@RequestMapping("projectList.do")
	public String listConsupportB(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".listConsupportB");
		logger.info("   - paramMap : " + paramMap);
		
		
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));	// 현재 페이지 번호
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));			// 페이지 사이즈
		int pageIndex = (currentPage-1)*pageSize;												// 페이지 시작 row 번호
				
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		String loginID = (String) session.getAttribute("loginId");		
		paramMap.put("loginID", loginID);
		
		// 공통 그룹코드 목록 조회
		List<ConSupportBModel> listConSupportBModel = conSupportBService.listConSupportB(paramMap);
		model.addAttribute("projectList", listConSupportBModel);
		
		// 공통 그룹코드 목록 카운트 조회
		int totalCount = conSupportBService.countListConSupportB(paramMap);
		model.addAttribute("totalCntConSupportB", totalCount);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPageConSupportB",currentPage);
		
		logger.info("+ End " + className + ".listConSupportB");
		

		return "/consupport/projectList";
	}	
	
	//이름 상세코드 목록조회
	@RequestMapping("/nameList.do")
	public String namelist(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("@@@@@@@@@@@@@@@@START nameList.do @@@@@@@@@@@@@@@@");
		int currentPage = Integer.parseInt((String) paramMap.get("currentPage"));
		int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
		int pageIndex = (currentPage - 1) * pageSize;
		

		paramMap.put("pageIndex", pageIndex);		
		paramMap.put("pageSize", pageSize);

		List<NameListModel> nameList = conSupportBService.nameList(paramMap);
		model.addAttribute("userList", nameList);
		
		int totalCount = conSupportBService.countListlistNameList(paramMap);
		model.addAttribute("totalCntConSupportB", totalCount);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("lecSeq", paramMap.get("lecSeq"));
		logger.info("@@@@@@@@@@@@@@@@nameList.do END@@@@@@@@@@@@@@@@");
		return "/consupport/nameList";
	}
	
	
/*	
		//모달 창
	   공통 상세 코드 단건 조회 
	
	@RequestMapping("selectNameList.do")
	@ResponseBody
	public Map<String, Object> selectNameList (Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".selectNameList");
		logger.info("   - paramMap : " + paramMap);

		String result = "SUCCESS";
		String resultMsg = "조회 되었습니다.";
		
		// 공통 상세 코드 단건 조회
		ConSupportBModel selectNameList = ConSupportBService.selectNameList(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		resultMap.put("selectNameList", selectNameList);
		
		logger.info("+ End " + className + ".selectNameList");
		
		return resultMap;
	}
	*/
	
	
	
	
	/*
	@RequestMapping("saveUserList.do")
	@ResponseBody
	public Map<String, Object> saveUserList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("@@@@@@@@@@@@@@@@@@@@ saveUserList START @@@@@@@@@@@@@@@");
		logger.info("@@@@@@@@@@@@@@@@@@@@PARAMMAP @@@@@@@@@@@@@@@"+paramMap);		
		String action = (String)paramMap.get("action");
		String result = "SUCCESS";
		String resultMsg = "저장되었습니다.";
		
		if("I".equals(action)){
			acService.insertCnsUser(paramMap);
		}else if("U".equals(action)){
			acService.updateCnsUser(paramMap);
		}else{
			result = "FALSE";
			resultMsg = "알수 없는 요청 입니다.";
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("@@@@@@@@@@@@@@@@@@@@ saveUserList END @@@@@@@@@@@@@@@");
		return resultMap;
	}
	@RequestMapping("deleteClist.do")
	@ResponseBody
	public Map<String, Object> deleteClist(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".deleteClist");
		logger.info("   - paramMap : " + paramMap);
		
		String result = "SUCCESS";
		String resultMsg = "삭제 되었습니다.";
		
		acService.deleteClist(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End " + className + ".deleteComnGrpCod");
		
		return resultMap;
	}*/
}