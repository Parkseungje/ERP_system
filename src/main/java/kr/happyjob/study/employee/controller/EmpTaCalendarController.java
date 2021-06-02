package kr.happyjob.study.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.employee.model.EmpTaModel;
import kr.happyjob.study.employee.service.EmpTaCalendarService;

@Controller
@RequestMapping("/employee/")
public class EmpTaCalendarController {
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	EmpTaCalendarService empTaCalendarService;
	
	/* 근태현황조회 초기화면 */
	@RequestMapping("empTaCalendar.do")
	public String initEmpTaCalendar(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("+ Start " + className + ".initEmpTaCalendar");
		
		return "employee/empTaCalendar";
	}//근태현황조회 초기화면 끝
	
	/* 근태현황조회*/
	@RequestMapping(value = "empTaList.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String empTaList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session){

		logger.info("+ Start " + className + ".empTaList");
		logger.info("   - paramMap : " + paramMap);
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		
		List<EmpTaModel> empTaList = empTaCalendarService.empTaList(paramMap);
		logger.info("   - empTaList : " + empTaList);
		
		for (EmpTaModel dto : empTaList) {
			JSONObject empTaModel = new JSONObject();
			empTaModel.put("ta_yn", dto.getTa_yn());
			empTaModel.put("ta_yn_cnt", dto.getTa_yn_cnt());
			empTaModel.put("ta_reg_date", dto.getTa_reg_date());
			empTaModel.put("name", dto.getName());
			empTaModel.put("kind_hol", dto.getKind_hol());
			
			array.put(empTaModel);
		}
		
		object.put("empTaList", array);
		
		logger.info("+ End " + className + ".empTaList");
		
		return object.toString();
	}
	
	/* 근태현황조회*/
	@RequestMapping(value = "empTaDetailList.do")
	@ResponseBody
	public Map<String, Object>  empTaDetailList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session){
		logger.info("+ Start " + className + ".empTaList");
		logger.info("   - paramMap : " + paramMap);
		
		List<EmpTaModel> empTaDetailList = empTaCalendarService.empTaDetailList(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("empTaDetailList", empTaDetailList);
		
		return resultMap;
	}
}
