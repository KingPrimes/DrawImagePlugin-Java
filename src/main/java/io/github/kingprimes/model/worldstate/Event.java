package io.github.kingprimes.model.worldstate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Event extends BastWorldState{
    @JsonProperty("Messages")
    private List<Message> messages;
    @JsonProperty("Prop")
    private String prop;
    @JsonProperty("Icon")
    private String icon;
    @JsonProperty("Priority")
    private Boolean priority;
    @JsonProperty("MobileOnly")
    private Boolean mobileOnly;
    @JsonProperty("Community")
    private Boolean community;
    // 添加字段映射
    @JsonProperty("Date")
    private DateField date;
    @JsonProperty("ImageUrl")
    private String imageUrl;
    @JsonProperty("EventStartDate")
    private DateField eventStartDate;
    @JsonProperty("EventEndDate")
    private DateField eventEndDate;
    @JsonProperty("HideEndDateModifier")
    private Boolean hideEndDateModifier;

}
