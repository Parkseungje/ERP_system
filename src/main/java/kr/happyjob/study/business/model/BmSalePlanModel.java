package kr.happyjob.study.business.model;

public class BmSalePlanModel {

	/* 계획등록일 */
	private String sales_reg_date;
	
	/* 로그인 ID*/
	
	private String loginID;
	
	/* 제조업체코드 */
	private String manufacturer;
	
	/* 제품대분류코드 */
	private String large_classifi;
	
	/* 제품중분류코드 */
	private String small_classifi;
	
	/* 제품코드*/
	private String product_cd;
	
	/* 목표수량 */
	private int 	goal_amt;
	
	/* 실적수량 */
	private int estimate_cnt;
	
	/* 달성률*/
	private int a_rate;
	
	/* 비고*/
	private String  memo;
	
	/* 제품명*/
	private String prod_nm;    
	
	/* 제품 대분류명*/
	private String m_ct_nm;
	
	/* 제품 중분류명*/
	private String l_ct_nm; 
	
	/* 유저타입체크*/
	private String userType;
	
	
	public String getSales_reg_date() {
		return sales_reg_date;
	}

	public void setSales_reg_date(String sales_reg_date) {
		this.sales_reg_date = sales_reg_date;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
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

	public String getProduct_cd() {
		return product_cd;
	}

	public void setProduct_cd(String product_cd) {
		this.product_cd = product_cd;
	}

	public int getGoal_amt() {
		return goal_amt;
	}

	public void setGoal_amt(int goal_amt) {
		this.goal_amt = goal_amt;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getA_rate() {
		return a_rate;
	}

	public void setA_rate(int a_rate) {
		this.a_rate = a_rate;
	}

	public int getEstimate_cnt() {
		return estimate_cnt;
	}

	public void setEstimate_cnt(int estimate_cnt) {
		this.estimate_cnt = estimate_cnt;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getProd_nm() {
		return prod_nm;
	}

	public void setProd_nm(String prod_nm) {
		this.prod_nm = prod_nm;
	}

	public String getM_ct_nm() {
		return m_ct_nm;
	}

	public void setM_ct_nm(String m_ct_nm) {
		this.m_ct_nm = m_ct_nm;
	}

	public String getL_ct_nm() {
		return l_ct_nm;
	}

	public void setL_ct_nm(String l_ct_nm) {
		this.l_ct_nm = l_ct_nm;
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}
