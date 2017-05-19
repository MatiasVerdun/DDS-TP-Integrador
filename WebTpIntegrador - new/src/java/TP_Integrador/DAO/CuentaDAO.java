/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.DAO;

import TP_Integrador.DTO.Cuenta;
import TP_Integrador.MySQL.MySqlHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Victoria
 */
public class CuentaDAO {
    public boolean validarExistencia(String codigo){
        Boolean existe=false;
        try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement consultaUsuario = conn.prepareStatement("SELECT * FROM cuentas where codCuenta= ?   ");
            consultaUsuario.setString(1,codigo);
            
            //--- Ejecuta la consulta
            ResultSet rs = consultaUsuario.executeQuery();
            //--- Verifica si pudo obtener al Usuuario
            if(rs.next())   {
                existe=true;
               
            }
        } catch (SQLException ex) {
            System.out.println("Error al validar cuenta ");
        }
        return existe;
    } 
    
        public void GuardarCuenta(Cuenta cuenta){
        try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement guardarCuenta = conn.prepareStatement("INSERT INTO `cuentas` (`codCuenta`, `nombreCuenta`) VALUES (?, ?)");
            guardarCuenta.setString(1, cuenta.getCodCuenta());
            guardarCuenta.setString(2, cuenta.getNombreCuenta());
          
            

            //--- Ejecuta la sentencia para almacenar datos
            guardarCuenta.execute();
        } catch (SQLException ex) {
            System.out.println("Error al Ingresar la Cuenta");
        }
    }
}
