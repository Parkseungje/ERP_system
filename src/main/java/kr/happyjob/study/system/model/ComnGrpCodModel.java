package kr.happyjob.study.system.model;

import java.util.Date;

public class ComnGrpCodModel {

   // 게시판 글 번호
   private int row_num;

   // 그룹 코드
   private String grp_cod;

   // 그룹 코드 명
   private String grp_cod_nm;

   // 그룹 코드 설명
   private String grp_cod_eplti;

   // 임시 필드 01
   private String tmp_fld_01;

   // 임시 필드 02
   private String tmp_fld_02;

   // 임시 필드 03
   private String tmp_fld_03;

   // 사용 유무
   private String use_poa;

   // 최초 등록 일시
   private Date fst_enlm_dtt;

   // 최종 등록 일시
   private String reg_date;   
   
   // 최초 등록자 시스템 ID
   private String fst_rgst_sst_id;

   // 최종 수정 일시
   private String fnl_mdfd_dtt;

   // 최종 수정자 시스템 ID
   private String fnl_mdfr_sst_id;

   // 상세코드 건수
   private int detailcnt;
   
   /**
    * @return the row_num
    */
   public int getRow_num() {
      return row_num;
   }

   /**
    * @param row_num
    *            the row_num to set
    */
   public void setRow_num(int row_num) {
      this.row_num = row_num;
   }

   /**
    * @return the grp_cod
    */
   public String getGrp_cod() {
      return grp_cod;
   }

   /**
    * @param grp_cod
    *            the grp_cod to set
    */
   public void setGrp_cod(String grp_cod) {
      this.grp_cod = grp_cod;
   }

   /**
    * @return the grp_cod_nm
    */
   public String getGrp_cod_nm() {
      return grp_cod_nm;
   }

   /**
    * @param grp_cod_nm
    *            the grp_cod_nm to set
    */
   public void setGrp_cod_nm(String grp_cod_nm) {
      this.grp_cod_nm = grp_cod_nm;
   }

   public String getReg_date() {
      return reg_date;
   }

   public void setReg_date(String reg_date) {
      this.reg_date = reg_date;
   }
   
   
   /**
    * @return the grp_cod_eplti
    */
   public String getGrp_cod_eplti() {
      return grp_cod_eplti;
   }

   /**
    * @param grp_cod_eplti
    *            the grp_cod_eplti to set
    */
   public void setGrp_cod_eplti(String grp_cod_eplti) {
      this.grp_cod_eplti = grp_cod_eplti;
   }

   /**
    * @return the tmp_fld_01
    */
   public String getTmp_fld_01() {
      return tmp_fld_01;
   }

   /**
    * @param tmp_fld_01
    *            the tmp_fld_01 to set
    */
   public void setTmp_fld_01(String tmp_fld_01) {
      this.tmp_fld_01 = tmp_fld_01;
   }

   /**
    * @return the tmp_fld_02
    */
   public String getTmp_fld_02() {
      return tmp_fld_02;
   }

   /**
    * @param tmp_fld_02
    *            the tmp_fld_02 to set
    */
   public void setTmp_fld_02(String tmp_fld_02) {
      this.tmp_fld_02 = tmp_fld_02;
   }

   /**
    * @return the tmp_fld_03
    */
   public String getTmp_fld_03() {
      return tmp_fld_03;
   }

   /**
    * @param tmp_fld_03
    *            the tmp_fld_03 to set
    */
   public void setTmp_fld_03(String tmp_fld_03) {
      this.tmp_fld_03 = tmp_fld_03;
   }

   /**
    * @return the use_poa
    */
   public String getUse_poa() {
      return use_poa;
   }

   /**
    * @param use_poa
    *            the use_poa to set
    */
   public void setUse_poa(String use_poa) {
      this.use_poa = use_poa;
   }

   /**
    * @return the fst_enlm_dtt
    */
   public Date getFst_enlm_dtt() {
      return fst_enlm_dtt;
   }

   /**
    * @param fst_enlm_dtt
    *            the fst_enlm_dtt to set
    */
   public void setFst_enlm_dtt(Date fst_enlm_dtt) {
      this.fst_enlm_dtt = fst_enlm_dtt;
   }

   /**
    * @return the fst_rgst_sst_id
    */
   public String getFst_rgst_sst_id() {
      return fst_rgst_sst_id;
   }

   /**
    * @param fst_rgst_sst_id
    *            the fst_rgst_sst_id to set
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
    * @param fnl_mdfd_dtt
    *            the fnl_mdfd_dtt to set
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
    * @param fnl_mdfr_sst_id
    *            the fnl_mdfr_sst_id to set
    */
   public void setFnl_mdfr_sst_id(String fnl_mdfr_sst_id) {
      this.fnl_mdfr_sst_id = fnl_mdfr_sst_id;
   }
   
   public int getDetailcnt() {
      return detailcnt;
   }

   public void setDetailcnt(int detailcnt) {
      this.detailcnt = detailcnt;
   }

}