/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import dominio.Persona;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author 
 */
public interface IPersonaDAO {
    // Obtiene la persona por rfc
    Persona obtenerPersona(String rfc) throws PersistenciaException;
    // Lista de todas las personas
    List<Persona> obtenerAllPersonas() throws PersistenciaException;
    // Se agrega una persona
    Persona agregarPersona(Persona persona) throws PersistenciaException;
    // Se actualiza una persona
    Persona actualizarPersona(Persona persona) throws PersistenciaException;
    // Se elimina una persona
    void eliminarPersona(String rfc) throws PersistenciaException;
    
    
}
