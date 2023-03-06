package com.densor.jfxplayerratings;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            try {
                // Create the SessionFactory from hibernate.cfg.xml
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
                System.out.println("Hibernate Configuration loaded");

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate serviceRegistry created");

                SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
            catch (Exception ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                ex.printStackTrace();
            }
        }
        return sessionFactory;
    }
    public static void shutdown() {
        sessionFactory.close();
    }


}
