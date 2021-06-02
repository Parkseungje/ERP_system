package kr.happyjob.study.employee.model;

public class EmpTaModel {
	
	//tb_userInfo table에서 가져오는 정보들
	private String loginID; //사용자 ID == 사원번호
	private String user_type; //사용자구분 == 직무
	private String name; //사원명
	private String tel; //연락처
	
	//tb_emp table에서 가져오는 정보들
	private String entry_date; //입사일
	private String retire_date; //퇴사일
	private int dept_cd; //부서코드 -> tb_dept table에서 가져오는 정보 join해서 부서명 가져와야함.
	private int total_an; //총연차 -> tb_ta_mgt table과 연관된 정보
	private int use_an; //사용연차 -> tb_ta_mgt table과 연관된 정보
	private int left_an; //남은연차 -> tb_ta_mgt table과 연관된 정보


	private String poscd; //직급코드 -> 공통코드table
	private String dept_name; //부서명
	
	//tb_ta_mgt
	private int ta_no; // 신청번호
	private String ta_app_nm; //승인자
	private String ta_yn; //승연여부
	private String ta_reg_date; //신청일자
	private String kind_hol; //근태종류
	private String reason_hol; //근태사유
	private String start_date; //시작일자
	private String end_date; //종료일자
	private int h_cnt; //휴가일수
	private String can_reason; //반려사유
	
	private int ta_yn_cnt; //캘린더에서 승인 여부에 따라 건 수 가져올 때 필요한 변수
	
	//getter, setter
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEntry_date() {
		return entry_date;
	}
	public void setEntry_date(String entry_date) {
		this.entry_date = entry_date;
	}
	public String getRetire_date() {
		return retire_date;
	}
	public void setRetire_date(String retire_date) {
		this.retire_date = retire_date;
	}
	public int getDept_cd() {
		return dept_cd;
	}
	public void setDept_cd(int dept_cd) {
		this.dept_cd = dept_cd;
	}
	public String getPoscd() {
		return poscd;
	}
	public void setPoscd(String poscd) {
		this.poscd = poscd;
	}

	public int getTa_no() {
		return ta_no;
	}
	public void setTa_no(int ta_no) {
		this.ta_no = ta_no;
	}
	public String getTa_app_nm() {
		return ta_app_nm;
	}
	public void setTa_app_nm(String ta_app_nm) {
		this.ta_app_nm = ta_app_nm;
	}
	public String getTa_yn() {
		return ta_yn;
	}
	public void setTa_yn(String ta_yn) {
		this.ta_yn = ta_yn;
	}
	public String getTa_reg_date() {
		return ta_reg_date;
	}
	public void setTa_reg_date(String ta_reg_date) {
		this.ta_reg_date = ta_reg_date;
	}
	public String getKind_hol() {
		return kind_hol;
	}
	public void setKind_hol(String kind_hol) {
		this.kind_hol = kind_hol;
	}
	public String getReason_hol() {
		return reason_hol;
	}
	public void setReason_hol(String reason_hol) {
		this.reason_hol = reason_hol;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getH_cnt() {
		return h_cnt;
	}
	public void setH_cnt(int h_cnt) {
		this.h_cnt = h_cnt;
	}
	public String getCan_reason() {
		return can_reason;
	}
	public void setCan_reason(String can_reason) {
		this.can_reason = can_reason;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public int getTotal_an() {
		return total_an;
	}
	public void setTotal_an(int total_an) {
		this.total_an = total_an;
	}
	public int getUse_an() {
		return use_an;
	}
	public void setUse_an(int use_an) {
		this.use_an = use_an;
	}
	public int getLeft_an() {
		return left_an;
	}
	public void setLeft_an(int left_an) {
		this.left_an = left_an;
	}
	
	public int getTa_yn_cnt() {
		return ta_yn_cnt;
	}
	public void setTa_yn_cnt(int ta_yn_cnt) {
		this.ta_yn_cnt = ta_yn_cnt;
	}
	
	
	@Override
	public String toString() {
		return "EmpTaModel [loginID=" + loginID + ", user_type=" + user_type + ", name=" + name + ", tel=" + tel
				+ ", entry_date=" + entry_date + ", retire_date=" + retire_date + ", dept_cd=" + dept_cd + ", total_an="
				+ total_an + ", use_an=" + use_an + ", left_an=" + left_an + ", poscd=" + poscd + ", dept_name="
				+ dept_name + ", ta_no=" + ta_no + ", ta_app_nm=" + ta_app_nm + ", ta_yn=" + ta_yn + ", ta_reg_date="
				+ ta_reg_date + ", kind_hol=" + kind_hol + ", reason_hol=" + reason_hol + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", h_cnt=" + h_cnt + ", can_reason=" + can_reason + ", ta_yn_cnt="
				+ ta_yn_cnt + "]";
	}

}
