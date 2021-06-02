package kr.happyjob.study.system.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.system.dao.UserMgmtDao;
import kr.happyjob.study.system.model.UserMgmtModel;

@Service
public class UserMgmtServiceImpl implements UserMgmtService {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	UserMgmtDao userMgmtDao;
	
	/** 사용자 목록 조회 */
	@Override
	public List<UserMgmtModel> userMgmtList(Map<String, Object> paramMap) throws Exception {
		
		List<UserMgmtModel> userMgmtList = userMgmtDao.userMgmtList(paramMap);
		
		return userMgmtList;
	}
	
	@Override
	public int userMgmtCnt(Map<String, Object> paramMap) throws Exception {
		int userMgmtCnt = userMgmtDao.userMgmtCnt(paramMap);
		return userMgmtCnt;
	}
	
	@Override
	public UserMgmtModel userMgmtDetail(Map<String, Object> paramMap) throws Exception {

		UserMgmtModel userMgmtModel = userMgmtDao.userMgmtDetail(paramMap);
		return userMgmtModel;
	}
}
