package de.nosebrain.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author nosebrain
 *
 */
public abstract class StringUtils {
	
	/**
	 * md5 of the string
	 * @param str the string to hash
	 * @return md5(str)
	 */
	public static String md5(final String str) {
		try {
			final MessageDigest md = MessageDigest.getInstance("MD5");
			return toHexString(md.digest(str.getBytes("UTF-8")));
		} catch (final NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (final UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String normalizeString(final String str) {
		if (str != null) {
			return str.replaceAll("[^0-9\\p{L}]+", "").toLowerCase();
		}
		return "";
	}
	
	private static String toHexString(byte[] buffer) {
		final StringBuilder result = new StringBuilder();
		for (final byte b : buffer) {
			String hex = Integer.toHexString(b);
			if (hex.length() == 1) {
				hex = "0" + hex;
			}
			
			result.append(hex.substring(hex.length() - 2));
		}
		
		return result.toString();
	}
}
