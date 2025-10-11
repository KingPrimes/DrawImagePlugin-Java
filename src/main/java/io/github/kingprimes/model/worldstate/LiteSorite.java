package io.github.kingprimes.model.worldstate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.kingprimes.model.enums.BossEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class LiteSorite extends BastWorldState{
    @JsonProperty("Reward")
    private String reward;
    @JsonProperty("Seed")
    private Integer seed;
    @JsonProperty("Boss")
    private BossEnum boss;
    @JsonProperty("Missions")
    private List<Mission> missions;

    @JsonIgnore
    public String getBoss() {
        return boss.getName();
    }
}
