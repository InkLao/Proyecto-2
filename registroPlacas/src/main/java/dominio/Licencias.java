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
 *
 * @author HP
 */
@Entity
@DiscriminatorValue(value = "licencia")
public class Licencias extends Tramites{
    
    
    @Column (name = "fechaExpiracion", nullable = false)
    @Temporal (TemporalType.DATE)
    private Calendar fechaExpiracion;

    //Constructores
    public Licencias() {
    }

    public Licencias(Calendar fechaExpiracion, Long id, Calendar fechaExpedicion, EstadoTramite estado, Persona persona, Costos costos) {
        super(id, fechaExpedicion, estado, persona, costos);
        this.fechaExpiracion = fechaExpiracion;
    }

    public Licencias(Calendar fechaExpiracion, Calendar fechaExpedicion, EstadoTramite estado, Persona persona, Costos costos) {
        super(fechaExpedicion, estado, persona, costos);
        this.fechaExpiracion = fechaExpiracion;
    }
    //--------------------------------------------------------------------------
    
    public Calendar getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Calendar fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    @Override
    public String toString() {
        return "Licencias{" + "fechaExpiracion=" + fechaExpiracion + '}';
    }
}
