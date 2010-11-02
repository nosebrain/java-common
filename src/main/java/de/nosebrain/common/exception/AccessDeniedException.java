package de.nosebrain.common.exception;

/**
 * the user hasn't the privilege to access the method
 * @author nosebrain
 */
public class AccessDeniedException extends RuntimeException {
	
	private static final long serialVersionUID = 1873982206352914294L;

	/**
	 * @see RuntimeException#RuntimeException()
	 */
	public AccessDeniedException() {
		// noop
	}
	
	/**
	 * @see RuntimeException#RuntimeException(String)
	 */
	public AccessDeniedException(final String message) {
		super(message);
	}
}
