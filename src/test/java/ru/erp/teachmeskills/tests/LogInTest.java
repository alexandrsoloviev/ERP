package ru.erp.teachmeskills.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.erp.teachmeskills.pages.LoginPage;
import ru.erp.teachmeskills.pages.StudentPage;



import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LogInTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    StudentPage studentPage = new StudentPage();
    private final String email = "ul.erp@yopmail.com";
    private final String pass = "Ulerp123";

    @Test
    @Owner("alexandrsoloviev")
    @DisplayName("Открыть страницу авторизации")
    void logInPageIsOpened() {
        step("Открыть страницу login", () -> {
            loginPage.openLoginPage();
        });
        step("Форма авторизации отображается", () -> {
           loginPage.isPageOpened();
        });
    }

    @Test
    @Owner("alexandrsoloviev")
    @DisplayName("Авторизоваться как админмистратор")
    void logInUsAdmin() {
        step("Открыть страницу авторизации", () -> {
            loginPage.openLoginPage();
        });
        step("Ввести email администратора", () -> {
            loginPage.setEmailValue(email);
        });
        step("Ввести пароль администратора", () -> {
            loginPage.setPasswordValue(pass);
        });
        step("Нажать кнопку 'Войти в систему'", () -> {
            loginPage.clickLogInButton();
        });
        step("Администратор просматривает страницу студенты", () -> {
            studentPage.isPageOpened();
        });
    }


}
