package kr.happyjob.study.dashboard.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.dashboard.model.PcmModel;

public interface DashboardPcmService {
	
	List<PcmModel> purchaseOrderList(Map<String, Object> paramMap);

}
