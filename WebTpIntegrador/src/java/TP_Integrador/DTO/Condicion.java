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

class MenorA extends Condicion {
    
    @Override
    public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        
        IndicadorDAO indicadorDAO = new IndicadorDAO();
        int i = anioDesde;
        while(i <= anioHasta){
        double resultado = indicadorDAO.resultadoFinal(this.getIndicador(), empresa.getNombreEmpresa(),Integer.toString(i));
        if(resultado >= Integer.parseInt(this.getNumero()) ){
            pasa = false;
        }
        i++;
        }
      return pasa;
    }
    
}

class MayorA extends Condicion{
    @Override
    public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        
        IndicadorDAO indicadorDAO = new IndicadorDAO();
        int i = anioDesde;
        while(i <= anioHasta){
        double resultado = indicadorDAO.resultadoFinal(this.getIndicador(), empresa.getNombreEmpresa(),Integer.toString(i));
        if(resultado <= Integer.parseInt(this.getNumero()) ){
            pasa = false;
        }
        i++;
        }
      return pasa;
    }
}

class Creciente extends Condicion{
    public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        IndicadorDAO indicadorDAO = new IndicadorDAO();
        double resultadoInicial = indicadorDAO.resultadoFinal(this.getIndicador(), empresa.getNombreEmpresa(),Integer.toString(anioDesde));
        
        int i = anioDesde++;
        while(i <= anioHasta){
        double resultadoAComparar = indicadorDAO.resultadoFinal(this.getIndicador(), empresa.getNombreEmpresa(),Integer.toString(i));
        if(resultadoAComparar < resultadoInicial ){
            pasa = false;
            resultadoInicial = resultadoAComparar;
        }
        i++;
        }
      return pasa;
    }
}

class Decreciente extends Condicion{
     @Override
     public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        IndicadorDAO indicadorDAO = new IndicadorDAO();
        double resultadoInicial = indicadorDAO.resultadoFinal(this.getIndicador(), empresa.getNombreEmpresa(),Integer.toString(anioDesde));
        
        int i = anioDesde++;
        while(i <= anioHasta){
        double resultadoAComparar = indicadorDAO.resultadoFinal(this.getIndicador(), empresa.getNombreEmpresa(),Integer.toString(i));
        if(resultadoAComparar > resultadoInicial ){
            pasa = false;
            resultadoInicial = resultadoAComparar;
        }
        i++;
        }
      return pasa;
    }
}

class Consistente extends Condicion{
     @Override
     public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        IndicadorDAO indicadorDAO = new IndicadorDAO();
        double resultadoInicial = indicadorDAO.resultadoFinal(this.getIndicador(), empresa.getNombreEmpresa(),Integer.toString(anioDesde));
        
        int i = anioDesde++;
        while(i <= anioHasta){
        double resultadoAComparar = indicadorDAO.resultadoFinal(this.getIndicador(), empresa.getNombreEmpresa(),Integer.toString(i));
        if( abs(resultadoAComparar - resultadoInicial)  < resultadoAComparar * 0.05 ){
            pasa = false;
            resultadoInicial = resultadoAComparar;
        }
        i++;
        }
      return pasa;
    }
    
}
