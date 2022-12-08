/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAM_1.Examen_EV1_DAM1;

import java.util.Arrays;


/**
 *
 * @author lucasjosemoraleschacon
 */
public class DRedIPv4 
{
    private int octetos[];
    private int mascaraDecimal;
    

    /**
     * Crea la dirección de Red IPv4 127.0.0.1
     */
    public DRedIPv4() 
    {
        octetos = new int[4];
        
        octetos[0] = 127;
        octetos[1] = 0;
        octetos[2] = 0;
        octetos[3] = 1;
        
        mascaraDecimal = 8;
    }

    /**
     * Crea la dirección de Red IPv4 o1.o2.o3.o4
     * @param o1 Primer octeto
     * @param o2 Segundo octeto
     * @param o3 Tercer octeto
     * @param o4 Cuarto octeto
     * @throws IllegalArgumentException Lanza la excepción IllegalArgumentException si algún octeto está fuera del rango [0,255]
     */
    public DRedIPv4(int o1, int o2, int o3, int o4) throws IllegalArgumentException
    {
        if ((o1 < 0) || (o1 > 255))
        {
            throw new IllegalArgumentException("El primer octeto tiene un valor fuera del rango [0,255]");
        }   
        
        if ((o2 < 0) || (o2 > 255))
        {
            throw new IllegalArgumentException("El segundo octeto tiene un valor fuera del rango [0,255]");
        }
        
        if ((o3 < 0) || (o3 > 255))
        {
            throw new IllegalArgumentException("El tercer octeto tiene un valor fuera del rango [0,255]");
        }
        
        if ((o4 < 0) || (o4 > 255))
        {
            throw new IllegalArgumentException("El cuarto octeto tiene un valor fuera del rango [0,255]");
        }
        
        octetos = new int[4];
        
        octetos[0] = o1;
        octetos[1] = o2;
        octetos[2] = o3;
        octetos[3] = o4;
        
        mascaraDecimal = getMascaraDecimal();
        
    }

    /**
     * Devuelve el valor del primer octeto en decimal
     * @return El valor entero del primer octeto en decimal
     */
    public int getOcteto1()
    {
        return octetos[0];
    }   
    
    /**
     * Devuelve el valor del segundo octeto en decimal
     * @return El valor entero del segundo octeto en decimal
     */
    public int getOcteto2()
    {
        return octetos[1];
    }
    
    /**
     * Devuelve el valor del tercer octeto en decimal
     * @return El valor entero del tercer octeto en decimal
     */
    public int getOcteto3()
    {
        return octetos[2];
    }
    
    /**
     * Devuelve el valor del cuarto octeto en decimal
     * @return El valor entero del cuarto octeto en decimal
     */
    public int getOcteto4()
    {
        return octetos[3];
    }

    /**
     * Asigna un valor entero al octeto1 de la DRedIPv4
     * @param octeto Valor entero entre 0 y 255
     */
    public void setOcteto1(int octeto) 
    {
        this.octetos[0] = octeto;
        
        this.mascaraDecimal = this.getMascaraDecimal();
    }
    
    /**
     * Asigna un valor entero al octeto2 de la DRedIPv4
     * @param octeto Valor entero entre 0 y 255
     */
    public void setOcteto2(int octeto) 
    {
        this.octetos[1] = octeto;
    }
    
    /**
     * Asigna un valor entero al octeto3 de la DRedIPv4
     * @param octeto Valor entero entre 0 y 255
     */
    public void setOcteto3(int octeto) 
    {
        this.octetos[2] = octeto;
    }
    
    /**
     * Asigna un valor entero al octeto4 de la DRedIPv4
     * @param octeto Valor entero entre 0 y 255
     */
    public void setOcteto4(int octeto) 
    {
        this.octetos[3] = octeto;
    }
    
    

    /**
     * Devuelve el valor de la máscara de red en valor decimal (8,16 ó 24)
     * @return 
     */
    public int getMascaraDecimal() 
    {
        if ((octetos[0] >= 0) && (octetos[0] <= 127))
        {
            return 8;
        }     
        else if ((octetos[0] >= 128 ) && (octetos[0] <= 191))
        {
            return 16;
        }       
        else if ((octetos[0] >= 192 ) && (octetos[0] <= 223))
        {
            return 24;
        }    
        else
        {
            return 0;
        }    
    }
    
    /**
     * Devuelve una letra en función de la clase de la DRedIPv4
     * @return 'A', 'B' o 'C' si o1 está entre [0,223]. En caso contrario el carácter nulo.
     */
    public char getClase()
    {
        if (this.getMascaraDecimal() == 8)
            return 'A';
        else if (this.getMascaraDecimal() == 16)
            return 'B';
        else if (this.getMascaraDecimal() == 24)
        {
            return 'C';
        }    
        else
        {
            return '\0';
        }    
    }        
    
    /**
     * Devuelve la máscara en formato binario con puntos.
     * @return La máscara en formato binario con puntos. Si el primer octeto no se encuentra en el rango [0,223] devuelve un  String vacío
     */
    public String getMascaraBinario()
    {
        if ((octetos[0] >= 0) && (octetos[0] <= 127))
        {
            return "11111111.00000000.00000000.00000000";
        }     
        else if ((octetos[0] >= 128 ) && (octetos[0] <= 191))
        {
            return "11111111.11111111.00000000.00000000";
        }       
        else if ((octetos[0] >= 192 ) && (octetos[0] <= 223))
        {
            return "11111111.11111111.11111111.00000000";
        }    
        else
        {
            return "";
        }
    }        
    
    /**
     * Devuelve la DRedIPv4 en formato o1.o2.o3.o4, estando los octetos en código binario
     * @return La DRedIPv4 en formato o1.o2.o3.o4 en binario
     */
    public String getIPv4BinarioPuntos()
    {
        String octetosBinario[] = new String[4];
        
        octetosBinario[0] = Integer.toBinaryString(octetos[0]);
        octetosBinario[1] = Integer.toBinaryString(octetos[1]);
        octetosBinario[2] = Integer.toBinaryString(octetos[2]);
        octetosBinario[3] = Integer.toBinaryString(octetos[3]);
        
        //Rellenamos los bits 0 que faltan a la izquierda
        for (int i=0; i<octetosBinario.length; i++)
        {
            int diferencia = 8 - octetosBinario[i].length();

            while (octetosBinario[i].length() != 8)
            {
                octetosBinario[i] = '0' + octetosBinario[i];
            }
           
        }    
        
        return octetosBinario[0] + "." + octetosBinario[1] + "." + octetosBinario[2] + "." + octetosBinario[3];
    }

    /**
     * Devuelve la DRedIPv4 en formato o1.o2.o3.o4, estando los octetos en código decimal
     * @return La DRedIPv4 en formato o1.o2.o3.o4 en decimal
     */
    public String toString()
    {
        return octetos[0] + "." 
                + octetos[1] + "." + octetos[2] + "."
                        + octetos[3];
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Arrays.hashCode(this.octetos);
        return hash;
    }

    /**
     * Comprueba si dos DRedIPv4 son iguales
     * @param obj La DRedIPv4 con la que comparar
     * @return Devuelve true si son iguales, y false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DRedIPv4 other = (DRedIPv4) obj;
        if (!Arrays.equals(this.octetos, other.octetos)) {
            return false;
        }
        return true;
    }
    
    /**
     * Comprueba si dos DRedIPv4 se encuentran en la misma red
     * @param ip DRedIPv4 con la que comparar
     * @return Devuelve verdadero si las dos DRedIPv4 están en la misma red, y falso en caso contrario
     */
    public boolean mismaRed(DRedIPv4 ip)
    {
        //Si tienen diferente máscara no pueden estar en la misma red
        if (this.mascaraDecimal != ip.mascaraDecimal)
        {
            return false;
        }   
        else
        {
            if (this.getClase() == 'A')
            {
                if (this.octetos[0] == ip.octetos[0])
                    return true;
                else
                    return false;
            }         
            else if (this.getClase() == 'B')
            {
                if ((this.octetos[0] == ip.octetos[0]) && (this.octetos[1] == ip.octetos[1]))
                    return true;
                else
                    return false;
            }  
            else if (this.getClase() == 'C')
            {
                if ((this.octetos[0] == ip.octetos[0]) && (this.octetos[1] == ip.octetos[1]) 
                        && (this.octetos[2] == ip.octetos[2]))
                    return true;
                else
                    return false;
            }
            else
            {
                return false;
            }    
            
        }    
        
    }        
    
    /**
     * Comprueba si una dirección de red es de Loopback
     * @return Devuelve true en caso de que lo sea y false en caso contrario.
     */
    public boolean direccionLoopBack()
    {
        if ((this.getClase() == 'A') && (this.octetos[0] == 127))
                return true;
        else
            return false;
    } 
    
    
    
    
    
    
    
    
}
