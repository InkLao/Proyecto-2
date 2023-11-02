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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author HP
 */
public class TramitesDAO implements ITramitesDAO {
    
    private IConexionBD conexionBD;

    public TramitesDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Tramites obtenerTramite(Long id) throws PersistenciaException {
         EntityManager bd = conexionBD.useConnectionMySQL();
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
            bd.close();
        }
    }

    @Override
    public List<Tramites> obtenerAllTramites() throws PersistenciaException {
        EntityManager bd = conexionBD.useConnectionMySQL();
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
            bd.close();
        }
    }

    @Override
    public Tramites agregarTramite(Tramites tramites) throws PersistenciaException {
        EntityManager bd = conexionBD.useConnectionMySQL();
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
            bd.close();
        }
    }

    @Override
    public Tramites actualizarTramite(Tramites tramites) throws PersistenciaException {
        EntityManager bd = conexionBD.useConnectionMySQL();
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
            bd.close();
        }
    }

    @Override
    public void eliminarTramite(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
