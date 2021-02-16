package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.EventListener;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    AppiumDriver<MobileElement> driver;
    UserHelper userHelper;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    DesiredCapabilities capabilities;

    public void start() throws IOException {

        capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "qa26");
        capabilities.setCapability( "platformVersion", "8.0");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app",
                "C:/Testing/org.wikipedia.apk");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new AppiumListener());

        logger.info("App version: " );
        userHelper = new UserHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public UserHelper user() {
        return userHelper;
    }
}
