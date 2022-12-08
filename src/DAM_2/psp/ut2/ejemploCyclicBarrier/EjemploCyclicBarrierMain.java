package DAM_2.psp.ut2.ejemploCyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class EjemploCyclicBarrierMain {

    public static void main(String[] args) {
        
        int numeroHilos = 100;
        final CyclicBarrier barreraInicio = new CyclicBarrier(numeroHilos + 1);
        final CyclicBarrier barreraFin = new CyclicBarrier(numeroHilos + 1);

        System.out.println("Creando hilos");
        for (int i = 0; i < numeroHilos; i++) {
            Thread hilo = new Thread() {
                @Override
                public void run() {
                    try {
                        barreraInicio.await();
                        System.out.println("hilo ejecutandose");
                        barreraFin.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            hilo.start();
        }

        try {
            System.out.println("levanto barrera");
            barreraInicio.await();
            barreraFin.await();
            System.out.println("todo acabado");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
