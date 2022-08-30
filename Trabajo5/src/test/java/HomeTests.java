import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.junit.Test;
import pages.Homepage;
import pages.LoginPage;
import utilities.DriverManager;

import java.util.List;
public class HomeTests extends BaseTest  {

    @Test
    public void verifyAlphabeticalItemsFilterTest() {
        // Login with standard user
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        // Filtering by name
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.selectProductFilter("Name (A to Z)");
        List<String> names = homepage.getAllItemNames();
        boolean namesAreSorted = Ordering.natural().isOrdered(names);
        Assert.assertTrue(namesAreSorted);
    }

    @Test
    public void verifyAlphabeticalReversedItemsFilterTest() {
        // Login with standard user
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        // Filtering by name
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.selectProductFilter("Name (Z to A)");
        List<String> names = homepage.getAllItemNames();
        boolean namesAreSorted = Ordering.natural().reverse().isOrdered(names);
        Assert.assertTrue(namesAreSorted);
    }
}
