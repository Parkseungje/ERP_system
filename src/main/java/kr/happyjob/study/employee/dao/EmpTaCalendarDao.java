package kr.happyjob.study.employee.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.employee.model.EmpTaModel;

public interface EmpTaCalendarDao {

	public List<EmpTaModel> empTaList(Map<String, Object> paramMap);

	public List<EmpTaModel> empTaDetailList(Map<String, Object> paramMap);

}
