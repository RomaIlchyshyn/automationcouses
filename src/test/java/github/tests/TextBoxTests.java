package github.tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestData{

    @BeforeAll
    static void setupDriver(){
        WebDriverManager.chromedriver().setup();
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {

        String userName = "Roma";
        String email = "roma@gmail.com";
        String userAddress = "Kyiv";

        open("/text-box");
        $(("#userName")).setValue(userName);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(userAddress);
        $("#permanentAddress").setValue("Kyiv");
        $("#submit").click();

        $("#output").shouldBe(visible);

        $("#name").shouldHave(text(userName));
        $("#email").shouldHave(text(email));

    }
}
