package kr.happyjob.study.common.comnUtils;

public class FileUtilModel {

	// 논리 파일 명
	private String lgc_fil_nm;
	
	// 물리 파일 명
	private String psc_fil_nm;
	
	// 저용량 물리 파일 명
	private String sml_psc_fil_nm;
	
	// 파일 확장자
	private String fil_ets;
	
	// 원본 파일 사이즈
	private String fil_siz;
	
	// 저용량 파일 사이즈
	private String sml_fil_size;
	
	// 첨부파일 구분 코드
	private String fil_dvs_cod;

	/**
	 * @return the lgc_fil_nm
	 */
	public String getLgc_fil_nm() {
		return lgc_fil_nm;
	}

	/**
	 * @param lgc_fil_nm the lgc_fil_nm to set
	 */
	public void setLgc_fil_nm(String lgc_fil_nm) {
		this.lgc_fil_nm = lgc_fil_nm;
	}

	/**
	 * @return the psc_fil_nm
	 */
	public String getPsc_fil_nm() {
		return psc_fil_nm;
	}

	/**
	 * @param psc_fil_nm the psc_fil_nm to set
	 */
	public void setPsc_fil_nm(String psc_fil_nm) {
		this.psc_fil_nm = psc_fil_nm;
	}

	/**
	 * @return the sml_psc_fil_nm
	 */
	public String getSml_psc_fil_nm() {
		return sml_psc_fil_nm;
	}

	/**
	 * @param sml_psc_fil_nm the sml_psc_fil_nm to set
	 */
	public void setSml_psc_fil_nm(String sml_psc_fil_nm) {
		this.sml_psc_fil_nm = sml_psc_fil_nm;
	}

	/**
	 * @return the fil_ets
	 */
	public String getFil_ets() {
		return fil_ets;
	}

	/**
	 * @param fil_ets the fil_ets to set
	 */
	public void setFil_ets(String fil_ets) {
		this.fil_ets = fil_ets;
	}

	/**
	 * @return the fil_siz
	 */
	public String getFil_siz() {
		return fil_siz;
	}

	/**
	 * @param fil_siz the fil_siz to set
	 */
	public void setFil_siz(String fil_siz) {
		this.fil_siz = fil_siz;
	}

	/**
	 * @return the sml_fil_size
	 */
	public String getSml_fil_size() {
		return sml_fil_size;
	}

	/**
	 * @param sml_fil_size the sml_fil_size to set
	 */
	public void setSml_fil_size(String sml_fil_size) {
		this.sml_fil_size = sml_fil_size;
	}

	/**
	 * @return the fil_dvs_cod
	 */
	public String getFil_dvs_cod() {
		return fil_dvs_cod;
	}

	/**
	 * @param fil_dvs_cod the fil_dvs_cod to set
	 */
	public void setFil_dvs_cod(String fil_dvs_cod) {
		this.fil_dvs_cod = fil_dvs_cod;
	}
}
