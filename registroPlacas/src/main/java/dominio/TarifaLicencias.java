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
 * Clase que representa una tarifa de licencias en el sistema.
 * Esta clase almacena información sobre la tarifa de licencias, incluyendo el precio para discapacitados y la vigencia de la tarifa.
 *
 * @author HP
 */
@Entity
@DiscriminatorValue(value = "TarifaLicencias")
public class TarifaLicencias extends Costos {

    @Column(name = "precioDiscapacitado", nullable = false)
    private Float precioDiscapacitado;

    @Column(name = "Vigencias", nullable = false)
    @Enumerated(EnumType.STRING)
    private VigenciaTarifaLicencia vigencia;

    public TarifaLicencias() {
    }

    public TarifaLicencias(Float precioDiscapacitado, VigenciaTarifaLicencia vigencia, Long id, Float precioNormal, List<Tramites> tramites) {
        super(id, precioNormal, tramites);
        this.precioDiscapacitado = precioDiscapacitado;
        this.vigencia = vigencia;
    }

    public TarifaLicencias(Float precioDiscapacitado, VigenciaTarifaLicencia vigencia, Float precioNormal, List<Tramites> tramites) {
        super(precioNormal, tramites);
        this.precioDiscapacitado = precioDiscapacitado;
        this.vigencia = vigencia;
    }

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
