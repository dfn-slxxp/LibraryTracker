package library.project.Items;

import library.project.LibraryItem;

public class Device extends LibraryItem {
    
    public enum DeviceType {
        LAPTOP,
        IPAD,
        DESKTOP,
        OTHER;

        public static DeviceType fromString(String str) {
            switch (str) {
                case "Laptop":
                    return DeviceType.LAPTOP;
                case "IPad":
                    return DeviceType.IPAD;
                case "Desktop":
                    return DeviceType.DESKTOP;
                default:
                    return DeviceType.OTHER;
            }
        }
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
