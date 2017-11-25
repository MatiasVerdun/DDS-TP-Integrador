/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Usuario;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Vic
 */
public class UsuarioDAO extends GenericDAO<Usuario,String> implements  UsuarioDAOInterface{
    SessionFactory sessionFactory  =HibernateUtil.getSessionFactory();
    
    @Override
    public boolean exists(String id){
       Session session = sessionFactory.openSession();
       session.beginTransaction();
        Query query = (Query) session.createQuery("SELECT e FROM DTO.Usuario e WHERE id_usuario = '" +id+ "'");
         List<Usuario> entities = query.list();
         return !entities.isEmpty(); 
       
    }
}
