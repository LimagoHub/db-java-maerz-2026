package gui;


import repo.Person;
import service.PersonenServices;

import javax.swing.table.AbstractTableModel;

public class PersonenTableAdapter extends AbstractTableModel {

    private final PersonenServices services = PersonenServices.getInstance();

    @Override
    public int getRowCount() {
        return services.getPersonen().size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        Person person = services.getPersonen().get(rowIndex);
        switch (columnIndex) {
            case 0: return person.id();
            case 1: return person.vorname();
            case 2: return person.nachname();
            default: return null;
        }
    }

    public void refresh() {
        fireTableDataChanged();
    }
}
