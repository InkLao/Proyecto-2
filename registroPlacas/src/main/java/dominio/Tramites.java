/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Calendar;
import java.util.Objects;
import javax.persistence.*;
/**
 *
 * @author HP
 */
@Entity
@Table(name = "Tramites")
@DiscriminatorColumn(name = "tipo")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public class Tramites {
    
    //Atributos
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name = "fechaExpedicion", nullable = false)
    @Temporal (TemporalType.DATE)
    private Calendar fechaExpedicion;
    
    @Column (name = "estado", nullable = false)
    @Enumerated (EnumType.STRING)
    private EstadoTramite estado;
    
    //Relaciones
    @ManyToOne()
    @JoinColumn(name = "rfc", nullable = false)
    private Persona persona;
    
    @ManyToOne()
    @JoinColumn(name = "id_costos", nullable = false)
    private Costos costos;

    public Tramites() {
    }

    public Tramites(Long id, Calendar fechaExpedicion, EstadoTramite estado, Persona persona, Costos costos) {
        this.id = id;
        this.fechaExpedicion = fechaExpedicion;
        this.estado = estado;
        this.persona = persona;
        this.costos = costos;
    }

    public Tramites(Calendar fechaExpedicion, EstadoTramite estado, Persona persona, Costos costos) {
        this.fechaExpedicion = fechaExpedicion;
        this.estado = estado;
        this.persona = persona;
        this.costos = costos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public EstadoTramite getEstado() {
        return estado;
    }

    public void setEstado(EstadoTramite estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Costos getCostos() {
        return costos;
    }

    public void setCostos(Costos costos) {
        this.costos = costos;
    }

    @Override
    public String toString() {
        return "Tramites{" + "id=" + id + ", fechaExpedicion=" + fechaExpedicion + ", estado=" + estado + ", persona=" + persona + ", costos=" + costos + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

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
