/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.ValorCuenta;
import Hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

public class ValorCuentaDAO extends GenericDAO<ValorCuenta,String> implements  ValorCuentaDAOInterface{
    SessionFactory sessionFactory  =HibernateUtil.getSessionFactory();
   
    @Override
    public ArrayList<ValorCuenta> filter(String Cuenta, String Empresa) {
          Session session = sessionFactory.openSession();
          session.beginTransaction();
          Query query = session.createQuery("SELECT e FROM DTO.ValorCuenta e WHERE codEmpresa = '" +Empresa+ "' AND codCuenta = '" +Cuenta+ "'");  
          session.close();
          return (ArrayList<ValorCuenta>) query.list();
    }

    @Override
   public ArrayList<ValorCuenta> filterPeriodos(String Periodo, String Empresa) {
          Session session = sessionFactory.openSession();
          session.beginTransaction();
          Query query = session.createQuery("SELECT e FROM DTO.ValorCuenta e WHERE codEmpresa = '" +Empresa+ "' AND periodo = '" +Periodo+ "'");
          
          return (ArrayList<ValorCuenta>) query.list();
    }

    @Override
   public double filterValor(String Cuenta, String Empresa,String Periodo) {
         Session session = sessionFactory.openSession();
          session.beginTransaction();
          Query query = (Query) session.createQuery("SELECT e FROM DTO.ValorCuenta e WHERE codEmpresa = '" +Empresa+ "' AND periodo = '" +Periodo+ "' AND codCuenta = '" +Cuenta+ "'" );
          return (double) query.list().get(0);
    }

   
    
}
