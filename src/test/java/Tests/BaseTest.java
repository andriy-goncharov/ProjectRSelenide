package Tests;

import Tests.Listener.TestListener;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.time.Duration;

import static com.codeborne.selenide.Configuration.browser;


public class BaseTest {


    @BeforeMethod
    @Parameters("browser")
    public void setUp() {
        Configuration.timeout = Duration.ofSeconds(10).toMillis();
        Configuration.baseUrl = "https://auto.ria.com";
        selectBrowser("chrome");
    }


    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }


    @DataProvider(name = "browser")
    public Object[][] getData(ITestContext context) {
        String browserName = System.getProperty("browser");
        return new Object[][]{
                {browserName}
        };
    }


    private void selectBrowser(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                Configuration.browser = "chrome";
                break;
            case "firefox":
                Configuration.browser = "firefox";
                break;
            case "ie":
                Configuration.browser = "ie";
                break;
            case "edge":
                Configuration.browser = "edge";
                break;
            case "safari":
                Configuration.browser = "safari";
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name");
        }
    }

}
