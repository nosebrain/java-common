package de.nosebrain.util.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class UrlUtils {

  public static String decodeUrlString(final String urlString) {
    try {
      return URLDecoder.decode(urlString, "UTF-8");
    } catch (final UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }
}
