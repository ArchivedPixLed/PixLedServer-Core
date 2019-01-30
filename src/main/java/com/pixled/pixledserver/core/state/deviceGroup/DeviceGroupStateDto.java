package com.pixled.pixledserver.core.state.deviceGroup;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pixled.pixledserver.core.state.base.StateDto;

public class DeviceGroupStateDto extends StateDto {

    @JsonCreator
    public DeviceGroupStateDto(
            @JsonProperty("toggle") String toggle
    ){
        super(toggle);
    }

    public DeviceGroupStateDto(DeviceGroupState deviceGroupState) {
        super(deviceGroupState);
    }

}
