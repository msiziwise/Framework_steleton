package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {


    public static WebDriver driver = null;

    @FindBy(xpath = "//input[contains(@id,'user-name')]")
    WebElement username_xpath;

    @FindBy(xpath = "//input[contains(@id,'password')]")
    WebElement password_xpath;

    @FindBy(xpath = "//input[contains(@id,'login-button')]")
    WebElement loginButton_xpath;

    @FindBy(xpath = "//h3[@data-test='error'][contains(.,'Epic sadface: Username and password do not match any user in this service')]")
    WebElement loginError_xpath;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String username) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(username_xpath));
        username_xpath.clear();
        username_xpath.sendKeys(username);
    }

    public void enterPassWord(String password) {
        password_xpath.clear();
        password_xpath.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton_xpath.click();
    }

    public void verifyLoginUnsuss() {
        loginError_xpath.isDisplayed();
        Assert.assertEquals(loginError_xpath.getText(),"Epic sadface: Username and password do not match any user in this service");
    }

}
