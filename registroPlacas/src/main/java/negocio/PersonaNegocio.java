/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Persona;
import excepciones.PersistenciaException;
import factory.FactoryDAO;
import factory.IFactoryDAO;
import java.util.List;

/**
 *
 * @author HP
 */
public class PersonaNegocio {

    IFactoryDAO factoryDAO;

    public PersonaNegocio() {
        this.factoryDAO = new FactoryDAO();
    }

    public Persona agregarPersona(Persona persona) {
        return factoryDAO.crearPersonasDAO().agregarPersona(persona);
    }

//    // Obtiene la persona por rfc
//    Persona obtenerPersona(String rfc) throws PersistenciaException
//
//    // Lista de todas las personas
//    List<Persona> obtenerAllPersonas() throws PersistenciaException;
//
//
//
//
//    // Se actualiza una persona
//    Persona actualizarPersona(Persona persona) throws PersistenciaException;
//
//    // Se elimina una persona
//    void eliminarPersona(String rfc) throws PersistenciaException;
}
