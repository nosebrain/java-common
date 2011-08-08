package de.nosebrain.authentication;


/**
 * 
 * @author nosebrain
 *
 */
public class UsernamePasswordAuthority implements Authority {
	private static final long serialVersionUID = 4019105460510224953L;
	
	
	private String password;

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public AuthMethod getMethod() {
		return AuthMethod.USERNAME_PASSWORD;
	}
}
