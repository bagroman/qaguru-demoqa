package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesSelector = $("#hobbiesWrapper"),
            imageUploadInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateSelector = $("#react-select-3-input"),
            citySelector = $("#react-select-4-input"),
            submitButton = $("#submit"),
            resultsTable = $(".table-responsive");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setBirthDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String text) {
        subjectsInput.setValue(text).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobby) {
        hobbiesSelector.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadImage(String classpath) {
        imageUploadInput.uploadFromClasspath(classpath);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public RegistrationPage selectState(String state) {
        stateSelector.setValue(state).pressEnter();
        return this;
    }

    public RegistrationPage selectCity(String city) {
        citySelector.setValue(city).pressEnter();
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.scrollTo().click();
        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }
}