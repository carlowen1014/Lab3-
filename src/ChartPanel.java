// Carl Owen
// Lab 3
// ChartPanel Class
// This class displays data as a line chart and updates on filtering

import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.List;

public class ChartPanel extends JPanel
{
    private DefaultCategoryDataset dataset;

    public ChartPanel(List<MyDataClass> data)
    {
        dataset = new DefaultCategoryDataset();
        populateDataset(data);

        JFreeChart chart = ChartFactory.createLineChart(
                "Data Values Over Time", "Date", "Value", dataset);
        ChartPanel chartPanel = new ChartPanel(chart);

        setLayout(new BorderLayout());
        add(chartPanel, BorderLayout.CENTER);
    }

    private void populateDataset(List<MyDataClass> data)
    {
        for (MyDataClass item : data)
        {
            dataset.addValue(item.getValue(), "Value", item.getDate());
        }
    }

    //Update chart data
    public void updateChart(List<MyDataClass> data)
    {
        dataset.clear();
        populateDataset(data);
    }
}

