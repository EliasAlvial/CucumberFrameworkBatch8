package com.hrms.testbase;


import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.sun.tools.internal.jxc.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BaseClass  {

    public static WebDriver driver;
    /**
     * this method will open a browser, set up configuration and navigation to the URL
     */
     public static void setUp(){
         ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
         switch (ConfigsReader.getPropertyValue("browser").toLowerCase()){
             case "chrome":
                 WebDriverManager.chromedriver().setup();
                 driver=new ChromeDriver();
                 break;

             case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
             default:
                 throw new RuntimeException("invalid browser");
         }
         driver.get(ConfigsReader.getPropertyValue("url"));
         driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
         PageInitializer.initializePageObjects();
     }

     public static void tearDown(){
         if(driver !=null){
             driver.quit();
         }
     }

}
