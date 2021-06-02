package kr.happyjob.study.accounting.model;
import java.util.Date;

public class AccSlipModel {

	/* 아이디 */
	private String loginID;
	
	/* 계정대분류코드 */
	private String account_cd;
	
	/* 계정상세분류코드*/
	private String detail_account_cd;
	
	/* 계정대분류명*/
	private String group_name;
	
	private String group_code; 
	
	/* 계정상세분류명*/
	private String detail_account_nm;
	
	/* 지출금액 */
	private int dv_amt;
	
	/* 승인여부 */
	private String dv_app_yn;

	/* 승인자 */
	private String dv_app_nm;
	
	/* 승인일자 */
	private String dv_app_date;

	/* 비고 */
	private String dv_memo;
	
	/* 거래처명 */
	private String acc_name;
	
	/* 전표번호 */
	private int slip_no;
	
	/* 수주번호 */
	private String receive_no;
	
	/* 수주일자 */
	private Date receive_date;
	
	private String occur_date;
	/* 담당자 */
	/*private String ;*/
	
	/* 수입 */
	private int en_amt;
	
	/* 담당자 */
	private String rp_nm;
	
	/* 비고 */
	private String note;
	
	/* 고객사 코드 */
	private String client_cd;
	

	public String getClient_cd() {
		return client_cd;
	}

	public void setClient_cd(String client_cd) {
		this.client_cd = client_cd;
	}

	/**
	 * @return the loginID
	 */
	public String getLoginID() {
		return loginID;
	}

	/**
	 * @param loginID
	 *            the loginID to set
	 */
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	/**
	* @return the group_name
	*/
	public String getGroup_name() {
			return group_name;
	}

	/**
	* @param group_code
	*            the group_name to set
	*/
	/**
	* @return the detail_account_nm
	*/
	public String getDetail_account_nm() {
			return detail_account_nm;
	}

	/**
	* @param detail_account_nm
	*            the detail_account_nm to set
	*/
	
	public void setDetail_account_nm(String detail_account_nm) {
			this.detail_account_nm = detail_account_nm;		
	}
	
	/**
	* @return the account_cd
	*/
	public String getAccount_cd() {
			return account_cd;
	}

	/**
	* @param account_cd
	*            the account_cd to set
	*/
	public void setAccount_cd(String account_cd) {
			this.account_cd = account_cd;		
	}
	
	/**
	* @return the detail_account_cd
	*/
	public String getDetail_account_cd() {
			return detail_account_cd;
	}

	/**
	* @param detail_account_cd
	*            the detail_account_cd to set
	*/
	public void setDetail_account_cd(String detail_account_cd) {
			this.detail_account_cd = detail_account_cd;		
	}
		
	/**
	 * @param dv_amt
	 *            the dv_amt to set
	 */
	public void setDv_amt(int dv_amt) {
		this.dv_amt = dv_amt;
	}
	
	/**
	 * @return the dv_amt
	 */
	public int getDv_amt() {
		return dv_amt;
	}

	/**
	 * @param dv_app_yn
	 *            the dv_app_yn to set
	 */
	public void setDv_app_yn(String dv_app_yn) {
		this.dv_app_yn = dv_app_yn;
	}
	
	/**
	 * @return the dv_app_yn
	 */
	public String getDv_app_yn() {
		return dv_app_yn;
	}

	/**
	 * @param dv_app_nm
	 *            the dv_app_nm to set
	 */
	public void setDv_app_nm(String dv_app_nm) {
		this.dv_app_nm = dv_app_nm;
	}
	
	/**
	 * @return the dv_app_nm
	 */
	public String getDv_app_nm() {
		return dv_app_nm;
	}

	/**
	 * @param dv_memo
	 *            the dv_memo to set
	 */
	public void setDv_memo(String dv_memo) {
		this.dv_memo = dv_memo;
	}
	
	/**
	 * @return the dv_memo
	 */
	public String getDv_memo() {
		return dv_memo;
	}	
	
	/**
	 * @param acc_name
	 *            the acc_name to set
	 */
	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}
	
	/**
	 * @return the acc_name
	 */
	public String getAcc_name() {
		return acc_name;
	}	

	public int getSlip_no() {
		return slip_no;
	}

	public void setSlip_no(int slip_no) {
		this.slip_no = slip_no;
	}
	
	public String getDv_app_date() {
		return dv_app_date;
	}

	public void setDv_app_date(String dv_app_date) {
		this.dv_app_date = dv_app_date;
	}
	
	public String getReceive_no() {
		return receive_no;
	}

	public void setReceive_no(String receive_no) {
		this.receive_no = receive_no;
	}

	public Date getReceive_date() {
		return receive_date;
	}

	public void setReceive_date(Date receive_date) {
		this.receive_date = receive_date;
	}

	public int getEn_amt() {
		return en_amt;
	}

	public void setEn_amt(int en_amt) {
		this.en_amt = en_amt;
	}
	
	public String getOccur_date() { 
		return occur_date;
	}

	public void setOccur_date(String occur_date) {
		this.occur_date = occur_date;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	
	public String getGroup_code() {
		return group_code;
	}

	public void setGroup_code(String group_code) {
			this.group_code = group_code;		
	}
	

	
	public String getRp_nm() {
		return rp_nm;
	}

	public void setRp_nm(String rp_nm) {
		this.rp_nm = rp_nm;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





