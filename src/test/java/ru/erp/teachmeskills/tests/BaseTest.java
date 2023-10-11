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
import ru.erp.teachmeskills.config.erp.App;
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

    @BeforeAll
    static void configureBaseUrl() {

        Configuration.baseUrl = App.config.webUrl();
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

