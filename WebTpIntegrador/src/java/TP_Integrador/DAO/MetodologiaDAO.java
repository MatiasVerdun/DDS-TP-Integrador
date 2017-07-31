/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.DAO;

import TP_Integrador.DTO.*;
import TP_Integrador.MySQL.MySqlHelper;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public ArrayList<Metodologia> ObtenerMetodologias(){
        ArrayList<Metodologia> listaMetodologias = new ArrayList<Metodologia>();
        try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement consultaMetodologias = conn.prepareStatement("SELECT * FROM metodologias");

            //--- Ejecuta la consulta
            ResultSet rs = consultaMetodologias.executeQuery();
            //--- Recorre los registros y los carga en lo que va a devolver de Usar Indicador
            while(rs.next())
            {
                Metodologia metodologia = new Metodologia();
                metodologia.setNombreMetodologia(rs.getString("nombreMetodologia"));
                
                listaMetodologias.add(metodologia);
            }
        } catch (SQLException ex) {
            System.out.println("Error al Obtener Metodologias");
        }
        return listaMetodologias;
    }
    
        public void GuardarMetodologia(Metodologia metodologia){
        try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement guardarMetodologia = conn.prepareStatement("INSERT INTO `metodologias` (`nombreMetodologia`) VALUES (?)");
            guardarMetodologia.setString(1, metodologia.getNombreMetodologia());       

            //--- Ejecuta la sentencia para almacenar datos
            guardarMetodologia.execute();
        } catch (SQLException ex) {
            System.out.println("Error al Ingresar la Metodologia");
        }
    }
        
       public Metodologia ObtenerMetodologiaConCondiciones(String metodologia){
           Metodologia meto = new Metodologia();
           meto.setNombreMetodologia(metodologia);
           CondicionDAO condicionDAO = new CondicionDAO();
           meto.addCondiciones(condicionDAO.ObtenerCondiciones(metodologia));
           return meto;
       }
}
