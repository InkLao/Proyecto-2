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
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public class FactoryDAO implements IFactoryDAO {

    private IConexionBD conexionBD;

    public FactoryDAO() {
        this.conexionBD = new ConexionBD();
    }

    @Override
    public ICostosDAO crearCostosDAO() {

        return new CostosDAO(conexionBD);
    }

    @Override
    public IPagosDAO crearPagosDAO() {

        return new PagosDAO(conexionBD);
    }

    @Override
    public IPersonaDAO crearPersonasDAO() {

        return new PersonasDAO(conexionBD);
    }

    @Override
    public ITramitesDAO crearTramitesDAO() {

        return new TramitesDAO(conexionBD);
    }

    @Override
    public IVehiculosDAO crearVehiculosDAO() {

        return new VehiculosDAO(conexionBD);
    }

}
