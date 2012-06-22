package de.nosebrain.testutil;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Ignore;

/**
 * class for common test methods
 * 
 * @author nosebrain
 */
@Ignore
public final class TestUtils {
	private TestUtils() {}

	/**
	 * @param url the url to convert
	 * @return the url
	 */
	public static URL parseURL(final String url) {
		try {
			return new URL(url);
		} catch (final MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
}
