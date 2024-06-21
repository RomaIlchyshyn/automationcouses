package qa.lessons;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Open the main page")
    public void openMainPage() {
        open("https://github.com");
    }
    @Step("Search git repo {repo}")
    public void searchForRepository(String repo) {
        $(".search-input-container").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }
    @Step("Click on repo link {repo}")
    public void clickOnRepository(String repo) {
        $(linkText(repo)).click();
    }
    @Step("Open tab issues")
    public void openIssueTab() {
        $("#issues-tab").click();
    }
    @Step("Verify issues with number {issue}")
    public void shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }

}
