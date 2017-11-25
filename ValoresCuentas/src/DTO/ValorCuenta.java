/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.CuentaDAO;
import DAO.EmpresaDAO;
import DAO.ValorCuentaDAO;
import java.io.Serializable;
import javax.persistence.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



@Entity
@Table(name="ValorCuenta")
public class ValorCuenta  implements Serializable{
  
    
    
    @Id
    @Column(name="id")
    @GeneratedValue( generator = "generador_propietario_hibernate_increment")
    @org.hibernate.annotations.GenericGenerator(name = "generador_propietario_hibernate_increment", strategy = "increment")
    private int id;

    
    
    @Column(name="codEmpresa")
    private String CodEmpresa;
    
    @Column(name="periodo")
    private String Periodo;
 
    
    @Column(name="codCuenta")
    private String CodCuenta;
    
    @Column(name="valor")
    private double Valor;

    public ValorCuenta() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getCodEmpresa() {
        return CodEmpresa;
    }

    public void setCodEmpresa(String CodEmpresa) {
        this.CodEmpresa = CodEmpresa;
    }

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
    }

    public String getCodCuenta() {
        return CodCuenta;
    }

    public void setCodCuenta(String CodCuenta) {
        this.CodCuenta = CodCuenta;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }
    
    
    
    public  static  void main(String[] args) throws IOException{
    
     File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

         archivo = new File ("C:\\ValoresCuentas.txt");
         fr = new FileReader(archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
        String linea;
        while((linea=br.readLine())!=null){
                String[] arreglo_datos = linea.split(",");
                ValorCuenta valorCuentaLinea = new ValorCuenta();
                EmpresaDAO empresa = new EmpresaDAO();
                CuentaDAO cuenta = new CuentaDAO();
                
                String codigoEmpresa = arreglo_datos[0];
                String codigoCuenta = arreglo_datos[2];
                
                valorCuentaLinea.setCodEmpresa(codigoEmpresa);
                valorCuentaLinea.setPeriodo(arreglo_datos[1]);  
                valorCuentaLinea.setCodCuenta(codigoCuenta);
                valorCuentaLinea.setValor(Double.parseDouble(arreglo_datos[3]));

                if(empresa.exists(codigoEmpresa) && cuenta.exists(codigoCuenta) ){
                ValorCuentaDAO valorCuenta = new ValorCuentaDAO();
                valorCuenta.saveOrUpdate(valorCuentaLinea);
                } 
                linea=br.readLine();
          }
        fr.close(); 
    }
    
       
}
