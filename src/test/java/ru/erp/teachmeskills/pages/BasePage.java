package ru.erp.teachmeskills.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;


public abstract class BasePage {
    public abstract boolean isPageOpened();

    public boolean isExist(SelenideElement element) {

        try {
            element.shouldBe(visible);
            return true;
        } catch (ElementNotFound e) {
            return false;
        }
    }
}
