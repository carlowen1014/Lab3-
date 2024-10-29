// Carl Owen
// Lab 3
// DataReader Class
// This class reads and parses the CSV data file

import java.io.*;
import java.util.*;

//Reads data from a CSV file and returns a list of MyDataClass objects
public class DataReader
{
    public List<MyDataClass> readData(String filePath)
    {
        List<MyDataClass> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            //Skipping header
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                MyDataClass data = new MyDataClass(values[0], values[1], Double.parseDouble(values[2]));
                dataList.add(data);
            }
        } catch (IOException e)

        {
            e.printStackTrace();
        }
        return dataList;
    }
}
