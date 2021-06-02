package kr.happyjob.study.sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.common.comnUtils.ComnCodUtil;
import kr.happyjob.study.system.model.ComnCodUtilModel;
import kr.happyjob.study.system.model.ComnDtlCodModel;
import kr.happyjob.study.system.model.ComnGrpCodModel;
import kr.happyjob.study.sample.service.SampleComnCodService;

@Controller
@RequestMapping("/sample/")
public class SampleComnCodController {
   
   @Autowired
   SampleComnCodService sampleComnCodService;
   
   // Set logger
   private final Logger logger = LogManager.getLogger(this.getClass());

   // Get class name for logger
   private final String className = this.getClass().toString();
   
   
   
   /**
    * 공통코드 관리 초기화면
    */
   @RequestMapping("comnCodMgr.do")
   public String comnCodMgr(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".initComnCod");
      logger.info("   - paramMap : " + paramMap);
      
      logger.info("+ End " + className + ".initComnCod");

      return "sample/sample_comncod";
   }
     

   /**
    * 그룹코드 목록조회
    */
   @RequestMapping("gouppcodelist.do")
   public String gouppcodelist(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".gouppcodelist");
      logger.info("   - paramMap : " + paramMap);
      
      int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));   // 현재 페이지 번호
      int pageSize = Integer.parseInt((String)paramMap.get("grouppageSize"));         // 페이지 사이즈
      int pageIndex = (currentPage-1)*pageSize;                                    // 페이지 시작 row 번호
         
      paramMap.put("pageIndex", pageIndex);
      paramMap.put("pageSize", pageSize);
      
      List<ComnGrpCodModel> groupcodelist = sampleComnCodService.gouppcodelist(paramMap);
      
      int groupcodecount = sampleComnCodService.gouppcodecount(paramMap);
      
      model.addAttribute("groupcodelist",groupcodelist);
      model.addAttribute("groupcodecount",groupcodecount);
      model.addAttribute("groupcodecurrentPage",currentPage);
      model.addAttribute("pageSize",pageSize);
      
      logger.info("+ End " + className + ".gouppcodelist");

      return "sample/sample_comnGrpCodList";
   }   
   
   /**
    * 상세코드 목록조회
    */
   @RequestMapping("detailcodelist.do")
   @ResponseBody
   public Map<String,Object> detailcodelist(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".detailcodelist");
      logger.info("   - paramMap : " + paramMap);
      
      int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));   // 현재 페이지 번호
      int pageSize = Integer.parseInt((String)paramMap.get("detailpagesize"));         // 페이지 사이즈
      int pageIndex = (currentPage-1)*pageSize;                                    // 페이지 시작 row 번호
         
      paramMap.put("pageIndex", pageIndex);
      paramMap.put("pageSize", pageSize);
      
      List<ComnDtlCodModel> detailcodelist = sampleComnCodService.detailcodelist(paramMap);
      
      int totalCntComndetailCod = sampleComnCodService.detailcodecount(paramMap);
      
      Map<String,Object> returnmap = new HashMap<String,Object>();
      returnmap.put("detailcodelist", detailcodelist); 
      returnmap.put("totalCntComndetailCod", totalCntComndetailCod);
      
      logger.info("+ End " + className + ".detailcodelist");

      return returnmap;
   }      
   
   
   
   
   @RequestMapping("selectgroupcode.do")
   @ResponseBody
   public Map<String,Object> selectgroupcode(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".selectgroupcode");
      logger.info("   - paramMap : " + paramMap);
      
      ComnGrpCodModel groupcode = sampleComnCodService.selectgroupcode(paramMap);
      
      Map<String,Object> returnmap = new HashMap<String,Object>();
      returnmap.put("selectgroupcode", groupcode); 
      
      logger.info("+ End " + className + ".selectgroupcode");

      return returnmap;
   }   
   
   @RequestMapping("savegroupcode.do")
   @ResponseBody
   public Map<String,Object> savegroupcode(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".savegroupcode");
      logger.info("   - paramMap : " + paramMap);
      
      String action = (String) paramMap.get("action");
      String Result = "N";
      String resultMsg = "데이터  저장 시 오류가 발생 했습니다.";         
         
      try {
         if("U".equals(action)) {
            sampleComnCodService.updategroupcode(paramMap);
            resultMsg = "데이터  저장 되었습니다.";
         } else if("I".equals(action)) {
            sampleComnCodService.insertgroupcode(paramMap);
            resultMsg = "데이터  저장 되었습니다.";
         } else {
            sampleComnCodService.deletegroupcode(paramMap);
            resultMsg = "삭제 되었습니다.";
         }
         
         Result = "Y";
      } catch(Exception e) {
         
      }

      
      Map<String,Object> returnmap = new HashMap<String,Object>();
      returnmap.put("Result", Result); 
      returnmap.put("resultMsg", resultMsg); 
      
      logger.info("+ End " + className + ".savegroupcode");

      return returnmap;
   }      
   
   
   
   @RequestMapping("selectdetailcode.do")
   @ResponseBody
   public Map<String,Object> selectdetailcode(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".selectdetailcode");
      logger.info("   - paramMap : " + paramMap);
      
      ComnDtlCodModel detailcode = sampleComnCodService.selectdetailcode(paramMap);
      
      Map<String,Object> returnmap = new HashMap<String,Object>();
      returnmap.put("selectdetailcode", detailcode); 
      
      logger.info("+ End " + className + ".selectdetailcode");

      return returnmap;
   }   
      
   @RequestMapping("savedetailcode.do")
   @ResponseBody
   public Map<String,Object> savedetailcode(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".savedetailcode");
      logger.info("   - paramMap : " + paramMap);
      
      String loginId = (String) session.getAttribute("loginId");
      paramMap.put("loginId",loginId);
      
      String action = (String) paramMap.get("action");
      String Result = "N";
      String resultMsg = "데이터  저장 시 오류가 발생 했습니다.";         
         
      try {
         if("U".equals(action)) {
            sampleComnCodService.updatedetailcode(paramMap);
            resultMsg = "데이터  저장 되었습니다.";
         } else if("I".equals(action)) {
            sampleComnCodService.insertdetailcode(paramMap);
            resultMsg = "데이터  저장 되었습니다.";
         } else {
            sampleComnCodService.deletedetailcode(paramMap);
            resultMsg = "삭제 되었습니다.";
         }
         
         Result = "Y";
      } catch(Exception e) {
         
      }

      
      Map<String,Object> returnmap = new HashMap<String,Object>();
      returnmap.put("Result", Result); 
      returnmap.put("resultMsg", resultMsg); 
      
      logger.info("+ End " + className + ".savedetailcode");

      return returnmap;
   }      
      
}