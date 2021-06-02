package kr.happyjob.study.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.system.dao.NoticeDao;
import kr.happyjob.study.system.model.ComnGrpCodModel;
import kr.happyjob.study.system.model.NoticeModel;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao noticeDao;

	@Override
	public List<NoticeModel> noticeList(Map<String, Object> paramMap) throws Exception{

		List<NoticeModel> noticeList = noticeDao.noticeList(paramMap);
		return noticeList;
	}

	@Override
	public int noticeCnt(Map<String, Object> paramMap) throws Exception {
		int noticeCnt = noticeDao.noticeCnt(paramMap);
		return noticeCnt;
	}

	@Override
	public NoticeModel noticeDetail(Map<String, Object> paramMap) throws Exception {

		NoticeModel noticeModel = noticeDao.noticeDetail(paramMap);
		return noticeModel;
	}

	@Override
	public int insertNotice(Map<String, Object> paramMap) throws Exception {

		int statusChange = noticeDao.insertNotice(paramMap);
		return statusChange;
	}

	@Override
	public int updateNotice(Map<String, Object> paramMap) throws Exception {

		int statusChange = noticeDao.updateNotice(paramMap);
		return statusChange;
	}

	@Override
	public int deleteNotice(Map<String, Object> paramMap) throws Exception {

		int statusChange = noticeDao.deleteNotice(paramMap);
		return statusChange;
	}

}
