package kr.happyjob.study.supportD.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.supportD.dao.NoticeDDao;
import kr.happyjob.study.supportD.model.NoticeDModel;

@Service
public class NoticeDServiceImpl implements NoticeDService {
	
	@Autowired
	NoticeDDao noticeDDao;

	@Override
	public List<NoticeDModel> noticeList(Map<String, Object> paramMap) {
		List<NoticeDModel> noticeList=noticeDDao.noticeList(paramMap);
		return noticeList;
	}

	@Override
	public int noticeTotalCnt(Map<String, Object> paramMap) {
		int noticeTotalCnt=noticeDDao.noticeTotalCnt(paramMap);
		return noticeTotalCnt;
	}

	@Override
	public NoticeDModel detailNotice(Map<String, Object> paramMap) {
		 NoticeDModel detailNotice=noticeDDao.detailNotice(paramMap);
		return detailNotice;
	}



}