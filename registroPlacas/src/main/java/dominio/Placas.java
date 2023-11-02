/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa un trámite de placas en el sistema.
 * Esta clase almacena información sobre el trámite de placas, incluyendo su número alfanumérico, fecha de recepción y la relación con el vehículo al que se asocian las placas.
 *
 * @author HP
 */
@Entity
@DiscriminatorValue(value = "placa")
public class Placas extends Tramites {

    @Column(name = "noAlfanumerico", nullable = false, length = 18)
    private String noAlfanumerico;

    @Column(name = "fechaRecepcion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;

    // Relación
    @ManyToOne()
    @JoinColumn(name = "serie", nullable = false)
    private Vehiculos vehiculos;

    /**
     * Constructor vacío de la clase Placas.
     */
    public Placas() {
    }

    /**
     * Constructor de la clase Placas con todos los parámetros.
     *
     * @param noAlfanumerico   El número alfanumérico de las placas.
     * @param fechaRecepcion   La fecha de recepción de las placas.
     * @param vehiculos        El vehículo al que se asocian las placas.
     * @param id               El ID del trámite de placas.
     * @param fechaExpedicion  La fecha de expedición del trámite.
     * @param estado           El estado del trámite.
     * @param persona          La persona asociada al trámite.
     * @param costos           Los costos asociados al trámite.
     */
    public Placas(String noAlfanumerico, Calendar fechaRecepcion, Vehiculos vehiculos, Long id, Calendar fechaExpedicion, EstadoTramite estado, Persona persona, Costos costos) {
        super(id, fechaExpedicion, estado, persona, costos);
        this.noAlfanumerico = noAlfanumerico;
        this.fechaRecepcion = fechaRecepcion;
        this.vehiculos = vehiculos;
    }

    /**
     * Constructor de la clase Placas sin el ID.
     *
     * @param noAlfanumerico   El número alfanumérico de las placas.
     * @param fechaRecepcion   La fecha de recepción de las placas.
     * @param vehiculos        El vehículo al que se asocian las placas.
     * @param fechaExpedicion  La fecha de expedición del trámite.
     * @param estado           El estado del trámite.
     * @param persona          La persona asociada al trámite.
     * @param costos           Los costos asociados al trámite.
     */
    public Placas(String noAlfanumerico, Calendar fechaRecepcion, Vehiculos vehiculos, Calendar fechaExpedicion, EstadoTramite estado, Persona persona, Costos costos) {
        super(fechaExpedicion, estado, persona, costos);
        this.noAlfanumerico = noAlfanumerico;
        this.fechaRecepcion = fechaRecepcion;
        this.vehiculos = vehiculos;
    }

    /**
     * Obtiene el número alfanumérico de las placas.
     *
     * @return El número alfanumérico de las placas.
     */
    public String getNoAlfanumerico() {
        return noAlfanumerico;
    }

    /**
     * Establece el número alfanumérico de las placas.
     *
     * @param noAlfanumerico El nuevo número alfanumérico de las placas.
     */
    public void setNoAlfanumerico(String noAlfanumerico) {
        this.noAlfanumerico = noAlfanumerico;
    }

    /**
     * Obtiene la fecha de recepción de las placas.
     *
     * @return La fecha de recepción de las placas.
     */
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Establece la fecha de recepción de las placas.
     *
     * @param fechaRecepcion La nueva fecha de recepción de las placas.
     */
    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Obtiene el vehículo al que se asocian las placas.
     *
     * @return El vehículo al que se asocian las placas.
     */
    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    /**
     * Establece el vehículo al que se asocian las placas.
     *
     * @param vehiculos El nuevo vehículo al que se asocian las placas.
     */
    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Retorna una representación en cadena de las placas.
     *
     * @return Una cadena que representa las placas.
     */
    @Override
    public String toString() {
        return "Placas{" + "noAlfanumerico=" + noAlfanumerico + ", fechaRecepcion=" + fechaRecepcion + ", vehiculos=" + vehiculos + '}';
    }
}
