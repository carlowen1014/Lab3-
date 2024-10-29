// Carl Owen
// Lab 3
// DataReader Class
// This class reads and parses the CSV data file

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    public List<MyDataClass> readData(String filePath) {
        List<MyDataClass> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Parse each line, assuming CSV format with three columns
                String[] values = line.split(",");
                String category = values[0];
                String date = values[1];
                double value = Double.parseDouble(values[2]);
                dataList.add(new MyDataClass(category, date, value));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }

        return dataList;
    }
}
