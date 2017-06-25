/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.DAO;

import TP_Integrador.DTO.Condicion;
import TP_Integrador.MySQL.MySqlHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Vic
 */
public class CondicionDAO {
     public void GuardarCondicion(Condicion condicion){
        try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement guardarCondicion = conn.prepareStatement("INSERT INTO `condiciones` (`metodologia`, `indicador`, `numeroPeriodo`) VALUES (?, ?, ?)"); 
            guardarCondicion.setString(1,  condicion.getMetodologia());
            guardarCondicion.setString(2, condicion.getIndicador());
            guardarCondicion.setInt(3, condicion.getNumero());
          
            

            //--- Ejecuta la sentencia para almacenar datos
            guardarCondicion.execute();
        } catch (SQLException ex) {
            System.out.println("Error al Ingresar la Condicion");
        }
    }
}
