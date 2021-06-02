package kr.happyjob.study.common.comnUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.happyjob.study.system.model.ComnCodUtilModel;
import kr.happyjob.study.system.service.ComnCodService;

@Component
public class ComnCodUtil {

	private static List<ComnCodUtilModel> listComnCod;


	@Autowired
	ComnCodService comnCodService;

	@PostConstruct
	public void initCodes() throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		listComnCod = comnCodService.listAllComnCode(paramMap);
	}

	
	/**
	 * 공통코드 조회
	 */
	public static List<ComnCodUtilModel> getComnCod(String grp_cod) {

		List<ComnCodUtilModel> resultList = new ArrayList<ComnCodUtilModel>();

		if (listComnCod != null) {

			for (ComnCodUtilModel comnCodUtilModel : listComnCod) {
				if (comnCodUtilModel.getGrp_cod().equals(grp_cod)) {
					resultList.add(comnCodUtilModel);
				}
			}
		}

		return resultList;
	}

	/**
	 * 공통코드 조회 value : 제외처리
	 */
	public static List<ComnCodUtilModel> getComnCod(String grp_cod, String value) {

		List<ComnCodUtilModel> resultList = new ArrayList<ComnCodUtilModel>();

		if (listComnCod != null) {

			for (ComnCodUtilModel comnCodUtilModel : listComnCod) {
				if (comnCodUtilModel.getGrp_cod().equals(grp_cod)) {
					if (!comnCodUtilModel.getDtl_cod().equals(value))
						resultList.add(comnCodUtilModel);
				}
			}
		}

		return resultList;
	}

}
