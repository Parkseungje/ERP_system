package kr.happyjob.study.consupport.service;

import java.util.List;



import java.util.Map;

import kr.happyjob.study.consupport.model.ConSupportBModel;
import kr.happyjob.study.consupport.model.NameListModel;
import kr.happyjob.study.system.model.ComnCodUtilModel;
import kr.happyjob.study.system.model.ComnDtlCodModel;
import kr.happyjob.study.system.model.ComnGrpCodModel;

public interface ConSupportBService {

	/** 프로젝트 목록 조회 */
	public List<ConSupportBModel> listConSupportB(Map<String, Object> paramMap) throws Exception;

	
	/** 프로젝트 목록 카운트 조회 */
	public int countListConSupportB(Map<String, Object> paramMap) throws Exception;
	
	
	/* 이름 목록조회*/
	public List<NameListModel> nameList(Map<String, Object> paramMap) throws Exception;
	
	/* 이름 목록 카운트 조회*/
	public int countListlistNameList(Map<String, Object> paramMap) throws Exception;

	

	

	

	
}
