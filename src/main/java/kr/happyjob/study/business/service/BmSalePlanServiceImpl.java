package kr.happyjob.study.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.business.model.BmSalePlanModel;

import kr.happyjob.study.business.service.BmSalePlanService;
import kr.happyjob.study.business.dao.BmSalePlanDao;


@Service
public class BmSalePlanServiceImpl implements BmSalePlanService{

	@Autowired
	BmSalePlanDao bmSalePlanDao;
	
	/** 영업실적조회 리스트 조회 **/
	
	public List<BmSalePlanModel> listBmSalePlan(Map<String, Object> paramMap) throws Exception{
		
		List<BmSalePlanModel> listBmSalePlan = bmSalePlanDao.listBmSalePlan(paramMap);
		
		return listBmSalePlan;
		
	}
	
	/** 영업실적 목록 카운트 조회(신청페이지) **/
	
	public int countListBmSalePlan(Map<String, Object> paramMap) throws Exception{
		
		   int totalCount = bmSalePlanDao.countListBmSalePlan(paramMap);
			
		   return totalCount;
		}		
	
}
