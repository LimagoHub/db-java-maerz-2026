package konten;

public class Konto extends AbstractKonto{

    private double saldo;

    public Konto(final String bezeichnung, double saldo) {
        super(bezeichnung);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(final double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return super.toString() + ", saldo=" + saldo;
    }
}
