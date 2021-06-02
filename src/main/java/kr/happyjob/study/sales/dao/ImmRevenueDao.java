package kr.happyjob.study.sales.dao;

import java.util.List;
import java.util.Map;
import kr.happyjob.study.sales.model.SalesModel;

public interface ImmRevenueDao {
	
	/** 월별 손익통계
	 * 사용자 직접 입력 조회(combo:user_input) */
	public List<SalesModel> listMSalesUI(Map<String, Object> paramMap);
	
	
	
	

}
