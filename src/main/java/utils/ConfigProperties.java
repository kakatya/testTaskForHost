package utils;

import org.aeonbits.owner.Config;

@Config.Sources({"file:./src/main/resources/config.properties"})
public interface ConfigProperties extends Config {
    @Key("BROWSER")
    String browser();

    @Key("lang")
    String language();

    @Key("base_url")
    String baseUrl();

}
