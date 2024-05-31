package github.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;


public class HomeworkSolution extends TestBase {
    @Test
    void formTest() {
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userNumber = faker.number().numberBetween(7926000000L,7926999999L) + "";
        String userAddress = faker.address().city();
        String genderType = "Other";

        String hobbies = "Sports";
        String subject = "Math";

        String fileName = "test.pdf";
        String filePath = "C:\\Users\\Рома\\IdeaProjects\\automationCourses\\src\\test\\resources\\test.pdf";
        String region = "NCR";
        String city = "Delhi";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(genderType)
                .setNumber(userNumber)
                .setBirthDate("30", "June", "2008")
                .chooseSubject(subject)
                .setHobbies(hobbies)
                .addFile(filePath)
                .setAddress(userAddress)
                .selectRegionAndCity(region, city)
                .clickOnSubmit();


        registrationPage.checkResults()
                .verifyResult("Student Name", firstName + " Abubakar")
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", genderType)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", "30 June,2008")
                .verifyResult("Subjects",subject)
                //.verifyResult("Hobbies", hobbies)
                .verifyResult("Picture",fileName)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City",region + " " + city);
    }
}
