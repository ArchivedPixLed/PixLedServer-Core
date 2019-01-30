package com.pixled.pixledserver.core.color;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ColorDto {
    private Float hue;
    private Float saturation;
    private Float value;
    private Integer argb;

    public ColorDto() {

    }

    @JsonCreator
    public ColorDto(
            @JsonProperty("hue") Float hue,
            @JsonProperty("saturation") Float saturation,
            @JsonProperty("value") Float value,
            @JsonProperty("argb") Integer argb
    ){
        this.hue = hue;
        this.saturation = saturation;
        this.value = value;
        this.argb = argb;
    }

    private ColorDto(Color color) {
        this.hue = color.getHue();
        this.saturation = color.getSaturation();
        this.value = color.getValue();
        this.argb = color.getArgb();
    }

    public Float getHue() {
        return hue;
    }

    public Float getSaturation() {
        return saturation;
    }

    public Float getValue() {
        return value;
    }

    public Integer getArgb() {
        return argb;
    }
}
