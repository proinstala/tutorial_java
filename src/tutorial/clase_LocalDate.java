
package tutorial;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

//EJEMPLO DE USO DE LA CLASE LocalDate

/**
 *
 * @author CARLOS
 */
public class clase_LocalDate {

    public static void main(String[] args) {

        //Fecha
        LocalDate fecha1 = LocalDate.of(2023, 01, 20);
        LocalDate fecha2 = LocalDate.now();

        System.out.println(fecha1.isAfter(fecha2));
        System.out.println(fecha1.isBefore(fecha2));

        //Hora (tiempo)
        LocalTime tiempo1 = LocalTime.of(22, 30, 50);
        LocalTime tiempo2 = LocalTime.now();

        System.out.println(tiempo1.isAfter(tiempo2));
        System.out.println(tiempo1.isBefore(tiempo2));

        //Fecha y hora (tiempo)
        LocalDateTime fechaTiempo1 = LocalDateTime.of(2023, 01, 20, 22, 30, 50);
        LocalDateTime fechaTiempo2 = LocalDateTime.now();

        System.out.println(fechaTiempo1.isAfter(fechaTiempo2));
        System.out.println(fechaTiempo1.isBefore(fechaTiempo2));
        
        //Medir el tiempo
        Instant ini= Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.getMessage();
        }
        Instant fin= Instant.now();
        System.out.println(Duration.between(ini, fin).toMillis());
        
        //Medir 2 fechas
        LocalDate nacimiento= LocalDate.of(1991, 1, 21);
        LocalDate actual= LocalDate.now();
        
        Period periodo= Period.between(nacimiento, actual);
        System.out.println("Han trascurrido " + periodo.getYears() + " años, " 
                                              + periodo.getMonths() + " meses y " 
                                              + periodo.getDays() + " días, "
                                              + "desde su nacimiento (" + nacimiento + ")"
                                              + " hasta " + actual);
        
        
        //Convertir
        String fecha= "21/01/2023";
        DateTimeFormatter formateador= DateTimeFormatter.ofPattern("dd/MM/yyy");
        LocalDate fechaLocal= LocalDate.parse(fecha, formateador);
        System.out.println(formateador.format(fechaLocal));
         
        
    }

}
