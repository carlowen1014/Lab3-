// Carl Owen
// Lab 3
// FilterPanel Class
// This class contains filter options that update the table when toggled.


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

//Panel containing filter options
public class FilterPanel extends JPanel
{
    private JComboBox<String> categoryFilter;
    private JTextField startDateField, endDateField;
    private JSlider minValueSlider;

    public FilterPanel(ActionListener filterListener)
    {
        setLayout(new GridLayout(4, 2));

        categoryFilter = new JComboBox<>(new String[]{"All", "Category1", "Category2"});
        startDateField = new JTextField("YYYY-MM-DD");
        endDateField = new JTextField("YYYY-MM-DD");
        minValueSlider = new JSlider(0, 100, 10);

        add(new JLabel("Category:"));
        add(categoryFilter);
        add(new JLabel("Start Date:"));
        add(startDateField);
        add(new JLabel("End Date:"));
        add(endDateField);
        add(new JLabel("Min Value:"));
        add(minValueSlider);

        categoryFilter.addActionListener(filterListener);
        startDateField.addActionListener(filterListener);
        endDateField.addActionListener(filterListener);
        minValueSlider.addChangeListener(e -> filterListener.actionPerformed(null));
    }

    //Getters for filter criteria
    public String getSelectedCategory() { return (String) categoryFilter.getSelectedItem(); }
    public String getStartDate() { return startDateField.getText(); }
    public String getEndDate() { return endDateField.getText(); }
    public int getMinValue() { return minValueSlider.getValue(); }
}
