package testSwicthes;

import com.pixled.pixledserver.core.ToggleState;
import com.pixled.pixledserver.core.device.base.Device;
import com.pixled.pixledserver.core.device.strip.Strip;
import com.pixled.pixledserver.core.group.DeviceGroup;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GroupSwitchTests {
    private Device d1;
    private Device d2;
    private Device d3;

    private DeviceGroup g1;
    private DeviceGroup g2;

    @Test
    public void SwitchTest() {
        d1 = new Strip("Strip1", 10);
        d2 = new Strip("Strip2", 10);
        d3 = new Strip("Strip3", 10);

        g1 = new DeviceGroup("SwitchTest1");
        g2 = new DeviceGroup("SwitchTest2");

        ArrayList<Device> g1Devices = new ArrayList<>();
        g1Devices.add(d1);
        g1Devices.add(d3);

        ArrayList<Device> g2Devices = new ArrayList<>();
        g2Devices.add(d2);
        g2Devices.add(d3);

        ArrayList<DeviceGroup> d1Groups = new ArrayList<>();
        d1Groups.add(g1);

        ArrayList<DeviceGroup> d2Groups = new ArrayList<>();
        d2Groups.add(g2);

        ArrayList<DeviceGroup> d3Groups = new ArrayList<>();
        d3Groups.add(g1);
        d3Groups.add(g2);

        g1.setDevices(g1Devices);
        g2.setDevices(g2Devices);
        d1.setDeviceGroups(d1Groups);
        d2.setDeviceGroups(d2Groups);
        d3.setDeviceGroups(d3Groups);

        g1.switchGroup();
        assertTrue(d1.getDeviceState().getToggleState() == ToggleState.ON);
        assertTrue(d3.getDeviceState().getToggleState() == ToggleState.ON);
        assertTrue(g2.getDeviceGroupState().getToggleState() == ToggleState.ON);
        assertTrue(d2.getDeviceState().getToggleState() == ToggleState.OFF);

        d3.switchDevice();
        d1.switchDevice();
        assertTrue(g1.getDeviceGroupState().getToggleState() == ToggleState.OFF);
        assertTrue(g2.getDeviceGroupState().getToggleState() == ToggleState.OFF);
    }
}
