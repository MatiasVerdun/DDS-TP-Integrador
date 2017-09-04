/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.*;
import java.util.List;


/**
 *
 * @author Vic
 */
public interface CondicionDAOInterface extends GenericDAOInterface<Condicion,String> {
    public List<Condicion> filter(String Metodologia);
}
