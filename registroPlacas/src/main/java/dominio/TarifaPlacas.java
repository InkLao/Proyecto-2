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
@DiscriminatorValue(value = "TarifaPlacas")
public class TarifaPlacas extends Costos{
    
    @Column (name = "Vigencias", nullable = false)
    @Enumerated (EnumType.STRING)
    private CondicionVehiculo condicionVehiculo;

    public TarifaPlacas() {
    }

    public TarifaPlacas(CondicionVehiculo condicionVehiculo, Long id, Float precioNormal, List<Tramites> tramites) {
        super(id, precioNormal, tramites);
        this.condicionVehiculo = condicionVehiculo;
    }

    public TarifaPlacas(CondicionVehiculo condicionVehiculo, Float precioNormal, List<Tramites> tramites) {
        super(precioNormal, tramites);
        this.condicionVehiculo = condicionVehiculo;
    }

    public CondicionVehiculo getCondicionVehiculo() {
        return condicionVehiculo;
    }

    public void setCondicionVehiculo(CondicionVehiculo condicionVehiculo) {
        this.condicionVehiculo = condicionVehiculo;
    }

    @Override
    public String toString() {
        return "TarifaPlacas{" + "condicionVehiculo=" + condicionVehiculo + '}';
    }
    
}
