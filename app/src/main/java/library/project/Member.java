package library.project;

import java.util.ArrayList;

public class Member {
    
    protected ArrayList<LibraryItem> ItemsCheckedOut;
    protected String Name;

    public ArrayList<LibraryItem> getCheckedOut() {
        return ItemsCheckedOut;
    }

    public void CheckOutItem(LibraryItem item, Date date) {
        ItemsCheckedOut.add(item);
        item.checkOut(date, date.getDueDate());
    }

}
