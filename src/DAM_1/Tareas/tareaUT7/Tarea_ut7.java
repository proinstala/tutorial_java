
package DAM_1.Tareas.tareaUT7;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class Tarea_ut7 {

    public static final int LARGO_PARCELA = 1000;
    public static final int ANCHO_PARCELA = 500;

    public static final String NEGRO_FONDO = "\u001B[40m";
    public static final String BLANCO = "\u001B[37m";
    public static final String VERDE = "\u001B[32m";
    public static final String PURPURA	= "\u001B[35m";
    public static final String ROJO = "\u001B[31m";
    public static final String ROJO_FONDO = "\u001B[41m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";

    public static void main(String[] args) {
        
        int numeroCliente = 1;
        int numeroReserva = 1;
        int auxNumeroCliente;
        int auxNumeroReserva;
        int parcelas[][] = new int[5][31];
        int dia;
        int auxParcela;
        
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
        
        
        //APARTADO 2 DE LA TAREA ---------------------------------------------------------------------------------------------------------------
        
        //CREO 2 CLIENTES
        Cliente cliente1 = new Cliente(1, "David Jimenez", "48500100A", new Fecha(9,1,1986), new Caravana("Seat", 450, 230, false, 800, true));
        Cliente cliente2 = new Cliente(2, "Juan Martinez", "48600100B", new Fecha(10,8,1990), new Autocaravana("Opel", 600, 200, true, TIPO_AUTOCARAVANA.PERFILADA));
        
        
        //CREO 2 RESERVAS USANDO LOS CLIENTES DEL PASO ANTERIOR
        Reserva reserva1 = new Reserva(1, cliente1, 1, new Fecha(1, 8, 2022), new Fecha(10, 8, 2022));
        Reserva reserva2 = new Reserva(2, cliente2, 1, new Fecha(15, 8, 2022), new Fecha(31, 8, 2022));
        
        
        //MUESTRO LAS RESERVAS Y LOS CLIENTES
        System.out.println("Cliente 1:");
        System.out.println(cliente1.toString());
        
        System.out.println("\nCliente 2:");
        System.out.println("Numero de cliente: " + cliente2.getNumCliente());
        System.out.println("Nombre completo: " + cliente2.getNombreCompleto());
        System.out.println("DNI: " + cliente2.getDni());
        System.out.println("Fecha de nacimiento: " + cliente2.getFechaNac().toString());
        System.out.println("Alojamineto: " + cliente2.getAlojamiento().toString());
        
        System.out.println("\nReserva 1:");
        System.out.println(reserva1.toString());
        
        System.out.println("\nReserva 2:");
        System.out.println("Numero de reserva: " + reserva2.getNumReserva());
        System.out.println("Cliente: " + reserva2.getCliente().toString());
        System.out.println("Parcela: " + reserva2.getNumParcela());
        System.out.println("Fecha inicio: " + reserva2.getFechaInicio().toString());
        System.out.println("Fecha fin: " + reserva2.getFechaFin().toString());
        
        
        //USO EL METODO cabeEnParcela() y compruebo que funciona
        System.out.println("\nCompruebo si el alojamiento del cliente 1 cabe en la parcela:");
        try{
          if(cliente1.getAlojamiento().cabeEnParcela(ANCHO_PARCELA, LARGO_PARCELA, cliente1.getAlojamiento().getAncho(), cliente1.getAlojamiento().getLongitud())){
            System.out.println("El alojamiento del cliente cabe en la parcela");
        }  
        }catch(AlojamientoInvalidoException e){
            System.out.println(AlojamientoInvalidoException.ALOJAMIENTO_DEMASIADO_GRANDE);
            //System.out.println("El alojamiento del cliente NO cabe en la parcela");
        }
        
        
        
        //APARTADO 3 DE LA TAREA ------------------------------------------------------------------------------------------
        System.out.println("\n");
        
        Scanner teclado = new Scanner(System.in);
        int menu = 0;
        System.out.println("Bienvenido al camping Tarea UT7");
        
        do{
            try{
                System.out.println("\nMenu de opciones:\n" +
                        VERDE + "-- CLIENTES ---------------\n" + 
                        "1. Ver clientes\n" +
                        "2. Dar de alta un cliente\n" +
                        "3. Dar de baja un cliente\n\n" + 
                        PURPURA + "-- PARCELAS ---------------\n" +
                        "4. Mostrar el número de parcelas libres para un dia\n" +
                        "5. Mostrar los días libres para una parcela\n\n" +
                        AMARILLO + "-- RESERVAS ---------------\n" + 
                        "6. Ver reservas\n" +
                        "7. Realizar una reserva\n" +
                        "8. Eliminar una reserva\n\n" +
                        AZUL + "-- SALIR ------------------\n" + 
                        "9. Salir\n" + BLANCO);
                
                System.out.print("Elige una opción: ");
                menu = teclado.nextInt();

                switch(menu){
                    case 1: //Ver clientes
                    System.out.println("\nAs elegido: Ver clientes.");
                    verClientes(listaClientes);
                    if(listaClientes.isEmpty()){
                        System.out.println("\nNo hay clientes registrados en el sistema!!!");
                    }
                    break;

                    case 2: //Dar de alta un cliente
                    System.out.println("\nAs elegido: Dar de alta un cliente.");
                    añadirCliente(listaClientes, numeroCliente);
                    numeroCliente++;
                    System.out.println("\nCliente añadido al sistema!!!!!!");
                    break;

                    case 3: //Dar de baja un cliente
                    System.out.println("\nAs elegido: Dar de baja un cliente.");
                    System.out.println("\nAVISO: si borras un cliente tambien borraras todas las reservas que tengan asociado a ese cliente.\n");
                    System.out.print("Inserta el numero del cliente que quieres borrar del sistema: ");
                    auxNumeroCliente = teclado.nextInt();
                    if(clienteEnLista(listaClientes, auxNumeroCliente)){
                        borrarCliente(listaClientes, auxNumeroCliente, listaReservas, parcelas);
                        System.out.println("\nCliente eliminado del sistema!!!");
                    }
                    break;
                    
                    case 4: //Mostrar el número de parcelas libres para un dia
                    System.out.println("\nAs elegido: Mostrar el número de parcelas libres para un dia.");
                    System.out.print("Inserta el dia: ");
                    dia = teclado.nextInt();
                    if(dia > 0 && dia <=31){
                        System.out.println("");
                        parcelasLibres(parcelas, dia);
                    }
                    else{
                        System.out.println(ROJO_FONDO + "\n-ERROR- Dia insertado incorrecto!!!" + NEGRO_FONDO);
                    }
                    break;

                    case 5: //Mostrar los dias libres para una parcela
                    System.out.println("\nAs elegido: Mostrar los dias libres para una parcela.");
                    System.out.print("Inserta la parcela: ");
                    auxParcela = teclado.nextInt();
                    if(auxParcela > 0 && auxParcela <= 5){
                        diasLibresParcela(parcelas, auxParcela);
                    }
                    else{
                        System.out.println(ROJO_FONDO + "\n-ERROR- Parcela insertada incorrecta!!!" + NEGRO_FONDO);
                    }
                    
                    break;

                    case 6: //Ver reservas
                    System.out.println("\nAs elegido: Ver reservas.");
                    verReservas(listaReservas);
                    if(listaReservas.isEmpty()){
                        System.out.println("\nNo hay reservas en el sistema!!!");
                    }
                    break;

                    case 7: //Realizar una reserva
                    System.out.println("\nAs elegido: Realiar una reserva.");
                    System.out.print("Inserta numero de cliente: ");
                    auxNumeroCliente = teclado.nextInt();
                    if(clienteEnLista(listaClientes, auxNumeroCliente)){
                        añadirReserva(listaReservas, dameCliente(listaClientes, auxNumeroCliente) , parcelas, numeroReserva);
                        numeroReserva++;
                    }
                    break;

                    case 8: //Eliminar una reserva
                    System.out.println("\nAs elegido: Eliminar una reserva.");
                    System.out.print("Inserta numero de reserva: ");
                    auxNumeroReserva = teclado.nextInt();
                    if(reservaEnLista(listaReservas, auxNumeroReserva)){
                        borrarReserva(listaReservas, auxNumeroReserva, parcelas);
                        System.out.println("\nReserva eliminada del sistema!!!");
                    }
                    break;

                    case 9: //Salir
                    System.out.println("Adios!!!!");
                    break;

                    default:
                    System.out.println("\nDeves introducir un valor entre 1 y 9\n");
                        
                }

            }catch(InputMismatchException e){
                System.out.println("\n" + ROJO_FONDO + "-ERROR- El valor esperado no corresponde con el insertado" + NEGRO_FONDO + "\n");
                teclado.nextLine();
            }catch(AlojamientoInvalidoException e){
                System.out.println("\n" + ROJO_FONDO + "-ERROR- No se puede hacer una reserva con este cliente. " + e.getMessage() + NEGRO_FONDO + "\n");
            }catch(IllegalArgumentException e){
                System.out.println("\n" + ROJO_FONDO + e.getMessage() + NEGRO_FONDO);
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("\n" + ROJO_FONDO + "-ERROR- ---------------------!!!" + NEGRO_FONDO + "\n");
            }catch(Exception e){
                System.out.println("\n" + ROJO_FONDO + e.getMessage() + NEGRO_FONDO + "\n");
            }
            
        }while(menu != 9);
        
    }//FIN MAIN ----------------------------------------------------------


    public static void parcelasLibres(int parcelas[][], int dia){
        for(int i=0; i < parcelas.length; i++){
            if(parcelas[i][dia -1] == 0){
                System.out.println("Parcela " + (i+1) + " LIBRE.");
            }
            else{
                System.out.println("Parcela " + (i+1) + " OCUPADA. | Cliente: " + parcelas[i][dia -1]);
            }
        }
    }//FIN parcelasLibres


    public static void diasLibresParcela(int parcelas[][],int auxParcela){
        System.out.println("\nDias libres para parcela " + auxParcela + ": ");
        for(int i=0; i < parcelas[auxParcela -1].length; i++){
            if(parcelas[auxParcela -1][i] == 0){
                System.out.print((i+1) + ", ");
            }
        }
        System.out.println("\n");
    }//FIN diasLibresParcela


    public static void añadirReserva(ArrayList<Reserva> listaReservas, Cliente cliente,int parcelas[][], int numeroReserva) throws Exception, IllegalArgumentException, AlojamientoInvalidoException{
        if(cliente.getAlojamiento().cabeEnParcela(ANCHO_PARCELA, LARGO_PARCELA, cliente.getAlojamiento().getAncho(), cliente.getAlojamiento().getLongitud())){
            Scanner teclado = new Scanner(System.in);
            int numeroParcela;
            Fecha fechaInicio = new Fecha(1, 8, 2022);
            Fecha fechaFin = new Fecha(2, 8, 2022);
            System.out.print("Inserta la parcela que quieres reservar: ");
            numeroParcela = teclado.nextInt();
            if(numeroParcela < 1 || numeroParcela > 5){
                throw new IllegalArgumentException("-ERROR- Valor introducido en numero de parcela incorrecto!!!");
            }
            System.out.print("Inserta el dia de inicio de la reserva: ");
            fechaInicio.setDia(teclado.nextInt());
            System.out.print("Inserta el dia de fin de la reserva: ");
            fechaFin.setDia(teclado.nextInt());
            if(fechaInicio.getDia() > fechaFin.getDia() || fechaInicio.getDia() < 1 || fechaFin.getDia() > 31){
                throw new IllegalArgumentException("-ERROR- Valores introducidos en fechas de reserva incorrectos!!!");
            }
            if(!compruebaFechasLibres(parcelas, numeroParcela, fechaInicio.getDia(), fechaFin.getDia())){
                throw new Exception("-ERROR- Fechas introducidas no se encuentran disponibles!!!");
            }           
            listaReservas.add(new Reserva(numeroReserva, cliente, numeroParcela, fechaInicio, fechaFin));
            registraFechas(parcelas, numeroParcela, fechaInicio.getDia(), fechaFin.getDia(), cliente.getNumCliente());
            System.out.println("\nReserva realizada!!!!!");
            
        }
    }//FIN añadirReserva


    public static void verReservas(ArrayList<Reserva> listaReservas){
        Iterator<Reserva> mi_iterador = listaReservas.iterator();
        while(mi_iterador.hasNext()){
            System.out.println(mi_iterador.next().toString());
        }    
    }//FIN verReservas.


    public static boolean compruebaFechasLibres(int parcelas[][], int numeroParcela, int fechaInicio, int fechaFin){
        for(int i=fechaInicio -1; i < parcelas[numeroParcela -1].length; i++){
            if(parcelas[numeroParcela -1][i] != 0){
                return false;
            }
            if(i == fechaFin){  
                return true;
            }   
        }
        return true;
    }//FIN compruebaFechasLibres


    public static void registraFechas(int parcelas[][], int numeroParcela, int fechaInicio, int fechaFin, int numeroCliente){
        for(int i=fechaInicio -1; i <= fechaFin -1; i++){
            parcelas[numeroParcela -1][i] = numeroCliente;
        }
    }//FIN registraFechas


    public static void borrarReserva(ArrayList<Reserva> listaReservas, int auxNumeroReserva, int parcelas[][]){
        for(Reserva i: listaReservas){ 
            if(i.getNumReserva() == auxNumeroReserva){
                for(int j=i.getFechaInicio().getDia() -1; j <= i.getFechaFin().getDia() -1; j++){
                    if(parcelas[i.getNumParcela() -1][j] == i.getCliente().getNumCliente()){
                        parcelas[i.getNumParcela() -1][j] = 0;
                    }
                }
                listaReservas.remove(i);
                break;
            }
        }
    }//FIN borrarReserva


    public static boolean reservaEnLista(ArrayList<Reserva> listaReservas, int numeroReserva) throws IllegalArgumentException{
        for(Reserva i: listaReservas){  
            if(i.getNumReserva() == numeroReserva){
                return true;
            }
        }
        throw new IllegalArgumentException("-ERROR- El numero de reserva insertado no esta en la lista!!!");
    }//FIN reservaEnLista


    public static void verClientes(ArrayList<Cliente> listaClientes){
        Iterator<Cliente> mi_iterador = listaClientes.iterator();
        while(mi_iterador.hasNext()){
            System.out.println(mi_iterador.next().toString());
        }  
    }//FIN verClientes.


    public static Cliente dameCliente(ArrayList<Cliente> listaClientes, int numeroCliente){
        for(Cliente i: listaClientes){ 
            if(i.getNumCliente() == numeroCliente){
                return new Cliente(i);
            }
        }
        return null;
    }//FIN dameCliente


    public static boolean clienteEnLista(ArrayList<Cliente> listaClientes, int numeroCliente) throws Exception{
        for(Cliente i: listaClientes){  
            if(i.getNumCliente() == numeroCliente){
                return true;
            }
        }
        throw new Exception("-ERROR- El numero de cliente insertado no esta en la lista!!!");
    }//FIN clienteEnLista


    public static void borrarCliente(ArrayList<Cliente> listaClientes, int auxNumeroCliente, ArrayList<Reserva> listaReservas, int parcelas[][]){
        
        //BORRA TODAS LAS RESERVAS DEL CLIENTE
        for(int i = listaReservas.size() -1; i >= 0 ; i--){  
            if(listaReservas.get(i).getCliente().getNumCliente() == auxNumeroCliente){
                Reserva r = listaReservas.get(i);
                for(int j=r.getFechaInicio().getDia() -1; j <= r.getFechaFin().getDia() -1; j++){
                    if(parcelas[r.getNumParcela() -1][j] == r.getCliente().getNumCliente()){
                        parcelas[r.getNumParcela() -1][j] = 0;
                    }
                }
                listaReservas.remove(i);
            }
        }

        //BORRA EL CLIENTE
        for(Cliente i: listaClientes){ 
            if(i.getNumCliente() == auxNumeroCliente){
                listaClientes.remove(i);
                break;
            }
        }
    }//FIN borrarClientes


    public static void añadirCliente(ArrayList<Cliente> listaClientes, int numeroCliente) throws IllegalArgumentException{
        Scanner teclado = new Scanner(System.in);
        Cliente cliente = new Cliente();
        int auxAlojamiento;
                    
        System.out.print("Introduce el nombre completo del cliente: ");
        cliente.setNombreCompleto(teclado.nextLine());
                   
        System.out.print("Introduce el DNI: ");
        cliente.setDni(teclado.nextLine());
                    
        Fecha fecha = new Fecha();
        System.out.println("\nFecha de nacimiento.");
                    
        System.out.print("Introduce dia: ");
        fecha.setDia(teclado.nextInt());
                    
        System.out.print("Introduce mes: ");
        fecha.setMes(teclado.nextInt());
                    
        System.out.print("Introduce año: ");
        fecha.setAnio(teclado.nextInt());
        cliente.setFechaNac(fecha);
        
        if(!fecha.fechaCorrecta()){
            throw new IllegalArgumentException("-ERROR- Los datos de fecha no son correctos!!!");
        }
        
        System.out.println("\nTipo de lojamiento.");
        do{
            System.out.print("introduce (1) si tiene Autocaravana o (2) si tiene Caravana: ");
            auxAlojamiento = teclado.nextInt();
            if(auxAlojamiento == 1){
                Autocaravana autocaravana = new Autocaravana(creaAutocaravana());
                cliente.setAlojamiento(autocaravana);
            }
            else if(auxAlojamiento == 2){
                Caravana caravana =new Caravana(crearCaravana());
                cliente.setAlojamiento(caravana);
            }
            else{
                System.out.println("Alojamineto no contemplado");
            }

        }while(auxAlojamiento < 1 || auxAlojamiento > 2);

        cliente.setNumCliente(numeroCliente);
        listaClientes.add(cliente);
    }//FIN crearCliente


    public static Autocaravana creaAutocaravana(){
        Scanner teclado = new Scanner(System.in);
        Autocaravana autoC = new Autocaravana();
        int auxTieneAseo;
        int auxTipoAutocaravana;
        
        System.out.print("introduce el modelo: ");
        autoC.setModelo(teclado.nextLine());
        
        System.out.print("introduce la longitud: ");
        autoC.setLongitud(teclado.nextInt());
        
        System.out.print("introduce el ancho: ");
        autoC.setAncho(teclado.nextInt());
        
        System.out.print("introduce (1) si tiene aseo o (0) si no tiene aseo: ");
        auxTieneAseo = teclado.nextInt();    
        if(auxTieneAseo == 1){autoC.setTieneAseo(true);} 
        else{autoC.setTieneAseo(false);} 

        System.out.println("\nTipo de autocarabana");
        System.out.print("introduce (1)PERFILADA, (2)CAPUCHINA, (3)INTEGRAL.: ");
        auxTipoAutocaravana = teclado.nextInt();
        if(auxTipoAutocaravana == 1){autoC.setTipoAC(TIPO_AUTOCARAVANA.PERFILADA);} 
        else if(auxTipoAutocaravana == 2) {autoC.setTipoAC(TIPO_AUTOCARAVANA.CAPUCHINA);}
        else{autoC.setTipoAC(TIPO_AUTOCARAVANA.INTEGRAL);} 

        return autoC;
    }//FIN crearAutocaravana


    public static Caravana crearCaravana(){
        Scanner teclado = new Scanner(System.in);
        Caravana c = new Caravana();
        int auxTieneAseo;
        int auxTieneMover;
        
        System.out.print("introduce el modelo: ");
        c.setModelo(teclado.nextLine());
        
        System.out.print("introduce la longitud: ");
        c.setLongitud(teclado.nextInt());
        
        System.out.print("introduce el ancho: ");
        c.setAncho(teclado.nextInt());
        
        System.out.print("introduce (1) si tiene aseo o (0) si no tiene aseo: ");
        auxTieneAseo = teclado.nextInt();    
        if(auxTieneAseo == 1){c.setTieneAseo(true);} 
        else{c.setTieneAseo(false);} 

        System.out.print("Longitud total de la caravana + Vehiculo: ");
        c.setLongitudTotal(teclado.nextInt());
        
        System.out.print("Introduce (1)si tiene sistema para mover o (0) si no tiene: ");
        auxTieneMover = teclado.nextInt();
        if(auxTieneMover == 1){
            c.setTieneMover(true);
        }
        else{
            c.setTieneMover(false);
        }
    
        return c;
    }//FIN crearCaravana

}//FIN CLASE TareaUT7
