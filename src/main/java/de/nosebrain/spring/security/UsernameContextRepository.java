package de.nosebrain.spring.security;

import static de.nosebrain.util.ValidationUtils.present;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;

/**
 * stores the {@link SecurityContext} by only saving the username in the session
 * 
 * @author nosebrain
 */
public class UsernameContextRepository implements SecurityContextRepository {
	private static final String ATTRIBUTE_LOGIN_USER_NAME = "LOGIN_USER_NAME";
	
	/**
	 * Delivers details for each given user.
	 */
	private UserDetailsService service;
	private final AuthenticationTrustResolver authenticationTrustResolver = new AuthenticationTrustResolverImpl();

	/**
	 * Checks for a user name in the session. If one is found, the corresponding
	 * user details are extracted and the user is stored as request attribute.
	 * 
	 * @see org.springframework.security.web.context.SecurityContextRepository#loadContext(org.springframework.security.web.context.HttpRequestResponseHolder)
	 */
	@Override
	public SecurityContext loadContext(final HttpRequestResponseHolder requestResponseHolder) {
		final HttpServletRequest request = requestResponseHolder.getRequest();
		final SecurityContextImpl securityContext = new SecurityContextImpl();
		
		final String username = getLoginUser(request);
		if (present(username)) {
			/*
			 * user name found in session -> get the corresponding user
			 */
			final UserDetails user = this.service.loadUserByUsername(username);
			final Authentication authentication = new SessionAuthenticationToken(user, user.getAuthorities());
			securityContext.setAuthentication(authentication);
		}
		
		return securityContext;
	}
	
	
	/**
	 * Stores the user name in the session.
	 * 
	 * @see org.springframework.security.web.context.SecurityContextRepository#saveContext(org.springframework.security.core.context.SecurityContext, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void saveContext(final SecurityContext context, final HttpServletRequest request, final HttpServletResponse response) {
		this.setLoginUser(request, context.getAuthentication());
	}

	/**
	 * The name of the logged in user is stored in the session. This method 
	 * extracts the name from the session.
	 * 
	 * @param request
	 * @return
	 */
	private static String getLoginUser(final HttpServletRequest request) {
		final HttpSession session = request.getSession();
		if (session == null) {
			return null;
		}
		
		return (String) session.getAttribute(ATTRIBUTE_LOGIN_USER_NAME);
	}
	
	private void setLoginUser(final HttpServletRequest request, final Authentication authentication) {
		if (this.authenticationTrustResolver.isAnonymous(authentication)) {
            return;
        }
		
		/*
		 * If an authentication is present, we store the user name in the 
		 * session. Note that we /always/ store it - also when it already 
		 * contained in the session (i.e., we don't check for 
		 * !this.containsContext(request)). Thus, the session should time out
		 * after XX minutes of /inactivity/.
		 */
		if (present(authentication)) {
			final UserDetails user = (UserDetails) authentication.getPrincipal();
			final String loginUsername = user.getUsername();
			final HttpSession session = request.getSession(true);
			session.setAttribute(ATTRIBUTE_LOGIN_USER_NAME, loginUsername);
		}
	}
	
	@Override
	public boolean containsContext(HttpServletRequest request) {
		return getLoginUser(request) != null;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(final UserDetailsService service) {
		this.service = service;
	}
}
