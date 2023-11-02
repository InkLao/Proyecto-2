/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package factory;

import conexionBD.IConexionBD;
import interfaces.*;

/**
 * Interfaz que define los métodos para crear objetos de acceso a datos (DAO) en
 * una aplicación. Esta interfaz proporciona métodos para crear instancias de
 * diferentes tipos de DAO, como DAO de costos, pagos, personas, trámites y
 * vehículos.
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public interface IFactoryDAO {
    /**
     * Crea y devuelve un objeto de acceso a datos (DAO) para gestionar costos.
     *
     * @return Un objeto ICostosDAO para interactuar con la capa de datos de costos.
     */
    public ICostosDAO crearCostosDAO();
    
    /**
     * Crea y devuelve un objeto de acceso a datos (DAO) para gestionar pagos.
     *
     * @return Un objeto IPagosDAO para interactuar con la capa de datos de pagos.
     */
    public IPagosDAO crearPagosDAO();
    
    /**
     * Crea y devuelve un objeto de acceso a datos (DAO) para gestionar personas.
     *
     * @return Un objeto IPersonaDAO para interactuar con la capa de datos de personas.
     */
    public IPersonaDAO crearPersonasDAO();
    
    /**
     * Crea y devuelve un objeto de acceso a datos (DAO) para gestionar trámites.
     *
     * @return Un objeto ITramitesDAO para interactuar con la capa de datos de trámites.
     */
    public ITramitesDAO crearTramitesDAO();
    
    /**
     * Crea y devuelve un objeto de acceso a datos (DAO) para gestionar vehículos.
     *
     * @return Un objeto IVehiculosDAO para interactuar con la capa de datos de vehículos.
     */
    public IVehiculosDAO crearVehiculosDAO();
}

