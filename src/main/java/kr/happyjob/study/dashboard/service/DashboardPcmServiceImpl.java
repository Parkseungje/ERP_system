package kr.happyjob.study.dashboard.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.dashboard.dao.DashboardPcmDao;
import kr.happyjob.study.dashboard.model.PcmModel;

@Service
public class DashboardPcmServiceImpl implements DashboardPcmService {

	@Autowired
	DashboardPcmDao dao;
	
	@Override
	public List<PcmModel> purchaseOrderList(Map<String, Object> paramMap) {
		List<PcmModel> list = dao.purchaseOrderList(paramMap);
		return list;
	}

}
