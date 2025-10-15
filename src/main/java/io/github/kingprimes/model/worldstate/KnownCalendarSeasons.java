package io.github.kingprimes.model.worldstate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 已知日历季节
 * <p>表示1999日历活动的季节信息，包含特定日期的挑战、奖励和升级事件</p>
 * <p>该类继承 {@link BastWorldState} 基类</p>
 *
 * @author KingPrimes
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class KnownCalendarSeasons extends BastWorldState {

    /**
     * 日期事件列表
     * <p>包含特定日期的事件信息，如挑战、奖励和升级</p>
     */
    @JsonProperty("Days")
    private List<Days> days;

    /**
     * 季节枚举
     * <p>表示当前季节，如秋季(CST_FALL)、夏季(CST_SUMMER)等</p>
     */
    @JsonProperty("Season")
    private SeasonEnum season;

    /**
     * 年份迭代次数
     * <p>表示这是第几次该季节循环</p>
     */
    @JsonProperty("YearIteration")
    private Integer yearIteration;

    /**
     * 版本号
     * <p>日历季节的版本标识</p>
     */
    @JsonProperty("Version")
    private Integer version;

    /**
     * 升级可用性要求
     * <p>升级功能可用的前提条件列表</p>
     */
    @JsonProperty("UpgradeAvaliabilityRequirements")
    private List<String> upgradeAvaliabilityRequirements;

    /**
     * 每月天数映射
     * <p>月份与天数的映射关系</p>
     */
    @JsonProperty("MonthDays")
    private Map<?, ?> monthDays;

    /**
     * 处理Days数据，计算自然月和日期
     */
    @JsonIgnore
    public void processDays() {
        if (days == null || days.isEmpty() || season == null) {
            return; // 空数据保护
        }
        int startMonth = 1;
        int[] seasonMonthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 1. 计算每个Days的自然月和日期
        for (Days day : days) {
            int seasonDay = day.getDay(); // 季节累计天数
            int monthIndex = 0;
            int remainingDays = seasonDay;

            // 计算月份索引
            while (monthIndex < seasonMonthDays.length && remainingDays >= seasonMonthDays[monthIndex]) {
                remainingDays -= seasonMonthDays[monthIndex];
                monthIndex++;
            }

            // 设置自然月和当月日期
            day.setMonth(startMonth + monthIndex);
            day.setDay(remainingDays);
        }

        // 2. 按自然月升序、日期升序排序
        days.sort(Comparator.comparingInt(Days::getMonth)
                .thenComparingInt(Days::getDay));
    }

    /**
     * 深拷贝当前对象
     *
     * @return 当前对象的深拷贝副本
     */
    @JsonIgnore
    public KnownCalendarSeasons copy() {
        KnownCalendarSeasons copy = new KnownCalendarSeasons();
        // 拷贝基础属性
        copy.set_id(this.get_id());
        copy.setSeason(this.getSeason());
        copy.setYearIteration(this.getYearIteration());
        copy.setVersion(this.getVersion());
        copy.setActivation(this.getActivation());
        copy.setExpiry(this.getExpiry());
        copy.setUpgradeAvaliabilityRequirements(this.getUpgradeAvaliabilityRequirements());
        // 深拷贝 Days 列表
        if (this.days != null) {
            List<Days> copiedDays = new ArrayList<>(this.days.size()); // 预指定容量
            for (Days day : this.days) {
                copiedDays.add(day.copy());
            }
            copy.setDays(copiedDays);
        }
        return copy;
    }

    /**
     * 日期事件类型枚举
     * <p>定义日历中可能出现的事件类型</p>
     */
    @Getter
    public enum DaysTypeEnum {
        /**
         * 挑战任务类型
         * <p>需要完成特定挑战任务</p>
         */
        CET_CHALLENGE("任务"),

        /**
         * 奖励类型
         * <p>完成条件后可获得奖励</p>
         */
        CET_REWARD("奖励"),

        /**
         * 加成类型
         * <p>提供某种游戏加成效果</p>
         */
        CET_UPGRADE("加成"),
        ;
        private final String displayName;

        DaysTypeEnum(String displayName) {
            this.displayName = displayName;
        }

    }

    /**
     * 季节枚举
     * <p>定义一年中的四个季节</p>
     */
    @Getter
    public enum SeasonEnum {
        /**
         * 秋季
         * <p>通常对应10-12月</p>
         */
        CST_FALL("秋季"),

        /**
         * 夏季
         * <p>通常对应7-9月</p>
         */
        CST_SUMMER("夏季"),

        /**
         * 春季
         * <p>通常对应4-6月</p>
         */
        CST_SPRING("春季"),

        /**
         * 冬季
         * <p>通常对应1-3月</p>
         */
        CST_WINTER("冬季");

        private final String name;

        SeasonEnum(String name) {
            this.name = name;
        }
    }

    /**
     * 日期类
     * <p>表示特定日期及其包含的事件</p>
     */
    @Data
    @Accessors(chain = true)
    public static class Days {
        /**
         * 日期
         * <p>在季节中的第几天(从1开始计算)</p>
         */
        @JsonProperty("day")
        private Integer day;

        /**
         * 事件列表
         * <p>在该日期发生的事件列表</p>
         */
        @JsonProperty("events")
        private List<Events> events;

        /**
         * 月份
         * <p>自然月份(1-12)</p>
         */
        @JsonProperty("month")
        private Integer month;

        /**
         * 深拷贝当前对象
         *
         * @return 当前对象的深拷贝副本
         */
        @JsonIgnore
        public Days copy() {
            Days copy = new Days();
            copy.setDay(this.day);
            copy.setMonth(this.month);
            // 深拷贝 Events 列表
            if (this.events != null) {
                List<Events> copiedEvents = new ArrayList<>(this.events.size()); // 预指定容量
                for (Events event : this.events) {
                    copiedEvents.add(event.copy());
                }
                copy.setEvents(copiedEvents);
            }
            return copy;
        }
    }

    /**
     * 事件类
     * <p>表示日历中的具体事件</p>
     */
    @Data
    @Accessors(chain = true)
    public static class Events {
        /**
         * 事件类型
         * <p>事件的类型，如挑战(CET_CHALLENGE)、奖励(CET_REWARD)或加成(CET_UPGRADE)</p>
         */
        @JsonProperty("type")
        private DaysTypeEnum type;

        /**
         * 奖励
         * <p>事件提供的奖励物品路径</p>
         */
        @JsonProperty("reward")
        private String reward;

        /**
         * 挑战
         * <p>需要完成的挑战任务路径</p>
         */
        @JsonProperty("challenge")
        private String challenge;

        /**
         * 挑战信息
         * <p>挑战的详细信息</p>
         */
        @JsonProperty("challengeInfo")
        private Challenge challengeInfo;

        /**
         * 升级信息
         * <p>升级效果的详细信息</p>
         */
        @JsonProperty("upgradeInfo")
        private Upgrade upgradeInfo;

        /**
         * 升级
         * <p>提供的升级效果路径</p>
         */
        @JsonProperty("upgrade")
        private String upgrade;

        /**
         * 深拷贝当前对象
         *
         * @return 当前对象的深拷贝副本
         */
        @JsonIgnore
        public Events copy() {
            Events copy = new Events();
            copy.setType(this.type);
            copy.setChallenge(this.challenge);
            copy.setReward(this.reward);
            copy.setUpgrade(this.upgrade);
            return copy;
        }

        /**
         * 挑战记录类
         * <p>包含挑战名称和挑战描述的记录类</p>
         *
         * @param name      名称
         * @param challenge 挑战描述
         */
        public record Challenge(String name, String challenge) {
        }

        /**
         * 升级记录类
         * <p>包含升级名称和升级描述的记录类</p>
         *
         * @param name    名称
         * @param upgrade 升级描述
         */
        public record Upgrade(String name, String upgrade) {
        }

    }
}
