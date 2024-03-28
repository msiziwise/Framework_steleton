package Helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots {


    String Screenshot_dir= System.getProperty("user.dir")+ "/Screenshots";
    public void takeSnapShot(WebDriver driver, String screenshotName){

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        File destination = new File(Screenshot_dir,screenshotName+".png");

        try{
            FileUtils.copyFile(src,destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
