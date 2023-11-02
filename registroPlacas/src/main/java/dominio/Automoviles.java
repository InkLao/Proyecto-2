/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Clase que representa automóviles, una subclase de Vehiculos.
 * Esta clase almacena información sobre los automóviles, como su serie, modelo, color, línea, marca y placas asociadas.
 *
 * @author HP
 */
@Entity
@DiscriminatorValue(value = "automovil")
public class Automoviles extends Vehiculos {

    public Automoviles() {
    }

    public Automoviles(String serie, String modelo, String color, String linea, String marca, List<Placas> placas) {
        super(serie, modelo, color, linea, marca, placas);
    }

    public Automoviles(String modelo, String color, String linea, String marca, List<Placas> placas) {
        super(modelo, color, linea, marca, placas);
    }

    public Automoviles(String serie, String modelo, String color, String linea, String marca) {
        super(serie, modelo, color, linea, marca);
    }

    
}
