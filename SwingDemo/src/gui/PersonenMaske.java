package gui;

import model.Person;
import model.PersonenVerwaltung;
import persistence.PersonenRepository;

import javax.swing.*;
import java.awt.*;

public class PersonenMaske extends JFrame {
    private PersonenVerwaltung verwaltung; // Das "saubere" Model
    private PersonenAdapter adapter;    // Der "Übersetzer"

    private JTextField txtVorname, txtNachname;
    private JList<Person> personenListe;

    public PersonenMaske() {
        // 1. Initialisierung der Logik

        verwaltung = new PersonenVerwaltung(new PersonenRepository());
        adapter = new PersonenAdapter(verwaltung);

        // 2. Fenster-Setup
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
        btnAdd.addActionListener(e -> personHinzufuegen());

        // 5. Liste (Mitte)
        personenListe = new JList<>(adapter);

        // Komponenten zusammenbauen
        JPanel topContainer = new JPanel(new BorderLayout());
        topContainer.add(inputPanel, BorderLayout.CENTER);
        topContainer.add(btnAdd, BorderLayout.SOUTH);

        add(topContainer, BorderLayout.NORTH);
        add(new JScrollPane(personenListe), BorderLayout.CENTER);
    }

    private void personHinzufuegen() {
        String vor = txtVorname.getText();
        String nach = txtNachname.getText();

        if(!vor.isEmpty() && !nach.isEmpty()) {
            // Wir interagieren NUR mit dem sauberen Model
            verwaltung.addPerson(new Person(0,vor, nach));

            // Dem Adapter sagen: "Hey, die Datenquelle ist neu!"
            adapter.refresh();

            // Felder leeren
            txtVorname.setText("");
            txtNachname.setText("");
            txtVorname.requestFocus();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PersonenMaske().setVisible(true));
    }
}