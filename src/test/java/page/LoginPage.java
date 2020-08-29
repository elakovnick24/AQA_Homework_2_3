package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.DataGenerator;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    static SelenideElement authCity = $("[placeholder='Город']");
    static SelenideElement clearInput = $("[placeholder='Дата встречи']");
    static SelenideElement dateMeet = $("[placeholder='Дата встречи']");
    static SelenideElement authName = $("[data-test-id=name] input");
    static SelenideElement authPhone = $("[data-test-id=phone] input");
    static SelenideElement agreeButton = $("[data-test-id=agreement]");
    static ElementsCollection loginButton = $$("button");
    static SelenideElement popUp = $("[data-test-id=success-notification]");

    public static void openLoginPage() {
        open("http://localhost:9999");

    }

    public static void loginValid(DataGenerator.Registration.RegistrationByCardInfo user) {
        authCity.setValue(user.getAddress());
        clearInput.clear();
        dateMeet.setValue(String.valueOf(user.getDate()));
        authName.setValue(user.getName());
        authPhone.setValue(user.getNumber());
        agreeButton.click();
        loginButton.find(exactText("Запланировать")).click();
        popUp.find(withText("Успешно!")).shouldBe(visible);
    }
}
