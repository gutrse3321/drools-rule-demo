package ru.reimu.alice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.reimu.alice.constant.ErrorCode;
import ru.reimu.alice.drools.config.IDroolsService;
import ru.reimu.alice.drools.RuleManager;
import ru.reimu.alice.drools.model.RuleDataModel;
import ru.reimu.alice.exception.EXPF;
import ru.reimu.alice.persist.entity.RuleEntity;
import ru.reimu.alice.persist.repository.RuleRepository;

import javax.annotation.Resource;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-07-20 15:41
 */
@Service
public class DroolsService implements IDroolsService<RuleEntity> {

    @Resource
    private RuleManager ruleManager;
    @Resource
    RuleRepository ruleRepository;

    /**
     * 触发值，简易版，固定返回为String
     * @param kieBaseName
     * @param insertParam
     * @return
     * @throws Exception
     */
    public RuleDataModel<Object> triggerRule(String kieBaseName,
                                             Integer insertParam) throws Exception {
        return ruleManager.fireRule(kieBaseName, insertParam);
    }

    /**
     * 添加
     *
     * @param entity
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insertRule(RuleEntity entity) throws Exception {
        ruleRepository.save(entity);
        //添加到drools会话容器
        ruleManager.addOrUpdateRule(entity.getId(), entity.getKieBaseName(), entity.getKiePackageName(),
                entity.getRuleContent());
    }

    /**
     * 修改
     *
     * @param entity
     */
    @Override
    public void updateRule(RuleEntity entity) throws Exception {
        RuleEntity rule = ruleRepository.extFindOne(entity.getId());
        if (rule == null) {
            throw EXPF.exception(ErrorCode.DataNotExists, "规则不存在", true);
        }

        RuleEntity findByName = ruleRepository.findByRuleName(entity.getKieBaseName(), entity.getKiePackageName());
        if (findByName != null && !rule.getId().equals(findByName.getId())) {
            throw EXPF.exception(ErrorCode.DataDuplicated, "此规则已在此分组存在", true);
        }
        ruleRepository.save(entity);
        //添加到drools会话容器
        ruleManager.addOrUpdateRule(entity.getId(), entity.getKieBaseName(), entity.getKiePackageName(),
                entity.getRuleContent());
    }

    /**
     * 根据ruleName、ruleId删除
     *
     * @param entity
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void deleteRule(RuleEntity entity,
                           String ruleName) throws Exception {
        RuleEntity rule = ruleRepository.extFindOne(entity.getId());
        if (rule == null) {
            throw EXPF.exception(ErrorCode.DataNotExists, "规则不存在", true);
        }

        ruleRepository.extDeleteByPhysically(entity.getId());
        ruleManager.deleteDroolsRule(entity.getKieBaseName(), entity.getKiePackageName(), ruleName);
    }
}
