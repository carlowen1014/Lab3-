// Carl Owen
// Lab 3
// DataClass Class
// This class Represents the data structure, with fields corresponding
// to the columns in your CSV file.

//Represents a single data entry in the dataset
public class MyDataClass
{
    private String category;
    private String date;
    private double value;

    //Constructor to initialize data fields
    public MyDataClass(String category, String date, double value)
    {
        this.category = category;
        this.date = date;
        this.value = value;
    }

    //Getters for each field
    public String getCategory() { return category; }
    public String getDate() { return date; }
    public double getValue() { return value; }

    //toString for displaying details in DetailsPanel
    @Override
    public String toString() {
        return "Category: " + category + ", Date: " + date + ", Value: " + value;
    }
}

