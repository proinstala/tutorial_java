/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas.tareaUT7;

/**
 *
 * @author David
 */
public class AlojamientoInvalidoException extends Exception {
    
    public static final String ALOJAMIENTO_DEMASIADO_GRANDE = "El alojamiento es mas grande que la parcela.";
    
    //Constructor sin parametros
    public AlojamientoInvalidoException(){}

    //Constructor con parametros
    public AlojamientoInvalidoException(String msj_error){
        super(msj_error);
    }
}
