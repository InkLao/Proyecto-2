/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Clase que representa una tarifa de licencias en el sistema. Esta clase almacena información sobre la tarifa de licencias, incluyendo el precio para discapacitados y la vigencia de la tarifa.
 * 
 * @author HP
 */
@Entity
@DiscriminatorValue(value = "TarifaLicencias")
public class TarifaLicencias extends Costos {

    /**
     * Precio de la tarifa para discapacitados.
     */
    @Column(name = "precioDiscapacitado", nullable = true)
    private Float precioDiscapacitado;

    /**
     * Vigencia de la tarifa de licencia.
     */
    @Column(name = "vigencias", nullable = true)
    @Enumerated(EnumType.STRING)
    private VigenciaTarifaLicencia vigencia;

    /**
     * Constructor por defecto de la clase TarifaLicencias.
     */
    public TarifaLicencias() {
    }

    /**
     * Constructor que permite inicializar todas las propiedades de la tarifa de licencias, incluyendo el precio para discapacitados, la vigencia y el precio normal.
     *
     * @param precioDiscapacitado El precio de la tarifa para discapacitados.
     * @param vigencia          La vigencia de la tarifa de licencia.
     * @param id                El identificador de la tarifa de licencias.
     * @param precioNormal      El precio normal de la tarifa.
     * @param tramites          La lista de tramites asociados a la tarifa de licencias.
     */
    public TarifaLicencias(Float precioDiscapacitado, VigenciaTarifaLicencia vigencia, Long id, Float precioNormal, List<Tramites> tramites) {
        super(id, precioNormal, tramites);
        this.precioDiscapacitado = precioDiscapacitado;
        this.vigencia = vigencia;
    }

    /**
     * Constructor que permite inicializar algunas propiedades de la tarifa de licencias, incluyendo el precio para discapacitados, la vigencia y el precio normal.
     *
     * @param precioDiscapacitado El precio de la tarifa para discapacitados.
     * @param vigencia          La vigencia de la tarifa de licencia.
     * @param precioNormal      El precio normal de la tarifa.
     * @param tramites          La lista de tramites asociados a la tarifa de licencias.
     */
    public TarifaLicencias(Float precioDiscapacitado, VigenciaTarifaLicencia vigencia, Float precioNormal, List<Tramites> tramites) {
        super(precioNormal, tramites);
        this.precioDiscapacitado = precioDiscapacitado;
        this.vigencia = vigencia;
    }

    /**
     * Constructor que permite inicializar algunas propiedades de la tarifa de licencias, incluyendo el precio para discapacitados y la vigencia.
     *
     * @param precioDiscapacitado El precio de la tarifa para discapacitados.
     * @param vigencia          La vigencia de la tarifa de licencia.
     * @param precioNormal      El precio normal de la tarifa.
     */
    public TarifaLicencias(Float precioDiscapacitado, VigenciaTarifaLicencia vigencia, Float precioNormal) {
        super(precioNormal);
        this.precioDiscapacitado = precioDiscapacitado;
        this.vigencia = vigencia;
    }

    /**
     * Obtiene el precio de la tarifa para discapacitados.
     *
     * @return El precio de la tarifa para discapacitados.
     */
    public Float getPrecioDiscapacitado() {
        return precioDiscapacitado;
    }

    /**
     * Establece el precio de la tarifa para discapacitados.
     *
     * @param precioDiscapacitado El nuevo precio de la tarifa para discapacitados.
     */
    public void setPrecioDiscapacitado(Float precioDiscapacitado) {
        this.precioDiscapacitado = precioDiscapacitado;
    }

    /**
     * Obtiene la vigencia de la tarifa de licencia.
     *
     * @return La vigencia de la tarifa de licencia.
     */
    public VigenciaTarifaLicencia getVigencia() {
        return vigencia;
    }

    /**
     * Establece la vigencia de la tarifa de licencia.
     *
     * @param vigencia La nueva vigencia de la tarifa de licencia.
     */
    public void setVigencia(VigenciaTarifaLicencia vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Retorna una representación en cadena de la tarifa de licencias.
     *
     * @return Una cadena que representa la tarifa de licencias.
     */
    @Override
    public String toString() {
        return "TarifaLicencias{" + "precioDiscapacitado=" + precioDiscapacitado + ", vigencia=" + vigencia + '}';
    }
}
