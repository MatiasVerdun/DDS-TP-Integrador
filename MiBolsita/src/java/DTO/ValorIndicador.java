/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.IndicadorDAO;
import DAO.ValorCuentaDAO;
import DAO.ValorIndicadorDAO;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Matias
 */
@Entity
@Table(name="ValorIndicador")
public class ValorIndicador {
    
    @Column(name="codEmpresa")
    private String CodEmpresa;
     @Column(name="periodo")
    private String Periodo;
      @Column(name="nombreIndicador")
    private String NombreIndicador;
     @Column(name="valor")
    private double Valor;
     @Column(name="id_usuario")
    private String id_usuario;
    @Id
    @Column(name="id")
    @GeneratedValue( generator = "generador_propietario_hibernate_increment")
    @org.hibernate.annotations.GenericGenerator(name = "generador_propietario_hibernate_increment", strategy = "increment")
    private int id;

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
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

    public String getNombreIndicador() {
        return NombreIndicador;
    }

    public void setNombreIndicador(String CodCuenta) {
        this.NombreIndicador = CodCuenta;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public void generarValores() {
       
       IndicadorDAO indicadorDAO = new IndicadorDAO();
       Indicador indicador = indicadorDAO.filter(NombreIndicador);
        ValorCuentaDAO valorCuentaDAO = new ValorCuentaDAO();
        ValorIndicadorDAO valorIndicadorDAO = new ValorIndicadorDAO();
       //Obtiene todos los valoresCuenta
        ArrayList<ValorCuenta> valorCuenta = (ArrayList<ValorCuenta>) valorCuentaDAO.filter();
        
        valorCuenta.forEach((unValorCuenta) -> {
                setCodEmpresa(unValorCuenta.getCodEmpresa());
                setPeriodo(unValorCuenta.getPeriodo());
                double resultado = indicador.resultadoFinal(unValorCuenta.getCodEmpresa(), unValorCuenta.getPeriodo());
                setValor(resultado);
                valorIndicadorDAO.saveOrUpdate(this);
        });
       
        
    }
    
    
    
        
    public ArrayList<ValorIndicador> filtrarEmpresa(ArrayList<ValorIndicador> valores , String empresa){
        ArrayList<ValorIndicador> valoresAux = new ArrayList();
        valores.forEach(valor -> {
            if(valor.getCodEmpresa().equals(empresa)){
                valoresAux.add(valor);
            }
        } );
    return valoresAux;
    }
    
    public ArrayList<ValorIndicador> filtrarPeriodo(ArrayList<ValorIndicador> valores , String periodo){
        ArrayList<ValorIndicador> valoresAux = new ArrayList();
        valores.forEach(valor -> {
            if(valor.getPeriodo().equals(periodo)){
                valoresAux.add(valor);
            }
        } );
    return valoresAux;
    }
     
     public ArrayList<ValorIndicador> filtrarIndicador(ArrayList<ValorIndicador> valores , String cuenta){
        ArrayList<ValorIndicador> valoresAux = new ArrayList();
        valores.forEach(valor -> {
            if(valor.getNombreIndicador().equals(cuenta)){
                valoresAux.add(valor);
            }
        } );
    return valoresAux;
    }
     
      public double obtenerValor(ArrayList<ValorIndicador> valores,String empresa,String indicador, String periodo){
       ValorIndicador valor = new ValorIndicador();
       ArrayList<ValorIndicador> filterEmpresa=valor.filtrarEmpresa(valores,empresa);
       ArrayList<ValorIndicador> filterCuenta= valor.filtrarIndicador(filterEmpresa, indicador);
       ArrayList<ValorIndicador> filterPeriodo= valor.filtrarPeriodo(filterCuenta, periodo);
       if(filterPeriodo.isEmpty()){
           System.out.print("Error al conseguir un valor");
          
       }else{ 
           return filterPeriodo.get(0).getValor();
       }
        return 0;
     }

    
     

}
