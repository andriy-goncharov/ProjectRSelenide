package Pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class ReviewPage {

    private SelenideElement categoryId = $("#categoryId");
    private SelenideElement markaId = $("#markaId");
    private ElementsCollection autoColletion = $$("li.list-item a");
    private SelenideElement model = $x("//*[@id='modelId']");
    private ElementsCollection modelCollection = $$("li.list-item a");
    private SelenideElement selectYear = $("#year");
    private SelenideElement selectBody = $("#bodyId");
    private SelenideElement selectfuelId = $("#fuelIdList");
    private SelenideElement driveType = $("#driveIdList");
    private SelenideElement gearType = $("#gearIdList");
    private SelenideElement odometer = $("#race");
    private SelenideElement fuelConsumption = $("#fuelConsumption");
    private SelenideElement firstBayer = $("label[for='first-bayer']");
    private SelenideElement userName = $("#userName");
    private SelenideElement timeDriving = $("#timeDriving");
    private SelenideElement timeOwning = $("#drivingExperience");
    private SelenideElement usingType = $("#usingType");
    private SelenideElement textReview = $("#review");

    private SelenideElement korobka_peredach_minus = $("label[data-gaq='korobka-peredach_minus']");
    private SelenideElement korobka_peredach_plus = $("label[data-gaq='korobka-peredach_plus']");
    private SelenideElement raskhod_topliva_minus = $("label[data-gaq='raskhod-topliva_minus']");
    private SelenideElement raskhod_topliva_plus = $("label[data-gaq='raskhod-topliva_plus']");
    private SelenideElement dinamika_minus = $("label[data-gaq='dinamika_minus']");
    private SelenideElement dinamika_plus = $("label[data-gaq='dinamika_plus']");
    private SelenideElement upravlyaemost_minus = $("label[data-gaq='upravlyaemost_minus']");
    private SelenideElement upravlyaemost_plus = $("label[data-gaq='upravlyaemost_plus']");
    private SelenideElement tormoza_minus = $("label[data-gaq='tormoza_minus']");
    private SelenideElement tormoza_plus = $("label[data-gaq='tormoza_plus']");
    private SelenideElement shumoizolyacziya_minus = $("label[data-gaq='shumoizolyacziya_minus']");
    private SelenideElement shumoizolyacziya_plus = $("label[data-gaq='shumoizolyacziya_plus']");
    private SelenideElement kachestvosborki_minus = $("label[data-gaq='kachestvo-sborki_minus']");
    private SelenideElement kachestvosborki_plus = $("label[data-gaq='kachestvo-sborki_plus']");
    private SelenideElement stoimost_obsluzhivaniya_minus = $("label[data-gaq='stoimost-obsluzhivaniya_minus']");
    private SelenideElement stoimost_obsluzhivaniya_plus = $("label[data-gaq='stoimost-obsluzhivaniya_plus']");
    private SelenideElement dorozhnyj_prosve_minus = $("label[data-gaq='dorozhnyj-prosve_minus']");
    private SelenideElement dorozhnyj_prosve_plus = $("label[data-gaq='dorozhnyj-prosve_plus']");
    private SelenideElement dizajn_kuzova_minus = $("label[data-gaq='dizajn-kuzova_minus']");
    private SelenideElement dizajn_kuzova_plus = $("label[data-gaq='dizajn-kuzova_plus']");
    private SelenideElement obem_bagazhnika_minus = $("label[data-gaq='obem-bagazhnika_minus']");
    private SelenideElement obem_bagazhnika_plus = $("label[data-gaq='obem-bagazhnika_plus']");
    private SelenideElement prostor_salona_minus = $("label[data-gaq='prostor-salona_minus']");
    private SelenideElement prostor_salona_plus = $("label[data-gaq='prostor-salona_plus']");
    private SelenideElement kachestvo_materialov_minus = $("label[data-gaq='kachestvo-materialov_minus']");
    private SelenideElement kachestvo_materialov_plus = $("label[data-gaq='kachestvo-materialov_plus']");
    private SelenideElement czena_minus = $("label[data-gaq='czena_minus']");
    private SelenideElement czena_plus = $("label[data-gaq='czena_plus']");
    private ElementsCollection plusAndMinus = $$x("//div[@class='item ']");
    
    private SelenideElement buttonAddrewiev = $("input[type='submit']");

    private SelenideElement addFoto = $x("//span[@class='label-upload-foto']");

    public SelenideElement reviewsText = $("h3[class$='mob'] a[data-gaq*='reviews']");
    Faker faker = new Faker();




    public static ReviewPage getInstance() {
        return new ReviewPage();
    }
    @Step("Input  characteristics auto")
    public void inputVehiclecharacteristics(String marka, String modelName) {
        categoryId.shouldBe(visible).shouldBe(clickable).selectOption("Легкові");
        markaId.shouldBe(visible).shouldBe(clickable).setValue(marka);
        autoColletion.find(innerText(marka)).click();
        model.shouldBe(visible).shouldBe(clickable).setValue(modelName);
        modelCollection.filterBy(textCaseSensitive(modelName)).find(not(textCaseSensitive("Grand"))).click();
        selectYear.shouldBe(visible).shouldBe(clickable).selectOption("2018");
        selectBody.shouldBe(visible).shouldBe(clickable).shouldHave(text("Кросовер"));
        selectfuelId.shouldBe(visible).shouldBe(clickable).selectOption("Бензин");
        driveType.shouldBe(visible).shouldBe(clickable).selectOption("Повний");
        gearType.shouldBe(visible).shouldBe(clickable).selectOption("Автомат");
        odometer.shouldBe(visible).shouldBe(clickable).setValue("45");
        fuelConsumption.shouldBe(visible).shouldBe(clickable).setValue("7.5");
    }

    @Step("Input feedback user")
    public SelenideElement inputYourFeedback() {
        firstBayer.shouldBe(visible).shouldNotBe(checked).click();
        userName.shouldBe(visible).setValue(faker.name().fullName());
        timeDriving.shouldBe(visible).shouldBe(clickable).selectOption(5);
        timeOwning.shouldBe(visible).shouldBe(clickable).selectOption(5);
        usingType.shouldBe(visible).shouldBe(clickable).selectOption("Сім'я");
        textReview.shouldBe(visible).shouldBe(clickable).setValue(faker.lorem().paragraph(5));
           inputYourAppinoinV2();
        setRating(1, 4);
        setRating(2, 5);
        setRating(3, 5);
        setRating(4, 5);
        setRating(5, 5);

//     buttonAddrewiev.should(visible).shouldBe(clickable).click();
     return reviewsText.shouldBe(visible, Duration.ofSeconds(20));

    }
    @Step("Input opinion user")
    public void inputYourAppinoinV2() {
        korobka_peredach_minus.scrollIntoView(true);
        setKorobka_peredach(true);
        setRaskhod_topliva(true);
        setDinamika(true);
        setUpravlyaemost(true);
        setTormoza(true);
        setShumoizolyacziya(false);
        setKachestvosborki(true);
        setStoimost_obsluzhivaniya(true);
        setDorozhnyj_prosve(true);
        setDizajn_kuzova(true);
        setObem_bagazhnika(true);
        setProstor_salona(true);
        kachestvo_materialov_minus.scrollIntoView(true);
        setKachestvo_materialov(true);
        setCzena(true);
    }

    @Step("Input rating auto")
    public void  setRating(int numberRaiting, int grade){
        $("label[for='type"+numberRaiting+"-val"+grade+"']").click();
    }


    public void setKorobka_peredach(boolean plusOrMinus) {
        korobka_peredach_plus.shouldBe(visible).should(appear);
        korobka_peredach_plus.shouldBe(visible).should(appear);
        if (plusOrMinus) {
            korobka_peredach_plus.click();
        } else {
            korobka_peredach_minus.click();
        }
    }

    public void setRaskhod_topliva(boolean plusOrMinus) {
        raskhod_topliva_plus.shouldBe(visible).should(clickable);
        raskhod_topliva_minus.shouldBe(visible).should(clickable);
        if (plusOrMinus) {
            raskhod_topliva_plus.click();
        } else {
            raskhod_topliva_minus.click();
        }
    }

    public void setDinamika(boolean plusOrMinus) {
        dinamika_plus.shouldBe(visible).should(clickable);
        dinamika_minus.shouldBe(visible).should(clickable);
        if (plusOrMinus) {
            dinamika_plus.click();
        } else {
            dinamika_minus.click();
        }
    }

    public void setUpravlyaemost(boolean plusOrMinus) {
        upravlyaemost_plus.shouldBe(visible).should(clickable);
        upravlyaemost_minus.shouldBe(visible).should(clickable);
        if (plusOrMinus) {
            upravlyaemost_plus.click();
        } else {
            upravlyaemost_minus.click();
        }
    }

    public void setTormoza(boolean plusOrMinus) {
        tormoza_plus.shouldBe(visible).should(clickable);
        tormoza_minus.shouldBe(visible).should(clickable);
        if (plusOrMinus) {
            tormoza_plus.click();
        } else {
            tormoza_minus.click();
        }
    }

    public void setShumoizolyacziya(boolean plusOrMinus) {
        shumoizolyacziya_plus.shouldBe(visible).should(clickable);
        shumoizolyacziya_minus.shouldBe(visible).should(clickable);
        if (plusOrMinus) {
            shumoizolyacziya_plus.click();
        } else {
            shumoizolyacziya_minus.click();
        }
    }

    public void setKachestvosborki(boolean plusOrMinus) {
        kachestvosborki_plus.shouldBe(visible).should(clickable);
        kachestvosborki_minus.shouldBe(visible).should(clickable);
        if (plusOrMinus) {
            kachestvosborki_plus.click();
        } else {
            kachestvosborki_minus.click();
        }
    }

    public void setStoimost_obsluzhivaniya(boolean plusOrMinus) {
        stoimost_obsluzhivaniya_plus.shouldBe(visible).should(clickable);
        stoimost_obsluzhivaniya_minus.shouldBe(visible).should(clickable);
        if (plusOrMinus) {
            stoimost_obsluzhivaniya_plus.click();
        } else {
            stoimost_obsluzhivaniya_minus.click();
        }
    }

    public void setDorozhnyj_prosve(boolean plusOrMinus) {
        dorozhnyj_prosve_plus.shouldBe(visible).should(clickable);
        dorozhnyj_prosve_minus.shouldBe(visible).should(clickable);
        if (plusOrMinus) {
            dorozhnyj_prosve_plus.click();
        } else {
            dorozhnyj_prosve_minus.click();
        }
    }

    public void setDizajn_kuzova(boolean plusOrMinus) {
        dizajn_kuzova_plus.shouldBe(visible).should(clickable);
        dizajn_kuzova_minus.shouldBe(visible).should(clickable);
        if (plusOrMinus) {
            dizajn_kuzova_plus.click();
        } else {
            dizajn_kuzova_minus.click();
        }
    }

    public void setObem_bagazhnika(boolean plusOrMinus) {
        obem_bagazhnika_plus.shouldBe(visible).should(clickable);
        obem_bagazhnika_minus.shouldBe(visible).should(clickable);
        if (plusOrMinus) {
            obem_bagazhnika_plus.click();
        } else {
            obem_bagazhnika_minus.click();
        }
    }

    public void setProstor_salona(boolean plusOrMinus) {
        prostor_salona_plus.shouldBe(visible).should(clickable);
        prostor_salona_minus.shouldBe(visible).should(clickable);
        if (plusOrMinus) {
            prostor_salona_plus.click();
        } else {
            prostor_salona_minus.click();
        }
    }

    public void setKachestvo_materialov(boolean plusOrMinus) {
        kachestvo_materialov_plus.shouldBe(visible).should(clickable);
        kachestvo_materialov_minus.shouldBe(visible).should(clickable);
        if (plusOrMinus) {
            kachestvo_materialov_plus.click();
        } else {
            kachestvo_materialov_minus.click();
        }
    }

    public void setCzena(boolean plusOrMinus) {
        czena_plus.shouldBe(visible).should(clickable);
        czena_minus.shouldBe(visible).should(clickable);
        if (plusOrMinus) {
            czena_plus.click();
        } else {
            czena_minus.click();
        }
    }
}
