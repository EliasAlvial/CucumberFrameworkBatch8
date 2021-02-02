package com.hrms.utils;

import com.hrms.testbase.BaseClass;
import com.hrms.testbase.PageInitializer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {

    /**
     * this method will clear a textBox and send text to it
     * @param element
     * @param textToSend
     */

    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    public static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(driver,Constants.EXPLICIT_WAIT);
        return wait;
    }
    /**
     * this method will wait until given becomes clickable
     * @param element
     */
    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * this method will wait till and then click
     * @param element
     */
    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        return js;
    }

    public static void jsClick(WebElement element){

        getJSExecutor().executeScript("arguments[0].click();", element);
    }
    public static void jsSendText(WebElement element, String s){
        getJSExecutor().executeScript("arguments[0].value='enter the value here';",element);
    }

    /**
     *
     * @param fileName
     */
    public static byte[] takeScreenshot(String fileName) {
        TakesScreenshot ts=(TakesScreenshot)driver;
        byte[] bytes=ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName +
                    getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     *
     * @param pattern
     * @return
     */
    public static String getTimeStamp(String pattern){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * this method will click on a radio btton or a checkbox bb the given list of elements and the value
     * @param radioOrCheckBoxes
     * @param value
     */
     public static void clickRadioOnCheckBox(List<WebElement> radioOrCheckBoxes, String value) {
        for(WebElement radioOrCheckbox:radioOrCheckBoxes){
            String actualValue=radioOrCheckbox.getAttribute("value").trim();
            if(radioOrCheckbox.isEnabled() &&actualValue.equals(value)){
                jsClick(radioOrCheckbox);
                break;
            }
        }
    }

    /**
     * this method will select a value from a given dropdown by the given visible text.
     * @param dd
     * @param visibleText
     */

    public static void selectDDValue(WebElement dd, String visibleText){
//we aer using this try because there's a chance that a dropdown menu will not contain select
         try {


         Select select=new Select(dd); //we can use select action only when the tagname has select in it
        List <WebElement> options=select.getOptions();// this will return a list of elements
        for(WebElement option:options){
            if(option.getText().equals(visibleText)){
                select.selectByVisibleText(visibleText);
                break;
            }
        }
    }catch (UnexpectedTagNameException e){
             e.printStackTrace();
         }
     }

     public static void switchToFrame(int frameIndex){
        try{
            driver.switchTo().frame(frameIndex);
        }catch (NoSuchFrameException e){
            e.printStackTrace();
        }
     }
    public static void switchToFrame(String nameOrId){
        try{
            driver.switchTo().frame(nameOrId);
        }catch (NoSuchFrameException e){
            e.printStackTrace();
        }
    }

    /**
     * this method will select a value from a given dropdown by the given index
     * @param dd
     * @param index
     */
    public static void selectedDDValue(WebElement dd, int index){

       try {
           Select select = new Select(dd);
           List<WebElement> options = select.getOptions();
           int ddSize = options.size();

           if (ddSize > index) {
               select.selectByIndex(index);

           }
       }catch (UnexpectedTagNameException e){
           e.printStackTrace();
       }
    }

    public static void switchToChildWindow(){
       String mainWindow= driver.getWindowHandle();
        Set<String> allWindows=driver.getWindowHandles();
    }

    /**
     * this method will click on a radio btton or a checkbox bb the given list of elements byt textValue
     * @param radioOrCheckBoxes
     * @param value
     */
    public static void clickRadioOnCheckBoxByText(List<WebElement> radioOrCheckBoxes, String value) {
        for(WebElement radioOrCheckbox:radioOrCheckBoxes){
            String actualValue=radioOrCheckbox.getText().trim();
            if(radioOrCheckbox.isEnabled() &&actualValue.equals(value)){
                jsClick(radioOrCheckbox);
                break;
            }
        }
    }
}
