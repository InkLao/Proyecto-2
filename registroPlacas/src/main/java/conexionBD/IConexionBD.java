/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package conexionBD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Interfaz que define el método para obtener una instancia de EntityManagerFactory
 * con el propósito de establecer una conexión a una base de datos MySQL.
 *
 * @author HP
 */
public interface IConexionBD {
    
    /**
     * Obtiene una instancia de EntityManagerFactory para la conexión a una base de datos MySQL.
     *
     * @return La factoría de entidades para la conexión a la base de datos.
     */
    EntityManagerFactory useConnectionMySQL();
}

