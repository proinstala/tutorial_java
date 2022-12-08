package DAM_1.Tareas.tareaUT7_verano;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    
    public static final String BLANCO = "\u001B[37m";
    public static final String VERDE = "\u001B[32m";
    public static final String PURPURA	= "\u001B[35m";
    public static final String ROJO = "\u001B[31m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";

    public static final String NEGRO_FONDO = "\u001B[40m";
    public static final String ROJO_FONDO = "\u001B[41m";


    public static void main(String[] args) {
        
        Scanner telcado = new Scanner(System.in);
        int menu = 0;
        int numeroCliente = 1;

        ArrayList<Cliente> listaClientes = new ArrayList<>();
       //ArrayList<Reserva> listaReservas = new ArrayList<>();

        /* 
        Cliente cliente1 = new Cliente(1, "David Jimenez", "48500100A", new Fecha(9,1,1986), new Caravana("Seat", 450, 230, false, 800, true));
        Cliente cliente2 = new Cliente(2, "Juan Martinez", "48600100B", new Fecha(10,8,1990), new Autocaravana("Opel", 600, 200, true, TIPO_AUTOCARAVANA.PERFILADA));

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        */

        //int[][] agosto = new int[30][4]; //31 dias. 5 parcelas

        System.out.println("\nBienvenido al --CAMPING-- para el mes de Agosto");
        System.out.println("-----------------------------------------------\n");

        while(menu != 9){
            System.out.println("Elije una opción: \n" 
            + VERDE 
            + "CLIENTES\n"
            + BLANCO 
            + "1. Ver clientes \n"
            + "2. Dar de alta un cliente \n"
            + "3. Dar de baja un cliente \n"
            + PURPURA
            + "\nPARCELAS\n"
            + BLANCO
            + "4. Mostrar el número de parcelas libres para un día \n"
            + "5. Mostrar los días libres para una parcela \n"
            + AMARILLO
            + "\nRESERVAS\n"
            + BLANCO
            + "6. Ver reservas \n"
            + "7. Realizar una reserva \n"
            + "8. Eliminar una reserva \n"
            + AZUL
            + "\nSALIR\n"
            + BLANCO
            + "9. Salir \n"
            );

            try {
                System.out.print("INTRODUCE EL NUMERO DE OPCION: ");
                menu = telcado.nextInt();
                if(menu < 1 || menu > 9){
                    System.out.println("\n" + ROJO_FONDO + "ERROR: el numero de opcion introducido no esta contemplado en el menu" + NEGRO_FONDO + "\n");
                    continue;
                }

                switch (menu) {
                    case 1: //Ver clientes
                    if(listaClientes.isEmpty()){
                        System.out.println("AVISO: La lista de clientes esta vacia.\n");
                    } else {
                        verClientes(listaClientes);
                    }
                        break;

                    case 2: //Dar de alta un cliente
                    listaClientes.add(altaCliente(numeroCliente));
                    numeroCliente++;
                        break;

                    case 3: //Dar de baja un cliente

                        break;
                        
                    case 4:

                        break;
                    case 5:

                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n" + ROJO_FONDO + "ERROR: El valor introducido no es un numero" + NEGRO_FONDO + "\n");
                telcado.nextLine();
            } catch (Exception e) {
                System.out.println("\n" + ROJO_FONDO + e.getMessage() + NEGRO_FONDO + "\n");
            }
            
        } //Fin while

        telcado.close();
    } //Fin void

    public static Cliente buscaCliente(ArrayList<Cliente> listaC, int numeroC) throws Exception{
        for (Cliente c : listaC) {
            if(c.getNumeroCliente() == numeroC) {
                return new Cliente(c);
            }
        }
        throw new Exception("ERROR: El numero de cliente insertado no esta en la lista");
    }

    public static void verClientes(ArrayList<Cliente> listaC){
        for (Cliente cliente : listaC) {
            System.out.println(cliente.toString());   
        }
    }

    public static Cliente altaCliente(int numeroCliente){
        Scanner teclado = new Scanner(System.in);
        Fecha fecha = new Fecha();
        System.out.println("Vamos a crear un nuevo cliente.");
        Cliente cliente = new Cliente();
        cliente.setNumeroCliente(numeroCliente);
        System.out.print("Introduce el nombre completo del cliente: ");
        cliente.setNombreCompleto(teclado.nextLine());
        System.out.print("Introduce DNI: ");
        cliente.setDni(teclado.nextLine());
        System.out.println("Fecha de nacimiento.");
        System.out.print("Introduce dia: ");
        fecha.setDia(teclado.nextInt()); 
        System.out.print("Introduce mes: ");
        fecha.setMes(teclado.nextInt());
        System.out.print("Introduce año: ");
        fecha.setAnio(teclado.nextInt());
        return cliente;
    }



} //Fin Clase Principal
