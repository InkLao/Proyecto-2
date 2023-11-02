/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Tramites;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ITramitesDAO {
    
     // Obtiene el trámite por ID
    Tramites obtenerTramite(Long id) throws PersistenciaException;
    // Lista de todos los trámites
    List<Tramites> obtenerAllTramites() throws PersistenciaException;
    // Se agrega un trámite
    Tramites agregarTramite(Tramites tramites) throws PersistenciaException;
    // Se actualiza un trámite
    Tramites actualizarTramite(Tramites tramites) throws PersistenciaException;
    // Se elimina un trámite
    void eliminarTramite(Long id) throws PersistenciaException;
    
}
