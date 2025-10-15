package io.github.kingprimes.model.enums;

import lombok.Getter;

/**
 * 订阅任务类型枚举
 *
 * @author KingPrimes
 * @version 1.0.0
 */
@Getter
public enum SubscribeEnums {


    /**
     * 错误
     */
    ERROR("没有此数值！"),
    /**
     * 警报
     */
    ALERTS("警报"),
    /**
     * 仲裁
     */
    ARBITRATION("仲裁"),
    /**
     * 夜灵平野
     */
    CETUS_CYCLE("夜灵平野"),
    /**
     * 每日特惠
     */
    DAILY_DEALS("每日特惠"),
    /**
     * 活动
     */
    EVENTS("活动"),
    /**
     * 入侵
     */
    INVASIONS("入侵"),
    /**
     * 钢铁兑换
     */
    STEEL_PATH("钢铁兑换"),
    /**
     * 奸商
     */
    VOID("奸商"),
    /**
     * 裂隙
     */
    FISSURES("裂隙"),
    /**
     * 新闻
     */
    NEWS("新闻"),
    /**
     * 电波
     */
    NIGHTWAVE("电波"),
    /**
     * 突击
     */
    SORTIE("突击"),

    /**
     * 执政官突击
     */
    ARCHON_HUNT("执政官突击"),

    /**
     * 双衍王境
     */
    DUVIRI_CYCLE("双衍王境"),

    ;


    private final String NAME;


    SubscribeEnums(String name) {
        this.NAME = name;
    }


}
