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
 * Clase que representa un vehículo en el sistema
 * Esta clase almacena información sobre un vehículo
 * @author HP
 */
@Entity
@Table(name = "Vehiculos")
@DiscriminatorColumn(name = "tipo")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public class Vehiculos {
    
    @Id
    @Column(name = "serie", length = 17)
    private String serie;
    
    @Column(name = "modelo", nullable = false, length = 255)
    private String modelo;
    
    @Column(name = "color", nullable = false, length = 255)
    private String color;
    
    @Column(name = "linea", nullable = false, length = 255)
    private String linea;
    
    @Column(name = "marca", nullable = false, length = 255)
    private String marca;

    //Relaciones
    @OneToMany (mappedBy = "Vehiculos")
    private List<Placas> placas;
    
    /**
     * Constructor vacío de la clase Vehiculos
     */
    public Vehiculos() {
    }
    
    /**
     * Constructor de la clase Vehiculos con todos los parámetros
     * @param serie La serie del vehículo
     * @param modelo El modelo del vehículo
     * @param color El color del vehículo
     * @param linea La línea del vehículo
     * @param marca La marca del vehículo
     * @param placas Las placas asociadas al vehículo
     */
    public Vehiculos(String serie, String modelo, String color, String linea, String marca, List<Placas> placas) {
        this.serie = serie;
        this.modelo = modelo;
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.placas = placas;
    }
    
    /**
     * Constructor de la clase Vehiculos sin la serie
     * @param modelo El modelo del vehículo
     * @param color El color del vehículo
     * @param linea La línea del vehículo
     * @param marca La marca del vehículo
     * @param placas Las placas asociadas al vehículo
     */
    public Vehiculos(String modelo, String color, String linea, String marca, List<Placas> placas) {
        this.modelo = modelo;
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.placas = placas;
    }

    public Vehiculos(String serie, String modelo, String color, String linea, String marca) {
        this.serie = serie;
        this.modelo = modelo;
        this.color = color;
        this.linea = linea;
        this.marca = marca;
    }
    
    
    /**
     * Obtiene la serie del vehículo
     * 
     * @return La serie del vehículo
     */
    public String getSerie() {
        return serie;
    }
    
    /**
     * Establece la serie del vehículo
     * 
     * @param serie La nueva serie del vehículo
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }
    
    /**
     * Obtiene el modelo del vehículo
     * 
     * @return El modelo del vehículo
     */
    public String getModelo() {
        return modelo;
    }
    
    /**
     * Establece el modelo del vehículo
     * 
     * @param modelo El nuevo modelo del vehículo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    /**
     * Obtiene el color del vehículo
     * 
     * @return El color del vehículo
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Establece el color del vehículo
     * 
     * @param color El nuevo color del vehículo
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    /**
     * Obtiene la línea del vehículo
     * 
     * @return La línea del vehículo
     */
    public String getLinea() {
        return linea;
    }
    
    /**
     * Establece la línea del vehículo
     * 
     * @param linea La nueva línea del vehículo
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }
    
    /**
     * Obtiene la marca del vehículo
     * 
     * @return La nueva marca del vehículo
     */
    public String getMarca() {
        return marca;
    }
    
    /**
     * Establece la marca del vehículo
     * 
     * @param marca La nueva marca del vehículo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /**
     * Obtiene las placas asociadas al vehículo
     * 
     * @return Las placas asociadas al vehículo
     */
    public List<Placas> getPlacas() {
        return placas;
    }
    
    /**
     * Establece las placas asociadas al vehículo
     * 
     * @param placas Las nuevas placas asociadas al vehículo
     */
    public void setPlacas(List<Placas> placas) {
        this.placas = placas;
    }
    
    /**
     * Calcula el valor de hash del vehículo.
     * 
     * @return El valor de hash calculado.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.serie);
        return hash;
    }
    
    /**
     * Compara el vehículo con otro objeto para determinar si son iguales
     * 
     * @param obj El objeto con el que se compara el vehículo
     * @return true si los vehículos son iguales, false en caso contrario
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
        final Vehiculos other = (Vehiculos) obj;
        return Objects.equals(this.serie, other.serie);
    }
    
    /**
     * Retorna una representación en cadena del vehículo.
     *
     * @return Una cadena que representa el vehículo.
     */
    @Override
    public String toString() {
        return "Vehiculos{" + "serie=" + serie + ", modelo=" + modelo + ", color=" + color + ", linea=" + linea + ", marca=" + marca + '}';
    }

}

