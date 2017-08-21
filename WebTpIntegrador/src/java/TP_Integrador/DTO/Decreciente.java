package TP_Integrador.DTO;
import TP_Integrador.DTO.Indicador;


public class Decreciente extends Condicion{
     public Decreciente(String numero, String indicador) {
        super(numero, indicador);
    } 
    @Override
     public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        Indicador indicador = new Indicador();
        indicador.setIndicador(this.indicador);
        
        boolean pasa = true;
        double resultadoInicial = indicador.resultadoFinal( empresa.getNombreEmpresa(),Integer.toString(anioDesde));
        
        int i = anioDesde++;
        while(i <= anioHasta){
        double resultadoAComparar = indicador.resultadoFinal(empresa.getNombreEmpresa(),Integer.toString(i));
        if(resultadoAComparar > resultadoInicial ){
            pasa = false;
            resultadoInicial = resultadoAComparar;
        }
        i++;
        }
      return pasa;
    }
}
