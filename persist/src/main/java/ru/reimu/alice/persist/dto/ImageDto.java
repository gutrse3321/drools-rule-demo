package ru.reimu.alice.persist.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-05-21 13:38
 *
 * 图片信息
 */
@Data
public class ImageDto {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;             //bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    private String name;         //varchar(64) DEFAULT NULL COMMENT '图片名称',
    private String imageUrl;     //varchar(255) NOT NULL COMMENT '图片地址',
    private Integer width;       //int(4) DEFAULT NULL COMMENT '图片宽度',
    private Integer height;      //int(4) DEFAULT NULL COMMENT '图片高度',
    private Integer price;       //int(4) DEFAULT NULL COMMENT '价格',
    private Integer isStar;      //tinyint(1) DEFAULT NULL COMMENT '是否是精选【0=否，1=是】',
    private Integer downloadNum; //int(4) DEFAULT 0 COMMENT '下载次数',
    private Integer collectNum;  //int(4) DEFAULT 0 COMMENT '收藏次数',
    private Integer viewNum;     //int(4) DEFAULT 0 COMMENT '浏览次数',
    private String description;  //varchar(255) DEFAULT NULL COMMENT '描述',
    private Integer dataState;   //tinyint(1) NOT NULL DEFAULT 2 COMMENT '数据状态【0=删除，1=封禁，2=正常】',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long createdTime;    //bigint(20) DEFAULT NULL COMMENT '创建时间',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long creatorId;      //bigint(20) DEFAULT NULL COMMENT '创建人id',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long updatedTime;    //bigint(20) DEFAULT NULL COMMENT '修改时间',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long updatorId;      //bigint(20) DEFAULT NULL COMMENT '修改人id',

    private List<TagDto> tagList;               //标签列表
    private List<ClassifyInfoDto> classifyList; //分类列表
    private String tagIds;                      //所属标签ids
    private String tagName;                     //所属标签名
    private String classifyIds;                 //所属分类ids
    private String classifyName;                //所属分类名
    private Integer isUserCollect = 0;          //用户是否收藏了此图片【0=否，1=是】
}
