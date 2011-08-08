package de.nosebrain.authentication;

import java.io.Serializable;

/**
 * @author nosebrain
 */
public interface Authority extends Serializable {
	
	/**
	 * 
	 * @return the method of the authority
	 */
	public AuthMethod getMethod();
}
