package library.project.Items;

import library.project.Date;
import library.project.LibraryItem;

public class Newspaper extends LibraryItem {
    
    public enum NewspaperPublisher {
        NEW_YORK_TIMES,
        LOS_ANGELES_TIMES,
        WALL_STREET_JOURNAL,
        USA_TODAY,
        WASHINGTON_POST,
        OTHER;

        public static NewspaperPublisher fromString(String str) {
            switch (str) {
                case "NYT":
                    return NewspaperPublisher.NEW_YORK_TIMES;
                case "LAT":
                    return NewspaperPublisher.LOS_ANGELES_TIMES;
                case "WSJ":
                    return NewspaperPublisher.WALL_STREET_JOURNAL;
                case "USA Today":
                    return NewspaperPublisher.USA_TODAY;
                case "Washington Post":
                    return NewspaperPublisher.WASHINGTON_POST;
                default:
                    return NewspaperPublisher.OTHER;
            }
        }
    }

    protected NewspaperPublisher publisher;
    protected Date publishDate;

    // Constructor
    /**
     * 
     * @param name
     * @param publisher
     * @param publishDate
     */
    public Newspaper(String name, NewspaperPublisher publisher, Date publishDate) {
        super(name);
        this.publisher = publisher;
        this.publishDate = publishDate;
    }

    /**
     * 
     * @param id
     * @param name
     * @param publisher
     * @param avaliability
     */
    public Newspaper(int id, String name, NewspaperPublisher publisher, boolean avaliability){
        super(id, name, avaliability);
        this.publisher = publisher;
    }

    @Override
    public void printItem() {
        System.out.println(this.publisher.toString() + " Newspaper from " + this.publishDate.toString() + " with Title " + this.ItemName);
    }

    @Override
    public void printCheckedOutItem() {
        System.out.println(this.publisher.toString() + " Newspaper from " + this.publishDate.toString() + " with Title " + this.ItemName + "; Checked Out on " + this.CheckOutDate.get().toString() + " and Due on " + this.DueDate.get().toString());
    }

}
