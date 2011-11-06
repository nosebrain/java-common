package de.nosebrain.util;

/**
 * 
 * @author nosebrain
 */
public final class ValidationUtils {
	private ValidationUtils() { }
	
	/**
	 * @param object the object to check
	 * @return <code>true</code> if object is not null
	 */
	public static boolean present(final Object object) {
		return object != null;
	}
	
	/**
	 * @param sequence the sequence to check
	 * @return <code>true</code> if seqenence is not null and has a length
	 */
	public static boolean present(CharSequence sequence) {
		return sequence != null && sequence.toString().trim().length() > 0;
	}
}
