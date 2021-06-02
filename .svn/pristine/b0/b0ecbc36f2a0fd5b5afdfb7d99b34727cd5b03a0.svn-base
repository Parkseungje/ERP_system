package kr.happyjob.study.sales.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.sales.dao.IddRevenueDao;
import kr.happyjob.study.sales.model.AccSlipModel;
import kr.happyjob.study.system.model.ComnGrpCodModel;

@Service
public class SlServiceImpl implements SlService {
	@Autowired
	IddRevenueDao iddRevenueDao;
	
	@Override
	public int countListddRevenue(Map<String, Object> paramMap) {
		int totalCount = iddRevenueDao.countListddRevenue(paramMap);
		
		return totalCount;
	}
	
	@Override
	public List<AccSlipModel> listAccSlip(Map<String, Object> paramMap) throws Exception {
		List<AccSlipModel> listAccSlip = iddRevenueDao.listAccSlip(paramMap);
		
		return listAccSlip;
	}


	@Override
	public List<AccSlipModel> listddAmtSum(Map<String, Object> paramMap) throws Exception {
		List<AccSlipModel> listddAmtSum = iddRevenueDao.listddAmtSum(paramMap);
		
		return listddAmtSum;
	}

}
