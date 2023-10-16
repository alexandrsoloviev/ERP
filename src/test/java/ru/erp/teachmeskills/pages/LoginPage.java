package ru.erp.teachmeskills.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {
    private final SelenideElement authForm = $("form");

    public void openLoginPage() {
        open("/login");
    }

    public void setEmailValue(String email) {
        input.setValueInInput("Ввеasasдите Email",email);
    }

    public void setPasswordValue(String pass) {
        input.setValueInInput("Введите пароль",pass);;
    }

    public void clickLogInButton() {
        button.clickButton("Войти в систему");
    }



    public SelenideElement isPageOpened() {
       return  $(authForm).shouldBe(visible);
    }
}
