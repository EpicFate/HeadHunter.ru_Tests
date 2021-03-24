package ru.hh.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:api_properties/Basket.properties"
})
public interface ApiConfig extends Config {
    @Key("Body")
    String Body();

    @Key("Cookie")
    String Cookie();

    @Key("ContentType")
    String ContentType();

    @Key("Post")
    String Post();

    @Key("Header")
    String Header();
}
