/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Calendar;
import java.util.Objects;
import javax.persistence.*;

/**
 * Clase que representa un trámite en el sistema.
 * Esta clase almacena información sobre un trámite, incluyendo su fecha de expedición, estado, persona asociada y costos.
 *
 * @author HP
 */
@Entity
@Table(name = "Tramites")
@DiscriminatorColumn(name = "tipo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Tramites {

    // Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaExpedicion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaExpedicion;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoTramite estado;

    // Relaciones
    @ManyToOne()
    @JoinColumn(name = "rfc", nullable = false)
    private Persona persona;

    @ManyToOne()
    @JoinColumn(name = "id_costos", nullable = false)
    private Costos costos;

    /**
     * Constructor vacío de la clase Tramites.
     */
    public Tramites() {
    }

    /**
     * Constructor de la clase Tramites con todos los parámetros.
     *
     * @param id               El ID del trámite.
     * @param fechaExpedicion  La fecha de expedición del trámite.
     * @param estado           El estado del trámite.
     * @param persona          La persona asociada al trámite.
     * @param costos           Los costos asociados al trámite.
     */
    public Tramites(Long id, Calendar fechaExpedicion, EstadoTramite estado, Persona persona, Costos costos) {
        this.id = id;
        this.fechaExpedicion = fechaExpedicion;
        this.estado = estado;
        this.persona = persona;
        this.costos = costos;
    }

    /**
     * Constructor de la clase Tramites sin el ID.
     *
     * @param fechaExpedicion  La fecha de expedición del trámite.
     * @param estado           El estado del trámite.
     * @param persona          La persona asociada al trámite.
     * @param costos           Los costos asociados al trámite.
     */
    public Tramites(Calendar fechaExpedicion, EstadoTramite estado, Persona persona, Costos costos) {
        this.fechaExpedicion = fechaExpedicion;
        this.estado = estado;
        this.persona = persona;
        this.costos = costos;
    }

    /**
     * Obtiene el ID del trámite.
     *
     * @return El ID del trámite.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del trámite.
     *
     * @param id El nuevo ID del trámite.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha de expedición del trámite.
     *
     * @return La fecha de expedición del trámite.
     */
    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Establece la fecha de expedición del trámite.
     *
     * @param fechaExpedicion La nueva fecha de expedición del trámite.
     */
    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Obtiene el estado del trámite.
     *
     * @return El estado del trámite.
     */
    public EstadoTramite getEstado() {
        return estado;
    }

    /**
     * Establece el estado del trámite.
     *
     * @param estado El nuevo estado del trámite.
     */
    public void setEstado(EstadoTramite estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la persona asociada al trámite.
     *
     * @return La persona asociada al trámite.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al trámite.
     *
     * @param persona La nueva persona asociada al trámite.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Obtiene los costos asociados al trámite.
     *
     * @return Los costos asociados al trámite.
     */
    public Costos getCostos() {
        return costos;
    }

    /**
     * Establece los costos asociados al trámite.
     *
     * @param costos Los nuevos costos asociados al trámite.
     */
    public void setCostos(Costos costos) {
        this.costos = costos;
    }

    /**
     * Retorna una representación en cadena del trámite.
     *
     * @return Una cadena que representa el trámite.
     */
    @Override
    public String toString() {
        return "Tramites{" + "id=" + id + ", fechaExpedicion=" + fechaExpedicion + ", estado=" + estado + ", persona=" + persona + ", costos=" + costos + '}';
    }

    /**
     * Calcula el valor de hash del trámite.
     *
     * @return El valor de hash calculado.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara el trámite con otro objeto para determinar si son iguales.
     *
     * @param obj El objeto con el que se compara el trámite.
     * @return true si los trámites son iguales, false en caso contrario.
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
        final Tramites other = (Tramites) obj;
        return Objects.equals(this.id, other.id);
    }
}
