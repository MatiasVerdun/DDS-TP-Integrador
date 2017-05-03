/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.MySQL;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySqlHelper {
    private static Connection conn;
   

    
     public MySqlHelper() throws SQLException {
        conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/DDS-TP-Integrador", "root", "");
            if (conn != null){
                System.out.println("Conexion establecida..");
            }
        } catch(ClassNotFoundException | SQLException e){
          System.out.println("Error al conectar" + e);
            
        }
    }
     
     public Connection getConnection(){
         return conn;
     }
     
     public void desconectar() {
         conn = null;
         if(conn == null){
           System.out.println("Conexion terminada..");
         }   
         
     }
}
       