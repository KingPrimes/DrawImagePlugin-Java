package io.github.kingprimes.model.worldstate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class EndlessXpChoices {

    @JsonProperty("Category")
    private Category category;
    @JsonProperty("Choices")
    private List<String> choices;

    public enum Category{
        EXC_NORMAL,
        EXC_HARD
    }
}
