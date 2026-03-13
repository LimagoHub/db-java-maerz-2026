package presentation;

import persistence.Person;

import javax.swing.*;
import java.awt.*;

public class PersonenMaske extends JFrame {

    private final PersonenAdapter adapter = new PersonenAdapter();
    private JTextField txtVorname, txtNachname;
    private JList<Person> personenListe;

    public PersonenMaske() throws HeadlessException {
        setTitle("Personen-Verwaltung");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout(10, 10));

        // 3. Eingabe-Bereich (Oben)
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.add(new JLabel("Vorname:"));
        txtVorname = new JTextField();
        inputPanel.add(txtVorname);
        inputPanel.add(new JLabel("Nachname:"));
        txtNachname = new JTextField();
        inputPanel.add(txtNachname);

        // 4. Button zum Hinzufügen
        JButton btnAdd = new JButton("Hinzufügen");
        btnAdd.addActionListener(e -> personeHinzufuegen());

        // 5. Liste (Mitte)
        personenListe = new JList<>(adapter);

        // Komponenten zusammenbauen
        JPanel topContainer = new JPanel(new BorderLayout());
        topContainer.add(inputPanel, BorderLayout.CENTER);
        topContainer.add(btnAdd, BorderLayout.SOUTH);

        add(topContainer, BorderLayout.NORTH);
        add(new JScrollPane(personenListe), BorderLayout.CENTER);
    }

    private void personeHinzufuegen() {
        String vor = txtVorname.getText();
        String nach = txtNachname.getText();

        if(!vor.isEmpty() && !nach.isEmpty()) {
            // Wir interagieren NUR mit dem sauberen Model
            adapter.getServices().addPerson(new Person(0,vor, nach));

            // Dem Adapter sagen: "Hey, die Datenquelle ist neu!"
            adapter.refresh();

            // Felder leeren
            txtVorname.setText("");
            txtNachname.setText("");
            txtVorname.requestFocus();
        }
    }
}
