package Tests;

import Pages.CalculatorPage;
import Tests.Listener.TestListener;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.time.Duration;



public class BaseTest {
    @BeforeClass
//    @DataProvider(name = "browser")
    public Object[][] getData(ITestContext context) {
        String browserName = System.getProperty("browser");
        return new Object[][]{
                {browserName}
        };
    }

    @BeforeMethod
    public void setUp() {
        Configuration.timeout = Duration.ofSeconds(10).toMillis();
        Configuration.baseUrl = "https://auto.ria.com";
        SelenideLogger.addListener("allure", new AllureSelenide());
        selectBrowser("chrome");
        Configuration.headless = false;

    }


    @AfterMethod
    public void tearDown() {
        if (WebDriverRunner.getWebDriver() != null) {
            Selenide.closeWebDriver();
        }
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
