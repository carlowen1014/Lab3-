// Carl Owen
// Lab 3
// Main Class
// This class is the main driver of the program and
// sets up to run the GUI

import java.awt.*;
import java.util.List;
import javax.swing.*;

public class MainApplication extends JFrame
{
    private TablePanel tablePanel;
    private FilterPanel filterPanel;
    private StatsPanel statsPanel;
    private ChartPanel chartPanel;
    private DetailsPanel detailsPanel;
    private DataProcessor dataProcessor;

    public MainApplication(List<MyDataClass> data)
    {
        dataProcessor = new DataProcessor(data);

        tablePanel = new TablePanel(data);
        filterPanel = new FilterPanel(e -> applyFilters());
        statsPanel = new StatsPanel(data);
        chartPanel = new ChartPanel(data);
        detailsPanel = new DetailsPanel();

        tablePanel.getTable().getSelectionModel().addListSelectionListener(e ->
        {
            int selectedRow = tablePanel.getTable().getSelectedRow();
            if (selectedRow >= 0)
            {
                MyDataClass selectedItem = data.get(selectedRow);
                detailsPanel.showDetails(selectedItem);
            }
        });

        setLayout(new BorderLayout());
        add(filterPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        add(statsPanel, BorderLayout.WEST);
        add(chartPanel, BorderLayout.EAST);
        add(detailsPanel, BorderLayout.SOUTH);

        setTitle("Data Viewer");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Applies filters and updates all panels
    private void applyFilters()
    {
        String category = filterPanel.getSelectedCategory();
        String startDate = filterPanel.getStartDate();
        String endDate = filterPanel.getEndDate();
        int minValue = filterPanel.getMinValue();

        List<MyDataClass> filteredData = dataProcessor.filterData(category, startDate, endDate, minValue);
        tablePanel.updateTable(filteredData);
        statsPanel.updateStats(filteredData);
        chartPanel.updateChart(filteredData);
    }

    public static void main(String[] args)
    {
        DataReader reader = new DataReader();
        List<MyDataClass> data = reader.readData("path_to_your_file.csv");
        new MainApplication(data);
    }
}
