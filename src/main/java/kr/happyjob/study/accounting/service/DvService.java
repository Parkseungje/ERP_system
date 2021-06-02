package kr.happyjob.study.accounting.service;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.happyjob.study.accounting.model.DvModel;


public interface DvService{

	/** 지출결의 목록 조회(신청페이지) */
	public List<DvModel> listEmpDv(Map<String, Object> paramMap) throws Exception;
	
	/** 지출결의 목록 카운트 조회 (신청페이지)*/
	public int countListEmpDv(Map<String, Object> paramMap) throws Exception;
	
	/** 지출결의 단건 조회 (신청페이지)*/
	public DvModel selectEmpDv(Map<String, Object> paramMap) throws Exception;
	
	/* 지출결의 저장(신청페이지) */
	public void insertEmpDv(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;

	/** 지출결의 목록 조회(승인페이지) */
	public List<DvModel> listBmDv(Map<String, Object> paramMap) throws Exception;
	
	/** 지출결의 목록 카운트 조회 (승인페이지)*/
	public int countListBmDv(Map<String, Object> paramMap) throws Exception;
	
	/** 지출결의 단건 조회 (승인페이지)*/
	public DvModel selectBmDv(Map<String, Object> paramMap) throws Exception;
	
	/** 그룹코드 삭제 */
	public int deleteEmpDv(Map<String, Object> paramMap) throws Exception;
	
	/* 지출결의 승인(신청페이지) */
	public void saveAppDv(Map<String, Object> paramMap) throws Exception;

	/* 지출결의 첨부서류 파일정보 가져오기 */
	public String selectAttFile(Map<String, Object> paramMap) throws Exception;
	
}











