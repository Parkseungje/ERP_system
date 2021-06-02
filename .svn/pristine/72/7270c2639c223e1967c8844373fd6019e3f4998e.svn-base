package kr.happyjob.study.sales.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import kr.happyjob.study.sales.model.AccSlipModel;


public interface SlService {
	
	/** 일별매출목록 카운트 조회 */
	public int countListddRevenue(Map<String, Object> paramMap);
	
	/** 일별매출 목록 조회 */
	public List<AccSlipModel> listAccSlip(Map<String, Object> paramMap) throws Exception;
	
	/** 일별손익통계 조회 */
	public List<AccSlipModel> listddAmtSum(Map<String, Object> paramMap) throws Exception; 
}
