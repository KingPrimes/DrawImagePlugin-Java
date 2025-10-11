package io.github.kingprimes.model.worldstate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.kingprimes.model.enums.VoidEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class VoidStorms extends BastWorldState {
    // 节点
    @JsonProperty("Node")
    private String node;
    // 遗物等级
    @JsonProperty("ActiveMissionTier")
    private VoidEnum ActiveMissionTier;
    @JsonIgnore
    public String getActiveMissionTier() {
        return ActiveMissionTier.getName();
    }

    @JsonIgnore
    public VoidEnum getVoidEnum() {
        return ActiveMissionTier;
    }
}
