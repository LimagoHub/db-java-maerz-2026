package main;

import konten.AbstractKonto;
import konten.Konto;
import konten.Kontogruppe;

public class Main {

    public static void main(String[] args) {
        Kontogruppe root = new Kontogruppe("Bilanz 2026");

        // --- AST 1: AKTIVA (Sehr tief: 4 Ebenen) ---
        Kontogruppe aktiva = new Kontogruppe("Aktiva");
        root.appendChild(aktiva);

        Kontogruppe umlaufvermoegen = new Kontogruppe("Umlaufvermögen");
        aktiva.appendChild(umlaufvermoegen);

        Kontogruppe zahlungsmittel = new Kontogruppe("Zahlungsmittel");
        umlaufvermoegen.appendChild(zahlungsmittel);

        // Hier erreichen wir Ebene 4
        zahlungsmittel.appendChild(new Konto("Hauptkasse", 1500.50));
        zahlungsmittel.appendChild(new Konto("Postbank", 45000.00));
        zahlungsmittel.appendChild(new Konto("Tresor Barbestand", 12000.00));
        zahlungsmittel.appendChild(new Konto("Bitcoins", 8500.00));
        zahlungsmittel.appendChild(new Konto("Fremdwährung USD", 300.00));

        // --- AST 2: PASSIVA (Mitteltief: 3 Ebenen) ---
        Kontogruppe passiva = new Kontogruppe("Passiva");
        root.appendChild(passiva);

        Kontogruppe verbindlichkeiten = new Kontogruppe("Verbindlichkeiten");
        passiva.appendChild(verbindlichkeiten);

        verbindlichkeiten.appendChild(new Konto("Darlehen Bank", -100000.00));
        verbindlichkeiten.appendChild(new Konto("Verbindlichkeiten LuL", -15200.00));
        verbindlichkeiten.appendChild(new Konto("Umsatzsteuer-Schuld", -2400.00));
        verbindlichkeiten.appendChild(new Konto("Lohnsteuer-Schuld", -1800.00));
        verbindlichkeiten.appendChild(new Konto("Sonstige Kredite", -500.00));

        // --- AST 3: ERTRÄGE (Flach: 2 Ebenen) ---
        Kontogruppe ertraege = new Kontogruppe("Erträge");
        root.appendChild(ertraege);

        ertraege.appendChild(new Konto("Umsatzerlöse 19%", 120000.00));
        ertraege.appendChild(new Konto("Umsatzerlöse 7%", 15000.00));
        ertraege.appendChild(new Konto("Zinserträge", 120.00));
        ertraege.appendChild(new Konto("Mieterträge", 2400.00));
        ertraege.appendChild(new Konto("Sonstige Erträge", 50.00));

        // --- AST 4: AUFWENDUNGEN (2 Ebenen) ---
        Kontogruppe aufwand = new Kontogruppe("Aufwendungen");
        root.appendChild(aufwand);

        aufwand.appendChild(new Konto("Büromaterial", 450.00));
        aufwand.appendChild(new Konto("Miete Büro", 12000.00));
        aufwand.appendChild(new Konto("Personalkosten", 85000.00));
        aufwand.appendChild(new Konto("Fortbildung", 3200.00));
        aufwand.appendChild(new Konto("IT-Infrastruktur", 1400.00));

        // --- AST 5: PRIVAT (Sehr flach: direkt unter Root) ---
        root.appendChild(new Konto("Privatentnahme", 5000.00));
        root.appendChild(new Konto("Privateinlage", -2000.00));
        root.appendChild(new Konto("Privatsteuern", 1200.00));
        root.appendChild(new Konto("Versicherungen", 800.00));
        root.appendChild(new Konto("Sonstiges Privat", 150.00));

        root.forEach(System.out::println);
    }

    static void travers(AbstractKonto abstractKonto) {
        System.out.println(abstractKonto);
        for (AbstractKonto child : abstractKonto.getChildren()) {
            travers(child);
        }
    }
}
