package kr.happyjob.study.employee.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.employee.dao.EmpTaApplyDao;
import kr.happyjob.study.employee.model.EmpTaModel;

@Service
public class EmpTaApplyServicelmpl implements EmpTaApplyService {
	
	@Autowired
	EmpTaApplyDao empTaApplyDao;

	@Override
	public List<EmpTaModel> empTaApplyList(Map<String, Object> paramMap)  throws Exception {
	
		List<EmpTaModel> empTaApplyList = empTaApplyDao.empTaApplyList(paramMap);
		
		System.out.printf("empTaApplyList", empTaApplyList);
		
		return empTaApplyList;
	}
	
	@Override
	public int empTaApplyCnt(Map<String, Object> paramMap)   throws Exception {
		
		int empTaApplyCnt = empTaApplyDao.empTaApplyCnt(paramMap);
		
		System.out.printf("empTaApplyCnt : ", empTaApplyCnt);
		System.out.printf("gdgd");
		
		return empTaApplyCnt;
	}

	@Override
	public EmpTaModel empTaApplyAnList(Map<String, Object> paramMap){
	
		EmpTaModel empTaApplyAnList = empTaApplyDao.empTaApplyAnList(paramMap);
				
		System.out.printf("empTaApplyAnList", empTaApplyAnList);
		
		return empTaApplyAnList;
	}
	
	@Override
	public EmpTaModel empTaApplyReturn(Map<String, Object> paramMap){
		
		EmpTaModel empTaApplyReturn = empTaApplyDao.empTaApplyReturn(paramMap);
		
		System.out.printf("empTaApplyReturn", empTaApplyReturn);
		
		return empTaApplyReturn;
	}
	@Override
	public void insertEmpTaApply(Map<String, Object> paramMap){
		
		empTaApplyDao.insertEmpTaApply(paramMap);
	}
	
	@Override
	public EmpTaModel empTaApplyModal(Map<String, Object> paramMap){
		
		EmpTaModel empTaApplyModal = empTaApplyDao.empTaApplyModal(paramMap);
		
		System.out.printf("empTaApplyModal", empTaApplyModal);
		
		return empTaApplyModal;
	}
	
}
