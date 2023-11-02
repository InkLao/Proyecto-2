/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Vehiculos;
import factory.FactoryDAO;
import factory.IFactoryDAO;

/**
 *
 * @author HP
 */
public class AutomovilNegocio {

    IFactoryDAO factoryDAO;

    public AutomovilNegocio() {
        this.factoryDAO = new FactoryDAO();
    }

    public Vehiculos agregarVehiculo(Vehiculos vehiculos) {
        return factoryDAO.crearVehiculosDAO().agregarVehiculo(vehiculos);
    }
}
