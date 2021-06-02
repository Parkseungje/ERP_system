package kr.happyjob.study.employee.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.employee.model.EmployeeModel;

public interface EmpPaymentDao {
	
	/* 급여지급 리스트 전체 조회 */
	public List<EmployeeModel> empPaymentList(Map<String, Object> paramMap);

	/* 급여지급 리스트 전체 조회 총 글 수 가져오기 */
	public int countEmpPaymentList(Map<String, Object> paramMap);

	/* 급여지급 리스트 상세 조회 사원 정보 가져오기 */
	public EmployeeModel viewEmpDtlPayment(Map<String, Object> paramMap);

	/* 급여지급 리스트 상세 조회 */
	public List<EmployeeModel> empDtlPaymentList(Map<String, Object> paramMap);

	/* 급여지급 리스트 상세 조회 총 글 수 가져오기 */
	public int countEmpDtlPaymentList(Map<String, Object> paramMap);

	/* 급여지급처리(개인) -> tb_sal_his */
	public void empPaymentProcess(Map<String, Object> paramMap);

	/* 급여지급처리(개인) -> tb_acc_slip (실급여) */
	public void empPaymentProcess_netpay(Map<String, Object> paramMap);
	/* 급여지급처리(개인) -> tb_acc_slip (국민연금) */
	public void empPaymentProcess_natps(Map<String, Object> paramMap);
	/* 급여지급처리(개인) -> tb_acc_slip (건강보험) */
	public void empPaymentProcess_hinsure(Map<String, Object> paramMap);
	/* 급여지급처리(개인) -> tb_acc_slip (산재보험) */
	public void empPaymentProcess_ohsinsure(Map<String, Object> paramMap);
	/* 급여지급처리(개인) -> tb_acc_slip (고용보험) */
	public void empPaymentProcess_einsure(Map<String, Object> paramMap);

	/* 급여지급처리(일괄) -> tb_sal_his */
	public void allEmpPayment(Map<String, Object> paramMap);

	/* 급여지급처리(일괄) -> tb_acc_slip (실급여) */
	public void allEmpPayment_netpay(Map<String, Object> paramMap);
	/* 급여지급처리(일괄) -> tb_acc_slip (국민연금) */
	public void allEmpPayment_natps(Map<String, Object> paramMap);
	/* 급여지급처리(일괄) -> tb_acc_slip (건강보험) */
	public void allEmpPayment_hinsure(Map<String, Object> paramMap);
	/* 급여지급처리(일괄) -> tb_acc_slip (산재보험) */
	public void allEmpPayment_ohsinsure(Map<String, Object> paramMap);
	/* 급여지급처리(일괄) -> tb_acc_slip (고용보험) */
	public void allEmpPayment_einsure(Map<String, Object> paramMap);


}
