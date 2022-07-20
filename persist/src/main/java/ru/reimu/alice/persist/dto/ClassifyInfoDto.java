package ru.reimu.alice.persist.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-05-20 20:44
 */
@Data
public class ClassifyInfoDto {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;             //'主键id',
    private String coverUrl;     //'封面地址',
    private String name;         //'分类名称',
    private Integer level;       //'排序等级',
    private Integer isRecommend; //是否推荐【0=否，1=是】
    private String description;  //'描述',
    private Integer dataState;   //'数据状态【0=删除，1=封禁，2=正常】',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long createdTime;    //'创建时间',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long creatorId;      //'创建人id',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long updatedTime;    //'修改时间',
    @JsonSerialize(using = ToStringSerializer.class)
    private Long updatorId;      //'修改人id',
}
