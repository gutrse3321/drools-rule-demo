package ru.reimu.alice.service;

import org.springframework.stereotype.Service;
import ru.reimu.alice.drools.IDroolsService;
import ru.reimu.alice.persist.entity.RuleEntity;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-07-20 15:41
 */
@Service
public class DroolsService implements IDroolsService<RuleEntity> {

    /**
     * 添加
     *
     * @param entity
     */
    @Override
    public void insertRule(RuleEntity entity) throws Exception {

    }

    /**
     * 修改
     *
     * @param entity
     */
    @Override
    public void updateRule(RuleEntity entity) throws Exception {

    }

    /**
     * 根据ruleName、ruleId删除
     *
     * @param entity
     */
    @Override
    public void deleteRule(RuleEntity entity) throws Exception {

    }
}
