package library.project.Items;

import library.project.LibraryItem;

public class Book extends LibraryItem {

    protected String author;

    // Constructor
    public Book(String title, String author) {
        super(title);
        this.author = author;
    }

    public Book(int id, String title, String author, boolean avaliability) {
        super(id, title, avaliability);
        this.author = author;
    }

}
