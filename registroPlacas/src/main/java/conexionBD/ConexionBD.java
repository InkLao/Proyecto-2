/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase que implementa la interfaz IConexionBD para proporcionar una conexión a la base de datos MySQL.
 * Esta clase gestiona la creación y cierre de la factoría de entidades (EntityManagerFactory) para acceder a la base de datos.
 *
 * @author HP
 */
public class ConexionBD implements IConexionBD {

    private static EntityManagerFactory factory;

    /**
     * Obtiene una instancia de la factoría de entidades (EntityManagerFactory) para la conexión a la base de datos MySQL.
     * Si la factoría no existe o está cerrada, la crea.
     *
     * @return La factoría de entidades para la conexión a la base de datos.
     */
    @Override
    public EntityManagerFactory useConnectionMySQL() {
        if (factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory("persistencia");
        }
        return factory;
    }

    /**
     * Cierra la factoría de entidades (EntityManagerFactory) si está abierta.
     */
    public static void closeEntityManagerFactory() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}

