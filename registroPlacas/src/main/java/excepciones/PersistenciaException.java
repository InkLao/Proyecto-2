/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * Excepción personalizada para manejar errores relacionados con la persistencia
 * de datos en una aplicación.
 * Esta excepción puede ser lanzada en situaciones donde ocurran errores de
 * lectura o escritura de datos en una fuente de datos, como una base de datos
 * o un archivo.
 *
 * @author HP
 */
public class PersistenciaException extends RuntimeException {

    /**
     * Crea una nueva instancia de la excepción de persistencia sin un mensaje
     * descriptivo.
     */
    public PersistenciaException() {
    }

    /**
     * Crea una nueva instancia de la excepción de persistencia con un mensaje
     * descriptivo.
     *
     * @param message El mensaje descriptivo de la excepción.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Crea una nueva instancia de la excepción de persistencia con un mensaje
     * descriptivo y una causa subyacente.
     *
     * @param message El mensaje descriptivo de la excepción.
     * @param cause La causa subyacente de la excepción.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Crea una nueva instancia de la excepción de persistencia con una causa
     * subyacente.
     *
     * @param cause La causa subyacente de la excepción.
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Crea una nueva instancia de la excepción de persistencia con un mensaje
     * descriptivo, una causa subyacente, habilitación de supresión y capacidad de
     * escritura en el seguimiento.
     *
     * @param message El mensaje descriptivo de la excepción.
     * @param cause La causa subyacente de la excepción.
     * @param enableSuppression Indica si se habilita la supresión de excepciones.
     * @param writableStackTrace Indica si se habilita la capacidad de escritura
     * en el seguimiento de la excepción.
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
