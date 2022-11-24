package ca.jrvs.apps.grep;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.regex.Pattern;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaGrepImp implements JavaGrep {

  private String regex;
  private String rootPath;
  private String outFile;

  Logger logger = LoggerFactory.getLogger(JavaGrep.class);

  /**
   * Get cli arguments and set the class variables to the args elements. then start the process function
   * @param args cli arguments for regex rootDir and outfile
   */
  public static void main(String[] args) {
    BasicConfigurator.configure();

    //validation
    if(args.length != 3) {
      throw new IllegalArgumentException("Three arguments required, regex rootDir and outfile");
    }

    //setter
    JavaGrepImp javaGrepImp = new JavaGrepImp();
    javaGrepImp.setRegex(args[0]);
    javaGrepImp.setRootPath(args[1]);
    javaGrepImp.setOutFile(args[2]);

    try{
      javaGrepImp.process();
    }catch(Exception e){
      javaGrepImp.logger.error("Could not start the process method", e);
    }
  }

  @Override
  public void process() throws IOException {
    //listFiles
      //readLines
        //if contains Pattern
          //add
    //writeToFile
    List<String> matchedLines = new ArrayList<String>();
    ArrayList<File> filesInDirectories = new ArrayList<File>();
    for(File file : listFiles(rootPath)){
      for(String line : readLines(file)){
          if(containsPattern(line)){
            matchedLines.add(line);
          }
      }
    }
  writeToFile(matchedLines);
  }
  //@Override
  public List<File> listFiles(String rootDir) {

    File currFile = new File(rootDir);
    // get the initial root directory contents
    File[] filesInDirectory = currFile.listFiles();
    //array to store the list of files in all directories
    List<File> listOfFiles = new ArrayList<>();
    //if directory is empty return null
    if(filesInDirectory == null) {
      return null;
    }
    for(File file : filesInDirectory) {
      //check if directory, if it is make a recursive call, store in a List type and add to the listOfFiles
      if(file.isDirectory()) {
        List<File> currDirectory = listFiles(file.getAbsolutePath());
        listOfFiles.addAll(currDirectory);
      } else {
        listOfFiles.add(file);
      }
    }
    return listOfFiles;
  }

  @Override
  public List<String> readLines(File inputFile) throws IllegalArgumentException {
    //create the array of lines that need to be returned
    List<String> linesArray = new ArrayList<>();
    String line;
    try{
      BufferedReader reader = new BufferedReader((new FileReader(inputFile)));
      while((line = reader.readLine()) != null) {
        linesArray.add(line);
      }
    }catch(FileNotFoundException fnfe){
      throw new IllegalArgumentException("Given input is not the correct file", fnfe);
    } catch(IOException io) {
      throw new IllegalArgumentException("Contents of file cannot be read", io);
    }
    return null;
  }

  @Override
  public boolean containsPattern(String line) {
    return Pattern.matches(getRegex(), line);
  }

  @Override
  public void writeToFile(List<String> lines) throws IOException {

  }

  @Override
  public String getRootPath() {
    return rootPath;
  }

  @Override
  public void setRootPath(String rootPath) {
    this.rootPath = rootPath;
  }

  @Override
  public String getRegex() {
    return regex;
  }

  @Override
  public void setRegex(String regex) {
    this.regex = regex;
  }

  @Override
  public String getOutFile() {
    return outFile;
  }

  @Override
  public void setOutFile(String outFile) {
  this.outFile = outFile;
  }
}
