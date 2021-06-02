package kr.happyjob.study.sales.controller;

import java.util.HashMap;
import java.util.List;
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

import kr.happyjob.study.accounting.service.AccSlipService;
import kr.happyjob.study.sales.model.ArmngModel;
import kr.happyjob.study.sales.service.ArmngService;



@Controller
@RequestMapping("/sales/")
public class ArmngController {
	
	@Autowired
	ArmngService armngService;
	
	@Autowired
	AccSlipService accSlipService;

	@RequestMapping("armngMain.do")
	public String initArManagement(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		return "sales/ArManagement";
	}
	
	@RequestMapping("armngList.do")
	public String AccTitleList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage")); // 현재페이지
	    int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));
	    int pageIndex = (currentPage - 1) * pageSize;
		
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		
		List<ArmngModel> armngtitle = armngService.armngtitle(paramMap);  // 쿼리에서 이용하기위해 paramMap에 담는다.
		
		model.addAttribute("armngtitle", armngtitle);
	    model.addAttribute("pageSize", pageSize);
	    model.addAttribute("admCurrentPage",currentPage);
		
		return "sales/ArManagementAdm";
	}
	
	@RequestMapping("armngSelect.do")
	@ResponseBody
	public Map<String, Object> acctitleUpdateSelect(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session)throws Exception{
		
		
		String loginID = (String) session.getAttribute("loginId");
		model.addAttribute("loginID", loginID);
		
		
		
		ArmngModel armngModel = armngService.armngSelect(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("armngModel", armngModel);
		
		resultMap.put("result","SUCCESS");
		resultMap.put("resultMsg","내용을 입력해주세요");
		resultMap.put("resultMsgYes","수정 완료되었습니다.");
		resultMap.put("loginID",loginID);
		
		return resultMap;
			
	}
	
	@RequestMapping("armngUpdate.do")
	@ResponseBody
	public Map<String, Object> acctitleUpdate(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session)throws Exception{
		

		armngService.armngUpdate(paramMap); // 미수금관리에서 수동으로 입금완료 업데이트
		
		accSlipService.accSlipInsert(paramMap); // 회계전표테이블 인서트
		
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("result","SUCCESS");
		resultMap.put("resultMsg","내용을 입력해주세요");
		resultMap.put("resultMsgYes","입금 완료되었습니다.");
				
		return resultMap;
		
	}
}