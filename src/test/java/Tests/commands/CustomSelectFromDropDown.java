package Tests.commands;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.Arguments;
import com.codeborne.selenide.impl.WebElementSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.commands.Util.merge;

public class CustomSelectFromDropDown implements Command<SelenideElement> {
    @Nullable
    @Override
    public SelenideElement execute(SelenideElement proxy, WebElementSource locator, @Nullable Object[] args) {
        Arguments arguments = new Arguments(args);
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Missing arguments");
        } else if (args[0] instanceof String firstOptionText) {
            List<String> texts = merge(firstOptionText, arguments.nth(1));
            selectOptionsByTexts(locator, texts);
            return null;
        } else if (args[0] instanceof Integer firstOptionIndex) {
            int[] otherIndexes = arguments.nth(1);
            selectOptionsByIndexes(locator, merge(firstOptionIndex, otherIndexes));
            return null;
        } else {
            throw new IllegalArgumentException("Unsupported argument (expected String or Integer): " + Arrays.toString(args));
        }
    }

    private void selectOptionsByIndexes(WebElementSource locator, List<Integer> merge) {
        locator.findAndAssertElementIsClickable().click();
        WebDriver webDriver = locator.driver().getWebDriver();
        WebElement optionsList = webDriver.findElement(By.cssSelector("li.list-item a"));
        for (int index : merge) {
            optionsList.findElement(By.xpath("./li[@role='option'][%s]".formatted(index))).click();
        }
    }

    private void selectOptionsByTexts(WebElementSource locator, List<String> texts) {
        locator.findAndAssertElementIsClickable().click();
        WebDriver webDriver = locator.driver().getWebDriver();
        WebElement optionsList = webDriver.findElement(By.cssSelector("li.list-item"));
        for (String text : texts) {
            optionsList.findElement(By.xpath("./li[@class='item'][text()='%s']".formatted(text))).click();
        }
    }
}
