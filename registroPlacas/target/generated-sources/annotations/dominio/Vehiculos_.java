package dominio;

import dominio.Placas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-11-02T03:59:07")
@StaticMetamodel(Vehiculos.class)
public class Vehiculos_ { 

    public static volatile SingularAttribute<Vehiculos, String> marca;
    public static volatile SingularAttribute<Vehiculos, String> color;
    public static volatile SingularAttribute<Vehiculos, String> serie;
    public static volatile SingularAttribute<Vehiculos, String> modelo;
    public static volatile SingularAttribute<Vehiculos, String> linea;
    public static volatile ListAttribute<Vehiculos, Placas> placas;

}