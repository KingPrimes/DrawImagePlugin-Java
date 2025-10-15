package io.github.kingprimes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Warframe Market 用户信息
 *
 * @author KingPrimes
 * @version 1.0.0
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Owner {
    /**
     * 声望
     */
    @JsonProperty("reputation")
    private Integer reputation;
    /**
     * 区服
     */
    @JsonProperty("locale")
    private String locale;
    /**
     * 玩家头像
     */
    @JsonProperty("avatar")
    private String avatar;
    /**
     * 上次登录时间
     */
    @JsonProperty("last_seen")
    private LocalDateTime lastSeen;
    /**
     * 游戏内名称
     */
    @JsonProperty("ingame_name")
    private String ingameName;
    /**
     * 用户状态
     */
    @JsonProperty("status")
    private String status;
    /**
     * 用户ID
     */
    @JsonProperty("id")
    private String id;
    /**
     * 所使用的语言
     */
    @JsonProperty("region")
    private String region;
}
