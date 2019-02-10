package com.pixled.pixledserver.core.group;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pixled.pixledserver.core.device.base.Device;
import com.pixled.pixledserver.core.device.base.DeviceDto;
import com.pixled.pixledserver.core.state.deviceGroup.DeviceGroupStateDto;

import java.util.ArrayList;
import java.util.List;

public class DeviceGroupDto {

    private Integer id;
    private String name;
    private DeviceGroupStateDto state;
    private List<Integer> devices;

    @JsonCreator
    public DeviceGroupDto(
            @JsonProperty("id") Integer id,
            @JsonProperty("name") String name,
            @JsonProperty("state") DeviceGroupStateDto state,
            @JsonProperty("devices") List<Integer> devices
    ){
        this.id = id;
        this.name = name;
        this.state = state;
        this.devices = devices;
    }

    public DeviceGroupDto(DeviceGroup deviceGroup) {
        id = deviceGroup.getId();
        name = deviceGroup.getName();
        state = new DeviceGroupStateDto(deviceGroup.getDeviceGroupState());
        devices = new ArrayList<>();
        for (Device d : deviceGroup.getDevices()) {
            devices.add(d.getId());
        }
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

    public List<Integer> getDevices() {
        return devices;
    }

    public void setDevices(List<Integer> devices) {
        this.devices = devices;
    }
}
