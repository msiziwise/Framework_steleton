package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.text.DecimalFormat;
public class CheckoutOverviewPage {
    public static WebDriver driver = null;
    public static final DecimalFormat decfor = new DecimalFormat("0.00");
    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Overview')]")
    WebElement CheckoutOverviewTitle_xpath;
    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    WebElement itemTotal_xpath;
    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    WebElement Total_xpath;
    @FindBy(xpath = "//button[@id='finish']")
    WebElement finish_xpath;

    @FindBy(xpath = "//button[@id='cancel']")
    WebElement cancel_xpath;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    WebElement TaxLabel_xpath;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyThatCheckoutOverviewPageIsDisplayed() {
        Assert.assertEquals(CheckoutOverviewTitle_xpath.getText(), "Checkout: Overview");
        CheckoutOverviewTitle_xpath.isDisplayed();

    }

    public void Verify_Item_Total_Plus_Tax_Is_Equal_Total() {
        // Resolve Item Total
        String itemTotaLabel = itemTotal_xpath.getText().substring(13);
        double itemTotal = Double.parseDouble(itemTotaLabel);

        // Resolve Item Tax
        String iTaxLabel = TaxLabel_xpath.getText().substring(6);
        double Tax = Double.parseDouble(iTaxLabel);


        double ItemTotalPlusTax = itemTotal + Tax;

        // Resolve Total
        String TotaLabel = Total_xpath.getText().substring(8);
        double Total = Double.parseDouble(TotaLabel);

        if (Total == ItemTotalPlusTax+2) {
            finish_xpath.click();
            Assert.assertTrue(true);
        } else {
            cancel_xpath.click();
            Assert.assertTrue(false);
        }


    }

}
