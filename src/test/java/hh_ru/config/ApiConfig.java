package hh_ru.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:api_properties/AllRussiaToTheBasket.properties"
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
