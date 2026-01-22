package library.project;

import java.util.ArrayList;

public class Member {

    private static int nextID = 0;
    protected int id;
    
    protected ArrayList<LibraryItem> ItemsCheckedOut;
    protected String Name;

    public Member(String name) {
        this.Name = name;
        this.id = nextID;
        this.ItemsCheckedOut = new ArrayList<LibraryItem>();

        nextID++;
    }
    public Member(String name, int id) {
        this.Name = name;
        this.id = id;
        this.ItemsCheckedOut = new ArrayList<LibraryItem>();
    }

    public ArrayList<LibraryItem> getCheckedOut() {
        return ItemsCheckedOut;
    }

    public void CheckOutItem(LibraryItem item, Date date) {
        ItemsCheckedOut.add(item);
        item.checkOut(date, date.getDueDate());
    }

    public int getId() {
        return this.id;
    }

    public static void updateNextID(int next) {
        nextID = next;
    }

    public void printCheckedOutItems() {
        System.out.println(Name + " has " + ItemsCheckedOut.size() + " items Checked Out.");
        if (ItemsCheckedOut.size() > 0) {
            for (LibraryItem item : ItemsCheckedOut) {
                item.printCheckedOutItem();
            }
        }
        System.out.println("----------");
    }

}
