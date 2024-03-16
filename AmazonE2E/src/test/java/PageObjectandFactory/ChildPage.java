package PageObjectandFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChildPage {

    WebDriver driver;
    public ChildPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//input[@id='add-to-cart-button']")
    WebElement cart;

    public void addToCart()
    {
        cart.click();
    }

}
