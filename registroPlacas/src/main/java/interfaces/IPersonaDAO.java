/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import dominio.Persona;
import java.util.List;

/**
 *
 * @author 
 */
public interface IPersonaDAO {
    // Obtiene la persona por rfc
    Persona obtenerPersona(String rfc);
    // Lista de todas las personas
    List<Persona> obtenerAllPersonas();
    // Se agrega una persona
    Persona agregarPersona(Persona persona);
    // Se actualiza una persona
    void actualizarPersona(Persona persona);
    // Se elimina una persona
    void eliminarPersona(String rfc);
    
    
}
