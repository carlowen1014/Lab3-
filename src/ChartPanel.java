// Carl Owen
// Lab 3
// ChartPanel Class
// This class displays data as a line chart and updates on filtering

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChartPanel extends JPanel
{
    private List<MyDataClass> data;

    public ChartPanel(List<MyDataClass> data)
    {
        this.data = data;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (data == null || data.isEmpty()) return;

        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        int padding = 50;
        int labelPadding = 25;
        int barWidth = (width - 2 * padding) / data.size();

        double maxDataValue = data.stream().mapToDouble(MyDataClass::getValue).max().orElse(1);

        //Draws axes
        g2d.drawLine(padding, height - padding, padding, padding); // y-axis
        g2d.drawLine(padding, height - padding, width - padding, height - padding); // x-axis

        //Draws bars
        for (int i = 0; i < data.size(); i++)
        {
            int x = padding + i * barWidth;
            int barHeight = (int) ((data.get(i).getValue() / maxDataValue) * (height - 2 * padding));
            int y = height - padding - barHeight;
            g2d.setColor(Color.BLUE);
            g2d.fillRect(x, y, barWidth - 2, barHeight);

            //Draws labels
            g2d.setColor(Color.BLACK);
            String label = data.get(i).getCategory();
            int labelWidth = g2d.getFontMetrics().stringWidth(label);
            g2d.drawString(label, x + (barWidth - labelWidth) / 2, height - padding + labelPadding);
        }
    }

    //Update the chart data
    public void updateChart(List<MyDataClass> newData)
    {
        this.data = newData;
        repaint();
    }
}
