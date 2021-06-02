package kr.happyjob.study.sample.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.system.model.ComnCodUtilModel;
import kr.happyjob.study.system.model.ComnDtlCodModel;
import kr.happyjob.study.system.model.ComnGrpCodModel;

public interface SampleComnCodDao {

   /** 그룹코드 목록 조회 */
   //gouppcodelist 가 쿼리문 ID가 됌.
   public List<ComnGrpCodModel> gouppcodelist(Map<String, Object> paramMap);
   
   /** 그룹코드 목록 카운트 조회 */
   public int gouppcodecount(Map<String, Object> paramMap);
   
   /** 상세코드 목록 조회 */
   public List<ComnDtlCodModel> detailcodelist(Map<String, Object> paramMap) throws Exception;
   
   /** 상세코드 목록 카운트 조회 */
   public int detailcodecount(Map<String, Object> paramMap) throws Exception;
      
   /** 그룹코드 한건 조회 */
   public ComnGrpCodModel selectgroupcode(Map<String, Object> paramMap) throws Exception;
   
   /** 그룹코드 등록 */
   public void insertgroupcode(Map<String, Object> paramMap) throws Exception;   
   
   /** 그룹코드 수정 */
   public void updategroupcode(Map<String, Object> paramMap) throws Exception;
   
   /** 그룹코드 삭제 */
   public void deletegroupcode(Map<String, Object> paramMap) throws Exception;
   
   /** 상세코드 한건 조회 */
   public ComnDtlCodModel selectdetailcode(Map<String, Object> paramMap) throws Exception;
   
   /** 상세코드 등록 */
   public void insertdetailcode(Map<String, Object> paramMap) throws Exception;   
   
   /** 상세코드 수정 */
   public void updatedetailcode(Map<String, Object> paramMap) throws Exception;
   
   /** 상세코드 삭제 */
   public void deletedetailcode(Map<String, Object> paramMap) throws Exception;
   
}