package de.nosebrain.util;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author nosebrain
 */
public class Mailer {
	
	private Session session;
	
	private Properties properties;
	private String username;
	private String password;
	
	/**
	 * @return a new message
	 * @throws MessagingException if reload fails
	 */
	public MimeMessage createMessage() throws MessagingException {
		return new MimeMessage(this.session);
	}
	
	/**
	 * {@link #sendMessage(Message, Address...)}
	 * 
	 * @param message the message to send
	 * @param addresses the recipients (strings)
	 * @throws MessagingException #{@link Transport#sendMessage(Message, Address[])}
	 */
	public void sendMessage(final Message message, final String... addresses) throws MessagingException {
		final Address[] addressesA = new Address[addresses.length];
		for (int i = 0; i < addresses.length; i++) {
			final String address = addresses[i];
			addressesA[i] = new InternetAddress(address);
		}
		this.sendMessage(message, addressesA);
	}
	
	/**
	 * @param message the message to send
	 * @param addresses the recipients
	 * @throws MessagingException #{@link Transport#sendMessage(Message, Address[])}
	 */
	public void sendMessage(final Message message, final Address... addresses) throws MessagingException {
		message.addRecipients(RecipientType.TO, addresses);
		Transport.send(message);
	}
	
	/**
	 * inits the transport and session
	 * @throws MessagingException if transport
	 */
	public void init() throws MessagingException {
		if (this.password != null && this.username != null) {
			this.session = Session.getDefaultInstance(this.properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(Mailer.this.username, Mailer.this.password);
				}
			});
		} else {
			this.session = Session.getDefaultInstance(this.properties);
		}
	}
	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}