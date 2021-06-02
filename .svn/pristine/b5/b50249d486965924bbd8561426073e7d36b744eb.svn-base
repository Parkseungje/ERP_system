package kr.happyjob.study.system.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.system.model.NoticeModel;

public interface NoticeDao {

	
	// 공지사항 리스트 조회
	public List<NoticeModel> noticeList(Map<String, Object> paramMap)throws Exception ;
	
	// 공지사항 목록 카운트 조회
	public int noticeCnt(Map<String, Object> paramMap)throws Exception ;
	
	// 공지사항 단건 조회
	public NoticeModel noticeDetail(Map<String, Object> paramMap)throws Exception ;
	
	// 공지사항 저장
	public int insertNotice(Map<String, Object> paramMap) throws Exception;
	
	// 공지사항 수정
	public int updateNotice(Map<String, Object> paramMap) throws Exception;
	
	// 공지사항 삭제
	public int deleteNotice(Map<String, Object> paramMap) throws Exception;
	
	}
