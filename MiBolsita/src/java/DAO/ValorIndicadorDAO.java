/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.Condicion;

import DTO.ValorIndicador;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;

public class ValorIndicadorDAO extends GenericDAO<ValorIndicador,String> implements  ValorIndicadorDAOInterface{
    @Override
    public List<ValorIndicador> filterId(String id_usuario) {
          
        Session session = sessionFactory.openSession();
          session.beginTransaction();
          Query query = session.createQuery("SELECT e FROM DTO.ValorIndicador e WHERE id_usuario= '" +id_usuario+ "'");
            List<ValorIndicador> entities = query.list();
           return entities;
    }
  
}
