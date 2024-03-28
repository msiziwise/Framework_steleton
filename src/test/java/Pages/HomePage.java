package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {

    public static WebDriver driver = null;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Products')]")
    WebElement Product_label_xpath;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartButton_BackPack_id;

    @FindBy(xpath = "//span[@class='shopping_cart_badge'][contains(.,'1')]")
    WebElement ItemAdded_xpath;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLoginSuccess() {
        Product_label_xpath.isDisplayed();
        Assert.assertEquals(Product_label_xpath.getText(), "Products");
    }

    public void clickBackPack_AddToCartButton() {
        addToCartButton_BackPack_id.click();
    }

    public void verifyItemAddedToCart() {
        ItemAdded_xpath.isDisplayed();
    }
    public void clickCart()  {
        ItemAdded_xpath.click();
    }
}
