package kr.happyjob.study.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
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

import kr.happyjob.study.common.comnUtils.ComnCodUtil;
import kr.happyjob.study.system.model.ComnCodUtilModel;
import kr.happyjob.study.system.model.ComnDtlCodModel;
import kr.happyjob.study.system.model.ComnGrpCodModel;
import kr.happyjob.study.system.service.ComnCodService;


@Controller
@RequestMapping("/system/")
public class ComnCodController {
	
	@Autowired
	ComnCodService comnCodService;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	

	
	/**
	 * 공통코드 관리 초기화면
	 */
	@RequestMapping("comnCodMgr.do")
	public String initComnCod(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".initComnCod");
		logger.info("   - paramMap : " + paramMap);
		
		logger.info("+ End " + className + ".initComnCod");

		return "system/comncod";
	}
	
	
	/**
	 * 공통 그룹 코드 목록 조회
	 */
	@RequestMapping("listComnGrpCod.do")
	public String listComnGrpCod(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".listComnGrpCod");
		logger.info("   - paramMap : " + paramMap);
		
		
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));	// 현재 페이지 번호
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));			// 페이지 사이즈
		int pageIndex = (currentPage-1)*pageSize;									// 페이지 시작 row 번호
				
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		// 공통 그룹코드 목록 조회
		List<ComnGrpCodModel> listComnGrpCodModel = comnCodService.listComnGrpCod(paramMap);
		model.addAttribute("listComnGrpCodModel", listComnGrpCodModel);
		
		// 공통 그룹코드 목록 카운트 조회
		int totalCount = comnCodService.countListComnGrpCod(paramMap);
		model.addAttribute("totalCntComnGrpCod", totalCount);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPageComnGrpCod",currentPage);
		
		logger.info("+ End " + className + ".listComnGrpCod");
		

		return "/system/comnGrpCodList";
	}	

	/**
	 *  공통 그룹 코드 단건 조회
	 */
	@RequestMapping("selectComnGrpCod.do")
	@ResponseBody
	public Map<String, Object> selectComnGrpCod (Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".selectComnGrpCod");
		logger.info("   - paramMap : " + paramMap);

		String result = "SUCCESS";
		String resultMsg = "조회 되었습니다.";
		
		// 공통 그룹 코드 단건 조회
		ComnGrpCodModel comnGrpCodModel = comnCodService.selectComnGrpCod(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		resultMap.put("comnGrpCodModel", comnGrpCodModel);
		
		logger.info("+ End " + className + ".selectComnGrpCod");
		
		return resultMap;
	}
	
	
	/**
	 *  공통 그룹 코드 저장
	 */
	@RequestMapping("saveComnGrpCod.do")
	//Map 형태 redirect안할때 씀 즉 값만 바꾸겠다.라는 이야기
	@ResponseBody
	public Map<String, Object> saveComnGrpCod(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".saveComnGrpCod");
		logger.info("   - paramMap : " + paramMap);
		
		String action = (String)paramMap.get("action");
		
		String result = "SUCCESS";
		String resultMsg = "저장 되었습니다.";
		
		
		// 사용자 정보 설정
		paramMap.put("fst_rgst_sst_id", session.getAttribute("loginId"));
		paramMap.put("fnl_mdfr_sst_id", session.getAttribute("loginId"));
		if ("I".equals(action)) {
			// 그룹코드 신규 저장
			comnCodService.insertComnGrpCod(paramMap);
		} else if("U".equals(action)) {
			// 그룹코드 수정 저장
			comnCodService.updateComnGrpCod(paramMap);
		} else {
			result = "FALSE";
			resultMsg = "알수 없는 요청 입니다.";
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End " + className + ".saveComnGrpCod");
		
		return resultMap;
	}
	
		
	/**
	 *  그룹코드 삭제
	 */
	@RequestMapping("deleteComnGrpCod.do")
	@ResponseBody
	public Map<String, Object> deleteComnGrpCod(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".deleteComnGrpCod");
		logger.info("   - paramMap : " + paramMap);

		String result = "SUCCESS";
		String resultMsg = "삭제 되었습니다.";
		
		// 그룹코드 삭제
		comnCodService.deleteComnGrpCod(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End " + className + ".deleteComnGrpCod");
		
		return resultMap;
	}
	
	
	/**
	 * 공통 상세 코드 목록 조회
	 */
	@RequestMapping("listComnDtlCod.do")
	public String listComnDtlCod(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".listComnDtlCod");
		logger.info("   - paramMap : " + paramMap);
		
		
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));	// 현재 페이지 번호
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));			// 페이지 사이즈
		int pageIndex = (currentPage-1)*pageSize;												// 페이지 시작 row 번호
		

		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		// 공통 상세코드 목록 조회
		List<ComnDtlCodModel> listComnDtlCodModel = comnCodService.listComnDtlCod(paramMap);
		model.addAttribute("listComnDtlCodModel", listComnDtlCodModel);
		
		// 공통 상세코드 목록 카운트 조회
		int totalCount = comnCodService.countListComnDtlCod(paramMap);
		model.addAttribute("totalCntComnDtlCod", totalCount);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPageComnDtlCod",currentPage);
		
		logger.info("+ End " + className + ".listComnDtlCod");

		return "/system/comnDtlCodList";
	}	

	/**
	 *  공통 상세 코드 단건 조회
	 */
	@RequestMapping("selectComnDtlCod.do")
	@ResponseBody
	public Map<String, Object> selectComnDtlCod (Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".selectComnDtlCod");
		logger.info("   - paramMap : " + paramMap);

		String result = "SUCCESS";
		String resultMsg = "조회 되었습니다.";
		
		// 공통 상세 코드 단건 조회
		ComnDtlCodModel comnDtlCodModel = comnCodService.selectComnDtlCod(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		resultMap.put("comnDtlCodModel", comnDtlCodModel);
		
		logger.info("+ End " + className + ".selectComnDtlCod");
		
		return resultMap;
	}
	
	
	/**
	 *  공통 상세 코드 저장
	 */
	@RequestMapping("saveComnDtlCod.do")
	@ResponseBody
	public Map<String, Object> saveComnDtlCod(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".saveComnDtlCod");
		logger.info("   - paramMap : " + paramMap);

		String action = (String)paramMap.get("action");
		String result = "SUCCESS";
		String resultMsg = "저장 되었습니다.";
		
		// 사용자 정보 설정
		paramMap.put("fst_rgst_sst_id", session.getAttribute("loginId"));
		paramMap.put("fnl_mdfr_sst_id", session.getAttribute("loginId"));
		
		if ("I".equals(action)) {
			// 상세코드 신규 저장
			comnCodService.insertComnDtlCod(paramMap);
		} else if("U".equals(action)) {
			// 상세코드 수정 저장
			comnCodService.updateComnDtlCod(paramMap);
		} else {
			result = "FALSE";
			resultMsg = "알수 없는 요청 입니다.";
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End " + className + ".saveComnDtlCod");
		
		return resultMap;
	}
	
		
	/**
	 *  상세코드 삭제
	 */
	@RequestMapping("deleteComnDtlCod.do")
	@ResponseBody
	public Map<String, Object> deleteComnDtlCod(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".deleteComnDtlCod");
		logger.info("   - paramMap : " + paramMap);

		String result = "SUCCESS";
		String resultMsg = "삭제 되었습니다.";
		
		// 상세코드 삭제
		comnCodService.deleteComnDtlCod(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End " + className + ".deleteComnDtlCod");
		
		return resultMap;
	}


}
