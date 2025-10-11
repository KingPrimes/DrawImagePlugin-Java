package io.github.kingprimes.model.worldstate;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.kingprimes.model.enums.SyndicateEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class SyndicateMission extends BastWorldState{
    @JsonProperty("Tag")
    private SyndicateEnum tag;
    @JsonProperty("Seed")
    private Integer seed;
    @JsonProperty("Nodes")
    private List<String> nodes;
    @JsonProperty("Jobs")
    private List<Job> jobs;
}
