package io.github.kingprimes.model.enums;

public enum RarityEnum {
    COMMON("常见"),
    UNCOMMON("罕见"),
    RARE("稀有"),
    LEGENDARY("传奇");
    final String name;

    RarityEnum(String s) {
        name = s;
    }
}
