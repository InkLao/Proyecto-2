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
 * Clase que representa a una persona en el sistema.
 * Esta clase almacena información personal de una persona, como el RFC, nombres, apellidos, fecha de nacimiento, discapacidad, teléfono y CURP.
 * También mantiene una lista de trámites asociados a la persona.
 *
 * @author HP
 */
@Entity
@Table(name = "Personas")
public class Persona implements Serializable {

    // Variables
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

    // Relaciones
    @OneToMany(mappedBy = "persona")
    private List<Tramites> tramites;

    /**
     * Constructor vacío de la clase Persona.
     */
    public Persona() {
    }

    /**
     * Constructor de la clase Persona con todos los parámetros.
     *
     * @param rfc             El RFC de la persona.
     * @param nombres         Los nombres de la persona.
     * @param apellido_paterno El apellido paterno de la persona.
     * @param apellido_materno El apellido materno de la persona.
     * @param fechaNacimiento  La fecha de nacimiento de la persona.
     * @param discapacidad     Indica si la persona tiene discapacidad.
     * @param telefono         El número de teléfono de la persona.
     * @param curp             El CURP de la persona.
     * @param tramites         La lista de trámites asociados a la persona.
     */
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

    /**
     * Constructor de la clase Persona sin la lista de trámites.
     *
     * @param rfc             El RFC de la persona.
     * @param nombres         Los nombres de la persona.
     * @param apellido_paterno El apellido paterno de la persona.
     * @param apellido_materno El apellido materno de la persona.
     * @param fechaNacimiento  La fecha de nacimiento de la persona.
     * @param discapacidad     Indica si la persona tiene discapacidad.
     * @param telefono         El número de teléfono de la persona.
     * @param curp             El CURP de la persona.
     */
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

    /**
     * Obtiene el RFC de la persona.
     *
     * @return El RFC de la persona.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC de la persona.
     *
     * @param rfc El nuevo RFC de la persona.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Obtiene los nombres de la persona.
     *
     * @return Los nombres de la persona.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres de la persona.
     *
     * @param nombres Los nuevos nombres de la persona.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene el apellido paterno de la persona.
     *
     * @return El apellido paterno de la persona.
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Establece el apellido paterno de la persona.
     *
     * @param apellido_paterno El nuevo apellido paterno de la persona.
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Obtiene el apellido materno de la persona.
     *
     * @return El apellido materno de la persona.
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Establece el apellido materno de la persona.
     *
     * @param apellido_materno El nuevo apellido materno de la persona.
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     *
     * @return La fecha de nacimiento de la persona.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     *
     * @param fechaNacimiento La nueva fecha de nacimiento de la persona.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Indica si la persona tiene discapacidad.
     *
     * @return true si la persona tiene discapacidad, false en caso contrario.
     */
    public Boolean getDiscapacidad() {
        return discapacidad;
    }

    /**
     * Establece si la persona tiene discapacidad.
     *
     * @param discapacidad true si la persona tiene discapacidad, false en caso contrario.
     */
    public void setDiscapacidad(Boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    /**
     * Obtiene el número de teléfono de la persona.
     *
     * @return El número de teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono de la persona.
     *
     * @param telefono El nuevo número de teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la lista de trámites asociados a la persona.
     *
     * @return La lista de trámites asociados a la persona.
     */
    public List<Tramites> getTramites() {
        return tramites;
    }

    /**
     * Establece la lista de trámites asociados a la persona.
     *
     * @param tramites La nueva lista de trámites asociados a la persona.
     */
    public void setTramites(List<Tramites> tramites) {
        this.tramites = tramites;
    }

    /**
     * Obtiene el CURP de la persona.
     *
     * @return El CURP de la persona.
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Establece el CURP de la persona.
     *
     * @param curp El nuevo CURP de la persona.
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * Calcula la edad de la persona en años.
     *
     * @return La edad de la persona en años.
     */
    public int getEdad() {
        Calendar ahora = Calendar.getInstance();
        long edadEnDias = (ahora.getTimeInMillis() - fechaNacimiento.getTimeInMillis()) / 1000 / 60 / 60 / 24;
        int anios = Double.valueOf(edadEnDias / 365.25d).intValue();

        return anios;
    }

    /**
     * Calcula el código hash de la persona basado en su RFC.
     *
     * @return El código hash calculado.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.rfc);
        return hash;
    }

    /**
     * Compara la persona con otro objeto para verificar su igualdad basada en el RFC.
     *
     * @param obj El objeto con el que se va a comparar.
     * @return true si las personas son iguales, false en caso contrario.
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
        final Persona other = (Persona) obj;
        return Objects.equals(this.rfc, other.rfc);
    }

    /**
     * Retorna una representación en cadena de la persona.
     *
     * @return Una cadena que representa la persona.
     */
    @Override
    public String toString() {
        return "Persona{" + "rfc=" + rfc + ", nombres=" + nombres + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", fechaNacimiento=" + fechaNacimiento + ", discapacidad=" + discapacidad + ", telefono=" + telefono + '}';
    }
}
