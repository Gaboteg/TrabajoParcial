import org.junit.Assert;
import org.junit.Test;
import pages.CheckoutPage;
import pages.Homepage;
import pages.LoginPage;
import utilities.DriverManager;

public class CheckoutTests extends BaseTest{

    @Test
    public void verifyCartNotSharedBetweenUsers(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        Assert.assertEquals( "1", homepage.getCartIconText());
        homepage.clickOnMenuButton();
        homepage.clickOnLogout();
        Assert.assertTrue(loginPage.loginButtonIsDisplayed());
        //Thread.sleep(1000);
        LoginPage loginPage2 = new LoginPage(DriverManager.getDriver().driver);
        loginPage2.setUserNameTextBox("problem_user");
        loginPage2.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage2= new Homepage(DriverManager.getDriver().driver);
        Assert.assertEquals( "1", homepage2.getCartIconText());
        System.out.println("Se espera que no exista ningun producto en el carrito del otro usuario");
    }

    @Test
    public void verifyCartSaveAfterLogout(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        Assert.assertEquals( "1", homepage.getCartIconText());
        homepage.clickOnMenuButton();
        homepage.clickOnLogout();
        Assert.assertTrue(loginPage.loginButtonIsDisplayed());
        //Thread.sleep(2500);
        LoginPage loginPage2 = new LoginPage(DriverManager.getDriver().driver);
        loginPage2.setUserNameTextBox("standard_user");
        loginPage2.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage2= new Homepage(DriverManager.getDriver().driver);
        Assert.assertEquals( "1", homepage2.getCartIconText());
    }

    @Test
    public void verifyShopWithoutName(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickOnCart();
        CheckoutPage checkoutpage= new CheckoutPage(DriverManager.getDriver().driver);
        checkoutpage.clickOnCheckout();
        checkoutpage.setFirst("");
        checkoutpage.setLast("Lopez");
        checkoutpage.setZip("12345");
        checkoutpage.clickOnContinue();
        Assert.assertEquals("Error: First Name is required",
                checkoutpage.getCheckoutErrorMessage());
    }

    @Test
    public void verifyShopWithoutZip(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickOnCart();
        CheckoutPage checkoutpage= new CheckoutPage(DriverManager.getDriver().driver);
        checkoutpage.clickOnCheckout();
        checkoutpage.setFirst("Fernando");
        checkoutpage.setLast("Lopez");
        checkoutpage.setZip("");
        checkoutpage.clickOnContinue();
        Assert.assertEquals("Error: Postal Code is required",
                checkoutpage.getCheckoutErrorMessage());
    }
}
