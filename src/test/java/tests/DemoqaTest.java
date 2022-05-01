package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DemoqaTest {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void checkForm() {
        registrationPage.openPage()
            .setFirstName("Alex")
            .setLastName("Ovechkin")
            .setEmail("Alex@email.com")
            .setGender("Male")
            .setUserNumber("1234567890")
            .setBirthDate("10", "4", "1990")
            .setSubject("Ma")
            .setHobbies("Sports")
            .uploadImage("flat.jpeg")
            .setAddress("Abrakadabra")
            .selectState("Haryana")
            .selectCity("Karnal")
            .submitForm();

        registrationPage.checkForm("Student Name", "Alex" + "Ovechkin")
                .checkForm("Student Email", "Alex@email.com")
                .checkForm("Gender", "Male")
                .checkForm("Mobile", "1234567890")
                .checkForm("Date of Birth", "10 May,1990")
                .checkForm("Subjects", "Maths")
                .checkForm("Hobbies", "Sports")
                .checkForm("Picture", "flat.jpeg")
                .checkForm("Address", "Abrakadabra")
                .checkForm("State and City", "Haryana Karnal");
    }
}
