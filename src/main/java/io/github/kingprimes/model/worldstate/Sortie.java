package io.github.kingprimes.model.worldstate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.kingprimes.model.enums.BossEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 突击
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Sortie extends BastWorldState {

    @JsonProperty("Boss")
    private BossEnum boss;
    @JsonProperty("Reward")
    private String reward;
    @JsonProperty("Seed")
    private Integer seed;
    @JsonProperty("Variants")
    private List<Variant> variants;
    @JsonProperty("Twitter")
    private Boolean twitter;

    @JsonIgnore
    public String getBoss() {
        return boss.getName();
    }
}
