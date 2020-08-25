package class1;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import lombok.Data;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class DeliveryCard {

    private Faker faker;

    @BeforeEach
    void setUpAll() {
        Configuration.browser = "firefox";
        Configuration.startMaximized = Boolean.parseBoolean("true");

        faker = new Faker(new Locale("ru"));
    }
    @Test
    void shoudDeliveryCard() {
        Date nowDate = Date.from(LocalDate.now().plusDays(3).atStartOfDay(ZoneId.systemDefault()).toInstant());
        String date = new SimpleDateFormat("dd.MM.yyyy").format(faker.date().future(10, TimeUnit.DAYS, nowDate));

        Annotation forms = new Annotation(faker.name().fullName(), faker.phoneNumber().phoneNumber(), faker.address().city(), date);

        open("http://localhost:9999");
        $("[placeholder='Город']").setValue(forms.getCity());
        $("[placeholder='Дата встречи']").setValue(forms.getDate()).clear();
        $("[placeholder='Дата встречи']").setValue(forms.getDate());
        $("[data-test-id=name] input").setValue(forms.getName());
        $("[data-test-id=phone] input").setValue(forms.getPhone());
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Запланировать")).click();
        $("[data-test-id=success-notification]").find(withText("Успешно!"));

    }
}
