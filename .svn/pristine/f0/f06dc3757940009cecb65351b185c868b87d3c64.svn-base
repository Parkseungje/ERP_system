package kr.happyjob.study.accounting.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.accounting.dao.AccSlipDao;
import kr.happyjob.study.accounting.model.AccSlipModel;

@Service
public class AccSlipServiceImpl implements AccSlipService{

	
	@Autowired
	private AccSlipDao AccSlipDao;

	@Override
	public List<AccSlipModel> accSlipList(Map<String, Object> paramMap){
		 
		List<AccSlipModel> accSlipList = AccSlipDao.accSlipList(paramMap);
		
		System.out.printf("accSlipList", accSlipList);
		 
		return accSlipList;
	} 

	@Override
	public int accSlipCnt(Map<String, Object> paramMap) {
		
		int accSlipCnt = AccSlipDao.accSlipCnt(paramMap);
		
		System.out.printf("accSlipCnt", accSlipCnt);
		System.out.printf("gdgd");
		
		return accSlipCnt;
	}
	
	@Override
	public List<AccSlipModel> accSlipModal(Map<String, Object> paramMap){
		 
		List<AccSlipModel> accSlipModal = AccSlipDao.accSlipModal(paramMap);
		
		System.out.printf("accSlipModal : ", accSlipModal);
		
		return accSlipModal;
	}
	
	@Override
	public void accSlipInsert(Map<String, Object> paramMap) {
		AccSlipDao.accSlipInsert(paramMap);
	
	}
}