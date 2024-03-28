package StepDefinations;

import Helpers.BrowserSetup;
import Helpers.Screenshots;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    BrowserSetup browserSetup = new BrowserSetup();
    final WebDriver driver=browserSetup.startBrowser("chrome","https://www.saucedemo.com/");

    LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
    HomePage homePage = PageFactory.initElements(driver,HomePage.class);
    CartPage cartPage = PageFactory.initElements(driver,CartPage.class);
    YourInformationPage yourInformationPage = PageFactory.initElements(driver,YourInformationPage.class);
    CheckoutOverviewPage checkoutOverviewPage = PageFactory.initElements(driver,CheckoutOverviewPage.class);


    Screenshots screenshots = new Screenshots();

}
