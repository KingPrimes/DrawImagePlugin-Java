package io.github.kingprimes.model.enums;

import lombok.Getter;

/**
 * 虚空遗物等级枚举
 *
 * @author KingPrimes
 * @version 1.0.0
 */
@Getter
public enum VoidEnum {

    /**
     * 古纪
     */
    VoidT1("古纪"),

    /**
     * 前纪
     */
    VoidT2("前纪"),

    /**
     * 中纪
     */
    VoidT3("中纪"),

    /**
     * 后纪
     */
    VoidT4("后纪"),

    /**
     * 安魂
     */
    VoidT5("安魂"),

    /**
     * 全能
     */
    VoidT6("全能"),
    ;
    private final String name;

    VoidEnum(String name) {
        this.name = name;
    }
}
