/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import conexionBD.ConexionBD;
import conexionBD.IConexionBD;
import implementacionDAO.CostosDAO;
import implementacionDAO.PagosDAO;
import implementacionDAO.PersonasDAO;
import implementacionDAO.TramitesDAO;
import implementacionDAO.VehiculosDAO;
import interfaces.ICostosDAO;
import interfaces.IPagosDAO;
import interfaces.IPersonaDAO;
import interfaces.ITramitesDAO;
import interfaces.IVehiculosDAO;

/**
 * Clase que implementa una fábrica para crear objetos de acceso a datos (DAO) en
 * una aplicación. Esta fábrica proporciona métodos para crear instancias de
 * diferentes tipos de DAO, como DAO de costos, pagos, personas, trámites y
 * vehículos.
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public class FactoryDAO implements IFactoryDAO {

    private IConexionBD conexionBD;

    /**
     * Crea una nueva instancia de la fábrica de DAO con una conexión a la base
     * de datos por defecto.
     */
    public FactoryDAO() {
        this.conexionBD = new ConexionBD();
    }

    /**
     * Crea y devuelve un objeto de acceso a datos (DAO) para gestionar costos.
     *
     * @return Un objeto ICostosDAO para interactuar con la capa de datos de
     * costos.
     */
    @Override
    public ICostosDAO crearCostosDAO() {
        return new CostosDAO(conexionBD);
    }

    /**
     * Crea y devuelve un objeto de acceso a datos (DAO) para gestionar pagos.
     *
     * @return Un objeto IPagosDAO para interactuar con la capa de datos de
     * pagos.
     */
    @Override
    public IPagosDAO crearPagosDAO() {
        return new PagosDAO(conexionBD);
    }

    /**
     * Crea y devuelve un objeto de acceso a datos (DAO) para gestionar personas.
     *
     * @return Un objeto IPersonaDAO para interactuar con la capa de datos de
     * personas.
     */
    @Override
    public IPersonaDAO crearPersonasDAO() {
        return new PersonasDAO(conexionBD);
    }

    /**
     * Crea y devuelve un objeto de acceso a datos (DAO) para gestionar trámites.
     *
     * @return Un objeto ITramitesDAO para interactuar con la capa de datos de
     * trámites.
     */
    @Override
    public ITramitesDAO crearTramitesDAO() {
        return new TramitesDAO(conexionBD);
    }

    /**
     * Crea y devuelve un objeto de acceso a datos (DAO) para gestionar vehículos.
     *
     * @return Un objeto IVehiculosDAO para interactuar con la capa de datos de
     * vehículos.
     */
    @Override
    public IVehiculosDAO crearVehiculosDAO() {
        return new VehiculosDAO(conexionBD);
    }
}
