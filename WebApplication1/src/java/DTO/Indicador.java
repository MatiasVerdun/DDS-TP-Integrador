/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.*;
import java.io.Serializable;
import java.util.ArrayList;
import org.mariuszgromada.math.mxparser.Function;
import javax.persistence.*;
import org.mariuszgromada.math.mxparser.Argument;


@Entity
@Table(name="Indicadores")
public class Indicador  implements Serializable {
    @Id
    @Column(name="nombreIndicador")
    private String nombre;
    @Column(name="indicador")
    private String indicador;

    public Indicador() {
    }
    
    
    
    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    

   public double resultadoFinal(String Empresa, String Anio){
      
            ValorCuentaDAO valorcuentaDAO = new ValorCuentaDAO();
            IndicadorDAO indicadorDAO = new IndicadorDAO();
            
            Function f = new Function(indicador);
            
            
          for(int i = 0; i < f.getArgumentsNumber(); i++){
                Argument argumentoActual = f.getArgument(i);
              if(indicadorDAO.exists(argumentoActual.getArgumentName())){
                 argumentoActual.setArgumentValue(resultadoFinal(Empresa, Anio));
              }else{
                double valor = valorcuentaDAO.filterValor(argumentoActual.getArgumentName(), Empresa, Anio);
                argumentoActual.setArgumentValue(valor);
              }
          }
          double resultadoFinal = f.calculate();
          return resultadoFinal;
   

}
    
     public boolean comprobarSintaxis(){
            
            Function f = new Function(indicador);
            
            f.checkSyntax();
            String subStr = f.getErrorMessage().substring(f.getErrorMessage().length() - 11);
            
            
            return (subStr.equals("no errors.\n"));
    }

    public ArrayList<ValorIndicador> ObtenerValoresIndicadores(String strCodEmpresa, String strPeriodo) {
        IndicadorDAO indicadorDAO = new IndicadorDAO();
        ArrayList<Indicador> indicadores = (ArrayList<Indicador>) indicadorDAO.findAll();
        ArrayList<ValorIndicador> valores = new  ArrayList<>();
        for(int i=0;i<indicadores.size();i++){
        ValorIndicador valorIndicador = new ValorIndicador();
                valorIndicador.setCodEmpresa(strCodEmpresa);
                valorIndicador.setPeriodo(strPeriodo);
                valorIndicador.setNombreIndicador(indicadores.get(i).getNombre());
                valorIndicador.setValor(indicadores.get(i).resultadoFinal(strCodEmpresa, strPeriodo));
        valores.add(valorIndicador);
        }

      return valores;
    }
}
