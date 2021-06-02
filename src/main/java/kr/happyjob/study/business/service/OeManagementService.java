package kr.happyjob.study.business.service;

import java.util.List;
import java.util.Map;



import kr.happyjob.study.business.model.OeManagementModel;

public interface OeManagementService {
	
	
	//전체조회
	public List<OeManagementModel> oemList(Map<String, Object> paramMap) throws Exception;
	//전체 조회 카운트
	public int oemCnt(Map<String, Object> paramMap);
	

	
	/** 리스트 목록 단건 조회 */
	public OeManagementModel selectOemList(Map<String, Object> paramMap);

	
	//모달 안 리스트 조회
	public List<OeManagementModel> oemListDetail(Map<String, Object> paramMap) throws Exception;
	//모달 안 리스트 조회 카운트
	public int oemDetailCnt(Map<String, Object> paramMap);
	
	
	
	/**  수주 신규 저장 */
	public int  insertOemList(Map<String, Object> paramMap) throws Exception;
	
	// 수주 제품에 인서트 
	public int updateInsertOemList(Map<String, Object> paramMap)  throws Exception;

	
	
	
	/** 단건 수정 */
	public int updateOemList(Map<String, Object> paramMap);
	/** 단건 삭제 */
	public int deleteOemList(Map<String, Object> paramMap);
	
	

}
