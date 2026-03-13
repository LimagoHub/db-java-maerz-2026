package repo.impl;



import repo.Person;
import repo.PersonRepository;

import java.util.ArrayList;
import java.util.List;
// Nur Datenbanktechnik
public class PersonenRepositoryImpl implements PersonRepository {
    @Override
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
