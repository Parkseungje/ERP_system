package kr.happyjob.study.community.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.community.model.QnAByinqNoModel;
import kr.happyjob.study.community.model.QnAModel;

public interface QnAService {
	
	/** 1:1문의 목록 조회 */
	public List<QnAModel> listQnA(Map<String, Object> paramMap) throws Exception;
	
	/** 1:1문의 목록 카운트 조회 */
	public int countListQnA(Map<String, Object> paramMap) throws Exception;

	// 문의 번호로 문의 정보 가져오기
		public QnAModel selectQnAByInqNo(Map<String, Object> paramMap) throws Exception;
		
		//1:1 문의 답변 저장
		public	int insertQnAAns(Map<String, Object> paramMap) throws Exception;
		
		//1:1 문의 답변 여부
		public int answerONX(Map<String, Object> paramMap) throws Exception;
		
		//1:1 문의 답변 삭제
		public int inqAnsDel(Map<String, Object> paramMap) throws Exception;
}
