package kr.happyjob.study.dashboard.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.happyjob.study.dashboard.dao.DashboardGedDao;
import kr.happyjob.study.dashboard.model.MonthCompanyDTO;
import kr.happyjob.study.dashboard.model.MonthCompanyVO;
import kr.happyjob.study.dashboard.model.MonthProductDTO;
import kr.happyjob.study.dashboard.model.MonthProductVO;
import kr.happyjob.study.dashboard.model.MonthProfitDTO;
import kr.happyjob.study.dashboard.model.MonthProfitVO;

@Transactional
@Service("DashboardGedServiceImpl")
public class DashboardGedServiceImpl implements DashboardGedService{

	@Autowired
	private DashboardGedDao dashboardGedDao;
	
	
	@Override
	public Map<String, Object> getMonthChartData() {
		
		Map<String, Object> map = new HashMap<>();
		
		List<MonthCompanyVO> companyVOList = dashboardGedDao.selectMonthCompany();
		
		List<MonthProductVO> productVOList = dashboardGedDao.selectMonthProduct();
		
		List<MonthProfitVO> profitVOList = dashboardGedDao.selectMonthProfit();
		
		Iterator<MonthCompanyVO> companyIterator = companyVOList.iterator();
		
		Iterator<MonthProductVO> productIterator = productVOList.iterator();
		
		Iterator<MonthProfitVO> profitIterator = profitVOList.iterator();
		
		List<MonthCompanyDTO> companyDTOList = new LinkedList<>();

		List<MonthProductDTO> productDTOList = new LinkedList<>();

		List<MonthProfitDTO> profitDTOList = new LinkedList<>();
		
		while(companyIterator.hasNext()) {
			MonthCompanyVO vo = companyIterator.next();
			MonthCompanyDTO dto = new MonthCompanyDTO(vo);
			
			companyDTOList.add(dto);
		}
		
		while(productIterator.hasNext()) {
			MonthProductVO vo = productIterator.next();
			MonthProductDTO dto = new MonthProductDTO(vo);
			
			productDTOList.add(dto);
		}
		
		while(profitIterator.hasNext()) {
			MonthProfitVO vo = profitIterator.next();
			MonthProfitDTO dto = new MonthProfitDTO(vo);
			
			profitDTOList.add(dto);
		}
		
		map.put("companyDTOList", companyDTOList);
		map.put("productDTOList", productDTOList);
		map.put("profitDTOList", profitDTOList);
		
		return map;
	}

}
