package library.project;

import java.util.Optional;

public abstract class LibraryItem {

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

    protected Optional<Date> CheckOutDate;
    protected Optional<Date> DueDate;

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

    public int getId() {
        return id;
    }

    public Date getCheckoutDate() {
        return CheckOutDate.get();
    }

    public Date getDueDate() {
        return DueDate.get();
    }

    // Setters
    public void setItemName(String name) {
        ItemName = name;
    }

    public void checkOut(Date CheckOutDate, Date DueDate) {
        this.avaliability = false;
        this.CheckOutDate = Optional.of(CheckOutDate);
        this.DueDate = Optional.of(DueDate);
    }

    public void checkIn() {
        this.avaliability = true;
        this.CheckOutDate = Optional.empty();
        this.DueDate = Optional.empty();
    }

    public void renew(Date date) {
        this.checkOut(date, date.getDueDate());
    }

    public static void updateNextID(int next) {
        nextID = next;
    }


    // MISC
    public void printItem() {
        System.out.println(ItemName);
    }
    public void printCheckedOutItem() {
        System.out.println(ItemName + "; Checked Out on " + this.CheckOutDate.get().toString() + " and Due on " + this.DueDate.get().toString());
    }
}
