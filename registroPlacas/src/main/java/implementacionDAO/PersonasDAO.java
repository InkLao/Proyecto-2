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
 *
 * @author HP
 */
public class PersonasDAO implements IPersonaDAO{
    
    private IConexionBD conexionBD;

    public PersonasDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    

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

    @Override
    public void eliminarPersona(String rfc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
