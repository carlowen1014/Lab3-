// Carl Owen
// Lab 3
// DataProcessor Class
//This class Processes the data, including sorting and filtering

import java.util.*;
import java.util.stream.Collectors;

//Processes data, including filtering and sorting
public class DataProcessor
{
    private List<MyDataClass> data;

    public DataProcessor(List<MyDataClass> data)
    {
        this.data = data;
    }

    //Filters data based on category, date range, or minimum value
    public List<MyDataClass> filterData(String category, String startDate, String endDate, double minValue)
    {
        return data.stream()
                .filter(d -> d.getCategory().equalsIgnoreCase(category) || category == null)
                .filter(d -> d.getDate().compareTo(startDate) >= 0 && d.getDate().compareTo(endDate) <= 0)
                .filter(d -> d.getValue() >= minValue)
                .collect(Collectors.toList());
    }

    //Sorts data by a specified field
    public List<MyDataClass> sortDataBy(String sortBy)
    {
        Comparator<MyDataClass> comparator = Comparator.comparing(MyDataClass::getDate);
        if ("Category".equalsIgnoreCase(sortBy)) comparator = Comparator.comparing(MyDataClass::getCategory);
        if ("Value".equalsIgnoreCase(sortBy)) comparator = Comparator.comparingDouble(MyDataClass::getValue);
        return data.stream().sorted(comparator).collect(Collectors.toList());
    }
}



