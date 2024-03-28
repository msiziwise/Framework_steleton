package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage {
    public static WebDriver driver = null;

    @FindBy(xpath = "//span[contains(.,'Your Cart')]")
    WebElement CartTitle_xpath;
    @FindBy(xpath = "//button[contains(@id,'checkout')]")
    WebElement checkoutButton_xpath;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyThatCartPageIsDisplayed() {
             Assert.assertEquals(CartTitle_xpath.getText(), "Your Cart");

    }

    public void clickCheckoutButton() {
        checkoutButton_xpath.click();

    }
}

