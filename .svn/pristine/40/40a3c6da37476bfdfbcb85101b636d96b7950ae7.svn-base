package kr.happyjob.study.dashboard.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.dashboard.dao.DashboardDlmDao;
import kr.happyjob.study.dashboard.model.DeliveryBuyerModel;

@Service
public class DashboardDlmServiceImpl implements DashboardDlmService {

	@Autowired
	DashboardDlmDao dao;
	
	@Override
	public List<DeliveryBuyerModel> deliveryBuyerList(Map<String, Object> paramMap) {
		List<DeliveryBuyerModel> list = dao.deliveryBuyerList(paramMap);
		return list;
	}

}
