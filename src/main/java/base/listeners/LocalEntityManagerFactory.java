package base.listeners;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class LocalEntityManagerFactory implements ServletContextListener{
    private static EntityManagerFactory emf;
   
    public void contextInitialized(ServletContextEvent event) {
        emf = Persistence.createEntityManagerFactory("fuchaDB");
    }

    public void contextDestroyed(ServletContextEvent event) {
        emf.close();
    }
  
    public static EntityManager getEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("Context is not initialized yet.");
        }
        return emf.createEntityManager();
    }
}