package stepDefinitions;

import com.google.common.collect.Ordering;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Homepage;
import pages.LoginPage;
import utilities.DriverManager;

import java.util.List;

public class HomeSteps {
    Homepage homepage = new Homepage(DriverManager.getDriver().driver);
    LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);

    @When("I set the filter in {string}")
    public void setFilter(String filter){
        homepage.selectProductFilter(filter);
    }

    @Then("I check if the prices are correctly sorted")
    public void checkOrder() {
        List<Double> prices = homepage.getAllItemPrices();
        boolean pricesAreSorted = Ordering.natural().isOrdered(prices);
        Assert.assertTrue(pricesAreSorted);
    }

    @Given("I add the backpack product to the cart")
    public void addBackpack(){homepage.clickOnAddSauceLabsBackPackToCartButton();}

    @And("I check the number {string} is displayed at the top of the cart")
    public void checkCartText(String num){Assert.assertEquals( num, homepage.getCartIconText());}


    @Given ("I open the lateral menu")
    public void openMenu(){homepage.clickOnMenuButton();}

    @When ("I click in the logout option")
    public void clickLogout(){homepage.clickOnLogout();}

    @Then ("The login page should be displayed")
    public void loginDisplay(){Assert.assertTrue(loginPage.loginButtonIsDisplayed());}



}
