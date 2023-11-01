/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author HP
 */

@Entity
@Table(name = "Tramites")
public class Tramites {
    
    //Atributos
    @id
    @column (name = "id", lengt = 1000)
    private String id;
    
    @column (name = "fechaExpedicion", nullable = false,length = 255)
    @Temporal (TemporalType.DATE)
    private Calendar fechaExpedicion;
    
    
}
