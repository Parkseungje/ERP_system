package kr.happyjob.study.accounting.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.accounting.dao.AcctitleDao;
import kr.happyjob.study.accounting.model.AcctitleModel;

@Service
public class AcctitleServiceImp implements AcctitleService {
	
	@Autowired
	AcctitleDao acctitleDao;

	@Override
	public List<AcctitleModel> acctitle(Map<String, Object> paramMap) {
		List<AcctitleModel> acctitle = acctitleDao.acctitle(paramMap);
		return acctitle;
	}

	@Override
	public void acctitleWrite(Map<String, Object> paramMap) {
		acctitleDao.acctitleWrite(paramMap);
	
	}
	
	@Override
	public AcctitleModel acctitleUpdateSelect(Map<String, Object> paramMap) {
		return acctitleDao.acctitleUpdateSelect(paramMap);
	}
	
	@Override
	public void acctitleUpdate(Map<String, Object> paramMap) {
		acctitleDao.acctitleUpdate(paramMap);
	
	}
	
	
	/*
	@Override
	public int admNoticeCnt(Map<String, Object> paramMap) {
		int admNoticeCnt = acctitleDao.admNoticeCnt(paramMap);
		return admNoticeCnt;
	}

	@Override
	public List<AcctitleModel> tutNotice(Map<String, Object> paramMap) {
		List<AcctitleModel> tutNotice = acctitleDao.tutNotice(paramMap);
		return tutNotice;
	}

	@Override
	public int tutNoticeCnt(Map<String, Object> paramMap) {
		int tutNoticeCnt = acctitleDao.tutNoticeCnt(paramMap);
		return tutNoticeCnt;
	}

	@Override
	public AcctitleModel tutDetail(Map<String, Object> paramMap) {
		AcctitleModel tutDetail = acctitleDao.tutDetail(paramMap);
		return tutDetail;
	}

	@Override
	public AcctitleModel admDetail(Map<String, Object> paramMap) {
		AcctitleModel admDetail = acctitleDao.admDetail(paramMap);
		return admDetail;
	}

	@Override
	public int admHit(Map<String, Object> paramMap) {
		int admHit = acctitleDao.admHit(paramMap);
		return admHit;
	}

	@Override
	public int tutHit(Map<String, Object> paramMap) {
		int tutHit = acctitleDao.tutHit(paramMap);
		return tutHit;
	}

	@Override
	public int admWrite(Map<String, Object> paramMap) {
		int admWrite = acctitleDao.admWrite(paramMap);
		return admWrite;
	}

	@Override
	public int tutWrite(Map<String, Object> paramMap) {
		int tutWrite = acctitleDao.tutWrite(paramMap);
		return tutWrite;
	}

	@Override
	public int admDel(Map<String, Object> paramMap) {
		int admDel = acctitleDao.admDel(paramMap);
		return admDel;
	}

	@Override
	public int tutDel(Map<String, Object> paramMap) {
		int tutDel = acctitleDao.tutDel(paramMap);
		return tutDel;
	}

	@Override
	public AcctitleModel typeCheck(Map<String, Object> paramMap) {
		AcctitleModel typeCheck = acctitleDao.typeCheck(paramMap);
		return typeCheck;
	}

	@Override
	public int admUpdate(Map<String, Object> paramMap) {
		int admUpdate = acctitleDao.admUpdate(paramMap);
		return admUpdate;
	}

	@Override
	public int tutUpdate(Map<String, Object> paramMap) {
		int tutUpdate = acctitleDao.tutUpdate(paramMap);
		return tutUpdate;
	}
	*/
}
