package kr.happyjob.study.common.comnUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

/*import kr.kosmo.jobkorea.adm.model.AdmModel;
import kr.kosmo.jobkorea.adm.model.CompanysModel;
import kr.kosmo.jobkorea.adm.model.AdmProjectModel;*/
//import kr.kosmo.jobkorea.adm.service.AdmService;
//import kr.kosmo.jobkorea.adm.service.CompanysService;
//import kr.kosmo.jobkorea.adm.service.AdmProjectService;

@Controller
@RequestMapping("/excelDownload/")
public class ExcelDownloadController {

	//@Autowired
	//CompanysService companysService;
	
	//@Autowired
	//AdmService admService;
	
	//@Autowired
	//AdmProjectService prjMgrService;
	
	@RequestMapping(value = "/excelDownload.do")
	public View responseStatExcel(ModelMap excelParams, @RequestParam Map<String, Object> paramMap) throws Exception {
		
		String excelType = (String)paramMap.get("excelType");
		try {
				
			switch (excelType) {

//				case "acutInfoMgr":
//					paramMap.put("pageIndex", 0);
//					paramMap.put("currentPage", 1);
//					paramMap.put("pageSize", admService.countListAdm(paramMap));
//					
//					List<AdmModel> listFreeMgr = admService.listAdm(paramMap);
//					resultFreeMgr(excelType, excelParams, paramMap, listFreeMgr);
//					break;
//				case "projectMgr":
//					paramMap.put("pageIndex", 0);
//					paramMap.put("currentPage", 1);
//					paramMap.put("pageSize", prjMgrService.countTotPrj(paramMap));
//					
//					List<AdmProjectModel> listProjectMgr = prjMgrService.listProject(paramMap);
//					resultProjectMgr(excelType, excelParams, paramMap, listProjectMgr);
//					break;
//				default:
//					throw new IllegalArgumentException("Unexpected ExcelType: " + excelType);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		return new ExcelDownloadView();
	}
/*
	private void resultCompanyMgr(String excelType, ModelMap excelParams, Map<String, Object> paramMap, List<CompanysModel> resultList) {
		
		List<HashMap<String, Object>> results = new ArrayList<HashMap<String, Object>>();
		for(CompanysModel each : resultList){
			HashMap<String, Object> result = new HashMap<String, Object>();
			if(each !=null ){
				result.put("nmpidx", ComnUtil.NVL(each.getNmpidx()));
				result.put("nmpname", ComnUtil.NVL(each.getNmpname()));
				result.put("nmpemail", ComnUtil.NVL(each.getNmpemail()));
				result.put("nmpsex", ComnUtil.NVL(each.getNmpsex()));
				result.put("nmpbirth", ComnUtil.NVL(each.getNmpbirth()));
				result.put("nmphp", ComnUtil.NVL(each.getNmphp()));
				result.put("nmpwritedate", ComnUtil.NVL(each.getNmpwritedate()));
				result.put("nmpmodifydate", ComnUtil.NVL(each.getNmpmodifydate()));
				result.put("nmpip", ComnUtil.NVL(each.getNmpip()));
				result.put("nmpstatus", ComnUtil.NVL(each.getNmpstatus()));
			}
			results.add(result);
		}
		
		ExcelDownloadParam param = new ExcelDownloadParam()
				.setExcelParams(excelParams)
				.setList(results)
				.setFilePrefix(excelType)
				.setTitle("현력사관리")
				//.setDate(requestParams.get("fromDate"), requestParams.get("toDate"))
				.setNames("순번","상호명","이메일","성별","연락처","등록일자","수정일자","접속IP","삭제여부")
				.setCols("nmpidx","nmpname","nmpemail","nmpsex","nmphp","nmpwritedate","nmpmodifydate","nmpip","nmpstatus"); 
		
		ExcelDownloadView.template(param);
	}
	
	private void resultFreeMgr(String excelType, ModelMap excelParams, Map<String, Object> paramMap, List<AdmModel> resultList) {
		
		List<HashMap<String, Object>> results = new ArrayList<HashMap<String, Object>>();
		for(AdmModel each : resultList){
			HashMap<String, Object> result = new HashMap<String, Object>();
			if(each !=null ){
				result.put("nmpidx", ComnUtil.NVL(each.getNmpidx()));
				result.put("nmpname", ComnUtil.NVL(each.getNmpname()));
				result.put("nmpclass", ComnUtil.NVL(each.getNmpclass()));
				
				if("H".equals(each.getNmphome())) {
					result.put("nmphome", "재택");
				} else {
					result.put("nmphome", "");
				}

				if("S".equals(each.getNmpofis())) {
					if("S".equals(each.getNmpofissi())) {
						result.put("nmpofis", "개발");
					} else {
						result.put("nmpofis", "운영");
					}
				} else {
					result.put("nmpofis", "");
				}				
				
				result.put("nmphp", ComnUtil.NVL(each.getNmphp()));
				result.put("nmpwritedate", ComnUtil.NVL(each.getNmpwritedate()));
			}
			results.add(result);
		}
		
		ExcelDownloadParam param = new ExcelDownloadParam()
				.setExcelParams(excelParams)
				.setList(results)
				.setFilePrefix(excelType)
				.setTitle("프리랜서 정보 관리")
				//.setDate(requestParams.get("fromDate"), requestParams.get("toDate"))
				.setNames("순번","이름","등급","재택","상주","연락처","등록일자")
				.setCols("nmpidx","nmpname","nmpclass","nmphome","nmpofis","nmphp","nmpwritedate"); 
		
		ExcelDownloadView.template(param);
	}
	

	private void resultProjectMgr(String excelType, ModelMap excelParams, Map<String, Object> paramMap, List<AdmProjectModel> resultList) {
		
		List<HashMap<String, Object>> results = new ArrayList<HashMap<String, Object>>();
		int i = 0;
		for(AdmProjectModel each : resultList){
			HashMap<String, Object> result = new HashMap<String, Object>();
			if(each !=null ){
				if("00".equals(each.getProstatus())) {
					result.put("prostatus", "공고");					
				} else if("90".equals(each.getProstatus())) {
					result.put("prostatus", "금지");	
				}
				
				if("10".equals(each.getProprioritize())) {
					result.put("proprioritize", "일반");					
				} else if("20".equals(each.getProstatus())) {
					result.put("proprioritize", "긴급");	
				}		
				
				if("10".equals(each.getProsmsi())) {
					result.put("prosmsi", "개발");					
				} else if("20".equals(each.getProstatus())) {
					result.put("prosmsi", "운영");	
				} else {
					result.put("prosmsi", "개발/운영");	
				}
				
				result.put("prosttdate", each.getProsttdate());
				result.put("proenddate", each.getProenddate());
				result.put("proname", each.getProname());
				result.put("proarea", each.getProarea() + "/" + each.getProareatext());
				result.put("proindate", each.getProindate());
				result.put("prooutdate", each.getProoutdate());
				result.put("proclass", each.getProclass());
				result.put("proskill", each.getProskill());		
				
				//System.out.println(resultList.size() + "  : i ===============================" + i++);
			}
			results.add(result);
		}
		ExcelDownloadParam param = new ExcelDownloadParam()
				.setExcelParams(excelParams)
				.setList(results)
				.setFilePrefix(excelType)
				.setTitle("프로젝트 관리")
				//.setDate(requestParams.get("fromDate"), requestParams.get("toDate"))
				.setNames("공고","구분","유형","접수일","마감일","프로젝트명","위치","시작일","종료일","등급","필요스킬")
				.setCols("prostatus","proprioritize","prosmsi","prosttdate","proenddate","proname","proarea","proindate","prooutdate","proclass","proskill"); 
		
		//System.out.println("===============================" + param.toString());
		
		ExcelDownloadView.template(param);
	}
	*/
	
}
