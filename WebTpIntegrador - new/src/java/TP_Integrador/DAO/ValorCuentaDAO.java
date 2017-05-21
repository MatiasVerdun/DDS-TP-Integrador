/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.DAO;

import TP_Integrador.DTO.ValorCuenta;
import TP_Integrador.MySQL.MySqlHelper;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Matias
 */
public class ValorCuentaDAO {
    public void GuardarValorCuenta(ValorCuenta valorCuenta){
        try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement guardarValorCuenta = conn.prepareStatement("INSERT INTO `valorCuenta` (`codEmpresa`, `Periodo`, `codCuenta`, `Valor`) VALUES (?, ?, ?, ?)");
            guardarValorCuenta.setString(1, valorCuenta.getCodEmpresa());
            guardarValorCuenta.setString(2, valorCuenta.getPeriodo());
            guardarValorCuenta.setString(3, valorCuenta.getCodCuenta());
            guardarValorCuenta.setDouble(4, valorCuenta.getValor());

            //--- Ejecuta la sentencia para almacenar datos
            guardarValorCuenta.execute();
        } catch (SQLException ex) {
            System.out.println("Error al Insertar el Valor de la Cuenta");
        }
    }               
    
      public double conseguirValor(String Cuenta, String Empresa, String Anio){
          double valor = 0;
           try {
         MySqlHelper mySQL = new MySqlHelper();
         Connection conn = mySQL.getConnection();
         
         PreparedStatement cuenta = conn.prepareStatement("SELECT valor FROM valorcuenta WHERE codEmpresa = ? AND periodo = ? AND codCuenta = ?");
            cuenta.setString(1,Empresa);
            cuenta.setString(2,Anio);
            cuenta.setString(3,Cuenta);
            //--- Ejecuta la consulta
            ResultSet rs = cuenta.executeQuery();
            //--- Recorre los registros y los carga en lo que va a devolver de Usar Indicador
            rs.next();
           valor = rs.getInt("valor");
    } catch (SQLException ex) {
            System.out.println("Error al Obtener Valores de Cuentas");
        }
           return valor;
    }
    
    
    
    public ArrayList<ValorCuenta> ObtenerValoresDeCuentas(String codEmpresa, String Periodo){
        ArrayList<ValorCuenta> listaValorCuenta = new ArrayList<ValorCuenta>();
        try {
            //--- Se conecta a la base de datos
            MySqlHelper mySQL = new MySqlHelper();
            Connection conn = mySQL.getConnection();
            
            //--- Prepara la sentencia para validar el Usuario
            PreparedStatement consultaCuentas = conn.prepareStatement("SELECT * FROM valorcuenta where codEmpresa = ? AND periodo= ? ");
            consultaCuentas.setString(1, codEmpresa);
            consultaCuentas.setString(2, Periodo);

            //--- Ejecuta la consulta
            ResultSet rs = consultaCuentas.executeQuery();
            //--- Recorre los registros y los carga en lo que va a devolver de Valores de Cuentas
            while(rs.next())
            {
                ValorCuenta valorCuenta = new ValorCuenta();
                valorCuenta.setCodEmpresa(rs.getString("codEmpresa"));
                valorCuenta.setPeriodo(rs.getString("Periodo"));
                valorCuenta.setCodCuenta(rs.getString("codCuenta"));
                valorCuenta.setValor(rs.getDouble("Valor"));
                
                listaValorCuenta.add(valorCuenta);
            }
        } catch (SQLException ex) {
            System.out.println("Error al Obtener Valores de Cuentas");
        }
        return listaValorCuenta;
    }

}
