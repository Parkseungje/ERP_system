package kr.happyjob.study.mainlogin.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.mainlogin.model.MainChildUsrMnuModel;
import kr.happyjob.study.mainlogin.model.MainLoginInfoModel;
import kr.happyjob.study.mainlogin.model.MainUsrMnuModel;



public interface MainLoginService {
	/* 사용자 로그인  체크*/
	public String checkMainLogin(Map<String, Object> paramMap) throws Exception;
	
	/* 사용자 로그인 */
	public MainLoginInfoModel MainLogin(Map<String, Object> paramMap) throws Exception;
	
	/* 사용자 메뉴 권한 */
	public List<MainUsrMnuModel> listMainUsrMnu(Map<String, Object> paramMap) throws Exception;
	
	/* 사용자 자식 메뉴 권한 */
	public List<MainChildUsrMnuModel> listMainChildUsrMnu(Map<String, Object> paramMap) throws Exception;
}
