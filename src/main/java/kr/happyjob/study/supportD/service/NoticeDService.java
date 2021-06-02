package kr.happyjob.study.supportD.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.supportD.model.NoticeDModel;


public interface NoticeDService {

	List<NoticeDModel> noticeList(Map<String, Object> paramMap);

	int noticeTotalCnt(Map<String, Object> paramMap);

	NoticeDModel detailNotice(Map<String, Object> paramMap);



}