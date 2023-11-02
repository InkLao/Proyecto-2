package dominio;

import dominio.Vehiculos;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-11-02T15:24:44")
@StaticMetamodel(Placas.class)
public class Placas_ extends Tramites_ {

    public static volatile SingularAttribute<Placas, String> noAlfanumerico;
    public static volatile SingularAttribute<Placas, Vehiculos> vehiculos;
    public static volatile SingularAttribute<Placas, Calendar> fechaRecepcion;

}