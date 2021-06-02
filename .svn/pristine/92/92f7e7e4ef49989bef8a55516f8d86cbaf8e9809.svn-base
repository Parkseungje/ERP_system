package kr.happyjob.study.common.comnUtils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public class FileUtil {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
		
	// MultipartHttpServletRequest
	private MultipartHttpServletRequest multipartHttpServletRequest;
	
	// root file path
	private String rootFilePath;
	
	// item file path
	private String itemFilePath;
	
	// make thumbnail option
	private boolean bThumbnail;
	
	// thumbnail 파일 width
	@Value("${image.resize.with}")
	private int thumWidth;
	
	// 이미지 파일 허용 확장자
	@Value("${image.allow.ext}")
	private String allowExt;
	
	private final String _THUMBNAIL_ = "_THUMBNAIL_";
	
	
	/**
	 *  생성자
	 * @param multipartHttpServletRequest
	 * @param rootFilePath
	 * @param itemFilePath
	 */
	public FileUtil() {

	}
	
			
	/**
	 *  생성자
	 * @param multipartHttpServletRequest
	 * @param rootFilePath
	 * @param itemFilePath
	 */
	public FileUtil(MultipartHttpServletRequest multipartHttpServletRequest, String rootFilePath, String itemFilePath) {
		this.multipartHttpServletRequest = multipartHttpServletRequest;
		this.rootFilePath = rootFilePath;
		this.itemFilePath = File.separator + itemFilePath;
		this.bThumbnail = false;
	}
	
	/**
	 * 생성자 - 썸네일 생성 옵션 추가
	 * @param multipartHttpServletRequest
	 * @param rootFilePath
	 * @param itemFilePath
	 * @param bThumbnail
	 */
	public FileUtil(MultipartHttpServletRequest multipartHttpServletRequest, String rootFilePath, String itemFilePath,
			boolean bThumbnail, int thumWidth, String allowExt) {
		this.multipartHttpServletRequest = multipartHttpServletRequest;
		this.rootFilePath = rootFilePath;
		this.itemFilePath = File.separator + itemFilePath;
		this.bThumbnail = bThumbnail;
		this.thumWidth = thumWidth;
		this.allowExt = allowExt;
	}
	
	
	/**
	 *  Set multipartHttpServletRequest
	 * @param multipartHttpServletRequest
	 */
	public void setMultipartHttpServletRequest(MultipartHttpServletRequest multipartHttpServletRequest) {
		this.multipartHttpServletRequest = multipartHttpServletRequest;
	}
	
	/**
	 *  Set rootFilePath
	 * @param rootFilePath
	 */
	public void setRootFilePath(String rootFilePath) {
		this.rootFilePath = rootFilePath;
	}

	/**
	 *  Set itemFilePath
	 * @param itemFilePath
	 */
	public void setItemFilePath(String itemFilePath) {
		this.itemFilePath = File.separator + itemFilePath;
	}
	
	/**
	 *  Set boolean Thumbnail
	 * @param bThumbnail
	 */
	public void setThumbnail(boolean bThumbnail) {
		this.bThumbnail = bThumbnail;
	}
	
	/**
	 *  Set Thumbnail width
	 * @param thumWidth
	 */
	public void setThumbnailWidth(int thumWidth) {
		this.thumWidth = thumWidth;
	}

	/**
	 *  Set allowExt
	 * @param allowExt
	 */
	public void setAllowExt(String allowExt) {
		this.allowExt = allowExt;
	}
	

	
	
	
	/** 
	 * 파일 업로드 
	 * @return 저장된 파일 메타 정보
	 */
	public List<FileUtilModel> uploadFiles() throws Exception {
		
		// Return value
		List<FileUtilModel> listFileUtilModel = new ArrayList<FileUtilModel>();
		
		// 디렉토리 생성
		makeDir();
        
        Iterator<String> files = multipartHttpServletRequest.getFileNames();
        
        while(files.hasNext()){
        	
            String uploadFile = files.next();

            MultipartFile multipartFile = multipartHttpServletRequest.getFile(uploadFile);
            String fileDvsCod = multipartFile.getName();

            if (!multipartFile.isEmpty()) {
            	
            	FileUtilModel fileUtilModel = new FileUtilModel();
            
            	String fileName = multipartFile.getOriginalFilename();
                String fileExtension = fileName.substring(fileName.lastIndexOf(".")+1);
                String tmpFileName = itemFilePath + fileName;
                String newFileName = tmpFileName;
                String thumbnailFileName = tmpFileName +"_thumbnail."+fileExtension;
                String fileSize = Long.toString(multipartFile.getSize());
                
                fileUtilModel.setLgc_fil_nm(fileName);
                fileUtilModel.setPsc_fil_nm(newFileName);
                fileUtilModel.setFil_ets(fileExtension);
                fileUtilModel.setFil_siz(fileSize);
                fileUtilModel.setFil_dvs_cod(fileDvsCod);
                
                listFileUtilModel.add(fileUtilModel);
                
                File orgFile = new File(rootFilePath+newFileName);
                multipartFile.transferTo(orgFile);
                
                // 썸네일 파일 생성
                if (bThumbnail) {
                	File thumbnailFile = new File(rootFilePath+thumbnailFileName);
                	
                	// 썸네일 파일 생성 성공일 경우 리턴값 생성
                	if (imageResize(orgFile, thumbnailFile)) {
                		fileUtilModel.setSml_psc_fil_nm(thumbnailFileName);
                		fileUtilModel.setSml_fil_size(Long.toString(thumbnailFile.length()));
                	}
                }
            }
        }
        
        return listFileUtilModel;
	}
	
	
	/** 
	 * 파일 업로드 
	 * @return 저장된 파일 메타 정보
	 */
	public List<FileUtilModel> uploadFilesWithThumbnail() throws Exception {
		
		int mb = 1024*1024;
		logger.info("Runtime.getRuntime().totalMemory()=" + (Runtime.getRuntime().totalMemory()/mb) + "MB" );
		logger.info("Runtime.getRuntime().maxMemory()=" + (Runtime.getRuntime().maxMemory()/mb) + "MB" );
		logger.info("Runtime.getRuntime().freeMemory(1)=" + (Runtime.getRuntime().freeMemory()/mb) + "MB" );
		
		// Return value
		List<FileUtilModel> listFileUtilModel = new ArrayList<FileUtilModel>();
		
		// 디렉토리 생성
		makeDir();
        
        Iterator<String> files = multipartHttpServletRequest.getFileNames();
        logger.info("Runtime.getRuntime().freeMemory(2)=" + (Runtime.getRuntime().freeMemory()/mb) + "MB" );
        
        while(files.hasNext()){
        	
            String uploadFile = files.next();
            
            logger.info("[FILE NAME="+uploadFile+"]==================================================");

            MultipartFile multipartFile = multipartHttpServletRequest.getFile(uploadFile);
            logger.info("Runtime.getRuntime().freeMemory(3)=" + (Runtime.getRuntime().freeMemory()/mb) + "MB" );
            String fileDvsCod = multipartFile.getName();
            
            if (!multipartFile.isEmpty()) {
            	
            	if (fileDvsCod.indexOf(_THUMBNAIL_) < 0) {
            		logger.info("Runtime.getRuntime().freeMemory(4)=" + (Runtime.getRuntime().freeMemory()/mb) + "MB" );
                	
            		FileUtilModel fileUtilModel = new FileUtilModel();
                    
                	String fileName = multipartFile.getOriginalFilename();
                    String fileExtension = fileName.substring(fileName.lastIndexOf(".")+1);
                    String tmpFileName = itemFilePath + System.currentTimeMillis() + "_" + UUID.randomUUID().toString();
                    String newFileName = tmpFileName +"."+fileExtension;
                    String thumbnailFileName = tmpFileName +"_thumbnail."+fileExtension;
                    String fileSize = Long.toString(multipartFile.getSize());
                    
                    logger.info("Runtime.getRuntime().freeMemory(5)=" + (Runtime.getRuntime().freeMemory()/mb) + "MB" );
                    if (uploadThumbnailFile(fileDvsCod, thumbnailFileName, fileUtilModel)) {
                    	
                    	fileUtilModel.setSml_psc_fil_nm(thumbnailFileName);
                    }
                    logger.info("Runtime.getRuntime().freeMemory(6)=" + (Runtime.getRuntime().freeMemory()/mb) + "MB" );
                    
                    fileUtilModel.setFil_dvs_cod(fileDvsCod);
                    fileUtilModel.setLgc_fil_nm(fileName);
                    // 서버 용량 부담으로 인하여 원본파일 서버에 저장하지 않음
                    //fileUtilModel.setPsc_fil_nm(newFileName);
                    //fileUtilModel.setFil_siz(fileSize);
                    fileUtilModel.setPsc_fil_nm(null);
                    fileUtilModel.setFil_siz("0");
                    fileUtilModel.setFil_ets(fileExtension);
                    
                    listFileUtilModel.add(fileUtilModel);

                    /* 서버 용량 부담으로 인하여 원본파일 서버에 저장하지 않음
                	File orgFile = new File(rootFilePath+newFileName);
                    logger.info("Runtime.getRuntime().freeMemory(7)=" + (Runtime.getRuntime().freeMemory()/mb) + "MB" );
                    multipartFile.transferTo(orgFile);
                    logger.info("Runtime.getRuntime().freeMemory(8)=" + (Runtime.getRuntime().freeMemory()/mb) + "MB" );
                    */
                }
            }
        }
        
        return listFileUtilModel;
	}
	
	/** 썸네일 파일 저장 */
	public boolean uploadThumbnailFile(String dvsCod, String fileName, FileUtilModel fileUtilModel) throws Exception {
		
		Iterator<String> files = multipartHttpServletRequest.getFileNames();
		dvsCod = _THUMBNAIL_+dvsCod;
		
        while(files.hasNext()){
        	
            String uploadFile = files.next();

            MultipartFile multipartFile = multipartHttpServletRequest.getFile(uploadFile);
            String fileDvsCod = multipartFile.getName();
            if (dvsCod.equals(fileDvsCod)) {
            	
            	File orgFile = new File(rootFilePath+fileName);
                multipartFile.transferTo(orgFile);
                
            	String fileSize = Long.toString(multipartFile.getSize());
            	
            	fileUtilModel.setSml_psc_fil_nm(fileName);
            	fileUtilModel.setSml_fil_size(fileSize);
            	
                return true;
            }
        }
        
        return false;
	}
	
	
	/** 
	 * 파일 업로드 - 썸네일 파일만 저장
	 * @return 저장된 파일 메타 정보
	 */
	public List<FileUtilModel> uploadFilesOnlyThumbnail() throws Exception {
		
		int mb = 1024*1024;
		logger.info("Runtime.getRuntime().totalMemory()=" + (Runtime.getRuntime().totalMemory()/mb) + "MB" );
		logger.info("Runtime.getRuntime().maxMemory()=" + (Runtime.getRuntime().maxMemory()/mb) + "MB" );
		logger.info("Runtime.getRuntime().freeMemory(1)=" + (Runtime.getRuntime().freeMemory()/mb) + "MB" );
		
		// Return value
		List<FileUtilModel> listFileUtilModel = new ArrayList<FileUtilModel>();
		
		// 디렉토리 생성
		makeDir();
        
        Iterator<String> files = multipartHttpServletRequest.getFileNames();
        logger.info("Runtime.getRuntime().freeMemory(2)=" + (Runtime.getRuntime().freeMemory()/mb) + "MB" );
        
        while(files.hasNext()){
        	
            String uploadFile = files.next();
            
            logger.info("[FILE NAME="+uploadFile+"]==================================================");

            MultipartFile multipartFile = multipartHttpServletRequest.getFile(uploadFile);
            logger.info("Runtime.getRuntime().freeMemory(3)=" + (Runtime.getRuntime().freeMemory()/mb) + "MB" );
            String fileDvsCod = multipartFile.getName();
            
            if (!multipartFile.isEmpty()) {
            	
            	if (fileDvsCod.indexOf(_THUMBNAIL_) >= 0) {
            		logger.info("Runtime.getRuntime().freeMemory(4)=" + (Runtime.getRuntime().freeMemory()/mb) + "MB" );
                	
            		FileUtilModel fileUtilModel = new FileUtilModel();
                    
                	String fileName = multipartFile.getOriginalFilename();
                    String fileExtension = fileName.substring(fileName.lastIndexOf(".")+1);
                    String tmpFileName = itemFilePath + System.currentTimeMillis() + "_" + UUID.randomUUID().toString();
                    String newFileName = tmpFileName +"."+fileExtension;
                    String thumbnailFileName = tmpFileName +"_thumbnail."+fileExtension;
                    String fileSize = Long.toString(multipartFile.getSize());
                                        
                    fileUtilModel.setFil_dvs_cod(fileDvsCod);
                    fileUtilModel.setLgc_fil_nm(fileName);
                    fileUtilModel.setPsc_fil_nm("");
                    fileUtilModel.setFil_siz("0");
                    fileUtilModel.setSml_psc_fil_nm(thumbnailFileName);
                	fileUtilModel.setSml_fil_size(fileSize);
                    listFileUtilModel.add(fileUtilModel);
                    
                	File orgFile = new File(rootFilePath+newFileName);
                    logger.info("Runtime.getRuntime().freeMemory(7)=" + (Runtime.getRuntime().freeMemory()/mb) + "MB" );
                    multipartFile.transferTo(orgFile);
                    logger.info("Runtime.getRuntime().freeMemory(8)=" + (Runtime.getRuntime().freeMemory()/mb) + "MB" );
                }
            }
        }
        
        return listFileUtilModel;
	}
	
	
	@SuppressWarnings("deprecation")
	public boolean imageResize(File srcFile, File destFile) throws Exception {
	
		Image srcImg = null;
        String suffix = srcFile.getName().substring(srcFile.getName().lastIndexOf('.')+1).toLowerCase();
        
        // 확장자 체크
        if (!imageExtCheck(suffix)) {
        	return false;
        }
        
        logger.info("Runtime.getRuntime().freeMemory(1)=["+Runtime.getRuntime().freeMemory()/(1024*1024)+"]");
        
        if (suffix.equals("bmp") || suffix.equals("png") || suffix.equals("gif")) {
            srcImg = ImageIO.read(srcFile);
        } else {
            // BMP가 아닌 경우 ImageIcon을 활용해서 Image 생성
            // 이렇게 하는 이유는 getScaledInstance를 통해 구한 이미지를
            // PixelGrabber.grabPixels로 리사이즈 할때
            // 빠르게 처리하기 위함이다.
            srcImg = new ImageIcon(srcFile.toURL()).getImage();
        }
        logger.info("Runtime.getRuntime().freeMemory(2)=["+Runtime.getRuntime().freeMemory()/(1024*1024)+"]");
        
        int srcWidth = srcImg.getWidth(null);
        int srcHeight = srcImg.getHeight(null);
        int destWidth = 0;
        int destHeight = 0;
        
        if (srcWidth < thumWidth) {
        	destWidth = srcWidth;
        	destHeight = srcHeight;
        } else {
        	
        	destWidth = thumWidth;
        	double ratio = ((double)destWidth) / ((double)srcWidth);
        	destHeight = (int)((double)srcHeight * ratio);
        }
        
        Image imgTarget = srcImg.getScaledInstance(destWidth, destHeight, Image.SCALE_SMOOTH); 
        int pixels[] = new int[destWidth * destHeight]; 
        PixelGrabber pg = new PixelGrabber(imgTarget, 0, 0, destWidth, destHeight, pixels, 0, destWidth);
        logger.info("Runtime.getRuntime().freeMemory(3)=["+Runtime.getRuntime().freeMemory()/(1024*1024)+"]");
        try {
            pg.grabPixels();
        } catch (InterruptedException e) {
            throw e;
        } 
        logger.info("Runtime.getRuntime().freeMemory(4)=["+Runtime.getRuntime().freeMemory()/(1024*1024)+"]");
        BufferedImage destImg = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB); 
        destImg.setRGB(0, 0, destWidth, destHeight, pixels, 0, destWidth); 
        logger.info("Runtime.getRuntime().freeMemory(5)=["+Runtime.getRuntime().freeMemory()/(1024*1024)+"]");
        return ImageIO.write(destImg, "jpg", destFile);
	}

	
	/**
	 * 원본파일 복사 생성
	 */
/*	public List<FileUtilModel> copyFiles(List<WrqPtetPotoModel> listWrqPtetPotoModel ) throws Exception {
	
		List<FileUtilModel> listFileUtilModel = new ArrayList<FileUtilModel>();
		
		// 디렉토리 생성
		makeDir();
		        
        for (WrqPtetPotoModel wrqPtetPotoModel : listWrqPtetPotoModel) {
        	
        	FileUtilModel fileUtilModel = new FileUtilModel();
        	
        	
        	String orgFilNm = wrqPtetPotoModel.getOrg_poto_lgc_fil_nm();
        	if (orgFilNm != null && !"".equals(orgFilNm)) {
        		
        		String filEts = wrqPtetPotoModel.getFil_ets(); 
        		String newPscFilNm = getPscFilNm();
        		String pscFilNm = newPscFilNm + "." + filEts;
        		String pscTnlFilNm = newPscFilNm + "_thumbnail." + filEts;
        		
        		// 정보 설정
        		fileUtilModel.setFil_dvs_cod(wrqPtetPotoModel.getPoto_dvs_cod());
        		fileUtilModel.setLgc_fil_nm(wrqPtetPotoModel.getOrg_poto_lgc_fil_nm());
        		fileUtilModel.setPsc_fil_nm(pscFilNm);
        		fileUtilModel.setFil_siz(wrqPtetPotoModel.getOrg_poto_siz());
        		fileUtilModel.setFil_ets(filEts);
        		fileUtilModel.setSml_psc_fil_nm(pscTnlFilNm);
        		fileUtilModel.setSml_fil_size(wrqPtetPotoModel.getTnl_poto_siz());

        		listFileUtilModel.add(fileUtilModel);
        		
        		// 원본 파일 복사
        		//copyFile(wrqPtetPotoModel.getOrg_poto_psc_fil_nm(), pscFilNm);
        		
        		// 썸네일 파일 복사
        		copyFile(wrqPtetPotoModel.getTnl_poto_psc_fil_nm(), pscTnlFilNm);
        	}
        }
        
		return listFileUtilModel;
	}*/
	
	
	/**
	 * 파일 copy
	 * @param orgFilNm - 원본 파일
	 * @param newFilNm - 신규 파일
	 * @throws Exception
	 */
	public void copyFile(String orgFilNm, String newFilNm) throws Exception {

		FileInputStream is = null;
		FileOutputStream os = null;
		FileChannel isFc=  null;
		FileChannel osFc = null;
		
		try {
			
			is = new FileInputStream(rootFilePath + orgFilNm);        
			os = new FileOutputStream(rootFilePath + newFilNm);
			isFc =  is.getChannel();
			osFc = os.getChannel();
			
			long size = isFc.size();
			isFc.transferTo(0, size, osFc);
			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {		
			try {isFc.close();} catch(IOException e) {e.printStackTrace();} finally {isFc=null;}
			try {osFc.close();} catch(IOException e) {e.printStackTrace();} finally {osFc=null;}
			try {is.close();} catch(IOException e) {e.printStackTrace();} finally {is=null;}
			try {os.close();} catch(IOException e) {e.printStackTrace();} finally {os=null;}
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
	 * 이미지 파일 확장자 허용 체크
	 * @param ext
	 * @return
	 */
	public boolean imageExtCheck(String ext) {
		
		StringTokenizer st = new StringTokenizer(allowExt, ",");
		
		ext = ext.toLowerCase();
		while (st.hasMoreTokens()) {
			
			String t = st.nextToken().toLowerCase();
			if (t.equals(ext)) 	return true;
		}
		
		return false;
	}
	

	/**
	 * 파일 삭제
	 * @param listFileUtilModel
	 * @param uploadFilePath
	 * @throws Exception
	 */
	public void deleteFiles(List<FileUtilModel> listFileUtilModel, String rootFilePath) throws Exception {
		
		this.rootFilePath = rootFilePath;
		deleteFiles(listFileUtilModel);
	}
	

	/**
	 * 파일 삭제
	 * @param listFileUtilModel
	 * @throws Exception
	 */
	public void deleteFiles(List<FileUtilModel> listFileUtilModel) throws Exception {
		
		if (listFileUtilModel != null) {
			for(FileUtilModel fileUtilModel : listFileUtilModel) {
				
				// 원본 파일 삭제
				String pscFilNm = fileUtilModel.getPsc_fil_nm();
				if (pscFilNm != null && !"".equals(pscFilNm)) {
					File file = new File(rootFilePath + pscFilNm);
					if (file.exists()) file.delete();
				}
				
				// 썸네일 파일 삭제
				String smlPscFilNm = fileUtilModel.getSml_psc_fil_nm();
				if (smlPscFilNm != null && !"".equals(smlPscFilNm)) {
					File file = new File(rootFilePath + smlPscFilNm);
					if (file.exists()) file.delete();
				}
			}
		}
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
