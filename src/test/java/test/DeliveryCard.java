package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import data.DataGenerator;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.LoginPage;

import static data.DataGenerator.Registration.generateByCard;


public class DeliveryCard {

    @BeforeEach
    public void openPage() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = Boolean.parseBoolean("true");
    }
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shoudDeliveryCard() {

        val loginPage = new LoginPage ();
        LoginPage.openLoginPage();
        LoginPage.loginValid(generateByCard());
    }
}
