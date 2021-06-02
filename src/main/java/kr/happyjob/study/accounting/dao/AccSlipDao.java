package kr.happyjob.study.accounting.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.accounting.model.AccSlipModel;

public interface AccSlipDao {
	
		public List<AccSlipModel> accSlipList(Map<String, Object> paramMap);
		
		public int accSlipCnt(Map<String, Object> paramMap); 
	
		public List<AccSlipModel> accSlipModal(Map<String, Object> paramMap);
		
		public void accSlipInsert(Map<String, Object> paramMap);
}