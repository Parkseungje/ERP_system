package kr.happyjob.study.business.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.business.model.BizPartnerModel;
import kr.happyjob.study.business.model.EstManagementModel;
import kr.happyjob.study.business.model.OeManagementModel;



public interface OeManagementDao {
	
	
	//견적서 전체조회
	public List<OeManagementModel> oemList(Map<String, Object> paramMap) throws Exception;
	//견적서 전체 조회 카운트
	public int oemCnt(Map<String, Object> paramMap);

	
	/** 리스트 목록 단건 조회 => 견적서 상세조회 */
	public OeManagementModel selectOemList(Map<String, Object> paramMap);

	
	//모달 안 리스트 조회
	public List<OeManagementModel> oemListDetail (Map<String, Object> paramMap) throws Exception;
	
	//모달 안 리스트 조회 카운트
	public int oemDetailCnt(Map<String, Object> paramMap);
	
	
	/** 견적서 신규 저장 */
	public int  insertOemList(Map<String, Object> paramMap);
	// 견적제품 인서트 
	public int updateInsertOemList(Map<String, Object> paramMap);
	
	
	
	
	/** 단건수정 */
	public int updateOemList(Map<String, Object> paramMap);

	/** 단건 삭제 */
	public int deleteOemList(Map<String, Object> paramMap);
	

	

}
