import Super_Clase.MedioPago;
import Sub_Clase.PagoBilleteraVirtual;
import Sub_Clase.PagoCriptomoneda;
import Sub_Clase.PagoTarjetaDebito;

public class Main {

    public static void main(String[] args) {

        MedioPago[] medios = new MedioPago[3];

        medios[0] = new PagoTarjetaDebito(
                "Juan Perez",
                "ARS",
                50000,
                "4500123412341234",
                "0720000720000000012345"
        );

        medios[1] = new PagoCriptomoneda(
                "Maria Lopez",
                "BTC",
                1.5,
                "0xABC123456",
                "Ethereum"
        );

        medios[2] = new PagoBilleteraVirtual(
                "Pedro Gomez",
                "ARS",
                80000,
                "pedro.mp",
                30000
        );

        double[] montos = {15000, 0.25, 12000};

        System.out.println("===== SISTEMA DE PAGOS ELECTRÓNICOS =====");

        for (int i = 0; i < medios.length; i++) {

            System.out.println("\n--- OPERACIÓN " + (i + 1) + " ---");

            medios[i].procesarCobro(montos[i]);
        }

        System.out.println("\n--- SEGUNDO PAGO DE BILLETERA ---");

        medios[2].procesarCobro(25000);
    }
}