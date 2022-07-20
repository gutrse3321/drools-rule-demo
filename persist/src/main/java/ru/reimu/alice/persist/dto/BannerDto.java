package ru.reimu.alice.persist.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-05-21 12:39
 *
 * banner信息表
 */
@Data
public class BannerDto {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;           //bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    private String name;       //varchar(64) NOT NULL COMMENT 'banner名称',
    private Integer type;      //tinyint(1) NOT NULL COMMENT 'banner类型【BannerType枚举类具体描述】',
    private String coverUrl;   //varchar(255) NOT NULL COMMENT '封面地址',
    private String target;     //varchar(255) DEFAULT NULL COMMENT '目标指向【外链，内链，id...】',
    @JsonSerialize(using = ToStringSerializer.class)
    private Double keepTime;   //double(4,3) NOT NULL DEFAULT 1.000 COMMENT '展示时间，秒级',
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
