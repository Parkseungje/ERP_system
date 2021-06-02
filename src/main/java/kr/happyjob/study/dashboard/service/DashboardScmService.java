package kr.happyjob.study.dashboard.service;

import java.util.Map;

public interface DashboardScmService {

	// main todo list 가져오기
	public Map<String, Object> getCurdateData();
	
	// main bar data 가져오기
	public Map<String, Object> getBardateData();
}
