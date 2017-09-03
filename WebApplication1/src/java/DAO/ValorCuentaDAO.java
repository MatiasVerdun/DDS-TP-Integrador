/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.ValorCuenta;
import Hibernate.HibernateUtil;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

public class ValorCuentaDAO extends GenericDAO<ValorCuenta,String> implements  ValorCuentaDAOInterface{
    SessionFactory sessionFactory  =HibernateUtil.getSessionFactory();
    public List<ValorCuenta> findAll(String Cuenta, String Empresa) {
          Session session = sessionFactory.getCurrentSession();
          session.beginTransaction();
          Query query = session.createQuery("SELECT e FROM valorcuenta WHERE codEmpresa =" +Empresa+ "AND codCuenta = " +Cuenta);
           
          session.getTransaction().commit();
          return query.list();
    }

   

   
    
}
