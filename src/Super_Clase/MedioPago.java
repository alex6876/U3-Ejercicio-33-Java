package Super_Clase;

public abstract class MedioPago {

    protected String titular;
    protected String moneda;
    protected double saldoDisponible;

    public MedioPago(String titular, String moneda, double saldoDisponible) {
        this.titular = titular;
        this.moneda = moneda;
        this.saldoDisponible = saldoDisponible;
    }

    public abstract void procesarCobro(double monto);

    public void mostrarComprobante(String medio, double monto) {

        System.out.println("===== COMPROBANTE DE PAGO =====");
        System.out.println("Titular: " + titular);
        System.out.println("Moneda: " + moneda);
        System.out.println("Medio de pago: " + medio);
        System.out.println("Monto: " + monto + " " + moneda);
    }
}