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
    /**
     * @param title Book Title
     * @param author Book Author
     * @param genre BookGenre Genre
     */
    public Book(String title, String author, BookGenre genre) {
        super(title);
        this.author = author;
        this.genre = genre;
    }

    /**
     * @param id LibraryItem Id
     * @param title Book Title
     * @param author Book Author
     * @param genre BookGenre Genre
     * @param avaliability Is this book avaliable?
     */
    public Book(int id, String title, String author, BookGenre genre, boolean avaliability) {
        super(id, title, avaliability);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public void printItem() {
        System.out.println(this.ItemName + " By " + this.author);
    }

    @Override
    public void printCheckedOutItem() {
        System.out.println(this.ItemName + " By " + this.author + "; Checked Out on " + this.CheckOutDate.get().toString() + " and Due on " + this.DueDate.get().toString());
    }

}
