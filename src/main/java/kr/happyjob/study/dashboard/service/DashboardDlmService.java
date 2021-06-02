package kr.happyjob.study.dashboard.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.dashboard.model.DeliveryBuyerModel;

public interface DashboardDlmService {
	
	List<DeliveryBuyerModel> deliveryBuyerList(Map<String, Object> paramMap);

}
