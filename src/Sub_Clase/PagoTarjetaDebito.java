package Sub_Clase;
import Super_Clase.MedioPago;

public class PagoTarjetaDebito extends MedioPago {

    private String numeroTarjeta;
    private String claveInterbancaria;

    public PagoTarjetaDebito(String titular, String moneda,
                             double saldoDisponible, String numeroTarjeta,
                             String claveInterbancaria) {

        super(titular, moneda, saldoDisponible);

        this.numeroTarjeta = numeroTarjeta;
        this.claveInterbancaria = claveInterbancaria;
    }

    @Override
    public void procesarCobro(double monto) {

        if (monto > 0 && monto <= saldoDisponible) {

            saldoDisponible -= monto;

            System.out.println("Pago con tarjeta aprobado.");
            mostrarComprobante("Tarjeta de débito", monto);

        } else {

            System.out.println("Pago rechazado: saldo insuficiente o monto inválido.");
        }
    }
}