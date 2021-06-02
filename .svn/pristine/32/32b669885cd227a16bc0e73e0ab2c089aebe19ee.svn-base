package kr.happyjob.study.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.business.dao.EstManagementDao;
import kr.happyjob.study.business.dao.OeManagementDao;
import kr.happyjob.study.business.model.BizPartnerModel;
import kr.happyjob.study.business.model.EstManagementModel;
import kr.happyjob.study.business.model.OeManagementModel;

@Service
public class OeManagementServiceImpl implements OeManagementService{

	
	
	@Autowired
	OeManagementDao oeManagementDao;
	
	
	
	//리스트 목록 조회
	@Override
	public List<OeManagementModel> oemList(Map<String, Object> paramMap) throws Exception {
		
		List<OeManagementModel> listOem = oeManagementDao.oemList(paramMap);
		
		System.out.println("==================");
		System.out.println("listOem "+  listOem);
		System.out.println("listOem.size() "+listOem.size());
		System.out.println("==================");
		return listOem;
	}
	

	//리스트 목록 카운트  => 매퍼의 리스트 관계 확인
	@Override
	public int oemCnt(Map<String, Object> paramMap) {
		
		int estCnt = oeManagementDao.oemCnt(paramMap);
		
		return estCnt;
	}

	
	//단건조회
	@Override
	public OeManagementModel selectOemList(Map<String, Object> paramMap) {
		
		OeManagementModel oemManage = oeManagementDao.selectOemList(paramMap);
		
		return oemManage;
	}

	
	//단건 신규등록
	@Override
	public int insertOemList(Map<String, Object> paramMap) {
		int beta = oeManagementDao.insertOemList(paramMap);

		return beta;
	}

	//단건 업데이트
	@Override
	public int updateOemList(Map<String, Object> paramMap) {
		int beta = oeManagementDao.updateOemList(paramMap);
		return beta;
	}

	// 단건 삭제 
	@Override
	public int deleteOemList(Map<String, Object> paramMap) {
		int beta =  oeManagementDao.deleteOemList(paramMap);
		return beta;
	}

	
	
	// 모달 안 리스트 뿌리기
	@Override
	public List<OeManagementModel> oemListDetail(Map<String, Object> paramMap) throws Exception {
		
		List<OeManagementModel> DetailList = oeManagementDao.oemListDetail(paramMap);

		return DetailList;
	}
	
	// 모달 안 리스트 뿌리기 카운트 
	@Override
	public int oemDetailCnt(Map<String, Object> paramMap) {
		int oemDetailCnt = oeManagementDao.oemDetailCnt(paramMap);
		return oemDetailCnt;
	}


	
	// 견적서,견적 제품에  넘버 넣고 -> 이후 견적제품에 업데이트  
	@Override
	public int updateInsertOemList(Map<String, Object> paramMap) throws Exception {
		int updateInOemList =  oeManagementDao.updateInsertOemList(paramMap);
		return updateInOemList;
	}
	

	

	
	
}
