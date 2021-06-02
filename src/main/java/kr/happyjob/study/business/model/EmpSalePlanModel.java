package kr.happyjob.study.business.model;




public class EmpSalePlanModel {

	
	private int sales_pro_seq;
	private String client_cd;
	private String client_nm;
	private int  goal_amt;
	private String  large_classifi;
	private String  small_classifi;
	private String  loginID;
	private String  memo;
	private String  product_cd;
	private String  sales_reg_date;
	private String  prod_nm;
	private String estimate_cnt;
	
	
	public String getClient_nm() {
		return client_nm;
	}
	public void setClient_nm(String client_nm) {
		this.client_nm = client_nm;
	}
	public String getEstimate_cnt() {
		return estimate_cnt;
	}
	public void setEstimate_cnt(String estimate_no) {
		this.estimate_cnt = estimate_no;
	}
	public String getProd_nm() {
		return prod_nm;
	}
	public void setProd_nm(String prod_nm) {
		this.prod_nm = prod_nm;
	}
	public String getClient_cd() {
		return client_cd;
	}
	public void setClient_cd(String client_cd) {
		this.client_cd = client_cd;
	}
	public int getGoal_amt() {
		return goal_amt;
	}
	public void setGoal_amt(int goal_amt) {
		this.goal_amt = goal_amt;
	}
	public String getLarge_classifi() {
		return large_classifi;
	}
	public void setLarge_classifi(String large_classifi) {
		this.large_classifi = large_classifi;
	}
	public String getSmall_classifi() {
		return small_classifi;
	}
	public void setSmall_classifi(String small_classifi) {
		this.small_classifi = small_classifi;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getProduct_cd() {
		return product_cd;
	}
	public void setProduct_cd(String product_cd) {
		this.product_cd = product_cd;
	}
	public int getSales_pro_seq() {
		return sales_pro_seq;
	}
	public void setSales_pro_seq(int sales_pro_seq) {
		this.sales_pro_seq = sales_pro_seq;
	}
	public String getSales_reg_date() {
		return sales_reg_date;
	}
	public void setSales_reg_date(String sales_reg_date) {
		this.sales_reg_date = sales_reg_date;
	}
	@Override
	public String toString() {
		return "자바단     EmpSalePlanModel [sales_pro_seq=" + sales_pro_seq + ", client_cd=" + client_cd + ", client_nm="
				+ client_nm + ", goal_amt=" + goal_amt + ", large_classifi=" + large_classifi + ", small_classifi="
				+ small_classifi + ", loginID=" + loginID + ", memo=" + memo + ", product_cd=" + product_cd
				+ ", sales_reg_date=" + sales_reg_date + ", prod_nm=" + prod_nm + ", estimate_cnt=" + estimate_cnt
				+ "]";
	}
	
	
	
	
	


	
	

	
}
