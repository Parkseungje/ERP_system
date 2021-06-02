package kr.happyjob.study.dashboard.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.happyjob.study.dashboard.dao.DashboardEpcDao;
import kr.happyjob.study.dashboard.model.ProductCategoryDTO;
import kr.happyjob.study.dashboard.model.ProductCategoryVO;
import kr.happyjob.study.dashboard.model.SlideProductInfoDTO;
import kr.happyjob.study.dashboard.model.SlideProductInfoRequestDTO;
import kr.happyjob.study.dashboard.model.SlideProductInfoVO;

@Transactional
@Service("DashboardEpcServiceImpl")
public class DashboardEpcServiceImpl implements DashboardEpcService {

	@Autowired
	private DashboardEpcDao dashboardEpcDao;

	@Override
	public List<SlideProductInfoDTO> getSlideProductInfoList(SlideProductInfoRequestDTO slideProductInfoRequestDTO) {
		
		List<SlideProductInfoVO> voList = dashboardEpcDao.selectSlideProductInfo(slideProductInfoRequestDTO);
		
		List<SlideProductInfoDTO> dtoList = new LinkedList<>();
		
		Iterator<SlideProductInfoVO> iterator = voList.iterator();
		
		while(iterator.hasNext()) {
			SlideProductInfoVO vo = iterator.next();
			SlideProductInfoDTO dto = new SlideProductInfoDTO(vo);
			
			dtoList.add(dto);
		}
		
		return dtoList;
	}

	@Override
	public List<ProductCategoryDTO> getProductCategoryList() {
		
		List<ProductCategoryVO> voList = dashboardEpcDao.selectProductCategory();
		
		List<ProductCategoryDTO> dtoList = new LinkedList<>();
		
		Iterator<ProductCategoryVO> iterator = voList.iterator();
		
		while(iterator.hasNext()) {
			ProductCategoryVO vo = iterator.next();
			ProductCategoryDTO dto = new ProductCategoryDTO(vo);
			
			dtoList.add(dto);
		}
		
		return dtoList;
	}
	
}
