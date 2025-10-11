package io.github.kingprimes.model.worldstate;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.kingprimes.model.enums.FactionEnum;
import io.github.kingprimes.model.enums.MissionTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Nodes {

    @JsonProperty("uniqueName")
    String uniqueName;

    @JsonProperty("name")
    String name;

    @JsonProperty("systemName")
    String systemName;

    @JsonProperty("systemIndex")
    Integer systemIndex;

    @JsonProperty("missionType")
    MissionTypeEnum missionType;

    @JsonProperty("masteryReq")
    Integer masteryReq;

    @JsonProperty("missionIndex")
    Integer missionIndex;

    @JsonProperty("faction")
    FactionEnum faction;

    @JsonProperty("minEnemyLevel")
    Integer minEnemyLevel;

    @JsonProperty("maxEnemyLevel")
    Integer maxEnemyLevel;
}
