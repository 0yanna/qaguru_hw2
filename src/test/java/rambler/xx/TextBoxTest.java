package rambler.xx;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Homework#2")
public class TextBoxTest {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void automationPracticeForm () {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $( "#firstName").setValue("Alex");
        $( "#lastName").setValue("Smith");
        $( "#userEmail").setValue("xx@mail.ru");
        $( "#genterWrapper").$(byText("Male")).click();
                      //$("#gender-radio-1").doubleClick(); working, but why?
        $( "#userNumber").setValue("9110000000");
        $( "#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--031:not(.react-datepicker__day--outside-month)").click();
                      // $$(".react-datepicker__day--030")
                      // .filter(not(cssClass(".react-datepicker__day--outside-month")))
                      /// .first() // or .get(0)
                      /// .click();
                      //  $("[aria-label=Choose Wednesday, July 30th, 2008]").click(); // NOT WORKING
                      //  $("[aria-label=\"Choose Wednesday, July 30th, 2008\"]").click();
                      //  $("[aria-label='Choose Wednesday, July 30th, 2008']").click();
                      //  $("[aria-label$='July 30th, 2008']").click();
                      //  $x("//*[contains(@aria-label, \"July 30th, 2008\")]").click();
                      //  $("#subjectsContainer").setValue("Maths");
                      //  $("#subjectsContainer").setValue("Maths");
                      //  $("#hobbiesWrapper").setValue("id=\"hobbies-checkbox-1\"");
        $("#subjectsInput").setValue("Math").pressEnter();
                      //  $("#subjectsWrapper").$(byText("Math")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/pic.png"));
                     //    File someFile = new File("src/test/resources/img/1.png"); // alternative option
                     //    $("#uploadPicture").uploadFile(someFile);                 // alternative option
                     //    $("#uploadPicture").uploadFromClasspath("img/1.png»);     // second option
        $("#currentAddress").setValue("Some address");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").scrollTo().$(byText("Haryana")).click();
                    //     $("#state").scrollTo().$(byText("Haryana")).click();     // alternative option
        $("#city").click();
        $("#city").$(byText("Karnal")).click();
                    //     $("#city").scrollTo().$(byText("Karnal")).click();     // alternative option
        $("#submit").click();

        // Asserts
        $(".table-responsive").shouldBe(visible);
        $(".table-responsive").shouldHave(text("Alex Smith"), text("xx@mail.ru"), text("Male"),
                text("9110000000"), text("31 January,1990"), text("Math"), text("Sports"), text("pic.jpg"),
                text("Some address"), text("Haryana Karnal"));
        //коммент для второго коммита
        //коммент для третьего коммита
    }
}
