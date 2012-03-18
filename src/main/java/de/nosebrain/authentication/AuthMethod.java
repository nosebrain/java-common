package de.nosebrain.authentication;

/**
 * 
 * @author nosebrain
 */
public enum AuthMethod {

	/**
	 * using standard password
	 */
	PASSWORD(false),

	/**
	 * using an open id
	 */
	OPEN_ID(true),

	/**
	 * using an oauth 2 end point
	 */
	OAUTH_2(true);

	private final boolean multiple;

	private AuthMethod(final boolean multiple) {
		this.multiple = multiple;
	}

	/**
	 * @return the multiple
	 */
	public boolean isMultiple() {
		return this.multiple;
	}
}
