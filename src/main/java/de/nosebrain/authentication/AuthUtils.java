package de.nosebrain.authentication;

import static de.nosebrain.util.ValidationUtils.present;

import java.util.List;

/**
 * 
 * @author nosebrain
 */
public final class AuthUtils {
	private AuthUtils() {}

	/**
	 * @param authorities
	 * @return returns the password of the first {@link PasswordAuthority} <code>null</code> iff
	 * list is empty or
	 */
	public static String getPassword(final List<Authority> authorities) {
		if (!present(authorities)) {
			return null;
		}

		for (final Authority authority : authorities) {
			if (authority instanceof PasswordAuthority) {
				final PasswordAuthority passwordAuthority = (PasswordAuthority) authority;
				return passwordAuthority.getPassword();
			}
		}

		return null;
	}

	/**
	 * @param authorities
	 * @param authorityClass
	 * @return <code>true</code> iff one authority of this type is present
	 */
	public static boolean containsAuthority(final List<Authority> authorities, final Class<? extends Authority> authorityClass) {
		for (final Authority authority : authorities) {
			if (authority.getClass().equals(authorityClass)) {
				return true;
			}
		}

		return false;
	}
}
