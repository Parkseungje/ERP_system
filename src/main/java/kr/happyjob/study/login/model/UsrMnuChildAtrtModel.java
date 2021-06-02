package kr.happyjob.study.login.model;

public class UsrMnuChildAtrtModel {

	// 메뉴 ID
	private String mnu_id;
	
	// 부모 메뉴 ID
	private String hir_mnu_id;
	
	// 메뉴 명
	private String mnu_nm;
	
	// 메뉴 URL
	private String mnu_url;
	
	// 메뉴 구분 코드
	private String mnu_dvs_cod;
	
	// 그룹 번호
	private String grp_num;
	
	// 메뉴 순번
	private String odr;
	
	// 메뉴 레벨
	private String lvl;

	/**
	 * @return the mnu_id
	 */
	public String getMnu_id() {
		return mnu_id;
	}

	/**
	 * @param mnu_id the mnu_id to set
	 */
	public void setMnu_id(String mnu_id) {
		this.mnu_id = mnu_id;
	}

	/**
	 * @return the hir_mnu_id
	 */
	public String getHir_mnu_id() {
		return hir_mnu_id;
	}

	/**
	 * @param hir_mnu_id the hir_mnu_id to set
	 */
	public void setHir_mnu_id(String hir_mnu_id) {
		this.hir_mnu_id = hir_mnu_id;
	}

	/**
	 * @return the mnu_nm
	 */
	public String getMnu_nm() {
		return mnu_nm;
	}

	/**
	 * @param mnu_nm the mnu_nm to set
	 */
	public void setMnu_nm(String mnu_nm) {
		this.mnu_nm = mnu_nm;
	}

	/**
	 * @return the mnu_url
	 */
	public String getMnu_url() {
		return mnu_url;
	}

	/**
	 * @param mnu_url the mnu_url to set
	 */
	public void setMnu_url(String mnu_url) {
		this.mnu_url = mnu_url;
	}

	/**
	 * @return the mnu_dvs_cod
	 */
	public String getMnu_dvs_cod() {
		return mnu_dvs_cod;
	}

	/**
	 * @param mnu_dvs_cod the mnu_dvs_cod to set
	 */
	public void setMnu_dvs_cod(String mnu_dvs_cod) {
		this.mnu_dvs_cod = mnu_dvs_cod;
	}

	/**
	 * @return the grp_num
	 */
	public String getGrp_num() {
		return grp_num;
	}

	/**
	 * @param grp_num the grp_num to set
	 */
	public void setGrp_num(String grp_num) {
		this.grp_num = grp_num;
	}

	/**
	 * @return the odr
	 */
	public String getOdr() {
		return odr;
	}

	/**
	 * @param odr the odr to set
	 */
	public void setOdr(String odr) {
		this.odr = odr;
	}

	/**
	 * @return the lvl
	 */
	public String getLvl() {
		return lvl;
	}

	/**
	 * @param lvl the lvl to set
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
}
