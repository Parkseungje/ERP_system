package kr.happyjob.study.mainlogin.service;

import java.util.List;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.mainlogin.dao.MainLoginDao;
import kr.happyjob.study.mainlogin.model.MainChildUsrMnuModel;
import kr.happyjob.study.mainlogin.model.MainLoginInfoModel;
import kr.happyjob.study.mainlogin.model.MainUsrMnuModel;



@Service
public class MainLoginServiceImpl implements MainLoginService{
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private MainLoginDao mainLoginDao;
	
	/* 사용자 로그인 체크 */
	public String checkMainLogin(Map<String, Object> paramMap)throws Exception{
		return mainLoginDao.checkMainLogin(paramMap);
	}
	
	/* 사용자 로그인 */
	public MainLoginInfoModel MainLogin(Map<String, Object> paramMap) throws Exception {
		String password = paramMap.get("pwd").toString();
		paramMap.put("pwd", password);
		return mainLoginDao.MainLogin(paramMap);
	}
	
	/* 사용자 메뉴 권한 */
	public List<MainUsrMnuModel> listMainUsrMnu(Map<String, Object> paramMap) throws Exception{
		return mainLoginDao.listMainUsrMnu(paramMap);
		
	}
	
	/* 사용자 자식 메뉴 권한 */
	public List<MainChildUsrMnuModel> listMainChildUsrMnu(Map<String, Object> paramMap) throws Exception{
		return mainLoginDao.listMainChildUsrMnu(paramMap);
		
	}
	
	
}
