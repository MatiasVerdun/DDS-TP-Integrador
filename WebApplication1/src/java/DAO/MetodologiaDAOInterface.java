/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.*;
import java.util.List;


public interface MetodologiaDAOInterface extends GenericDAOInterface<Metodologia,String> {
    
    public List<Metodologia> filter(String id_usuario);

    
}
