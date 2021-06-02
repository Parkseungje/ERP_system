package kr.happyjob.study.accounting.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.happyjob.study.accounting.model.DvModel;
import kr.happyjob.study.accounting.service.DvService;
import kr.happyjob.study.common.comnUtils.FileUtilCho;
import kr.happyjob.study.accounting.dao.DvDao;

@Service
public class DvServiceImpl implements DvService{

	@Autowired
	DvDao dvDao;

	@Value("${fileUpload.rootPath}")
	private String rootPath;
	@Value("${fileUpload.accimgPath}")
	private String accimgPath;
	
	
	/** 지출결의 목록 조회(신청페이지) **/
	
	public List<DvModel> listEmpDv(Map<String, Object> paramMap) throws Exception{
		
		List<DvModel> listEmpDv = dvDao.listEmpDv(paramMap);
		
		return listEmpDv;
		
	}
	
	/** 지출결의 목록 카운트 조회(신청페이지) **/
	
	public int countListEmpDv(Map<String, Object> paramMap) throws Exception{
		
		   int totalCount = dvDao.countListEmpDv(paramMap);
			
		   return totalCount;
		}	
	
	/** 지출결의 단건 조회 (신청페이지) **/
	
	public DvModel selectEmpDv(Map<String, Object> paramMap) throws Exception {
		
		DvModel empDvModel = dvDao.selectEmpDv(paramMap);
		return empDvModel;
	}

	/** 지출결의 저장(신청페이지) **/
	
	public void insertEmpDv(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest)request;
		
		
		try{
			dvDao.insertEmpDv(paramMap);
			
			String dv_no = dvDao.selectDv_no(paramMap);
			
			System.out.println("dv_no : "+dv_no);
			String itemFilePath = accimgPath + dv_no + File.separator;
			
			FileUtilCho fileUtilCho = new FileUtilCho(mpRequest, rootPath, itemFilePath);
			Map<String, Object> listFileUtilModel = fileUtilCho.uploadFiles();
			
			paramMap.put("att_filename", listFileUtilModel.get("file_nm"));
			paramMap.put("att_filepath", listFileUtilModel.get("file_loc"));
			paramMap.put("att_filesize", listFileUtilModel.get("file_size"));
			paramMap.put("dv_no", dv_no);
			
			if(mpRequest.getFile("att_file").getSize() > 0) {
				dvDao.updateDvFile(paramMap);
			}else {
				System.out.println("첨부 파일 없음");
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	
	/** 지출결의 목록 조회(승인페이지) **/
	public List<DvModel> listBmDv(Map<String, Object> paramMap) throws Exception{
		
		List<DvModel> listBmDv = dvDao.listBmDv(paramMap);
		
		return listBmDv;
		
	}
	
	/** 지출결의 목록 카운트 조회(승인페이지) **/
	
	public int countListBmDv(Map<String, Object> paramMap) throws Exception{
		
		   int totalCount = dvDao.countListBmDv(paramMap);
			
		   return totalCount;
		}	
	
	/** 지출결의 단건 조회 (신청페이지) **/
	
	public DvModel selectBmDv(Map<String, Object> paramMap) throws Exception {
		
		DvModel bmDvModel = dvDao.selectBmDv(paramMap);
	
		return bmDvModel;
	}
	
	/** 그룹코드 삭제 **/
	public int deleteEmpDv(Map<String, Object> paramMap) throws Exception {
		
		int ret = dvDao.deleteEmpDv(paramMap);
		
		return ret;
	}
	
	/** 지출결의 승인(신청페이지) **/
	public void saveAppDv(Map<String, Object> paramMap) throws Exception{
		
	 //승인구분의 값 구하기
	//	System.out.println("dv_app_type: " + dv_app_type);
		try{
			dvDao.saveAppDv(paramMap);
			int dv_app_type = dvDao.selectAppType(paramMap);
			System.out.println("dv_app_type : " + dv_app_type);
			if(dv_app_type == 2) {
				dvDao.insertToaccslip(paramMap);  //승인구분의 값이 '2'이면 계정금액정보 테이블에 지출결의 정보 insert
			}else {
				System.out.println("11111");
			}
		}catch(Exception e){
			throw e;
		}
	}


	/* 지출결의 첨부파일 경로 가져오기 */
	
	public String selectAttFile(Map<String, Object> paramMap) throws Exception{
		
		dvDao.selectAttFile(paramMap);
		
		String selectAttFilePath = dvDao.selectAttFile(paramMap);
		
		return selectAttFilePath;
	};
}
	
	
	

