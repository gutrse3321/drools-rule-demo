package ru.reimu.alice.drools.config;

import org.kie.api.KieServices;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.reimu.alice.drools.RuleManager;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-07-20 11:23
 */
@Configuration
//自动化配置
@ConditionalOnProperty(prefix = "appserver.drools", name = "enabled")
@EnableConfigurationProperties(DroolsEngineProperties.class)
public class RuleManagerConfiguration {

    private DroolsEngineProperties droolsEngineProperties;

    public RuleManagerConfiguration(DroolsEngineProperties droolsEngineProperties) {
        this.droolsEngineProperties = droolsEngineProperties;
    }

    @Bean
    public RuleManager ruleManager() {
        KieServices kieServices = KieServices.get();
        return new RuleManager(
                kieServices,
                kieServices.newKieFileSystem(),
                kieServices.newKieModuleModel()
        );
    }
}
