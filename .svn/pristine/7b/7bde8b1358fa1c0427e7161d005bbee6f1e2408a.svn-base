package kr.happyjob.study.consupport.service;

import java.util.List;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.happyjob.study.consupport.dao.ConSupportBDao;
import kr.happyjob.study.consupport.dao.ConSupportCDao;
import kr.happyjob.study.consupport.model.ConSupportBModel;
import kr.happyjob.study.consupport.model.ConSupportCModel;



@Service
public class ConSupportCServiceImpl implements ConSupportCService {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	ConSupportCDao conSupportCDao;
	
	/** 그룹코드 목록 조회 */
	public List<ConSupportCModel> listConSupportC(Map<String, Object> paramMap) throws Exception {
		
		List<ConSupportCModel> listConSupportC = conSupportCDao.listConSupportC(paramMap);
		
		return listConSupportC;
	}
	
	/** 그룹코드 목록 카운트 조회 */
	public int countListConSupportC(Map<String, Object> paramMap) throws Exception {
		
		int totalCount = conSupportCDao.countListConSupportC(paramMap);
		
		return totalCount;
	}
	
	
}
