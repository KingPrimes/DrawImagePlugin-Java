package io.github.kingprimes.model;

import io.github.kingprimes.model.enums.RarityEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 遗物
 */
@Data
@Accessors(chain = true)
public class Relics {
    /**
     * 遗物名称
     */
    String name;

    @Data
    @Accessors(chain = true)
    public static class Rewards {
        /**
         * 奖励名称
         */
        String name;
        /**
         * 奖励稀有度
         */
        RarityEnum rarity;
        /**
         * 奖励数量
         */
        Integer itemCount;

        public String getName() {
            if (itemCount > 1) return itemCount + "X" + name;
            return name;
        }
    }
}
