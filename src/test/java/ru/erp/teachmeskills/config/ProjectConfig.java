package ru.erp.teachmeskills.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
        "classpath:config/project-${runIn}.properties"})
public interface ProjectConfig extends Config {
    String remoteDriver();
    String baseUrl();
    String browser();
    String browserSize();
    String runIn();
    String user();
    String key();
    String deviceName();
    String platformVersion();
}