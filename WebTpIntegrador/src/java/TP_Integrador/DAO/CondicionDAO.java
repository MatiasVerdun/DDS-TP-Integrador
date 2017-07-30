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
            PreparedStatement guardarCondicion = conn.prepareStatement("INSERT INTO `condiciones` (`metodologia`, `indicador`, `numeroPeriodo`) VALUES (?, ?, ?)"); 
            guardarCondicion.setString(1,  condicion.getMetodologia());
            guardarCondicion.setString(2, condicion.getIndicador());
            guardarCondicion.setString(3, condicion.getNumero());
          
            

            //--- Ejecuta la sentencia para almacenar datos
            guardarCondicion.execute();
        } catch (SQLException ex) {
            System.out.println("Error al Ingresar la Condicion");
        }
    }
       public ArrayList<Condicion> ObtenerCondicion(String metodologia ){
        ArrayList<Condicion> listaCondiciones = new ArrayList<>();
           try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement consultaCondicion = conn.prepareStatement("SELECT * FROM condiciones WHERE (`metodologia`) VALUES (?)"); 
            consultaCondicion.setString(1, metodologia);
            

            ResultSet rs = consultaCondicion.executeQuery();
            //--- Recorre los registros y los carga en lo que va a devolver de Usar Indicador
            
            while(rs.next())
            {
               String tipo = rs.getString("tipo");
              
            if("MayorA".equals(tipo)){
               Condicion MayorA = new Condicion();
               MayorA.setMetodologia(rs.getString("metodologia"));
               MayorA.setIndicador(rs.getString("indicador"));
               MayorA.setNumero(rs.getString("numero"));
               listaCondiciones.add(MayorA);
            }
             if("MenorA".equals(tipo)){
               Condicion MenorA = new Condicion();
               MenorA.setMetodologia(rs.getString("metodologia"));
               MenorA.setIndicador(rs.getString("indicador"));
               MenorA.setNumero(rs.getString("numero"));
               listaCondiciones.add(MenorA);
            } 
             if("Creciente".equals(tipo)){
               Condicion Creciente = new Condicion();
               Creciente.setMetodologia(rs.getString("metodologia"));
               Creciente.setIndicador(rs.getString("indicador"));
               Creciente.setNumero(rs.getString("numero"));
               listaCondiciones.add(Creciente);
            }
              if("Decreciente".equals(tipo)){
               Condicion Decreciente = new Condicion();
               Decreciente.setMetodologia(rs.getString("metodologia"));
               Decreciente.setIndicador(rs.getString("indicador"));
               Decreciente.setNumero(rs.getString("numero"));
               listaCondiciones.add(Decreciente);
            }
              if("Consistente".equals(tipo)){
               Condicion Consistente = new Condicion();
               Consistente.setMetodologia(rs.getString("metodologia"));
               Consistente.setIndicador(rs.getString("indicador"));
               Consistente.setNumero(rs.getString("numero"));
               listaCondiciones.add(Consistente);
            }
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al Ingresar la Condicion");
        }
         return listaCondiciones;
        
       }
}
