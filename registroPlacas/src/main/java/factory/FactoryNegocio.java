/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import negocio.AutomovilNegocio;
import negocio.CostosNegocio;
import negocio.PersonaNegocio;

/**
 *
 * @author HP
 */
public class FactoryNegocio implements IFactoryNegocio {

    @Override
    public PersonaNegocio crearPersonaNegocio() {
        return new PersonaNegocio();
    }

    @Override
    public CostosNegocio crearCostoNegocio() {
        return new CostosNegocio();
    }

    @Override
    public AutomovilNegocio crearAutomovilNegocio() {
        return new AutomovilNegocio();
    }

}
