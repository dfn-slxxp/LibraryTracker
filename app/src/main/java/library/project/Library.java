package library.project;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

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

    public void loadLibraryFromCSV(InputStream stream) throws IOException, CsvException {
        this.members = new ArrayList<Member>();
        List<String[]> fileContents = this.readCSV(stream);
        for (String[] libraryInfo : fileContents) {
            
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
