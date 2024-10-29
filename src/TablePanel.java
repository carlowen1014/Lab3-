// Carl Owen
// Lab 3
// TablePanel Class
//This class displays data in a table with sorting capabilities

import javax.swing.*;
import javax.swing.table.*;
import java.util.List;

//Displays data in a table
public class TablePanel extends JPanel
{
    private JTable table;
    private DefaultTableModel tableModel;

    public TablePanel(List<MyDataClass> data)
    {
        tableModel = new DefaultTableModel(new String[]{"Category", "Date", "Value"}, 0);
        table = new JTable(tableModel);
        updateTable(data);
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    //Updates the table with new data
    public void updateTable(List<MyDataClass> data)
    {
        tableModel.setRowCount(0);  // Clear existing data
        for (MyDataClass item : data)
        {
            tableModel.addRow(new Object[]{item.getCategory(), item.getDate(), item.getValue()});
        }
    }
}

