/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vic
 * @param <T>
 * @param <ID>
 */
public interface GenericDAOInterface<T,ID extends Serializable> {
   T create();
   void saveOrUpdate(T entity);
   T get(ID id);
   List<T> findAll();
   boolean exists(ID id);
}

