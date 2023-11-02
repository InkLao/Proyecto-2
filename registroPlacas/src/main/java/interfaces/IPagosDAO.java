/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Pagos;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IPagosDAO {
    
     // Obtiene un pago por ID
    Pagos obtenerPago(Long id) throws PersistenciaException;
    // Lista de todas los pagos
    List<Pagos> obtenerAllPagos() throws PersistenciaException;
    // Se agrega un pago
    Pagos agregarPago(Pagos pagos) throws PersistenciaException;
    // Se actualiza un pago
    Pagos actualizarPago(Pagos pagos) throws PersistenciaException;
    // Se elimina un pago
    void eliminarPago(Long id) throws PersistenciaException;
    
}
