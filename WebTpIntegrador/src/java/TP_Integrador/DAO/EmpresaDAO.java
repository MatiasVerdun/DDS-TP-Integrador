/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.DAO;

import TP_Integrador.DTO.Empresa;
import TP_Integrador.MySQL.MySqlHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Matias
 */
public class EmpresaDAO {
    public boolean validarExistencia(String codigo){
        Boolean existe=false;
        try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement consultaUsuario = conn.prepareStatement("SELECT * FROM empresa where codEmpresa = ?   ");
            consultaUsuario.setString(1,codigo);
            
            //--- Ejecuta la consulta
            ResultSet rs = consultaUsuario.executeQuery();
            //--- Verifica si pudo obtener al Usuuario
            if(rs.next())   {
                existe=true;
               
            }
        } catch (SQLException ex) {
            System.out.println("Error al validar empresa ");
        }
        return existe;
    }   
    public void GuardarEmpresa(Empresa empresa){
        try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement guardarIndicador = conn.prepareStatement("INSERT INTO `empresa` (`codEmpresa`, `nombreEmpresa`) VALUES (?, ?)");
            guardarIndicador.setString(1, empresa.getCodEmpresa());
            guardarIndicador.setString(2, empresa.getNombreEmpresa());
          
            

            //--- Ejecuta la sentencia para almacenar datos
            guardarIndicador.execute();
        } catch (SQLException ex) {
            System.out.println("Error al Ingresar la Empresa");
        }
    }
    
    public ArrayList<Empresa> ObtenerEmpresas(){
        ArrayList<Empresa> listaEmpresas = new ArrayList<Empresa>();
        try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement consultaEmpresas = conn.prepareStatement("SELECT * FROM empresa");

            //--- Ejecuta la consulta
            ResultSet rs = consultaEmpresas.executeQuery();
            //--- Recorre los registros y los carga en lo que va a devolver de Valores de Cuentas
            while(rs.next())
            {
                Empresa empresa = new Empresa();
                empresa.setCodEmpresa(rs.getString("codEmpresa"));
                empresa.setNombreEmpresa(rs.getString("nombreEmpresa"));
                
                listaEmpresas.add(empresa);
            }
        } catch (SQLException ex) {
            System.out.println("Error al Obtener Empresas");
        }
        return listaEmpresas;
    }
    
    public Empresa ObtenerEmpresa(String empresa){
       Empresa objEmpresa = new Empresa();
        try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement consultaEmpresa = conn.prepareStatement("SELECT * FROM empresa WHERE nombreEmpresa = ?");
            consultaEmpresa.setString(1, empresa);
            //--- Ejecuta la consulta
            ResultSet rs = consultaEmpresa.executeQuery();
            rs.next();
               
                objEmpresa.setCodEmpresa(rs.getString("codEmpresa"));
                objEmpresa.setNombreEmpresa(rs.getString("nombreEmpresa"));
                
              
        } catch (SQLException ex) {
            System.out.println("Error al Obtener Empresas");
        }
        return objEmpresa;
    }
    
    
}
