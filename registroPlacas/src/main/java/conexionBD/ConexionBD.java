/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author HP
 */
public class ConexionBD implements IConexionBD {

    private static EntityManagerFactory factory;

    @Override
    public EntityManagerFactory useConnectionMySQL() {
        if (factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory("persistencia");
        }
        return factory;
    }

    public static void closeEntityManagerFactory() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }

}
