package io.github.kingprimes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Warframe orders查询结果
 */
@Data
@Accessors(chain = true)
public class Orders {
    /**
     * 物品名称
     */
    String itemName;
    /**
     * 平台类型例如"pc"、"xbox"、"ps4"等
     */
    String form;
    /**
     * true: 购买 false: 出售
     */
    Boolean isBy;
    /**
     * true: 满级 false: 未满级
     */
    Boolean isMax;
    /**
     * 订单列表
     */
    List<Order> orders;

    @Data
    @Accessors(chain = true)
    public static class Order {

        /**
         * 白金
         */
        Integer platinum;

        /**
         * 数量
         */
        Integer quantity;

        /**
         * 等级
         */
        Integer modRank;

        /**
         * 买卖类型
         */
        @JsonProperty("order_type")
        String orderType;

        /**
         * 订单创建日期
         */
        @JsonProperty("creation_date")
        LocalDateTime creationDate;

        /**
         * 最后一次修改日期
         */
        @JsonProperty("last_update")
        LocalDateTime lastUpdate;

        Owner owner;
    }
}
