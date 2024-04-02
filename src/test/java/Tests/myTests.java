package Tests;

import Pages.CalculatorPage;
import Pages.ReviewPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;


public class myTests extends BaseTest {
    private static final String MARKA_AUTO = "Suzuki";
    private static final String MODEL_AUTO = "Vitara";

    @Test( description = "Test#1: відгук про авто")
    public void sendRewiew() {
        open("/uk/reviews/add.html");
        ReviewPage.getInstance().inputVehiclecharacteristics(MARKA_AUTO, MODEL_AUTO);
        assertThat(ReviewPage.getInstance().inputYourFeedback().text()).contains(MARKA_AUTO, MODEL_AUTO);
    }

    @Test( description = "Test#2: калькулятор")
    public void testCalc() {
        open("/uk/rastamozhka-avto/calculator/");
        assertThat(CalculatorPage.getInstance().calculation()).isEqualTo("4649 €");
    }

}
