package kr.happyjob.study.business.dao;



import java.util.List;
import java.util.Map;

import kr.happyjob.study.business.model.BmSalePlanModel;

public interface BmSalePlanDao {

	/** 지출결의 목록 조회(신청페이지) */
	public List<BmSalePlanModel> listBmSalePlan(Map<String, Object> paramMap);
	
	
	/** 지출결의 목록 카운트 조회(신청페이지) */
	public int countListBmSalePlan(Map<String, Object> paramMap);

	}
