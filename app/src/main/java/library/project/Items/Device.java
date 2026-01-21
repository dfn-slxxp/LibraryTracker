package library.project.Items;

import library.project.LibraryItem;

public class Device extends LibraryItem {
    
    protected enum DeviceType {
        LAPTOP,
        IPAD
    }

    protected DeviceType deviceType;

    // Constructor
    public Device(String name, DeviceType device) {
        super(name);
        this.deviceType = device;
    }

    public Device(int id, String name, DeviceType device, boolean avaliability) {
        super(id, name, avaliability);
        this.deviceType = device;
    }

}
