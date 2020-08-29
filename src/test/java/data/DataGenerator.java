package data;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@Data
public class DataGenerator {

    static LocalDate futureDate = LocalDate.now().plusDays(10);
    static String date = DateTimeFormatter.ofPattern("dd.MM.yyyy").format(futureDate);

    public static class Registration {
        private Registration() {
        }

        public static RegistrationByCardInfo generateByCard() {
            Faker faker = new Faker(new Locale("ru"));
            return new RegistrationByCardInfo(
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber(),
                    faker.address().city(),
                    date
            );
        }

        @Data
        @RequiredArgsConstructor
        public static class RegistrationByCardInfo {
            private final String name;
            private final String number;
            private final String address;
            private final String date;
        }
    }
}
