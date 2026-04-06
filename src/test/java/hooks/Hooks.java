package hooks;
import com.aventstack.extentreports.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;
import utils.ExtentManager;

public class Hooks {

    static ExtentReports extent = ExtentManager.getInstance();
    static ExtentTest test;

    @Before
    public void setup(io.cucumber.java.Scenario scenario) {
        test = extent.createTest(scenario.getName());
        DriverFactory.initDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
        extent.flush();
    }
}
