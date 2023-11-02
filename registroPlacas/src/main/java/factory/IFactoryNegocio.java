/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import negocio.CostosNegocio;
import negocio.PersonaNegocio;

/**
 *
 * @author HP
 */
public interface IFactoryNegocio {

    public PersonaNegocio crearPersonaNegocio();

    public CostosNegocio crearCostoNegocio();
}
