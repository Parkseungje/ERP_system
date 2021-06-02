package kr.happyjob.study.dashboard.service;

import java.util.List;

import kr.happyjob.study.dashboard.model.ProductCategoryDTO;
import kr.happyjob.study.dashboard.model.SlideProductInfoDTO;
import kr.happyjob.study.dashboard.model.SlideProductInfoRequestDTO;

public interface DashboardEpcService {

	// 슬라이드쇼 제품 정보 리스트 가져오기
	public List<SlideProductInfoDTO> getSlideProductInfoList(SlideProductInfoRequestDTO slideProductInfoRequestDTO);
	
	// 제품 카테고리 리스트 가져오기
	public List<ProductCategoryDTO> getProductCategoryList();
}
