package library.project.Items;

import library.project.LibraryItem;

public class Disk extends LibraryItem {
    
    protected enum DiskType {
        CD,
        DVD
    }

    protected DiskType diskType;

    // Constructor
    public Disk(String name, DiskType type) {
        super(name);
        this.diskType = type;
    }

    public Disk(int id, String name, DiskType type, boolean avaliability) {
        super(id, name, avaliability);
        this.diskType = type;
    }

}
