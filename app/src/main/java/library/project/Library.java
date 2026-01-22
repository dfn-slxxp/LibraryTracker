package library.project;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import library.project.Items.Book;
import library.project.Items.Book.BookGenre;
import library.project.Items.Device.DeviceType;
import library.project.Items.Disk.DiskType;
import library.project.Items.Newspaper.NewspaperPublisher;
import library.project.Items.Device;
import library.project.Items.Disk;
import library.project.Items.Newspaper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Library {

    protected ArrayList<Member> members;
    protected ArrayList<LibraryItem> items;

    // Constructor
    public Library(ArrayList<LibraryItem> items) {
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

    public void loadItems(InputStream stream) throws IOException, CsvException {
        this.items = new ArrayList<LibraryItem>();
        List<String[]> fileContents = this.readCSV(stream);
        for (String[] item : fileContents) {
            switch (item[0]) {
                case "Book":
                    this.items.add(new Book(Integer.valueOf(item[1]), item[2], item[3], BookGenre.fromString(item[4]), true));
                    break;
                case "Device":
                    this.items.add(new Device(Integer.valueOf(item[1]), item[2], DeviceType.fromString(item[4]), true));
                    break;
                case "Disk":
                    this.items.add(new Disk(Integer.valueOf(item[1]), item[2], DiskType.fromString(item[4]), true));
                    break;
                case "Newspaper":
                    this.items.add(new Newspaper(Integer.valueOf(item[1]), item[2], NewspaperPublisher.fromString(item[4]), true));
                    break;
            }
        }
    }

    public void sortMembersById() {
        
    }

    public void loadMembers(InputStream stream) throws IOException, CsvException {
        this.members = new ArrayList<Member>();
        List<String[]> fileContents = this.readCSV(stream);
        for (String[] member : fileContents) {
            this.members.add(new Member(member[1], Integer.valueOf(member[0])));
        }
    }

    public void loadCheckouts(InputStream stream) throws IOException, CsvException {
        this.members = new ArrayList<Member>();
        List<String[]> fileContents = this.readCSV(stream);
        for (String[] checkouts : fileContents) {
            
        }
    }

    private List<String[]> readCSV(InputStream stream) throws IOException, CsvException {
        try (InputStreamReader reader = new InputStreamReader(stream)) {
            try (CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build()) {
                return csvReader.readAll();
            }
        }
    }

}
