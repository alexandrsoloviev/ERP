package ru.erp.teachmeskills.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.erp.teachmeskills.config.Project;
import ru.erp.teachmeskills.drivers.UIDriver;
import ru.erp.teachmeskills.helpers.Attach;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.openqa.selenium.remote.HttpSessionId.getSessionId;
import static ru.erp.teachmeskills.helpers.Attach.*;

public class BaseTest {

    protected final String email = System.getProperty("USER_EMAIL");   //"ul.erp@yopmail.com"
    protected final String pass = System.getProperty("USER_PASS");                 //"Ulerp123";

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        selectDriver();
    }

    private static void selectDriver() {
        switch (Project.config.runIn()) {
            case "browser_selenoid":
            case "browser_local":
                UIDriver.configure();
                break;

        }
    }



    @AfterEach
    @Step("Save artifacts and close webdriver")
    public void afterEach() {
        screenshotAs("Last screenshot");
        pageSource();
        closeWebDriver();
    }


    }


//    @BeforeAll
//    static void beforeAll() {
//        Configuration.baseUrl = "http://erp-tms.s3-website.eu-central-1.amazonaws.com";
//        Configuration.browser = "chrome";
////        Configuration.browserVersion = "100.0";
//        Configuration.browserSize = "1920x1080";
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//
//        Configuration.browserCapabilities = capabilities;
//    }
//
//    @BeforeEach
//    void addListener() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//    }
//
//    @AfterEach
//    void addAttachments() {
//        Attach.screenshotAs("Last screenshot");
//        Attach.pageSource();
//        Attach.browserConsoleLogs();
//        Attach.addVideo();
//        getWebDriver().quit();
//    }




//    @BeforeEach
//     void beforeAll() {
//        Configuration.baseUrl = "http://erp-tms.s3-website.eu-central-1.amazonaws.com";
//        Configuration.browserSize = "1920x1080";
//    }
//
//    @AfterEach
//    void afterEach(){
//        getWebDriver().quit();
//    }
