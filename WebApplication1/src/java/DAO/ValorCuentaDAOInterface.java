/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ValorCuenta;
import java.util.List;


public interface ValorCuentaDAOInterface extends GenericDAOInterface<ValorCuenta,String> {

    public List<ValorCuenta> filter(String Cuenta, String Empresa);
    public List<ValorCuenta> filterPeriodos(String Periodo, String Empresa);
    public double filterValor(String Cuenta, String Empresa,String Periodo);
}
