package persistence;

import model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonenRepository {

    public List<Person> findAll() {

        try(VirtualTable table = new VirtualTable("SELECT * FROM PUBLIC.tbl_persons")){
           List<Person> persons = new ArrayList<>();

            while(table.next()){

                Person person = new Person(Integer.valueOf(table.getValue("ID")), table.getValue("FIRST_NAME"), table.getValue("LAST_NAME"));
                persons.add(person);
            }
            return persons;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
