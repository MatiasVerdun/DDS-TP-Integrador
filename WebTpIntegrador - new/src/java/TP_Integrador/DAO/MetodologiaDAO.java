/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.DAO;

import TP_Integrador.DTO.Cuenta;
import TP_Integrador.DTO.Metodologia;
import TP_Integrador.MySQL.MySqlHelper;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vic
 */
public class MetodologiaDAO {
    /* public boolean validarExistencia(String codigo){
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
    */
        public void GuardarMetodologia(Metodologia metodologia){
        try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement guardarMetodologia = conn.prepareStatement("INSERT INTO `metodologias` `nombreMetodologia` VALUES ?");
            guardarMetodologia.setString(1, metodologia.getNombreMetodologia());       
            
               
            

            //--- Ejecuta la sentencia para almacenar datos
            guardarMetodologia.execute();
        } catch (SQLException ex) {
            System.out.println("Error al Ingresar la Metodologia");
        }
    }
}
