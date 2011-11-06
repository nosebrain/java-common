package de.nosebrain.spring.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * 
 * @author nosebrain
 * @see org.bibsonomy.webapp.util.spring.security.authentication.SessionAuthenticationToken
 */
public class SessionAuthenticationToken extends AbstractAuthenticationToken {
	private static final long serialVersionUID = 1434519528252232694L;
	
	private final Object principal;
	
	/**
	 * builds a session authentication token
	 * 
	 * @param principal the principal
	 * @param authorities the authorities
	 */
	public SessionAuthenticationToken(final Object principal, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
		setAuthenticated(true);
	}

	@Override
	public Object getCredentials() {
		return "";
	}

	@Override
	public Object getPrincipal() {
		return this.principal;
	}

}
