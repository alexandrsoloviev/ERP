package ru.erp.teachmeskills.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class StudentPage extends BasePage{
    private final SelenideElement studentTable = $x("//td[text() ='ФИО студента']/ancestor::table");

    @Override
    public boolean isPageOpened() {
        return isExist(studentTable);
    }
}
