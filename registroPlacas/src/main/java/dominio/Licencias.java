/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa licencias de tránsito, una subclase de Tramites.
 * Esta clase almacena información sobre las licencias de tránsito, incluyendo su fecha de expiración.
 *
 * @author HP
 */
@Entity
@DiscriminatorValue(value = "licencia")
public class Licencias extends Tramites {

    /**
     * Fecha de expiración de la licencia.
     */
    @Column(name = "fechaExpiracion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaExpiracion;

    // Constructores
    public Licencias() {
    }

    /**
     * Constructor de la clase Licencias con todos los parámetros.
     *
     * @param fechaExpiracion   La fecha de expiración de la licencia.
     * @param id                El ID de la licencia.
     * @param fechaExpedicion   La fecha de expedición de la licencia.
     * @param estado            El estado de la licencia.
     * @param persona           La persona asociada a la licencia.
     * @param costos            Los costos asociados a la licencia.
     */
    public Licencias(Calendar fechaExpiracion, Long id, Calendar fechaExpedicion, EstadoTramite estado, Persona persona, Costos costos) {
        super(id, fechaExpedicion, estado, persona, costos);
        this.fechaExpiracion = fechaExpiracion;
    }

    /**
     * Constructor de la clase Licencias sin el ID.
     *
     * @param fechaExpiracion   La fecha de expiración de la licencia.
     * @param fechaExpedicion   La fecha de expedición de la licencia.
     * @param estado            El estado de la licencia.
     * @param persona           La persona asociada a la licencia.
     * @param costos            Los costos asociados a la licencia.
     */
    public Licencias(Calendar fechaExpiracion, Calendar fechaExpedicion, EstadoTramite estado, Persona persona, Costos costos) {
        super(fechaExpedicion, estado, persona, costos);
        this.fechaExpiracion = fechaExpiracion;
    }

    /**
     * Obtiene la fecha de expiración de la licencia.
     *
     * @return La fecha de expiración de la licencia.
     */
    public Calendar getFechaExpiracion() {
        return fechaExpiracion;
    }

    /**
     * Establece la fecha de expiración de la licencia.
     *
     * @param fechaExpiracion La nueva fecha de expiración de la licencia.
     */
    public void setFechaExpiracion(Calendar fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    /**
     * Retorna una representación en cadena de la licencia de tránsito.
     *
     * @return Una cadena que representa la licencia de tránsito.
     */
    @Override
    public String toString() {
        return "Licencias{" + "fechaExpiracion=" + fechaExpiracion + '}';
    }
}
