package kr.happyjob.study.consupport.service;

import java.util.List;



import java.util.Map;

import kr.happyjob.study.consupport.model.ConSupportBModel;
import kr.happyjob.study.consupport.model.ConSupportCModel;


public interface ConSupportCService {

	/** 프로젝트 목록 조회 */
	public List<ConSupportCModel> listConSupportC(Map<String, Object> paramMap) throws Exception;

	
	/** 프로젝트 목록 카운트 조회 */
	public int countListConSupportC(Map<String, Object> paramMap) throws Exception;
	
}
