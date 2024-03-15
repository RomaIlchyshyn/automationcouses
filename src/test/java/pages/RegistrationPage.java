package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            firstName = $("#firstName"),
            lastNameInput = $("#lastName");
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    public RegistrationPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }
    public RegistrationPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }
    public RegistrationPage setNumber(String number){
        $("#userNumber").setValue(number);
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage checkResults() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }
    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
    public RegistrationPage chooseSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationPage addFile(String path) {
        $("label.custom-control-label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File(path));
        return this;
    }
    public RegistrationPage setAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }
    public RegistrationPage selectRegionAndCity(String region, String city) {
        $("#react-select-3-input").setValue(region).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }
    public void clickOnSubmit(){
        $("#submit").click();

    }

}
