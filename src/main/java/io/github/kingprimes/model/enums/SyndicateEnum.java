package io.github.kingprimes.model.enums;

import lombok.Getter;

/**
 * 集团枚举
 *
 * @author KingPrimes
 * @version 1.0.0
 */
@Getter
public enum SyndicateEnum {
    /**
     * 均衡仲裁者
     */
    ArbitersSyndicate("均衡仲裁者"),

    /**
     * 中枢苏达
     */
    CephalonSudaSyndicate("中枢苏达"),

    /**
     * 新世间
     */
    NewLokaSyndicate("新世间"),

    /**
     * 佩兰数列
     */
    PerrinSyndicate("佩兰数列"),

    /**
     * 钢铁防线
     */
    SteelMeridianSyndicate("钢铁防线"),

    /**
     * 血色面纱
     */
    RedVeilSyndicate("血色面纱"),

    /**
     * Ostron
     */
    CetusSyndicate("Ostron"),

    /**
     * 夜羽
     */
    QuillsSyndicate("夜羽"),

    /**
     * 刺客
     */
    AssassinsSyndicate("刺客"),

    /**
     * 集团
     */
    EventSyndicate("集团"),

    /**
     * 索拉里斯联盟
     */
    SolarisSyndicate("索拉里斯联盟"),

    /**
     * 索拉里斯之声
     */
    VoxSyndicate("索拉里斯之声"),

    /**
     * 通风小子
     */
    VentKidsSyndicate("通风小子"),

    /**
     * 英择谛
     */
    EntratiSyndicate("英择谛"),

    /**
     * 科维兽
     */
    EntratiLabSyndicate("科维兽"),

    /**
     * The Hex
     */
    HexSyndicate("The Hex"),

    /**
     * 殁世械灵
     */
    NecraloidSyndicate("殁世械灵"),

    /**
     * 卡尔驻军
     */
    KahlSyndicate("卡尔驻军"),

    /**
     * 坚守者
     */
    ZarimanSyndicate("坚守者"),

    /**
     * 土星六号之狼
     */
    RadioLegionSyndicate("土星六号之狼"),

    /**
     * 使徒
     */
    RadioLegion2Syndicate("使徒"),

    /**
     * 玻璃匠
     */
    RadioLegion3Syndicate("玻璃匠"),
    RadioLegionIntermissionSyndicate("Intermission"),
    RadioLegionIntermission2Syndicate("Intermission II"),
    RadioLegionIntermission3Syndicate("Intermission III"),
    RadioLegionIntermission4Syndicate("Nora 的精选"),
    RadioLegionIntermission5Syndicate("Nora 的混选 Vol. 1"),
    RadioLegionIntermission6Syndicate("Nora 的混选 Vol. 2"),
    RadioLegionIntermission7Syndicate("RadioLegionIntermission7Syndicate"),
    RadioLegionIntermission8Syndicate("RadioLegionIntermission8Syndicate"),
    RadioLegionIntermission9Syndicate("RadioLegionIntermission9Syndicate"),
    RadioLegionIntermission10Syndicate("RadioLegionIntermission10Syndicate"),
    RadioLegionIntermission11Syndicate("RadioLegionIntermission11Syndicate"),
    RadioLegionIntermission12Syndicate("RadioLegionIntermission12Syndicate"),
    RadioLegionIntermission13Syndicate("RadioLegionIntermission13Syndicate"),

    ;

    private final String name;

    SyndicateEnum(String name) {
        this.name = name;
    }
}
