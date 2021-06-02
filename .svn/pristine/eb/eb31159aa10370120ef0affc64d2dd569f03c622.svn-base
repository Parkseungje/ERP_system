package kr.happyjob.study.common.comnUtils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComnUtil {
	/** key 값*/
	public static final String AES_KEY = "KOSMO";						/*암호화 key*/
	
	/**
	 * NULL 값을 제거한다. 입력값(text)이 NULL이이면 공백("")을 리턴한다.
	 * 
	 * @param text
	 *            NULL을 제거할 입력값
	 * @return NULL을 제거한 값
	 */
	public static String NVL(Object text) {
		if (text == null) {
			return "";
		} else {
			return NVL(text.toString(), "");

		}
	}

	/**
	 * NULL 값을 제거한다. 입력값(text)이 NULL이이면 공백("")을 리턴한다.
	 * 
	 * @param text
	 *            NULL을 제거할 입력값
	 * @return NULL을 제거한 값
	 */
	public static String NVL(String text) {
		return NVL(text, "");
	}

	/**
	 * NULL 값을 제거한다. 입력값(text)이 NULL이거나 공백("")이면 기본값(value)을 리턴한다.
	 * 
	 * @param text
	 *            NULL을 제거할 입력값
	 * @param value
	 *            기본값
	 * @return NULL을 제거한 값
	 */
	public static String NVL(Object text, String value) {
		if (text == null) {
			return value;
		} else {
			return NVL(text.toString(), value);
		}
	}

	/**
	 * NULL 값을 제거한다. 입력값(text)이 NULL이거나 공백("")이면 기본값(value)을 리턴한다.
	 * 
	 * @param text
	 *            NULL을 제거할 입력값
	 * @param value
	 *            기본값
	 * @return NULL을 제거한 값
	 */
	public static String NVL(String text, String value) {
		if (text == null) {
			return value;
		} else if (text.equals("")) {
			return value;
		} else {
			return text;
		}
	}

	/**
	 * NULL 값을 제거한다. 입력값(text)이 NULL이거나 공백(""), 혹은 int형으로 전환할수 없는 값이면
	 * 기본값(value)을 리턴한다.
	 * 
	 * @param text
	 *            NULL을 제거할 입력값
	 * @param value
	 *            기본값
	 * @return NULL을 제거하고 int형으로 변환된 값
	 */
	public static int NVL(Object text, int value) {
		if (text == null) {
			return value;
		} else {
			return NVL(text.toString(), value);
		}
	}
	
	public static String changeFileFormat(String size) {
	
		String retValue = "[-]";
		
		try {
			float fSize = Float.parseFloat(size);
			float sizeKB = fSize / 1024;
			
			if ((int)sizeKB > 1024) {
				retValue = String.format("%10.2f MB", (sizeKB/1024));
			} else {
				retValue = String.format("%10.2f KB", sizeKB);
			}
		} catch(Exception e) {}
		
		return retValue;
	}
	
	/**
	 * 가격에 콤마를 삽입한다.
	 * @param value
	 *            가격
	 * @return 변환된 값
	 */
	public static String comma(String value) {
		int target;
		try {
			target = Integer.parseInt(value);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			target = 0;
		}
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(target);
	}
	

	/**
	 * 숫자 타입 String을 integer로 변환한다.
	 * @param String
	 * @return int
	 * @throws Exception
	 */
	public static int strToIntegerWithException(String in) throws Exception {
		
		int out;
		try {
			out = Integer.parseInt(in);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			throw e;
		}
		
		return out;
	}
	
	/**
	 * 숫자 타입 String을 Double로 변환한다.
	 * 
	 * @param in
	 * @return
	 * @throws Exception
	 */
	public static double strToDoubleWithException(String in) throws Exception {
		
		double out;
		try {
			out = Double.parseDouble(in);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			throw e;
		}
		
		return out;
	}
	
	/**
	 * 현재 날짜를 반환 한다
	 * 
	 * @param format 날짜 포멧
	 * @return
	 */
	public static String getNowDate(String format) {
		
        Date d = new Date();
        
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(d);
	}
}
