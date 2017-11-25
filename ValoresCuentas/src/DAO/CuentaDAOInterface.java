/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Cuenta;


/**
 *
 * @author Victoria
 */
public interface CuentaDAOInterface extends GenericDAOInterface<Cuenta,String> {
    public boolean exists(String id);
}