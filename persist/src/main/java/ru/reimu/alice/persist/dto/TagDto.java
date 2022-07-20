package ru.reimu.alice.persist.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-05-21 14:31
 *
 * 标签信息
 */
@Data
public class TagDto {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;           //bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    private String name;       //varchar(32) NOT NULL COMMENT '标签名称',
    private Integer level;     //int(4) NOT NULL COMMENT '排序等级',
    private String description; //varchar(255) DEFAULT NULL COMMENT '标签描述',
    private Integer dataState; //tinyint(1) NOT NULL DEFAULT 2 COMMENT '数据状态【0=删除，1=封禁，2=正常】',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long createdTime;  //bigint(20) DEFAULT NULL COMMENT '创建时间',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long creatorId;    //bigint(20) DEFAULT NULL COMMENT '创建人id',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long updatedTime;  //bigint(20) DEFAULT NULL COMMENT '修改时间',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long updatorId;    //bigint(20) DEFAULT NULL COMMENT '修改人id',
}
