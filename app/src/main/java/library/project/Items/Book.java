package library.project.Items;

import library.project.LibraryItem;

public class Book extends LibraryItem {

    public enum BookGenre {
        FANTASY_FICTION,
        REALISTIC_FICTION,
        NON_FICTION,
        OTHER;

        public static BookGenre fromString(String str) {
            switch (str) {
                case "Fantasy":
                    return BookGenre.FANTASY_FICTION;
                case "Realistic":
                    return BookGenre.REALISTIC_FICTION;
                case "Nonfiction":
                    return BookGenre.NON_FICTION;
                default:
                    return BookGenre.OTHER;
            }
        }
    }

    protected String author;
    protected BookGenre genre;

    // Constructor
    public Book(String title, String author, BookGenre genre) {
        super(title);
        this.author = author;
        this.genre = genre;
    }

    public Book(int id, String title, String author, BookGenre genre, boolean avaliability) {
        super(id, title, avaliability);
        this.author = author;
        this.genre = genre;
    }

}
