package kr.happyjob.study.system.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.system.model.NoticeModel;
import kr.happyjob.study.system.model.NoticeNewModel;

public interface NoticeService {

	// 공지사항 리스트 조회
	public List<NoticeModel> noticenewList(Map<String, Object> paramMap)throws Exception ;
	  
	// 공지사항 목록 카운트 조회
	public int noticenewCount(Map<String, Object> paramMap)throws Exception ;
	
	// **** 공지사항 단건 조회(변경)****
	public NoticeNewModel noticenewdetail(Map<String, Object> paramMap)throws Exception ;
	
	// 공지사항 저장
	public int insertNotice(Map<String, Object> paramMap) throws Exception;
	
	// 공지사항 수정
	public int updateNotice(Map<String, Object> paramMap) throws Exception;
	
	// **** 공지사항 삭제(변경)****
	public int noticenewdelete(Map<String, Object> paramMap) throws Exception;
	
}