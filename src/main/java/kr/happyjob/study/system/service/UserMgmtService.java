package kr.happyjob.study.system.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.login.model.UserInfo;
import kr.happyjob.study.system.model.UserMgmtModel;

public interface UserMgmtService {

	// 사용자 목록 조회
	public List<UserMgmtModel> userMgmtList(Map<String, Object> paramMap) throws Exception;

	// 사용자 목록 카운트 조회
	public int userMgmtCnt(Map<String, Object> paramMap)throws Exception ;
	
	// 사용자 상세 단건 조회
	public UserMgmtModel userMgmtDetail(Map<String, Object> paramMap)throws Exception ;
	
}
