package ru.reimu.alice.persist.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ru.reimu.alice.persist.dto.BannerDto;
import ru.reimu.alice.persist.dto.BannerGroupDto;

import java.util.List;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-05-21 12:53
 *
 * banner信息表、banner组表、关系表
 */
@Repository
public interface KeepMapper {

    /**
     * 获取当前启用的组
     * @return
     */
    BannerGroupDto getCurrentBannerGroup();

    /**
     * 根据组id获取banner列表
     * @param groupId
     * @return
     */
    List<BannerDto> getGroupBannerList(@Param("groupId") Long groupId);
}
