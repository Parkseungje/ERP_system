package kr.happyjob.study.accounting.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;

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




import kr.happyjob.study.accounting.model.DvModel;
import kr.happyjob.study.accounting.service.DvService;


@Controller
@RequestMapping("/accounting")



public class DvController {
	@Autowired
	DvService dvService;
	
	@Value("${fileUpload.rootPath}")
	private String rootPath;
	@Value("${fileUpload.accimgPath}")
	private String accimgPath;

	
	
	
	
		// Set logger
		private final Logger logger = LogManager.getLogger(this.getClass());

		// Get class name for logger
		private final String className = this.getClass().toString();
		
	
	
	/* 지출결의서  초기화면  호출(신청페이지)   : 권한 - 회계 총무 / 관리자 / 임원 */
	
	@RequestMapping("empDv.do")
	public String initEmpDv(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		
		String userType = (String) session.getAttribute("userType");
		String loginID = (String) session.getAttribute("loginId");
		
		model.addAttribute("userType", userType);
		model.addAttribute("loginID", loginID);
		
		return "accounting/dvmain"; /* 호출할 jsp 파일명 */
	}
	
	
	/* 지출결의서 승인  초기화면  호출(승인페이지) : 회계 총무  / 임원 */
	
	@RequestMapping("bmDv.do")
	public String initBmDv(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		String userType = (String) session.getAttribute("userType");
		String loginID = (String) session.getAttribute("loginId");
		
		model.addAttribute("userType", userType);
		model.addAttribute("loginID", loginID);
		
		return "accounting/dvapprove"; /* 호출할 jsp 파일명 */
	}
	
	
	/**
	 * 지출결의서 목록 조회(신청페이지) : 회계 총무 / 관리자 / 영업   
	 */
	@RequestMapping("listEmpDv.do")
	public String listEmpDv(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".listEmpDv");
		logger.info("   - paramMap : " + paramMap);
		
				
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));	// 현재 페이지 번호
		int pageSize    = Integer.parseInt((String)paramMap.get("pageSize"));	    // 페이지 사이즈
		int pageIndex   = (currentPage-1)*pageSize;								    // 페이지 시작 row 번호
			
		String loginID = (String) session.getAttribute("loginId");
		model.addAttribute("loginID", loginID);
		
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		paramMap.put("loginID", loginID);
		
		// 지출결의서 목록 조회 : 회계 총무 / 관리자
		List<DvModel> listEmpDvModel = dvService.listEmpDv(paramMap);
		model.addAttribute("listEmpDvModel", listEmpDvModel);
		
		// 지출결의서 목록 카운트 조회 :
		int totalCount = dvService.countListEmpDv(paramMap);
		model.addAttribute("totalCntEmpDv", totalCount);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPageEmpDv",currentPage);
		
		logger.info("+ End " + className + ".listEmpDv");
		
		
		return "accounting/empDvCallback";
	}	

	
	/**
	 * 지출결의서  목록 조회(승인페이지) : 회계 총무 / 관리자 / 영업
	 */
	@RequestMapping("listBmDv.do")
	public String listBmDv(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".listBmDv");
		logger.info("   - paramMap : " + paramMap);
		
				
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));	// 현재 페이지 번호
		int pageSize    = Integer.parseInt((String)paramMap.get("pageSize"));	    // 페이지 사이즈
		int pageIndex   = (currentPage-1)*pageSize;								    // 페이지 시작 row 번호
			
		
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		// 지출결의서 목록 조회 : 회계 총무 / 관리자
		List<DvModel> listBmDvModel = dvService.listBmDv(paramMap);
		model.addAttribute("listBmDvModel", listBmDvModel);
		
		// 지출결의서 목록 카운트 조회 :
		int totalCount = dvService.countListBmDv(paramMap);
		model.addAttribute("totalCntBmDv", totalCount);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPageBmDv",currentPage);
		
		logger.info("+ End " + className + ".listBmDv");
		
		
		return "accounting/bmDvCallback";
	}	
	

	
	/**
	 *  지출결의서 단건 조회(신청페이지) : 회계 총무 / 관리자 / 영업
	 */
	@RequestMapping("selectEmpDv.do")
	@ResponseBody
	public Map<String, Object> selectEmpDv(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		
		DvModel empDvModel = dvService.selectEmpDv(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
	
		resultMap.put("empDvModel", empDvModel);
		
		return resultMap;
	}

	/**
	 *  지출결의서 단건 조회(신청페이지) : 회계 총무 / 관리자 / 영업 */
	
	@RequestMapping("selectBmDv.do")
	@ResponseBody
	public Map<String, Object> selectBmDv(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		
		DvModel bmDvModel = dvService.selectBmDv(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
	
		resultMap.put("bmDvModel", bmDvModel);
		
		return resultMap;
	}	
	
		
	
	/**  지출결의서 저장(신청페이지)    :  회계  총무 / 관리자  / 영업  **/
	
	@RequestMapping("saveEmpDv.do")
	//Map 형태 redirect안할때 씀 즉 값만 바꾸겠다.라는 이야기
	@ResponseBody
	public Map<String, Object> saveEmpDv(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".saveEmpDv");
		logger.info("   - paramMap : " + paramMap);
		
		String action = (String)paramMap.get("action");
		String result = "SUCCESS";
		String resultMsg = "저장 되었습니다.";
		
		
		logger.info("action :" + action);
		
		String loginID = (String)session.getAttribute("loginId");
		model.addAttribute("loginID", loginID);
		
		logger.info("   - sql before  : " + paramMap);
		if ("I".equals(action)) {
			// 그룹코드 신규 저장
			dvService.insertEmpDv(paramMap, request);
		}  else {
			result = "FALSE";
			resultMsg = "알수 없는 요청 입니다.";
			
		}
		

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End " + className + ".saveEmpDv");
		
		/*String dv_no = dvService.selectDv_no(paramMap);
		logger.info("dv_no :  " + dv_no);
		*/
		
		return resultMap;
	}
	
	/**
	 *  지출결의 삭제(신청페이지)
	 */
	@RequestMapping("deleteEmpDv.do")
	@ResponseBody
	public Map<String, Object> deleteEmpDv(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".deleteEmpDv");
		logger.info("   - paramMap : " + paramMap);

		String result = "SUCCESS";
		String resultMsg = "삭제 되었습니다.";
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		// 상세코드 삭제
		dvService.deleteEmpDv(paramMap);
		
	
		logger.info("+ End " + className + ".deleteEmpDv");
		
		return resultMap;
	}
	
	
	
	/**
	 *  지출결의 승인 (승인페이지)
	 */
	@RequestMapping("saveAppDv.do")
	@ResponseBody
	public Map<String, Object> appDv(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".saveAppDv");
		logger.info("   - paramMap : " + paramMap);

		
		String appLoginID = (String)session.getAttribute("loginId");
		paramMap.put("appLoginID",appLoginID);
		
		String result = "SUCCESS";
		String resultMsg = "처리 되었습니다.";
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		dvService.saveAppDv(paramMap);
		
		logger.info("+ End " + className + ".saveAppDv");

		return resultMap;
	}

	
	/**
	 *  지출결의 첨부파일 경로 가져오기
	 */
	@RequestMapping("selectAttFile.do")
	@ResponseBody
	public Map<String, Object> selectAttFile(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();

		String selectAttFile = dvService.selectAttFile(paramMap);
		
		resultMap.put("attFilePath", selectAttFile);

		return resultMap;
			
	}
	
	@RequestMapping("downloadDvFile.do")
	@ResponseBody
	   /**
	    * 첨부파일 다운로드
	    */
	   public void downloadDvAttFile(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	   
	      logger.info("+ Start " + className + ".downloadAttDvFile");
	      logger.info("   - paramMap : " + paramMap);
	      
	      String dv_no = (String) paramMap.get("dv_no");
	      
	      // 첨부파일 조회
	      String downloadAttDvFile = dvService.selectAttFile(paramMap);
	      
	      byte fileByte[] = FileUtils.readFileToByteArray(new File(rootPath + accimgPath + dv_no + File.separator + downloadAttDvFile));
	      
	       response.setContentType("application/octet-stream");
	       response.setContentLength(fileByte.length);
	       response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(downloadAttDvFile,"UTF-8")+"\";");
	       response.setHeader("Content-Transfer-Encoding", "binary");
	       response.getOutputStream().write(fileByte);
	        
	       response.getOutputStream().flush();
	       response.getOutputStream().close();

	      logger.info("+ End " + className + ".downloadAttDvFile");
	   }
	
}

	



