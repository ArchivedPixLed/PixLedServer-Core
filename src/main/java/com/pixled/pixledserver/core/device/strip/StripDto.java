package com.pixled.pixledserver.core.device.strip;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pixled.pixledserver.core.device.base.DeviceDto;
import com.pixled.pixledserver.core.state.device.DeviceStateDto;

import java.util.List;

public class StripDto extends DeviceDto {

    private Integer length;

    @JsonCreator
    public StripDto(
            @JsonProperty("id") Integer id,
            @JsonProperty("name") String name,
            @JsonProperty("groups") List<Integer> deviceGroups,
            @JsonProperty("state") DeviceStateDto state,
            @JsonProperty("length") Integer length)
    {
        super(id, name, deviceGroups, state);
        this.length = length;
    }


    public StripDto(Strip strip) {
        super(strip);
        length = strip.getLength();
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
