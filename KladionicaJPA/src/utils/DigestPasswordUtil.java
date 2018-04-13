package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class DigestPasswordUtil {

	public static final String MD5 = "MD5"; // Recommended
	public static final String SHA = "SHA";
	private static final String CHARSET_NAME = "iso-8859-1";

	private static String convertToHex(byte[] data) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			int halfbyte = (data[i] >>> 4) & 0x0F;
			int two_halfs = 0;
			do {
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = data[i] & 0x0F;
			} while (two_halfs++ < 1);
		}
		return buf.toString();
	}

	public static String hashPassword(String text, String algorithm)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md;
		md = MessageDigest.getInstance(algorithm);
		byte[] md5hash = new byte[32];
		md.update(text.getBytes(CHARSET_NAME), 0, text.length());
		md5hash = md.digest();
		return convertToHex(md5hash);
	}

}
