/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;
import javax.persistence.*;

/**
 * Clase que representa los pagos asociados a trámites.
 * Esta clase almacena información sobre los pagos, incluyendo su ID, monto y la relación con el trámite correspondiente.
 *
 * @author HP
 */
@Entity
@Table(name = "Pagos")
public class Pagos {

    // Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto")
    private Float monto;

    // Relaciones
    @OneToOne(mappedBy = "Pagos", cascade = CascadeType.PERSIST)
    private Tramites tramites;

    /**
     * Constructor vacío de la clase Pagos.
     */
    public Pagos() {
    }

    /**
     * Constructor de la clase Pagos con todos los parámetros.
     *
     * @param id       El ID del pago.
     * @param monto    El monto del pago.
     * @param tramites El trámite asociado al pago.
     */
    public Pagos(Long id, Float monto, Tramites tramites) {
        this.id = id;
        this.monto = monto;
        this.tramites = tramites;
    }

    /**
     * Constructor de la clase Pagos sin el ID.
     *
     * @param monto    El monto del pago.
     * @param tramites El trámite asociado al pago.
     */
    public Pagos(Float monto, Tramites tramites) {
        this.monto = monto;
        this.tramites = tramites;
    }

    /**
     * Obtiene el ID del pago.
     *
     * @return El ID del pago.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del pago.
     *
     * @param id El nuevo ID del pago.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el monto del pago.
     *
     * @return El monto del pago.
     */
    public Float getMonto() {
        return monto;
    }

    /**
     * Establece el monto del pago.
     *
     * @param monto El nuevo monto del pago.
     */
    public void setMonto(Float monto) {
        this.monto = monto;
    }

    /**
     * Obtiene el trámite asociado al pago.
     *
     * @return El trámite asociado al pago.
     */
    public Tramites getTramites() {
        return tramites;
    }

    /**
     * Establece el trámite asociado al pago.
     *
     * @param tramites El nuevo trámite asociado al pago.
     */
    public void setTramites(Tramites tramites) {
        this.tramites = tramites;
    }

    /**
     * Calcula el código hash del pago basado en su ID.
     *
     * @return El código hash calculado.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara el pago con otro objeto para verificar su igualdad basada en el ID.
     *
     * @param obj El objeto con el que se va a comparar.
     * @return true si los pagos son iguales, false en caso contrario.
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
        final Pagos other = (Pagos) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Retorna una representación en cadena del pago.
     *
     * @return Una cadena que representa el pago.
     */
    @Override
    public String toString() {
        return "Pagos{" + "id=" + id + ", monto=" + monto + '}';
    }
}
