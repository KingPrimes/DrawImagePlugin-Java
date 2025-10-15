package io.github.kingprimes.model.enums;

import lombok.Getter;

/**
 * Warframe 派系:Faction 枚举
 *
 * @author KingPrimes
 * @version 1.0.0
 * @see <a href="https://wiki.warframe.com/w/Factions">Warframe Faction</a>
 */
@Getter
public enum FactionEnum {
    /**
     * Grineer
     */
    FC_GRINEER("Grineer"),

    /**
     * Corpus
     */
    FC_CORPUS("Corpus"),

    /**
     * Infestation
     */
    FC_INFESTATION("Infested"),
    /**
     * 奥罗金
     */
    FC_OROKIN("奥罗金"),
    /**
     * 堕落者
     */
    FC_CORRUPTED("堕落者"),

    /**
     * Sentient
     */
    FC_SENTIENT("Sentient"),

    /**
     * 合一众
     */
    FC_NARMER("合一众"),

    /**
     * 低语者
     */
    FC_MURMUR("低语者"),

    /**
     * 炽蛇军
     */
    FC_SCALDRA("炽蛇军"),

    /**
     * 科腐者
     */
    FC_TECHROT("科腐者"),

    /**
     * 双衍王境
     */
    FC_DUVIRI("双衍王境"),

    /**
     * 墙中人
     */
    FC_MITW("墙中人"),

    /**
     * TENNO
     */
    FC_TENNO("TENNO"),

    /**
     * 未知派系
     */
    FC_NONE("未知派系"),
    ;
    private final String name;

    FactionEnum(String name) {
        this.name = name;
    }
}
