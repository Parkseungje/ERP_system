package kr.happyjob.study.system.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.system.dao.ComnCodDao;
import kr.happyjob.study.system.model.ComnCodUtilModel;
import kr.happyjob.study.system.model.ComnDtlCodModel;
import kr.happyjob.study.system.model.ComnGrpCodModel;

@Service
public class ComnCodServiceImpl implements ComnCodService {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	ComnCodDao comnCodDao;
	
	/** 그룹코드 목록 조회 */
	public List<ComnGrpCodModel> listComnGrpCod(Map<String, Object> paramMap) throws Exception {
		
		List<ComnGrpCodModel> listComnGrpCod = comnCodDao.listComnGrpCod(paramMap);
		
		return listComnGrpCod;
	}
	
	/** 그룹코드 목록 카운트 조회 */
	public int countListComnGrpCod(Map<String, Object> paramMap) throws Exception {
		
		int totalCount = comnCodDao.countListComnGrpCod(paramMap);
		
		return totalCount;
	}
	
	/** 그룹코드 단건 조회 */
	public ComnGrpCodModel selectComnGrpCod(Map<String, Object> paramMap) throws Exception {
		
		ComnGrpCodModel comnGrpCodModel = comnCodDao.selectComnGrpCod(paramMap);
		return comnGrpCodModel;
	}
	
	/** 그룹코드 저장 */
	public int insertComnGrpCod(Map<String, Object> paramMap) throws Exception {
		
		int ret = comnCodDao.insertComnGrpCod(paramMap);
		
		return ret;
	}
	
	/** 그룹코드 수정 */
	public int updateComnGrpCod(Map<String, Object> paramMap) throws Exception {
		
		int ret = comnCodDao.updateComnGrpCod(paramMap);
		return ret;
	}
	
	/** 그룹코드 삭제 */
	public int deleteComnGrpCod(Map<String, Object> paramMap) throws Exception {
		
		int ret = comnCodDao.deleteComnGrpCod(paramMap);
		
		return ret;
	}
	
	/** 상세코드 목록 조회 */
	public List<ComnDtlCodModel> listComnDtlCod(Map<String, Object> paramMap) throws Exception {
		
		List<ComnDtlCodModel> listComnGrpCod = comnCodDao.listComnDtlCod(paramMap);
		
		return listComnGrpCod;
	}
	
	/** 그룹코드 목록 카운트 조회 */
	public int countListComnDtlCod(Map<String, Object> paramMap) throws Exception {
		
		int totalCount = comnCodDao.countListComnDtlCod(paramMap);
		
		return totalCount;
	}
	
	/** 상세코드 단건 조회 */
	public ComnDtlCodModel selectComnDtlCod(Map<String, Object> paramMap) throws Exception {
		
		ComnDtlCodModel comnDtlCodModel = comnCodDao.selectComnDtlCod(paramMap);
		return comnDtlCodModel;
	}
	
	/** 상세코드 저장 */
	public int insertComnDtlCod(Map<String, Object> paramMap) throws Exception {
		
		int ret = comnCodDao.insertComnDtlCod(paramMap);
		return ret;
	}
	
	/** 상세코드 수정 */
	public int updateComnDtlCod(Map<String, Object> paramMap) throws Exception {
		
		int ret = comnCodDao.updateComnDtlCod(paramMap);
		return ret;
	}
	
	/** 상세코드 삭제 */
	public int deleteComnDtlCod(Map<String, Object> paramMap) throws Exception {
		
		int ret = comnCodDao.deleteComnDtlCod(paramMap);
		return ret;
	}
	
	/** 사용가능한 모든 공통코드 조회 */
	public List<ComnCodUtilModel> listAllComnCode(Map<String, Object> paramMap) throws Exception {
		
		List<ComnCodUtilModel> listComnCode = comnCodDao.listAllComnCode(paramMap);
		return listComnCode;
	}
}
