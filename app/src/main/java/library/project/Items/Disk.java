package library.project.Items;

import library.project.LibraryItem;

public class Disk extends LibraryItem {
    
    public enum DiskType {
        CD,
        DVD,
        BLURAY,
        OTHER;

        public static DiskType fromString(String str) {
            switch (str) {
                case "CD":
                    return DiskType.CD;
                case "DVD":
                    return DiskType.DVD;
                case "Bluray":
                    return DiskType.BLURAY;
                default:
                    return DiskType.OTHER;
            }
        }
    }

    protected DiskType diskType;

    // Constructor
    /**
     * 
     * @param name
     * @param type
     */
    public Disk(String name, DiskType type) {
        super(name);
        this.diskType = type;
    }

    /**
     * 
     * @param id
     * @param name
     * @param type
     * @param avaliability
     */
    public Disk(int id, String name, DiskType type, boolean avaliability) {
        super(id, name, avaliability);
        this.diskType = type;
    }

}
