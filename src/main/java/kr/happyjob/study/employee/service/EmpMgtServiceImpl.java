package kr.happyjob.study.employee.service;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.happyjob.study.common.comnUtils.FileUtilCho;
import kr.happyjob.study.employee.dao.EmpMgtDao;
import kr.happyjob.study.employee.model.EmployeeModel;

@Service
public class EmpMgtServiceImpl implements EmpMgtService {
	@Autowired
	EmpMgtDao empMgtDao;

	/* 파일 저장 경로*/
	@Value("${fileUpload.rootPath}")
	private String rootPath;
	@Value("${fileUpload.empimgPath}")
	private String empimgPath;	
	@Value("${emp.payment.date}")
	private String paymentDate;
	
	/* 인사관리 사원등록 -> 로그인 아이디 가져오기 */
	@Override
	public String gainLoginID() {
		return empMgtDao.gainLoginID();
	}
	
	/* 인사관리 사원등록 */
	@Override
	public void empRegister(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest)request;

		String itemFilePath = empimgPath + paramMap.get("loginID") + File.separator;
		
		FileUtilCho fileUtilCho = new FileUtilCho(mpRequest, rootPath, itemFilePath);
		Map<String, Object> listFileUtilModel = fileUtilCho.uploadFiles();
		
		paramMap.put("filename", listFileUtilModel.get("file_nm"));
		paramMap.put("filepath", listFileUtilModel.get("file_loc"));
		paramMap.put("filesize", listFileUtilModel.get("file_size"));
		
		System.out.println("업로드한 파일 이름 : "+paramMap.get("filename"));
		System.out.println("업로드한 파일 url : "+paramMap.get("filepath"));
		System.out.println("업로드한 파일 사이즈 : "+paramMap.get("filesize"));
	
		//사번 만들기
		try{
			empMgtDao.empRegister1(paramMap); //프로필사진 제외 사원 등록 -> tb_userinfo
			empMgtDao.empRegister2(paramMap); //프로필사진 제외 사원 등록 -> tb_emp
			System.out.println("확인작업 "+listFileUtilModel);
			System.out.println("임플"+mpRequest );
			
			if(mpRequest.getFile("profileUpload").getSize() > 0) {
				empMgtDao.empRegisterProfile(paramMap);
			}else {
				System.out.println("프로필 사진 없음");
			}
			
		}catch(Exception e){
			throw e;
		}
		
	}//사원등록 끝
	
	/* 인사관리 사원정보 수정 */
	@Override
	public void updateEmp(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest)request;

		String itemFilePath = empimgPath + paramMap.get("loginID") + File.separator;
		
		FileUtilCho fileUtilCho = new FileUtilCho(mpRequest, rootPath, itemFilePath);
		Map<String, Object> listFileUtilModel = fileUtilCho.uploadFiles();
		
		paramMap.put("filename", listFileUtilModel.get("file_nm"));
		paramMap.put("filepath", listFileUtilModel.get("file_loc"));
		paramMap.put("filesize", listFileUtilModel.get("file_size"));
		
		System.out.println("업로드한 파일 이름 : "+paramMap.get("filename"));
		System.out.println("업로드한 파일 url : "+paramMap.get("filepath"));
		System.out.println("업로드한 파일 사이즈 : "+paramMap.get("filesize"));
	
		//연봉인상
		
		
		try{
			empMgtDao.updateEmp1(paramMap); //프로필사진 제외 사원 정보 수정 -> tb_userinfo
			int og_pos_cd = empMgtDao.getPoscd(paramMap); //정보수정할 사원의 기존 직급코드 가져오기
			int new_pos_cd = Integer.parseInt((String)paramMap.get("poscd"));
			if (og_pos_cd > new_pos_cd) { //승진할 경우 승진이력테이블에 데이터 추가 (승진할 수록 직급코드 줄어감
				empMgtDao.insertGradeHis(paramMap);
			}
			Calendar cal = Calendar.getInstance();
			int day = cal.get(Calendar.DAY_OF_MONTH);
			int payDate = Integer.parseInt(paymentDate);
			int og_year_sal = empMgtDao.viewEmpDtl(paramMap).getYear_salary();
			int new_year_sal = Integer.parseInt((String)paramMap.get("year_salary"));
			String entry_type = empMgtDao.viewEmpDtl(paramMap).getEntry_type();
			
			if(entry_type.equals("B")) {
				if(og_year_sal < new_year_sal) { //연봉 인상 되었을 경우
					if(payDate > day) {
						//tb_sal_his에 전 달 월급 지급 insert
						empMgtDao.paySalary2(paramMap); //월급 지급
						
						//tb_acc_slip에 insert -> 4대보험, 실급여 
						empMgtDao.paySalary_netpay(paramMap); //(실급여)
					}
				}
			}else if (entry_type.equals("N")) {
				if(og_year_sal < new_year_sal) {
					if(payDate > day) {
						//tb_sal_his에 전 달 월급 지급 insert
						empMgtDao.paySalary2(paramMap); //월급 지급
						
						//tb_acc_slip에 insert -> 4대보험, 실급여 
						empMgtDao.paySalary_netpay(paramMap); //(실급여)
						empMgtDao.paySalary_natps(paramMap); //(국민연금)
						empMgtDao.paySalary_hinsure(paramMap); //(건강보험)
						empMgtDao.paySalary_ohsinsure(paramMap); //(산재보험)
						empMgtDao.paySalary_einsure(paramMap); //(고용보험)
					}
				}
			}
			
			empMgtDao.updateEmp2(paramMap); //프로필사진 제외 사원 정보 수정 -> tb_emp
			
			if(mpRequest.getFile("profileUpload").getSize() > 0) {
				empMgtDao.empRegisterProfile(paramMap);
			}else {
				System.out.println("프로필 사진 없음");
			}
			
		}catch(Exception e){
			throw e;
		}
		
	}

	/* 인사관리 사원 리스트 조회 */
	@Override
	public List<EmployeeModel> showEmpList(Map<String, Object> paramMap) {
		return empMgtDao.showEmpList(paramMap);
	}
	/* 인사관리 사원 총 명수 */
	@Override
	public int countEmpList(Map<String, Object> paramMap) {
		return empMgtDao.countEmpList(paramMap);
	}
	
	/* 인사관리 사원 상세조회 */
	@Override
	public EmployeeModel viewEmpDtl(Map<String, Object> paramMap) {
		return empMgtDao.viewEmpDtl(paramMap);
	}
	
	/* 인사관리 사원 상세조회 -> 근무연차 가져오기 */
	@Override
	public int getWorkyear(Map<String, Object> paramMap) {
		return empMgtDao.getWorkyear(paramMap);
	}

	/* 인사관리 퇴직 처리 */
	@Override
	public void resignEmp(Map<String, Object> paramMap) {
		empMgtDao.resignEmp(paramMap); //tb_emp에 퇴직 처리(out_yn = 'y' / 퇴사일, 퇴직금, 퇴직사유 	insert)s 
		int oamt = empMgtDao.isExistOamt(paramMap); //근무연차가 0인 경우 퇴직금 지급X, 퇴직금 존재 여부 확인.
		if (oamt > 0) {
			paramMap.put("oamt", oamt);
			empMgtDao.payOamt(paramMap); //tb_acc_slip에 퇴직금 insert
		}
		int payDate = Integer.parseInt(paymentDate);
		String retire_date = (String)paramMap.get("retire_date");
		String[] strAry = retire_date.split("-");
		int retire_date_day = Integer.parseInt(strAry[2]);
		
		String entry_type = (String)empMgtDao.viewEmpDtl(paramMap).getEntry_type();
		
		if(entry_type.equals("B")) {
			if(payDate > retire_date_day) {//월급지급 전에 퇴사할 경우
				empMgtDao.paySalary(paramMap); //tb_acc_slip에 퇴사일까지 일한 일급 insert
				
				//tb_sal_his에 전 달 월급 지급 insert
				empMgtDao.paySalary2(paramMap);
				
				//tb_acc_slip에 insert -> 실급여 
				empMgtDao.paySalary_netpay(paramMap); //(실급여)
				
			}else { //월급 지급 후
				empMgtDao.paySalary(paramMap); //tb_acc_slip에 퇴사일까지 일한 일급 insert
			}
		}else if (entry_type.equals("N")) {
			if(payDate > retire_date_day) {//월급지급 전에 퇴사할 경우
				empMgtDao.paySalary(paramMap); //tb_acc_slip에 퇴사일까지 일한 일급 insert
				
				//tb_sal_his에 전 달 월급 지급 insert
				empMgtDao.paySalary2(paramMap);
				
				//tb_acc_slip에 insert -> 4대보험, 실급여 
				empMgtDao.paySalary_netpay(paramMap); //(실급여)
				empMgtDao.paySalary_natps(paramMap); //(국민연금)
				empMgtDao.paySalary_hinsure(paramMap); //(건강보험)
				empMgtDao.paySalary_ohsinsure(paramMap); //(산재보험)
				empMgtDao.paySalary_einsure(paramMap); //(고용보험)
			} else { //월급 지급 후
				empMgtDao.paySalary(paramMap); //tb_acc_slip에 퇴사일까지 일한 일급 insert
			}
		}
	}

	/* 인사관리 정보 삭제 */
	@Override
	public void deleteEmp(Map<String, Object> paramMap) {
		empMgtDao.deleteEmp1(paramMap);
		empMgtDao.deleteEmp2(paramMap);
		empMgtDao.deleteEmp3(paramMap);
	}

	/* 승진내역관리 승진내역 리스트 조회 */
	@Override
	public List<EmployeeModel> empGradeList(Map<String, Object> paramMap) {
		return empMgtDao.empGradeList(paramMap);
	}
	
	/* 승진내역관리 승진내역 리스트 총 글수  */
	@Override
	public int countEmpGradeList(Map<String, Object> paramMap) {
		return empMgtDao.countEmpGradeList(paramMap);
	}
	
	/* 승진내역관리 승진내역 상세리스트*/
	@Override
	public List<EmployeeModel> empDtlGradeList(Map<String, Object> paramMap) {
		return empMgtDao.empDtlGradeList(paramMap);
	}

	/* 승진내역관리 승진내역 상세리스트 총 글수  */
	@Override
	public int countEmpDtlGradeList(Map<String, Object> paramMap) {
		return empMgtDao.countEmpDtlGradeList(paramMap);
	}

}
