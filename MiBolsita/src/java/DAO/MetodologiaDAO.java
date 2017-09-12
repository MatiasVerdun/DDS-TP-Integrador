/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Condicion;
import DTO.Metodologia;
import Hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class MetodologiaDAO extends GenericDAO<Metodologia,String> implements  MetodologiaDAOInterface{
     SessionFactory sessionFactory  =HibernateUtil.getSessionFactory();
    @Override
    public List<Metodologia> filter(String id_usuario) {
          
        Session session = sessionFactory.openSession();
          session.beginTransaction();
          Query query = session.createQuery("SELECT e FROM DTO.Metodologia e WHERE id_usuario= '" +id_usuario+ "'");
            List<Metodologia> entities = query.list();
           return entities;
    }
}
