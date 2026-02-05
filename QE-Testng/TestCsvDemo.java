package demos;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class TestCsvDemo {

    @DataProvider(name = "csvData")
    public Iterator<Object[]> getCsvData() throws IOException, CsvValidationException {
        List<Object[]> data = new ArrayList<>();
        String csvPath = "src/test/resources/input.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvPath))) {
            String[] line;
            // Skip first line because headings
            reader.readNext();

            while ((line = reader.readNext()) != null) {
                data.add(line);
            }
        }
        return data.iterator();
    }

    @Test(dataProvider = "csvData")
    public void verifyUserDetails(String username, String role, String status) {
        System.out.println("Testing user: " + username + " | Role: " + role + " | Status: " + status);
    }

}