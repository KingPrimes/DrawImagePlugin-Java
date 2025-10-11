package io.github.kingprimes;

import io.github.kingprimes.model.enums.RivenTrendEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 紫卡分析
 */
@Data
@Accessors(chain = true)
public class RivenAnalyseTrend {
    /**
     * 武器名称
     */
    String weaponName;
    /**
     * 紫卡名称
     */
    String rivenName;
    /**
     * 倾向点
     */
    String dot;
    /**
     * 倾向数值
     */
    Double num;
    /**
     * 武器类型
     */
    String weaponType;
    /**
     * 属性分析
     */
    List<Attribute> attributes;

    public String getDot() {
        if (num != null) {
            return RivenTrendEnum.getRivenTrendDot(num);
        }
        return RivenTrendEnum.RIVEN_TREND_1.getDoc();
    }

    @Data
    public static class Attribute {
        /**
         * 属性名称
         */
        String name;
        /**
         * 属性数值
         */
        Double attr;
        /**
         * 低属性数值
         */
        String lowAttr;
        /**
         * 高属性数值
         */
        String highAttr;
        /**
         * 属性数值差异
         */
        String attrDiff;
    }
}
