package Sub_Clase;
import Super_Clase.MedioPago;

public class PagoCriptomoneda extends MedioPago {

    private String direccionWallet;
    private String redBlockchain;

    public PagoCriptomoneda(String titular, String moneda,
                            double saldoDisponible, String direccionWallet,
                            String redBlockchain) {

        super(titular, moneda, saldoDisponible);

        this.direccionWallet = direccionWallet;
        this.redBlockchain = redBlockchain;
    }

    @Override
    public void procesarCobro(double monto) {

        if (monto > 0 && monto <= saldoDisponible) {

            saldoDisponible -= monto;

            System.out.println("Transacción enviada a la blockchain.");
            System.out.println("Red utilizada: " + redBlockchain);
            System.out.println("Wallet: " + direccionWallet);
            System.out.println("Transacción confirmada.");

            mostrarComprobante("Criptomoneda", monto);

        } else {

            System.out.println("Transacción rechazada: saldo insuficiente o monto inválido.");
        }
    }
}