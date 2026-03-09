package tiere;

import java.util.Objects;

public class Schwein {


    // Instance variables
    private String name;
    private int gewicht;

    // Klassenvariablen
    private static int counter;

    public static int getCounter() {

        return counter;
    }


    /*
    // Anonymer Konstruktor
    {
        System.out.println("Komischer Konstruktor");
    }
    */

    static {
        counter = 0;
    }

    public Schwein() {
       this("Nobody");
    }

    public Schwein(final String name) {
        this.name = name;

        this.gewicht = 10;
        counter++;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Quuuuiek");
        counter--;
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
        setGewicht(getGewicht() + 1);
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
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final Schwein schwein = (Schwein) o;
        return gewicht == schwein.gewicht && Objects.equals(name, schwein.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gewicht);
    }


}
