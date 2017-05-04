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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Matias
 */
public class ConsultarValoresDAO {
    public boolean ObtenerCuentas(ValorCuenta valorCuenta){
        Boolean existe=false;
        try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement consultaCuentas = conn.prepareStatement("SELECT * FROM valorcuenta where codEmpresa = ? AND periodo= ? ");
          //  consultaCuentas.setString(1, valorCuenta.getUserName());
           // consultaCuentas.setString(2, valorCuenta.getPassword());

            //--- Ejecuta la consulta
            ResultSet rs = consultaCuentas.executeQuery();
            //--- Verifica si pudo obtener al Usuuario
            if(rs.next())   {
                existe=true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al validar el usuario");
        }
        return existe;
    }
}
