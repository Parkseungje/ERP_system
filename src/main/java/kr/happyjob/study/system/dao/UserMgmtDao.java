package kr.happyjob.study.system.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.system.model.UserMgmtModel;

public interface UserMgmtDao {

	
	// 사용자 리스트 조회
	public List<UserMgmtModel> userMgmtList(Map<String, Object> paramMap)throws Exception ;

	// 사용자 목록 카운트 조회
	public int userMgmtCnt(Map<String, Object> paramMap)throws Exception ;
	
	// 사용자 상세 단건 조회
	public UserMgmtModel userMgmtDetail(Map<String, Object> paramMap)throws Exception ;
	
	}
