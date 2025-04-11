package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeAll;


import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork_3 {

    File file = new File("src/test/imgs/test_img.jpg");

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "2560x1440";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void FormTest1() throws InterruptedException {
        open("/automation-practice-form");
        $("#firstName").setValue("Паша");
        $("#lastName").setValue("Техник");
        $("#userEmail").setValue("xanax@techique.com");
        $("label[for='gender-radio-1']").click();
        $("#gender-radio-1").shouldBe(selected);
        $("#userNumber").setValue("8800555353");
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__year-select").selectOptionByValue("1990");
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $$(".react-datepicker__day").findBy(Condition.text("24")).click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("body").click(); // снимаем фокус с поля, без этого тест не идет дальше по полям (синий трактор едет к нам...)
        $("label[for='hobbies-checkbox-2']").click();
        $("label[for='hobbies-checkbox-1']").click();
        $("#hobbies-checkbox-2").shouldBe(selected);
        $("#hobbies-checkbox-1").shouldBe(selected);
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("Улица Пушкина, дом Колотушкина");
        $("#state").click();
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Agra").pressEnter();
        $("#submit").click();

        $("table").shouldHave(text("Student Name"), text("Паша Техник"));
        $("table").shouldHave(text("Student Email"), text("xanax@techique.com"));
        $("table").shouldHave(text("Gender"), text("Male"));
        $("table").shouldHave(text("Mobile"), text("8800555353"));
        $("table").shouldHave(text("Date of Birth"), text("24 July,1990"));
        $("table").shouldHave(text("Subjects"), text("Chemistry"));
        $("table").shouldHave(text("Hobbies"), text("Паша Техник"));
        $("table").shouldHave(text("Picture"), text("test_img.jpg"));
        $("table").shouldHave(text("Address"), text("Улица Пушкина, дом Колотушкина"));
        $("table").shouldHave(text("State and City"), text("Uttar Pradesh Agra"));


    }



}