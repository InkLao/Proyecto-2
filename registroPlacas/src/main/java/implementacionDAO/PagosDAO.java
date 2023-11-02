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
 *
 * @author HP
 */
public class PagosDAO implements IPagosDAO {

    private IConexionBD conexionBD;

    public PagosDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Pagos obtenerPago(Long id) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try{
            bd.getTransaction().begin();
            Pagos pagoEncontrado = bd.find(Pagos.class, id);
            bd.getTransaction().commit();
            return pagoEncontrado;
        }catch(Exception ex){
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo encontrar el pago: " + ex.getMessage(), ex);
        }
        finally{
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    @Override
    public List<Pagos> obtenerAllPagos() throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try{
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Pagos> criteria = builder.createQuery(Pagos.class);
            Root<Pagos> root = criteria.from(Pagos.class);
            TypedQuery<Pagos> query = bd.createQuery(criteria);
            List<Pagos> pagos = query.getResultList();
            bd.getTransaction().commit();
            return pagos;

        }catch(Exception ex){
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo encontrar los pagos: " + ex.getMessage(), ex);
        }
        finally{
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    @Override
    public Pagos agregarPago(Pagos pagos) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try{
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

    @Override
    public Pagos actualizarPago(Pagos pagos) throws PersistenciaException {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try{
            bd.getTransaction().begin();
            Pagos pagoActualizado = bd.find(Pagos.class, pagos.getId());
            pagoActualizado.setMonto(pagos.getMonto());
            pagoActualizado.setTramites(pagos.getTramites());
            bd.merge(pagoActualizado);
            bd.getTransaction().commit();
            return pagoActualizado;
        }catch(Exception ex){
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo actualizar el pago: " + ex.getMessage(), ex);
        }
        finally{
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
    }

    @Override
    public void eliminarPago(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
