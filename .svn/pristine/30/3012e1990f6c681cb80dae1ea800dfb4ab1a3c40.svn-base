package kr.happyjob.study.accounting.controller;

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

import kr.happyjob.study.accounting.model.AcctitleModel;
import kr.happyjob.study.accounting.service.AcctitleService;




@Controller
@RequestMapping("/accounting/")
public class AcctitleController {
		
		@Autowired
		AcctitleService acctitleService;

		// Set logger
		private final Logger logger = LogManager.getLogger(this.getClass());

		@RequestMapping("acctitle.do")
		public String init(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
				HttpServletResponse response, HttpSession session) throws Exception {
			
			return "accounting/acctitle";
		}
		
		@RequestMapping("acctitleList.do")
		public String AccTitleList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
				HttpServletResponse response, HttpSession session) throws Exception {
			
			logger.info("   - paramMap : " + paramMap);
			
			int currentPage = Integer.parseInt((String)paramMap.get("currentPage")); // 현재페이지
		    int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));
		    int pageIndex = (currentPage - 1) * pageSize;
			
			paramMap.put("pageIndex", pageIndex);
			paramMap.put("pageSize", pageSize);
			
			
			List<AcctitleModel> acctitle = acctitleService.acctitle(paramMap);  // 쿼리에서 이용하기위해 paramMap에 담는다.
			
			System.out.println("acctitle : " + acctitle);
			//int admNoticeCnt = acctitleService.admNoticeCnt(paramMap);
			
			model.addAttribute("acctitle", acctitle);
		    //model.addAttribute("admNoticeCnt", admNoticeCnt);
		    model.addAttribute("pageSize", pageSize);
		    model.addAttribute("admCurrentPage",currentPage);
			
			return "accounting/acctitleAdm";
		}
		
		@RequestMapping("acctitleWrite.do")
		@ResponseBody
		public Map<String, Object> acctitleInsert(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
				HttpServletResponse response, HttpSession session)throws Exception{
			System.out.println("param : "+ paramMap);
			acctitleService.acctitleWrite(paramMap);
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			
			resultMap.put("result","게시글 작성을 성공하였습니다.");
			

			return resultMap;
			
		}
		
		@RequestMapping("acctitleUpdateSelect.do")
		@ResponseBody
		public Map<String, Object> acctitleUpdateSelect(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
				HttpServletResponse response, HttpSession session)throws Exception{
			
			AcctitleModel acctitleModel = acctitleService.acctitleUpdateSelect(paramMap);
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			
			resultMap.put("acctitleUpdate", acctitleModel);
			
			resultMap.put("result","SUCCESS");
			resultMap.put("resultMsg","내용을 입력해주세요");
			resultMap.put("resultMsgYes","수정 완료되었습니다.");
			
		
			return resultMap;
			
		}
		
		@RequestMapping("acctitleUpdate.do")
		@ResponseBody
		public Map<String, Object> acctitleUpdate(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
				HttpServletResponse response, HttpSession session)throws Exception{
			
			logger.info("   - paramMap : " + paramMap);
			
			acctitleService.acctitleUpdate(paramMap);
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			
			resultMap.put("result","SUCCESS");
			resultMap.put("resultMsg","내용을 입력해주세요");
			resultMap.put("resultMsgYes","수정 완료되었습니다.");
					
			return resultMap;
			
		}
		
	
}
