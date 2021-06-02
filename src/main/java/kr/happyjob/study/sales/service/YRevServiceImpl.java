package kr.happyjob.study.sales.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.sales.dao.ImmRevenueDao;
import kr.happyjob.study.sales.dao.IyyRevenueDao;
import kr.happyjob.study.sales.model.AccSlipModel;
import kr.happyjob.study.sales.model.SalesModel;

@Service
public class YRevServiceImpl implements YRevService {
	
	@Autowired
	IyyRevenueDao iyyRevenueDao;

	@Override
	public List<SalesModel> listYSalesUI(Map<String, Object> paramMap) throws Exception {
		List<SalesModel> listYSalesUI = iyyRevenueDao.listYSalesUI(paramMap);
		
		return listYSalesUI;
	}

	@Override
	public List<SalesModel> listYSalesHalf(Map<String, Object> paramMap) throws Exception {
		List<SalesModel> listYSalesHalf = iyyRevenueDao.listYSalesHalf(paramMap);
		
		return listYSalesHalf;
	}

	@Override
	public List<SalesModel> listYSalesQuart(Map<String, Object> paramMap) throws Exception {
		List<SalesModel> listYSalesQuart = iyyRevenueDao.listYSalesQuart(paramMap);
		
		return listYSalesQuart;
	}




}
