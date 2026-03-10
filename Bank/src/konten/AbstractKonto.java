package konten;

public class AbstractKonto {

    private AbstractKonto parent;
    private String bezeichnung;

    public AbstractKonto(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public AbstractKonto getParent() {
        return parent;
    }

    public void setParent(final AbstractKonto parent) {
        this.parent = parent;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(final String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append(" parent=").append(parent.bezeichnung);
        sb.append(", bezeichnung='").append(bezeichnung).append('\'');

        return sb.toString();
    }
}
