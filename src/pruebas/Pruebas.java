package pruebas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.time.temporal.IsoFields;
import java.util.Locale;
import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args) {
        /* 
        LocalTime hora = LocalTime.of(15, 30);
        System.out.println(hora);
        Month mes =  Month.valueOf(Month.APRIL.name());
        System.out.println(mes);
        YearMonth yearMes = YearMonth.of(1986, Month.valueOf("JANUARY"));
        System.out.println("El mes: " + yearMes.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
       for (Month month : Month.values()) {
            String nombreMes = month.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
            System.out.println(nombreMes);
        }
        */

        /* 

        LocalDate dia = LocalDate.now();
        
        LocalDate currentDate = LocalDate.now();
        int weekNumber = currentDate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        System.out.println("Número de semana: " + weekNumber);*/


        int[] numeros = {1,2,3};

        try {
            int uno = numeros[5];
        } catch (Exception e) {
            System.out.println("\n1" + e.getMessage());
            System.out.println("\n2" + e.getLocalizedMessage());
            System.out.println("\n3" + e.getCause());
            System.out.println("\n4" + e.toString());
        }

    }//Fin main.

}
