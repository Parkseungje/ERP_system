package kr.happyjob.study.employee.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.employee.dao.EmpPayHistDAO;
import kr.happyjob.study.employee.model.EmployeeModel;

@Service
public class EmpPayHistServicelmpl implements EmpPayHistService {
	
	@Autowired
	private EmpPayHistDAO EmpPayHistDAO;

	@Override
	public EmployeeModel empPayHistList(Map<String, Object> paramMap){
	
		EmployeeModel payHistList =EmpPayHistDAO.empPayHistList(paramMap);
		
		System.out.printf("payHistList", payHistList);
		
		return payHistList;
	}

}
