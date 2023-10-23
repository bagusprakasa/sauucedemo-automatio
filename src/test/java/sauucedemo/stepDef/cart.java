package sauucedemo.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class cart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user success login to dashboard")
    public void user_success_login_to_dashboard(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
    @When("user tap add to cart")
    public void user_tap_add_to_cart(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("user tap shopping cart button")
    public void user_tap_shopping_cart_button(){
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @Then("user is on your cart page")
    public void user_is_on_your_cart_page(){
        String cartPge = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(cartPge, "Your Cart");
        driver.close();
    }

}
