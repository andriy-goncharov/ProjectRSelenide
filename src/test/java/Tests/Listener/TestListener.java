package Tests.Listener;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

import static com.codeborne.selenide.Selenide.screenshot;

public class TestListener implements ITestListener, StepLifecycleListener, TestLifecycleListener {

    @Override
    public void onTestFailure(ITestResult result) {
        makeScreenshot();
    }

    @Attachment(type = "image/png")
    private byte[] makeScreenshot() {
        return screenshot(OutputType.BYTES);
    }

    @Override
    public void beforeTestStop(TestResult result) {
        if (result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN) {
            byte[] screenshot = Selenide.screenshot(OutputType.BYTES);
            Allure.addAttachment(result.getName(), new ByteArrayInputStream(screenshot));
        }
    }


}
