package kr.happyjob.study.supportD.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import kr.happyjob.study.supportD.model.NoticeDModel;
import kr.happyjob.study.supportD.service.NoticeDService;

@Controller
@RequestMapping("/supportD/")
public class NoticeDController {

	@Autowired
	NoticeDService noticeDService;

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	/* 자유게시판 -초기화면 */
	@RequestMapping("notice.do")
	public String initNotice(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".initNotice");
		logger.info("   - paramMap : " + paramMap);

		// 로그인해서 리스트를 먼저 뿌린다.
		model.addAttribute("writer", session.getAttribute("loginId"));
		// 작성 초기 단계에서 쓰려고 미리 뿌린다.
		// System.out.println("writer : " + session.getAttribute("loginId"));

		logger.info("+ End " + className + ".initNotice");

		return "supportD/noticeD";
	}

	/* 공지사항 리스트 뿌리기 */
	@RequestMapping("noticeList.do")
	public String noticeList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		
		
		logger.info("+ Start " + className + ".noticeList");
		logger.info("   - paramMap : " + paramMap);
		// System.out.println("param에서 넘어온 값을 찍어봅시다.: " + paramMap);

		// jsp페이지에서 넘어온 파람 값 정리 (페이징 처리를 위해 필요)
		int currentPage = Integer.parseInt((String) paramMap.get("currentPage")); // 현재페이지
		int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
		int pageIndex = (currentPage - 1) * pageSize;

		// 사이즈는 int형으로, index는 2개로 만들어서 -> 다시 파람으로 만들어서 보낸다.
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);

		// 세션값 로그인 아이디 - 세종
		paramMap.put("loginId", session.getAttribute("loginId"));

		// 서비스 호출
		List<NoticeDModel> noticeList = noticeDService.noticeList(paramMap);
		model.addAttribute("noticeList", noticeList);

		// 목록 숫자 추출하여 보내기
		int totalCnt = noticeDService.noticeTotalCnt(paramMap);
		model.addAttribute("totalCnt", totalCnt);

		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPage", currentPage);

		// System.out.println("자 컨트롤러에서 값을 가지고 jsp로 갑니다~ : " +
		// freeboardlist.size());
		logger.info("+ End " + className + ".noticeList");

		return "supportD/noticeListD";
	}

	/* 공지사항 리스트 뿌리기 */
	@RequestMapping("noticeListvue.do")
	@ResponseBody
	public Map<String, Object> noticeListvue(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".noticeListvue");
		logger.info("   - paramMap : " + paramMap);
		// System.out.println("param에서 넘어온 값을 찍어봅시다.: " + paramMap);

		// jsp페이지에서 넘어온 파람 값 정리 (페이징 처리를 위해 필요)
		int currentPage = Integer.parseInt((String) paramMap.get("currentPage")); // 현재페이지
		int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
		int pageIndex = (currentPage - 1) * pageSize;

		// 사이즈는 int형으로, index는 2개로 만들어서 -> 다시 파람으로 만들어서 보낸다.
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);

		// 서비스 호출
		List<NoticeDModel> noticeList = noticeDService.noticeList(paramMap);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("noticeList", noticeList);

		// 목록 숫자 추출하여 보내기
		int totalCnt = noticeDService.noticeTotalCnt(paramMap);
		resultMap.put("totalCnt", totalCnt);

		// System.out.println("자 컨트롤러에서 값을 가지고 jsp로 갑니다~ : " +
		// freeboardlist.size());
		logger.info("+ End " + className + ".noticeListvue");

		return resultMap;
	}

	/* 공지사항 상세 정보 뿌리기 */
	@RequestMapping("detailNoticeList.do")
	@ResponseBody
	public Map<String, Object> detailList(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		// System.out.println("상세정보 보기를 위한 param에서 넘어온 값을 찍어봅시다.: " + paramMap);
		logger.info("+ Start " + className + ".detailList");
		logger.info("   - paramMap : " + paramMap);

		String result = "";

		// 선택된 게시판 1건 조회
		NoticeDModel detailNotice = noticeDService.detailNotice(paramMap);
		// List<CommentsVO> comments = null;

		if (detailNotice != null) {

			result = "SUCCESS"; // 성공시 찍습니다.

		} else {
			result = "FAIL / 불러오기에 실패했습니다."; // null이면 실패입니다.
		}

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", detailNotice); // 리턴 값 해쉬에 담기
		// resultMap.put("resultComments", comments);
		resultMap.put("resultMsg", result); // success 용어 담기

		System.out.println("결과 글 찍어봅세 " + result);
		System.out.println("결과 글 찍어봅세 " + detailNotice);

		logger.info("+ End " + className + ".detailList");

		return resultMap;
	}

}
