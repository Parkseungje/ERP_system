package kr.happyjob.study.mainlogin.controller;

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

import kr.happyjob.study.mainlogin.model.MainLoginInfoModel;
import kr.happyjob.study.mainlogin.model.MainUsrMnuModel;
import kr.happyjob.study.mainlogin.service.MainLoginService;

@Controller
public class MainLoginController {

	// 사용자 로그인 처리

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	@Autowired
	MainLoginService mainLoginService;

	@RequestMapping("MainLogin.do")
	@ResponseBody
	public Map<String, String> MainLogin(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		MainLoginInfoModel mlm = mainLoginService.MainLogin(paramMap);

		String result;
		String resultMsg;

		if (mlm != null) {
			result = "SUCCESS";
			resultMsg = "사용자 로그인 정보가 일치 합니다.";

			// 사용자 메뉴 권한 조회
			paramMap.put("usr_sst_id", mlm.getUsr_sst_id());
			paramMap.put("userType", mlm.getMem_author());
			
			// 메뉴 목록 조회 0depth
			List<MainUsrMnuModel> listMainUsrMnuModel = mainLoginService.listMainUsrMnu(paramMap);
			// 메뉴 목록 조회 1depth
			for(MainUsrMnuModel list : listMainUsrMnuModel){
				Map<String, Object> resultMapSub = new HashMap<String, Object>();
				resultMapSub.put("lgn_Id", paramMap.get("lgn_Id"));
				resultMapSub.put("hir_mnu_id", list.getMnu_id());
				resultMapSub.put("userType", mlm.getMem_author());
				list.setNodeList(mainLoginService.listMainChildUsrMnu(resultMapSub));
			}
			session.setAttribute("loginId", mlm.getLgn_id());
			session.setAttribute("userNm", mlm.getUsr_nm());
			session.setAttribute("MainMnu", listMainUsrMnuModel);
			session.setAttribute("userType", mlm.getMem_author());
			session.setAttribute("serverName", request.getServerName());
			
		}else{
			
			result = "FALSE";
			resultMsg = "사용자 로그인 정보가 일치하지 않습니다.";
		}
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		resultMap.put("serverName", request.getServerName());
		return resultMap;

	}
}
