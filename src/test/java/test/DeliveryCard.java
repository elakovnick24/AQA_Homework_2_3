package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import data.DataGenerator;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.LoginPage;

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
