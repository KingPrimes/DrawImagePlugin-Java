package io.github.kingprimes.model.worldstate;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AllCycle {
    // 地球循环
    EarthCycle earthCycle;

    // 夜灵平原
    CetusCycle cetusCycle;

    // 魔胎之境
    CambionCycle cambionCycle;

    // 奥布山谷 轮换
    VallisCycle vallisCycle;
}
