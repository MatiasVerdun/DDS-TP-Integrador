/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.DAO;

import TP_Integrador.DTO.*;
import TP_Integrador.MySQL.MySqlHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
            PreparedStatement guardarCondicion = conn.prepareStatement("INSERT INTO `condiciones` (`metodologia`, `indicador`, `numeroPeriodo`, `tipo`) VALUES (?, ?, ?, ?)"); 
            guardarCondicion.setString(1,  condicion.getMetodologia());
            guardarCondicion.setString(2, condicion.getIndicador());
            guardarCondicion.setString(3, condicion.getNumero());
            guardarCondicion.setString(4, condicion.getTipo());

            //--- Ejecuta la sentencia para almacenar datos
            guardarCondicion.execute();
        } catch (SQLException ex) {
            System.out.println("Error al Ingresar la Condicion");
        }
    }
       public ArrayList<Condicion> ObtenerCondiciones(String metodologia ){
        ArrayList<Condicion> listaCondiciones = new ArrayList<>();
           try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement consultaCondicion = conn.prepareStatement("SELECT * FROM condiciones WHERE metodologia = ?"); 
            consultaCondicion.setString(1, metodologia);
            

            ResultSet rs = consultaCondicion.executeQuery();
            //--- Recorre los registros y los carga en lo que va a devolver de Usar Indicador
            
            while(rs.next()){
            switch (rs.getString("tipo")) {
                       case "menorA":
                           listaCondiciones.add(new MenorA(rs.getString("numeroPeriodo"),rs.getString("indicador")));
                           break;
                       case "mayorA":
                           listaCondiciones.add(new MayorA(rs.getString("numeroPeriodo"),rs.getString("indicador")));
                           break;
                       case "consistente":
                           listaCondiciones.add(new Consistente(rs.getString("numeroPeriodo"),rs.getString("indicador")));
                           break;
                       case "creciente":
                           listaCondiciones.add(new Creciente(rs.getString("numeroPeriodo"),rs.getString("indicador")));
                           break;
                       case "decreciente":
                           listaCondiciones.add(new Decreciente(rs.getString("numeroPeriodo"),rs.getString("indicador")));
                           break;
                   }
            }
<<<<<<< HEAD
=======
           
>>>>>>> 3db3154cc642b717b273f81db77a7560b9bc15cc
            
        } catch (SQLException ex) {
            System.out.println("Error al Ingresar la Condicion");
        }
         return listaCondiciones;
        
       }
}
