package kr.happyjob.study.dashboard.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.dashboard.model.InfModel;
import kr.happyjob.study.dashboard.model.FileModel;

public interface DashInfDao {
	
	//공지사항 데쉬보드에 뿌리기
	public List<InfModel> listInf(Map<String, Object> paramMap) throws Exception;
	
	/**공지사항 목록 카운트 조회 */
	public int countListInf(Map<String, Object> paramMap) throws Exception;
	
	//문의 번호로 문의 정보 가져오기
	public InfModel selectInfByInfNo(int notice_no) throws Exception;
	
	//파일 조회
	public FileModel selectFile(Map<String, Object> paramMap);
}
