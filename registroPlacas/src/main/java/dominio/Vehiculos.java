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
    
    public Vehiculos() {
    }

    public Vehiculos(String serie, String modelo, String color, String linea, String marca, List<Placas> placas) {
        this.serie = serie;
        this.modelo = modelo;
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.placas = placas;
    }

    public Vehiculos(String modelo, String color, String linea, String marca, List<Placas> placas) {
        this.modelo = modelo;
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.placas = placas;
    }
    
    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<Placas> getPlacas() {
        return placas;
    }

    public void setPlacas(List<Placas> placas) {
        this.placas = placas;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.serie);
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
        final Vehiculos other = (Vehiculos) obj;
        return Objects.equals(this.serie, other.serie);
    }

    @Override
    public String toString() {
        return "Vehiculos{" + "serie=" + serie + ", modelo=" + modelo + ", color=" + color + ", linea=" + linea + ", marca=" + marca + '}';
    }
    
    
    
    
}
