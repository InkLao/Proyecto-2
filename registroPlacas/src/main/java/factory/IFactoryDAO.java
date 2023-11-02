/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package factory;

import conexionBD.IConexionBD;
import interfaces.*;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public interface IFactoryDAO {
    public ICostosDAO crearCostosDAO();
    
    public IPagosDAO crearPagosDAO();
    
    public IPersonaDAO crearPersonasDAO();
    
    public ITramitesDAO crearTramitesDAO();
    
    public IVehiculosDAO crearVehiculosDAO();
}
