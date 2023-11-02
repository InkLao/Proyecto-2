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
 *
 * @author HP
 */
@Entity
@DiscriminatorValue(value = "TarifaLicencias")
public class TarifaLicencias extends Costos{
    
    @Column (name = "precioDiscapacitado", nullable = false)
    private Float precioDiscapacitado;
    
    @Column (name = "Vigencias", nullable = false)
    @Enumerated (EnumType.STRING)
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
    
    public Float getPrecioDiscapacitado() {
        return precioDiscapacitado;
    }

    public void setPrecioDiscapacitado(Float precioDiscapacitado) {
        this.precioDiscapacitado = precioDiscapacitado;
    }

    public VigenciaTarifaLicencia getVigencia() {
        return vigencia;
    }

    public void setVigencia(VigenciaTarifaLicencia vigencia) {
        this.vigencia = vigencia;
    }

    @Override
    public String toString() {
        return "TarifaLicencias{" + "precioDiscapacitado=" + precioDiscapacitado + ", vigencia=" + vigencia + '}';
    }
    
}
