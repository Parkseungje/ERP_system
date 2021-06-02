package kr.happyjob.study.employee.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.employee.model.EmployeeModel;

public interface EmpMgtDao {
	/* 사원등록 -> 사번 만들기*/
	public String gainLoginID();
	
	/* 사원등록 -> tb_userinfo */
	public void empRegister1(Map<String, Object> paramMap) throws Exception;
	
	/* 사원등록 -> tb_emp */
	public void empRegister2(Map<String, Object> paramMap) throws Exception;

	/* 사원 프로필 사진 등록 */
	public void empRegisterProfile(Map<String, Object> listFileUtilModel) throws Exception;
	
	/* 사원 정보 수정 -> tb_userinfo */
	public void updateEmp1(Map<String, Object> paramMap);

	/* 사원 정보 수정 -> 기존 직급 가져오기 */
	public int getPoscd(Map<String, Object> paramMap);

	/* 사원 정보 수정 -> 승진 시 승진이력테이블에 데이터 추가 */
	public void insertGradeHis(Map<String, Object> paramMap);

	/* 사원 정보 수정 -> tb_emp  */
	public void updateEmp2(Map<String, Object> paramMap);

	/* 사원 리스트 조회 */
	public List<EmployeeModel> showEmpList(Map<String, Object> paramMap);

	/* 사원 리스트 조회 -> 총 글 수 조회 */
	public int countEmpList(Map<String, Object> paramMap);
	
	/* 사원 상세조회 */
	public EmployeeModel viewEmpDtl(Map<String, Object> paramMap);
	
	/* 사원 상세조회 -> 근무연차 조회 */
	public int getWorkyear(Map<String, Object> paramMap);

	/* 퇴직 처리 */
	public void resignEmp(Map<String, Object> paramMap);

	/* 퇴직금 존재 여부 */
	public int isExistOamt(Map<String, Object> paramMap);

	 /* 퇴직금 지급 */
	public void payOamt(Map<String, Object> paramMap);
	
	/* 퇴직자 일급 계산 지급 -> tb_acc_slip -> */
	public void paySalary(Map<String, Object> paramMap);

	/* 퇴직자 전 달 월급 계산 지급 -> tb_sal_his */
	public void paySalary2(Map<String, Object> paramMap);
	
	/* 퇴직자 전 달 월급 계산 지급 -> tb_acc_slip(실급여) */
	public void paySalary_netpay(Map<String, Object> paramMap);
	/* 퇴직자 전 달 월급 계산 지급 -> tb_acc_slip(국민연금) */
	public void paySalary_natps(Map<String, Object> paramMap);
	/* 퇴직자 전 달 월급 계산 지급 -> tb_acc_slip(건강보험) */
	public void paySalary_hinsure(Map<String, Object> paramMap);
	/* 퇴직자 전 달 월급 계산 지급 -> tb_acc_slip(산재보험) */
	public void paySalary_ohsinsure(Map<String, Object> paramMap);
	/* 퇴직자 전 달 월급 계산 지급 -> tb_acc_slip(고용보험) */
	public void paySalary_einsure(Map<String, Object> paramMap);
	
	/* 사원 정보 삭제 -> tb_userinfo */
	public void deleteEmp1(Map<String, Object> paramMap);
	
	/* 사원 정보 삭제 -> tb_emp */
	public void deleteEmp2(Map<String, Object> paramMap);

	public void deleteEmp3(Map<String, Object> paramMap);

	/* 승진내역 리스트 조회 */
	public List<EmployeeModel> empGradeList(Map<String, Object> paramMap);

	/* 승진내역 리스트 조회 -> 총 글 수 조회 */
	public int countEmpGradeList(Map<String, Object> paramMap);

	/* 승진내역 상세리스트 조회 */
	public List<EmployeeModel> empDtlGradeList(Map<String, Object> paramMap);
	
	/* 승진내역 상세리스트 조회 -> 총 글 수 조회 */
	public int countEmpDtlGradeList(Map<String, Object> paramMap);


	

}
