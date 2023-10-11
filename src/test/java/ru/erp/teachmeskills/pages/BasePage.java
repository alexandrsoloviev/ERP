package ru.erp.teachmeskills.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.junit.jupiter.api.BeforeAll;
import ru.erp.teachmeskills.config.erp.App;
import ru.erp.teachmeskills.pages.PageElements.Button;
import ru.erp.teachmeskills.pages.PageElements.Input;

import static com.codeborne.selenide.Condition.visible;


public abstract class BasePage {
    Input input = new Input();
    Button button = new Button();




}
