package ru.reimu.alice.constant;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @date 2020-09-19 17:18
 */
public class Constant {

    public static final String LICENSE = "aw_alice";
    public static final String ACCESS_TOKEN_SALT = "tankInPussy";
    public static final String REFRESH_TOEKN_SALT = "@@@_¯=¿BigBlackDick";

    public enum DataState {
        Invalid(0),   //删除
        Disable(1),   //无效
        Available(2); //有效

        private Integer val;

        DataState(Integer val) {
            this.val = val;
        }

        public DataState getType(Integer val) {
            this.val = val;
            return this;
        }

        public Integer getVal() {
            return val;
        }
    }

    public enum YesNo {
        FALSE,
        TRUE
    }

    public enum DriversOs {
        Android,
        iOS,
        Web
    }

    /**
     * sql公共符号
     */
    public enum SqlCommonMethod {
        Equal("="),
        UnEqual("!="),
        GreaterThan(">"),
        LessThan("<"),
        GreaterThanOrEqual(">="),
        LessThanOrEqual("<="),
        Instr("instr");

        private String val;

        SqlCommonMethod(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    /**
     * 成功信息
     */
    public enum MsgData {
        Get("获取成功"),
        Add("添加成功"),
        Edit("修改成功"),
        Del("删除成功"),
        Err("操作失败"),
        Send("下发成功"),
        Opt("操作成功");


        private String val;

        MsgData(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    public enum Gender {
        Other,      //未知
        Male,        //男
        Female       //女
    }

    /**
     * banner类型
     */
    public enum BannerType {
        Photo(0),      //纯图片
        AD(1),         //广告
        Classify(2),   //app内的分类
        Tag(3),        //app内的标签
        Html(4);       //网页

        private Integer val;

        BannerType(Integer val) {
            this.val = val;
        }

        public Integer get() {
            return val;
        }

        public static BannerType type(Integer val) {
            return BannerType.values()[val];
        }
    }

    /**
     * 图片与用户关系类型
     */
    public enum UserImageType {
        Download,
        Collect,
        Viewed
    }
}
