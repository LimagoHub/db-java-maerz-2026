package konten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Kontogruppe extends AbstractKonto{

    private final List<AbstractKonto> children = new ArrayList<>();

    public Kontogruppe(final String bezeichnung) {
        super(bezeichnung);
    }

    public void appendChild(final AbstractKonto abstractKonto) {

        abstractKonto.setParent(this);
        children.add(abstractKonto);

    }


    @Override
    public List<AbstractKonto> getChildren() {
        return Collections.unmodifiableList(children);
    }
}
