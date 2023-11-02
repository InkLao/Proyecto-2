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
 *
 * @author HP
 */
public class CostosDAO implements ICostosDAO {

    private IConexionBD conexionBD;

    public CostosDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

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

    @Override
    public void eliminarCosto(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
