package ru.reimu.alice.persist.entity;

import lombok.Data;
import ru.reimu.alice.datasource.jpa.entity.BaseEntity;

import javax.persistence.*;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-07-20 15:43
 */
@Data
@Entity
@Table(name = "rule_info")
public class RuleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;               //bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    @Column(name = "kie_base_name")
    private String kieBaseName;    //varchar(64) DEFAULT NULL COMMENT 'kbase会话名称',
    @Column(name = "kie_package_name")
    private String kiePackageName; //varchar(128) DEFAULT NULL COMMENT '虚拟包包名',
    @Column(name = "rule_content")
    private String ruleContent;    //varchar(2048) DEFAULT NULL COMMENT '规则内容',
}
