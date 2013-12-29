package de.nosebrain.spring.security.provisioning;

import java.util.Collection;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.memory.UserAttribute;
import org.springframework.security.core.userdetails.memory.UserAttributeEditor;

/**
 * an {@link InMemoryUserDetailsManager} that only uses properties
 * starting with a prefix for creating users
 * 
 * @author nosebrain
 */
public class InMemoryUserDetailsManager extends org.springframework.security.provisioning.InMemoryUserDetailsManager {
	
	private static Collection<UserDetails> extractUser(Properties properties, String prefix) {
		final List<UserDetails> users = new LinkedList<UserDetails>();
		final Enumeration<?> names = properties.propertyNames();
		final UserAttributeEditor editor = new UserAttributeEditor();

		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			if (name.startsWith(prefix)) {
				editor.setAsText(properties.getProperty(name));
				final UserAttribute attr = (UserAttribute) editor.getValue();
				// rename the name after the editor extracted the attributes
				name = name.replaceFirst(prefix, "");
				final UserDetails user = new User(name, attr.getPassword(), attr.isEnabled(), true, true, true, attr.getAuthorities());
				
				users.add(user);
			}
		}
		
		return users;
	}
	
	public InMemoryUserDetailsManager(final Properties properties, final String prefix) {
		super(extractUser(properties, prefix));
	}

}
