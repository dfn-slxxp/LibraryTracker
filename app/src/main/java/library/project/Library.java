package library.project;

import java.util.ArrayList;

public class Library {

    protected String LibraryName;
    protected ArrayList<Member> members;
    protected ArrayList<LibraryItem> items;

    // Constructor
    public Library(String libraryName, ArrayList<LibraryItem> items) {
        this.LibraryName = libraryName;
        this.items = items;
    }

    public ArrayList<LibraryItem> getCheckedOut() {
        ArrayList<LibraryItem> checkedOut = new ArrayList<>();
        for (Member member : members) {
            for (LibraryItem item : member.getCheckedOut()) {
                checkedOut.add(item);
            }
        }

        return checkedOut;
    }

}
