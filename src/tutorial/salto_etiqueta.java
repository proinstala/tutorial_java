package tutorial;

public class salto_etiqueta {
    public static void main(String[] args) {
        
        for(int i=1; i<4; i++){
            bloque_uno: {
                System.out.println("empieza bloque 1");
                bloque_dos: {
                    System.out.println("empieza bloque 2");
                    System.out.println("iteracion: " + i);
                    if(i==1) break bloque_uno;
                    System.out.println("en medio");
                    if(i==2) break bloque_dos;
                }
                System.out.println("despùes del bloque dos");
            }
            System.out.println("despues del bloque uno");
        }
        System.out.println("fin del bucle");
    }
}
