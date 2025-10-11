package io.github.kingprimes.model.worldstate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 火星集市 瓦奇娅
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class PrimeVaultTrader extends BastWorldState {

    @JsonProperty("InitialStartDate")
    private DateField initialStartDate;
    @JsonProperty("Node")
    private String node;
    @JsonProperty("Manifest")
    private List<ManifestItem> manifest;
    /**
     *
     */
    @JsonProperty("EvergreenManifest")
    private List<ManifestItem> evergreenManifest;
    /**
     * 时间表信息
     */
    @JsonProperty("ScheduleInfo")
    private List<ScheduleInfo> scheduleInfos;
}
