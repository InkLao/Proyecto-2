/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Vehiculos;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IVehiculosDAO {
    
     // Obtiene los vehiculos por Serie
    Vehiculos obtenerVehiculo(String serie) throws PersistenciaException;
    // Lista de todos los vehiculos
    List<Vehiculos> obtenerAllVehiculos() throws PersistenciaException;
    // Se agrega un vehiculo
    Vehiculos agregarVehiculo(Vehiculos vehiculos) throws PersistenciaException;
    // Se actualiza un vehiculo
    Vehiculos actualizarVehiculo(Vehiculos vehiculos) throws PersistenciaException;
    // Se elimina un vehiculo
    void eliminarVehiculo(String serie) throws PersistenciaException;
    
}
