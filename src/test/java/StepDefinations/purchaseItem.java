package StepDefinations;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class purchaseItem extends Base {

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
//       (driver,"Login Page");
    }

    @And("^I enter username (.*)$")
    public void i_enter_username(String username) {
        loginPage.enterUserName(username);
    }

    @And("^I enter password (.*)$")
    public void i_enter_password(String password) {
        loginPage.enterPassWord(password);

    }

    @When("I click login button")
    public void i_click_login_button() {

        loginPage.clickLoginButton();
//       (driver,"Home Page");
    }

    @Then("Home Page is Displayed")
    public void home_page_is_displayed() {
        homePage.verifyLoginSuccess();
    }


    @And("i close the browser")
    public void iCloseTheBrowser() {
        driver.quit();
    }

    @And("I click item backpack add to cart button")
    public void iClickItemBackpackAddToCartButton() {
        homePage.clickBackPack_AddToCartButton();
    }

    @Then("Verify that item is added to card")
    public void verifyThatItemIsAddedToCard() {
        homePage.verifyItemAddedToCart();
    }

    @And("I click cart")
    public void iClickCart() throws InterruptedException {
        homePage.clickCart();
    }

    @Then("Verify that I am on Cart Page")
    public void verifyThatIAmOnCartPage() {
        cartPage.verifyThatCartPageIsDisplayed();

    }

    @AfterStep
    public void tearDown(Scenario scenario) {
        // This method will be executed after each scenario
        if (scenario.isFailed()) {
            // Take a screenshot and attach it to the report
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
//        driver.quit();
    }

    @And("I click checkout button")
    public void iClickCheckoutButton() {
        cartPage.clickCheckoutButton();
    }

//    @Then("Verify that information page is displayed")
//    public void verifyThatInformationPageIsDisplayed() {
//        yourInformationPage.verifyThatYourInformationPageIsDisplayed();
//    }

    @And("^I enter First Name (.*)$")
    public void iEnterFirstNameFirstName(String first_name) {
        yourInformationPage.enterUsename(first_name);
    }

    @And("^I enter Last Name (.*)$")
    public void iEnterLastNameLastName(String last_Name) {
        yourInformationPage.enterLastName(last_Name);

    }

    @And("^I enter Zipcode (.*)$")
    public void iEnterZipcodeZipcode(String zipcode) {
        yourInformationPage.enterzip(zipcode);
    }

    @And("click continue button")
    public void clickContinueButton() {
        yourInformationPage.clickContinueButton();
    }

    @Then("Verify that CheckoutOverview is displayed")
    public void verifyThatCheckoutOverviewIsDisplayed() {
        checkoutOverviewPage.verifyThatCheckoutOverviewPageIsDisplayed();
    }

    @And("VerifyItemTotalPlusTaxIsEqualTotal")
    public void verifyitemtotalplustaxisequaltotal() {
        checkoutOverviewPage.Verify_Item_Total_Plus_Tax_Is_Equal_Total();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }

    }



}