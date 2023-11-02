/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacionDAO;

import conexionBD.IConexionBD;
import dominio.Persona;
import excepciones.PersistenciaException;
import interfaces.IPersonaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Clase que implementa la interfaz IPersonaDAO para acceder a los datos relacionados con personas en una base de datos. Esta clase se encarga de realizar operaciones de acceso a datos, como obtener, agregar, actualizar y eliminar personas en la base de datos.
 *
 * @author HP
 */
public class PersonasDAO implements IPersonaDAO{
    
    private IConexionBD conexionBD;

    /**
     * Constructor de la clase PersonasDAO.
     *
     * @param conexionBD Objeto que proporciona la conexión a la base de datos.
     */
    public PersonasDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Obtiene una persona por su RFC.
     *
     * @param rfc RFC de la persona a obtener.
     * @return La persona encontrada o null si no se encontró.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public Persona obtenerPersona(String rfc) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try{
            bd.getTransaction().begin();
            Persona personaEncontrada = bd.find(Persona.class, rfc);
            bd.getTransaction().commit();
            return personaEncontrada;
        }catch(Exception ex){
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo encontrar a la persona: " + ex.getMessage(), ex);
        }
        finally{
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    /**
     * Obtiene una lista de todas las personas en la base de datos.
     *
     * @return Una lista de personas disponibles en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public List<Persona> obtenerAllPersonas() throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try{
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
            Root<Persona> root = criteria.from(Persona.class);
            TypedQuery<Persona> query = bd.createQuery(criteria);
            List<Persona> personas = query.getResultList();
            bd.getTransaction().commit();
            return personas;
        }catch(Exception ex){
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo encontrar a las personas: " + ex.getMessage(), ex);
        }
        finally{
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    /**
     * Agrega una nueva persona a la base de datos.
     *
     * @param persona La persona a agregar a la base de datos.
     * @return La persona agregada, con su RFC asignado.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public Persona agregarPersona(Persona persona) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try{
            bd.getTransaction().begin();
            bd.persist(persona);
            bd.getTransaction().commit();
            return persona;
        }catch(Exception ex){
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo agregar a la persona: " + ex.getMessage(), ex);
        }
        finally{
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    /**
     * Actualiza una persona en la base de datos.
     *
     * @param persona La persona con los nuevos datos a actualizar.
     * @return La persona actualizada en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public Persona actualizarPersona(Persona persona) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try{
            bd.getTransaction().begin();
            Persona personaActualizada = bd.find(Persona.class, persona.getRfc());
            personaActualizada.setNombres(persona.getNombres());
            personaActualizada.setApellido_paterno(persona.getApellido_paterno());
            personaActualizada.setApellido_materno(persona.getApellido_materno());
            personaActualizada.setFechaNacimiento(persona.getFechaNacimiento());
            personaActualizada.setCurp(persona.getCurp());
            personaActualizada.setTelefono(persona.getTelefono());
            personaActualizada.setTramites(persona.getTramites());
            personaActualizada.setDiscapacidad(persona.getDiscapacidad());
            personaActualizada.setTramites(persona.getTramites());
            bd.merge(personaActualizada);
            bd.getTransaction().commit();
            return personaActualizada;
        }catch(Exception ex){
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo actualizar a la persona: " + ex.getMessage(), ex);
        }
        finally{
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    /**
     * Elimina una persona de la base de datos por su RFC.
     *
     * @param rfc RFC de la persona a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public void eliminarPersona(String rfc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
