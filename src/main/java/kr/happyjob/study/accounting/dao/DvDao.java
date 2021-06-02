package kr.happyjob.study.accounting.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.accounting.model.DvModel;


public interface DvDao {

	/** 지출결의 목록 조회(신청페이지) */
	public List<DvModel> listEmpDv(Map<String, Object> paramMap);
	
	/** 지출결의 목록 카운트 조회(신청페이지) */
	public int countListEmpDv(Map<String, Object> paramMap);
	
	/** 지출결의 단건 조회(신청페이지) */
	public DvModel selectEmpDv(Map<String, Object> paramMap);
	
	/** 지출결의 저장(신청페이지) */
	public int insertEmpDv(Map<String, Object> paramMap);

	/** 지출결의 수정(신청페이지) */
	public int updateEmpDv(Map<String, Object> paramMap);	
		
	/** 지출결의 삭제(신청페이지) */
	public int deleteEmpDv(Map<String, Object> paramMap);
	
	/** 지출결의 목록 조회(승인페이지) */
	public List<DvModel> listBmDv(Map<String, Object> paramMap);
	
	/** 지출결의 목록 카운트 조회(승인페이지) */
	public int countListBmDv(Map<String, Object> paramMap);
	
	/** 지출결의 단건 조회(승인페이지) */
	public DvModel selectBmDv(Map<String, Object> paramMap);

	/** 등록된 row값 가져오기(승인페이지) **/
	public String selectDv_no(Map<String, Object> paramMap);

	/** 파일 업로드 **/
	public void updateDvFile(Map<String, Object> paramMap);

	/** 지출 결의 승인처리*/
	public void saveAppDv(Map<String, Object> paramMap);

	/** 방금 승인처리된 지출결의건 승인여부 정보 가져오기 (2: 승인 / 3: 반려) */
	public int selectAppType(Map<String, Object> paramMap);
	
	/** 승인된 지출결의 정보 계정 금액 정보 테이블(tb_acc_slip) 에 저장 */
	public void insertToaccslip(Map<String, Object> paramMap);

	/** 지출결의 첨부서류 파일정보 가져오기 */
	public String selectAttFile(Map<String, Object> paramMap);

}
