package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableOfRegistration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement firstNameLocator = $("#firstName");
    private SelenideElement lastNameLocator = $("#lastName");
    private SelenideElement userEmailLocator = $("#userEmail");
    private SelenideElement genderLocator = $("#genterWrapper");
    private SelenideElement userNumberLocator = $("#userNumber");
    private SelenideElement dateOfBirthLocator = $("#dateOfBirthInput");
    private SelenideElement subjectsLocator = $("#subjectsInput");
    private SelenideElement hobbiesLocator = $("#hobbiesWrapper");
    private SelenideElement uploadPictureLocator = $("#uploadPicture");
    private SelenideElement currentAddressLocator = $("#currentAddress");
    private SelenideElement stateCityWrapperLocator = $("#stateCity-wrapper");
    private SelenideElement stateLocator = $("#state");
    private SelenideElement cityLocator = $("#city");
    private SelenideElement submitButtonLocator = $("#submit");

    private String resultTableLocator = ".table-responsive";

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultTableOfRegistration resultTableOfRegistration = new ResultTableOfRegistration();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameLocator.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameLocator.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailLocator.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderLocator.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberLocator.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthLocator.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsLocator.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbiesLocator.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPictureLocator.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddressLocator.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateLocator.click();
        stateCityWrapperLocator.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityLocator.click();
        stateCityWrapperLocator.$(byText(value)).click();
        return this;
    }

    public void pushSubmitButton() {
        submitButtonLocator.click();
    }

    public RegistrationPage checkResult(String key, String value) {

        resultTableOfRegistration.checkResultOfRegistration(resultTableLocator,key, value);
        return this;
    }
    public void checkNegativeResult() {
        resultTableOfRegistration.checkNegativeResult(resultTableLocator);
    }


}
