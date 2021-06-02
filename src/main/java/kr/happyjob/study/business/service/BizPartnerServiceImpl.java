package kr.happyjob.study.business.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.business.dao.BizPartnerDao;
import kr.happyjob.study.business.model.BizPartnerModel;



@Service
public class BizPartnerServiceImpl implements BizPartnerService  {
	


	@Autowired
	private BizPartnerDao bizPartnerDao;
	
	 
	
	// 거래처 전체 조회
	@Override
	public List<BizPartnerModel> clientList(Map<String, Object> paramMap) throws Exception {
	
		
		List<BizPartnerModel> listClient = bizPartnerDao.clientList(paramMap);
		
		System.out.println("==================");
		System.out.println("listClient.size() "+listClient.size());
		System.out.println("==================");
		return listClient;
	}



	
	//거래처 조회 카운트
	@Override
	public int clientCnt(Map<String, Object> paramMap) throws Exception {
		
		int cliCnt = bizPartnerDao.clientCnt(paramMap);

		return cliCnt;
	}




	
	//단건  조회  - 모달 두번째꺼 위해서 client_nm을 가지고 한건 조회
	@Override
	public BizPartnerModel seClientList(Map<String, Object> paramMap) {
		
		BizPartnerModel bizpart = bizPartnerDao.seClientList(paramMap);
		
		return bizpart;
	}


	//단건 저장
	@Override
	public int insertClientList(Map<String, Object> paramMap) throws Exception {
		int alpa = bizPartnerDao.insertClientList(paramMap);
		return alpa;
	}



	//단건 수정
	@Override
	public int updateClientList(Map<String, Object> paramMap) throws Exception {
		int alpa = bizPartnerDao.updateClientList(paramMap);
		return alpa;
	}




	//단건 삭제
	@Override
	public int deleteClientList(Map<String, Object> paramMap) throws Exception {
		int alpa = bizPartnerDao.deleteClientList(paramMap);
		return alpa;
	}


	
	
	

}
