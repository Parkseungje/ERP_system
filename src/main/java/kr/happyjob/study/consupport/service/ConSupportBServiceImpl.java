package kr.happyjob.study.consupport.service;

import java.util.List;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.happyjob.study.consupport.dao.ConSupportBDao;
import kr.happyjob.study.consupport.model.ConSupportBModel;
import kr.happyjob.study.consupport.model.NameListModel;



@Service
public class ConSupportBServiceImpl implements ConSupportBService {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	ConSupportBDao conSupportBDao;
	
	/** 그룹코드 목록 조회 */
	public List<ConSupportBModel> listConSupportB(Map<String, Object> paramMap) throws Exception {
		
		List<ConSupportBModel> listConSupportB = conSupportBDao.listConSupportB(paramMap);
		
		return listConSupportB;
	}
	
	/** 그룹코드 목록 카운트 조회 */
	public int countListConSupportB(Map<String, Object> paramMap) throws Exception {
		
		int totalCount = conSupportBDao.countListConSupportB(paramMap);
		
		return totalCount;
	}
	
	/*이름 목록 조회*/
	public List<NameListModel> nameList(Map<String, Object> paramMap) throws Exception {
		List<NameListModel> listNameList = conSupportBDao.listNameList(paramMap);
						
		return listNameList;
	}
	/** 이름 목록 카운트 조회 */
	public int countListlistNameList(Map<String, Object> paramMap) throws Exception {
		
		int totalCount = conSupportBDao.countListlistNameList(paramMap);
		
		return totalCount;
	}


	
	
	
}
