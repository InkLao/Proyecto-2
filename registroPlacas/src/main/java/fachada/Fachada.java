/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import dominio.Costos;
import dominio.Persona;
import dominio.Vehiculos;
import factory.FactoryNegocio;
import factory.IFactoryNegocio;
import java.util.List;

/**
 *
 * @author HP
 */
public class Fachada implements IFachada {

    IFactoryNegocio factoryNegocio;

    public Fachada() {
        this.factoryNegocio = new FactoryNegocio();
    }

    @Override
    public Persona agregarPersona(Persona persona) {
        return factoryNegocio.crearPersonaNegocio().agregarPersona(persona);
    }

    @Override
    public Costos agregarCosto(Costos costo) {
        return factoryNegocio.crearCostoNegocio().agregarCosto(costo);
    }

    @Override
    public Persona obtenerPersona(String rfc) {
        return factoryNegocio.crearPersonaNegocio().obtenerPersona(rfc);
    }

    @Override
    public List<Persona> obtenerAllPersonas() {
        return factoryNegocio.crearPersonaNegocio().obtenerAllPersonas();
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vehiculos agregarVehiculo(Vehiculos vehiculos) {
        return factoryNegocio.crearAutomovilNegocio().agregarVehiculo(vehiculos);
    }

}
