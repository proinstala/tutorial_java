package DAM_2.psp.tareaUT2.ejercicio_1;


/**
 * Clase que representa una cuenta bancaria.
 * 
 * @author David Jimenez Alonso
 */
public class CuentaBancaria {
    
    //Campos de clase.
    private int saldo;

    /**
     * Crea un objeto de tipo cuentaBancaria.
     * Inicializa el saldo de la cuenta a 2000.
     */
    public CuentaBancaria() {
        saldo = 2000;
    }


    /**
     * 
     * @param cantidad valor que se va a restar o sumar a la cuenta.
     */
    public void addMovimiento(int cantidad) {
        
        int saldoAntes = saldo; //guardamos el saldo de la cuenta para mostrar despues la comparacion entre saldo antes y despues de movimiento.

        //Compruebo si la cantidad pasada por parametros es negativa o positiva para realizar la operacion de sumar o restar al saldo cuenta.
        if (cantidad > 0) { 
            saldo = saldo + cantidad;
        } else {
            saldo = saldo - cantidad;
        }

        //Dormimos el hilo para simular la operación.
        try {
            Thread.sleep((int)Math.round((Math.random()*2) +1) * 1000); // Duerme el hilo de 1 a 3 segundos.
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        //Mostramos el saldo antes y depues del movimiento y la cantidad del movimiento.
        System.out.println("Saldo antes: " + saldoAntes + "  Cantidad: " + cantidad + "  Saldo actual: " + saldo); 
    }
}
