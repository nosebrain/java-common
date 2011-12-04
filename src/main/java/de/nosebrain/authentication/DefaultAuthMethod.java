package de.nosebrain.authentication;

/**
 * 
 * @author nosebrain
 */
public enum DefaultAuthMethod implements AuthMethod {

	/**
	 * using standard password
	 */
	PASSWORD(false),

	/**
	 * using an open id
	 */
	OPEN_ID(true);

	private final boolean multiple;

	private DefaultAuthMethod(final boolean multiple) {
		this.multiple = multiple;
	}

	/**
	 * @return the multiple
	 */
	@Override
	public boolean isMultiple() {
		return this.multiple;
	}
}
