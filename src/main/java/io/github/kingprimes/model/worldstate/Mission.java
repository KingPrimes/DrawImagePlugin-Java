package io.github.kingprimes.model.worldstate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.kingprimes.model.enums.MissionTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Mission {
    @JsonProperty("missionType")
    private MissionTypeEnum missionType;
    @JsonProperty("node")
    private String node;

    @JsonIgnore
    public String getMissionType(){
        return missionType.getName();
    }
}
