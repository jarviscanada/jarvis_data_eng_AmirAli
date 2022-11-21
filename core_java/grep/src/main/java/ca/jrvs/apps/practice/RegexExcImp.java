package ca.jrvs.apps.practice;

import java.util.regex.*;

public class RegexExcImp implements RegexExc{

  /**
   *return true if filename extension is jpg or jpeg (case-insensitive)
   * @param filename
   * @return
   */
  @Override
  public boolean matchJpeg(String filename) {
    String jpg = "jpg";
    String jpeg = "jpeg";
    boolean isMatched = Pattern.matches("(?i)(\\.jpg|\\.jpeg)", filename);
    return isMatched;
  }

  /**
   * return true if ip is valid
   * to simplify the problem IP address range is from 0.0.0.0 to 999.999.999.999
   * @param ip
   * @return
   */
  @Override
  public boolean matchIp(String ip) {
    boolean isMatched = Pattern.matches("^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$", ip);
    return isMatched;
  }

  /**
   * return true if lineis empty (e.g. empty, white space, tabs, etc..)
   * @param line
   * @return
   */
  @Override
  public boolean isEmptyLine(String line) {
    return false;
  }
}
