package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalculatorPage {

    public static CalculatorPage getInstance() {
        return new CalculatorPage();
    }

    private SelenideElement categoryLegkovie = $("svg[class='svg svg_i48_legkovie']");

    public SelenideElement filterFuel = $("select[name='fuel']");

    public SelenideElement filterOrigin = $("#leftFilterOrigin");

    public SelenideElement filterAge = $("#leftFilterAge");

    public SelenideElement inputPrice = $("input[name='price']");

    public SelenideElement inputFilterEngine = $("#leftFilterEngine");

    public SelenideElement button = $("button");

    public ElementsCollection listResult = $$("div[class^='calc-table'] span[class ='casual']");

    public String calculation() {
        categoryLegkovie.shouldBe(visible).shouldBe(clickable).click();
        filterFuel.shouldBe(visible).shouldBe(clickable).selectOption("бензин");
        filterOrigin.shouldBe(visible).shouldBe(clickable).selectOption("ЄС");
        filterAge.shouldBe(visible).shouldBe(clickable).selectOption("2 роки");
        inputPrice.shouldBe(visible).shouldBe(editable).setValue("3500");
        inputFilterEngine.shouldBe(visible).shouldBe(editable).setValue("1500");
        button.shouldBe(visible).shouldBe(interactable).click();
        return listResult.last().shouldBe(visible).text();
    }


}
