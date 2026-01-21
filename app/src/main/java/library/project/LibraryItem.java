package library.project;

public class LibraryItem {

    public enum ItemType {
        BOOK,
        NEWSPAPER,
        DISK,
        DEVICE
    }

    private static int nextID = 0;
    protected int id;

    protected String ItemName;
    protected boolean avaliability;

    // Constructor
    public LibraryItem(String name) {
        this.id = nextID;
        nextID++;

        this.ItemName = name;
        this.avaliability = true;
    }

    public LibraryItem(int id, String name, boolean avaliability) {
        this.id = id;
        this.ItemName = name;
        this.avaliability = avaliability;
    }

    // Getters
    public String getItemName() {
        return ItemName;
    }

    public boolean checkAvaliability() {
        return avaliability;
    }

    // Setters
    public void setItemName(String name) {
        ItemName = name;
    }

    public void checkOut() {
        this.avaliability = false;
    }

    public void checkIn() {
        this.avaliability = true;
    }

}
