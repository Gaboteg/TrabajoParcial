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

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpack;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    WebElement removeTShirt;

    @FindBy(tagName = "h3")
    WebElement chekoutError;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartIcon;

    @FindBy(className = "inventory_item_name")
    List<WebElement> itemNamesLabel;

    @FindBy(className = "inventory_item_price")
    List<WebElement> itemPricesLabel;
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

    public void clickOnRemoveBackpack(){ removeBackpack.click(); }

    public void clickOnRemoveTShirt(){ removeTShirt.click(); }

   // public String getPriceText(){
   //     String Price = cartIcon.getText();
   //     return Price;
   // }

    public String getCartIconText(){
        String cartText = cartIcon.getText();
        return cartText;
    }

    public List<String> getItemNames(){
        List<String> names = new ArrayList<>();

        for (WebElement itemname: itemNamesLabel) {
            String itemNameText = itemname.getText();
            StringBuilder sb = new StringBuilder(itemNameText);
            sb.deleteCharAt(0);
            names.add(sb.toString());
        }
        return names;
    }

    public List<Double> getItemPrices(){
        List<Double> prices = new ArrayList<>();

        for (WebElement itemPrice: itemPricesLabel) {
            String itemPriceText = itemPrice.getText();
            StringBuilder sb = new StringBuilder(itemPriceText);
            sb.deleteCharAt(0);
            prices.add(Double.parseDouble(sb.toString()));
        }
        return prices;
    }




}
