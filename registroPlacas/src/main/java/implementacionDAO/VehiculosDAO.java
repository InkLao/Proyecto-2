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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author HP
 */
public class VehiculosDAO implements IVehiculosDAO {
    
    private IConexionBD conexionBD;

    public VehiculosDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Vehiculos obtenerVehiculo(String serie) throws PersistenciaException {
       EntityManager bd = conexionBD.useConnectionMySQL();
        try{
            bd.getTransaction().begin();
            Vehiculos vehiculoEncontrado = bd.find(Vehiculos.class, serie);
            bd.getTransaction().commit();
            return vehiculoEncontrado;
        }catch(Exception ex){
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo encontrar el vehículo: " + ex.getMessage(), ex);
        }
        finally{
            bd.close();
        }
    }

    @Override
    public List<Vehiculos> obtenerAllVehiculos() throws PersistenciaException {
        EntityManager bd = conexionBD.useConnectionMySQL();
        try{
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Vehiculos> criteria = builder.createQuery(Vehiculos.class);
            Root<Vehiculos> root = criteria.from(Vehiculos.class);
            TypedQuery<Vehiculos> query = bd.createQuery(criteria);
            List<Vehiculos> tramites = query.getResultList();
            bd.getTransaction().commit();
            return tramites;

        }catch(Exception ex){
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo encontrar los vehículos: " + ex.getMessage(), ex);
        }
        finally{
            bd.close();
        }
    }

    @Override
    public Vehiculos agregarVehiculo(Vehiculos vehiculos) throws PersistenciaException {
        EntityManager bd = conexionBD.useConnectionMySQL();
        try{
            bd.getTransaction().begin();
            bd.persist(vehiculos);
            bd.getTransaction().commit();
            return vehiculos;
        }catch(Exception ex){
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo agregar el vehículo: " + ex.getMessage(), ex);
        }
        finally{
            bd.close();
        }
    }

    @Override
    public Vehiculos actualizarVehiculo(Vehiculos vehiculos) throws PersistenciaException {
        EntityManager bd = conexionBD.useConnectionMySQL();
        try{
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
        }catch(Exception ex){
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo actualizar el vehículo: " + ex.getMessage(), ex);
        }
        finally{
            bd.close();
        }
    }

    @Override
    public void eliminarVehiculo(String serie) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
