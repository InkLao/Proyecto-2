/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Costos;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ICostosDAO {
    
     // Obtiene el costo por ID
    Costos obtenerCosto(Long id) throws PersistenciaException;
    // Lista de todos los costos
    List<Costos> obtenerAllCostos() throws PersistenciaException;
    // Se agrega un costo
    Costos agregarCosto(Costos costos) throws PersistenciaException;
    // Se actualiza un costo
    Costos actualizarCosto(Costos costos) throws PersistenciaException;
    // Se elimina un costo
    void eliminarCosto(Long id) throws PersistenciaException;
    
}
