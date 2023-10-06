package ru.erp.teachmeskills.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {
    private final SelenideElement emailInput = $("[name=email]"),
                                  passwordInput = $("[name=password]"),
                                  logInButton = $(byText("Войти в систему")),
                                  authForm = $("form");

    public void openLoginPage() {
        open("/login");
    }

    public void setEmailValue(String email) {
        emailInput.setValue(email);
    }

    public void setPasswordValue(String pass) {
        passwordInput.setValue(pass);
    }

    public void clickLogInButton() {
        logInButton.click();
    }

    @Override
    public boolean isPageOpened() {
        return isExist(authForm);
    }
}
