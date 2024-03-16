package StepDefinitions;

import PageObjectandFactory.ChildPage;
import PageObjectandFactory.ParentPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.Set;

public class Amazon {


     public ParentPage pp;
    public ChildPage cp;

    public  WebDriver driver;
    @Given("user is on the google home page")
    public void user_is_on_the_google_home_page() {

        ChromeOptions opt=new ChromeOptions();
        opt.addArguments("--incognito","--start-maximized");
        opt.addArguments("disable-notifications");
         driver=new ChromeDriver(opt);
        driver.get("https://google.co.in");


    }
    @When("^user searched with (.+) in search bar$")
    public void user_searched_with_amazon_in_search_bar(String SiteName) throws InterruptedException {

        pp=new ParentPage(driver);
        pp.search(SiteName);
    }
    @When("user clicks the first option from suggestion")
    public void user_clicks_the_first_option_from_suggestion() {

    }
    @When("user clicks the first option from the page")
    public void user_clicks_the_first_option_from_the_page() throws InterruptedException {

        Thread.sleep(3000);
        pp.amazonSearchListPage();
        Thread.sleep(3000);

    }
    @Then("user verifies that the site is Amazon.in official")
    public void user_verifies_that_the_site_is_amazon_in_official() {

     String actual=driver.getTitle();
     String expected="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        Assert.assertEquals(actual,expected);
    }
    @When("^user search (.+) in search bar$")
    public void user_search_tshirt_in_search_bar(String ProductType) throws InterruptedException {

        pp.searchSection(ProductType);
        Thread.sleep(3000);
    }
    @When("user select the price range from price section")
    public void user_select_the_price_range_from_price_section() {

        pp.priceRangeSection();
    }
    @When("^select the (.+) product$")
    public void select_the_third_product(String ProductNumber) {

        pp.displayOfTshirt();

    }
    @When("click on add to cart button")
    public void click_on_add_to_cart_button() {

///////////////////////////////// childpage

       Set<String> handles=driver.getWindowHandles();
       Iterator<String> it=handles.iterator();
       String parent=it.next();
       String child=it.next();
       driver.switchTo().window(child);

       cp=new ChildPage(driver);
       cp.addToCart();
      // driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
       driver.quit();
    }
}
