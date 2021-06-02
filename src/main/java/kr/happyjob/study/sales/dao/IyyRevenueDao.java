package kr.happyjob.study.sales.dao;

import java.util.List;
import java.util.Map;
import kr.happyjob.study.sales.model.SalesModel;

public interface IyyRevenueDao {
	
	/** 년도별 손익통계
	 * 사용자 직접 입력 조회(combo:user_input) */
	public List<SalesModel> listYSalesUI(Map<String, Object> paramMap);
	
	/** 년도별 손익통계
	 * 상/하반기 조회(combo:half) */
	public List<SalesModel> listYSalesHalf(Map<String, Object> paramMap);
	
	/** 년도별 손익통계
	 * 1-4분기 조회(combo:quarter) */
	public List<SalesModel> listYSalesQuart(Map<String, Object> paramMap);

	
	
	

}
