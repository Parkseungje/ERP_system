package kr.happyjob.study.employee.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.employee.dao.EmpTaCalendarDao;
import kr.happyjob.study.employee.model.EmpTaModel;


@Service
public class EmpTaCalendarServiceImpl implements EmpTaCalendarService {

	@Autowired
	EmpTaCalendarDao empTaCalendarDao;

	@Override
	public List<EmpTaModel> empTaList(Map<String, Object> paramMap) {
		return empTaCalendarDao.empTaList(paramMap);
	}

	@Override
	public List<EmpTaModel> empTaDetailList(Map<String, Object> paramMap) {
		return empTaCalendarDao.empTaDetailList(paramMap);
	}

}
