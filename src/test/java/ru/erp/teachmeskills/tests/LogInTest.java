package ru.erp.teachmeskills.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.erp.teachmeskills.config.erp.App;
import ru.erp.teachmeskills.pages.LoginPage;
import ru.erp.teachmeskills.pages.StudentPage;



import static io.qameta.allure.Allure.step;



public class LogInTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    StudentPage studentPage = new StudentPage();

    @BeforeAll
    static void configureBaseUrl() {

        Configuration.baseUrl = App.config.webUrl();
    }


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
            loginPage.setEmailValue(App.config.userLogin());
        });
        step("Ввести пароль администратора", () -> {
            loginPage.setPasswordValue(App.config.userPassword());
        });
        step("Нажать кнопку 'Войти в систему'", () -> {
            loginPage.clickLogInButton();
        });
        step("Администратор просматривает страницу студенты", () -> {
            studentPage.isPageOpened();
        });
    }


}
