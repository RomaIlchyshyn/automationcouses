package github;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkSolution extends TestBase {
    @Test
    void formTest() {
        String userName = "Roma";
        String lastName = "Abubakar";
        String email = "roma@gmail.com";
        String genderType = "Other";
        String phoneNumber = "1234567890";
        String hobbies = "Sports";
        String subject = "Math";
        String filePath = "test.pdf";
        String address = "Kyiv";
        String region = "NCR";
        String city = "Delhi";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(genderType)
                .setNumber(phoneNumber)
                .setBirthDate("30", "June", "2008")
                .chooseSubject(subject)
                .setHobbies(hobbies)
                .addFile(filePath)
                .setAddress(address)
                .selectRegionAndCity(region, city)
                .clickOnSubmit();


        registrationPage.checkResults()
                .verifyResult("Student Name", userName + " Abubakar")
                .verifyResult("Student Email", email)
                .verifyResult("Gender", genderType)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", "30 June,2008")
                .verifyResult("Subjects",subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture",filePath)
                .verifyResult("Address", address)
                .verifyResult("State and City",region + " " + city);
    }
}