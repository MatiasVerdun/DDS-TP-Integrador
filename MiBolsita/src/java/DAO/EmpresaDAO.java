/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Empresa;
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
public class EmpresaDAO extends GenericDAO<Empresa,String> implements  EmpresaDAOInterface{
    
    SessionFactory sessionFactory  =HibernateUtil.getSessionFactory();
    @Override
    public boolean exists(String id){
       Session session = sessionFactory.openSession();
       session.beginTransaction();
        Query query = (Query) session.createQuery("SELECT e FROM DTO.Empresa e WHERE codEmpresa = '" +id+ "'");
         List<Usuario> entities = query.list();
         return !entities.isEmpty();
       
    }
}
