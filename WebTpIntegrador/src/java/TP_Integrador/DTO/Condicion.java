/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.DTO;

import TP_Integrador.DAO.IndicadorDAO;
import static java.lang.Math.abs;
/**
 *
 * @author Vic
 */
public class Condicion {
    private String metodologia;
    private String numero;
    private String indicador;
    public Boolean pasa = true;
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

  
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        
         return pasa;
    }

    
}









