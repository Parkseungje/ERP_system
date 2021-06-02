package kr.happyjob.study.dashboard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.happyjob.study.dashboard.dao.DashboardScmDao;
import kr.happyjob.study.dashboard.model.DashboardScmModel;

@Transactional
@Service("DashboardScmServiceImpl")
public class DashboardScmServiceImpl implements DashboardScmService{

	@Autowired
	private DashboardScmDao dashboardScmDao;
	
	
	public Map<String, Object> getCurdateData() {
		
		Map<String, Object> map = new HashMap<>();
		
		List<DashboardScmModel> gList = dashboardScmDao.getCurdateData();
		
		map.put("gListobj", gList);
		
		return map;
	}
	
	public Map<String, Object> getBardateData() {
		
		Map<String, Object> result = new HashMap<>();
		
		List<DashboardScmModel> bList = dashboardScmDao.getBardateData();
		
		result.put("bListobj", bList);
		
		return result;
	}

}
