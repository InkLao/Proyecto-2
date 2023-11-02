/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Costos;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ICostosDAO {
    
     // Obtiene el costo por ID
    Costos obtenerCosto(Long id);
    // Lista de todos los costos
    List<Costos> obtenerAllCostos();
    // Se agrega un costo
    Costos agregarCosto(Costos costos);
    // Se actualiza un costo
    void actualizarCosto(Costos costos);
    // Se elimina un costo
    void eliminarCosto(Long id);
    
}
