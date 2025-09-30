package base;

import com.utils.ConfigReader;
import com.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    private DriverFactory driverFactory;

    @BeforeSuite
    public void setUp() throws IllegalAccessException {
        driverFactory = DriverFactory.getInstance();
        driverFactory.setDriver(ConfigReader.readFromPropFile("browser"));
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        DriverFactory.quitBrowser();
    }
}
