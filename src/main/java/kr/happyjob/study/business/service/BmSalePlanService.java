package kr.happyjob.study.business.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.business.model.BmSalePlanModel;


public interface BmSalePlanService {

	
	/** 영업실적조회 */
	public List<BmSalePlanModel> listBmSalePlan(Map<String, Object> paramMap) throws Exception;
	
	
	/** 영업실적조회 목록 카운트 조회 */
	public int countListBmSalePlan(Map<String, Object> paramMap) throws Exception;

	
}
