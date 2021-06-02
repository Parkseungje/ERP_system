package kr.happyjob.study.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.system.dao.NoticeDao;
import kr.happyjob.study.system.model.ComnGrpCodModel;
import kr.happyjob.study.system.model.NoticeModel;
import kr.happyjob.study.system.model.NoticeNewModel;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao noticeDao;
  
	@Override
	public List<NoticeModel> noticenewList(Map<String, Object> paramMap) throws Exception{

		List<NoticeModel> noticeList = noticeDao.noticenewList(paramMap);
		return noticeList;
	}

	@Override
	public int noticenewCount(Map<String, Object> paramMap) throws Exception {
		int noticeCnt = noticeDao.noticenewCount(paramMap);
		return noticeCnt;
	}

	// **** 상세 조회(변경)****
	@Override
	public NoticeNewModel noticenewdetail(Map<String, Object> paramMap) throws Exception {

	  NoticeNewModel noticeModel = noticeDao.noticenewdetail(paramMap);
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

	// **** 삭제(변경)****
	@Override
	public int noticenewdelete(Map<String, Object> paramMap) throws Exception {

		int statusChange = noticeDao.noticenewdelete(paramMap);
		return statusChange;
	}

}
