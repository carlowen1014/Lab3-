// Carl Owen
// Lab 3
// DetailsPanel Class
// This class shows details for the item selected in TablePanel

import javax.swing.*;
import java.awt.*;

public class DetailsPanel extends JPanel {
    private JTextArea detailsArea;

    public DetailsPanel() {
        detailsArea = new JTextArea(10, 30);
        detailsArea.setEditable(false);
        setLayout(new BorderLayout());
        add(new JScrollPane(detailsArea), BorderLayout.CENTER);
    }

    // Display details of selected item
    public void showDetails(MyDataClass item) {
        detailsArea.setText(item != null ? item.toString() : "No item selected");
    }
}

