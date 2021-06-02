package kr.happyjob.study.business.model;

public class EstManagementModel {
	
	private String estimate_no;
	private String estimate_date;
	private int supply_val;
	private int supply_tax;
	private int supply_cost; 
	
	
	// 매퍼에서 다른 테이블 조인해서 데려오는 데이터
	private String client_cd; //  거래처 코드
	private String client_nm; // 거래처 이름
	
	private String cop_no1;
	private String cop_no2;
	private String cop_no3;
	private String emp_nm;
	private String emp_hp;
	
	
	private String prod_nm; // scm 제품 정보테이블에서 조인 해 데려오는 데이터
	private int estimate_cnt; // 수량
	private String addr;
	private String  addr_detail;
	
	
	private String product_cd; 
	
	
	
	
	public String getProduct_cd() {
		return product_cd;
	}
	public void setProduct_cd(String product_cd) {
		this.product_cd = product_cd;
	}
	public String getProd_nm() {
		return prod_nm;
	}
	public void setProd_nm(String prod_nm) {
		this.prod_nm = prod_nm;
	}
	public String getEstimate_no() {
		return estimate_no;
	}
	public void setEstimate_no(String estimate_no) {
		this.estimate_no = estimate_no;
	}
	public String getClient_cd() {
		return client_cd;
	}
	public void setClient_cd(String client_cd) {
		this.client_cd = client_cd;
	}
	public String getEstimate_date() {
		return estimate_date;
	}
	public void setEstimate_date(String estimate_date) {
		this.estimate_date = estimate_date;
	}
	public int getSupply_val() {
		return supply_val;
	}
	public void setSupply_val(int supply_val) {
		this.supply_val = supply_val;
	}
	public int getSupply_tax() {
		return supply_tax;
	}
	public void setSupply_tax(int supply_tax) {
		this.supply_tax = supply_tax;
	}
	public int getSupply_cost() {
		return supply_cost;
	}
	public void setSupply_cost(int supply_cost) {
		this.supply_cost = supply_cost;
	}
	

	public String getClient_nm() {
		return client_nm;
	}
	public void setClient_nm(String client_nm) {
		this.client_nm = client_nm;
	}

	public int getEstimate_cnt() {
		return estimate_cnt;
	}
	public void setEstimate_cnt(int estimate_cnt) {
		this.estimate_cnt = estimate_cnt;
	}
	public String getCop_no1() {
		return cop_no1;
	}
	public void setCop_no1(String cop_no1) {
		this.cop_no1 = cop_no1;
	}
	public String getCop_no2() {
		return cop_no2;
	}
	public void setCop_no2(String cop_no2) {
		this.cop_no2 = cop_no2;
	}
	public String getCop_no3() {
		return cop_no3;
	}
	public void setCop_no3(String cop_no3) {
		this.cop_no3 = cop_no3;
	}
	public String getEmp_nm() {
		return emp_nm;
	}
	public void setEmp_nm(String emp_nm) {
		this.emp_nm = emp_nm;
	}
	public String getEmp_hp() {
		return emp_hp;
	}
	public void setEmp_hp(String emp_hp) {
		this.emp_hp = emp_hp;
	}
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddr_detail() {
		return addr_detail;
	}
	public void setAddr_detail(String addr_detail) {
		this.addr_detail = addr_detail;
	}
	@Override
	public String toString() {
		return "자바단 EstManagementModel [estimate_no=" + estimate_no + ", estimate_date=" + estimate_date + ", supply_val="
				+ supply_val + ", supply_tax=" + supply_tax + ", supply_cost=" + supply_cost + ", client_cd="
				+ client_cd + ", client_nm=" + client_nm + ", cop_no1=" + cop_no1 + ", cop_no2=" + cop_no2
				+ ", cop_no3=" + cop_no3 + ", emp_nm=" + emp_nm + ", emp_hp=" + emp_hp + ", prod_nm=" + prod_nm
				+ ", estimate_cnt=" + estimate_cnt + ", addr=" + addr + ", addr_detail=" + addr_detail + ", product_cd="
				+ product_cd + "]";
	}
	

	
	
	
	
	
	
	

}
