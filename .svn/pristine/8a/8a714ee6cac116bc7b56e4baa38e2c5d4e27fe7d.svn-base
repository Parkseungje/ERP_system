package kr.happyjob.study.sales.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.sales.dao.IddRevenueDao;
import kr.happyjob.study.sales.model.SalesModel;
import kr.happyjob.study.system.model.ComnGrpCodModel;

@Service
public class DRevServiceImpl implements DRevService {
	@Autowired
	IddRevenueDao iddRevenueDao;
	
	@Override
	public int countListddRevenue(Map<String, Object> paramMap) {
		int totalCount = iddRevenueDao.countListddRevenue(paramMap);
		
		return totalCount;
	}
	
	@Override
	public List<SalesModel> listDSales(Map<String, Object> paramMap) throws Exception {
		List<SalesModel> listDSales = iddRevenueDao.listDSales(paramMap);
		
		return listDSales;
	}


	@Override
	public List<SalesModel> listDaySalesSum(Map<String, Object> paramMap) throws Exception {
		List<SalesModel> listDaySalesSum = iddRevenueDao.listDaySalesSum(paramMap);
		
		return listDaySalesSum;
	}

	@Override
	public List<SalesModel> listDaySalesChart(Map<String, Object> paramMap) throws Exception {
		List<SalesModel> listDaySalesChart = iddRevenueDao.listDaySalesChart(paramMap);
		
		return listDaySalesChart;
	}

	


}
