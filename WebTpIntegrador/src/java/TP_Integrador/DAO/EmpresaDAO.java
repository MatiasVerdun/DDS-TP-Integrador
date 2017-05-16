
package TP_Integrador.DAO;

import TP_Integrador.DTO.Empresa;
import TP_Integrador.MySQL.MySqlHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
                this.crearObjetoEmpresa(codigo);
            }
        } catch (SQLException ex) {
            System.out.println("Error al validar empresa ");
        }
        return existe;
    }   
    
     public void crearObjetoEmpresa(String  codigo){
         Empresa empresa = new Empresa();
         empresa.setCodEmpresa(codigo);
     
     }
}
