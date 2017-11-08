/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Indicador;
import DTO.Usuario;
import Hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Vic
 */
public class IndicadorDAO extends GenericDAO<Indicador,String> implements  IndicadorDAOInterface {
    SessionFactory sessionFactory  =HibernateUtil.getSessionFactory();
    @Override
    public boolean exists(String id){
       Session session = sessionFactory.openSession();
       session.beginTransaction();
        Query query = (Query) session.createQuery("SELECT e FROM DTO.Indicador e WHERE nombreIndicador = '" +id+ "'");
         List<Usuario> entities = query.list();
         return !entities.isEmpty();
       
    }
    
    @Override
    public List<Indicador> filterId(String id_usuario) {
          
        Session session = sessionFactory.openSession();
          session.beginTransaction();
          Query query = session.createQuery("SELECT e FROM DTO.Indicador e WHERE id_usuario= '" +id_usuario+ "'");
            List<Indicador> entities = query.list();
           return entities;
    }
    
    @Override
    public Indicador filter(String id_indicador) {
          
        Session session = sessionFactory.openSession();
          session.beginTransaction();
          Query query = session.createQuery("SELECT e FROM DTO.Indicador e WHERE nombreIndicador= '" +id_indicador+ "'");
            List<Indicador> entities = query.list();
           return entities.get(0);
    }
}
