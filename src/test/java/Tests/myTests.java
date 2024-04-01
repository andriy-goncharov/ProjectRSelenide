package Tests;

import Pages.CalculatorPage;
import Pages.ReviewPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class Tests extends BaseTest{
    @Test
    public void inputVehiclecharacteristics() {
        open("/reviews/add.html");
        ReviewPage.getInstance().inputVehiclecharacteristics("Легковые");
    }
    @Test
    public void testCalc(){
        open("/uk/rastamozhka-avto/calculator/");
        CalculatorPage.getInstance().calculation();
    }

}
