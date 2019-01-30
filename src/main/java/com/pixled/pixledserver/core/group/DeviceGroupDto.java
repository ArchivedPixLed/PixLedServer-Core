package com.pixled.pixledserver.core.group;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pixled.pixledserver.core.state.deviceGroup.DeviceGroupStateDto;

public class DeviceGroupDto {

    private Integer id;
    private String name;
    private DeviceGroupStateDto state;

    @JsonCreator
    public DeviceGroupDto(
            @JsonProperty("id") Integer id,
            @JsonProperty("name") String name,
            @JsonProperty("state") DeviceGroupStateDto state
    ){
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public DeviceGroupDto(DeviceGroup deviceGroup) {
        id = deviceGroup.getId();
        name = deviceGroup.getName();
        state = new DeviceGroupStateDto(deviceGroup.getDeviceGroupState());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceGroupStateDto getState() {
        return state;
    }

    public void setState(DeviceGroupStateDto state) {
        this.state = state;
    }
}
