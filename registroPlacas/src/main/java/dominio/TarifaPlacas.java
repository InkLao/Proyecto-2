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
 * Clase que representa una tarifa de placas para vehículos, que extiende la
 * clase Costos. Esta clase almacena información sobre la condición del vehículo
 * y los costos asociados.
 *
 * @author HP
 */
@Entity
@DiscriminatorValue(value = "TarifaPlacas")
public class TarifaPlacas extends Costos {

    /**
     * Condición del vehículo a la que se aplica esta tarifa.
     */
    @Column(name = "condicion", nullable = true)
    @Enumerated(EnumType.STRING)
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

    public TarifaPlacas(CondicionVehiculo condicionVehiculo, Float precioNormal) {
        super(precioNormal);
        this.condicionVehiculo = condicionVehiculo;
    }

    /**
     * Obtiene la condición del vehículo asociada a esta tarifa.
     *
     * @return La condición del vehículo.
     */
    public CondicionVehiculo getCondicionVehiculo() {
        return condicionVehiculo;
    }

    /**
     * Establece la condición del vehículo para esta tarifa.
     *
     * @param condicionVehiculo La nueva condición del vehículo.
     */
    public void setCondicionVehiculo(CondicionVehiculo condicionVehiculo) {
        this.condicionVehiculo = condicionVehiculo;
    }

    /**
     * Retorna una representación en cadena de la tarifa de placas.
     *
     * @return Una cadena que representa la tarifa de placas.
     */
    @Override
    public String toString() {
        return "TarifaPlacas{" + "condicionVehiculo=" + condicionVehiculo + '}';
    }
}
