/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 * Clase que representa una excepción específica de negocio.
 * Esta excepción se utiliza para manejar errores relacionados con operaciones de negocio.
 * 
 * @author HP
 */
public class NegocioException extends RuntimeException {
    
    /**
     * Crea una nueva instancia de NegocioException sin detallar el motivo.
     */
    public NegocioException() {
    }
    
    /**
     * Crea una nueva instancia de NegocioException con un mensaje de error.
     * 
     * @param string El mensaje de error
     */
    public NegocioException(String string) {
        super(string);
    }
    
    /**
     * Crea una nueva instancia de NegocioException con un mensaje de error y una causa.
     * 
     * @param string El mensaje de error
     * @param thrwbl La causa
     */
    public NegocioException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
    /**
     * Crea una nueva instancia de NegocioException con una causa.
     * 
     * @param thrwbl La causa de la excepción.
     */
    public NegocioException(Throwable thrwbl) {
        super(thrwbl);
    }
    
    /**
     * Crea una nueva instancia de NegocioException con un mensaje de error, una causa y
     * opciones adicionales.
     * 
     * @param string El mensaje de error
     * @param thrwbl La causa de error
     * @param bln Si se debe habilitar la supresión de excepciones.
     * @param bln1 Si se deben escribir rastreos de pila.
     */
    public NegocioException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }

}
