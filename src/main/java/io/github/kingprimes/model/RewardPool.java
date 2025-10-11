package io.github.kingprimes.model;


import io.github.kingprimes.model.enums.RarityEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class RewardPool {
    /**
     * 奖励列表
     */
    List<Reward> rewards;

    @Data
    @Accessors(chain = true)
    public static class Reward {
        /**
         * 奖励名称
         */
        String item;
        /**
         * 奖励数量
         */
        String itemCount;
        /**
         * 奖励稀有度
         */
        RarityEnum rarity;
    }
}
