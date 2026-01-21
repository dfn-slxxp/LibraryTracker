package library.project.Items;

import library.project.LibraryItem;

public class Book extends LibraryItem {

    protected enum BookGenre {
        FANTASY_FICTION,
        REALISTIC_FICTION,
        NON_FICTION,
    }

    protected String author;
    protected BookGenre genre;

    // Constructor
    public Book(String title, String author, BookGenre genre) {
        super(title);
        this.author = author;
        this.genre = genre;
    }

    public Book(int id, String title, String author, boolean avaliability) {
        super(id, title, avaliability);
        this.author = author;
    }

}
