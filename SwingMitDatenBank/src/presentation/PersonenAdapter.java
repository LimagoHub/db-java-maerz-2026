package presentation;

import persistence.Person;
import service.PersonenServices;

import javax.swing.*;

public class PersonenAdapter extends AbstractListModel<Person> {

    private final PersonenServices services = PersonenServices.getInstance();
    @Override
    public int getSize() {
        return services.getPersonen().size();
    }

    @Override
    public Person getElementAt(final int index) {
        return services.getPersonen().get(index);
    }

    public PersonenServices getServices() {
        return services;
    }

    public void refresh() {
        fireContentsChanged(this, 0, getSize() - 1);
    }
}
