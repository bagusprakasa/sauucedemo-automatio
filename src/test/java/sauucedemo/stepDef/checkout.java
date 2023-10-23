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

public class checkout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user is on cart page")
    public void user_is_on_cart_page() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        String cartPge = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(cartPge, "Your Cart");
    }

    @When("user tap checkout button")
    public void user_tap_checkout_button() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("user input identity")
    public void user_input_identity() {
        driver.findElement(By.id("first-name")).sendKeys("Park");
        driver.findElement(By.id("last-name")).sendKeys("Sungjin");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
    }

    @And("user input identity without postal code")
    public void user_input_identity_without_postal_code() {
        driver.findElement(By.id("first-name")).sendKeys("Park");
        driver.findElement(By.id("last-name")).sendKeys("Sungjin");
        driver.findElement(By.id("postal-code")).sendKeys("");
        driver.findElement(By.id("continue")).click();

        driver.close();
    }

    @And("user tap continue button")
    public void user_tap_continue_button() {
        driver.findElement(By.id("continue")).click();
        String checkoutOverviewPage;
        checkoutOverviewPage = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(checkoutOverviewPage, "Checkout: Overview");
    }

    @And("user tap finish button")
    public void user_tap_finish_button() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("user is on checkout complete page")
    public void user_is_on_checkout_complete_page() {
        String checkoutCompletePage;
        checkoutCompletePage = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(checkoutCompletePage, "Checkout: Complete!");
        driver.close();
    }

}
