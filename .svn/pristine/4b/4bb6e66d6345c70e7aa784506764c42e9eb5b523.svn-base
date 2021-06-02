package kr.happyjob.study.system.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.system.model.ComnCodUtilModel;
import kr.happyjob.study.system.model.ComnDtlCodModel;
import kr.happyjob.study.system.model.ComnGrpCodModel;

public interface ComnCodDao {

	/** 그룹코드 목록 조회 */
	//listComnGrpCod 가 쿼리문 ID가 됌.
	public List<ComnGrpCodModel> listComnGrpCod(Map<String, Object> paramMap);
	
	/** 그룹코드 목록 카운트 조회 */
	public int countListComnGrpCod(Map<String, Object> paramMap);
	
	/** 그룹코드 단건 조회 */
	public ComnGrpCodModel selectComnGrpCod(Map<String, Object> paramMap);
	
	/** 그룹코드 저장 */
	public int insertComnGrpCod(Map<String, Object> paramMap);
	
	/** 그룹코드 수정 */
	public int updateComnGrpCod(Map<String, Object> paramMap);
	
	/** 그룹코드 삭제 */
	public int deleteComnGrpCod(Map<String, Object> paramMap);
	
	/** 상세코드 목록 조회 */
	public List<ComnDtlCodModel> listComnDtlCod(Map<String, Object> paramMap);
	
	/** 그룹코드 목록 카운트 조회 */
	public int countListComnDtlCod(Map<String, Object> paramMap);
	
	/** 상세코드 단건 조회 */
	public ComnDtlCodModel selectComnDtlCod(Map<String, Object> paramMap);
	
	/** 상세코드 저장 */
	public int insertComnDtlCod(Map<String, Object> paramMap);
	
	/** 상세코드 수정 */
	public int updateComnDtlCod(Map<String, Object> paramMap);
	
	/** 상세코드 삭제 */
	public int deleteComnDtlCod(Map<String, Object> paramMap);
	
	/** 사용가능한 모든 공통코드 조회 */
	public List<ComnCodUtilModel> listAllComnCode(Map<String, Object> paramMap);
	
}
