package kr.happyjob.study.common.comnUtils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.RijndaelEngine;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.paddings.ZeroBytePadding;
import org.bouncycastle.crypto.params.KeyParameter;


/**
 * <p>AES 알고리즘을 이용한 암호화, 복호화 기능을 제공한다.</p>
 * <p>여기 구현은 <a href="http://www.bouncycastle.org/java.html" target="_blank">BouncyCastle (http://www.bouncycastle.org/java.html)</a>
 * 에서 제공하는 Library를 이용했다.
 * 이는 이 클래스가 대체하기 위한 Visual Basic으로 구현된 알고리즘이
 * 256비트 Key를 이용한 256비트 블록크기의 암호화를 구현하였는데
 * 자바에서 기본으로 제공하는 AES 알고리즘은 128bit 블록단위만 지원하기
 * (혹은 방법을 못 찾았을 수도) 때문이다.
 * <strong>BouncyCastle</strong> 에서 제공하는 Library는 이를 지원한다.</p>
 * 
 * 주의할 점은 여기 구현은 대체 대상이 되는 Visual Basic 모듈에서
 * 암호화 대상 문자열을 byte로 치환하였을 때 16 byte 까지만 실제로
 * 암호화 된다는 것이다.
 * 이는 rijndaeltset.asp 에서 암호화를 호출하기 전 암호화 대상 문자열을
 * byte 배열로 만든 다음 16 byte 배열의 다른 변수에 복사한 후 이
 * byte 배열을 실제 암호화를 호출할 때 사용하기 때문이다. 이때,
 * 원 문자열을 byte 배열로 변환한 것이 16 byte 보다 적으면 나머지는 0으로
 * 채워지며, 길면 17 byte 부터는 버려지도록하는 코드가 들어가 있기 때문이다.
 * 이 부분은 원 저작자의 해당 사이트에서 내려 받은 파일과 비교해 본 결과
 * 추가된 것인데, 왜 이렇게 수정한 것인지는 현재로는 알 수 없다.
 */
public class AESCryptoHelper {
	/** 인코딩값. 한글 처리를 위해 중요하다. */
	private final static String ENCODING = "KSC5601";
	
	/**
	 * 주어진 문자열의 바이트 배열을 이용해 256 비트(32 바이트) 키 byte 배열을 생성한다.
	 * 
	 * @param password Key를 만드는데 사용할 비밀번호.
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static byte [] make256BitKey(String password)
	throws UnsupportedEncodingException {
		byte [] pwBytes = password.getBytes(ENCODING);

		byte [] key = new byte[32];
		System.arraycopy(pwBytes, 0, key, 0, pwBytes.length);

		return key;
	}
	
	
	/**
	 * 주어진 암호화 대상 문자열을 암호화 시키기 위한 바이트 배열로 만든다.
	 * 이때, 앞에 4바이트에는 암호화할 문자열의 바이트 배열 수를 넣고, 그 뒤에
	 * 암호화 대상 문자열의 바이트화하여 추가하게 되는데, 항상 16 바이트 배열을
	 * 만들기 때문에(적으면 나머지는 0으로 채우고, 많으면 자른다) 첫번째 바이트에만
	 * 16이 들어가고 나머지는 0이 들어간다.
	 * 
	 * @param message 암호화할 문자열.
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static byte [] makeMessageByteArray(String message)
	throws UnsupportedEncodingException {
		byte [] sr = message.getBytes(ENCODING);

		byte [] ba = new byte[16];
		Arrays.fill(ba, (byte) 0);
		ba[0] = 16;
		System.arraycopy(sr, 0, ba, 4, Math.min(sr.length, ba.length - 4));
		
		return ba;
	}
	
	
	/**
	 * 주어진 메세지를 암호화한 byte 배열값을 Hex값으로 변환한 String을 돌려준다.
	 *
	 * @param password 암호화시 사용할 비밀번호.
	 * @param message  암호화할 문자열.
	 * @return 암호화 byte 배열을 Hex값으로 변환한 문자열.
	 */
	public static String encode(String password, String message) {
		byte[] encrypted = null;

		try {
			byte [] key         = make256BitKey(password);
			byte [] messageByte = makeMessageByteArray(message);

			BlockCipher cipher = new RijndaelEngine(256);
			PaddedBufferedBlockCipher paddedBlockCipher = new PaddedBufferedBlockCipher(cipher, new ZeroBytePadding());
			
			KeyParameter keyParam = new KeyParameter(key);
			
			paddedBlockCipher.init(true, keyParam);

			encrypted = new byte[paddedBlockCipher.getOutputSize(messageByte.length)];
			int bytesWrittenOut = paddedBlockCipher.processBytes(messageByte, 0, messageByte.length, encrypted, 0);

			paddedBlockCipher.doFinal(encrypted, bytesWrittenOut);
		}
		catch (DataLengthException e) {
			throw new IllegalArgumentException(e);
		}
		catch (InvalidCipherTextException e) {
			throw new IllegalArgumentException(e);
		}
		catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException(e);
		}


		return toHexString(encrypted).toUpperCase();
	}

	

	/**
	 * 주어진 Hex값 문자열로 된 암호 문자열을 평문화하여 돌려 준다.
	 *
	 * @param password 이 문자열을 암호화하는데 사용된 비밀번호.
	 * @param encodedHexString 암호화된 Hex값 문자열을 평문화한 String.
	 * @return
	 */
	public static String decode(String password, String encodedHexString) {
		if ( encodedHexString == null ) return null;
		
		if ( encodedHexString.trim().equals("") ) return "";


		String plaingText = "";

		try {
			byte [] key       = make256BitKey(password);
			byte [] encrypted = toBytesFromHexString(encodedHexString.toLowerCase());

			BlockCipher cipher = new RijndaelEngine(256);
			PaddedBufferedBlockCipher paddedBlockCipher = new PaddedBufferedBlockCipher(cipher, new ZeroBytePadding());
			
			KeyParameter keyParam = new KeyParameter(key);
			
			paddedBlockCipher.init(false, keyParam);
			
			/* 앞 4바이트는 길이를 넣은 것이므로 뺀다. */

			byte[] decrypted = new byte[paddedBlockCipher.getOutputSize(encrypted.length)];
			int bytesWrittenOut = paddedBlockCipher.processBytes(encrypted, 0, encrypted.length, decrypted, 0);

			paddedBlockCipher.doFinal(decrypted, bytesWrittenOut);

			byte [] messageOnlyByte = new byte[decrypted.length - 4];
			System.arraycopy(decrypted, 4, messageOnlyByte, 0, messageOnlyByte.length);
			
			
			/* 뒤쪽의 연속된 0값을 지운다. */
			byte [] trimedByte = trimRightByte(messageOnlyByte);
			
			
			
			plaingText = new String(trimedByte, ENCODING);
		}
		catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException(e);
		}
		catch (DataLengthException e) {
			throw new IllegalArgumentException(e);
		}
		catch (InvalidCipherTextException e) {
			throw new IllegalArgumentException(e);
		}

		return plaingText;
	}


	/**
	 * 뒷 부분의 일련의 0 값인 byte 들을 제거한 byte 배열을 돌려 준다.
	 * 
	 * @param messageOnlyByte
	 * @return
	 */
	private static byte[] trimRightByte(byte[] messageOnlyByte) {
		byte [] trimmed = EMPTY_BYTE_ARR;
		
		
		for (int i = messageOnlyByte.length - 1; i >= 0; i--) {
			if ( messageOnlyByte[i] != 0 ) {
				trimmed = new byte[i + 1];
				System.arraycopy(messageOnlyByte, 0, trimmed, 0, i + 1);
				break;
			}
		}
		
		return trimmed;
	}


	/** 길이가 0인 byte 배열. */
	private final static byte [] EMPTY_BYTE_ARR = new byte[0];

	/**
	 * 주어진 Hex값 문자열로 부터 byte 배열을 만들어 돌려 준다.
	 *
	 * @param hexString byte 배열을 만들 Hex값 문자열.
	 * @return
	 */
	private static byte[] toBytesFromHexString(String hexString) {
		if (hexString == null) {
			return EMPTY_BYTE_ARR;
		}

		int length = hexString.length();
		if (length % 2 == 1) {
			throw new IllegalArgumentException("길이가 짝수가 아닙니다: \"" + hexString + "\"");
		}

		length = length / 2;
		byte[] bytes = new byte[length];
		for (int i = 0; i < length; i++) {
			int index = i * 2;
			bytes[i] = (byte) (Short.parseShort(hexString.substring(index, index + 2), 16));
		}

		return bytes;
	}


	/**
	 * byte 배열을 Hex값 문자열로 변환하여 돌려준다.
	 *
	 * @param bytes 변환할 byte 배열.
	 * @return 각 byte 값을 Hex값 문자열로 변환한 String.
	 */
	public static String toHexString(byte [] bytes) {
		if ( bytes == null || bytes.length == 0 ) return "";

		StringBuffer buff = new StringBuffer(bytes.length * 2);

		for (int i = 0; i < bytes.length; i++) {
			if (((int) bytes[i] & 0xff) < 0x10) {
				buff.append("0");
			}

			buff.append(Long.toString((int) bytes[i] & 0xff, 16));
		}

		return buff.toString();
	}
}
