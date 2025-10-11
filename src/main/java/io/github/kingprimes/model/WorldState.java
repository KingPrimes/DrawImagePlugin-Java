package io.github.kingprimes.model;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.kingprimes.model.enums.SyndicateEnum;
import io.github.kingprimes.model.worldstate.ActiveMission;
import io.github.kingprimes.model.worldstate.Alert;
import io.github.kingprimes.model.worldstate.CambionCycle;
import io.github.kingprimes.model.worldstate.CetusCycle;
import io.github.kingprimes.model.worldstate.ConstructionProjects;
import io.github.kingprimes.model.worldstate.DailyDeals;
import io.github.kingprimes.model.worldstate.DuviriCycle;
import io.github.kingprimes.model.worldstate.EarthCycle;
import io.github.kingprimes.model.worldstate.EndlessXpChoices;
import io.github.kingprimes.model.worldstate.Event;
import io.github.kingprimes.model.worldstate.ExperimentRecommended;
import io.github.kingprimes.model.worldstate.FeaturedGuilds;
import io.github.kingprimes.model.worldstate.FlashSale;
import io.github.kingprimes.model.worldstate.GlobalUpgrade;
import io.github.kingprimes.model.worldstate.Goal;
import io.github.kingprimes.model.worldstate.HubEvents;
import io.github.kingprimes.model.worldstate.InGameMarket;
import io.github.kingprimes.model.worldstate.Invasion;
import io.github.kingprimes.model.worldstate.KnownCalendarSeasons;
import io.github.kingprimes.model.worldstate.LibraryInfo;
import io.github.kingprimes.model.worldstate.LiteSorite;
import io.github.kingprimes.model.worldstate.NodeOverride;
import io.github.kingprimes.model.worldstate.PrimeVaultTrader;
import io.github.kingprimes.model.worldstate.SeasonInfo;
import io.github.kingprimes.model.worldstate.Sortie;
import io.github.kingprimes.model.worldstate.SteelPathOffering;
import io.github.kingprimes.model.worldstate.SyndicateMission;
import io.github.kingprimes.model.worldstate.VallisCycle;
import io.github.kingprimes.model.worldstate.VoidStorms;
import io.github.kingprimes.model.worldstate.VoidTrader;
import io.github.kingprimes.model.worldstate.ZarimanCycle;
import lombok.Data;
import lombok.experimental.Accessors;

@SuppressWarnings("unused")
@Data
@Accessors(chain = true)
public class WorldState {
    // 地球循环
    EarthCycle earthCycle;

    // 夜灵平原
    CetusCycle cetusCycle;

    // 魔胎之境
    CambionCycle cambionCycle;

    // 奥布山谷 轮换
    VallisCycle vallisCycle;

    // 裂隙任务
    @JsonProperty("ActiveMissions")
    List<ActiveMission> activeMissions;

    // 警报任务
    @JsonProperty("Alerts")
    List<Alert> alerts;

    @JsonProperty("BuildLabel")
    String buildLabel;

    @JsonProperty("ConstructionProjects")
    List<ConstructionProjects> constructionProjects;

    // 每日特惠
    @JsonProperty("DailyDeals")
    List<DailyDeals> dailyDeals;

    // 双衍王境 奖励
    @JsonProperty("EndlessXpChoices")
    List<EndlessXpChoices> endlessXpChoices;

    // 双衍王境 轮换
    DuviriCycle duviriCycle;

    // 新闻
    @JsonProperty("Events")
    List<Event> events;

    //
    @JsonProperty("ExperimentRecommended")
    List<ExperimentRecommended> experimentRecommended;

    // 精选氏族
    @JsonProperty("FeaturedGuilds")
    List<FeaturedGuilds> featuredGuilds;

    // 闪购
    @JsonProperty("FlashSales")
    List<FlashSale> flashSales;

    @JsonProperty("ForceLogoutVersion")
    Integer forceLogoutVersion;

    @JsonProperty("GlobalUpgrades")
    List<GlobalUpgrade> globalUpgrades;

    // 活动
    @JsonProperty("Goals")
    List<Goal> goals;

    //
    @JsonProperty("HubEvents")
    List<HubEvents> hubEvents;

    // 游戏内商城
    @JsonProperty("InGameMarket")
    InGameMarket inGameMarket;

    // 入侵
    @JsonProperty("Invasions")
    List<Invasion> invasions;

    // 1999日历
    @JsonProperty("KnownCalendarSeasons")
    List<KnownCalendarSeasons> knownCalendarSeasons;

    //
    @JsonProperty("LibraryInfo")
    LibraryInfo libraryInfo;

    // 执刑官猎杀
    @JsonProperty("LiteSorties")
    List<LiteSorite> liteSorties;

    //
    @JsonProperty("MobileVersion")
    String mobileVersion;

    //
    @JsonProperty("NodeOverrides")
    List<NodeOverride> nodeOverrides;

    // 瓦奇娅
    @JsonProperty("PrimeVaultTraders")
    List<PrimeVaultTrader> primeVaultTraders;

    //
    @JsonProperty("ProjectPct")
    List<Float> projectPct;

    // 电波
    @JsonProperty("SeasonInfo")
    SeasonInfo seasonInfo;

    // 突击
    @JsonProperty("Sorties")
    List<Sortie> sorties;

    // 集团任务
    @JsonProperty("SyndicateMissions")
    List<SyndicateMission> syndicateMissions;

    // 扎的曼轮换
    ZarimanCycle zarimanCycle;

    @JsonProperty("Time")
    Long time;

    @JsonProperty("Tmp")
    String tmp;

    @JsonProperty("Version")
    Integer version;

    // 虚空风暴 九重天裂隙
    @JsonProperty("VoidStorms")
    List<VoidStorms> voidStorms;

    // 虚空商人
    @JsonProperty("VoidTraders")
    List<VoidTrader> voidTraders;

    // 世界种子
    @JsonProperty("WorldSeed")
    String worldSeed;

    @JsonProperty("SteelPath")
    SteelPathOffering steelPath = new SteelPathOffering();

    @JsonIgnore
    public EarthCycle getEarthCycle() {
        return new EarthCycle();
    }
    @JsonIgnore
    public CetusCycle getCetusCycle() {
        return new CetusCycle(getBountiesEndDate(SyndicateEnum.CetusSyndicate));
    }
    @JsonIgnore
    public CambionCycle getCambionCycle() {
        return new CambionCycle(getCetusCycle());
    }
    @JsonIgnore
    public VallisCycle getVallisCycle() {
        return new VallisCycle();
    }
    @JsonIgnore
    public DuviriCycle getDuviriCycle() {
        return new DuviriCycle(this.getEndlessXpChoices());
    }
    @JsonIgnore
    public ZarimanCycle getZarimanCycle() {
        return new ZarimanCycle(getBountiesEndDate(SyndicateEnum.ZarimanSyndicate));
    }

    @JsonIgnore
    private Instant getBountiesEndDate(SyndicateEnum key) {
        return this.getSyndicateMissions()
                .stream()
                .filter(s -> s.getTag().equals(key))
                .findFirst()
                .map(s -> s.getExpiry().getEpochSecond())
                .orElse(Instant.now());
    }
}
