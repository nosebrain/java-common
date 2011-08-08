package de.nosebrain.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * @author nosebrain
 */
public class StringUtilsTest {
	
	@Test
	public void normalizeString() {
		for (String toNormalize : new String[] { "TeST", "T.E:S%&/(T", "T€e@St", "test", "t e s t "}) {
			assertEquals("test", StringUtils.normalizeString(toNormalize));
		}
	}
	
	@Test
	public void md5() {
		assertEquals("41da76f0fc3ec62a6939e634bfb6a342", StringUtils.md5("testuser1"));
		assertEquals("3a66da249c2280a223b9eaa9e2dd7d2d", StringUtils.md5("this is ö test"));
		assertEquals("1586cffafa39e38959477da9eaa41c31", StringUtils.md5("THIS IS A TEST"));
	}
}
