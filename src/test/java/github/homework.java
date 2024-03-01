package github;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class homework {

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void formTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Roma");
        $("#lastName").setValue("Abubakar");
        $("#userEmail").setValue("roma@gmail.com");
        $("label.custom-control-label[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select option[value='9']").click();
        $(".react-datepicker__year-select").click();
        $("option[value='2000']").click();
        $$(".react-datepicker__day").first().click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("label.custom-control-label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File("test.pdf"));
        $("#currentAddress").setValue("Kyiv");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#submit").click();
    }
}
