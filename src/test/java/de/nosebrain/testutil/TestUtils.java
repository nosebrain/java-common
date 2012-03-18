package de.nosebrain.testutil;

import java.net.MalformedURLException;
import java.net.URL;

public final class TestUtils {
	private TestUtils() {}

	public static URL parseURL(final String url) {
		try {
			return new URL(url);
		} catch (final MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
}
