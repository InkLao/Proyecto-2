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
 * Clase que representa los costos de trámites, una clase base para otras clases relacionadas con costos.
 * Esta clase almacena información sobre el costo de trámites, incluyendo su ID, precio normal y lista de trámites asociados.
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
@Entity
@Table(name = "Costos")
@DiscriminatorColumn(name = "tipo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Costos implements Serializable {

    // Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "precioNormal", nullable = false)
    private Float precioNormal;

    @OneToMany(mappedBy = "Costos")
    private List<Tramites> tramites;

    /**
     * Constructor vacío de la clase Costos.
     */
    public Costos() {
    }

    /**
     * Constructor de la clase Costos con todos los parámetros.
     *
     * @param id         El ID del costo.
     * @param precioNormal El precio normal del costo.
     * @param tramites   La lista de trámites asociados al costo.
     */
    public Costos(Long id, Float precioNormal, List<Tramites> tramites) {
        this.id = id;
        this.precioNormal = precioNormal;
        this.tramites = tramites;
    }

    /**
     * Constructor de la clase Costos sin el ID.
     *
     * @param precioNormal El precio normal del costo.
     * @param tramites   La lista de trámites asociados al costo.
     */
    public Costos(Float precioNormal, List<Tramites> tramites) {
        this.precioNormal = precioNormal;
        this.tramites = tramites;
    }

    /**
     * Obtiene el ID del costo.
     *
     * @return El ID del costo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del costo.
     *
     * @param id El nuevo ID del costo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el precio normal del costo.
     *
     * @return El precio normal del costo.
     */
    public Float getPrecioNormal() {
        return precioNormal;
    }

    /**
     * Establece el precio normal del costo.
     *
     * @param precioNormal El nuevo precio normal del costo.
     */
    public void setPrecioNormal(Float precioNormal) {
        this.precioNormal = precioNormal;
    }

    /**
     * Obtiene la lista de trámites asociados al costo.
     *
     * @return La lista de trámites asociados al costo.
     */
    public List<Tramites> getTramites() {
        return tramites;
    }

    /**
     * Establece la lista de trámites asociados al costo.
     *
     * @param tramites La nueva lista de trámites asociados al costo.
     */
    public void setTramites(List<Tramites> tramites) {
        this.tramites = tramites;
    }

    /**
     * Retorna una representación en cadena del costo de trámites.
     *
     * @return Una cadena que representa el costo de trámites.
     */
    @Override
    public String toString() {
        return "Costos{" + "id=" + id + ", precioNormal=" + precioNormal + ", tramites=" + tramites + '}';
    }

    /**
     * Calcula el código hash del costo de trámites basado en su ID.
     *
     * @return El código hash calculado.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara el costo de trámites con otro objeto para verificar su igualdad basada en el ID.
     *
     * @param obj El objeto con el que se va a comparar.
     * @return true si los costos son iguales, false en caso contrario.
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
        final Costos other = (Costos) obj;
        return Objects.equals(this.id, other.id);
    }
}
