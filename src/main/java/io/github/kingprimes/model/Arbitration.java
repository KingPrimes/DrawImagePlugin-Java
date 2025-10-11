package io.github.kingprimes.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.kingprimes.model.enums.WarframeMissionTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 预测仲裁
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Arbitration {

    /**
     * 时间
     */
    @JsonProperty("activation")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activation;
    /**
     * 结束时间
     */
    @JsonProperty("expiry")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expiry;
    /**
     * 代号
     */
    @JsonProperty("id")
    private String id;
    /**
     * 节点
     */
    @JsonProperty("node")
    private String node;
    /**
     * 行星
     */
    @JsonProperty("planet")
    private String planet;
    /**
     * 敌人
     */
    @JsonProperty("enemy")
    private String enemy;
    /**
     * 任务类型
     */
    @JsonProperty("missionType")
    private String type;

    @JsonProperty("etc")
    private String etc;

    @JsonIgnore
    public Boolean isWorth() {
        boolean isType = type.contains(WarframeMissionTypeEnum.Interception.get()) || type.contains(WarframeMissionTypeEnum.Defense.get());
        boolean isNode = node.contains("谷神星") || node.contains("水星");
        boolean isEnemy = enemy.contains("Grin") || enemy.contains("Infest");
        return isType && isNode && isEnemy;
    }

}
