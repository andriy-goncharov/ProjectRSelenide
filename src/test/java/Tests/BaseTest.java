package Tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.time.Duration;

import static com.codeborne.selenide.Configuration.browser;

public class BaseTest {
    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        Configuration.timeout = Duration.ofSeconds(10).toMillis();
        Configuration.baseUrl = "https://auto.ria.com";
        selectBrowser(browser);
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
            case "chromium":
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
