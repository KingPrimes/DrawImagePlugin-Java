package io.github.kingprimes.model.worldstate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.kingprimes.model.enums.FactionEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 入侵
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Invasion extends BastWorldState {
    @JsonProperty("Faction")
    private FactionEnum faction;
    @JsonProperty("DefenderFaction")
    private FactionEnum defenderFaction;
    @JsonProperty("Node")
    private String node;
    @JsonProperty("Count")
    private Double count;
    @JsonProperty("Goal")
    private Double goal;
    @JsonProperty("LocTag")
    private String locTag;
    @JsonProperty("Completed")
    private Boolean completed;
    @JsonProperty("ChainID")
    private Id chainID;
    @JsonProperty("AttackerReward")
    private List<Reward> attackerReward;
    @JsonProperty("AttackerMissionInfo")
    private MissionInfo attackerMissionInfo;
    @JsonProperty("DefenderReward")
    private Reward defenderReward;
    @JsonProperty("DefenderMissionInfo")
    private MissionInfo defenderMissionInfo;

    @JsonIgnore
    public String getFaction() {
        return faction.getName();
    }

    @JsonIgnore
    public String getFactionName() {
        return faction.name();
    }

    @JsonIgnore
    public String getDefenderFaction() {
        return defenderFaction.getName();
    }

    @JsonIgnore
    public String getDefenderFactionName() {
        return defenderFaction.name();
    }
    @JsonIgnore
    public String getCompletion() {
        return String.format("%.2f", count / goal);
    }
}
