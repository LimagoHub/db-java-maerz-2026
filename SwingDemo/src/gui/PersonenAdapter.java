package gui;

import model.Person;
import model.PersonenVerwaltung;

import javax.swing.*;

public class PersonenAdapter extends AbstractListModel<Person> {

    private final PersonenVerwaltung verwaltung;

    public PersonenAdapter(PersonenVerwaltung verwaltung) {
        this.verwaltung = verwaltung;
    }


    @Override
    public int getSize() {
        // Der Adapter fragt das technikfreie Model
        return verwaltung.getPersonen().size();
    }

    @Override
    public Person getElementAt(int index) {
        // Der Adapter holt die Daten aus dem technikfreien Model
        return verwaltung.getPersonen().get(index);
    }

    // Wenn sich Daten ändern, muss der Adapter die JList informieren
    public void refresh() {
        fireContentsChanged(this, 0, getSize() - 1);
    }
}
