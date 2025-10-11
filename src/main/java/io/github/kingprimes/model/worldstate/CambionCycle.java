package io.github.kingprimes.model.worldstate;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.Instant;

/**
 * 魔胎之境
 */
@Data
@Accessors(chain = true)
public class CambionCycle {
    String active;
    String timeLeft;
    Instant expiry;
    Instant activation;
    public CambionCycle(CetusCycle cycle){
        this.activation = cycle.getActivation();
        this.expiry = cycle.getExpiry();
        this.active = cycle.getIsDay() ? "FASS" : "VOME";
        this.timeLeft = cycle.getTimeLeft();
    }
}
