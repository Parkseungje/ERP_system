package kr.happyjob.study.business.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.business.model.BizPartnerModel;
import kr.happyjob.study.business.model.EstManagementModel;

public interface EstManagementService {
	
	
	//전체조회
	public List<EstManagementModel> estList(Map<String, Object> paramMap) throws Exception;
	//전체 조회 카운트
	public int estCnt(Map<String, Object> paramMap);
	

	
	/** 리스트 목록 단건 조회 */
	public EstManagementModel selectEstList(Map<String, Object> paramMap);
	/** 단건 저장 */
	public int  insertEstList(Map<String, Object> paramMap);
	/** 단건 수정 */
	public int updateEstList(Map<String, Object> paramMap);
	/** 단건 삭제 */
	public int deleteEstList(Map<String, Object> paramMap);
	
	
	//모달 안 리스트 조회
	public List<EstManagementModel> estListDetail(Map<String, Object> paramMap) throws Exception;
	//모달 안 리스트 조회 카운트
	public int estDetailCnt(Map<String, Object> paramMap);
	
	
	
	// 견적서,견적 제품에  넘버 넣고 업데이트  
	public int updateInsertEstList(Map<String, Object> paramMap)  throws Exception;
	

}
