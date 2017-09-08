package DAO;

import Hibernate.HibernateUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




public class GenericDAO<T, ID extends Serializable> implements GenericDAOInterface<T, ID> {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private final static Logger LOGGER = Logger.getLogger(GenericDAO.class.getName());

    public GenericDAO() {
         sessionFactory=HibernateUtil.getSessionFactory();
      }


    @Override
     public T create()  {
       try {
             return getEntityClass().newInstance();
         } catch (InstantiationException | IllegalAccessException ex) {
             throw new RuntimeException(ex);
         } catch (RuntimeException ex) {
              throw ex;
          }
     }
    
    @Override
    public void saveOrUpdate(T entity)  {
       Session session = sessionFactory.openSession();
           session.beginTransaction();
            session.saveOrUpdate(entity);
             session.getTransaction().commit();
             session.close();
     }

    @Override
      public T get(ID id)  {
         Session session = sessionFactory.openSession();
          session.beginTransaction();
          T entity = (T) session.get(getEntityClass(), id);
          session.getTransaction().commit();
          session.close();
          return entity;
          
    }


    @Override
    public List<T> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("SELECT e FROM " + getEntityClass().getName() + " e");
        List<T> entities = query.list();
        session.close();
        return entities;
     }

     private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
     }

    
   
    @Override
    public boolean exists(ID id){
        Session session = sessionFactory.openSession();
       String clase = getEntityClass().getName();
        Query query = (Query) session.createQuery("SELECT e FROM " + clase + " e");
         List<T> entities = query.list();
        session.close();
         if (entities.isEmpty()) {
        return false;
        } else{
        return true;
        }
        
    }
    
    

}