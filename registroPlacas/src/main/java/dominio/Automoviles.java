/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Clase que representa automóviles, una subclase de Vehiculos. Esta clase almacena información
 * sobre los automóviles, como su serie, modelo, color, línea, marca y placas asociadas.
 *
 * @author HP
 */
@Entity
@DiscriminatorValue(value = "automovil")
public class Automoviles extends Vehiculos {

    /**
     * Constructor por defecto de la clase Automoviles.
     */
    public Automoviles() {
    }

    /**
     * Constructor que permite inicializar todas las propiedades de un automóvil, incluyendo serie, modelo, color, línea, marca y placas asociadas.
     *
     * @param serie  La serie del automóvil.
     * @param modelo El modelo del automóvil.
     * @param color  El color del automóvil.
     * @param linea  La línea del automóvil.
     * @param marca  La marca del automóvil.
     * @param placas Las placas asociadas al automóvil.
     */
    public Automoviles(String serie, String modelo, String color, String linea, String marca, List<Placas> placas) {
        super(serie, modelo, color, linea, marca, placas);
    }

    /**
     * Constructor que permite inicializar algunas propiedades de un automóvil, incluyendo modelo, color, línea, marca y placas asociadas.
     *
     * @param modelo El modelo del automóvil.
     * @param color  El color del automóvil.
     * @param linea  La línea del automóvil.
     * @param marca  La marca del automóvil.
     * @param placas Las placas asociadas al automóvil.
     */
    public Automoviles(String modelo, String color, String linea, String marca, List<Placas> placas) {
        super(modelo, color, linea, marca, placas);
    }

    /**
     * Constructor que permite inicializar algunas propiedades de un automóvil, incluyendo serie, modelo, color, línea y marca.
     *
     * @param serie  La serie del automóvil.
     * @param modelo El modelo del automóvil.
     * @param color  El color del automóvil.
     * @param linea  La línea del automóvil.
     * @param marca  La marca del automóvil.
     */
    public Automoviles(String serie, String modelo, String color, String linea, String marca) {
        super(serie, modelo, color, linea, marca);
    }
}

