// Carl Owen
// Lab 3
// TablePanel Class
//This class displays data in a table with sorting capabilities

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TablePanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;

    public TablePanel(List<MyDataClass> data) {
        tableModel = new DefaultTableModel(new String[]{"Category", "Date", "Value"}, 0);
        table = new JTable(tableModel);
        updateTable(data);
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    // Getter for the JTable to allow MainApplication to access it
    public JTable getTable() {
        return table;
    }

    // Updates the table with new data
    public void updateTable(List<MyDataClass> data) {
        tableModel.setRowCount(0);  // Clear existing data
        for (MyDataClass item : data) {
            tableModel.addRow(new Object[]{item.getCategory(), item.getDate(), item.getValue()});
        }
    }
}
