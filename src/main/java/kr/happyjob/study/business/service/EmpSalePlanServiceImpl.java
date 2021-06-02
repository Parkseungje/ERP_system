package kr.happyjob.study.business.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.business.dao.BizPartnerDao;
import kr.happyjob.study.business.dao.EmpSalePlanDao;
import kr.happyjob.study.business.model.BizPartnerModel;
import kr.happyjob.study.business.model.EmpSalePlanModel;



@Service
public class EmpSalePlanServiceImpl implements EmpSalePlanService  {
	


	@Autowired
	private EmpSalePlanDao salePlanDao;
	

	@Override
	public List<EmpSalePlanModel> planList(Map<String, Object> paramMap) throws Exception {
	
		
		List<EmpSalePlanModel> listPlan = salePlanDao.planList(paramMap);
		
		System.out.println("==================");
		System.out.println("listPlan.size() "+listPlan.size());
		System.out.println("==================");
		
		
		return listPlan;
	}

	@Override
	public int planCnt(Map<String, Object> paramMap) {
		int planCnt = salePlanDao.planCnt(paramMap);
		return planCnt;
	}

	@Override
	public EmpSalePlanModel planListSelect(Map<String, Object> paramMap) {

		EmpSalePlanModel planpart = salePlanDao.planListSelect(paramMap);
		
		return planpart;
	}

	@Override
	public int insertPlanList(Map<String, Object> paramMap) {
		int alpa = salePlanDao.insertPlanList(paramMap);
		return alpa;
	}

	@Override
	public int updatePlanList(Map<String, Object> paramMap) {
		int beta = salePlanDao.updatePlanList(paramMap);
		return beta;
	}

	@Override
	public int deletePlanList(Map<String, Object> paramMap) {
		int gamma = salePlanDao.deletePlanList(paramMap);
		return gamma;
	}

	 
	


}
