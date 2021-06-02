package kr.happyjob.study.common.uuid;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderCodeGenerator {

	public String uuidGenerator() {

		// 날짜
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
		Date time = new Date();
		String day = date.format(time);

		// 임의 번호 생성
		long number = System.nanoTime(); //

		
		// 번호 생성 
		final char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
				'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B',
				'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z', '#', '$' };

		int shift = 6;
		char[] buf = new char[64];

		int charPos = 64;
		int radix = 1 << shift;
		long mask = radix - 1;
		do {
			buf[--charPos] = digits[(int) (number & mask)];
			number >>>= shift;
		} while (number != 0);
		
		

		//nanoTime 변환값  결과 
		String uuid = new String(buf, charPos, (64 - charPos));

		// 최종 코드 생성
		String orderCode = "e" + day + uuid;

		return orderCode;
	}

}
