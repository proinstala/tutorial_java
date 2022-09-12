package tutorial;


public class m_refundicion {
    
    public static void main(String[] args) {
        /*  Caundo usamos un metodo que va a asignar a una variable un dato mayor del que soporta,
            se usa otro metodo que se llama refundicon.
            La refundicion consiste en convertir un tipo de dato a otro.
            
            Math.round(num): Redondeo al siguiente número entero.
            Math.ceil(num): Mínimo entero que sea mayor o igual a num.
            Math.floor(num): Entero mayor, que sea inferior o igual a num.
        */
        double numero = 1.54;
        int resultado;
        resultado = (int)Math.round(numero); //usando refundicion
        System.out.println(resultado);

        float numero_2 = 2.6F; //Si el dato es de tipo float, se tiene que poner la letra F despues del numero
        int resultado_2;
        resultado_2 = Math.round(numero_2); // no hay que hacer refundicion porque los dos datos son de 4 bytes
        System.out.println(resultado_2);


    }
}
