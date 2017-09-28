/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Condicion;
import Hibernate.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Vic
 */
public class CondicionDAO extends GenericDAO<Condicion,String> implements  CondicionDAOInterface{
    SessionFactory sessionFactory  =HibernateUtil.getSessionFactory();
    
    @Override
    public List<Condicion> filter(String Metodologia) {
            Session session = sessionFactory.openSession();
          session.beginTransaction();
          Query query = session.createQuery("SELECT e FROM DTO.Condicion e WHERE metodologia = '" +Metodologia+ "'");
            List<Condicion> entities = query.list();
           return entities;
    }

   
}
