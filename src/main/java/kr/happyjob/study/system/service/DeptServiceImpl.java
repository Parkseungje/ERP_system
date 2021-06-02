package kr.happyjob.study.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.system.dao.deptMgrDao;
import kr.happyjob.study.system.model.DeptMgrModel;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	deptMgrDao deptDao;
  
	@Override
	public List<DeptMgrModel> deptList(Map<String, Object> paramMap) throws Exception{

		List<DeptMgrModel> deptList = deptDao.deptList(paramMap);
		return deptList;
	}

	@Override
	public int deptCount(Map<String, Object> paramMap) throws Exception {
		int deptCnt = deptDao.deptCount(paramMap);
		return deptCnt;
	}

	// **** 상세 조회(변경)****
	@Override
	public DeptMgrModel deptdetail(Map<String, Object> paramMap) throws Exception {

		DeptMgrModel deptMgrModel = deptDao.deptdetail(paramMap);
		return deptMgrModel;
	}

	@Override
	public int insertDept(Map<String, Object> paramMap) throws Exception {

		int statusChange = deptDao.insertDept(paramMap);
		return statusChange;
	}

	@Override
	public int updateDept(Map<String, Object> paramMap) throws Exception {

		int statusChange = deptDao.updateDept(paramMap);
		return statusChange;
	}

	// **** 삭제(변경)****
	@Override
	public int deptdelete(Map<String, Object> paramMap) throws Exception {

		int statusChange = deptDao.deptdelete(paramMap);
		return statusChange;
	}
	
}
