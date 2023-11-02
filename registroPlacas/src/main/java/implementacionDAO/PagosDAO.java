/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacionDAO;

import conexionBD.IConexionBD;
import dominio.Pagos;
import excepciones.PersistenciaException;
import interfaces.IPagosDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Clase que implementa la interfaz IPagosDAO para acceder a los datos relacionados con pagos en una base de datos. Esta clase se encarga de realizar operaciones de acceso a datos, como obtener, agregar, actualizar y eliminar pagos en la base de datos.
 *
 * @author HP
 */
public class PagosDAO implements IPagosDAO {

    private IConexionBD conexionBD;

    /**
     * Constructor de la clase PagosDAO.
     *
     * @param conexionBD Objeto que proporciona la conexión a la base de datos.
     */
    public PagosDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Obtiene un pago por su identificador único.
     *
     * @param id Identificador del pago a obtener.
     * @return El pago encontrado o null si no se encontró.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public Pagos obtenerPago(Long id) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Pagos pagoEncontrado = bd.find(Pagos.class, id);
            bd.getTransaction().commit();
            return pagoEncontrado;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo encontrar el pago: " + ex.getMessage(), ex);
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    /**
     * Obtiene una lista de todos los pagos en la base de datos.
     *
     * @return Una lista de pagos disponibles en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public List<Pagos> obtenerAllPagos() throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Pagos> criteria = builder.createQuery(Pagos.class);
            Root<Pagos> root = criteria.from(Pagos.class);
            TypedQuery<Pagos> query = bd.createQuery(criteria);
            List<Pagos> pagos = query.getResultList();
            bd.getTransaction().commit();
            return pagos;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo encontrar los pagos: " + ex.getMessage(), ex);
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    /**
     * Agrega un nuevo pago a la base de datos.
     *
     * @param pagos El pago a agregar a la base de datos.
     * @return El pago agregado, con su identificador único asignado.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public Pagos agregarPago(Pagos pagos) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            bd.persist(pagos);
            bd.getTransaction().commit();
            return pagos;
        }catch(Exception ex){
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo agregar el pago: " + ex.getMessage(), ex);
        }
        finally{
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    /**
     * Actualiza un pago en la base de datos.
     *
     * @param pagos El pago con los nuevos datos a actualizar.
     * @return El pago actualizado en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public Pagos actualizarPago(Pagos pagos) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Pagos pagoActualizado = bd.find(Pagos.class, pagos.getId());
            pagoActualizado.setMonto(pagos.getMonto());
            pagoActualizado.setTramites(pagos.getTramites());
            bd.merge(pagoActualizado);
            bd.getTransaction().commit();
            return pagoActualizado;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo actualizar el pago: " + ex.getMessage(), ex);
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    /**
     * Elimina un pago de la base de datos por su identificador único.
     *
     * @param id Identificador del pago a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public void eliminarPago(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
