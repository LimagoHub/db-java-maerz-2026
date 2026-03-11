package tiere;


import java.util.Objects;

public class Schwein extends Object{

    private String name;
    private int gewicht;

    public Schwein() {
        this("Nobody");
    }

    public Schwein(final String name) {
        this.name = name;
        this.gewicht = 10;
    }

    public Schwein(final String name, final int gewicht) {
        this.name = name;
        this.gewicht = gewicht;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getGewicht() {
        return gewicht;
    }

    private void setGewicht(final int gewicht) {
        this.gewicht = gewicht;
    }

    public void fuettern() {
        gewicht++;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Schwein{");
        sb.append("name='").append(name).append('\'');
        sb.append(", gewicht=").append(gewicht);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object otherPig) {
        if (otherPig == null || getClass() != otherPig.getClass()) return false;
        final Schwein schwein = (Schwein) otherPig;
        return gewicht == schwein.gewicht && Objects.equals(name, schwein.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gewicht);
    }


}
