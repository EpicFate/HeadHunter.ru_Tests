package hh_ru.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static String getWebBrowser() {
        return getWebConfig().webBrowser();
    }

    public static String getWebRemoteDriver() {
        return "https://" + getWebConfig().webRemoteDriverUser() + ":" +
                getWebConfig().webRemoteDriverPassword() + "@" +
                getWebConfig().webRemoteDriverUrl() + "/wd/hub";
    }

    public static boolean isRemoteWebDriver() {
        return !getWebConfig().webRemoteDriverUrl().equals("");
    }

    public static String getHHruEmail() {
        return getAuthorizationConfig().HHruEmail();
    }

    public static String getHHruPassword() {
        return getAuthorizationConfig().HHruPassword();
    }

    private static WebConfig getWebConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }

    private static AuthorizationConfig getAuthorizationConfig() {
        return ConfigFactory.newInstance().create(AuthorizationConfig.class, System.getProperties());
    }
}
