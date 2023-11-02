/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Pagos;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IPagosDAO {
    
     // Obtiene un pago por ID
    Pagos obtenerPago(Long id);
    // Lista de todas los pagos
    List<Pagos> obtenerAllPagos();
    // Se agrega un pago
    Pagos agregarPago(Pagos pagos);
    // Se actualiza un pago
    void actualizarPago(Pagos pagos);
    // Se elimina un pago
    void eliminarPago(Long id);
    
}
