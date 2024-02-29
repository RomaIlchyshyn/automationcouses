package github;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setupDriver(){
        WebDriverManager.chromedriver().setup();
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $(("#userName")).setValue("Roma");
        $("#userEmail").setValue("roma@gmail.com");
        $("#currentAddress").setValue("Kyiv");
        $("#permanentAddress").setValue("Kyiv");
        $("#submit").click();

        $("#output").shouldBe(visible);

        $("#name").shouldHave(text("Roma"));
        $("#email").shouldHave(text("roma@gmail.com"));

    }
}
