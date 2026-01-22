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

        sortItemsByID();
    }

    public void sortMembersByID() {
        for (int i = 0; i < this.members.size() - 1; i++) {

            int min_idx = i;

            for (int j = i + 1; j < this.members.size() - 1; j++) {

                if (members.get(j).getId() < members.get(min_idx).getId()) {

                    min_idx = j;

                }

            }

            Member tmp = members.get(i);
            members.set(i, members.get(min_idx));
            members.set(min_idx, tmp);

        }

        Member.updateNextID(members.getLast().getId());
    }

    public void sortItemsByID() {
        for (int i = 0; i < this.items.size() - 1; i++) {

            int min_idx = i;

            for (int j = i + 1; j < this.items.size() - 1; j++) {

                if (items.get(j).getId() < items.get(min_idx).getId()) {

                    min_idx = j;

                }

            }

            LibraryItem tmp = items.get(i);
            items.set(i, items.get(min_idx));
            items.set(min_idx, tmp);

        }

        LibraryItem.updateNextID(items.getLast().getId());
    }

    public void loadMembers(InputStream stream) throws IOException, CsvException {
        this.members = new ArrayList<Member>();
        List<String[]> fileContents = this.readCSV(stream);
        for (String[] member : fileContents) {
            this.members.add(new Member(member[1], Integer.valueOf(member[0])));
        }
        sortMembersByID();
    }

    public Member getMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    public LibraryItem getItemById(int id) {
        for (LibraryItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void loadCheckouts(InputStream stream) throws IOException, CsvException {
        this.members = new ArrayList<Member>();
        List<String[]> fileContents = this.readCSV(stream);
        for (String[] checkouts : fileContents) {
            int member_iden = Integer.parseInt(checkouts[0]);
            int item_iden = Integer.parseInt(checkouts[1]);
            Date checkout_date = Date.fromString(checkouts[2]);

            getMemberById(member_iden).CheckOutItem(getItemById(item_iden), checkout_date);
        }
    }

    private List<String[]> readCSV(InputStream stream) throws IOException, CsvException {
        try (InputStreamReader reader = new InputStreamReader(stream)) {
            try (CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build()) {
                return csvReader.readAll();
            }
        }
    }

    public ArrayList<LibraryItem> getCheckedOutItems() {
        ArrayList<LibraryItem> checkedOut = new ArrayList<LibraryItem>();
        for (LibraryItem item : items) {
            if (item.checkAvaliability() == false) {
                checkedOut.add(item);
            }
        }
        return checkedOut;
    }

    public ArrayList<LibraryItem> getItemsDueSoonest() {
        ArrayList<LibraryItem> checkedOut = getCheckedOutItems();
        boolean swapped;
        LibraryItem temp;

        for (int i = 0; i < checkedOut.size() - 1; i++) {

            swapped = false;

            for (int j = 0; i < checkedOut.size() - i - 1; j++) {

                if (false == checkedOut.get(j).getDueDate().isEarlier(checkedOut.get(j + 1).getDueDate())) {

                    temp = checkedOut.get(j);
                    checkedOut.set(j, checkedOut.get(j + 1));
                    checkedOut.set(j + 1, temp);
                    swapped = true;

                }

            }

            if (swapped == false) {
                break;
            }

        }

        return checkedOut;

    }


}
