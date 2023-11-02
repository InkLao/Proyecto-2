package dominio;

import dominio.Costos;
import dominio.EstadoTramite;
import dominio.Persona;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-11-02T15:24:44")
@StaticMetamodel(Tramites.class)
public class Tramites_ { 

    public static volatile SingularAttribute<Tramites, Costos> costos;
    public static volatile SingularAttribute<Tramites, Calendar> fechaExpedicion;
    public static volatile SingularAttribute<Tramites, EstadoTramite> estado;
    public static volatile SingularAttribute<Tramites, Persona> persona;
    public static volatile SingularAttribute<Tramites, Long> id;

}