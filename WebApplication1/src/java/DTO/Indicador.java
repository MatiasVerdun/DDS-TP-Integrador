/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.*;
import java.io.Serializable;
import org.mariuszgromada.math.mxparser.Function;
import javax.persistence.*;


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
      
            ValorCuentaDAOInterface valorcuentaDAO = new ValorCuentaDAO();
            IndicadorDAOInterface indicadorDAO = new IndicadorDAO();
            
            Function f = new Function(indicador);
            
            
          for(int i = 0; i < f.getArgumentsNumber(); i++){
              
              if(indicadorDAO.exists(f.getArgument(i).getArgumentName())){
                  f.getArgument(i).setArgumentValue(resultadoFinal(Empresa, Anio));
              }else{
            ValorCuenta valorCuenta = (ValorCuenta) valorcuentaDAO.filter(f.getArgument(i).getArgumentName(), Empresa);
            
            f.getArgument(i).setArgumentValue(valorCuenta.getValor());
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
}
