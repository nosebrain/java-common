package de.nosebrain.authentication;


/**
 * 
 * @author nosebrain
 */
public class PasswordAuthority implements Authority {
	private static final long serialVersionUID = 4019105460510224953L;


	private String password;

	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public AuthMethod getMethod() {
		return AuthMethod.PASSWORD;
	}
}
