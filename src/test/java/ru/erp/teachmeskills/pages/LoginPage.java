package ru.erp.teachmeskills.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {
    private final SelenideElement authForm = $("form");

    public void openLoginPage() {
        open("/login");
    }

    public void setEmailValue(String email) {
        input.setValueInInput("Введите Email",email);
    }

    public void setPasswordValue(String pass) {
        input.setValueInInput("Введите пароль",pass);;
    }

    public void clickLogInButton() {
        button.clickButton("Войти в систему");
    }

    @Override
    public boolean isPageOpened() {
        return isExist(authForm);
    }
}
