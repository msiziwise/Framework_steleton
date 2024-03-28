package Pages;

import Utils.ReusableFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static Pages.HomePage.driver;

public class YourInformationPage {
//    WebDriver driver=null;
    ReusableFunctions reusableFunctions;
//    @FindBy(xpath = "//span[contains(.,'Checkout: Your Information')]")
//    WebElement YourInformation_Text_xpath;

    private static By YourInformation_Text_xpath = By.xpath("//span[contains(.,'Checkout: Your Information')]");
    private static By firstName_field = By.xpath("//input[contains(@id,'first-name')]");
    private static By lastName_field = By.xpath("//input[contains(@id,'last-name')]");
    private static By zip_field = By.xpath("//input[contains(@id,'postal-code')]");
    private static By continueButton_xpath = By.xpath("//input[contains(@id,'continue')]");


    public YourInformationPage() {

        reusableFunctions= new ReusableFunctions(driver);
        PageFactory.initElements(driver,this);
    }


//    public void verifyThatYourInformationPageIsDisplayed() {
//        Assert.assertEquals(YourInformation_Text_xpath.getText(), "Checkout: Your Information");
//    }

    public void enterUsename(String firstname) {
        reusableFunctions.enterTextInTheTextBox(firstName_field, firstname);
    }

    public void enterLastName(String lastname) {
        reusableFunctions.enterTextInTheTextBox(lastName_field, lastname);
    }
    public void enterzip(String zip) {
        reusableFunctions.enterTextInTheTextBox(zip_field, zip);
    }

    public void clickContinueButton() {
        reusableFunctions.clickButton(continueButton_xpath);
    }

}
