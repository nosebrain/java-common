package de.nosebrain.authentication;

/**
 * 
 * @author nosebrain
 *
 */
public enum AuthMethod {
	
	/**
	 * TODO
	 */
	USERNAME_PASSWORD(0),
	
	/**
	 * TODO
	 */
	OPEN_ID(1);
	
	private final int id;
	
	private AuthMethod(final int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	
}
