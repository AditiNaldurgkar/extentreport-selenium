package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URL;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver() {
        try {
            ChromeOptions options = new ChromeOptions();

            driver.set(new RemoteWebDriver(
                    new URL("http://172.21.0.177:4444"), // 🔥 replace with your HUB IP
                    options
            ));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove(); 
        }
    }
}