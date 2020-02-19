import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.util.Locale;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class CardDelivery {
    private Faker faker;

    @BeforeEach
    void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }

    @Test
    void shouldScheduleDateOfCardDelivery() {
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue("Петрозаводск").pressEnter();
        $("[type='tel']").sendKeys(Keys.CONTROL, "a");
        $("[type='tel']").sendKeys(Keys.DELETE);
        $("[type='tel']").setValue("25.02.2020");
//        $("[type='tel']").setValue(String.valueOf(LocalDate.now().plusDays(5).getDayOfMonth() + "." + LocalDate.now().getMonthValue() + "." + LocalDate.now().getYear()));
        $("[name='name']").setValue(String.valueOf(faker.name().lastName() + " " + faker.name().firstName()));
        $("[name='phone']").setValue(String.valueOf(faker.phoneNumber().cellPhone()));
        $("[class='checkbox__box']").click();
        $$("button").find(Condition.exactText("Запланировать")).click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);
    }

    @Test
    void shouldRescheduleDateOfDelivery(){

    }
}
