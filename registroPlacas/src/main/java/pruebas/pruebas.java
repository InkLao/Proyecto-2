/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import dominio.Automoviles;
import dominio.CondicionVehiculo;
import dominio.Persona;
import dominio.TarifaLicencias;
import dominio.TarifaPlacas;
import dominio.VigenciaTarifaLicencia;
import excepciones.PersistenciaException;
import factory.FactoryDAO;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaException {
        // TODO code application logic here

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        
//        Persona nuevoUsuario = new Persona("1234567891011", "Daniel", "Alamea", "Lopez", Calendar.getInstance(), Boolean.FALSE, "123456789");
//        em.persist(nuevoUsuario);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
        FactoryDAO factoryDAO = new FactoryDAO();

        //Persona persona = new Persona("1234567891011", "Daniel", "Alamea", "Lopez", Calendar.getInstance(), Boolean.FALSE, "123456789", "ROHJ010918HSLDRRA4");
        //persona.setTramites(null);
        //factoryDAO.crearPersonasDAO().agregarPersona(persona);
//    Automoviles automovil = new Automoviles("abcdefghijklmnopq", "Supra", "rojo", "1998", "Toyota");
//    
//        factoryDAO.crearVehiculosDAO().agregarVehiculo(automovil);
        TarifaPlacas tarifaPlacas = new TarifaPlacas(CondicionVehiculo.NUEVO, 400F);
        TarifaLicencias tarifaLicencias = new TarifaLicencias(200f, VigenciaTarifaLicencia.I_AÑO, 300f); // factoryDAO.crearCostosDAO().agregarCosto(tarifaPlacas);

        factoryDAO.crearCostosDAO().agregarCosto(tarifaLicencias);
        factoryDAO.crearCostosDAO().agregarCosto(tarifaPlacas);
    }

}
