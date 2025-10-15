package io.github.kingprimes.model.worldstate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

/**
 * 魔胎之境
 *
 * <p>此循环计算方式来自 <a href="https://github.com/WFCD/warframe-worldstate-parser">warframe-worldstate-parser</a></p>
 *
 * @author KingPrimes
 * @version 1.0.0
 */
@Setter(AccessLevel.NONE)
@Getter
public final class CambionCycle {
    /**
     * 活动 FASS/VOME
     */
    String active;
    /**
     * 剩余时间
     */
    String timeLeft;
    /**
     * 结束时间
     */
    Instant expiry;
    /**
     * 开始时间
     */
    Instant activation;

    /**
     * 构造函数
     *
     * @param cycle 平原循环 {@link CetusCycle}
     */
    public CambionCycle(CetusCycle cycle) {
        this.activation = cycle.getActivation();
        this.expiry = cycle.getExpiry();
        this.active = cycle.getIsDay() ? "FASS" : "VOME";
        this.timeLeft = cycle.getTimeLeft();
    }
}
