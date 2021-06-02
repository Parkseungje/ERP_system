package kr.happyjob.study.sales.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.accounting.model.AcctitleModel;
import kr.happyjob.study.sales.dao.ArmngDao;
import kr.happyjob.study.sales.model.ArmngModel;

@Service
public class ArmngServiceImpl implements ArmngService {

	@Autowired
	ArmngDao armngDao;
	
	@Override
	public List<ArmngModel> armngtitle(Map<String, Object> paramMap) {
		
		List<ArmngModel> armngtitle = armngDao.armngtitle(paramMap);
		
		return armngtitle;
	}
	
	@Override
	public ArmngModel armngSelect(Map<String, Object> paramMap) {
		return armngDao.armngSelect(paramMap);
	}
	
	@Override
	public void armngUpdate(Map<String, Object> paramMap) {
		armngDao.armngUpdate(paramMap);
	
	}
}
