import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginTests {

    WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    void successfulLoginTest() {
        Configuration.holdBrowserOpen = true;
        open("https://practicetestautomation.com/practice-test-login/");
        $("#username").setValue("student");
        $("#password").setValue("Password123");
        $("#submit").click();
        $("p.has-text-align-center").shouldHave(text("Congratulations student. You successfully logged in!"));
    }
    @Test
    void unsuccessfulLoginTest() {

    }
}

