package gui;

import javax.swing.table.AbstractTableModel;

public class PersonenTableAdapter extends AbstractTableModel {
    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        return null;
    }
}
