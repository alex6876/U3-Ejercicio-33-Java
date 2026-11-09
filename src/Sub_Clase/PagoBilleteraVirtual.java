package Sub_Clase;
import Super_Clase.MedioPago;

public class PagoBilleteraVirtual extends MedioPago {

    private String alias;
    private double limiteDiario;
    private double montoUtilizadoHoy;

    public PagoBilleteraVirtual(String titular, String moneda,
                                double saldoDisponible, String alias,
                                double limiteDiario) {

        super(titular, moneda, saldoDisponible);

        this.alias = alias;
        this.limiteDiario = limiteDiario;
        this.montoUtilizadoHoy = 0;
    }

    @Override
    public void procesarCobro(double monto) {

        if (monto > 0
                && monto <= saldoDisponible
                && montoUtilizadoHoy + monto <= limiteDiario) {

            saldoDisponible -= monto;
            montoUtilizadoHoy += monto;

            System.out.println("Pago con billetera virtual aprobado.");
            System.out.println("Alias: " + alias);
            mostrarComprobante("Billetera virtual", monto);

        } else {

            System.out.println("Pago rechazado: se superó el saldo o el límite diario.");
        }
    }
}
