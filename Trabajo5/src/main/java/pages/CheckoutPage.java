package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CheckoutPage {
    WebDriver driver;

    @FindBy(id = "checkout")
    WebElement checkout;

    @FindBy(id = "first-name")
    WebElement first;

    @FindBy(id = "last-name")
    WebElement last;

    @FindBy(id = "postal-code")
    WebElement zip;

    @FindBy(id = "continue")
    WebElement continuar;

    @FindBy(tagName = "h3")
    WebElement chekoutError;

    public String getCheckoutErrorMessage(){
        String errorMessage = chekoutError.getText();
        return errorMessage;
    }

    public CheckoutPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCheckout(){ checkout.click(); }

    public void setFirst(String name){
        first.sendKeys(name);
    }

    public void setLast(String lastn){
        last.sendKeys(lastn);
    }

    public void setZip(String zipc){
        zip.sendKeys(zipc);
    }

    public void clickOnContinue(){ continuar.click(); }
}
