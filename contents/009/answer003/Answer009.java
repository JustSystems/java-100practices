/**
 * 20170202 takuya.m
 */

import java.util.Properties;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class Answer009 {
   public static void main(String arguments[]) throws IOException {
       Properties prop = new Properties();
       prop.load(new InputStreamReader(new FileInputStream("test.Properties"), "UTF-8"));
       System.out.println(prop.getProperty("name"));
   }
}
