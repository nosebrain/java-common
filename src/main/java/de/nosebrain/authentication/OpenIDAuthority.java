package de.nosebrain.authentication;

/**
 * 
 * @author nosebrain
 */
public class OpenIDAuthority implements Authority {
	private static final long serialVersionUID = -8548694743451044732L;
	
	
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
		return DefaultAuthMethod.OPEN_ID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((identity == null) ? 0 : identity.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof OpenIDAuthority)) {
			return false;
		}
		OpenIDAuthority other = (OpenIDAuthority) obj;
		if (identity == null) {
			if (other.identity != null) {
				return false;
			}
		} else if (!identity.equals(other.identity)) {
			return false;
		}
		return true;
	}
}
