package com.pixled.pixledserver.core.device.base;

import com.pixled.pixledserver.core.group.DeviceGroup;
import com.pixled.pixledserver.core.ToggleState;
import com.pixled.pixledserver.core.state.device.DeviceState;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public Device(String name) {
        this();
        this.name = name;
    }

    public Device(DeviceDto deviceDto) {
        deviceGroups = new ArrayList<>();
        id = deviceDto.getId();
        name = deviceDto.getName();
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

    public void setDeviceGroups(List<DeviceGroup> deviceGroups) {
        this.deviceGroups = deviceGroups;
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

    public abstract DeviceDto generateDto();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return id.equals(device.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
