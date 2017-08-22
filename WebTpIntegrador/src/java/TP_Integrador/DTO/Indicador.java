/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.DTO;

import TP_Integrador.DAO.*;
import org.mariuszgromada.math.mxparser.Function;


public class Indicador {
    private String nombre;
    private String indicador;

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
              
              if(indicadorDAO.esIndicador(f.getArgument(i).getArgumentName())){
                  f.getArgument(i).setArgumentValue(resultadoFinal(Empresa, Anio));
              }else{
            double valor = valorcuentaDAO.conseguirValor(f.getArgument(i).getArgumentName(), Empresa, Anio);
            f.getArgument(i).setArgumentValue(valor);
              }
          }
          double resultadoFinal = f.calculate();
          return resultadoFinal;
   

}
    
}
