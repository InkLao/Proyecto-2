/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Calendar;
import javax.persistence.*;
/**
 *
 * @author HP
 */

@Entity
@Table(name = "Tramites")
public class Tramites {
    
    //Atributos
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name = "fechaExpedicion", nullable = false,length = 255)
    @Temporal (TemporalType.DATE)
    private Calendar fechaExpedicion;
    
    
}
