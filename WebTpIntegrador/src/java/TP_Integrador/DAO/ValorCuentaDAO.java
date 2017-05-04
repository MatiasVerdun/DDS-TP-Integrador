/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.DAO;

import TP_Integrador.DTO.ValorCuenta;
import TP_Integrador.MySQL.MySqlHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Matias
 */
public class ValorCuentaDAO {
    public void GuardarValorCuenta(ValorCuenta valorCuenta){
        try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement guardarValorCuenta = conn.prepareStatement("INSERT INTO `valorCuenta` (`codEmpresa`, `Periodo`, `codCuenta`, `Valor`) VALUES (?, ?, ?, ?)");
            guardarValorCuenta.setString(1, valorCuenta.getCodEmpresa());
            guardarValorCuenta.setString(2, valorCuenta.getPeriodo());
            guardarValorCuenta.setString(3, valorCuenta.getCodCuenta());
            guardarValorCuenta.setDouble(4, valorCuenta.getValor());

            //--- Ejecuta la sentencia para almacenar datos
            guardarValorCuenta.execute();
        } catch (SQLException ex) {
            System.out.println("Error al Insertar el Valor de la Cuenta");
        }
    }               
}
