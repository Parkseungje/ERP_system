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

import kr.happyjob.study.system.model.DeptMgrModel;
import kr.happyjob.study.system.service.DeptService;

@Controller
@RequestMapping("/system/")
public class DeptmngController {
	
	@Autowired
	DeptService deptService;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	
	
	// 처음 로딩될 때 부서관리 연결
	@RequestMapping("deptMgr.do")
	public String init(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".initDept");
		logger.info("   - paramMap : " + paramMap);
		
		String loginID = (String) session.getAttribute("loginId");
		paramMap.put("loginID", loginID);
		System.out.println(loginID);
//		paramMap.put("writer", loginID);
		
		return "system/deptMgr";
	}
	

	// 부서관리 리스트 출력
	@RequestMapping("listdept.do")
	public String deptList(Model model, @RequestParam Map<String, Object> paramMap, 
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".deptList");
		logger.info("   - paramMap : " + paramMap);
		
		int currentPage = Integer.parseInt((String) paramMap.get("currentPage")); // 현재페이지
	    int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
	    int pageIndex = (currentPage - 1) * pageSize;
		
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		List<DeptMgrModel> deptList = deptService.deptList(paramMap);
		
		int deptCnt = deptService.deptCount(paramMap);
		
		model.addAttribute("dept", deptList);
		model.addAttribute("deptCnt", deptCnt);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		
		logger.info("   - deptList : " + deptList.size());
		logger.info("+ End " + className + ".deptList");
		
	    return "system/deptList";
	}
	
	
	// 부서관리 상세 조회
	@RequestMapping("deptdetail.do")
	@ResponseBody
	public Map<String,Object> deptdetail(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		//public DeptMgrModel deptdetail(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		//System.out.println("상세정보 보기를 위한 param에서 넘어온 값을 찍어봅시다.: " + paramMap);
		  logger.info("+ Start " + className + ".detailDept");
		  logger.info("   - paramMap : " + paramMap);
		  logger.info("확인" +paramMap);
		String result="";
		
		// 선택된  1건 조회 
		// **** 한줄 변경. 주석 처리된 부분이 기존 코드입니다. ****
		 DeptMgrModel detailDept = deptService.deptdetail(paramMap);
		//DeptMgrModel detailDept = deptService.deptdetail(paramMap);
		
		if(detailDept != null) {
			result = "SUCCESS";  // 성공시 찍습니다. 
		}else {
			result = "FAIL / 불러오기에 실패했습니다.";  // null이면 실패입니다.
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("resultMsg", result); // success 용어 담기 
		resultMap.put("result", detailDept); // 리턴 값 해쉬에 담기 
		//resultMap.put("resultComments", comments);
		System.out.println(detailDept);
		
		logger.info("+ End " + className + ".detailDept");
	    
	    return resultMap;
		//return detailDept;
	}
	
	// 부서관리 신규등록, 업데이트
	@RequestMapping("deptSave.do")
	@ResponseBody
	public Map<String, Object> deptSave(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		System.out.println("파라미터확인" + paramMap);
		logger.info("+ Start " + className + ".deptSave");
		logger.info("   - paramMap : " + paramMap);
		
		String action = (String)paramMap.get("action");
		String resultMsg = "";
		  
		// 사용자 정보 설정
		paramMap.put("loginID", session.getAttribute("loginId"));
		if ("I".equals(action)) {
			// 그룹코드 신규 저장
			deptService.insertDept(paramMap);
			resultMsg = "SUCCESS";
		} else if("U".equals(action)) {
			// 그룹코드 수정 저장
			deptService.updateDept(paramMap);
			resultMsg = "UPDATED";
			System.out.println("업데이트결과" + paramMap);
		} else {
			resultMsg = "FALSE : 등록에 실패하였습니다.";
		}
		
		//결과 값 전송
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("resultMsg", resultMsg);
	    
	    return resultMap;
	}
	
	// 부서관리 삭제
	@RequestMapping("deptDelete.do")
	@ResponseBody
	public Map<String, Object> deptDelete(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		System.out.println("삭제 호출");
		logger.info("+ Start " + className + ".deptDelete");
		logger.info("   - paramMap : " + paramMap);

				String result = "DELETED";
				String resultMsg = "삭제 되었습니다.";
		
		// **** 변경. 주석은 원본 코드입니다.****
//		deptService.deleteDept(paramMap);
		int resultCode = deptService.deptdelete(paramMap);
		
		System.out.println("삭제확인" + resultCode);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
  	
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End " + className + ".deptDelete");
		
		return resultMap;
	}
	
}
