/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Indicador;
import java.util.List;

public interface IndicadorDAOInterface extends GenericDAOInterface<Indicador,String> {
   public boolean exists(String id);
   public List<Indicador> filter(String id_usuario);
}
