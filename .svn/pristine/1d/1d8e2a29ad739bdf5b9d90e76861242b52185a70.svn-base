package kr.happyjob.study.community.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.community.model.QnAByinqNoModel;
import kr.happyjob.study.community.model.QnAModel;
import kr.happyjob.study.community.service.QnAService;

@Controller
@RequestMapping("/community/")
public class QnAController {
	
	@Autowired
	QnAService QnAService;


	// Root path for file upload 
	@Value("${fileUpload.rootPath}")
	private String rootPath;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	@RequestMapping("QnA.do")
	public String QnA(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".initCmntBbs");


		return "community/QnA";
	}
	
	/**
	 * 1:1 문의 목록
	 */
	@RequestMapping("listQnA.do")
	public String listQnA(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".listQnA");
		logger.info("   - paramMap : " + paramMap);			
		
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));	// 현재 페이지 번호
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));			// 페이지 사이즈
		int pageIndex = (currentPage-1)*pageSize;												// 페이지 시작 row 번호
				
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		   
		// 공통 1:1문의 목록 조회
		List<QnAModel> listQnA = QnAService.listQnA(paramMap);
		model.addAttribute("listQnA", listQnA);
		
		// 공통 1:1문의 목록 카운트 조회
		int totalCount = QnAService.countListQnA(paramMap);
		model.addAttribute("totalCntlistQnA", totalCount);
		
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPageQnA",currentPage);
		
		logger.info("+ End " + className + ".listQnA");
		 

		return "/community/QnAList";
	}	
	//1:1 단일 조회
			@RequestMapping("QnAByInqNo.do")
			@ResponseBody
			public Map<String, Object> QnAContent(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
					HttpServletResponse response, HttpSession session) throws Exception {
				
				logger.info("+ Start " + className + ".QnAByInqNo");
				logger.info("   - paramMap : " + paramMap);
				
				QnAModel QnAByInqNoModel = QnAService.selectQnAByInqNo(paramMap);
			
				Map<String, Object> resultMap = new HashMap<>();
				resultMap.put("inqNoData", QnAByInqNoModel);
				return resultMap;
			}
			
			@RequestMapping("QnAInAns.do")
			@ResponseBody
			public Map<String, Object> QnAAns (@RequestParam Map<String, Object> paramMap) throws Exception{
				
				int insertQnAAns = QnAService.insertQnAAns(paramMap);
				
				Map<String, Object> map = new HashMap<>();
				
				if(insertQnAAns==1){
					paramMap.put("answer_cd","1");
					int answerONX = QnAService.answerONX(paramMap);
					
					map.put("result", "SUCCESS");
					map.put("resultMsg", "답장완료");
					
				} else{
					
					map.put("result","Fail");
					map.put("resultMsg", "작성 실패");
				}
				
				System.out.println(insertQnAAns);
				
				return map;
			}
			@RequestMapping("deleteInqAns.do")
			@ResponseBody
			public Map<String, Object> QnAAnsDel (Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
					HttpServletResponse response, HttpSession session) throws Exception {
			
					
					
					logger.info("+ Start " + className + ".QnAAnsDel");
					logger.info("   - paramMap : " + paramMap);
					
					String result = "SUCCESS";
					String resultMsg = "삭제 되었습니다.";

					int inqAnsDel = QnAService.inqAnsDel(paramMap);
					
					
					
					paramMap.put("answer_cd", "0");
					
					QnAService.answerONX(paramMap);
					
					
					
					
					Map<String, Object> resultMap = new HashMap<String, Object>();
					resultMap.put("result", result);
					resultMap.put("resultMsg", resultMsg);
					
					logger.info("+ End " + className + ".QnAAnsDel");
					
					return resultMap;
				
				
			}
			
}
	



