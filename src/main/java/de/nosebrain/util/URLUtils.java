package de.nosebrain.util;

import java.net.URL;

/**
 * @author nosebrain
 */
public final class URLUtils {
  private URLUtils() {}

  /**
   * norms links without protocol
   * @param source
   * @param link
   * @return
   */
  public static String normLink(URL source, String link) {
    if (link.startsWith("//")) {
      return source.getProtocol() + ":" + link;
    }

    return link;
  }
}
