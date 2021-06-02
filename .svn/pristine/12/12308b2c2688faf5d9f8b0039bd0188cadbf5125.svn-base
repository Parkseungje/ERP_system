package kr.happyjob.study.dashboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.dashboard.model.ProductCategoryDTO;
import kr.happyjob.study.dashboard.model.SlideProductInfoDTO;
import kr.happyjob.study.dashboard.model.SlideProductInfoRequestDTO;
import kr.happyjob.study.dashboard.service.DashboardEpcService;

@Controller
@RequestMapping("/dashboard/epc")
public class DashboardEpcController {

	@Resource(name="DashboardEpcServiceImpl")
	private DashboardEpcService dashboardEpcServiceImpl;
	
	@RequestMapping("/slide")
	@ResponseBody
	public Map<String, Object> getSlideProductInfoList(@ModelAttribute SlideProductInfoRequestDTO slideProductInfoRequestDTO){
		
		System.out.println(slideProductInfoRequestDTO.getDetail_name());
		
		Map<String, Object> resultMap = new HashMap<>();
		
		List<SlideProductInfoDTO> slideProductInfoList = dashboardEpcServiceImpl.getSlideProductInfoList(slideProductInfoRequestDTO);
		
		resultMap.put("slideProductInfoList", slideProductInfoList);
		
		List<ProductCategoryDTO> productCategoryList = dashboardEpcServiceImpl.getProductCategoryList();
		
		resultMap.put("productCategoryList", productCategoryList);
		
		return resultMap;
	}
}
