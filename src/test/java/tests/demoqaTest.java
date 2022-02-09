package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class demoqaTest {
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
        $(".custom-control-input#gender-radio-1 + label").click();
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
        $(".table-responsive").shouldHave(text("Alex Ovechkin"));
        $(".table-responsive").shouldHave(text("Alex@email.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("10 May,1990"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("flat.jpeg"));
        $(".table-responsive").shouldHave(text("Abrakadabra"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));
        $("#closeLargeModal").click();
        $(".modal-content").shouldNotBe(visible);
    }
}
