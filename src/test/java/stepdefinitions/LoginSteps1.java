package stepdefinitions;

import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement loginBtn = wait.until(
        ExpectedConditions.elementToBeClickable(By.id("login"))
    );

    // 🔥 Scroll into view (VERY IMPORTANT)
    ((JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollIntoView(true);", loginBtn);

    // 🔥 Small wait for stability
    try { Thread.sleep(1000); } catch (Exception e) {}

    // 🔥 Try normal click
    try {
        loginBtn.click();
    } catch (Exception e) {
        // 🔥 Fallback: JS click (bypasses overlay)
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", loginBtn);
    }
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