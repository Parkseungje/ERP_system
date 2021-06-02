package kr.happyjob.study.employee.controller;

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

import kr.happyjob.study.employee.model.BmtaModel;
import kr.happyjob.study.employee.service.BmtaService;

@Controller
@RequestMapping("/employee/")
public class BmtaController {
	
	    @Autowired
		BmtaService bmtaService;
		
		
		@RequestMapping("taapprove.do")
		public String initTaapprove(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
				HttpServletResponse response, HttpSession session) throws Exception {
			
			
			return "employee/taapprove";
		}
		
		@RequestMapping("taapproveList.do")
		public String taapproveList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
				HttpServletResponse response, HttpSession session) throws Exception {
			
			
			int currentPage = Integer.parseInt((String)paramMap.get("currentPage")); // 현재페이지
		    int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));
		    int pageIndex = (currentPage - 1) * pageSize;
			
			paramMap.put("pageIndex", pageIndex);
			paramMap.put("pageSize", pageSize);
			
			
			List<BmtaModel> taapprove = bmtaService.taapprove(paramMap);  // 쿼리에서 이용하기위해 paramMap에 담는다.
			
			int totalCntBmDv = bmtaService.taapprovecnt(paramMap);
			
			
			//int admNoticeCnt = acctitleService.admNoticeCnt(paramMap);
			
			model.addAttribute("taapprove", taapprove);
		    //model.addAttribute("admNoticeCnt", admNoticeCnt);
		    model.addAttribute("pageSize", pageSize);
		    model.addAttribute("admCurrentPage",currentPage);
		    model.addAttribute("totalCntBmDv",totalCntBmDv);
		    
			
			return "employee/taapproveAdm";
		}
		
		@RequestMapping("taapproveUpdateSelect.do")
		@ResponseBody
		public Map<String, Object> taapproveUpdateSelect(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
				HttpServletResponse response, HttpSession session)throws Exception{
			
			BmtaModel taapproveModel = bmtaService.taapproveUpdateSelect(paramMap);
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			
			resultMap.put("taapproveModel", taapproveModel);
			
			resultMap.put("result","SUCCESS");
			resultMap.put("resultMsg","내용을 입력해주세요");
			resultMap.put("resultMsgYes","수정 완료되었습니다.");
			
		
			return resultMap;
			
		}
		
		@RequestMapping("taapproveUpdate.do")
		@ResponseBody
		public Map<String, Object> taapproveUpdate(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
				HttpServletResponse response, HttpSession session)throws Exception{
			
			System.out.println("paramMap : !!!!!!!!!!!!!!!!!!!!!!!!!" + paramMap);
			bmtaService.taapproveUpdate(paramMap);
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			
			resultMap.put("result","SUCCESS");
			resultMap.put("resultMsg","내용을 입력해주세요");
			resultMap.put("resultMsgYes","수정 완료되었습니다.");
					
			return resultMap;
			
		}
}
