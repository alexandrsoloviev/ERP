package ru.erp.teachmeskills.pages.PageElements;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class Button {

    public void clickButton(String buttonText){
        $(byTagAndText("button",buttonText)).click();
    }
}
