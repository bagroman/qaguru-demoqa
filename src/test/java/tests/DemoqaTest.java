package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void checkForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ovechkin");
        $("#userEmail").setValue("Alex@email.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__year-select").selectOptionByValue("1990");
        $(".react-datepicker__day--010").click();
        $("#subjectsInput").setValue("Ma").pressEnter();
        $("#hobbiesWrapper").find("#hobbies-checkbox-1 + label").click();
        $("#uploadPicture").uploadFromClasspath("flat.jpeg");
        $("#currentAddress").setValue("Abrakadabra");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").scrollTo().click();

        $(".modal-content").shouldBe(visible);
        $(".table-responsive").shouldHave(text("Alex Ovechkin"),
                text("Alex@email.com"),
                text("Male"),
                text("1234567890"),
                text("10 May,1990"),
                text("Maths"),
                text("Sports"),
                text("flat.jpeg"),
                text("Abrakadabra"),
                text("Haryana Karnal"));
        $("#closeLargeModal").click();
        $(".modal-content").shouldNotBe(visible);
    }
}
