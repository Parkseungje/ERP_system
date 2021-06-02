package kr.happyjob.study.common.comnUtils;



import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;



public class FileUtilCho {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
		
	// MultipartHttpServletRequest
	private MultipartHttpServletRequest multipartHttpServletRequest;
	
	// root file path
	private String rootFilePath;
	
	// item file path
	private String itemFilePath;
	


	
	// 이미지 파일 허용 확장자
	@Value("${image.allow.ext}")
	private String allowExt;


	public FileUtilCho() {

	}

	public FileUtilCho(MultipartHttpServletRequest multipartHttpServletRequest, String rootFilePath, String itemFilePath) {
		this.multipartHttpServletRequest = multipartHttpServletRequest;
		this.rootFilePath = rootFilePath;
		this.itemFilePath = File.separator + itemFilePath;
	}

	
	public void setMultipartHttpServletRequest(MultipartHttpServletRequest multipartHttpServletRequest) {
		this.multipartHttpServletRequest = multipartHttpServletRequest;
	}

	public void setRootFilePath(String rootFilePath) {
		this.rootFilePath = rootFilePath;
	}

	public void setItemFilePath(String itemFilePath) {
		this.itemFilePath = File.separator + itemFilePath;
	}


	public void setAllowExt(String allowExt) {
		this.allowExt = allowExt;
	}
	

	public Map<String,Object> uploadFiles() throws Exception {
			
		// 디렉토리 생성
		makeDir();
        
        Iterator<String> files = multipartHttpServletRequest.getFileNames();

    	Map<String,Object> map = new HashMap<String, Object>();
    	
        while(files.hasNext()){
        	
            String uploadFile = files.next();

            MultipartFile multipartFile = multipartHttpServletRequest.getFile(uploadFile);
          //  String fileDvsCod = multipartFile.getName();

            if (!multipartFile.isEmpty()) {
            	
            
            	String file_nm = multipartFile.getOriginalFilename();
                String fileExtension = file_nm.substring(file_nm.lastIndexOf(".")+1);
                String file_loc = rootFilePath+itemFilePath + file_nm;
               
               /* String thumbnailFileName = tmpFileName +"_thumbnail."+fileExtension;*/
                String file_Size = Long.toString(multipartFile.getSize());
                
                
                map.put("file_nm", file_nm);
                map.put("file_size", file_Size);
                map.put("file_loc", file_loc);
                map.put("fileExtension", fileExtension);
               
                logger.info("file 정보 : " + map);
                
                File orgFile = new File(file_loc);
                multipartFile.transferTo(orgFile);
                
              
            }
        }
        
        return map;
	}
	
	public void deleteFiles(Map<String,Object> map) throws Exception {
		
		if (map != null) {
			
				
				// 원본 파일 삭제Map
				String pscFilNm = (String)map.get("file_nm");
				if (pscFilNm != null && !"".equals(pscFilNm)) {
					File file = new File(rootFilePath + pscFilNm);
					if (file.exists()) file.delete();
				}
				
				
			
		}
	}
	
	
	/** 
	 * 파일 물리 파일 명 생성
	 * 
	 * */
	public String getPscFilNm () {
		
		String filPthNm = itemFilePath + System.currentTimeMillis() + "_" + UUID.randomUUID().toString();
		return filPthNm;
	}
	
	


	
	/**
	 * 디렉토리 생성
	 */
	private void makeDir() {
		
        // 디렉토리 파일 객체 생성
		String uploadFilePath = rootFilePath + itemFilePath;
        File file = new File(uploadFilePath);

        // 경로 생성
        if(!file.isDirectory()){
        	file.mkdirs();
        }
	}
}
