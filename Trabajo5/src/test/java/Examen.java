import org.junit.Assert;
import org.junit.Test;
import pages.CheckoutPage;
import pages.Homepage;
import pages.LoginPage;
import utilities.DriverManager;

import java.util.List;

public class Examen extends BaseTest{

    @Test
    public void verifyExam(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        Assert.assertEquals( "1", homepage.getCartIconText());
        homepage.clickOnAddSauceLabsTShirtToCartButton();
        Assert.assertEquals( "2", homepage.getCartIconText());
        homepage.clickOnCart();
        CheckoutPage checkoutpage= new CheckoutPage(DriverManager.getDriver().driver);
        List<String> names = checkoutpage.getItemNames();
        List<Double> prices = checkoutpage.getItemPrices();
        //Assert.assertEquals( "Sauce Labs Backpack", checkoutpage.getItemNames());
        //Assert.assertEquals( "Sauce Labs Bolt T-Shirt", checkoutpage.getItemNames());
        //Assert.assertEquals( "29.99", checkoutpage.getItemPrices());
        //Assert.assertEquals( "15.99", checkoutpage.getItemPrices());
        checkoutpage.clickOnRemoveBackpack();
        Assert.assertEquals( "1", checkoutpage.getCartIconText());
        checkoutpage.clickOnRemoveTShirt();
        Assert.assertEquals( "", homepage.getCartIconText());

    }
}
