package kr.happyjob.study.common.comnUtils;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.system.model.ComnCodUtilModel;

@Controller
@RequestMapping("/commonproc/")
public class CommonProc {
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	/**
	 * 공통코드 가져오기
	 */
	@RequestMapping(value="/comcombo.do")
	@ResponseBody
	public  Map<String,Object> comcombo(Model model, 
			@RequestParam Map<String, Object> paramMap, 
			HttpServletRequest request,
			HttpServletResponse response, 
			HttpSession session) throws Exception {
	
		logger.info("+ Start " + className );
		logger.info("   - paramMap : " + paramMap);
		
		String groupcode = (String) paramMap.get("group_code");
		
		List<ComnCodUtilModel> list = ComnCodUtil.getComnCod(groupcode);	// 공유대상구분코드 (M제외)
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("list", list);
		
		logger.info("+ End " + className + " : " + list.size());
		 
		return resultMap;
	}
	
}
