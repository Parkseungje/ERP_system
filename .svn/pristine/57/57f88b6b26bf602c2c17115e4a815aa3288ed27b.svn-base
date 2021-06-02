package kr.happyjob.study.employee.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kr.happyjob.study.employee.dao.BmtaDao;
import kr.happyjob.study.employee.model.BmtaModel;

@Service
public class BmtaServieImpl implements BmtaService {

	@Autowired
	BmtaDao bmtaDao;

	@Override
	public List<BmtaModel> taapprove(Map<String, Object> paramMap) {
		List<BmtaModel> taapprove = bmtaDao.taapprove(paramMap);
		return taapprove;
	}
	
	@Override
	public int taapprovecnt(Map<String, Object> paramMap) {
		
		int taapprovecnt = bmtaDao.taapprovecnt(paramMap);
		
		return taapprovecnt;
	}

	@Override
	public BmtaModel taapproveUpdateSelect(Map<String, Object> paramMap) {
		return bmtaDao.taapproveUpdateSelect(paramMap);
	}
	
	@Override
	public void taapproveUpdate(Map<String, Object> paramMap) {
		bmtaDao.taapproveUpdate(paramMap);
	
	}
}
