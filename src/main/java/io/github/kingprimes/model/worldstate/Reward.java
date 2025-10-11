package io.github.kingprimes.model.worldstate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Reward {
    @JsonProperty("credits")
    private Integer credits;
    @JsonProperty("xp")
    private Integer xp;
    @JsonProperty("items")
    private List<String> items;
    @JsonProperty("countedItems")
    private List<Item> countedItems;

    @Data
    @Accessors(chain = true)
    public static class Item {
        @JsonProperty("ItemType")
        private String name;
        @JsonProperty("ItemCount")
        private Integer count;
    }
}
