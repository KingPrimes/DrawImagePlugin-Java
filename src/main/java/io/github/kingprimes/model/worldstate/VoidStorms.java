package io.github.kingprimes.model.worldstate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.kingprimes.model.enums.VoidEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 虚空风暴
 * <p>表示九重天中的虚空风暴任务节点信息</p>
 * <p>该类继承 {@link BastWorldState} 基类</p>
 *
 * @author KingPrimes
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class VoidStorms extends BastWorldState {
    /**
     * 节点
     * <p>虚空风暴所在的九重天节点，如"CrewBattleNode509"</p>
     */
    @JsonProperty("Node")
    private String node;

    /**
     * 激活任务等级
     * <p>当前激活的虚空任务等级，如VoidT1、VoidT2等</p>
     */
    @JsonProperty("ActiveMissionTier")
    private VoidEnum ActiveMissionTier;

    /**
     * 获取激活任务等级名称
     *
     * @return 任务等级的显示名称 {@link VoidEnum#getName()}
     */
    @JsonIgnore
    public String getActiveMissionTier() {
        return ActiveMissionTier.getName();
    }

    /**
     * 获取虚空枚举
     *
     * @return 虚空任务等级枚举值 {@link VoidEnum}
     */
    @JsonIgnore
    public VoidEnum getVoidEnum() {
        return ActiveMissionTier;
    }
}
