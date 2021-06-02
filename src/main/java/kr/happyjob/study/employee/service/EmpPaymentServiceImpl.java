package kr.happyjob.study.employee.service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.employee.dao.EmpPaymentDao;
import kr.happyjob.study.employee.model.EmployeeModel;

@Service
public class EmpPaymentServiceImpl implements EmpPaymentService {
	@Autowired
	EmpPaymentDao empPaymentDao;

	/* 급여지급 리스트 전체 조회 */
	@Override
	public List<EmployeeModel> empPaymentList(Map<String, Object> paramMap) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		String str = (String)paramMap.get("from_date");
		String[] strAry = str.split("-");
		int from_date_year = Integer.parseInt(strAry[0]);
		int from_date_month = Integer.parseInt(strAry[1]);
		
		int flag;
		//조회하려는 월이 현재 월과 같을 경우
		if(year <= from_date_year && month <= from_date_month) { //tb_emp(현재 연봉)으로 조회
			flag = 1;
			System.out.println("flag == 1");
			paramMap.put("flag", flag);
		}else if (year >= from_date_year && month > from_date_month ){ //tb_sal_his(이미 지급된 내역)으로 조회
			flag = 2;
			System.out.println("flag == 2");
			paramMap.put("flag", flag);
		} 
		
		return empPaymentDao.empPaymentList(paramMap);
	}
	
	/* 급여지급 리스트 전체 조회 총 글 수 가져오기 */
	@Override
	public int countEmpPaymentList(Map<String, Object> paramMap) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		String str = (String)paramMap.get("from_date");
		String[] strAry = str.split("-");
		int from_date_year = Integer.parseInt(strAry[0]);
		int from_date_month = Integer.parseInt(strAry[1]);
		
		int flag;
		//조회하려는 월이 현재 월과 같을 경우
		if(year < from_date_year && month < from_date_month) { //tb_emp(현재 연봉)으로 조회
			flag = 1;
			paramMap.put("flag", flag);
		}else if (year > from_date_year && month > from_date_month ){ //tb_sal_his(이미 지급된 내역)으로 조회
			flag = 2;
			paramMap.put("flag", flag);
		}
		return empPaymentDao.countEmpPaymentList(paramMap);
	}

	/* 급여지급 리스트 상세 조회 -> 사원정보 가져오기 */
	@Override
	public EmployeeModel viewEmpDtlPayment(Map<String, Object> paramMap) {
		return empPaymentDao.viewEmpDtlPayment(paramMap);
	}

	/* 급여지급 리스트 상세 조회 */
	@Override
	public List<EmployeeModel> empDtlPaymentList(Map<String, Object> paramMap) {
		return empPaymentDao.empDtlPaymentList(paramMap);
	}

	/* 급여지급 리스트 상세 조회 총 글 수 가져오기 */
	@Override
	public int countEmpDtlPaymentList(Map<String, Object> paramMap) {
		return empPaymentDao.countEmpDtlPaymentList(paramMap);
	}

	/* 급여지급처리 -> 개인 지급 */
	@Override
	public void empPaymentProcess(Map<String, Object> paramMap) {
		
		String entry_type = empPaymentDao.viewEmpDtlPayment(paramMap).getEntry_type();

		//tb_sal_his에 insert
		empPaymentDao.empPaymentProcess(paramMap);
		
		if(entry_type.equals("B")) {
			empPaymentDao.empPaymentProcess_netpay(paramMap); //(실급여)
		}else if (entry_type.equals("N")) {
			//tb_acc_slip에 insert -> 4대보험, 실급여 
			empPaymentDao.empPaymentProcess_netpay(paramMap); //(실급여)
			empPaymentDao.empPaymentProcess_natps(paramMap); //(국민연금)
			empPaymentDao.empPaymentProcess_hinsure(paramMap); //(건강보험)
			empPaymentDao.empPaymentProcess_ohsinsure(paramMap); //(산재보험)
			empPaymentDao.empPaymentProcess_einsure(paramMap); //(고용보험)
		}
	}

	@Override
	public void allEmpPayment(Map<String, Object> paramMap) {
		//tb_sal_his에 insert
		empPaymentDao.allEmpPayment(paramMap);
		int flag = 1;
		paramMap.put("flag", flag);
		List<EmployeeModel> listEmployeeModel = empPaymentDao.empPaymentList(paramMap);

		for(EmployeeModel emp : listEmployeeModel) {
			String entry_type = emp.getEntry_type();
			if(entry_type.equals("B")) {
				empPaymentDao.allEmpPayment_netpay(paramMap); //(실급여)
				
			}else if (entry_type.equals("N")){
				//tb_acc_slip에 insert -> 4대보험, 실급여 
				empPaymentDao.allEmpPayment_netpay(paramMap); //(실급여)
				empPaymentDao.allEmpPayment_natps(paramMap); //(국민연금)
				empPaymentDao.allEmpPayment_hinsure(paramMap); //(건강보험)
				empPaymentDao.allEmpPayment_ohsinsure(paramMap); //(산재보험)
				empPaymentDao.allEmpPayment_einsure(paramMap); //(고용보험)
			}
		}//for문
	}

}
