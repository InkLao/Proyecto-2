/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacionDAO;

import conexionBD.IConexionBD;
import dominio.Costos;
import excepciones.PersistenciaException;
import interfaces.ICostosDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Clase que implementa la interfaz ICostosDAO para acceder a los datos relacionados con costos en una base de datos. Esta clase se encarga de realizar operaciones de acceso a datos, como obtener, agregar, actualizar y eliminar costos en la base de datos.
 *
 * @author HP
 */
public class CostosDAO implements ICostosDAO {

    private IConexionBD conexionBD;
    
    /**
     * Constructor de la clase CostosDAO.
     *
     * @param conexionBD Objeto que proporciona la conexión a la base de datos.
     */
    public CostosDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    /**
     * Obtiene un costo por su identificador único.
     *
     * @param id Identificador del costo a obtener.
     * @return El costo encontrado o null si no se encontró.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public Costos obtenerCosto(Long id) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Costos costoEncontrado = bd.find(Costos.class, id);
            bd.getTransaction().commit();
            return costoEncontrado;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo encontrar el costo: " + ex.getMessage(), ex);
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }
    
    /**
     * Obtiene una lista de todos los costos en la base de datos.
     *
     * @return Una lista de costos disponibles en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public List<Costos> obtenerAllCostos() throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Costos> criteria = builder.createQuery(Costos.class);
            Root<Costos> root = criteria.from(Costos.class);
            TypedQuery<Costos> query = bd.createQuery(criteria);
            List<Costos> costos = query.getResultList();
            bd.getTransaction().commit();
            return costos;

        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo encontrar los costos: " + ex.getMessage(), ex);
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }
    
    /**
     * Agrega un nuevo costo a la base de datos.
     *
     * @param costos El costo a agregar a la base de datos.
     * @return El costo agregado, con su identificador único asignado.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public Costos agregarCosto(Costos costos) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            bd.persist(costos);
            bd.getTransaction().commit();
            return costos;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo agregar el costo: " + ex.getMessage(), ex);
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }
    
    /**
     * Actualiza un costo en la base de datos.
     *
     * @param costos El costo con los nuevos datos a actualizar.
     * @return El costo actualizado en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public Costos actualizarCosto(Costos costos) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Costos costoActualizado = bd.find(Costos.class, costos.getId());
            costoActualizado.setPrecioNormal(costos.getPrecioNormal());
            costoActualizado.setTramites(costos.getTramites());
            bd.merge(costoActualizado);
            bd.getTransaction().commit();
            return costoActualizado;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo actualizar el costo: " + ex.getMessage(), ex);
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }
    
    /**
     * Elimina un costo en base a su id
     * @param id Identificador del costo a eliminar
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public void eliminarCosto(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
