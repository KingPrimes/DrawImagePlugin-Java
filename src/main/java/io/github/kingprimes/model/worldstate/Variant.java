package io.github.kingprimes.model.worldstate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.kingprimes.model.enums.MissionTypeEnum;
import io.github.kingprimes.model.enums.ModifierTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Variant {
    // 任务类型
    @JsonProperty("missionType")
    private MissionTypeEnum missionType;
    // 状态类型
    @JsonProperty("modifierType")
    private ModifierTypeEnum modifierType;
    // 节点
    @JsonProperty("node")
    private String node;
    // 地图板块
    @JsonProperty("tileset")
    private String tileset;

    @JsonIgnore
    public String getMissionType() {
        return missionType.getName();
    }

    @JsonIgnore
    public String getModifierType() {
        return modifierType.getStr();
    }
}
