package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import data.DataGenerator;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.LoginPage;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static data.DataGenerator.Registration.generateByCard;


public class DeliveryCard {

    @BeforeEach
    void setUpAll() {
        Configuration.browser = "firefox";
        Configuration.startMaximized = Boolean.parseBoolean("true");
    }

    @Test
    void shoudDeliveryCard() {

        val loginPage = new LoginPage ();
        LoginPage.openLoginPage();
        LoginPage.loginValid(generateByCard());
    }
}
