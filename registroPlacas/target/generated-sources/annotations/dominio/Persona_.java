package dominio;

import dominio.Tramites;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-11-02T03:59:07")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, Calendar> fechaNacimiento;
    public static volatile ListAttribute<Persona, Tramites> tramites;
    public static volatile SingularAttribute<Persona, String> apellido_paterno;
    public static volatile SingularAttribute<Persona, String> apellido_materno;
    public static volatile SingularAttribute<Persona, Boolean> discapacidad;
    public static volatile SingularAttribute<Persona, String> telefono;
    public static volatile SingularAttribute<Persona, String> rfc;
    public static volatile SingularAttribute<Persona, String> curp;
    public static volatile SingularAttribute<Persona, String> nombres;

}