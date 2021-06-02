package kr.happyjob.study.dashboard.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.dashboard.model.PcmModel;

public interface DashboardPcmDao {
	
	List<PcmModel> purchaseOrderList(Map<String, Object> paramMap);

}
