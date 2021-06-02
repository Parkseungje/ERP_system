package kr.happyjob.study.employee.dao;

import java.util.Map;

import kr.happyjob.study.employee.model.EmployeeModel;

public interface EmpPayHistDAO {
	
		public EmployeeModel empPayHistList(Map<String, Object> paramMap);
	
}