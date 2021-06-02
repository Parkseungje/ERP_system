package kr.happyjob.study.system.model;

public class MetaInfoMgrModel {
	// 사용자 번호
	private int row_num;
	// 상품 ID * 형식 : [접두어,1][년,2][일련번호,4] 예) PM170001
	private String gods_id;
	// 오피스명 
	private String ofc_id;
	// 상위 상품 ID 
	private String prt_gods_id;
	// 상품 명 
	private String gods_nm;
	// 상품 구분 코드
	private String gods_dvs_cod;
	// 상품 가격 
	private int gods_prc;
	// 시작 스탭 수량
	private String sat_stp_qnty;
	// 종료 스탭 수량
	private String end_stp_qnty;
	// 할인 가능 유무 
	private String sal_psb_poa;
	// 적용 시작 일자 
	private String apl_sat_dt;
	// 적용 종료 일자 
	private String apl_end_dt;
	// 사용 유무 
	private String use_poa;
	// 삭제 유무 
	private String dlt_poa;
	// 순서 
	private int odr;
	// 최초 등록 일시 
	private String fst_enlm_dtt;
	// 최소 등록자 시스템 ID 
	private String fst_rgst_sst_id;
	// 최종 수정 일시 
	private String fnl_mdfd_dtt;
	// 최종 수정자 시스템 ID 
	private String fnl_mdfr_sst_id;
	// 대리점 상품 할인율
	private String sal_rat;
	/**
	 * @return the row_num
	 */
	public int getRow_num() {
		return row_num;
	}
	/**
	 * @param row_num the row_num to set
	 */
	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}
	/**
	 * @return the gods_id
	 */
	public String getGods_id() {
		return gods_id;
	}
	/**
	 * @param gods_id the gods_id to set
	 */
	public void setGods_id(String gods_id) {
		this.gods_id = gods_id;
	}
	/**
	 * @return the ofc_id
	 */
	public String getOfc_id() {
		return ofc_id;
	}
	/**
	 * @param ofc_id the ofc_id to set
	 */
	public void setOfc_id(String ofc_id) {
		this.ofc_id = ofc_id;
	}
	/**
	 * @return the prt_gods_id
	 */
	public String getPrt_gods_id() {
		return prt_gods_id;
	}
	/**
	 * @param prt_gods_id the prt_gods_id to set
	 */
	public void setPrt_gods_id(String prt_gods_id) {
		this.prt_gods_id = prt_gods_id;
	}
	/**
	 * @return the gods_nm
	 */
	public String getGods_nm() {
		return gods_nm;
	}
	/**
	 * @param gods_nm the gods_nm to set
	 */
	public void setGods_nm(String gods_nm) {
		this.gods_nm = gods_nm;
	}
	/**
	 * @return the gods_dvs_cod
	 */
	public String getGods_dvs_cod() {
		return gods_dvs_cod;
	}
	/**
	 * @param gods_dvs_cod the gods_dvs_cod to set
	 */
	public void setGods_dvs_cod(String gods_dvs_cod) {
		this.gods_dvs_cod = gods_dvs_cod;
	}
	/**
	 * @return the gods_prc
	 */
	public int getGods_prc() {
		return gods_prc;
	}
	/**
	 * @param gods_prc the gods_prc to set
	 */
	public void setGods_prc(int gods_prc) {
		this.gods_prc = gods_prc;
	}
	/**
	 * @return the sat_stp_qnty
	 */
	public String getSat_stp_qnty() {
		return sat_stp_qnty;
	}
	/**
	 * @param sat_stp_qnty the sat_stp_qnty to set
	 */
	public void setSat_stp_qnty(String sat_stp_qnty) {
		this.sat_stp_qnty = sat_stp_qnty;
	}
	/**
	 * @return the end_stp_qnty
	 */
	public String getEnd_stp_qnty() {
		return end_stp_qnty;
	}
	/**
	 * @param end_stp_qnty the end_stp_qnty to set
	 */
	public void setEnd_stp_qnty(String end_stp_qnty) {
		this.end_stp_qnty = end_stp_qnty;
	}
	/**
	 * @return the sal_psb_poa
	 */
	public String getSal_psb_poa() {
		return sal_psb_poa;
	}
	/**
	 * @param sal_psb_poa the sal_psb_poa to set
	 */
	public void setSal_psb_poa(String sal_psb_poa) {
		this.sal_psb_poa = sal_psb_poa;
	}
	/**
	 * @return the apl_sat_dt
	 */
	public String getApl_sat_dt() {
		return apl_sat_dt;
	}
	/**
	 * @param apl_sat_dt the apl_sat_dt to set
	 */
	public void setApl_sat_dt(String apl_sat_dt) {
		this.apl_sat_dt = apl_sat_dt;
	}
	/**
	 * @return the apl_end_dt
	 */
	public String getApl_end_dt() {
		return apl_end_dt;
	}
	/**
	 * @param apl_end_dt the apl_end_dt to set
	 */
	public void setApl_end_dt(String apl_end_dt) {
		this.apl_end_dt = apl_end_dt;
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
	/**
	 * @return the sal_rat
	 */
	public String getSal_rat() {
		return sal_rat;
	}
	/**
	 * @param sal_rat the sal_rat to set
	 */
	public void setSal_rat(String sal_rat) {
		this.sal_rat = sal_rat;
	}
}
