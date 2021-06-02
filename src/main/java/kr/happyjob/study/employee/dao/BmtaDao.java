package kr.happyjob.study.employee.dao;

import java.util.List;
import java.util.Map;


import kr.happyjob.study.employee.model.BmtaModel;

public interface BmtaDao {
	public List<BmtaModel>  taapprove(Map<String, Object> paramMap);
	
	public int taapprovecnt(Map<String, Object> paramMap);
	
	public BmtaModel taapproveUpdateSelect(Map<String, Object> paramMap);
	
	public void taapproveUpdate(Map<String, Object> paramMap);
}
