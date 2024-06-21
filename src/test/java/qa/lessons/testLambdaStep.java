package qa.lessons;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class testLambdaStep {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE = 85;

    @Test
    public void selenideIssueSearch() {
        SelenideLogger.addListener("allure",new AllureSelenide());

        step("Open the main page", () -> {
                    open("https://github.com");
                });
        step("Search git repo", () -> {
                    $(".search-input-container").click();
                    $("#query-builder-test").sendKeys(REPOSITORY);
                    $("#query-builder-test").submit();
                });
        step("Click on repo ling", () -> {
                    $(linkText(REPOSITORY)).click();
                });
        step("Open tab issues", () -> {
                    $("#issues-tab").click();
                });
        step("Verify issues with number", () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    @Test
    public void testAnnotatedStep() {
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE);
    }

}
