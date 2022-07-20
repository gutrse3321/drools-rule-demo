package ru.reimu.alice.persist.repository;

import org.springframework.stereotype.Repository;
import ru.reimu.alice.datasource.jpa.config.ISimpleRepository;
import ru.reimu.alice.persist.entity.RuleEntity;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-07-20 15:50
 */
@Repository
public interface RuleRepository extends ISimpleRepository<RuleEntity, Long> {
}
