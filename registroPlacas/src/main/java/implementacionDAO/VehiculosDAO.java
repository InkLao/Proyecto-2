/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacionDAO;

import conexionBD.IConexionBD;
import dominio.Vehiculos;
import excepciones.PersistenciaException;
import interfaces.IVehiculosDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Clase que implementa la interfaz IVehiculosDAO para acceder a los datos relacionados con vehículos en una base de datos. Esta clase se encarga de realizar operaciones de acceso a datos, como obtener, agregar, actualizar y eliminar vehículos en la base de datos.
 *
 * @author HP
 */
public class VehiculosDAO implements IVehiculosDAO {

    private IConexionBD conexionBD;

    /**
     * Constructor de la clase VehiculosDAO.
     *
     * @param conexionBD Objeto que proporciona la conexión a la base de datos.
     */
    public VehiculosDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Obtiene un vehículo por su número de serie.
     *
     * @param serie Número de serie del vehículo a obtener.
     * @return El vehículo encontrado o null si no se encontró.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public Vehiculos obtenerVehiculo(String serie) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Vehiculos vehiculoEncontrado = bd.find(Vehiculos.class, serie);
            bd.getTransaction().commit();
            return vehiculoEncontrado;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo encontrar el vehículo: " + ex.getMessage(), ex);
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    /**
     * Obtiene una lista de todos los vehículos en la base de datos.
     *
     * @return Una lista de vehículos disponibles en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public List<Vehiculos> obtenerAllVehiculos() throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Vehiculos> criteria = builder.createQuery(Vehiculos.class);
            Root<Vehiculos> root = criteria.from(Vehiculos.class);
            TypedQuery<Vehiculos> query = bd.createQuery(criteria);
            List<Vehiculos> tramites = query.getResultList();
            bd.getTransaction().commit();
            return tramites;

        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo encontrar los vehículos: " + ex.getMessage(), ex);
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    /**
     * Agrega un nuevo vehículo a la base de datos.
     *
     * @param vehiculos El vehículo a agregar a la base de datos.
     * @return El vehículo agregado, con su número de serie asignado.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public Vehiculos agregarVehiculo(Vehiculos vehiculos) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            bd.persist(vehiculos);
            bd.getTransaction().commit();
            return vehiculos;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo agregar el vehículo: " + ex.getMessage(), ex);
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    /**
     * Actualiza un vehículo en la base de datos.
     *
     * @param vehiculos El vehículo con los nuevos datos a actualizar.
     * @return El vehículo actualizado en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public Vehiculos actualizarVehiculo(Vehiculos vehiculos) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Vehiculos vehiculoActualizado = bd.find(Vehiculos.class, vehiculos.getSerie());
            vehiculoActualizado.setModelo(vehiculos.getModelo());
            vehiculoActualizado.setColor(vehiculos.getColor());
            vehiculoActualizado.setLinea(vehiculos.getLinea());
            vehiculoActualizado.setMarca(vehiculos.getMarca());
            vehiculoActualizado.setPlacas(vehiculos.getPlacas());
            bd.merge(vehiculoActualizado);
            bd.getTransaction().commit();
            return vehiculoActualizado;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo actualizar el vehículo: " + ex.getMessage(), ex);
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    /**
     * Elimina un vehículo de la base de datos por su número de serie.
     *
     * @param serie El número de serie del vehículo a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public void eliminarVehiculo(String serie) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
