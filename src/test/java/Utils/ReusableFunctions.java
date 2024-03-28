package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReusableFunctions {

    WebDriver driver;

    public ReusableFunctions(WebDriver driver){
        this.driver=driver;
    }
    public void enterTextInTheTextBox(By by,String text){
        driver.findElement(by).sendKeys(text);
    }

    public void clickButton(By by){
        driver.findElement(by).click();
    }
}
