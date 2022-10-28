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

    @Key("wait")
    String waits();

    @Key("login")
    String login();

    @Key("password")
    String password();
    @Key("expected_service")
    String expected_service();
    @Key("indicator")
    String indicator();


}
