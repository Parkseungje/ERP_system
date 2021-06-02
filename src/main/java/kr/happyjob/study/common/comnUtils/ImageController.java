package kr.happyjob.study.common.comnUtils;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/image/")
public class ImageController {
	// Root path for file upload 
	@Value("${fileUpload.rootPath}")
	private String rootPath;
	
	@Value("${copnm}")
	private String copnm;	
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	/**
	 * 이미지 보기
	 */
	@RequestMapping(value="/showImg.do")
	@ResponseBody
	public ResponseEntity <byte []> showImg(String fileName) throws Exception {
		
		logger.info("+ Start " + className + ".showImg");
		fileName = fileName.replaceAll("@", Matcher.quoteReplacement(File.separator));
		InputStream in = null;
        ResponseEntity<byte[]> entity = null;
        
        logger.info("FILE NAME : " + fileName);
        
        try {
            String formatName = fileName.substring(fileName.lastIndexOf("." ) + 1);
            MediaType mType = MediaUtils.getMediaType(formatName);
            
            HttpHeaders headers = new HttpHeaders();
            
            in = new FileInputStream(rootPath + fileName);
            
            if (mType != null) {
                headers.setContentType(mType);
            } else {
                fileName = fileName.substring(fileName.indexOf("_") + 1);
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.add("Content-Disposition", "attatchment; filename=\"" + 
                        new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
            }
            entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
            
        } catch(Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        } finally {
            in.close();
        }

		logger.info("+ End " + className + ".showImg");
		
        return entity;
	} 
	
	/**
	 * 이미지 사이즈 가져오기
	 */
	@RequestMapping(value="/selectImgSize.do")
	@ResponseBody
	public  Map<String, Object> selectImgSize(String fileName) throws Exception {
		logger.info("+ Start " + className + ".selectImgSize");
		String orgFileName = fileName.replaceAll("@", Matcher.quoteReplacement(File.separator));
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Image img = new ImageIcon(rootPath + orgFileName).getImage();
		
        resultMap.put("width", img.getWidth(null));
        resultMap.put("height", img.getHeight(null));
        resultMap.put("url", fileName);
		logger.info("+ End " + className + ".selectImgSize");
		return resultMap;
	}
}
