package io.github.kingprimes.model.worldstate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 电波
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class SeasonInfo extends BastWorldState {

    @JsonProperty("AffiliationTag")
    private String affiliationTag;

    @JsonProperty("Season")
    private Integer season;

    @JsonProperty("Phase")
    private Integer phase;

    @JsonProperty("Params")
    private String params;

    @JsonProperty("ActiveChallenges")
    private List<ActiveChallenges> activeChallenges;

    @Data
    @Accessors(chain = true)
    public static class ActiveChallenges {
        /**
         * 任务名称
         */
        String name;
        /**
         * 任务描述
         */
        String description;
        /**
         * 任务声望
         */
        Integer standing;
        /**
         * 任务数量
         */
        Integer required;

        /**
         * 是否为每日任务
         */
        Boolean daily;
        /**
         * 是否为每周任务
         */
        Boolean weekly;
        /**
         * 是否为精英任务
         */
        Boolean elite;
    }

}
