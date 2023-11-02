/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacionDAO;

import conexionBD.IConexionBD;
import dominio.Tramites;
import excepciones.PersistenciaException;
import interfaces.ITramitesDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Clase que implementa la interfaz ITramitesDAO para acceder a los datos relacionados con trámites en una base de datos. Esta clase se encarga de realizar operaciones de acceso a datos, como obtener, agregar, actualizar y eliminar trámites en la base de datos.
 *
 * @author HP
 */
public class TramitesDAO implements ITramitesDAO {
    
    private IConexionBD conexionBD;

    /**
     * Constructor de la clase TramitesDAO.
     *
     * @param conexionBD Objeto que proporciona la conexión a la base de datos.
     */
    public TramitesDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Obtiene un trámite por su ID.
     *
     * @param id ID del trámite a obtener.
     * @return El trámite encontrado o null si no se encontró.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public Tramites obtenerTramite(Long id) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try{
            bd.getTransaction().begin();
            Tramites tramiteEncontrado = bd.find(Tramites.class, id);
            bd.getTransaction().commit();
            return tramiteEncontrado;
        }catch(Exception ex){
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo encontrar el trámite: " + ex.getMessage(), ex);
        }
        finally{
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    /**
     * Obtiene una lista de todos los trámites en la base de datos.
     *
     * @return Una lista de trámites disponibles en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public List<Tramites> obtenerAllTramites() throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try{
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Tramites> criteria = builder.createQuery(Tramites.class);
            Root<Tramites> root = criteria.from(Tramites.class);
            TypedQuery<Tramites> query = bd.createQuery(criteria);
            List<Tramites> tramites = query.getResultList();
            bd.getTransaction().commit();
            return tramites;
        }catch(Exception ex){
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo encontrar los trámites: " + ex.getMessage(), ex);
        }
        finally{
           if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    /**
     * Agrega un nuevo trámite a la base de datos.
     *
     * @param tramites El trámite a agregar a la base de datos.
     * @return El trámite agregado, con su ID asignado.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public Tramites agregarTramite(Tramites tramites) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try{
            bd.getTransaction().begin();
            bd.persist(tramites);
            bd.getTransaction().commit();
            return tramites;
        }catch(Exception ex){
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo agregar el trámite: " + ex.getMessage(), ex);
        }
        finally{
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    /**
     * Actualiza un trámite en la base de datos.
     *
     * @param tramites El trámite con los nuevos datos a actualizar.
     * @return El trámite actualizado en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public Tramites actualizarTramite(Tramites tramites) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try{
            bd.getTransaction().begin();
            Tramites tramiteActualizado = bd.find(Tramites.class, tramites.getId());
            tramiteActualizado.setFechaExpedicion(tramites.getFechaExpedicion());
            tramiteActualizado.setEstado(tramites.getEstado());
            tramiteActualizado.setPersona(tramites.getPersona());
            tramiteActualizado.setCostos(tramites.getCostos());
            bd.merge(tramiteActualizado);
            bd.getTransaction().commit();
            return tramiteActualizado;
        }catch(Exception ex){
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo actualizar el trámite: " + ex.getMessage(), ex);
        }
        finally{
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    /**
     * Elimina un trámite de la base de datos por su ID.
     *
     * @param id ID del trámite a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public void eliminarTramite(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
