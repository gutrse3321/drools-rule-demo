package ru.reimu.alice.drools;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-07-20 11:25
 */
@ConfigurationProperties(prefix = "appserver.drools")
public class DroolsEngineProperties {

    private boolean enabled = false;
}
