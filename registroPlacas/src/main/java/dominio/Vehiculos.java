/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "vehiculos")
public class Vehiculos {
    
    @Id
    @Column(name = "serie", length = 255)
    private String serie;
    
    @Column(name = "modelo", nullable = false, length = 255)
    private String modelo;
    
    @Column(name = "color", nullable = false, length = 255)
    private String color;
    
    @Column(name = "linea", nullable = false, length = 255)
    private String linea;
    
    @Column(name = "marca", nullable = false, length = 255)
    private String marca;
    
    
}
