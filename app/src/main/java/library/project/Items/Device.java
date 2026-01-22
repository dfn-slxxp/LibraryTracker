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
    /**
     * 
     * @param name
     * @param device
     */
    public Device(String name, DeviceType device) {
        super(name);
        this.deviceType = device;
    }

    /**
     * 
     * @param id
     * @param name
     * @param device
     * @param avaliability
     */
    public Device(int id, String name, DeviceType device, boolean avaliability) {
        super(id, name, avaliability);
        this.deviceType = device;
    }

    @Override
    public void printItem() {
        System.out.println(this.deviceType.toString() + " named " + this.ItemName);
    }

    @Override
    public void printCheckedOutItem() {
        System.out.println(this.deviceType.toString() + " named " + this.ItemName + "; Checked Out on " + this.CheckOutDate.get().toString() + " and Due on " + this.DueDate.get().toString());
    }

}
