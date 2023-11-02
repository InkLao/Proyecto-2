/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import dominio.Costos;
import dominio.Persona;
import factory.FactoryNegocio;
import factory.IFactoryNegocio;

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
    
}
