/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;

/**
 *
 * @author 
 */
public interface personaDAO {
    // Obtiene la persona por ID
    Persona getPersona(int id);
    // Lista de todas las personas
    List<Persona> getAllPersonas();
    // Se agrega una persona
    void agregarPersona(Persona persona);
    // Se actualiza una persona
    void actualizarPersona(Persona persona);
    // Se elimina una persona
    void eliminarPersona(int id);
    
    
}
