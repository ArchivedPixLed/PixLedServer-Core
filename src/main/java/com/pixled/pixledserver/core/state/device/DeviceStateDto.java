package com.pixled.pixledserver.core.state.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pixled.pixledserver.core.state.base.StateDto;

public class DeviceStateDto extends StateDto {

    private boolean connected;

    @JsonCreator
    public DeviceStateDto(
            @JsonProperty("toggle") String toggle,
            @JsonProperty("connected") boolean connected
    ){
        super(toggle);
        this.connected = connected;
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
}
