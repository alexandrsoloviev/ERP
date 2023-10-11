package ru.erp.teachmeskills.config;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.erp.teachmeskills.config.erp.App;

import java.util.HashMap;

public class ProjectConfiguration {
    private final WebConfig webConfig;

    public ProjectConfiguration(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    public void apiConfig() {
        RestAssured.baseURI = App.config.apiUrl();
    }

    public void webConfig() {
        Configuration.baseUrl = App.config.webUrl();
        Configuration.browser = webConfig.browser().toString();
        Configuration.browserVersion = webConfig.browserVersion();
        Configuration.browserSize = webConfig.browserSize();
        if (webConfig.isRemote()) {
            Configuration.remote = webConfig.remoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {
                {
                    put("enableVNC", true);
                    put("enableVideo", true);
                }
            });

            Configuration.browserCapabilities = capabilities;
        }
    }


    public String getVideoStorageUrl() {
        return webConfig.videoStorage();
    }

    public Boolean isRemote() {
        return webConfig.isRemote();
    }
}