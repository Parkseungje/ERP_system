package kr.happyjob.study.sales.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.sales.model.ArmngModel;

public interface ArmngDao {
	public List<ArmngModel>  armngtitle(Map<String, Object> paramMap);
	public ArmngModel armngSelect(Map<String, Object> paramMap);
	public void armngUpdate(Map<String, Object> paramMap);
}
