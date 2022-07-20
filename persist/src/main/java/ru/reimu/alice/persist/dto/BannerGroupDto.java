package ru.reimu.alice.persist.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-05-21 12:42
 *
 * banner组信息
 */
@Data
public class BannerGroupDto {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;           //bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    private String name;       //varchar(64) NOT NULL COMMENT '分组名称',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long startTime;    //bigint(20) NOT NULL COMMENT '展示开始时间',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long endTime;      //bigint(20) NOT NULL COMMENT '展示结束时间',
    private String description; //varchar(255) DEFAULT NULL COMMENT '描述',
    private Integer status;    //tinyint(1) NOT NULL DEFAULT 0 COMMENT '启用状态【0=否，1=是】',
    private Integer dataState; //tinyint(1) NOT NULL DEFAULT 2 COMMENT '数据状态【0=删除，1=封禁，2=正常】',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long createdTime;  //bigint(20) DEFAULT NULL COMMENT '创建时间',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long creatorId;    //bigint(20) DEFAULT NULL COMMENT '创建人id',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long updatedTime;  //bigint(20) DEFAULT NULL COMMENT '修改时间',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long updatorId;    //bigint(20) DEFAULT NULL COMMENT '修改人id',

    private List<BannerDto> bannerList = new ArrayList<>(); //banner集
}
