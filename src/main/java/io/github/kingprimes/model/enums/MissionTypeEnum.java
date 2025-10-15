package io.github.kingprimes.model.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Warframe 任务类型枚举
 *
 * @author KingPrimes
 * @version 1.0.0
 * @see <a href="https://wiki.warframe.com/w/Mission">任务类型列表</a>
 */

@Getter
public enum MissionTypeEnum {

    /**
     * 刺杀
     */
    MT_ASSASSINATION("刺杀", 0),

    /**
     * 歼灭
     */
    MT_EXTERMINATION("歼灭", 1),

    /**
     * 生存
     */
    MT_SURVIVAL("生存", 2),

    /**
     * 救援
     */
    MT_RESCUE("救援", 3),


    /**
     * 破坏
     */
    MT_SABOTAGE("破坏", 4),

    /**
     * 捕获
     */
    MT_CAPTURE("捕获", 5),

    /**
     * 未知
     */
    MT_DEFAULT("未知", 6),

    /**
     * 间谍
     */
    MT_INTEL("间谍", 7),

    /**
     * 防御
     */
    MT_DEFENSE("防御", 8),

    /**
     * 移动防御
     */
    MT_MOBILE_DEFENSE("移动防御", 9),

    /**
     * 武形秘仪
     */
    MT_PVP("武形秘仪", 10),

    /**
     * 黑暗地带
     */
    MT_SECTOR("黑暗地带", 11),

    /**
     * 拦截
     */
    MT_TERRITORY("拦截", 13),

    /**
     * 清巢
     */
    MT_HIVE("清巢", 15),

    /**
     * 劫持
     */
    MT_RETRIEVAL("劫持", 14),

    /**
     * 挖掘
     */
    MT_EXCAVATE("挖掘", 17),

    /**
     * 资源回收
     */
    MT_SALVAGE("资源回收", 21),

    /**
     * 竞技场
     */
    MT_ARENA("竞技场", 22),

    /**
     * 追击
     */
    MT_PURSUIT("追击", 24),

    /**
     * 强袭
     */
    MT_ASSAULT("强袭", 26),

    /**
     * 叛逃
     */
    MT_EVACUATION("叛逃", 27),

    /**
     * 自由漫步
     */
    MT_LANDSCAPE("自由漫步", 28),

    /**
     * 中断
     */
    MT_ARTIFACT("中断", 33),

    /**
     * 中断
     */
    MT_DISRUPTION("中断", 32),

    /**
     * 虚空洪流
     */
    MT_VOID_FLOOD("虚空洪流", 34),

    /**
     * 虚空覆涌
     */
    MT_VOID_CASCADE("虚空覆涌", 35),

    /**
     * 虚空决战
     */
    MT_VOID_ARMAGEDDON("虚空决战", 36),

    /**
     * 元素转换
     */
    MT_ALCHEMY("元素转换", 38),

    /**
     * 异化区
     */
    MT_CAMBIRE("异化区", 39),

    /**
     * 传承种收割
     */
    MT_LEGACYTE_HARVEST("传承种收割", 40),

    /**
     * 祈运坛防御
     */
    MT_SHRINE_DEFENSE("祈运坛防御", 41),

    /**
     * 对战
     */
    MT_FACEOFF("对战", 42),

    /**
     * 前哨战
     */
    MT_SKIRMISH("前哨战", 60),

    /**
     * 爆发
     */
    MT_VOLATILE("爆发", 61),

    /**
     * 奥菲斯
     */
    MT_ORPHEUS("奧菲斯", 62),

    /**
     * 扬升
     */
    MT_ASCENSION("扬升", 90),

    /**
     * 中继站
     */
    MT_RELAY("中继站", 100),
    ;
    private final String name;
    private final int order;

    MissionTypeEnum(String name, int order) {
        this.name = name;
        this.order = order;
    }

    /**
     * 获取按order字段排序的所有枚举值列表
     *
     * @return 按照order升序排列的MissionTypeEnum枚举值列表
     */
    public static List<MissionTypeEnum> getOrderedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparingInt(MissionTypeEnum::getOrder))
                .toList();
    }
}
