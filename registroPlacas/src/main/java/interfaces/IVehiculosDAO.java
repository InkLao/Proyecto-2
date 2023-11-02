/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Vehiculos;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IVehiculosDAO {
    
     // Obtiene los vehiculos por Serie
    Vehiculos obtenerVehiculo(String serie);
    // Lista de todos los vehiculos
    List<Vehiculos> obtenerAllVehiculos();
    // Se agrega un vehiculo
    Vehiculos agregarVehiculo(Vehiculos vehiculos);
    // Se actualiza un vehiculo
    void actualizarVehiculo(Vehiculos vehiculos);
    // Se elimina un vehiculo
    void eliminarVehiculo(String serie);
    
}
