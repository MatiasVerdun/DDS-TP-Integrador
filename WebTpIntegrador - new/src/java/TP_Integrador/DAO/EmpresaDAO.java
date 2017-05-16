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
                empresa.setDescripcion(rs.getString("Descripcion"));
                
                listaEmpresas.add(empresa);
            }
        } catch (SQLException ex) {
            System.out.println("Error al Obtener Empresas");
        }
        return listaEmpresas;
    }
    
}
