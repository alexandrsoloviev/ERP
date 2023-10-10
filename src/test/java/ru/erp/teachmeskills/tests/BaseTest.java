package ru.erp.teachmeskills.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.openqa.selenium.remote.DesiredCapabilities;
import ru.erp.teachmeskills.config.Project;
import ru.erp.teachmeskills.helpers.AllureAttachments;
import ru.erp.teachmeskills.helpers.DriverSettings;
import ru.erp.teachmeskills.helpers.DriverUtils;

public class BaseTest {

    protected final String email = System.getProperty("USER_EMAIL");   //"ul.erp@yopmail.com"
    protected final String pass = System.getProperty("USER_PASS");                 //"Ulerp123";

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
//        AllureAttachments.attachNetwork(); // todo
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
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
