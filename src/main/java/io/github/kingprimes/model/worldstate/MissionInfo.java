package io.github.kingprimes.model.worldstate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.kingprimes.model.enums.FactionEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 *
 */

@Data
@Accessors(chain = true)
public class MissionInfo {
    @JsonProperty("seed")
    private Integer seed;
    @JsonProperty("faction")
    private FactionEnum faction;
    @JsonProperty("missionReward")
    private List<Reward> missionReward; // 添加这个字段

    @JsonIgnore
    public String getFaction() {
        return faction.getName();
    }
}
