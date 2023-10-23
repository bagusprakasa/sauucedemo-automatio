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

public class logout {
    WebDriver driver;

    String baseUrl = "https://www.saucedemo.com/";

    @Given("user already login to dashboard")
    public void user_already_login_to_dashboard(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user tap burger menu button")
    public void user_tap_burger_menu_button(){
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("user tap logout button")
    public void user_tap_logout_button(){
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("user is on login page")
    public void user_is_on_login_page(){
        String loginPage;
        loginPage = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
        Assert.assertEquals(loginPage, "Swag Labs");
        driver.close();
    }
}
