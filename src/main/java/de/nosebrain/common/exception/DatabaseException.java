package de.nosebrain.common.exception;

/**
 * an error in the database occurred
 * @author nosebrain
 */
public class DatabaseException extends RuntimeException {
	private static final long serialVersionUID = 4103325424680090074L;

	/**
	 * @see RuntimeException#RuntimeException(Throwable)
	 * @param cause the cause of the exception
	 */
	public DatabaseException(Throwable cause) {
		super(cause);
	}
}
