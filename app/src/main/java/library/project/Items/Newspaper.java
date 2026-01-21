package library.project.Items;

import library.project.Date;
import library.project.LibraryItem;

public class Newspaper extends LibraryItem {
    
    protected enum NewspaperPublisher {
        NEW_YORK_TIMES,
        LOS_ANGELES_TIMES,
        WALL_STREET_JOURNAL,
        USA_TODAY,
        WASHINGTON_POST
    }

    protected NewspaperPublisher publisher;
    protected Date publishDate;

    // Constructor
    public Newspaper(String name, NewspaperPublisher publisher, Date publishDate) {
        super(name);
        this.publisher = publisher;
        this.publishDate = publishDate;
    }

    public Newspaper(int id, String name, NewspaperPublisher publisher, boolean avaliability){
        super(id, name, avaliability);
        this.publisher = publisher;
    }

}
