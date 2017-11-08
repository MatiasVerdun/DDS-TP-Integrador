/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.ValorCuenta;
import DTO.ValorIndicador;
import java.util.List;


public interface ValorIndicadorDAOInterface extends GenericDAOInterface<ValorIndicador,String> {
   
     public List<ValorIndicador> filterId(String id_usuario);
}
