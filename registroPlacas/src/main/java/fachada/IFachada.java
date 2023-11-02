/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import dominio.Costos;
import dominio.Persona;

/**
 *
 * @author HP
 */
public interface IFachada {

    public Persona agregarPersona(Persona persona);

    public Costos agregarCosto(Costos costo);
}
