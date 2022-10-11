package credentials;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/local.properties")
public interface CredentialsConfig extends Config {

    @Key("device")
    String device();

    @Key("os_version")
    String os_version();

    @Config.Key("os_name")
    String os_name();

    @Config.Key("URL")
    String URL();
}


