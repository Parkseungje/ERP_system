package kr.happyjob.study.sample.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.sample.dao.SampleComnCodDao;
import kr.happyjob.study.system.model.ComnCodUtilModel;
import kr.happyjob.study.system.model.ComnDtlCodModel;
import kr.happyjob.study.system.model.ComnGrpCodModel;

@Service
public class SampleComnCodServiceImpl implements SampleComnCodService {

   // Set logger
   private final Logger logger = LogManager.getLogger(this.getClass());
   
   // Get class name for logger
   private final String className = this.getClass().toString();
   
   @Autowired
   SampleComnCodDao samplecomnCodDao;
   
   /** 그룹코드 목록 조회 */
   public List<ComnGrpCodModel> gouppcodelist(Map<String, Object> paramMap) throws Exception {
      
      List<ComnGrpCodModel> gouppcodelist = samplecomnCodDao.gouppcodelist(paramMap);
      
      return gouppcodelist;
   }
   
   /** 그룹코드 목록 카운트 조회 */
   public int gouppcodecount(Map<String, Object> paramMap) throws Exception {
      
      int gouppcodecount = samplecomnCodDao.gouppcodecount(paramMap);
      
      return gouppcodecount;
   }
   
   /** 상세코드 목록 조회 */
   public List<ComnDtlCodModel> detailcodelist(Map<String, Object> paramMap) throws Exception {
      
      List<ComnDtlCodModel> detailcodelist = samplecomnCodDao.detailcodelist(paramMap);
      
      return detailcodelist;
   }
   
   /** 상세코드 목록 카운트 조회 */
   public int detailcodecount(Map<String, Object> paramMap) throws Exception {
      
      int detailcodecount = samplecomnCodDao.detailcodecount(paramMap);
      
      return detailcodecount;
   }   
   
   
   /** 그룹코드 한건 조회 */
   public ComnGrpCodModel selectgroupcode(Map<String, Object> paramMap) throws Exception {
      
      ComnGrpCodModel selectgroupcode = samplecomnCodDao.selectgroupcode(paramMap);
      
      return selectgroupcode;
   }   
   
   /** 그룹코드 등록 */
   public void insertgroupcode(Map<String, Object> paramMap) throws Exception {
      samplecomnCodDao.insertgroupcode(paramMap);
   }      
   
   /** 그룹코드 수정 */
   public void updategroupcode(Map<String, Object> paramMap) throws Exception {
      samplecomnCodDao.updategroupcode(paramMap);
   }   
   
   /** 그룹코드 삭제 */
   public void deletegroupcode(Map<String, Object> paramMap) throws Exception {
      samplecomnCodDao.deletegroupcode(paramMap);
   }   
   
   /** 상세코드 한건 조회 */
   public ComnDtlCodModel selectdetailcode(Map<String, Object> paramMap) throws Exception {
      
      ComnDtlCodModel selectdetailcode = samplecomnCodDao.selectdetailcode(paramMap);
      
      return selectdetailcode;
   }      

   /** 상세코드 등록 */
   public void insertdetailcode(Map<String, Object> paramMap) throws Exception {
      samplecomnCodDao.insertdetailcode(paramMap);
   }      
   
   /** 상세코드 수정 */
   public void updatedetailcode(Map<String, Object> paramMap) throws Exception {
      samplecomnCodDao.updatedetailcode(paramMap);
   }      
   
   /** 상세코드 삭제 */
   public void deletedetailcode(Map<String, Object> paramMap) throws Exception {
      samplecomnCodDao.deletedetailcode(paramMap);
   }
}