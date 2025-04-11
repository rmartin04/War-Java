package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	//PATRON DE DISEÑO SINGLETON//--generar el codigo para que el objeto solo se cree una vez
	
    private static Session session=null;

    private static Session generateSession (){ 
        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure() // Carga hibernate.cfg.xml
                    .buildSessionFactory();
            session = sessionFactory.openSession();
        } catch (Throwable ex) {
            System.err.println("Error al crear la SessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        return session;
    }

    //este metodo se pone public, para que se pueda acceder desde cualquier clase
    //y se pone static para que no sea necesario crear un objeto de la clase para acceder al metodo
    //el anterior metodo se pone private para que no se pueda acceder desde otra clase
    
    public static Session getSession() {
        if (session == null) {
            session = generateSession();
        }
       
        return session;
    }
}
