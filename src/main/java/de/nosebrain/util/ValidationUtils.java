package de.nosebrain.util;

import java.util.Collection;

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
	public static boolean present(final CharSequence sequence) {
		return sequence != null && sequence.toString().trim().length() > 0;
	}

	/**
	 * @param collection the collection to check
	 * @return <code>true</code> iff collection is not null and is not empty
	 */
	public static boolean present(final Collection<?> collection) {
		return collection != null && !collection.isEmpty();
	}
}
