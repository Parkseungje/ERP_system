package kr.happyjob.study.employee.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.employee.model.EmployeeModel;
import kr.happyjob.study.employee.service.EmpPayHistService;



@Controller
@RequestMapping("/employee/")
public class EmpPayHistController {
	
	@Autowired
	private EmpPayHistService EmpPayHistService;
	
	
	//급여조회 초기화면  -- 초기화하는 화면 
	@RequestMapping("empPayHist.do")
	public String initEmpPayHist(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		String loginID = (String) session.getAttribute("loginId");
		String userNm = (String) session.getAttribute("userNm");                  // 사용자 성명
		String posnm = (String) session.getAttribute("posnm");            // 로그린 사용자 권란       A: 관리자       B: 기업회원    C:일반회원
		int workyear = (int) session.getAttribute("workyear");
		
		model.addAttribute("loginID", loginID);
		model.addAttribute("userNm", userNm);
		model.addAttribute("posnm", posnm);
		model.addAttribute("workyear", workyear);
		
		
		
		System.out.println("급여조회 초기화면");
		return "/employee/empPayHist";
	}
	
	
	//목록 뿌려주기 
			@RequestMapping("empPayHistList.do")
			@ResponseBody
			public Map<String,Object>  empPayHistList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
					HttpServletResponse response, HttpSession session) throws Exception {
				System.out.println("시작");
				
				String result = "SUCESS";
				String resultMsg = "조회할 항목이 없습니다.";
				
				String loginID = (String) session.getAttribute("loginId");
				paramMap.put("loginID", loginID);
				
				EmployeeModel  payHist =  EmpPayHistService.empPayHistList(paramMap);
				System.out.println("service");
				
				Map<String, Object> resultMap = new HashMap<String, Object>();
				//Integer  totalCnt =  EmpPayHistService.totalCnt(paramMap);
				
				if(payHist == null){
					resultMap.put("resultMsg", resultMsg);
					result = "FAIL";
					//model.addAttribute("totalCnt",totalCnt);
				}else{
					resultMap.put("payHist", payHist);
				} 
				
				resultMap.put("result", result);
				
				return resultMap;
			}
	
}    
