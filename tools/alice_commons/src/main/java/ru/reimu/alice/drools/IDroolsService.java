package ru.reimu.alice.drools;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-07-20 15:32
 *
 * drools持久化基础接口
 */
public interface IDroolsService<E> {

    /**
     * 添加
     * @param entity
     */
    void insertRule(E entity) throws Exception;

    /**
     * 修改
     * @param entity
     */
    void updateRule(E entity) throws Exception;

    /**
     * 根据ruleName、ruleId删除
     * @param entity
     */
    void deleteRule(E entity,
                    String ruleName) throws Exception;
}
