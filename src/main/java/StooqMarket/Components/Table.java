package StooqMarket.Components;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {
    private String[] columnNames = {"Symbol", "Nazwa", "Kurs"};
    private static String[][] data = new String[][]{};
    private DefaultTableModel model;

    public Table(int width, int height, int x, int y) {

        data = RefreshTableButton.getData();
        setSize(width, height);
        setLocation(x, y);
        setBorder(new BevelBorder(1));
        setVisible(true);

        model = new DefaultTableModel(columnNames, data.length);

        for (int i = 0; i < data.length; i++) {
            model.insertRow(i, data[i]);
        }

        setModel(model);
    }

    public void setData(String[][] data){
        Table.data = data;

        model = new DefaultTableModel(columnNames, data.length);
        for (int i = 0; i < data.length; i++) {
            model.insertRow(i, data[i]);
        }

        setModel(model);
    }
}
