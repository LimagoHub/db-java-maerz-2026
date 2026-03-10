package konten;

public class Kontogruppe extends AbstractKonto{

    public Kontogruppe(final String bezeichnung) {
        super(bezeichnung);
    }

    public void appendChild(final AbstractKonto konto) {
        konto.setParent(this);
    }
}
