package PageObjectandFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ParentPage {
    WebDriver driver;

    public ParentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//textarea[@class='gLFyf']")
    WebElement SiteName;
    @FindBy(xpath ="//textarea[@class='gLFyf']")
    WebElement enter;
    @FindBy(xpath ="//div[text()='Not now']")
    WebElement popup;
    @FindBy(xpath ="//h3[@class='LC20lb MBeuO DKV0Md']")
    List<WebElement> firstoption;
    @FindBy(xpath ="//input[@type='text']")
    WebElement searchbar;
    @FindBy(xpath ="//input[@type='text']")
    WebElement searchenter;
    @FindBy(xpath ="//span[text()='₹500 - ₹1,000']")
    WebElement pricerange;
    @FindBy(xpath ="//img[@class='s-image']")
    List<WebElement> tshirtoption;


    public void search(String srch)
    {
        SiteName.sendKeys(srch);
        enter.sendKeys(Keys.ENTER);
    }

    public void amazonSearchListPage()
    {
        popup.click();
        firstoption.get(0).click();
    }

    public void searchSection(String ProductType)
    {
        searchbar.sendKeys(ProductType);
        searchenter.sendKeys(Keys.ENTER);
    }

    public void priceRangeSection()
    {
        pricerange.click();
    }
    public void displayOfTshirt()
    {
        tshirtoption.get(3).click();
    }



}
