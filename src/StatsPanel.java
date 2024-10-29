// Carl Owen
// Lab 3
// StatsPanel Class
// This class updates with average, max, and min values
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StatsPanel extends JPanel
{
    private JLabel avgLabel, maxLabel, minLabel;

    public StatsPanel(List<MyDataClass> data)
    {
        setLayout(new GridLayout(3, 1));

        avgLabel = new JLabel("Average Value: " + calculateAverage(data));
        maxLabel = new JLabel("Max Value: " + findMax(data));
        minLabel = new JLabel("Min Value: " + findMin(data));

        add(avgLabel);
        add(maxLabel);
        add(minLabel);
    }

    private double calculateAverage(List<MyDataClass> data)
    {
        return data.stream().mapToDouble(MyDataClass::getValue).average().orElse(0.0);
    }

    private double findMax(List<MyDataClass> data)
    {
        return data.stream().mapToDouble(MyDataClass::getValue).max().orElse(0.0);
    }

    private double findMin(List<MyDataClass> data)
    {
        return data.stream().mapToDouble(MyDataClass::getValue).min().orElse(0.0);
    }

    //Refresh stats with updated data
    public void updateStats(List<MyDataClass> data)
    {
        avgLabel.setText("Average Value: " + calculateAverage(data));
        maxLabel.setText("Max Value: " + findMax(data));
        minLabel.setText("Min Value: " + findMin(data));
    }
}

