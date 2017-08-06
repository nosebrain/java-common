package de.nosebrain.util;

import de.nosebrain.testutil.TestUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class URLUtilsTest {

  @Test
  public void testNormUrl() {
    assertEquals("http://nosebrain.de", URLUtils.normLink(TestUtils.parseURL("https://nosebrain.de"), "http://nosebrain.de"));
    assertEquals("https://nosebrain.de", URLUtils.normLink(TestUtils.parseURL("https://nosebrain.de"), "//nosebrain.de"));
  }
}