package kr.happyjob.study.sales.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import kr.happyjob.study.sales.model.SalesModel;;


public interface DRevService {
	
	/** 일별매출목록 카운트 조회 */
	public int countListddRevenue(Map<String, Object> paramMap);
	
	/** 검색날짜 매출 목록 조회 */
	public List<SalesModel> listDSales(Map<String, Object> paramMap) throws Exception;
	
	/** 검색날짜 손익통계 */
	public List<SalesModel> listDaySalesSum(Map<String, Object> paramMap) throws Exception;
	
	/** 검색날짜 기준 한달전 매출 시각화*/
	public List<SalesModel> listDaySalesChart(Map<String, Object> paramMap) throws Exception;
}
