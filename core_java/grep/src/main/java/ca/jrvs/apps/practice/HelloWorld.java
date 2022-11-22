package ca.jrvs.apps.practice;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class HelloWorld {

  //Print "Hello World to the terminal window"
  public static void main(String args[]) {
    BasicConfigurator.configure();
    Logger logger = LoggerFactory.getLogger("SampleLogger");
    logger.info("Hi this is my first SLF4J program");
    System.out.println("Hello, World");
  }
}