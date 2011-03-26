package de.nosebrain.authentication;

/**
 * 
 * @author nosebrain
 *
 */
public class OpenIDAuthority implements Authority {

	private String identity;
	
	/**
	 * @return the identity
	 */
	public String getIdentity() {
		return identity;
	}

	/**
	 * @param identity the identity to set
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	@Override
	public AuthMethod getMethod() {
		return AuthMethod.OPEN_ID;
	}

}