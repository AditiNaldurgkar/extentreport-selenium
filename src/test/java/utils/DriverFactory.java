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

            // 🔥 Required for Jenkins
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
             options.addArguments("--window-size=1920,1080"); 

            // ✅ USE THIS (your working Grid URL)
            String gridUrl = "http://172.31.8.161:4444";

            driver.set(new RemoteWebDriver(
                    new URL(gridUrl),
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