package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverFactory;

public class LoginSteps1 {

    WebDriver driver;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver = DriverFactory.initDriver();
        driver.get("https://demoqa.com/login");
    }

    @When("user enters {string} and {string}")
    public void user_enters_username_and_password(String username, String password) {
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userName")).sendKeys(username);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("user clicks on login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.id("login")).click();
    }

    @Then("user should see {string}")
    public void user_should_see_result(String result) {

        String currentUrl = driver.getCurrentUrl();

        if (result.equalsIgnoreCase("Login Successful")) {
            Assert.assertTrue(currentUrl.contains("profile"), "Login should be successful");
        } else {
            Assert.assertTrue(currentUrl.contains("login"), "Login should fail");
        }

        DriverFactory.quitDriver();
    }
}