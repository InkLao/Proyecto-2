/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Tramites;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ITramitesDAO {
    
     // Obtiene el trámite por ID
    Tramites obtenerTramite(Long id);
    // Lista de todos los trámites
    List<Tramites> obtenerAllTramites();
    // Se agrega un trámite
    Tramites agregarTramite(Tramites tramites);
    // Se actualiza un trámite
    void actualizarTramite(Tramites tramites);
    // Se elimina un trámite
    void eliminarTramite(Long id);
    
}
