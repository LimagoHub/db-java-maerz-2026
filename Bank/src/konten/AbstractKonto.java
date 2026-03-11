package konten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractKonto implements Iterable<AbstractKonto>{

    private AbstractKonto parent=null;
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

    public List<AbstractKonto> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        //sb.append(" parent=").append(parent.bezeichnung);
        sb.append(", bezeichnung='").append(bezeichnung).append('\'');

        return sb.toString();
    }

    @Override
    public Iterator<AbstractKonto> iterator() {
        List<AbstractKonto> result = new ArrayList<>();
        iteratorHelper(result);
        return result.iterator();
    }

    private void iteratorHelper(List<AbstractKonto> result) {
        result.add(this);
        for (AbstractKonto child : getChildren()) {
            child.iteratorHelper(result);
        }
    }
}
