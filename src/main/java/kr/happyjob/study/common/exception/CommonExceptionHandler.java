package kr.happyjob.study.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class CommonExceptionHandler {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	public static final String DEFAULT_ERROR_VIEW = "/common/error/error_403";
	
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object sampleTest(IllegalArgumentException ex, HttpServletRequest request) {

    	logger.info("+ Start CommonExceptionHandler.initComnCod");
    	String ext = request.getRequestURI();
    	
		if (ext.endsWith(".json")) {
			return new ResponseEntity<String>("errorMessage", HttpStatus.BAD_REQUEST);
		}

    	return new ModelAndView("errorViewName");
    }
}
