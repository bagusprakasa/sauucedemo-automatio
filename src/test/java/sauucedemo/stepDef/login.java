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

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user launch the website saucedemo")
    public void user_launch_the_website_saucedemo(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(baseUrl);
        // Assertion
        String loginPageAssert;
        loginPageAssert = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("user input valid username")
    public void user_input_valid_username(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input valid password")
    public void user_input_valid_password(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user input invalid password")
    public void user_input_invalid_password(){
        driver.findElement(By.id("password")).sendKeys("test123");
    }

    @And("user tap login button")
    public void user_tap_login_button(){
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user is on dashboard page")
    public void user_is_on_dashboard_page(){
        String dashboardPageAssert = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(dashboardPageAssert, "Products");
        driver.close();
    }

    @Then("user get error message")
    public void user_get_error_message(){
        String ErrorLogin;
        ErrorLogin = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]")).getText();
        Assert.assertEquals(ErrorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }}