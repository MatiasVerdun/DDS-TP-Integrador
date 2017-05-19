/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.DAO;

import TP_Integrador.DTO.Indicador;
import TP_Integrador.MySQL.MySqlHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class IndicadorDAO {
    public void GuardarIndicador(Indicador indicador){
        try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement guardarIndicador = conn.prepareStatement("INSERT INTO `indicadores` (`nombreIndicador`, `indicador`) VALUES (?, ?)");
            guardarIndicador.setString(1, indicador.getNombre());
            guardarIndicador.setString(2, indicador.getIndicador());
          
            

            //--- Ejecuta la sentencia para almacenar datos
            guardarIndicador.execute();
        } catch (SQLException ex) {
            System.out.println("Error al Ingresar el Indicador");
        }
       
    }
    
    public ArrayList<Indicador> ObtenerIndicadores(){
        ArrayList<Indicador> listaIndicadores = new ArrayList<Indicador>();
        try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement consultaEmpresas = conn.prepareStatement("SELECT * FROM indicadores");

            //--- Ejecuta la consulta
            ResultSet rs = consultaEmpresas.executeQuery();
            //--- Recorre los registros y los carga en lo que va a devolver de Usar Indicador
            while(rs.next())
            {
                Indicador indicador = new Indicador();
                indicador.setNombre(rs.getString("nombreIndicador"));
                indicador.setIndicador(rs.getString("indicador"));
                
                listaIndicadores.add(indicador);
            }
        } catch (SQLException ex) {
            System.out.println("Error al Obtener Indicadores");
        }
        return listaIndicadores;
    }

  

   

}