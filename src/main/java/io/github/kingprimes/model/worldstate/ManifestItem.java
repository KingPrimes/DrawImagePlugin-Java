package io.github.kingprimes.model.worldstate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ManifestItem {
    // 物品
    @JsonProperty("ItemType")
    private String itemType;
    // 御品阿耶精华
    @JsonProperty("PrimePrice")
    private Integer primePrice;
    // 阿耶精华
    @JsonProperty("RegularPrice")
    private Integer regularPrice;
}
