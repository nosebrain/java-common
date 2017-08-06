package de.nosebrain.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author nosebrain
 */
public final class IOUtils {
  private IOUtils() {}

  /**
   * loads a url into a string
   * @param url
   * @return
   * @throws IOException
   */
  public static String readUrl(URL url) throws IOException {
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new InputStreamReader(url.openStream()));
      StringBuffer buffer = new StringBuffer();
      int read;
      char[] chars = new char[1024];
      while ((read = reader.read(chars)) != -1) {
        buffer.append(chars, 0, read);
      }
      return buffer.toString();
    } finally {
      if (reader != null)
        reader.close();
    }
  }
}
