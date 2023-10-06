package ru.erp.teachmeskills.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import ru.erp.teachmeskills.pages.PageElements.Button;
import ru.erp.teachmeskills.pages.PageElements.Input;

import static com.codeborne.selenide.Condition.visible;


public abstract class BasePage {
    Input input = new Input();
    Button button = new Button();

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
