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

    // Obtiene la persona por rfc
    public Persona obtenerPersona(String rfc) {
        return factoryDAO.crearPersonasDAO().obtenerPersona(rfc);
    }

    public List<Persona> obtenerAllPersonas() {
        return factoryDAO.crearPersonasDAO().obtenerAllPersonas();
    }

    // Se actualiza una persona
    public Persona actualizarPersona(Persona persona) {
        return factoryDAO.crearPersonasDAO().actualizarPersona(persona);
    }

    // Se elimina una persona
    public void eliminarPersona(String rfc) {
        factoryDAO.crearPersonasDAO().eliminarPersona(rfc);
    }
}
