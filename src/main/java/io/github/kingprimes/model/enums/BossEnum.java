package io.github.kingprimes.model.enums;

import lombok.Getter;

/**
 * Warframe Boos 枚举集
 *
 * @author kingprimes
 * @version 1.0.0
 * @see <a href="https://wiki.warframe.com/w/Bosses">Boss Bosses</a>
 */
@Getter
public enum BossEnum {
    /**
     * 鬣狗群
     */
    SORTIE_BOSS_HYENA("鬣狗群", "Corpus"),
    /**
     * Kela De Thaym
     */
    SORTIE_BOSS_KELA("Kela De Thaym", "Grineer"),
    /**
     * Vor 上尉
     */
    SORTIE_BOSS_VOR("Vor 上尉", "Grineer"),
    /**
     * Sargas Ruk 将军
     */
    SORTIE_BOSS_RUK("Sargas Ruk 将军", "Grineer"),
    /**
     * Vay Hek 委员
     */
    SORTIE_BOSS_HEK("Vay Hek 委员", "Grineer"),
    /**
     * Lech Kril 中尉
     */
    SORTIE_BOSS_KRIL("Lech Kril 中尉", "Grineer"),
    /**
     * Tyl Regor
     */
    SORTIE_BOSS_TYL("Tyl Regor", "Grineer"),
    /**
     * 豺狼
     */
    SORTIE_BOSS_JACKAL("豺狼", "Corpus"),
    /**
     * Alad V
     */
    SORTIE_BOSS_ALAD("Alad V", "Corpus"),
    /**
     * Ambulas
     */
    SORTIE_BOSS_AMBULAS("Ambulas", "Corpus"),
    /**
     * Nef Anyo
     */
    SORTIE_BOSS_NEF("Nef Anyo", "Corpus"),
    /**
     * 猛禽
     */
    SORTIE_BOSS_RAPTOR("猛禽", "Corpus"),
    /**
     * Phorid
     */
    SORTIE_BOSS_PHORID("Phorid", "Infestation"),
    /**
     * Lephantis
     */
    SORTIE_BOSS_LEPHANTIS("Lephantis", "Infestation"),
    /**
     * 异融者 Alad V
     */
    SORTIE_BOSS_INFALAD("异融者 Alad V", "Infestation"),
    /**
     * 堕落 Vor
     */
    SORTIE_BOSS_CORRUPTED_VOR("堕落 Vor", "堕落者"),
    /**
     * 诡文枭主
     */
    SORTIE_BOSS_BOREAL("诡文枭主", "合一众"),
    /**
     * 欺谋狼主
     */
    SORTIE_BOSS_AMAR("欺谋狼主", "合一众"),
    /**
     * 混沌蛇主
     */
    SORTIE_BOSS_NIRA("混沌蛇主", "合一众"),
    /**
     * 帕祖
     */
    SORTIE_BOSS_PAAZUL("帕祖", "合一众");

    private final String name;
    private final String faction;

    BossEnum(String name, String faction) {
        this.name = name;
        this.faction = faction;
    }
}
