/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author HP
 */

    
@Entity
@Table(name = "Personas")
public class Persona implements Serializable {

    //Variables
    @Id
    @Column(name = "rfc", length = 13)
    private String rfc;

    @Column(name = "nombres", nullable = false, length = 255)
    private String nombres;

    @Column(name = "apellido_paterno", nullable = false, length = 255)
    private String apellido_paterno;

    @Column(name = "apellido_materno", nullable = false, length = 255)
    private String apellido_materno;

    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;

    @Column(name = "isDiscapacidad", nullable = false)
    private Boolean discapacidad;

    @Column(name = "telefono", nullable = false, length = 255)
    private String telefono;

    @Column(name = "curp", nullable = false, length = 18)
    private String curp;
    
    //relaciones
    @OneToMany (mappedBy = "Personas")
    private List<Tramites> tramites;
    
    public Persona() {
    }

    public Persona(String rfc, String nombres, String apellido_paterno, String apellido_materno, Calendar fechaNacimiento, Boolean discapacidad, String telefono, String curp, List<Tramites> tramites) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fechaNacimiento = fechaNacimiento;
        this.discapacidad = discapacidad;
        this.telefono = telefono;
        this.curp = curp;
        this.tramites = tramites;
    }

    public Persona(String rfc, String nombres, String apellido_paterno, String apellido_materno, Calendar fechaNacimiento, Boolean discapacidad, String telefono, String curp) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fechaNacimiento = fechaNacimiento;
        this.discapacidad = discapacidad;
        this.telefono = telefono;
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(Boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Tramites> getTramites() {
        return tramites;
    }

    public void setTramites(List<Tramites> tramites) {
        this.tramites = tramites;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
    
    
    /**
     * Metodo get que regresa la edad de la persona
     *
     * @return edad de la persona
     */
    public int getEdad() {
        Calendar ahora = Calendar.getInstance();
        long edadEnDias
                = (ahora.getTimeInMillis() - fechaNacimiento.getTimeInMillis())
                / 1000 / 60 / 60 / 24;
        int anios = Double.valueOf(edadEnDias / 365.25d).intValue();

        return anios;

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.rfc);
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
        final Persona other = (Persona) obj;
        return Objects.equals(this.rfc, other.rfc);
    }

    @Override
    public String toString() {
        return "Persona{" + "rfc=" + rfc + ", nombres=" + nombres + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", fechaNacimiento=" + fechaNacimiento + ", discapacidad=" + discapacidad + ", telefono=" + telefono + '}';
    }
    
    
}
