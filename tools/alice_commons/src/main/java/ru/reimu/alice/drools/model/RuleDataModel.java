package ru.reimu.alice.drools.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-07-21 10:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleDataModel<T> {

    private T result;           //返回值
    private String kieBaseName; //kbase会话名称
}
