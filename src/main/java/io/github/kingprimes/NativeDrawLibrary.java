package io.github.kingprimes;

import com.sun.jna.Library;
import com.sun.jna.Pointer;

/**
 * JNA 接口，用于调用C++库
 *
 * @author KingPrimes
 * @version 1.0.2
 */
public interface NativeDrawLibrary extends Library {

    // 插件信息函数
    String nativeGetPluginName();

    String nativeGetPluginVersion();

    // 图像绘制函数 (返回Pointer，需要手动管理内存)
    Pointer nativeDrawAllCycleImage(Pointer allCycle);

    Pointer nativeDrawAllInfoImage(Pointer allInfo);

    Pointer nativeDrawAlertsImage(Pointer alerts);

    Pointer nativeDrawArbitrationImage(Pointer arbitration);

    Pointer nativeDrawArbitrationsImage(Pointer sorties);

    Pointer nativeDrawDailyDealsImage(Pointer dailyDeal);

    Pointer nativeDrawDuviriCycleImage(Pointer duvalierCycle);

    Pointer nativeDrawActiveMissionImage(Pointer activeMission);

    Pointer nativeDrawInvasionImage(Pointer invasions);

    Pointer nativeDrawKnownCalendarSeasonsImage(Pointer knownCalendarSeasons);

    Pointer nativeDrawMarketGodDumpImage(Pointer dump);

    Pointer nativeDrawMarketSilverDumpImage(Pointer dump);

    Pointer nativeDrawMarketLichesImage(Pointer marketLichs);

    Pointer nativeDrawLiteSoriteImage(Pointer liteSorite);

    Pointer nativeDrawMarketSisterImage(Pointer marketSister);

    Pointer nativeDrawMarketOrdersImage(Pointer orders);

    Pointer nativeDrawMarketOrdersImageList(Pointer possibleItems);

    Pointer nativeDrawMarketRivenImage(Pointer marketRiven);

    Pointer nativeDrawSeasonInfoImage(Pointer seasonInfo);

    Pointer nativeDrawRelicsImage(Pointer relic);

    Pointer nativeDrawRivenAnalyseTrendImage(Pointer rivenAnalyseTrend);

    Pointer nativeDrawSortiesImage(Pointer sorties);

    Pointer nativeDrawSteelPath(Pointer steelPath);

    Pointer nativeDrawSyndicateImage(Pointer sm, Pointer se);

    Pointer nativeDrawVoidTraderImage(Pointer vt);

    void nativeReleaseMemory();

    void nativeReleaseMemory(Pointer pointer);
}
