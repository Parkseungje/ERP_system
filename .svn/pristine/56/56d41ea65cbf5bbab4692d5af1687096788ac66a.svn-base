package kr.happyjob.study.dashboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.dashboard.service.DashboardGedService;

@Controller
@RequestMapping("/dashboard/ged")
public class DashboardGedController {

	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@Resource(name="DashboardGedServiceImpl")
	private DashboardGedService dashboardGedServiceImpl;
	
	@RequestMapping("/chart")
	@ResponseBody
	public Map<String, Object> getChartData(){
		
		Map<String, Object> resultMap = new HashMap<>();
		
		Map<String, Object> chartData = dashboardGedServiceImpl.getMonthChartData();
		
		resultMap.put("chartData", chartData);

		logger.info(chartData.get("companyDTOList").toString());
		logger.info(chartData.get("productDTOList").toString());
		logger.info(chartData.get("profitDTOList").toString());
		
		return resultMap;
	}
	
}
