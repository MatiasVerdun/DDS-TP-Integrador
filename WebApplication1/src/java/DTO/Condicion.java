/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="Condiciones")
public class Condicion implements Serializable{

    public Condicion(String numero, String indicador) {
        this.monto = numero;
        this.indicador = indicador;
    }

    public Condicion() {
    }
    
    @Column(name="metodologia")
    private String metodologia;
    
    @Column(name="monto")
    private String monto;
    
    @Column(name="indicador")
    String indicador;
    
    @Id
    @Column(name="tipo")
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

  
    public String getMonto() {
        return monto;
    }

    public void setMonto(String numero) {
        this.monto = numero;
    }
    
    public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        
         return true;
    }

    
}









