package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

public class DemoQaTest1 {

    BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
    }

    @Test
    void FormTest1() {
        open("/automation-practice-form");
        $("#firstName").setValue("Паша");
        $("#lastName").setValue("Техник");
        $("#userEmail").setValue("xanax@techique.travel");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("88005553535");
        $("").setValue("");
        $("#gender-radio-1").click();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    }


}