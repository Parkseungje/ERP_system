package kr.happyjob.study.system.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.system.model.DeptMgrModel;
import kr.happyjob.study.system.model.NoticeModel;
import kr.happyjob.study.system.model.NoticeNewModel;

public interface DeptService {

	// 부서관리 리스트 조회
	public List<DeptMgrModel> deptList(Map<String, Object> paramMap)throws Exception ;
	  
	// 부서관리 목록 카운트 조회
	public int deptCount(Map<String, Object> paramMap)throws Exception ;
	
	// **** 부서관리 단건 조회(변경)****
	public DeptMgrModel deptdetail(Map<String, Object> paramMap)throws Exception ;
	
	// 부서관리 저장
	public int insertDept(Map<String, Object> paramMap) throws Exception;
	
	// 부서관리 수정
	public int updateDept(Map<String, Object> paramMap) throws Exception;
	
	// **** 부서관리 삭제(변경)****
	public int deptdelete(Map<String, Object> paramMap) throws Exception;
	
}
