package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JavaGrepImp implements JavaGrep {


  @Override
  public void process() throws IOException {

  }

  @Override
  public List<File> listFiles(String rootDir) {
    return null;
  }

  @Override
  public List<String> readLines(File inputFile) {
    return null;
  }

  @Override
  public boolean containsPattern(String line) {
    return false;
  }

  @Override
  public void writeToFile(List<String> lines) throws IOException {

  }

  @Override
  public String getRootPath() {
    return null;
  }

  @Override
  public void setRootPath(String rootPath) {

  }

  @Override
  public String getRegex() {
    return null;
  }

  @Override
  public void setRegex(String regex) {

  }

  @Override
  public String getOutFile() {
    return null;
  }

  @Override
  public void setOutFile(String outFile) {

  }
}
