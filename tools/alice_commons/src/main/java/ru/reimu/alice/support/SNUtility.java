package ru.reimu.alice.support;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Date;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2021-08-18 11:14
 */
@UtilityClass
public class SNUtility {

    private String time(String... args) {
        String format = "yyyyMMdd";
        if (args.length != 0) {
            format = args[0];
        }
        return DateUtility.convertDateTime(new Date(), format);
    }

    public String genBillSn(String type) throws Exception {
        String yyMMdd = time("yyMMdd");
        StringBuilder sb = new StringBuilder();
        sb.append(type);
        sb.append(yyMMdd);
        sb.append(StringUtility.getRandomStr(6, false));
        return sb.toString();
    }

    public String genAfSn(Integer... types) throws Exception {
        String yyyyMMdd = time();
        StringBuilder sb = new StringBuilder();
        if (types.length > 0) {
            Arrays.asList(types).forEach(t -> {
                t = t == null ? 0 : t;
                if (t < 10) {
                    sb.append("0");
                }
                sb.append(t);
            });
        }
        sb.append(yyyyMMdd);
        sb.append(StringUtility.getRandomStr(5, false));
        return sb.toString();
    }

    /**
     * 获取房源编码
     * @param args
     * @return
     * @throws Exception
     */
    public String genHouseSourceCode(Object... args) throws Exception {
        String yyyyMMdd = time();
        StringBuilder sb = new StringBuilder();
        sb.append("F");
        sb.append(yyyyMMdd);
        if (args.length > 0) {
            Arrays.asList(args).forEach(t -> {
                if (t != null) {
                    sb.append(t);
                }
            });
        }
        sb.append(StringUtility.getRandomStr(4, false));
        return sb.toString();
    }
}
