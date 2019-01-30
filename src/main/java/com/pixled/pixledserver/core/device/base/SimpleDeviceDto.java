package com.pixled.pixledserver.core.device.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pixled.pixledserver.core.state.device.DeviceStateDto;

import java.util.List;

public class SimpleDeviceDto extends DeviceDto {

    private String type;

    @JsonCreator
    public SimpleDeviceDto(
            @JsonProperty("id") Integer id,
            @JsonProperty("name") String name,
            @JsonProperty("groups") List<Integer> deviceGroups,
            @JsonProperty("state") DeviceStateDto state,
            @JsonProperty("type") String type
    ){
        super(id, name, deviceGroups, state);
        this.type = type;
    }

    public SimpleDeviceDto(Device device) {
        super(device);
        type = device.getClass().getSimpleName();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
