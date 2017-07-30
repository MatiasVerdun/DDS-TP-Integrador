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
               MayorA mayorA = new MayorA();
               mayorA.setMetodologia(rs.getString("metodologia"));
               mayorA.setIndicador(rs.getString("indicador"));
               mayorA.setNumero(rs.getString("numero"));
               listaCondiciones.add(mayorA);
            }
             if("MenorA".equals(tipo)){
               MenorA menorA = new MenorA();
               menorA.setMetodologia(rs.getString("metodologia"));
               menorA.setIndicador(rs.getString("indicador"));
               menorA.setNumero(rs.getString("numero"));
               listaCondiciones.add(menorA);
            } 
             if("Creciente".equals(tipo)){
               Creciente creciente = new Creciente();
               creciente.setMetodologia(rs.getString("metodologia"));
               creciente.setIndicador(rs.getString("indicador"));
               creciente.setNumero(rs.getString("numero"));
               listaCondiciones.add(creciente);
            }
              if("Decreciente".equals(tipo)){
               Decreciente decreciente = new Decreciente();
               decreciente.setMetodologia(rs.getString("metodologia"));
               decreciente.setIndicador(rs.getString("indicador"));
               decreciente.setNumero(rs.getString("numero"));
               listaCondiciones.add(decreciente);
            }
              if("Consistente".equals(tipo)){
               Consistente consistente = new Consistente();
               consistente.setMetodologia(rs.getString("metodologia"));
               consistente.setIndicador(rs.getString("indicador"));
               consistente.setNumero(rs.getString("numero"));
               listaCondiciones.add(consistente);
            }
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al Ingresar la Condicion");
        }
         return listaCondiciones;
        
       }
}
