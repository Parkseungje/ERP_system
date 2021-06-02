package kr.happyjob.study.system.model;

public class MnuMgrChildModel {
	// 메뉴 ID * 형식 : [접두어,1][일련번호,4]    예) M0001
	private String mnu_id;
	// 상위 메뉴 ID
	private String hir_mnu_id;
	// 메뉴 명
	private String mnu_nm;
	// 메뉴 URL
	private String mnu_url;
	// 메뉴 구분 코드 * M : 관리자 * U : 사용자
	private String mnu_dvs_cod;
	// 그룹 번호
	private int grp_num;
	// 순서
	private int odr;
	// 레벨
	private int lvl;
	// 사용 유무
	private String use_poa;
	// 삭제 유무
	private String dlt_poa;
	// 최초 등록 일시
	private String fst_enlm_dtt;
	// 최초 등록자 시스템 ID
	private String fst_rgst_sst_id;
	// 최종 수정 일시
	private String fnl_mdfd_dtt;
	// 최종 수정자 시스템 ID
	private String fnl_mdfr_sst_id;

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
	public int getGrp_num() {
		return grp_num;
	}
	/**
	 * @param grp_num the grp_num to set
	 */
	public void setGrp_num(int grp_num) {
		this.grp_num = grp_num;
	}
	/**
	 * @return the odr
	 */
	public int getOdr() {
		return odr;
	}
	/**
	 * @param odr the odr to set
	 */
	public void setOdr(int odr) {
		this.odr = odr;
	}
	/**
	 * @return the lvl
	 */
	public int getLvl() {
		return lvl;
	}
	/**
	 * @param lvl the lvl to set
	 */
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	/**
	 * @return the use_poa
	 */
	public String getUse_poa() {
		return use_poa;
	}
	/**
	 * @param use_poa the use_poa to set
	 */
	public void setUse_poa(String use_poa) {
		this.use_poa = use_poa;
	}
	/**
	 * @return the dlt_poa
	 */
	public String getDlt_poa() {
		return dlt_poa;
	}
	/**
	 * @param dlt_poa the dlt_poa to set
	 */
	public void setDlt_poa(String dlt_poa) {
		this.dlt_poa = dlt_poa;
	}
	/**
	 * @return the fst_enlm_dtt
	 */
	public String getFst_enlm_dtt() {
		return fst_enlm_dtt;
	}
	/**
	 * @param fst_enlm_dtt the fst_enlm_dtt to set
	 */
	public void setFst_enlm_dtt(String fst_enlm_dtt) {
		this.fst_enlm_dtt = fst_enlm_dtt;
	}
	/**
	 * @return the fst_rgst_sst_id
	 */
	public String getFst_rgst_sst_id() {
		return fst_rgst_sst_id;
	}
	/**
	 * @param fst_rgst_sst_id the fst_rgst_sst_id to set
	 */
	public void setFst_rgst_sst_id(String fst_rgst_sst_id) {
		this.fst_rgst_sst_id = fst_rgst_sst_id;
	}
	/**
	 * @return the fnl_mdfd_dtt
	 */
	public String getFnl_mdfd_dtt() {
		return fnl_mdfd_dtt;
	}
	/**
	 * @param fnl_mdfd_dtt the fnl_mdfd_dtt to set
	 */
	public void setFnl_mdfd_dtt(String fnl_mdfd_dtt) {
		this.fnl_mdfd_dtt = fnl_mdfd_dtt;
	}
	/**
	 * @return the fnl_mdfr_sst_id
	 */
	public String getFnl_mdfr_sst_id() {
		return fnl_mdfr_sst_id;
	}
	/**
	 * @param fnl_mdfr_sst_id the fnl_mdfr_sst_id to set
	 */
	public void setFnl_mdfr_sst_id(String fnl_mdfr_sst_id) {
		this.fnl_mdfr_sst_id = fnl_mdfr_sst_id;
	}

	
	
}
