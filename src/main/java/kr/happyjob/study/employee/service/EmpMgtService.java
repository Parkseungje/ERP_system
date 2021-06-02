package kr.happyjob.study.employee.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.happyjob.study.employee.model.EmployeeModel;

public interface EmpMgtService {

	public String gainLoginID();

	public void empRegister(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;

	public void updateEmp(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;

	public List<EmployeeModel> showEmpList(Map<String, Object> paramMap);

	public int countEmpList(Map<String, Object> paramMap);

	public EmployeeModel viewEmpDtl(Map<String, Object> paramMap);
	
	public int getWorkyear(Map<String, Object> paramMap);

	public void resignEmp(Map<String, Object> paramMap);

	public void deleteEmp(Map<String, Object> paramMap);

	public List<EmployeeModel> empGradeList(Map<String, Object> paramMap);

	public int countEmpGradeList(Map<String, Object> paramMap);

	public List<EmployeeModel> empDtlGradeList(Map<String, Object> paramMap);

	public int countEmpDtlGradeList(Map<String, Object> paramMap);

}
