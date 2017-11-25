/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;

/**
 *
 * @author Matias
 */
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
    
    public ArrayList<ValorCuenta> filtrarEmpresa(ArrayList<ValorCuenta> valores , String empresa){
        ArrayList<ValorCuenta> valoresAux = new ArrayList();
        valores.forEach(valor -> {
            if(valor.getCodEmpresa().equals(empresa)){
                valoresAux.add(valor);
            }
        } );
    return valoresAux;
    }
    
    public ArrayList<ValorCuenta> filtrarPeriodo(ArrayList<ValorCuenta> valores , String periodo){
        ArrayList<ValorCuenta> valoresAux = new ArrayList();
        valores.forEach(valor -> {
            if(valor.getPeriodo().equals(periodo)){
                valoresAux.add(valor);
            }
        } );
    return valoresAux;
    }
     
     public ArrayList<ValorCuenta> filtrarCuenta(ArrayList<ValorCuenta> valores , String cuenta){
        ArrayList<ValorCuenta> valoresAux = new ArrayList();
        valores.forEach(valor -> {
            if(valor.getCodCuenta().equals(cuenta)){
                valoresAux.add(valor);
            }
        } );
    return valoresAux;
    }
     
      public double obtenerValor(ArrayList<ValorCuenta> valores,String empresa,String cuenta, String periodo){
       ValorCuenta valor = new ValorCuenta();
       ArrayList<ValorCuenta> filterEmpresa=valor.filtrarEmpresa(valores,empresa);
       ArrayList<ValorCuenta> filterCuenta= valor.filtrarCuenta(filterEmpresa, cuenta);
       ArrayList<ValorCuenta> filterPeriodo= valor.filtrarPeriodo(filterCuenta, periodo);
       if(filterPeriodo.isEmpty()){
           System.out.print("Error al conseguir un valor");
          
       }else{ 
           return filterPeriodo.get(0).getValor();
       }
        return 0;
     }
      
       public ArrayList<ValorCuenta> obtenerPeriodosEmpresa(ArrayList<ValorCuenta> valores,String empresa, String periodo){
       ValorCuenta valor = new ValorCuenta();
       ArrayList<ValorCuenta> filterEmpresa=valor.filtrarEmpresa(valores,empresa);
       ArrayList<ValorCuenta> filterPeriodo= valor.filtrarPeriodo(filterEmpresa, periodo);
       return filterPeriodo;
        
          
    }

   
       
       
}
