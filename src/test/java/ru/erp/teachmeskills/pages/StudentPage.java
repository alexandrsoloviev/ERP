package ru.erp.teachmeskills.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class StudentPage extends BasePage{
    private final SelenideElement studentTable = $x("//td[text() ='ФИО студента']/ancestor::table");



    public SelenideElement isPageOpened() {
       return studentTable.shouldBe(visible);
    }
}
