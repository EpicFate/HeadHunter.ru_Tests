package hh_ru.tests.web;

import com.codeborne.selenide.Configuration;

import hh_ru.drivers.CustomWebDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static hh_ru.helpers.AttachmentsHelper.*;

public class TestBase {
    @BeforeAll
    static void setup() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = CustomWebDriver.class.getName();
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void Attachments(){
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        attachVideo();
        closeWebDriver();
    }
}
