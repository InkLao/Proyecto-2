/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Costos;
import factory.FactoryDAO;
import factory.IFactoryDAO;

/**
 *
 * @author HP
 */
public class CostosNegocio {

    IFactoryDAO factoryDAO;

    public CostosNegocio() {
        this.factoryDAO = new FactoryDAO();
    }

    public Costos agregarCosto(Costos costo) {
        return factoryDAO.crearCostosDAO().agregarCosto(costo);
    }
}
