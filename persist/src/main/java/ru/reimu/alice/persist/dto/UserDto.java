package ru.reimu.alice.persist.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import ru.reimu.alice.persist.entity.AppUserAuthEntity;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-05-14 19:11
 *
 * 用户信息
 */
@Data
public class UserDto {

    private String uid;         //varchar(64) NOT NULL COMMENT '主键id',
    private String name;        //varchar(64) NOT NULL COMMENT '用户名称',
    private Integer gender;     //tinyint(1) NOT NULL COMMENT '性别【0=未知，1=男，2=女】',
    private String avatarUrl;   //varchar(255) NOT NULL COMMENT '头像地址',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long lastLoginTime; //bigint(20) DEFAULT NULL COMMENT '最后登录时间',
    private Integer coin;       //int(4) NOT NULL DEFAULT 0 COMMENT '金币',

    AppUserAuthEntity auth; //授权信息
}
