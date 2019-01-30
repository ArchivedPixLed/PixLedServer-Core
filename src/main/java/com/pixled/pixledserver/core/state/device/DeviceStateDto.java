package com.pixled.pixledserver.core.state.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pixled.pixledserver.core.color.ColorDto;
import com.pixled.pixledserver.core.state.base.StateDto;

public class DeviceStateDto extends StateDto {

    private boolean connected;
    private ColorDto color;

    @JsonCreator
    public DeviceStateDto(
            @JsonProperty("toggle") String toggle,
            @JsonProperty("connected") boolean connected,
            @JsonProperty("color") ColorDto color
    ){
        super(toggle);
        this.connected = connected;
        this.color = color;
    }

    public DeviceStateDto(DeviceState deviceState) {
        super(deviceState);
        connected = deviceState.isConnected();
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public ColorDto getColor() {
        return color;
    }

    public void setColor(ColorDto color) {
        this.color = color;
    }
}
