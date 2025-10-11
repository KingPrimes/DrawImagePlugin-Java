package io.github.kingprimes.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Market 市场 杜卡币数据
 */
@Data
@Accessors(chain = true)
public class Ducats {

    Previous payload;

    /**
     * 银垃圾列表
     */
    Map<DumpType, List<Ducat>> silverDump;
    /**
     * 金垃圾列表
     */
    Map<DumpType, List<Ducat>> goldDump;

    public enum DumpType {
        /**
         * 当天
         */
        DAY,
        /**
         * 每小时
         */
        HOUR
    }

    @Data
    @Accessors(chain = true)
    public static class Ducat {
        /**
         * 时间
         */
        LocalDateTime dateTime;

        /**
         * 杜卡币
         */
        Integer ducats;

        /**
         * 1白金=?杜卡币
         */
        Double ducatsPerPlatinum;

        /**
         * 1白金=?杜卡币 实时
         */
        Double ducatsPerPlatinumWa;

        /**
         * 当前ID
         */
        String id;

        /**
         * 物品Id
         */
        String item;

        /**
         * 中位数
         */
        Integer median;

        /**
         * 平台价值
         */
        Float platWorth;

        /**
         * 日变动
         */
        Integer positionChangeDay;

        /**
         * 周变动
         */
        Integer positionChangeWeek;

        /**
         * 月变动
         */
        Integer positionChangeMonth;

        /**
         * 存货
         */
        Integer volume;

        /**
         * 均价
         */
        Double waPrice;
    }

    @Data
    @Accessors(chain = true)
    public static class Previous {
        List<Ducat> previousDay;
        List<Ducat> previousHour;
    }
}
