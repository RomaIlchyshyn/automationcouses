package qa.lessons;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Issue in repo")
    @Story("Issue creating")
    @Owner("eroshenkoam")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Creating issue for authorized used")
    public void testStaticLable() {

    }
    @Test
    @Feature("Issue in repo")
    @Story("Issue deleting")
    @Owner("frozen")
    @DisplayName("Deleting issue from repo")
    public void deleteTest(){

    }
}
