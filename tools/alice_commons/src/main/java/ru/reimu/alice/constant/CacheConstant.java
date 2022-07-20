package ru.reimu.alice.constant;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @date 2020-09-19 17:17
 */
public class CacheConstant {

    public static final String SPLIST = ":";

    public static final String WECHAT_ALICE_TOKEN = "wechat_alice_token";

    //修改账户和门禁设备关系的锁
    public static final String ENTRANCE_ACCOUNT_UPDATE_LOCK = "entrance_account_update_lock";

    //获取ezcloud的token
    public final static String EZCLOUD_ACCESS_TOKEN = "ezcloud_access_token";

    //摄像头预警列表
    public final static String DEVICE_CAMERA_WARNING = "device_camera_warning";
    //记录合约下的租客的消失时间
    public static final String DEVICE_CAMERA_WARNING_CONTRACT = "device_camera_warning_contract";
    //记录合约下的租客(转租)的消失时间
    public static final String DEVICE_CAMERA_SUBLET_WARNING_CONTRACT = "device_camera_sublet_warning_contract";

    //记录小区、楼栋、单元各级别的设备状态
    public static final String DEVICE_STATE_PLACE_KEEP = "device_state_place_keep";

    //websocket 小区分组
    public static final String WS_VILLAGE_GROUP = "WEBSOCKET_VILLAGE_GROUP";

    //租客三方预警配置
    public static final String TENANT_MANAGE_WARN_CONFIG = "TENANT_MANAGE_WARN_CONFIG";
}
