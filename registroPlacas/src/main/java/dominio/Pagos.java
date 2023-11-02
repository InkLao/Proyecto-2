/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "Pagos")
public class Pagos {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "monto")
    private Float monto;

    //Relaciones
    @OneToOne(mappedBy = "Pagos", cascade = CascadeType.PERSIST)
    private Tramites tramites;
    
    public Pagos() {
    }

    public Pagos(Long id, Float monto, Tramites tramites) {
        this.id = id;
        this.monto = monto;
        this.tramites = tramites;
    }

    public Pagos(Float monto, Tramites tramites) {
        this.monto = monto;
        this.tramites = tramites;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public Tramites getTramites() {
        return tramites;
    }

    public void setTramites(Tramites tramites) {
        this.tramites = tramites;
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
        final Pagos other = (Pagos) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Pagos{" + "id=" + id + ", monto=" + monto + '}';
    }
    
    
    
    
    
}
