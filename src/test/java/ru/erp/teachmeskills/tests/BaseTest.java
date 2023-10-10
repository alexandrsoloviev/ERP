package ru.erp.teachmeskills.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.BrowserPerTestStrategyExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.extension.ExtendWith;
import ru.erp.teachmeskills.config.Browser;
import ru.erp.teachmeskills.config.ConfigReader;
import ru.erp.teachmeskills.config.ProjectConfiguration;
import ru.erp.teachmeskills.config.WebConfig;
import ru.erp.teachmeskills.helpers.Attach;
@ExtendWith({BrowserPerTestStrategyExtension.class})

public class BaseTest {

    private static final WebConfig webConfig = ConfigReader.Instance.read();
    private static ProjectConfiguration projectConfiguration = new ProjectConfiguration(webConfig);

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        projectConfiguration.webConfig();
        projectConfiguration.apiConfig();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        if (Configuration.browser.equals(Browser.CHROME.name())) {
            Attach.browserConsoleLogs();
        }
        if (projectConfiguration.isRemote()) {
            Attach.addVideo(projectConfiguration.getVideoStorageUrl());
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
