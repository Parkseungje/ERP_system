package kr.happyjob.study.dashboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.dashboard.service.DashboardScmService;


@Controller
@RequestMapping("/dashboard/scm")
public class DashboardScmController {

	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@Resource(name="DashboardScmServiceImpl")
	private DashboardScmService dashboardScmServiceImpl;
	
	@RequestMapping("/chart")
	@ResponseBody
	public Map<String, Object> getChartData(){
		
		Map<String, Object> resultMap = new HashMap<>();
		
		Map<String, Object> chartData = dashboardScmServiceImpl.getCurdateData();
		
		resultMap.put("chartData", chartData);

		logger.info(chartData.get("gListobj").toString());
		
		return resultMap;
	}
	
	@RequestMapping("/bar")
	@ResponseBody
	public Map<String, Object> getBarData(){
		
		Map<String, Object> Map = new HashMap<>();
		
		Map<String, Object> barData = dashboardScmServiceImpl.getBardateData();
		
		Map.put("barData", barData);

		logger.info(barData.get("bListobj").toString());
		
		return Map;
	}
	
	
}
