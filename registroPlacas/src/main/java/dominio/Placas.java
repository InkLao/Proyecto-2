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
 *
 * @author HP
 */
@Entity
@DiscriminatorValue(value = "placa")
public class Placas extends Tramites{
   
    @Column (name = "noAlfanumerico", nullable = false, length =18)
    private String noAlfanumerico;
    
    @Column (name = "fechaRecepcion", nullable = false)
    @Temporal (TemporalType.DATE)
    private Calendar fechaRecepcion;
    
    //Relacion
    @ManyToOne()
    @JoinColumn(name = "serie", nullable = false)
    private Vehiculos vehiculos;

    public Placas() {
    }

    public Placas(String noAlfanumerico, Calendar fechaRecepcion, Vehiculos vehiculos, Long id, Calendar fechaExpedicion, EstadoTramite estado, Persona persona, Costos costos) {
        super(id, fechaExpedicion, estado, persona, costos);
        this.noAlfanumerico = noAlfanumerico;
        this.fechaRecepcion = fechaRecepcion;
        this.vehiculos = vehiculos;
    }

    public Placas(String noAlfanumerico, Calendar fechaRecepcion, Vehiculos vehiculos, Calendar fechaExpedicion, EstadoTramite estado, Persona persona, Costos costos) {
        super(fechaExpedicion, estado, persona, costos);
        this.noAlfanumerico = noAlfanumerico;
        this.fechaRecepcion = fechaRecepcion;
        this.vehiculos = vehiculos;
    }
    
    //--------------------------------------------------------------------------
    
    public String getNoAlfanumerico() {
        return noAlfanumerico;
    }

    public void setNoAlfanumerico(String noAlfanumerico) {
        this.noAlfanumerico = noAlfanumerico;
    }

    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Placas{" + "noAlfanumerico=" + noAlfanumerico + ", fechaRecepcion=" + fechaRecepcion + ", vehiculos=" + vehiculos + '}';
    }
    
    
    
    
}
