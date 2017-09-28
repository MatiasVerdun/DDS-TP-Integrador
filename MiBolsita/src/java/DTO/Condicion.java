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
public  class Condicion implements Serializable,CondicionInterface{
    

    public Condicion() {
    }
  
    @Id
    @Column(name="id")
    @GeneratedValue( generator = "generador_propietario_hibernate_increment")
    @org.hibernate.annotations.GenericGenerator(name = "generador_propietario_hibernate_increment", strategy = "increment")
    private int id;

  
    
    @Column(name="metodologia")
    private String metodologia;
    
    
    @Column(name="monto")
    private String monto;
    
    
    @Column(name="indicador")
    String indicador;
   
    
    @Column(name="tipo")
    private String tipo;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
  
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

    @Override
    public Boolean pasaCondicion(Empresa empresa, int anioDesde, int anioHasta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}









