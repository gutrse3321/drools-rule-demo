package ru.reimu.alice.appserver.rule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import ru.reimu.alice.datasource.jpa.config.JpaAutoConfiguration;
import ru.reimu.alice.drools.RuleManager;
import ru.reimu.alice.drools.config.RuleManagerConfiguration;
import ru.reimu.alice.persist.entity.RuleEntity;
import ru.reimu.alice.persist.repository.RuleRepository;

import java.util.List;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-07-21 15:14
 *
 * 生成数据库持久化规则到drools会话容器
 */
@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "appserver.drools", name = "enabled")
@AutoConfigureAfter({JpaAutoConfiguration.class, RuleManagerConfiguration.class})
public class GenDbRuleCacheConfiguration {

    private final RuleRepository ruleRepository;
    private final RuleManager ruleManager;

    public GenDbRuleCacheConfiguration(RuleRepository ruleRepository,
                                       RuleManager ruleManager) {
        this.ruleRepository = ruleRepository;
        this.ruleManager = ruleManager;
        this.cache();
    }

    private void cache() {
        log.warn("===============【初始化规则引擎规则会话】===============");
        List<RuleEntity> list = ruleRepository.getAll();
        list.forEach(r -> {
            try {
                ruleManager.addOrUpdateRule(r.getId(), r.getKieBaseName(), r.getKiePackageName(), r.getRuleContent());
            } catch (Exception e) {
                log.warn("---->【规则会话启用失败】kieBaseName: {} kiePackageName: {}, ruleId: {} | {}", r.getKieBaseName(),
                        r.getKiePackageName(), r.getId(), e.getMessage());
            }
        });
        log.warn("===============【结束 - 初始化规则引擎规则会话】===============");
    }
}
