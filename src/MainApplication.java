// Carl Owen
// Lab 3
// Main Class
// This class is the main driver of the program and
// sets up to run the GUI

import java.awt.*;
import java.util.List;

public class MainApplication extends JFrame
{
    private TablePanel tablePanel;
    private FilterPanel filterPanel;
    private DataProcessor dataProcessor;

    public MainApplication(List<MyDataClass> data)
    {
        dataProcessor = new DataProcessor(data);

        tablePanel = new TablePanel(data);
        filterPanel = new FilterPanel(e -> applyFilters());

        setLayout(new BorderLayout());
        add(tablePanel, BorderLayout.CENTER);
        add(filterPanel, BorderLayout.NORTH);

        setTitle("Data Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Applies filters based on user selections
    private void applyFilters()
    {
        String category = filterPanel.getSelectedCategory();
        String startDate = filterPanel.getStartDate();
        String endDate = filterPanel.getEndDate();
        int minValue = filterPanel.getMinValue();

        List<MyDataClass> filteredData = dataProcessor.filterData(category, startDate, endDate, minValue);
        tablePanel.updateTable(filteredData);
    }

    public static void main(String[] args)
    {
        DataReader reader = new DataReader();
        List<MyDataClass> data = reader.readData("path_to_your_file.csv");
        new MainApplication(data);
    }
}
