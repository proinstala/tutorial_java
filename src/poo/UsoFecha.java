package poo;

public class UsoFecha {
    public static void main(String[] args) {
        int dia = 5;
        int mes = 7;
        int anio = 2021;

        Fecha fecha_1 = new Fecha(dia, mes, anio);
        Fecha fecha_2 = new Fecha(19, 7, 2021);

        System.out.println(fecha_1);
        System.out.println(fecha_2);

        System.out.println(fecha_1.equals(fecha_2));

    }
}
