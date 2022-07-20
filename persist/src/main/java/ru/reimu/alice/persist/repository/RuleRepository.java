package ru.reimu.alice.persist.repository;

import org.springframework.data.jpa.repository.Query;
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

    @Query(value = "select * from rule_info where data_state = 2 " +
            "and kie_base_name = ?1 " +
            "and kie_package_name = ?2", nativeQuery = true)
    RuleEntity findByRuleName(String kieBaseName, String kiePackageName);
}
