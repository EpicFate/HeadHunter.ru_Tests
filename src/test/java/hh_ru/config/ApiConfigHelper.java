package hh_ru.config;

import org.aeonbits.owner.ConfigFactory;

public class ApiConfigHelper {

    public static String getBody() {
        return getConfig().Body();
    }

    public static String getCookie() {
        return getConfig().Cookie();
    }

    public static String getContentType() {
        return getConfig().ContentType();
    }

    public static String getPost() {
        return getConfig().Post();
    }

    private static ApiConfig getConfig() {
        return ConfigFactory.newInstance().create(ApiConfig.class);
    }
}
