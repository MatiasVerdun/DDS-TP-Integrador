/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.service.ServiceRegistry;




public class HibernateUtil {

   private static SessionFactory sessionFactory;

   public static synchronized void buildSessionFactory() {
        if (sessionFactory == null) {
       Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        }
   
    }

    public static void openSessionAndBindToThread() {
     Session session = sessionFactory.openSession();
     ThreadLocalSessionContext.bind(session);
    }

    public static SessionFactory getSessionFactory() {
         if (sessionFactory==null)  {
          buildSessionFactory();
         }
       return sessionFactory;
    }
    
    public static void closeSessionAndUnbindFromThread() {
         Session session = ThreadLocalSessionContext.unbind(sessionFactory);
       if (session!=null) {
            session.close();
        }
     }
    
    public static void closeSessionFactory() {
        if ((sessionFactory!=null) && (sessionFactory.isClosed()==false)) {
          sessionFactory.close();
        }
    }

    
}
