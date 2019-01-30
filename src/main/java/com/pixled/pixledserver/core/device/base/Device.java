package com.pixled.pixledserver.core.device.base;

import com.pixled.pixledserver.core.group.DeviceGroup;
import com.pixled.pixledserver.core.ToggleState;
import com.pixled.pixledserver.core.state.device.DeviceState;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Device {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "devices", cascade = CascadeType.ALL)
    private List<DeviceGroup> deviceGroups;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn()
    private DeviceState deviceState;

    public Device() {
        deviceGroups = new ArrayList<>();
        deviceState = new DeviceState();
    }

    public Device(DeviceDto deviceDto) {
        id = deviceDto.getId();
        name = deviceDto.getName();
        deviceGroups = new ArrayList<>();
        deviceState = new DeviceState(deviceDto.getState());
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

    public List<DeviceGroup> getDeviceGroups() {
        return deviceGroups;
    }

    public DeviceState getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(DeviceState deviceState) {
        this.deviceState = deviceState;
    }

    public void switchDevice() {
        deviceState.setToggleState(deviceState.getToggleState() == ToggleState.ON ? ToggleState.OFF : ToggleState.ON);
        for (DeviceGroup deviceGroup : deviceGroups) {
            deviceGroup.updateStatus();
        }
    }
}
