package de.nosebrain.util.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlUtils {

  public static String decodeUrlString(final String urlString) {
    try {
      return URLDecoder.decode(urlString, "UTF-8");
    } catch (final UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }

  public static String encodeUrlString(final String urlString) {
    try {
      return URLEncoder.encode(urlString, "UTF-8");
    } catch (final UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }
}
