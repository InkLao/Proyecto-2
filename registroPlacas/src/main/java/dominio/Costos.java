/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
@Entity
@Table(name = "Costos")
@DiscriminatorColumn(name = "tipo")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public class Costos implements Serializable {

    //Atributos
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name = "precioNormal", nullable = false)
    private Float precioNormal;
    
    @OneToMany (mappedBy = "Costos")
    private List<Tramites> tramites;

    public Costos() {
    }
    
    public Costos(Long id, Float precioNormal, List<Tramites> tramites) {
        this.id = id;
        this.precioNormal = precioNormal;
        this.tramites = tramites;
    }

    public Costos(Float precioNormal, List<Tramites> tramites) {
        this.precioNormal = precioNormal;
        this.tramites = tramites;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPrecioNormal() {
        return precioNormal;
    }

    public void setPrecioNormal(Float precioNormal) {
        this.precioNormal = precioNormal;
    }

    public List<Tramites> getTramites() {
        return tramites;
    }

    public void setTramites(List<Tramites> tramites) {
        this.tramites = tramites;
    }

    @Override
    public String toString() {
        return "Costos{" + "id=" + id + ", precioNormal=" + precioNormal + ", tramites=" + tramites + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Costos other = (Costos) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
}
