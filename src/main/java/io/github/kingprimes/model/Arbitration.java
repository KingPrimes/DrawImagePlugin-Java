package io.github.kingprimes.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 预测仲裁
 * <p>该类表示一个仲裁任务的信息，包括任务时间、地点、敌人类型等信息</p>
 *
 * @author KingPrimes
 * @version 1.0.0
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

    /**
     * 判断该仲裁任务是否值得参与
     * <p>根据任务类型、节点和敌人类型来判断任务的价值</p>
     *
     * @return 如果任务值得参与返回true，否则返回false
     */
    @JsonIgnore
    public Boolean isWorth() {
        boolean isType = type.contains("拦截") || type.contains("防御");
        boolean isNode = node.contains("谷神星") || node.contains("水星");
        boolean isEnemy = enemy.contains("Grin") || enemy.contains("Infest");
        return isType && isNode && isEnemy;
    }

}
