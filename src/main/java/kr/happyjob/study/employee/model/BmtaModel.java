package kr.happyjob.study.employee.model;

public class BmtaModel {
	private int ta_no;             // 번호
	private String loginID;        // 사번(id)
	private String name;           // 휴가신청자 이름
	private String start_date;     //휴가시작일
	private String end_date;       //휴가종료일
	private String ta_reg_date;    //휴가승인일
	private String tel;            //휴가신청자 전화번호
	private String reason_hol;     // 휴가사유
	private String can_reason;     // 반려사유
	private String ta_yn;          // 승인상태
	private String kind_hol;       // 휴가종류
	private String dept_name;      // 휴가신청자 부서
	private String app_nm;         // 승인자
	
	public int getTa_no() {
		return ta_no;
	}
	public void setTa_no(int ta_no) {
		this.ta_no = ta_no;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getTa_reg_date() {
		return ta_reg_date;
	}
	public void setTa_reg_date(String ta_reg_date) {
		this.ta_reg_date = ta_reg_date;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getReason_hol() {
		return reason_hol;
	}
	public void setReason_hol(String reason_hol) {
		this.reason_hol = reason_hol;
	}
	public String getCan_reason() {
		return can_reason;
	}
	public void setCan_reason(String can_reason) {
		this.can_reason = can_reason;
	}
	public String getTa_yn() {
		return ta_yn;
	}
	public void setTa_yn(String ta_yn) {
		this.ta_yn = ta_yn;
	}
	public String getKind_hol() {
		return kind_hol;
	}
	public void setKind_hol(String kind_hol) {
		this.kind_hol = kind_hol;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getApp_nm() {
		return app_nm;
	}
	public void setApp_nm(String app_nm) {
		this.app_nm = app_nm;
	}
	
	
}
