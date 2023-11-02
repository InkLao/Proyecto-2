/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import dominio.Costos;
import dominio.Persona;
import dominio.Vehiculos;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IFachada {

    // personas
    public Persona agregarPersona(Persona persona);
    // Obtiene la persona por rfc

    Persona obtenerPersona(String rfc);

    List<Persona> obtenerAllPersonas();

    Persona actualizarPersona(Persona persona);

    public Costos agregarCosto(Costos costo);

    public Vehiculos agregarVehiculo(Vehiculos vehiculos);

}
